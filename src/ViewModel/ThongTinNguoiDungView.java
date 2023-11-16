/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author buiti
 */
public class ThongTinNguoiDungView {
    private String ten;
    private String chucVu;
    private String ngaySinh;
    private String sdt;
    private String email;
    private String diaChi;
    private String cmnd;

    public ThongTinNguoiDungView() {
    }

    public ThongTinNguoiDungView(String ten, String chucVu, String ngaySinh, String sdt, String email, String diaChi, String cmnd) {
        this.ten = ten;
        this.chucVu = chucVu;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.cmnd = cmnd;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    @Override
    public String toString() {
        return "ThongTinNguoiDungView{" + "ten=" + ten + ", chucVu=" + chucVu + ", ngaySinh=" + ngaySinh + ", sdt=" + sdt + ", email=" + email + ", diaChi=" + diaChi + ", cmnd=" + cmnd + '}';
    }
    
}
