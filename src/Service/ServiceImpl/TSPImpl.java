/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import DomainModel.Camera;
import DomainModel.ChiTietDienThoai;
import DomainModel.DienThoai;
import DomainModel.Dong;
import DomainModel.Hang;
import DomainModel.QuocGia;
import DomainModel.QuocGiaDong;
import Repository.CameraRepon;
import Repository.DienThoaiRepon;
import Repository.DongRepository;
import Repository.HangReponsitory;
import Repository.QuocGiaRepon;
import Repository.SanPhamRespository;
import Repository.ThemSanPhamRepon;
import Service.SanPhamServices;
import Service.ThemSPServices;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haha
 */
public class TSPImpl implements ThemSPServices {

    ThemSanPhamRepon sp = new ThemSanPhamRepon();
    SanPhamServices sps = new SanPhamServicesImpl();

    QuocGiaRepon qgq = new QuocGiaRepon();

    @Override
    public List<QuocGia> getQG(int i) {
        return qgq.getAll(i);
    }

    @Override
    public String themQG(QuocGia qg) {
        for (QuocGia x : qgq.getAll(1)) {
            if (x.getMa().equalsIgnoreCase(qg.getMa())) {
                return "Thêm Không thành công";
            }
        }
        for (QuocGia x : qgq.getAll(0)) {
            if (x.getMa().equalsIgnoreCase(qg.getMa())) {
                return "Thêm Không thành công";
            }
        }
        if (new QuocGiaRepon().add(qg)) {
            return "Thêm thành công";
        }
        return "Thêm Không thành công";

    }

    @Override
    public List<QuocGia> getTimKiem(String i) {
        List<QuocGia> ls = new ArrayList<>();
        for (QuocGia quocGia : qgq.getAll(1)) {
            if (quocGia.getTen().contains(i) || quocGia.getMa().contains(i)) {
                ls.add(quocGia);
            }
        }
        return ls;
    }

    @Override
    public String suaQG(QuocGia qg) {
        if (new QuocGiaRepon().sua(qg)) {
            return "Sửa thành công";
        }
        return "Sửa Không thành công";
    }

    HangReponsitory hangls = new HangReponsitory();

    @Override
    public String themHang(Hang ha) {
        for (Hang x : hangls.getAll(1)) {
            if (x.getMa().equalsIgnoreCase(ha.getMa())) {
                return "Thông tin Mã bị trùng";
            }

        }
        for (Hang x : hangls.getAll(0)) {
            if (x.getMa().equalsIgnoreCase(ha.getMa())) {
                return "Thêm Không thành công";
            }
        }
        if (hangls.add(ha)) {
            return "Thêm thành công";
        }
        return "Thêm Không thành công";
    }

    @Override
    public String suaHang(Hang ha) {
        if (hangls.sua(ha)) {
            return "Sửa thành công";
        }
        return "Sửa Không thành công";
    }

    @Override
    public List<Hang> getHang(int i) {
        return hangls.getAll(i);
    }

    @Override
    public List<Hang> getTimKiemHa(String i) {
        List<Hang> ls = new ArrayList<>();
        for (Hang quocGia : hangls.getAll(1)) {
            if (quocGia.getTen().contains(i) || quocGia.getMa().contains(i)) {
                ls.add(quocGia);
            }
        }
        return ls;
    }
    ThemSanPhamRepon tsp = new ThemSanPhamRepon();

    @Override
    public String themDT(DienThoai ha) {
        for (DienThoai object : new SanPhamRespository().getDT(1, ha.getIdHang())) {
            if (object.getMa().equalsIgnoreCase(ha.getMa())) {
                return "Mã bị trùng";
            }
        }
        for (DienThoai object : new SanPhamRespository().getDT(0, ha.getIdHang())) {
            if (object.getMa().equalsIgnoreCase(ha.getMa())) {
                return "Mã bị trùng";
            }
        }
        if (tsp.ThemDT(ha)) {
            return "nhập thành công";
        }
        return "không nhập được";
    }

    @Override
    public String suaDT(DienThoai ha) {
        if (new DienThoaiRepon().sua(ha)) {
            return "nhập thành công";
        }
        return "không nhập được";
    }

    @Override
    public List<DienThoai> getDT(int i, String idHang) {
        if (idHang.isBlank()) {
            List<DienThoai> s = new ArrayList<>();
            return s;
        }
        return new SanPhamRespository().getDT(i, idHang);
    }

    @Override
    public List<DienThoai> getTimKiemDT(String i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override

    public String themQGD(QuocGiaDong ha) {
        if (new ThemSanPhamRepon().ThemQGD(ha)) {
            return "nhập thành công";
        }
        return "không nhập được";
    }

    @Override
    public String themCTDT(ChiTietDienThoai ha) {
        if (new ThemSanPhamRepon().ThemCTDT(ha)) {
            return "nhập thành công";
        }
        return "không nhập được";
    }

    @Override
    public String themDong(Dong ha) {
        if (ha == null) {
            return "không được để trống thông tin";
        }
        for (Dong object : new SanPhamRespository().getDong(0, ha.getIdDienThoai())) {
            if (object.getMa().contains(ha.getMa())) {
                return "Thông tin mã bị trùng";
            }
        }
        for (Dong object : new SanPhamRespository().getDong(1, ha.getIdDienThoai())) {
            if (object.getMa().contains(ha.getMa())) {
                return "Thông tin mã bị trùng";
            }
        }
        if (new DongRepository().add(ha)) {
            return "Thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String timKiem(QuocGiaDong ha) {
        for (QuocGia quocGia : new QuocGiaRepon().getAll(1)) {
            if (quocGia.equals(ha)) {
                return quocGia.getId();
            }
        }
        return null;
    }

    @Override
    public List<Camera> getCamera(int x) {
        return new CameraRepon().getCamera(x);
    }

    @Override
    public String themCamera(Camera tk) {
        if (tk == null) {
            return "Không được để trống thông tin";
        } else if (new CameraRepon().ThemCamera(tk)) {
            return "Thêm thành cônng";
        }
        return "Thêm thất bại";
    }

    @Override
    public String suaCamera(Camera tk) {
        if (tk == null) {
            return "Không được để trống thông tin";
        } else if (new CameraRepon().ThemCamera(tk)) {
            return "sửa thành cônng";
        }
        return "Sửa thất bại";
    }

    @Override
    public String xoaCamera(Camera tk, int x) {
        if (tk == null) {
            return "Không được để trống thông tin";
        } else if (new CameraRepon().xoaCamera(tk, x)) {
            return "sửa thành cônng";
        }
        return "Sửa thất bại";
    }

    @Override
    public String suaDong(Dong ha) {
        if (new SanPhamRespository().suaDong(ha)) {
            return "Sửa thành công";
        }
        return "Sửa thất bại";
    }

    @Override
    public String xoaDong(Dong ha, int tt) {
        if (new SanPhamRespository().xoaDong(ha, tt)) {
            return "Sửa thành công";
        }
        return "Sửa thất bại";
    }

    @Override
    public List<Dong> getDong(int i, String idHang) {
        if (idHang.isBlank()) {
            List<Dong> s = new ArrayList<>();
            return s;
        }
        return new SanPhamRespository().getDong(i, idHang);
    }

}
