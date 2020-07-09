package vn.edu.ntu.taidanh.baitap2.model;

public class ThongTin {
    String name, ngay,sdt;

    public ThongTin(String name, String ngay, String sdt) {
        this.name = name;
        this.ngay = ngay;
        this.sdt = sdt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
