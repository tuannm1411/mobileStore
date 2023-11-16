/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author buiti
 */
public class NhanVienView {
    private String id;
    private String ma;
    private String ten;
    private String idChucVu;
    private String tenChucVu;
    private String ngaySinh;
    private String sdt;
    private String email;
    private String diaChi;
    private String matKhau;
    private int trangThai;
    private String cmnd;

    public NhanVienView() {
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public NhanVienView(String id, String ma, String ten, String idChucVu, String tenChucVu, String ngaySinh, String sdt, String email, String diaChi, String matKhau, int trangThai, String cmnd) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.idChucVu = idChucVu;
        this.tenChucVu = tenChucVu;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
        this.cmnd = cmnd;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    @Override
    public String toString() {
        return "NhanVienView{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", idChucVu=" + idChucVu + ", tenChucVu=" + tenChucVu + ", ngaySinh=" + ngaySinh + ", sdt=" + sdt + ", email=" + email + ", diaChi=" + diaChi + ", matKhau=" + matKhau + ", trangThai=" + trangThai + '}';
    }
    public String tentrangThai(int trangThai){
        if (trangThai==1) {
           return "Đã nghỉ";
        } else {
            return "Đang làm";
        }
    }

    public Object[] toData(){
        return new Object[]{id,ma,ten,idChucVu,tenChucVu,ngaySinh,sdt,email,diaChi,matKhau,tentrangThai(trangThai),cmnd};
    }
    
    
}
