/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author quanl
 */
public class ChiTietDienThoai {

    private String IMEI;
    private int trangThai;
    private int moi;
    private String moTa;
    private String idQuocGiaDong;
    private double giaban;
    private double giaNhap;
    public ChiTietDienThoai() {
    }

    public ChiTietDienThoai(String IMEI, int trangThai, int moi, String moTa, String idQuocGiaDong, double giaban, double giaNhap) {
        this.IMEI = IMEI;
        this.trangThai = trangThai;
        this.moi = moi;
        this.moTa = moTa;
        this.idQuocGiaDong = idQuocGiaDong;
        this.giaban = giaban;
        this.giaNhap = giaNhap;
    }

    public ChiTietDienThoai(int moi, double giaban, double giaNhap) {
        this.moi = moi;
        this.giaban = giaban;
        this.giaNhap = giaNhap;
    }
    

    public double getGiaban() {
        return giaban;
    }

    public void setGiaban(double giaban) {
        this.giaban = giaban;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }
    
    public ChiTietDienThoai(String IMEI, int trangThai, int moi, String moTa, String idQuocGiaDong) {
        this.IMEI = IMEI;
        this.trangThai = trangThai;
        this.moi = moi;
        this.moTa = moTa;
        this.idQuocGiaDong = idQuocGiaDong;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getMoi() {
        return moi;
    }

    public void setMoi(int moi) {
        this.moi = moi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getIdQuocGiaDong() {
        return idQuocGiaDong;
    }

    public void setIdQuocGiaDong(String idQuocGiaDong) {
        this.idQuocGiaDong = idQuocGiaDong;
    }

}
