/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import java.sql.Date;

/**
 *
 * @author togia
 */
public class KhuyenMaiViewModel {

    private String id;
    private String ma;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private double giaGiam;
    private boolean donVi;
    private String moTa;
    private int trangThai;

    public KhuyenMaiViewModel() {
    }

    public KhuyenMaiViewModel(String id, String ma, Date ngayBatDau, Date ngayKetThuc, double giaGiam, boolean donVi, String moTa, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.giaGiam = giaGiam;
        this.donVi = donVi;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public KhuyenMaiViewModel(String ma, Date ngayBatDau, Date ngayKetThuc, double giaGiam, boolean donVi, String moTa, int trangThai) {
        this.ma = ma;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.giaGiam = giaGiam;
        this.donVi = donVi;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public KhuyenMaiViewModel(String ma, Date ngayBatDau, Date ngayKetThuc, double giaGiam, boolean donVi, String moTa) {
        this.ma = ma;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.giaGiam = giaGiam;
        this.donVi = donVi;
        this.moTa = moTa;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public Double getGiaGiam() {
        return giaGiam;
    }

    public void setGiaGiam(Double giaGiam) {
        this.giaGiam = giaGiam;
    }

    public boolean isDonVi() {
        return donVi;
    }

    public void setDonVi(boolean donVi) {
        this.donVi = donVi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String layTrangThai() {
        if (trangThai == 0) {
            return "Đang diễn ra";
        } else if (trangThai == 1) {
            return "Sắp diễn ra";
        } else {
            return "Kết thúc";
        }

    }

    public Object[] toDataRow() {
        return new Object[]{id, ma, ngayBatDau, ngayKetThuc, giaGiam, donVi ? "Money" : "%", moTa, layTrangThai()};

    }
}
