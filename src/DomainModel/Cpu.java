/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author haha
 */
public class Cpu {

    private String id;
    private String CPU;
    private String GPU;
    private String loai;
    private String hang;
    private String tienTrinh;

    private int trangThai;

    @Override
    public String toString() {
        return "Cpu{" + "id=" + id + ", CPU=" + CPU + ", GPU=" + GPU + ", loai=" + loai + ", hang=" + hang + ", tienTrinh=" + tienTrinh + ", trangThai=" + trangThai + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getGPU() {
        return GPU;
    }

    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public String getTienTrinh() {
        return tienTrinh;
    }

    public void setTienTrinh(String tienTrinh) {
        this.tienTrinh = tienTrinh;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Cpu() {
    }

    public Cpu(String id, String CPU, String GPU, String loai, String hang, String tienTrinh, int trangThai) {
        this.id = id;
        this.CPU = CPU;
        this.GPU = GPU;
        this.loai = loai;
        this.hang = hang;
        this.tienTrinh = tienTrinh;
        this.trangThai = trangThai;
    }

}
