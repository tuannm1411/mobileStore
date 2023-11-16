package DomainModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author buiti
 */
public class ThongSo {

    private String id;
    private String idQuocGiaDong;
    private String heDieuhanh;
    private String cpu;
    private String boNho;
    private String pin;
    private String ketNoi;
    private String manHinh;
    private String thietKe;
    private String tienIch;
    private String mauSac;
    private String camera;

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public ThongSo(String id, String idQuocGiaDong, String heDieuhanh, String cpu, String boNho, String pin, String ketNoi, String manHinh, String thietKe, String tienIch, String mauSac, String camera) {
        this.id = id;
        this.idQuocGiaDong = idQuocGiaDong;
        this.heDieuhanh = heDieuhanh;
        this.cpu = cpu;
        this.boNho = boNho;
        this.pin = pin;
        this.ketNoi = ketNoi;
        this.manHinh = manHinh;
        this.thietKe = thietKe;
        this.tienIch = tienIch;
        this.mauSac = mauSac;
        this.camera = camera;
    }

    public ThongSo() {
    }

    public ThongSo(String id, String idQuocGiaDong, String heDieuhanh, String cpu, String boNho, String pin, String ketNoi, String manHinh, String thietKe, String tienIch, String mauSac) {
        this.id = id;
        this.idQuocGiaDong = idQuocGiaDong;
        this.heDieuhanh = heDieuhanh;
        this.cpu = cpu;
        this.boNho = boNho;
        this.pin = pin;
        this.ketNoi = ketNoi;
        this.manHinh = manHinh;
        this.thietKe = thietKe;
        this.tienIch = tienIch;
        this.mauSac = mauSac;
    }

    public String getBoNho() {
        return boNho;
    }

    public void setBoNho(String boNho) {
        this.boNho = boNho;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getKetNoi() {
        return ketNoi;
    }

    public void setKetNoi(String ketNoi) {
        this.ketNoi = ketNoi;
    }

    public String getThietKe() {
        return thietKe;
    }

    public void setThietKe(String thietKe) {
        this.thietKe = thietKe;
    }

    public String getTienIch() {
        return tienIch;
    }

    public void setTienIch(String tienIch) {
        this.tienIch = tienIch;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getHeDieuhanh() {
        return heDieuhanh;
    }

    public void setHeDieuhanh(String heDieuhanh) {
        this.heDieuhanh = heDieuhanh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdQuocGiaDong() {
        return idQuocGiaDong;
    }

    public void setIdQuocGiaDong(String idQuocGiaDong) {
        this.idQuocGiaDong = idQuocGiaDong;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getManHinh() {
        return manHinh;
    }

    public void setManHinh(String manHinh) {
        this.manHinh = manHinh;
    }

    @Override
    public String toString() {
        return "ThongSo{" + "id=" + id + ", idQuocGiaDong=" + idQuocGiaDong + ", heDieuhanh=" + heDieuhanh + ", cpu=" + cpu + ", boNho=" + boNho + ", pin=" + pin + ", ketNoi=" + ketNoi + ", manHinh=" + manHinh + ", thietKe=" + thietKe + ", tienIch=" + tienIch + ", mauSac=" + mauSac + ", camera=" + camera + '}';
    }

}
