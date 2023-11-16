/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author haha
 */
public class ThietKe {

    private String id;
    private String matTruoc;
    private String matLung;
    private String vien;
    private String trongLuong;
    private int trangThai;

    public ThietKe(String id, String matTruoc, String matLung, String vien, String trongLuong, int trangThai) {
        this.id = id;
        this.matTruoc = matTruoc;
        this.matLung = matLung;
        this.vien = vien;
        this.trongLuong = trongLuong;
        this.trangThai = trangThai;
    }

    public ThietKe() {
    }

    @Override
    public String toString() {
        return "ThietKe{" + "id=" + id + ", matTruoc=" + matTruoc + ", matLung=" + matLung + ", vien=" + vien + ", trongLuong=" + trongLuong + ", trangThai=" + trangThai + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatTruoc() {
        return matTruoc;
    }

    public void setMatTruoc(String matTruoc) {
        this.matTruoc = matTruoc;
    }

    public String getMatLung() {
        return matLung;
    }

    public void setMatLung(String matLung) {
        this.matLung = matLung;
    }

    public String getVien() {
        return vien;
    }

    public void setVien(String vien) {
        this.vien = vien;
    }

    public String getTrongLuong() {
        return trongLuong;
    }

    public void setTrongLuong(String trongLuong) {
        this.trongLuong = trongLuong;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
}
