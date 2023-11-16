/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author haha
 */
public class Camera {
    private String id;
    private String cameraTruoc;
    private String cameraSau;
    private String quayVideo;
    private String Zoom;
    private String chongRung;
    private String dacBiet;
    private int trangThai;

    public Camera(String id, String cameraTruoc, String cameraSau, String quayVideo, String Zoom, String chongRung, String dacBiet, int trangThai) {
        this.id = id;
        this.cameraTruoc = cameraTruoc;
        this.cameraSau = cameraSau;
        this.quayVideo = quayVideo;
        this.Zoom = Zoom;
        this.chongRung = chongRung;
        this.dacBiet = dacBiet;
        this.trangThai = trangThai;
    }

    public Camera() {
    }

    @Override
    public String toString() {
        return "Camera{" + "id=" + id + ", cameraTruoc=" + cameraTruoc + ", cameraSau=" + cameraSau + ", quayVideo=" + quayVideo + ", Zoom=" + Zoom + ", chongRung=" + chongRung + ", dacBiet=" + dacBiet + ", trangThai=" + trangThai + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCameraTruoc() {
        return cameraTruoc;
    }

    public void setCameraTruoc(String cameraTruoc) {
        this.cameraTruoc = cameraTruoc;
    }

    public String getCameraSau() {
        return cameraSau;
    }

    public void setCameraSau(String cameraSau) {
        this.cameraSau = cameraSau;
    }

    public String getQuayVideo() {
        return quayVideo;
    }

    public void setQuayVideo(String quayVideo) {
        this.quayVideo = quayVideo;
    }

    public String getZoom() {
        return Zoom;
    }

    public void setZoom(String Zoom) {
        this.Zoom = Zoom;
    }

    public String getChongRung() {
        return chongRung;
    }

    public void setChongRung(String chongRung) {
        this.chongRung = chongRung;
    }

    public String getDacBiet() {
        return dacBiet;
    }

    public void setDacBiet(String dacBiet) {
        this.dacBiet = dacBiet;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

   
}
