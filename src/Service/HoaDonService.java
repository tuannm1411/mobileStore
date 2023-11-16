/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModel.VIewModelSanPhamHoaDon;
import ViewModel.ViewModelHoaDon;
import java.io.File;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public interface HoaDonService {

    List<ViewModelHoaDon> getAll(List<ViewModelHoaDon> list);

    List<ViewModelHoaDon> searchHoaDon(String mahd);

    List<ViewModelHoaDon> giaCaoXuongThap(List<ViewModelHoaDon> list);

    List<ViewModelHoaDon> giaThapLenCao(List<ViewModelHoaDon> list);

    List<VIewModelSanPhamHoaDon> getAllSp(String mahd);

    void showData(List<ViewModelHoaDon> list, DefaultTableModel dtm);

    void showData1(List<VIewModelSanPhamHoaDon> list, DefaultTableModel dtm);

    void exportExcel(List<ViewModelHoaDon> list, String name);

    void exportWord(ViewModelHoaDon hd, String file);

    int getSLHoaDonThanhToan();

    int getSLHoaDonChuaThanhToan();

}
