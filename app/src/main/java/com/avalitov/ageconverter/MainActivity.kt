package com.avalitov.ageconverter

import android.app.DatePickerDialog;
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var datePickerButton: Button
    lateinit var tvSelectedDate: TextView
    lateinit var tvSelectedDateInMinutes: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        datePickerButton = findViewById(R.id.btnDatePicker)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        tvSelectedDateInMinutes = findViewById(R.id.tvSelectedDateInMinutes)

        datePickerButton.setOnClickListener() { view ->
            clickDatePicker(view)
            Toast.makeText(this, "Button works", Toast.LENGTH_LONG).show()
        }

    }

    fun clickDatePicker(view: View) {

        //getting current date to offer it as a default
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDlg = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDayOfMonth ->
                    Toast.makeText(this, "The chosen year is $selectedYear, the month is $selectedMonth and the day is $selectedDayOfMonth",
                            Toast.LENGTH_LONG).show()

                    val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
                    tvSelectedDate.text = selectedDate

                    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                    //creating a Date object
                    val theDate = sdf.parse(selectedDate)

                    val selectedDateInMinutes = theDate!!.time / 1000 / 60
                    //tvSelectedDate.text = selectedDateInMinutes.toString()

                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                    val currentDateInMinutes = currentDate!!.time / 1000 / 60

                    val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes

                    tvSelectedDateInMinutes.text = differenceInMinutes.toString()

                }
                ,year
                ,month
                ,day);

        //datePickerDlg.datePicker.firstDayOfWeek = Calendar.MONDAY
        datePickerDlg.datePicker.maxDate = Date().time - (24 * 60 * 60 * 1000) // setting maximum date to yesterday
        datePickerDlg.show()

//        DatePickerDialog(this,
//             DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
//
//         }
//         ,year
//         ,month
//         ,day).show()
//
//        datePickerDialog.getDatePicker().setFirstDayOfWeek(Calendar.MONDAY)


    }


}