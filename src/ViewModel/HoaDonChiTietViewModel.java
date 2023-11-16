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
public class HoaDonChiTietViewModel {
    
    private String id;
    private String IMEI;
    private String idHoaDon;
    private BanHangReponsitory bhr=new BanHangReponsitory();
            
    public HoaDonChiTietViewModel() {
    }

    public HoaDonChiTietViewModel(String id, String IMEI, String idHoaDon) {
        this.id = id;
        this.IMEI = IMEI;
        this.idHoaDon = idHoaDon;
    }

    

    

    public HoaDonChiTietViewModel(String IMEI, String idHoaDon) {
        this.IMEI = IMEI;
        this.idHoaDon = idHoaDon;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }
    
    public String layTenSP(){
        return bhr.layTenSP(IMEI);
    }
    public int layGia(){
        return bhr.layGiaHoaDon(IMEI);
    }
    
    public Object[] toDataRowBanHang(){
        return new Object[]{IMEI,layTenSP(),layGia()};
    }
}
