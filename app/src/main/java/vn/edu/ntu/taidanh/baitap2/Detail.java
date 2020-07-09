package vn.edu.ntu.taidanh.baitap2;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import vn.edu.ntu.taidanh.baitap2.controller.IDanhBa;
import vn.edu.ntu.taidanh.baitap2.model.ThongTin;

public class Detail extends AppCompatActivity implements View.OnClickListener {
    EditText edtTen, edtNgaySinh, edtSDT, edtDiaChi;
    Button btnLuu;
    public static final String keyTen = "ten";
    public static final String keyNgay = "ngay";
    public static final String keyPhoe = "phone";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        addView();
    }
    public void addView(){
        edtTen  = findViewById(R.id.edtTen);
        edtNgaySinh = findViewById(R.id.edtNgaySinh);
        edtDiaChi = findViewById(R.id.edtDiaChi);
        edtSDT = findViewById(R.id.edtSDT);
        btnLuu = findViewById(R.id.btnLuu);
        btnLuu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.btnLuu: Save();
        }
    }
    public void Save(){
        Intent intent = new Intent(this, MainActivity.class);
        String ten = edtTen.getText().toString();
        String ngay = edtNgaySinh.getText().toString();
        String phone = edtSDT.getText().toString();
        intent.putExtra(keyTen, ten);
        intent.putExtra(keyNgay, ngay);
        intent.putExtra(keyPhoe, phone);
        startActivity(intent);
    }
}
