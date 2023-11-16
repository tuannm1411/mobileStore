/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import Repository.BanHangReponsitory;

/**
 *
 * @author ADMIN
 */
public class DienThoaiViewModel {
    private String id;
    private String maDienThoai;
    private String tenDienThoai;
    private String idHang;
    private int trangThai;
    private BanHangReponsitory bhr=new BanHangReponsitory();
    public DienThoaiViewModel() {
    }

    public DienThoaiViewModel(String id, String maDienThoai, String tenDienThoai, String idHang, int trangThai) {
        this.id = id;
        this.maDienThoai = maDienThoai;
        this.tenDienThoai = tenDienThoai;
        this.idHang = idHang;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaDienThoai() {
        return maDienThoai;
    }

    public void setMaDienThoai(String maDienThoai) {
        this.maDienThoai = maDienThoai;
    }

    public String getTenDienThoai() {
        return tenDienThoai;
    }

    public void setTenDienThoai(String tenDienThoai) {
        this.tenDienThoai = tenDienThoai;
    }

    public String getIdHang() {
        return idHang;
    }

    public void setIdHang(String idHang) {
        this.idHang = idHang;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    public String layTenDongSP(){
        return bhr.layTenDong(maDienThoai);
    }
    
    public Integer layGia(){
        return bhr.layGia(maDienThoai);
    }
    
    public Object[] toDataRow(){
        return new Object[]{maDienThoai,layTenDongSP(),layGia()};
    }
}
