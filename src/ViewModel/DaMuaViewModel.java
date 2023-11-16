/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author quanl
 */
public class DaMuaViewModel {

    private String maSP;
    private String ngayMua;

    public DaMuaViewModel() {
    }

    public DaMuaViewModel(String maSP, String ngayMua) {
        this.maSP = maSP;
        this.ngayMua = ngayMua;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }

    public Object[] toDataRow() {
        return new Object[]{maSP, ngayMua};
    }
}
