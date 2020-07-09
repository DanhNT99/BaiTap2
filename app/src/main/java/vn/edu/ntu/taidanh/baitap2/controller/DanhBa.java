package vn.edu.ntu.taidanh.baitap2.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.taidanh.baitap2.model.ThongTin;

public class DanhBa extends Application implements IDanhBa {
    List<ThongTin> listThongTin = new ArrayList<>();

    public DanhBa() {
        listThongTin.add(new ThongTin("Thuân", "19-02-1999","038419574"));
        listThongTin.add(new ThongTin("Tý", "11-09-1999","0389124463"));
        listThongTin.add(new ThongTin("Bậm", "28-03-1999","0387968865"));
        listThongTin.add(new ThongTin("Khanh", "05-06-2000","038578051"));
        listThongTin.add(new ThongTin("Nô", "05-07-2000","038414524"));
        listThongTin.add(new ThongTin("Xù", "28-02-2001","038783913"));
    }

    @Override
    public List<ThongTin> getAllThongTin() {
        return listThongTin;
    }

    @Override
    public void addThongTin(ThongTin t) {
       listThongTin.add(t);
    }
}
