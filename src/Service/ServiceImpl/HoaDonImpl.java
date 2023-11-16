/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import Repository.HoaDonRespository;
import ViewModel.VIewModelSanPhamHoaDon;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import ViewModel.ViewModelHoaDon;
import Service.HoaDonService;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author PC
 */
public class HoaDonImpl implements HoaDonService {

    @Override
    public List<ViewModelHoaDon> getAll(List<ViewModelHoaDon> list) {
        return new HoaDonRespository().getAllHoaDon();
    }

    @Override
    public void showData(List<ViewModelHoaDon> list, DefaultTableModel dtm) {
        dtm.setRowCount(0);
        for (ViewModelHoaDon viewModelHoaDon : list) {
            dtm.addRow(viewModelHoaDon.dataRow());
        }
    }

    @Override
    public List<ViewModelHoaDon> searchHoaDon(String mahd) {

        List<ViewModelHoaDon> listSearch = new ArrayList<>();

        for (ViewModelHoaDon viewModelHoaDon : new HoaDonRespository().getAllHoaDon()) {

            if (viewModelHoaDon.getMaHD().contains(mahd) || viewModelHoaDon.getTenKH().contains(mahd) || viewModelHoaDon.getTenNV().contains(mahd)) {
                listSearch.add(viewModelHoaDon);
            }

        }
        return listSearch;
    }

    @Override
    public List<ViewModelHoaDon> giaCaoXuongThap(List<ViewModelHoaDon> list) {
        list.sort((o1, o2) -> {
            int x1 = (int) Math.round(o1.getTongTien());
            int x2 = (int) Math.round(o2.getTongTien());
            return x1 - x2;
        });
        return list;
    }

    @Override
    public List<ViewModelHoaDon> giaThapLenCao(List<ViewModelHoaDon> list) {
        list.sort((o1, o2) -> {
            int x1 = (int) Math.round(o1.getTongTien());
            int x2 = (int) Math.round(o2.getTongTien());
            return x2 - x1;
        });
        return list;

    }

    @Override
    public List<VIewModelSanPhamHoaDon> getAllSp(String mahd) {
        return new HoaDonRespository().getAllSanPham(mahd);
    }

    @Override
    public void showData1(List<VIewModelSanPhamHoaDon> list, DefaultTableModel dtm) {
        dtm.setRowCount(0);
        for (VIewModelSanPhamHoaDon vIewModelSanPhamHoaDon : list) {
            dtm.addRow(vIewModelSanPhamHoaDon.dataRowSPHoaDon());
        }
    }

    @Override
    public void exportExcel(List<ViewModelHoaDon> list, String name) {
        new WriteExcelHoaDon().exportExcel(list, name);
    }

    @Override
    public void exportWord(ViewModelHoaDon hd, String file) {
        new WriteWordHoaDon().exportWord(hd, file);
    }

    @Override
    public int getSLHoaDonThanhToan() {
        return new HoaDonRespository().getHoaDonDaThanhToan();
    }

    @Override
    public int getSLHoaDonChuaThanhToan() {
        return new HoaDonRespository().getHoaDonChuaThanhToan();
    }

}
