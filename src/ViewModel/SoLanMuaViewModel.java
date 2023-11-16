/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author quanl
 */
public class SoLanMuaViewModel {

    private String ID;
    private String tenKhachHang;
    private int soLanMua;

    public SoLanMuaViewModel() {
    }

    public SoLanMuaViewModel(String ID, String tenKhachHang, int soLanMua) {
        this.ID = ID;
        this.tenKhachHang = tenKhachHang;
        this.soLanMua = soLanMua;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public int getSoLanMua() {
        return soLanMua;
    }

    public void setSoLanMua(int soLanMua) {
        this.soLanMua = soLanMua;
    }

    public Object[] toDataRow() {
        return new Object[]{ID, tenKhachHang, soLanMua};
    }
}
