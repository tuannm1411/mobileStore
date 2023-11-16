/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import java.text.DecimalFormat;

/**
 *
 * @author PC
 */
public class VIewModelSanPhamHoaDon {

    String MaHdSp;
    String MaDT;
    String TenSp;
    String TenHang;
    String TenDong;
    Double GiaBan;
    int DoMoi;
    String MoTa;

    public VIewModelSanPhamHoaDon() {
    }

    public VIewModelSanPhamHoaDon(String MaHdSp, String MaDT, String TenSp, String TenHang, String TenDong, Double GiaBan, int DoMoi, String MoTa) {
        this.MaHdSp = MaHdSp;
        this.MaDT = MaDT;
        this.TenSp = TenSp;
        this.TenHang = TenHang;
        this.TenDong = TenDong;
        this.GiaBan = GiaBan;
        this.DoMoi = DoMoi;
        this.MoTa = MoTa;
    }

    public String getMaHdSp() {
        return MaHdSp;
    }

    public void setMaHdSp(String MaHdSp) {
        this.MaHdSp = MaHdSp;
    }

    public String getMaDT() {
        return MaDT;
    }

    public void setMaDT(String MaDT) {
        this.MaDT = MaDT;
    }

    public String getTenSp() {
        return TenSp;
    }

    public void setTenSp(String TenSp) {
        this.TenSp = TenSp;
    }

    public String getTenHang() {
        return TenHang;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }

    public String getTenDong() {
        return TenDong;
    }

    public void setTenDong(String TenDong) {
        this.TenDong = TenDong;
    }

    public Double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(Double GiaBan) {
        this.GiaBan = GiaBan;
    }

    public int getDoMoi() {
        return DoMoi;
    }

    public void setDoMoi(int DoMoi) {
        this.DoMoi = DoMoi;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public Object[] dataRowSPHoaDon() {
        DecimalFormat df = new DecimalFormat("###,###,###,###");
        return new Object[]{MaDT, MaHdSp, TenSp, TenHang, TenDong, df.format(GiaBan), DoMoi + "%", MoTa};
    }

}
