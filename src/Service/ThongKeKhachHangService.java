/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModel.DaMuaViewModel;
import ViewModel.KhachHangViewModel;
import ViewModel.SanPhamDaMuaViewModel;
import ViewModel.SoLanMuaViewModel;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quanl
 */
public interface ThongKeKhachHangService {

    List<SoLanMuaViewModel> getAllSoLanMua(int rowOffset);

    List<SoLanMuaViewModel> getAllSoLanMuaKPT();

    List<SanPhamDaMuaViewModel> getAllSPDM(String imei);

    void showDataTableSoLan(DefaultTableModel dtm, List<SoLanMuaViewModel> list);

    void showDataTableSPDM(DefaultTableModel dtm, List<SanPhamDaMuaViewModel> list);

    List<SoLanMuaViewModel> searchTen(String tenKhachHang, int rowOffset);

    List<SoLanMuaViewModel> searchSoLanMua(int soLan, int rowOffset);
}
