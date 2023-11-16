/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author quanl
 */
public class HoaDonChiTiet {

    private String id;
    private String IMEI;
    private String idHoaDon;
    private String idBaoHanh;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String id, String IMEI, String idHoaDon, String idBaoHanh) {
        this.id = id;
        this.IMEI = IMEI;
        this.idHoaDon = idHoaDon;
        this.idBaoHanh = idBaoHanh;
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

    public String getIdBaoHanh() {
        return idBaoHanh;
    }

    public void setIdBaoHanh(String idBaoHanh) {
        this.idBaoHanh = idBaoHanh;
    }
    


}
