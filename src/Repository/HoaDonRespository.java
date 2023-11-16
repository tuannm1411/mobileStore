/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import ViewModel.ViewModelHoaDon;
import java.util.List;
import Ultilities.SQLServerConnection;
import ViewModel.VIewModelSanPhamHoaDon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class HoaDonRespository {

    public List<ViewModelHoaDon> getAllHoaDon() {

        String query = "select HoaDon.ma_hoa_don,NhanVien.ten_nhan_vien,KhachHang.ten_khach_hang,HoaDon.ngay_tao,\n"
                + "KhuyenMai.ma_khuyen_mai,\n"
                + "HoaDon.trang_thai, IIF(KhuyenMai.gia_giam > 1000, KhuyenMai.gia_giam, \n"
                + "sum(QuocGiaDong.gia_ban)*(KhuyenMai.gia_giam / 100)) as 'GiaGiam',\n"
                + "IIF(KhuyenMai.gia_giam > 1000, sum(QuocGiaDong.gia_ban) - KhuyenMai.gia_giam,(sum(QuocGiaDong.gia_ban)) - sum(QuocGiaDong.gia_ban)*(KhuyenMai.gia_giam / 100)) as 'TongTien',\n"
                + "count(HoaDonChiTiet.IMEI) as 'Tong so San pham'\n"
                + "from HoaDon left join NhanVien on HoaDon.id_nhan_vien = NhanVien.id\n"
                + "left join KhachHang on HoaDon.id_khach_hang = KhachHang.id\n"
                + "full join HoaDonChiTiet on HoaDon.id = HoaDonChiTiet.id_hoa_don\n"
                + "left join ChiTietDienThoai on HoaDonChiTiet.IMEI = ChiTietDienThoai.IMEI\n"
                + "left join QuocGiaDong on ChiTietDienThoai.id_quoc_gia_dong = QuocGiaDong.id\n"
                + "left join KhuyenMai on HoaDon.id_khuyen_mai = KhuyenMai.id\n"
                + "group by HoaDon.ma_hoa_don,NhanVien.ten_nhan_vien,KhachHang.ten_khach_hang,\n"
                + "HoaDon.ngay_tao,KhuyenMai.ma_khuyen_mai,HoaDon.trang_thai,KhuyenMai.gia_giam\n"
                + "order by HoaDon.ngay_tao";
        List<ViewModelHoaDon> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ViewModelHoaDon view = new ViewModelHoaDon(rs.getString("ma_hoa_don"), rs.getString("ten_nhan_vien"),
                        rs.getString("ten_khach_hang"), rs.getString("ngay_tao"),
                        rs.getString("ma_khuyen_mai"), rs.getInt("trang_thai"),
                        rs.getInt("Tong so San pham"), rs.getDouble("GiaGiam"), rs.getDouble("TongTien"));
                list.add(view);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public List<VIewModelSanPhamHoaDon> getAllSanPham(String mahd) {
        String query = "select DienThoai.ma_dien_thoai,HoaDon.ma_hoa_don,\n"
                + "DienThoai.ten_dien_thoai,Hang.ten_hang,Dong.ten_dong,\n"
                + "QuocGiaDong.gia_ban,ChiTietDienThoai.moi,ChiTietDienThoai.mo_ta\n"
                + "from HoaDon join HoaDonChiTiet on HoaDon.id = HoaDonChiTiet.id_hoa_don\n"
                + "full join ChiTietDienThoai on HoaDonChiTiet.IMEI = ChiTietDienThoai.IMEI\n"
                + "full join QuocGiaDong on ChiTietDienThoai.id_quoc_gia_dong = QuocGiaDong.id\n"
                + "full join Dong on QuocGiaDong.id_dong = Dong.id\n"
                + "full join DienThoai on Dong.id_dien_thoai = DienThoai.id\n"
                + "full join Hang on DienThoai.id_hang = Hang.id where HoaDon.ma_hoa_don like ?\n"
                + "order by DienThoai.ma_dien_thoai";

        List<VIewModelSanPhamHoaDon> list = new ArrayList<>();
        String a = "%" + mahd + "%";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareCall(query);) {
            ps.setObject(1, a);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                VIewModelSanPhamHoaDon view = new VIewModelSanPhamHoaDon(rs.getString("ma_dien_thoai"),
                        rs.getString("ma_hoa_don"), rs.getString("ten_dien_thoai"),
                        rs.getString("ten_hang"), rs.getString("ten_dong"),
                        rs.getDouble("gia_ban"), rs.getInt("moi"), rs.getString("mo_ta"));
                list.add(view);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<ViewModelHoaDon> giaCaoXuongThap() {
        String query = "select HoaDon.ma_hoa_don,NhanVien.ten_nhan_vien,KhachHang.ten_khach_hang,HoaDon.ngay_tao,\n"
                + "KhuyenMai.ma_khuyen_mai,\n"
                + "HoaDon.trang_thai, IIF(KhuyenMai.gia_giam > 1000, KhuyenMai.gia_giam, \n"
                + "sum(QuocGiaDong.gia_ban)*(KhuyenMai.gia_giam / 100)) as 'GiaGiam',\n"
                + "IIF(KhuyenMai.gia_giam > 1000, sum(QuocGiaDong.gia_ban) - KhuyenMai.gia_giam,(sum(QuocGiaDong.gia_ban)) - sum(QuocGiaDong.gia_ban)*(KhuyenMai.gia_giam / 100)) as 'TongTien',\n"
                + "count(HoaDonChiTiet.IMEI) as 'Tong so San pham'\n"
                + "from HoaDon left join NhanVien on HoaDon.id_nhan_vien = NhanVien.id\n"
                + "left join KhachHang on HoaDon.id_khach_hang = KhachHang.id\n"
                + "full join HoaDonChiTiet on HoaDon.id = HoaDonChiTiet.id_hoa_don\n"
                + "left join ChiTietDienThoai on HoaDonChiTiet.IMEI = ChiTietDienThoai.IMEI\n"
                + "left join QuocGiaDong on ChiTietDienThoai.id_quoc_gia_dong = QuocGiaDong.id\n"
                + "left join KhuyenMai on HoaDon.id_khuyen_mai = KhuyenMai.id\n"
                + "group by HoaDon.ma_hoa_don,NhanVien.ten_nhan_vien,KhachHang.ten_khach_hang,\n"
                + "HoaDon.ngay_tao,KhuyenMai.ma_khuyen_mai,HoaDon.trang_thai,KhuyenMai.gia_giam\n"
                + "order by IIF(KhuyenMai.gia_giam > 1000, sum(QuocGiaDong.gia_ban) - KhuyenMai.gia_giam,(sum(QuocGiaDong.gia_ban)) - sum(QuocGiaDong.gia_ban)*(KhuyenMai.gia_giam / 100)) desc";

        List<ViewModelHoaDon> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ViewModelHoaDon hd = new ViewModelHoaDon(rs.getString("ma_hoa_don"), rs.getString("ten_nhan_vien"),
                        rs.getString("ten_khach_hang"), rs.getString("ngay_tao"),
                        rs.getString("ma_khuyen_mai"), rs.getInt("trang_thai"),
                        rs.getInt("Tong so San pham"), rs.getDouble("GiaGiam"), rs.getDouble("TongTien"));
                list.add(hd);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public List<ViewModelHoaDon> giaThapLenCao() {
        String query = "select HoaDon.ma_hoa_don,NhanVien.ten_nhan_vien,KhachHang.ten_khach_hang,HoaDon.ngay_tao,\n"
                + "KhuyenMai.ma_khuyen_mai,\n"
                + "HoaDon.trang_thai, IIF(KhuyenMai.gia_giam > 1000, KhuyenMai.gia_giam, \n"
                + "sum(QuocGiaDong.gia_ban)*(KhuyenMai.gia_giam / 100)) as 'GiaGiam',\n"
                + "IIF(KhuyenMai.gia_giam > 1000, sum(QuocGiaDong.gia_ban) - KhuyenMai.gia_giam,(sum(QuocGiaDong.gia_ban)) - sum(QuocGiaDong.gia_ban)*(KhuyenMai.gia_giam / 100)) as 'TongTien',\n"
                + "count(HoaDonChiTiet.IMEI) as 'Tong so San pham'\n"
                + "from HoaDon left join NhanVien on HoaDon.id_nhan_vien = NhanVien.id\n"
                + "left join KhachHang on HoaDon.id_khach_hang = KhachHang.id\n"
                + "full join HoaDonChiTiet on HoaDon.id = HoaDonChiTiet.id_hoa_don\n"
                + "left join ChiTietDienThoai on HoaDonChiTiet.IMEI = ChiTietDienThoai.IMEI\n"
                + "left join QuocGiaDong on ChiTietDienThoai.id_quoc_gia_dong = QuocGiaDong.id\n"
                + "left join KhuyenMai on HoaDon.id_khuyen_mai = KhuyenMai.id\n"
                + "group by HoaDon.ma_hoa_don,NhanVien.ten_nhan_vien,KhachHang.ten_khach_hang,\n"
                + "HoaDon.ngay_tao,KhuyenMai.ma_khuyen_mai,HoaDon.trang_thai,KhuyenMai.gia_giam\n"
                + "order by IIF(KhuyenMai.gia_giam > 1000, sum(QuocGiaDong.gia_ban) - KhuyenMai.gia_giam,(sum(QuocGiaDong.gia_ban)) - sum(QuocGiaDong.gia_ban)*(KhuyenMai.gia_giam / 100)) asc";
        List<ViewModelHoaDon> list = new ArrayList<>();

        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ViewModelHoaDon hd = new ViewModelHoaDon(rs.getString("ma_hoa_don"), rs.getString("ten_nhan_vien"),
                        rs.getString("ten_khach_hang"), rs.getString("ngay_tao"),
                        rs.getString("ma_khuyen_mai"), rs.getInt("trang_thai"),
                        rs.getInt("Tong so San pham"), rs.getDouble("GiaGiam"), rs.getDouble("TongTien"));
                list.add(hd);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<ViewModelHoaDon> searchHoaDon(String mahd) {

        String query = "select HoaDon.ma_hoa_don,NhanVien.ten_nhan_vien,KhachHang.ten_khach_hang,HoaDon.ngay_tao,\n"
                + "KhuyenMai.ma_khuyen_mai,\n"
                + "HoaDon.trang_thai, IIF(KhuyenMai.gia_giam > 1000, KhuyenMai.gia_giam, \n"
                + "sum(QuocGiaDong.gia_ban)*(KhuyenMai.gia_giam / 100)) as 'GiaGiam',\n"
                + "IIF(KhuyenMai.gia_giam > 1000, sum(QuocGiaDong.gia_ban) - KhuyenMai.gia_giam,(sum(QuocGiaDong.gia_ban)) - sum(QuocGiaDong.gia_ban)*(KhuyenMai.gia_giam / 100)) as 'TongTien',\n"
                + "count(HoaDonChiTiet.IMEI) as 'Tong so San pham'\n"
                + "from HoaDon left join NhanVien on HoaDon.id_nhan_vien = NhanVien.id\n"
                + "left join KhachHang on HoaDon.id_khach_hang = KhachHang.id\n"
                + "full join HoaDonChiTiet on HoaDon.id = HoaDonChiTiet.id_hoa_don\n"
                + "left join ChiTietDienThoai on HoaDonChiTiet.IMEI = ChiTietDienThoai.IMEI\n"
                + "left join QuocGiaDong on ChiTietDienThoai.id_quoc_gia_dong = QuocGiaDong.id\n"
                + "left join KhuyenMai on HoaDon.id_khuyen_mai = KhuyenMai.id\n"
                + "where HoaDon.ma_hoa_don like ?\n"
                + "group by HoaDon.ma_hoa_don,NhanVien.ten_nhan_vien,KhachHang.ten_khach_hang,\n"
                + "HoaDon.ngay_tao,KhuyenMai.ma_khuyen_mai,HoaDon.trang_thai,KhuyenMai.gia_giam\n"
                + "order by HoaDon.ngay_tao";

        List<ViewModelHoaDon> listSearch = new ArrayList<>();
        String a = "%" + mahd + "%";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareCall(query);) {
            ps.setObject(1, a);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ViewModelHoaDon hd = new ViewModelHoaDon(rs.getString("ma_hoa_don"), rs.getString("ten_nhan_vien"),
                        rs.getString("ten_khach_hang"), rs.getString("ngay_tao"),
                        rs.getString("ma_khuyen_mai"), rs.getInt("trang_thai"),
                        rs.getInt("Tong so San pham"), rs.getDouble("GiaGiam"), rs.getDouble("TongTien"));
                listSearch.add(hd);
            }
            return listSearch;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int getHoaDonChuaThanhToan() {
        int count = 0;
        String query = "select count(HoaDon.ma_hoa_don) as 'ChuaThanhToan' from HoaDon where trang_thai = 0 ";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareCall(query);) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 count = rs.getInt("ChuaThanhToan");
            }
           
            return count;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return count;
    }

    public int getHoaDonDaThanhToan() {
        int count = 0;
        String query = "select count(HoaDon.ma_hoa_don) as 'DaThanhToan' from HoaDon where trang_thai =1";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareCall(query);) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                count = rs.getInt("DaThanhToan");
            }
            
            return count;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return count;
    }

}
