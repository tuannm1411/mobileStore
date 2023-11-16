/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import DomainModel.ChucVu;
import DomainModel.NhanVien;
import Repository.ChucVuRepository;
import Repository.LoginRepository;
import Repository.NhanVienRepository;
import Service.NhanVienService;
import ViewModel.CMNDViewModel;
import ViewModel.CheckEmail;
import ViewModel.CheckSDT;
import ViewModel.NhanVienView;
import ViewModel.ThongTinNguoiDungView;
import ViewModel.checkTrungManv;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author buiti
 */
public class NhanVienServiceImpl implements NhanVienService {

    NhanVienRepository Nvrp = new NhanVienRepository();

    @Override
    public List<NhanVienView> getAll() {
        return new NhanVienRepository().getAll();
    }

    @Override
    public void showData(DefaultTableModel dtm, List<NhanVienView> list) {
        dtm.setRowCount(0);
        for (NhanVienView nhanVienView : list) {
            dtm.addRow(nhanVienView.toData());

        }
    }

    @Override
    public List<String> ChucVuCBB() {
        List<String> cbb = new ArrayList<>();
        ChucVuRepository cv = new ChucVuRepository();
        List<ChucVu> fullCH = cv.getAll();
        for (ChucVu chucVu : fullCH) {
            cbb.add(chucVu.getTen());
        }
        return cbb;
    }

    @Override
    public List<String> IDChucVu() {
        List<String> cbb = new ArrayList<>();
        ChucVuRepository cv = new ChucVuRepository();
        List<ChucVu> fullCH = cv.getAll();
        for (ChucVu chucVu : fullCH) {
            cbb.add(chucVu.getId());
        }
        return cbb;
    }

    @Override
    public String dangKi(NhanVien nv) {

        if (Nvrp.addNV(nv)) {
            return "them thanh cong";
        }

        return "them that bai";
    }

    @Override
    public String update(NhanVien nv, String id) {
        boolean update = Nvrp.updateSVDiem(nv, id);
        if (update == true) {
            return "Cập nhật thành công";
        } else {
            return "Cập nhật thất bại";
        }
    }

    @Override
    public String chuyenTTNV(String id) {
        boolean cTT = Nvrp.chuyenTTNV(id);
        if (cTT == true) {
            return "Cập nhật thành công";
        } else {
            return "Cập nhật thất bại";
        }
    }

    @Override
    public List<NhanVien> getAlls() {
        return new NhanVienRepository().getAlls();
    }

    @Override
    public List<NhanVienView> searchNhanVien(String tenNhanVien) {
        List<NhanVienView> listSearch = new ArrayList<>();
        listSearch = Nvrp.searchNhanVien(tenNhanVien);
        return listSearch;
    }

    @Override
    public List<NhanVienView> searchsdt(String sdt) {
        List<NhanVienView> listSearch = new ArrayList<>();
        listSearch = Nvrp.searchNhanVienSDT(sdt);
        return listSearch;
    }

    @Override
    public List<NhanVienView> getAllNhanVienSearch(int rowOffset) {
        return Nvrp.getAllNhanVienSearch(rowOffset);
    }

    @Override
    public List<ThongTinNguoiDungView> layThongTin(String ma) {
        List<ThongTinNguoiDungView> listSearch = new ArrayList<>();
        listSearch = Nvrp.layThongTin(ma);
        return listSearch;
    }

    @Override
    public void checkTrungIMEI(String maHD, List<checkTrungManv> list) {
        list.addAll(Nvrp.getAllHoaDonCheckTrung(maHD));
    }

    @Override
    public void checkTrungCMND(String cmnd, List<CMNDViewModel> list) {
        list.addAll(Nvrp.getAllCheckTrungCMND(cmnd));
    }
    

    @Override
    public void checkTrungsdt(String sdt, List<CheckSDT> list) {
        list.addAll(Nvrp.getAllCheckTrungsdt(sdt));
    }

    @Override
    public List<NhanVienView> searchcmnd(String cmnd) {
 List<NhanVienView> listSearch = new ArrayList<>();
        listSearch = Nvrp.searchNhanViencmnd(cmnd);
        return listSearch;    }

    @Override
    public List<NhanVienView> searchMaNV(String maNV) {
          List<NhanVienView> listSearch = new ArrayList<>();
        listSearch = Nvrp.searchNhanVienMaNV(maNV);
        return listSearch;
    }

    @Override
    public void checkTrungEmail(String email, List<CheckEmail> list) {
          list.addAll(Nvrp.getAllCheckTrunggEmail(email));
    }

}
