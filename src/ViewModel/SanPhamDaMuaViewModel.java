/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author quanl
 */
public class SanPhamDaMuaViewModel {

    private String IMEI;
    private String tenDienThoai;
    private String tenDong;
    private String giaBan;

    public SanPhamDaMuaViewModel() {
    }

    public SanPhamDaMuaViewModel(String IMEI, String tenDienThoai, String tenDong, String giaBan) {
        this.IMEI = IMEI;
        this.tenDienThoai = tenDienThoai;
        this.tenDong = tenDong;
        this.giaBan = giaBan;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public String getTenDienThoai() {
        return tenDienThoai;
    }

    public void setTenDienThoai(String tenDienThoai) {
        this.tenDienThoai = tenDienThoai;
    }

    public String getTenDong() {
        return tenDong;
    }

    public void setTenDong(String tenDong) {
        this.tenDong = tenDong;
    }

    public String getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(String giaBan) {
        this.giaBan = giaBan;
    }

    public Object[] toDataRow() {
        return new Object[]{IMEI, tenDienThoai, tenDong, giaBan};
    }

}
