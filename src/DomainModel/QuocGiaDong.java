package DomainModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author quanl
 */
public class QuocGiaDong {

    private String id;
    private String idDong;
    private String idQuocGia;
    private Double giaBan;
    private Double giaNhap;
    private String srcAnh;

    public QuocGiaDong() {
    }

    public QuocGiaDong(String id, String idDong, String idQuocGia, Double giaBan, Double giaNhap, String srcAnh) {
        this.id = id;
        this.idDong = idDong;
        this.idQuocGia = idQuocGia;

        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.srcAnh = srcAnh;
    }

    public String getSrcAnh() {
        return srcAnh;
    }

    public void setSrcAnh(String srcAnh) {
        this.srcAnh = srcAnh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdDong() {
        return idDong;
    }

    public void setIdDong(String idDong) {
        this.idDong = idDong;
    }

    public String getIdQuocGia() {
        return idQuocGia;
    }

    public void setIdQuocGia(String idQuocGia) {
        this.idQuocGia = idQuocGia;
    }

   

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }

}
