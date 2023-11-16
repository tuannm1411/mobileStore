/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author haha
 */
public class LuuKho {

    private String tenSP;
    private int soLuong;
    private String ngayLK;

    public LuuKho(String tenSP, int soLuong, String ngayLK) {
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.ngayLK = ngayLK;
    }

    public LuuKho() {
    }

    @Override
    public String toString() {
        return "LuuKho{" + "tenSP=" + tenSP + ", soLuong=" + soLuong + ", ngayLK=" + ngayLK + '}';
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNgayLK() {
        return ngayLK;
    }

    public void setNgayLK(String ngayLK) {
        this.ngayLK = ngayLK;
    }
    
    

}
