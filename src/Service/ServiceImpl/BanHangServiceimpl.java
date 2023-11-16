/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import DomainModel.ChiTietDienThoai;
import DomainModel.HoaDon;
import Repository.BanHangReponsitory;
import Service.BanHangService;
import View.BanHangView;
import ViewModel.ChiTietDienThoaiViewModel;
import ViewModel.DienThoaiViewModel;
import ViewModel.HoaDonChiTietViewModel;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class BanHangServiceimpl implements BanHangService {

    BanHangReponsitory bhr = new BanHangReponsitory();

    @Override
    public void getAll(List<DienThoaiViewModel> list) {
        list.addAll(bhr.getAll());
    }

    @Override
    public void showData(DefaultTableModel dtm, List<DienThoaiViewModel> list) {
        dtm.setRowCount(0);
        for (DienThoaiViewModel a : list) {
            dtm.addRow(a.toDataRow());
        }
    }

    @Override
    public void getMaHD(List<String> list) {
        list.addAll(bhr.getAllMaHoaDon());
    }

    @Override
    public void getHDCT(List<HoaDonChiTietViewModel> list, String maHD) {
        list.addAll(bhr.getAllHoaDon(maHD));
    }

    @Override
    public void showDataHoaDon(DefaultTableModel dtm, List<HoaDonChiTietViewModel> list) {
        dtm.setRowCount(0);
        for(HoaDonChiTietViewModel a:list){
            dtm.addRow(a.toDataRowBanHang());
        }
    }

    @Override
    public void getTenKH(List<String> list) {
        list.addAll(bhr.getAllKH());
    }

    @Override
    public void getMaNV(List<String> list) {
        list.addAll(bhr.getAllMaNV());
    }

    @Override
    public void getMaGG(List<String> list) {
        list.addAll(bhr.getAllMaGG());
    }

    @Override
    public void addVaoHDCT(String imei, String maHD) {
        bhr.addVaoHoaDonCT(imei, maHD);  
    }

    @Override
    public void deleteHDCT(String imei, String maHD) {
        bhr.deleteHoaDonCT(imei, maHD);
    }

    @Override
    public String addHD() {
        String maHDThem=bhr.maHD();
        boolean add=bhr.addHoaDon();
        if(add==true){
            return "Thêm thành công " + maHDThem;
        }else{
            return "Thêm thất bại";
        }
    }

    @Override
    public int layGiaHD(String maHD) {
        return bhr.layGiaTien(maHD);
    }

    @Override
    public String thanhToan(String tenKH, String maNV, String maKM, String maHD) {
        boolean update=bhr.thanhToan(tenKH, maNV, maKM, maHD);
        if(update==true){
            return "Thanh toán thành công";
        }else{
            return "Thanh toán thất bại";
        }
    }

    @Override
    public int layGiaGiamGiaPhanTram(int giaTien,String maKM) {
        return bhr.layGiaGiamGiaPhantram(giaTien, maKM);
    }

    @Override
    public int layGiaGiamGiaK(String maKM) {
        return bhr.layGiaGiamGiaK(maKM);
    }

    @Override
    public boolean layDonVi(String maKM) {
        return bhr.layDonVi(maKM);
    }

    @Override
    public int layGiaThanhTien(int tongTien, int giamGia) {
        return bhr.layThanhTien(tongTien, giamGia);
    }

    @Override
    public void getAllHoaDonChuaThanhToan(List<HoaDon> list) {
        list.addAll(bhr.getAllHoaDonChuaThanhToan());
    }

    @Override
    public void showDataHoaDonChuaThanhToan(DefaultTableModel dtm, List<HoaDon> list) {
        dtm.setRowCount(0);
        for(HoaDon a:list){
            dtm.addRow(a.toDataRowBanHang());
        }
    }

    @Override
    public void sapXepHoaDon(List<HoaDon> list) {
        list.sort((o1,o2)->{
            return o1.getMaHoaDon().compareTo(o2.getMaHoaDon());
        });
    }

    @Override
    public void getIMEI(List<String> list,String maDT) {
        list.addAll(bhr.layIMEITheoMaDT(maDT));
    }

    @Override
    public String themThongTinVaoHD(String tenKH, String maNV, String maHD) {
        boolean update=bhr.themThongTinVaoHoaDon(tenKH, maNV, maHD);
        if(update==true){
            return "Thêm thông tin thành công";
        }else{
            return "Thêm thông tin thất bại";
        }
    }

    @Override
    public void sapXepTheoGiaTangDan(List<DienThoaiViewModel> list) {
        list.sort((o1,o2)->{
            return o1.layGia().compareTo(o2.layGia());
        });
    }

    @Override
    public void sapXepTheoGiaGiamDan(List<DienThoaiViewModel> list) {
        list.sort((o1,o2)->{
            return o2.layGia().compareTo(o1.layGia());
        });
    }

    @Override
    public void timTen(List<DienThoaiViewModel> list, String ten) {
        list.addAll(bhr.timKiemTheoTen(ten));
    }

    @Override
    public void thayDoiTrangThaiDienThoai(String imei) {
        bhr.updateTrangThaiChiTietDienThoai(imei);
    }

    @Override
    public void checkTrungIMEI(String maHD, String IMEI,List<HoaDonChiTietViewModel> list) {
        list.addAll(bhr.getAllHoaDonCheckTrung(maHD, IMEI));
    }

    @Override
    public void xoaSPDaCoTrongHD(String imei, String maHD) {
        bhr.xoaSPDaCoTrongHD(imei, maHD);
    }
}
