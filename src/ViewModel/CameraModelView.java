/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author haha
 */
public class CameraModelView {
    private String camBien;
    private String khauDo;
    private String chucNang;
    private String maxZoom;
    private String video;

    public CameraModelView(String camBien, String khauDo, String chucNang, String maxZoom, String video) {
        this.camBien = camBien;
        this.khauDo = khauDo;
        this.chucNang = chucNang;
        this.maxZoom = maxZoom;
        this.video = video;
    }

    public CameraModelView() {
    }

    public String getCamBien() {
        return camBien;
    }

    public void setCamBien(String camBien) {
        this.camBien = camBien;
    }

    public String getKhauDo() {
        return khauDo;
    }

    public void setKhauDo(String khauDo) {
        this.khauDo = khauDo;
    }

    public String getChucNang() {
        return chucNang;
    }

    public void setChucNang(String chucNang) {
        this.chucNang = chucNang;
    }

    public String getMaxZoom() {
        return maxZoom;
    }

    public void setMaxZoom(String maxZoom) {
        this.maxZoom = maxZoom;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
    
    
    
    
}
