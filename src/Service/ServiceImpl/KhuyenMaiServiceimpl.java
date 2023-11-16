/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import DomainModel.KhuyenMai;
import Repository.KhuyenMaiResponsitory;
import Service.KhuyenMaiService;
import ViewModel.KhuyenMaiViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author togia
 */
public class KhuyenMaiServiceimpl implements KhuyenMaiService {

    private KhuyenMaiResponsitory rs = new KhuyenMaiResponsitory();

    @Override
    public String add(KhuyenMaiViewModel km) {
        List<KhuyenMaiViewModel> list = new ArrayList<>();
        list.addAll(rs.getAllvali(km.getMa()));

        if (km.getMa().isEmpty()) {
            return "Mã Khuyến mại không được để trống ";
        }
        if (km.getMoTa().isEmpty()) {
            return "Mô tả không được để trống";
        }
        if (String.valueOf(km.getGiaGiam()).isEmpty()) {
            return "Mô tả không được để trống";
        }
        if (list.size() > 0) {
            return "Mã khuyến mại bị trùng";
        }
        if (km.getNgayKetThuc().getYear() < km.getNgayBatDau().getYear()) {
            return "Năm bắt đầu nhỏ hơn hoặc bằng năm kết thúc  ";
        } else if (km.getNgayKetThuc().getMonth() < km.getNgayBatDau().getMonth()) {
            return "Tháng bắt đầu phải nhỏ hơn hoặc bằng tháng kết thúc ";
        } else if (km.getNgayKetThuc().getDate() < km.getNgayBatDau().getDate()) {
            return "Ngày bắt đầu phải nhỏ hơn hoặc bằng ngày kết thúc ";
        }
        boolean add = rs.add(km);
        if (add == true) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }

    }

    @Override
    public String delete(String idKM
    ) {
        boolean delete = rs.delete(idKM);
        if (delete == true) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public void getAll(List<KhuyenMaiViewModel> list
    ) {
        list.addAll(rs.getAll());

    }

    @Override
    public String update(String idKM, KhuyenMaiViewModel km
    ) {
        boolean update = rs.update(km, idKM);
        if (update == true) {
            return "Sửa thành công";
        } else {
            return "Sủa thất bại";
        }
    }

    @Override
    public List<KhuyenMaiViewModel> timTheoMa(List<KhuyenMaiViewModel> listKMs, String ma
    ) {
        List<KhuyenMaiViewModel> listSearch = new ArrayList<>();
        for (KhuyenMaiViewModel km : listKMs) {
            if (km.getMa().contains(ma)) {
                listSearch.add(km);
            } else {

            }

        }

        return listSearch;
    }

    @Override
    public List<KhuyenMaiViewModel> listShowDangDienRa(List<KhuyenMaiViewModel> listKhuyenMais
    ) {
        List<KhuyenMaiViewModel> listShowDangDienRa = new ArrayList<>();
        for (KhuyenMaiViewModel KM : listKhuyenMais) {
            if (KM.getTrangThai() == 0) {
                listShowDangDienRa.add(KM);
            }
        }
        return listShowDangDienRa;
    }

    @Override
    public List<KhuyenMaiViewModel> listShowSapDienRa(List<KhuyenMaiViewModel> listKhuyenMais
    ) {
        List<KhuyenMaiViewModel> listShowSapDienRa = new ArrayList<>();
        for (KhuyenMaiViewModel KM : listKhuyenMais) {
            if (KM.getTrangThai() == 1) {
                listShowSapDienRa.add(KM);
            }
        }
        return listShowSapDienRa;
    }

    @Override
    public List<KhuyenMaiViewModel> listShowDaKT(List<KhuyenMaiViewModel> listKhuyenMais
    ) {
        List<KhuyenMaiViewModel> listShowDaKT = new ArrayList<>();
        for (KhuyenMaiViewModel KM : listKhuyenMais) {
            if (KM.getTrangThai() == 2) {
                listShowDaKT.add(KM);
            }

        }
        return listShowDaKT;
    }

    @Override
    public List<KhuyenMaiViewModel> sget() {
        return rs.getAll();
    }

    @Override
    public void sapXep(List<KhuyenMaiViewModel> list
    ) {
        list.sort((o1, o2) -> {
            return o1.getGiaGiam().compareTo(o2.getGiaGiam());
        });
    }

    @Override
    public List<KhuyenMaiViewModel> getAllDem(int soDem
    ) {

        return rs.getAllDem(soDem);

    }

    @Override
    public void upDateTrangThai() {
        rs.upDateTrangThai();
    }

}
