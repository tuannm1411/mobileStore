/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.KhachHang;
import ViewModel.KhachHangViewModel;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quanl
 */
public interface KhachHangService {

    List<KhachHangViewModel> getAllKhachHang(int rowOffset);

    List<KhachHangViewModel> getAllKhachHang1();

    List<KhachHangViewModel> searchKhachHang(String tenKhachHang, int rowOffset);

    List<KhachHangViewModel> searchKhachHangDiaChi(String diaChiKhachHang, int rowOffset);

    List<KhachHangViewModel> searchKhachHangSDT(String sdt, int rowOffset);

    void showDataTable(DefaultTableModel dtm, List<KhachHangViewModel> list);

    String addKhachHang(KhachHang kh);

    String editKhachHang(KhachHang kh, String id);

    String deleteKhachHang(String id);
}
