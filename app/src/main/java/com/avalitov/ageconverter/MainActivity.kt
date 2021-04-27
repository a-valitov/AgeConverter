package com.avalitov.ageconverter

import android.app.DatePickerDialog;
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi

import java.util.Calendar

class MainActivity : AppCompatActivity() {

    lateinit var datePickerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        datePickerButton = findViewById(R.id.btnDatePicker)

        datePickerButton.setOnClickListener() { view ->
            clickDatePicker(view)
            Toast.makeText(this, "Button works", Toast.LENGTH_LONG).show()
        }

    }

    fun clickDatePicker(view: View) {

        val calendar = Calendar.getInstance()
        //calendar.firstDayOfWeek = Calendar.MONDAY

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDlg = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

                }
                ,year
                ,month
                ,day);
        datePickerDlg.datePicker.firstDayOfWeek = Calendar.MONDAY;
        datePickerDlg.show();

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