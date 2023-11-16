/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author admin
 */
public class ChucVuViewModel {

    private String id;
    private String ma;
    private String maNV;
    private String ten;
    private String tenNV;

    public ChucVuViewModel() {
    }

    public ChucVuViewModel(String id, String ma, String ten) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
    }

    public ChucVuViewModel(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

  

    public ChucVuViewModel(String id, String ma, String maNV, String ten, String tenNV) {
        this.id = id;
        this.ma = ma;
        this.maNV = maNV;
        this.ten = ten;
        this.tenNV = tenNV;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public Object[] toDaTaRow() {
        return new Object[]{ma,ten,maNV,tenNV};
    }

 

}
