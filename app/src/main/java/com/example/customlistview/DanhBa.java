package com.example.customlistview;

public class DanhBa {
    String hoten, sdt;
    Integer mau;

    public DanhBa() {
    }

    public DanhBa(String hoten, String sdt, Integer mau) {
        this.hoten = hoten;
        this.sdt = sdt;
        this.mau = mau;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Integer getMau() {
        return mau;
    }

    public void setMau(Integer mau) {
        this.mau = mau;
    }
}
