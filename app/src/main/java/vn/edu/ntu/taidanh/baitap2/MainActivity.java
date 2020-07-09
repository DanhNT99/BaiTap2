package vn.edu.ntu.taidanh.baitap2;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.ntu.taidanh.baitap2.controller.IDanhBa;
import vn.edu.ntu.taidanh.baitap2.model.ThongTin;

public class MainActivity extends AppCompatActivity {
    RecyclerView lvThongTin;
    ThongTinAdapter adapterThongTin;
    List<ThongTin> listThongTin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();


    }

    @Override
    protected void onResume() {
        super.onResume();
        nhan();
    }

    public void addView(){
        lvThongTin = findViewById(R.id.lvThongTin);
        lvThongTin.setLayoutManager(new LinearLayoutManager(this));
        IDanhBa controller = (IDanhBa) getApplication();
        listThongTin = controller.getAllThongTin();
        adapterThongTin = new ThongTinAdapter();
        lvThongTin.setAdapter(adapterThongTin);
    }
    //trước tiên là tạo view holder và lớp adapter
    private class ThongTinViewholder extends RecyclerView.ViewHolder {
        TextView txtTen, txtNgay, txtSDT;
        ThongTin t;

        public ThongTinViewholder(@NonNull View itemView) {
            super(itemView);
            txtTen = itemView.findViewById(R.id.txtTen);
            txtNgay = itemView.findViewById(R.id.txtNgay);
            txtSDT = itemView.findViewById(R.id.txtSDT);

        }
        public void Bind(ThongTin t){
            this.t = t;
            txtTen.setText(t.getName());
            txtNgay.setText(t.getNgay());
            txtSDT.setText(t.getSdt());
        }
    }
    private class ThongTinAdapter extends RecyclerView.Adapter<ThongTinViewholder>{
        List<ThongTin> lisThongTin;
        @NonNull
        @Override
        public ThongTinViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.thongtin, parent, false);
            return new ThongTinViewholder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ThongTinViewholder holder, int position) {
            holder.Bind(listThongTin.get(position));
        }

        @Override
        public int getItemCount() {
            return listThongTin.size();
        }
    }
    //tạo menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu); // đưa menu lên
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();
        if(id == R.id.mnThem){
            ShowDetail();
        }
        return super.onOptionsItemSelected(item);
    }
    public void ShowDetail(){
        Intent intent = new Intent(this,Detail.class);
        startActivity(intent);
    }
    public void nhan(){
        Intent intent = getIntent();
        String ten = intent.getStringExtra(Detail.keyTen);
        String ngay = intent.getStringExtra(Detail.keyNgay);
        String phone = intent.getStringExtra(Detail.keyPhoe);
        if(ten == null){
            return;
        }
        ThongTin tt = new ThongTin(ten, ngay, phone);
        listThongTin.add(listThongTin.size(),tt);
        lvThongTin.setAdapter(adapterThongTin);
    }
}
