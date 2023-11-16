/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author haha
 */
public class Pin {

    private String id;
    private String dungLuong;
    private String loaiPin;
    private String sac;
    private String dacBiet;
    private int trangThai;

    public Pin(String id, String dungLuong, String loaiPin, String sac, String dacBiet, int trangThai) {
        this.id = id;
        this.dungLuong = dungLuong;
        this.loaiPin = loaiPin;
        this.sac = sac;
        this.dacBiet = dacBiet;
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "Pin{" + "id=" + id + ", dungLuong=" + dungLuong + ", loaiPin=" + loaiPin + ", sac=" + sac + ", dacBiet=" + dacBiet + ", trangThai=" + trangThai + '}';
    }

    public Pin() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDungLuong() {
        return dungLuong;
    }

    public void setDungLuong(String dungLuong) {
        this.dungLuong = dungLuong;
    }

    public String getLoaiPin() {
        return loaiPin;
    }

    public void setLoaiPin(String loaiPin) {
        this.loaiPin = loaiPin;
    }

    public String getSac() {
        return sac;
    }

    public void setSac(String sac) {
        this.sac = sac;
    }

    public String getDacBiet() {
        return dacBiet;
    }

    public void setDacBiet(String dacBiet) {
        this.dacBiet = dacBiet;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
    

}
