/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author haha
 */
public class BoNho {
     private String id;
    private String RAM;
    private String ROM;
    private String theNho;
    private int trangThai;

    public BoNho(String id, String RAM, String ROM, String theNho, int trangThai) {
        this.id = id;
        this.RAM = RAM;
        this.ROM = ROM;
        this.theNho = theNho;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

  
    public BoNho() {
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getROM() {
        return ROM;
    }

    public void setROM(String ROM) {
        this.ROM = ROM;
    }

    public String getTheNho() {
        return theNho;
    }

    public void setTheNho(String theNho) {
        this.theNho = theNho;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "BoNho{" + "RAM=" + RAM + ", ROM=" + ROM + ", theNho=" + theNho + ", trangThai=" + trangThai + '}';
    }
    
    
}
