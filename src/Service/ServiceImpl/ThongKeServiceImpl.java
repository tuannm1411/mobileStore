/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import DomainModel.HoaDon;
import Repository.KhachHangRepository;
import Repository.ThongKeRespository;
import Service.ThongKeService;
import ViewModel.KhachHangViewModel;
import ViewModel.ThongKeViewModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class ThongKeServiceImpl implements ThongKeService {
    
   
    ThongKeRespository thongKeRopo = new ThongKeRespository();
    
   
    
   
    @Override
    public List<ThongKeViewModel> getLisst() {
        return thongKeRopo.getLisstTK();
    }
    
    @Override
    public List<HoaDon> searchTheoNgay(String ngay) {
        
        return thongKeRopo.searchTheoNgay(ngay);
    }
    
    @Override
    public void showDaTa(DefaultTableModel dtm, List<ThongKeViewModel> listTK) {
        dtm.setRowCount(0);
        for (ThongKeViewModel b : listTK) {
            dtm.addRow(b.toDaTaRow());
            
        }
    }
    
    @Override
    public List<ThongKeViewModel> searchNgay(String Ngay, List<ThongKeViewModel> listTK) {
        List<ThongKeViewModel> listSearch = new ArrayList<>();
        listSearch = thongKeRopo.searchNgay(Ngay);
        return listSearch;
    }
    
    @Override
    public List<ThongKeViewModel> searchThang(String Thang,String nam, List<ThongKeViewModel> listTKK) {
        List<ThongKeViewModel> listSearch = new ArrayList<>();
        listSearch = thongKeRopo.searchThang(Thang,nam);
        return listSearch;
    }
    
    @Override
    public List<ThongKeViewModel> searchNam(String Nam, List<ThongKeViewModel> listNam) {
        List<ThongKeViewModel> listSearch = new ArrayList<>();
        listSearch = thongKeRopo.searchNam(Nam);
        return listSearch;
    }
    
    @Override
    public List<ThongKeViewModel> searchNgayThangNam(String NTN, List<ThongKeViewModel> listNTN) {
        List<ThongKeViewModel> listSearch = new ArrayList<>();
        listSearch = thongKeRopo.searchNTN(NTN);
        return listSearch;
    }
    
}
