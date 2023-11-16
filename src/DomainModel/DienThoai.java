package DomainModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author quanl
 */
public class DienThoai {

    private String id;

    private String ma;

    private String ten;

    private String idHang;
    
    private int trangThai;

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "DienThoai{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", idHang=" + idHang + '}';
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public DienThoai(String id, String ma, String ten, String idHang, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.idHang = idHang;
        this.trangThai = trangThai;
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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getIdHang() {
        return idHang;
    }

    public void setIdHang(String idHang) {
        this.idHang = idHang;
    }

    public DienThoai(String id, String ma, String ten, String idHang) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.idHang = idHang;
    }

    public DienThoai() {
    }

}
