/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import DomainModel.ChiTietDienThoai;
import DomainModel.QuocGiaDong;
import DomainModel.ThongSo;
import Repository.SanPhamRespository;
import Repository.ThemSanPhamRepon;
import Service.AddElementServices;
import ViewModel.ThongSoViewModel;
import ViewModel.vts;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haha
 */
public class AddElementImpl implements AddElementServices {

    @Override
    public List<vts> view(ThongSoViewModel t) {
        List<vts> ttList = new ArrayList<>();
        ttList.removeAll(ttList);
        ttList.add(new vts("-------------- BỘ NHỚ --------------", null));
        ttList.add(new vts("RAM", t.getRam()));
        ttList.add(new vts("ROM", t.getRom()));
        ttList.add(new vts("Thẻ nhớ", t.getTheNho()));
        ttList.add(new vts("------------- VI XỬ LÝ -------------", null));
        ttList.add(new vts("CPU", t.getCPU()));
        ttList.add(new vts("GPU", t.getGPU()));
        ttList.add(new vts("Loại CPU", t.getCPULoai()));
        ttList.add(new vts("Hãng CPU", t.getCPUHang()));
        ttList.add(new vts("Tiến trình", t.getTienTrinh()));
        ttList.add(new vts("---------------- PIN ---------------", null));
        ttList.add(new vts("Dung lượng Pin", t.getPinDungLuong()));
        ttList.add(new vts("Loại Pin", t.getPinLoai()));
        ttList.add(new vts("Sạc", t.getSac()));
        ttList.add(new vts("Đặc biệt", t.getPindacBiet()));
        ttList.add(new vts("----------- HỆ ĐIỀU HÀNH -----------", null));
        ttList.add(new vts("Hệ điều hành", t.getHeDieuhanh()));
        ttList.add(new vts("Phiên bản", t.getHDHphienBan()));
        ttList.add(new vts("------------- THIẾT KẾ -------------", null));
        ttList.add(new vts("Mặt trước", t.getMatTruoc()));
        ttList.add(new vts("Mặt Lưng", t.getMatLung()));
        ttList.add(new vts("Khung viền", t.getKhungVien()));
        ttList.add(new vts("Trọng lượng", t.getTrongLuong()));
        ttList.add(new vts("------------- MÀN HÌNH -------------", null));
        ttList.add(new vts("Kích thước màn hình", t.getManHinhKichThuoc()));
        ttList.add(new vts("Loại màn hình", t.getManHinhLoai()));
        ttList.add(new vts("Kiểu màn hình", t.getManHinhKieu()));
        ttList.add(new vts("Tầng số quét", t.getTangSoQuet()));
        ttList.add(new vts("Độ phân giải", t.getDoPhanGiai()));
        ttList.add(new vts("Công nghệ màn hình", t.getManHinhCongNghe()));
        ttList.add(new vts("-------------- KẾT NỐI -------------", null));
        ttList.add(new vts("SIM", t.getSIM()));
        ttList.add(new vts("Cổng hồng ngoại", t.getHongNgoai()));
        ttList.add(new vts("Jack tai nghe", t.getJackTaiNghe()));
        ttList.add(new vts("Mạng hỗ trợ", t.getMangHoTro()));
        ttList.add(new vts("Wifi", t.getWifi()));
        ttList.add(new vts("Blutooth", t.getBlutooth()));
        ttList.add(new vts("GPS", t.getGPS()));
        ttList.add(new vts("-------------- MÀU SẮC -------------", null));
        ttList.add(new vts("Màu sắc", t.getMauTen()));
        ttList.add(new vts("Mã màu", t.getMauMa()));
        ttList.add(new vts("---------- TIỆN ÍCH ĐI KÈM ---------", null));
        ttList.add(new vts("Bảo mật", t.getBaoMat()));
        ttList.add(new vts("Kháng nước", t.getKhangNuoc()));
        ttList.add(new vts("Đặc biệt", t.getDacBiet()));
        ttList.add(new vts("-------------- CAMERA --------------", null));
        ttList.add(new vts("Camera trước", t.getCameraTruoc()));
        ttList.add(new vts("Camera sau", t.getCameraSau()));
        ttList.add(new vts("Quay video", t.getQuayVideo()));
        ttList.add(new vts("MAX Zoom", t.getZoom()));
        ttList.add(new vts("Chống rung", t.getChongRung()));
        ttList.add(new vts("Đặc biệt", t.getCameraDacBiet()));

        return ttList;

    }
    TSPImpl sp = new TSPImpl();

    @Override
    public String themThongSo(ThongSo t) {
        if (new ThemSanPhamRepon().ThemSP(t)) {
            return "Thêm thành công";
        }
        return "Thêm không thành công";

    }

    @Override
    public String themQuocGiaDong(QuocGiaDong qgd) {
        for (QuocGiaDong quocGiaDong : new ThemSanPhamRepon().getQGD()) {
            if (quocGiaDong.getIdDong().equalsIgnoreCase(qgd.getIdDong()) && quocGiaDong.getIdQuocGia().equalsIgnoreCase(qgd.getIdQuocGia())) {
                return "Thêm không thành công dòng sản phẩm này đã tồn tại ở ";
            }
        }
        if (new ThemSanPhamRepon().ThemQGD(qgd)) {
            return "";
        }
        return "Thêm không thành công";
    }

    @Override
    public String idQGD(QuocGiaDong qgd) {
        for (QuocGiaDong quocGiaDong : new ThemSanPhamRepon().getQGD()) {
            if (quocGiaDong.getIdDong().equalsIgnoreCase(qgd.getIdDong()) && quocGiaDong.getIdQuocGia().equalsIgnoreCase(qgd.getIdQuocGia())) {
                return quocGiaDong.getId();
            }
        }
        return "";
    }

    @Override
    public List<QuocGiaDong> getf(String x) {
        return new ThemSanPhamRepon().getQGD2(x);
    }

    @Override
    public String xoaQG(String id, int tt) {
        return new SanPhamRespository().XoaQ(id, tt);

    }

    @Override
    public String xoaCTDT(String id) {
        return new SanPhamRespository().XoaDTCT(id);
    }

    @Override
    public String suaThongSo(ThongSo t) {
        if (new SanPhamRespository().capNhat(t)) {
            return "thành công";
        }
        return "thất bại";
    }

    @Override
    public String giaTien1(ChiTietDienThoai t) {
        if (new SanPhamRespository().idTS(t)) {
            return "thành công";
        }
        return "thất bại";
    }

    @Override
    public String giaTien2(QuocGiaDong t) {
   if (new SanPhamRespository().idST(t)) {
            return "thành công";
        }
        return "thất bại";    }


}
