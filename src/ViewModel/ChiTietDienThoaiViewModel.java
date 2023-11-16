/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import Repository.BanHangReponsitory;

/**
 *
 * @author ADMIN
 */
public class ChiTietDienThoaiViewModel {

    private String IMEI;
    private Boolean trangThai;
    private String moTa;
    private String idQuocGiaDong;

    public ChiTietDienThoaiViewModel() {
    }

    public ChiTietDienThoaiViewModel(String IMEI, Boolean trangThai, String moTa, String idQuocGiaDong) {
        this.IMEI = IMEI;
        this.trangThai = trangThai;
        this.moTa = moTa;
        this.idQuocGiaDong = idQuocGiaDong;
    }

    @Override
    public String toString() {
        return "ChiTietDienThoaiViewModel{" + "IMEI=" + IMEI + ", trangThai=" + trangThai + ", moTa=" + moTa + ", idQuocGiaDong=" + idQuocGiaDong + '}';
    }
    

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
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
