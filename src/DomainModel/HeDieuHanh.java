/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author haha
 */
public class HeDieuHanh {
    private String id;
    private String tenHDH;
    private String phienBan;
    private int trangThai;

    public HeDieuHanh(String id, String tenHDH, String phienBan, int trangThai) {
        this.id = id;
        this.tenHDH = tenHDH;
        this.phienBan = phienBan;
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "HeDieuHanh{" + "id=" + id + ", tenHDH=" + tenHDH + ", phienBan=" + phienBan + ", trangThai=" + trangThai + '}';
    }

    public HeDieuHanh() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenHDH() {
        return tenHDH;
    }

    public void setTenHDH(String tenHDH) {
        this.tenHDH = tenHDH;
    }

    public String getPhienBan() {
        return phienBan;
    }

    public void setPhienBan(String phienBan) {
        this.phienBan = phienBan;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
