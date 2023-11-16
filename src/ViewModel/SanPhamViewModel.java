/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author haha
 */
public class SanPhamViewModel {

    private String id;
    private String srcAnh;
    private String ten;
    private String ma;
    private String tenHang;
    private String tenDong;
    private String tenQuocGia;
    private int soLuongCon;
    private double giaBan;
    private double giaNhap;

    public String getId() {
        return id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public SanPhamViewModel(String id, String srcAnh, String ten, String tenHang, String tenDong, String tenQuocGia, int soLuongCon, double giaBan, double giaNhap) {
        this.id = id;
        this.srcAnh = srcAnh;
        this.ten = ten;
        this.tenHang = tenHang;
        this.tenDong = tenDong;
        this.tenQuocGia = tenQuocGia;
        this.soLuongCon = soLuongCon;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
    }

    public SanPhamViewModel(String id, String srcAnh, String ten, String ma, String tenHang, String tenDong, String tenQuocGia, int soLuongCon, double giaBan, double giaNhap) {
        this.id = id;
        this.srcAnh = srcAnh;
        this.ten = ten;
        this.ma = ma;
        this.tenHang = tenHang;
        this.tenDong = tenDong;
        this.tenQuocGia = tenQuocGia;
        this.soLuongCon = soLuongCon;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
    }

    public String getTenDong() {
        return tenDong;
    }

    public void setTenDong(String tenDong) {
        this.tenDong = tenDong;
    }

    public String getTenQuocGia() {
        return tenQuocGia;
    }

    public void setTenQuocGia(String tenQuocGia) {
        this.tenQuocGia = tenQuocGia;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public SanPhamViewModel() {
    }

    @Override
    public String toString() {
        return "SanPhamViewModel{" + "id=" + id + ", srcAnh=" + srcAnh + ", ten=" + ten + ", soLuongCon=" + soLuongCon + ", giaBan=" + giaBan + ", giaNhap=" + giaNhap + '}';
    }

    public String getSrcAnh() {
        return srcAnh;
    }

    public void setSrcAnh(String srcAnh) {
        this.srcAnh = srcAnh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoLuongCon() {
        return soLuongCon;
    }

    public void setSoLuongCon(int soLuongCon) {
        this.soLuongCon = soLuongCon;
    }

}
