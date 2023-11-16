/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import Repository.BanHangReponsitory;
import java.sql.Date;

/**
 *
 * @author quanl
 */
public class HoaDon {

    private String id;
    private String maHoaDon;
    private Date ngayTao;
    private String idNhanVien;
    private String idKhachHang;
    private String idKhuyenMai;   
    private String moTa;
    private int trangThai;
    private BanHangReponsitory bhr = new BanHangReponsitory();
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(String idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getIdKhuyenMai() {
        return idKhuyenMai;
    }

    public void setIdKhuyenMai(String idKhuyenMai) {
        this.idKhuyenMai = idKhuyenMai;
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

    public HoaDon(String id, String maHoaDon, Date ngayTao, String idNhanVien, String idKhachHang, String idKhuyenMai, String moTa, int trangThai) {
        this.id = id;
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
        this.idNhanVien = idNhanVien;
        this.idKhachHang = idKhachHang;
        this.idKhuyenMai = idKhuyenMai;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public HoaDon() {
    }
    
    public String layTenKH(){
        return bhr.layTenKH(idKhachHang);
    }
    
    public String layMaNV(){
        return bhr.layMaNV(idNhanVien);
    }
    
    public Object[] toDataRowBanHang(){
        return new Object[]{maHoaDon};
    }
}
