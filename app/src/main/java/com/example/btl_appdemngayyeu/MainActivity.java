package com.example.btl_appdemngayyeu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnTinh;
    EditText edtNgay1, edtNgay2;
    TextView txtKetQua;
    Calendar calendarOne, calendarTwo;
    SimpleDateFormat simpleDateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        edtNgay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChonNgay1();
            }
        });
        edtNgay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChonNgay2();
            }
        });

        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ngayYeuNhau = (int) ((calendarTwo.getTimeInMillis() - calendarOne.getTimeInMillis()) / (1000*60*60*24));

                if (ngayYeuNhau < 0){
                    Toast.makeText(MainActivity.this, "Vui long chon ngay thu 2 sau ngay thu 1",Toast.LENGTH_SHORT).show();

                }else {
                    txtKetQua.setText("so ngay yeu nhau la: " + ngayYeuNhau);
                }
                txtKetQua.setText("So ngay yeu nhau la: " + ngayYeuNhau);
            }
        });
    }

    private void ChonNgay1(){
        calendarOne = Calendar.getInstance();
        int ngay = calendarOne.get(Calendar.DATE);
        int thang = calendarOne.get(Calendar.MONTH);
        int nam = calendarOne.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        calendarOne.set(i, i1, i2);
                        edtNgay1.setText(simpleDateFormat.format(calendarOne.getTime()));
                    }
                }, nam,thang    ,ngay);
        datePickerDialog.show();
    }
    private void ChonNgay2(){
        calendarTwo = Calendar.getInstance();
        int ngay = calendarTwo.get(Calendar.DATE);
        int thang = calendarTwo.get(Calendar.MONTH);
        int nam = calendarTwo.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        calendarTwo.set(i, i1, i2);
                        edtNgay2.setText(simpleDateFormat.format(calendarTwo.getTime()));
                    }
                }, nam,thang    ,ngay);
        datePickerDialog.show();
    }

    private void AnhXa(){
        btnTinh = (Button) findViewById(R.id.buttonTinh);
        edtNgay1 = (EditText) findViewById(R.id.editTextDateOne);
        edtNgay2 = (EditText) findViewById(R.id.editTextDateTwo);
        txtKetQua = (TextView) findViewById(R.id.textViewResult);

    }
}