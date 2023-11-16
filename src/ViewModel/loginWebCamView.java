/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author buiti
 */
public class loginWebCamView {
    private String idChucVu;
    private String tenChucVu;
    private String cmnd;

    public loginWebCamView() {
    }

    public loginWebCamView(String idChucVu, String tenChucVu, String cmnd) {
        this.idChucVu = idChucVu;
        this.tenChucVu = tenChucVu;
        this.cmnd = cmnd;
    }

    public String getIdChucVu() {
        return idChucVu;
    }

    public void setIdChucVu(String idChucVu) {
        this.idChucVu = idChucVu;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    @Override
    public String toString() {
        return "loginWebCamView{" + "idChucVu=" + idChucVu + ", tenChucVu=" + tenChucVu + ", cmnd=" + cmnd + '}';
    }
    
    
}
