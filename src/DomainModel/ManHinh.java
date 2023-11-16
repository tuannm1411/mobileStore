/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author haha
 */
public class ManHinh {
    private String id;
    private String loai;
    private String kieu;
    private String tangSoQuet;
    private String doPhanGiai;
    private String kichThuoc;
    private String congNghe;
    private int trangThai;

    public ManHinh(String id, String loai, String kieu, String tangSoQuet, String doPhanGiai, String kichThuoc, String congNghe, int trangThai) {
        this.id = id;
        this.loai = loai;
        this.kieu = kieu;
        this.tangSoQuet = tangSoQuet;
        this.doPhanGiai = doPhanGiai;
        this.kichThuoc = kichThuoc;
        this.congNghe = congNghe;
        this.trangThai = trangThai;
    }

    public ManHinh() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getKieu() {
        return kieu;
    }

    public void setKieu(String kieu) {
        this.kieu = kieu;
    }

    public String getTangSoQuet() {
        return tangSoQuet;
    }

    public void setTangSoQuet(String tangSoQuet) {
        this.tangSoQuet = tangSoQuet;
    }

    public String getDoPhanGiai() {
        return doPhanGiai;
    }

    public void setDoPhanGiai(String doPhanGiai) {
        this.doPhanGiai = doPhanGiai;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getCongNghe() {
        return congNghe;
    }

    public void setCongNghe(String congNghe) {
        this.congNghe = congNghe;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "ManHinh{" + "id=" + id + ", loai=" + loai + ", kieu=" + kieu + ", tangSoQuet=" + tangSoQuet + ", doPhanGiai=" + doPhanGiai + ", kichThuoc=" + kichThuoc + ", congNghe=" + congNghe + ", trangThai=" + trangThai + '}';
    }
    
    
}
