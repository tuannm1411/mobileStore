/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.KhuyenMai;
import ViewModel.KhuyenMaiViewModel;
import java.util.List;

/**
 *
 * @author togia
 */
public interface KhuyenMaiService {

    List<KhuyenMaiViewModel> sget();

    void getAll(List<KhuyenMaiViewModel> list);

    List<KhuyenMaiViewModel> getAllDem(int rowOffset);

    String add(KhuyenMaiViewModel km);

    String delete(String idKM);

    String update(String idKM, KhuyenMaiViewModel km);

    List<KhuyenMaiViewModel> timTheoMa(List<KhuyenMaiViewModel> listKMs, String name);

    List<KhuyenMaiViewModel> listShowDangDienRa(List<KhuyenMaiViewModel> listKhuyenMais);

    List<KhuyenMaiViewModel> listShowSapDienRa(List<KhuyenMaiViewModel> listKhuyenMais);

    List<KhuyenMaiViewModel> listShowDaKT(List<KhuyenMaiViewModel> listKhuyenMais);

    void sapXep(List<KhuyenMaiViewModel> list);

    public void upDateTrangThai();
}
