/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author haha
 */
public class TienIch {
   private String id;
   private String baoMat;
   private String khangNuoc;
   private String dacBiet;
   private int trangThai;

    public TienIch(String id, String baoMat, String khangNuoc, String dacBiet, int trangThai) {
        this.id = id;
        this.baoMat = baoMat;
        this.khangNuoc = khangNuoc;
        this.dacBiet = dacBiet;
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "TienIch{" + "id=" + id + ", baoMat=" + baoMat + ", khangNuoc=" + khangNuoc + ", dacBiet=" + dacBiet + ", trangThai=" + trangThai + '}';
    }

    public TienIch() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBaoMat() {
        return baoMat;
    }

    public void setBaoMat(String baoMat) {
        this.baoMat = baoMat;
    }

    public String getKhangNuoc() {
        return khangNuoc;
    }

    public void setKhangNuoc(String khangNuoc) {
        this.khangNuoc = khangNuoc;
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
