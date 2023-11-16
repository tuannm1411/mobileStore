/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import Repository.ThongKeKhachHangRepository;
import Service.ThongKeKhachHangService;
import ViewModel.DaMuaViewModel;
import ViewModel.KhachHangViewModel;
import ViewModel.SanPhamDaMuaViewModel;
import ViewModel.SoLanMuaViewModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quanl
 */
public class ThongKeKhachHangServiceImpl implements ThongKeKhachHangService {

    ThongKeKhachHangRepository repo = new ThongKeKhachHangRepository();

    @Override
    public List<SoLanMuaViewModel> getAllSoLanMua(int rowOffset) {
        return repo.getAll(rowOffset);
    }

    @Override
    public void showDataTableSoLan(DefaultTableModel dtm, List<SoLanMuaViewModel> list) {
        dtm.setRowCount(0);
        for (SoLanMuaViewModel khachHangViewModel : list) {
            dtm.addRow(khachHangViewModel.toDataRow());
        }
    }

    @Override
    public List<SoLanMuaViewModel> searchTen(String tenKhachHang, int rowOffset) {
        List<SoLanMuaViewModel> listSearch = new ArrayList<>();
        listSearch = repo.searchTen(tenKhachHang, rowOffset);
        return listSearch;
    }

    @Override
    public List<SoLanMuaViewModel> searchSoLanMua(int soLan, int rowOffset) {
        List<SoLanMuaViewModel> listSearch = new ArrayList<>();
        listSearch = repo.searchSoLuong(soLan, rowOffset);
        return listSearch;
    }

    @Override
    public List<SoLanMuaViewModel> getAllSoLanMuaKPT() {
        return repo.getAllKPT();
    }

    @Override
    public List<SanPhamDaMuaViewModel> getAllSPDM(String imei) {
        return repo.getAllSPDL(imei);
    }

    @Override
    public void showDataTableSPDM(DefaultTableModel dtm, List<SanPhamDaMuaViewModel> list) {
        dtm.setRowCount(0);
        for (SanPhamDaMuaViewModel sanPhamDaMuaViewModel : list) {
            dtm.addRow(sanPhamDaMuaViewModel.toDataRow());
        }
    }

}
