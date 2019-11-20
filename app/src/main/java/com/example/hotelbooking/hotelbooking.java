package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


public class hotelbooking extends AppCompatActivity {

    Spinner Spinner, Spinner2;
    TextView Checkindate, Checkoutdate, tvresult;
    EditText etadult, etchildren, etroom;
    Button btncalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotelbooking);
        bindProperties();
    }

    public void bindProperties() {
        Spinner = findViewById(R.id.Spinner);
        Spinner2 = findViewById(R.id.Spinner2);
        Checkindate = findViewById(R.id.Checkindate);
        Checkoutdate = findViewById(R.id.Checkoutdate);
        etadult = findViewById(R.id.etadult);
        etchildren = findViewById(R.id.etchildren);
        etroom = findViewById(R.id.etroom);
        btncalculate = findViewById(R.id.btncalculate);
        tvresult = findViewById(R.id.tvresult);

        //Spinner
        String Country[] = {"Kathmandu", "Chitwan", "Bhaktapur"};
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Country);
        Spinner.setAdapter(adapter);

        String Room[] = {"Delux", "AC", "Platinum"};
        ArrayAdapter adapterRoom = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Room);
        Spinner2.setAdapter(adapterRoom);

        Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(hotelbooking.this, Spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(hotelbooking.this, Spinner2.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Checkindate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePickerCheckIn();
            }
        });

        Checkoutdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePickerCheckOut();
            }
        });
        //ButtonCalculate
        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adult, children, room, result, vat, charge;
                adult = Integer.parseInt(etadult.getText().toString());
                children = Integer.parseInt(etchildren.getText().toString());
                room = Integer.parseInt(etroom.getText().toString());

            }
        });
    }

    //DatePicker
    private void loadDatePickerCheckIn() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date = "Year/Month/Day:" + year + "/" + month + "/" + dayOfMonth;
                Checkindate.setText(date);
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    private void loadDatePickerCheckOut() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog1 = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date1 = "Year/Month/Day:" + year + "/" + month + "/" + dayOfMonth;
                Checkoutdate.setText(date1);
            }
        }, year, month, day);
        datePickerDialog1.show();
    }

}
