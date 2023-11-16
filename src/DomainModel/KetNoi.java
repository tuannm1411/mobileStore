/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author haha
 */
public class KetNoi {

    private String id;
    private String sim;
    private String hongNgoai;
    private String jackTaiNghe;
    private String hoTroMang;
    private String wifi;
    private String blutooth;
    private String GPS;
    private int trangThai;

    public KetNoi() {
    }

    public KetNoi(String id, String sim, String hongNgoai, String jackTaiNghe, String hoTroMang, String wifi, String blutooth, String GPS, int trangThai) {
        this.id = id;
        this.sim = sim;
        this.hongNgoai = hongNgoai;
        this.jackTaiNghe = jackTaiNghe;
        this.hoTroMang = hoTroMang;
        this.wifi = wifi;
        this.blutooth = blutooth;
        this.GPS = GPS;
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "KetNoi{" + "id=" + id + ", sim=" + sim + ", hongNgoai=" + hongNgoai + ", jackTaiNghe=" + jackTaiNghe + ", hoTroMang=" + hoTroMang + ", wifi=" + wifi + ", blutooth=" + blutooth + ", GPS=" + GPS + ", trangThai=" + trangThai + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getHongNgoai() {
        return hongNgoai;
    }

    public void setHongNgoai(String hongNgoai) {
        this.hongNgoai = hongNgoai;
    }

    public String getJackTaiNghe() {
        return jackTaiNghe;
    }

    public void setJackTaiNghe(String jackTaiNghe) {
        this.jackTaiNghe = jackTaiNghe;
    }

    public String getHoTroMang() {
        return hoTroMang;
    }

    public void setHoTroMang(String hoTroMang) {
        this.hoTroMang = hoTroMang;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getBlutooth() {
        return blutooth;
    }

    public void setBlutooth(String blutooth) {
        this.blutooth = blutooth;
    }

    public String getGPS() {
        return GPS;
    }

    public void setGPS(String GPS) {
        this.GPS = GPS;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

}
