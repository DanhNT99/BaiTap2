package vn.edu.ntu.taidanh.baitap2.controller;

import java.util.List;

import vn.edu.ntu.taidanh.baitap2.model.ThongTin;

public interface IDanhBa {
    public List<ThongTin> getAllThongTin();
    public void addThongTin(ThongTin t);
}
