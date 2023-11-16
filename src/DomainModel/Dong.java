package DomainModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author quanl
 */
public class Dong {

    private String id;

    private String ma;

    private String ten;

    private String idDienThoai;
    
    private int trangThai;

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    

    public Dong() {
    }

    @Override
    public String toString() {
        return "Dong{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", idDienThoai=" + idDienThoai + '}';
    }

    public Dong(String id, String ma, String ten, String idDienThoai, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.idDienThoai = idDienThoai;
        this.trangThai = trangThai;
    }

    public Dong(String id, String ma, String ten, String idDienThoai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.idDienThoai = idDienThoai;
    }

    public Dong(String id, String ten) {
        this.id = id;
        this.ten = ten;
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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getIdDienThoai() {
        return idDienThoai;
    }

    public void setIdDienThoai(String idDienThoai) {
        this.idDienThoai = idDienThoai;
    }

}
