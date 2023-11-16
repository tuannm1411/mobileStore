/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.HoaDon;
import Ultilities.SQLServerConnection;
import ViewModel.KhachHangViewModel;
import ViewModel.ThongKeViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ThongKeRespository {

    public List<HoaDon> searchTheoNgay(String ngay) {
        String query = "SELECT [id]\n"
                + "      ,[ma_hoa_don]\n"
                + "      ,[ngay_tao]\n"
                + "      ,[id_nhan_vien]\n"
                + "      ,[id_khach_hang]\n"
                + "      ,[id_khuyen_mai]\n"
                + "      ,[mo_ta]\n"
                + "      ,[trang_thai]\n"
                + "  FROM [dbo].[HoaDon]\n"
                + "  WHERE DAY(ngay_tao) like ?";
        List<HoaDon> listHoaDon = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {

            ps.setObject(1, ngay);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setId(rs.getString(1));
                hd.setMaHoaDon(rs.getString(2));
                hd.setNgayTao(rs.getDate(3));
                listHoaDon.add(hd);

            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return listHoaDon;
    }

    public List<ThongKeViewModel> getLisstTK() {

        String query = "SELECT ChiTietDienThoai.IMEI,ma_hoa_don,ngay_tao,gia_ban,gia_giam,gia_nhap\n"
                + "                FROM HoaDon JOIN HoaDonChiTiet on HoaDon.id = HoaDonChiTiet.id_hoa_don\n"
                + "               join ChiTietDienThoai on  ChiTietDienThoai.IMEI =HoaDonChiTiet.IMEI \n"
                + "                join QuocGiaDong on ChiTietDienThoai.id_quoc_gia_dong = QuocGiaDong.id\n"
                + "               join  KhuyenMai on HoaDon.id_khuyen_mai = KhuyenMai.id";
        List<ThongKeViewModel> listthongKe = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ThongKeViewModel thongKe = new ThongKeViewModel(rs.getString(1), rs.getString(2),
                        rs.getDate(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6));

                listthongKe.add(thongKe);

            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return listthongKe;
    }

    public List<ThongKeViewModel> searchNgay(String id) {
        String query = "SELECT ChiTietDienThoai.IMEI,ma_hoa_don,ngay_tao,gia_ban,gia_giam,gia_nhap\n"
                + "                FROM HoaDon JOIN HoaDonChiTiet on HoaDon.id = HoaDonChiTiet.id_hoa_don\n"
                + "               join ChiTietDienThoai on  ChiTietDienThoai.IMEI =HoaDonChiTiet.IMEI \n"
                + "                join QuocGiaDong on ChiTietDienThoai.id_quoc_gia_dong = QuocGiaDong.id\n"
                + "               join  KhuyenMai on HoaDon.id_khuyen_mai = KhuyenMai.id\n"
                + " where ngay_tao  = ?";
        List<ThongKeViewModel> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ThongKeViewModel thongKe = new ThongKeViewModel(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6));
                list.add(thongKe);

            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public List<ThongKeViewModel> searchThang(String thang, String nam) {
        String query = "SELECT ChiTietDienThoai.IMEI,ma_hoa_don,ngay_tao,gia_ban,gia_giam,gia_nhap\n"
                + "                FROM HoaDon JOIN HoaDonChiTiet on HoaDon.id = HoaDonChiTiet.id_hoa_don\n"
                + "               join ChiTietDienThoai on  ChiTietDienThoai.IMEI =HoaDonChiTiet.IMEI \n"
                + "                join QuocGiaDong on ChiTietDienThoai.id_quoc_gia_dong = QuocGiaDong.id\n"
                + "               join  KhuyenMai on HoaDon.id_khuyen_mai = KhuyenMai.id"
                + "               where  MONTH(ngay_tao) like ? and year(ngay_tao) = ?";
        List<ThongKeViewModel> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, thang);
            ps.setObject(2, nam);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ThongKeViewModel thongKe = new ThongKeViewModel(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6));
                list.add(thongKe);

            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public List<ThongKeViewModel> searchNam(String id) {
        String query = "SELECT ChiTietDienThoai.IMEI,ma_hoa_don,ngay_tao,gia_ban,gia_giam,gia_nhap\n"
                + "                FROM HoaDon JOIN HoaDonChiTiet on HoaDon.id = HoaDonChiTiet.id_hoa_don\n"
                + "               join ChiTietDienThoai on  ChiTietDienThoai.IMEI =HoaDonChiTiet.IMEI \n"
                + "                join QuocGiaDong on ChiTietDienThoai.id_quoc_gia_dong = QuocGiaDong.id\n"
                + "               join  KhuyenMai on HoaDon.id_khuyen_mai = KhuyenMai.id"
                + "               where Year(ngay_tao) like ?";
        List<ThongKeViewModel> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ThongKeViewModel thongKe = new ThongKeViewModel(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6));
                list.add(thongKe);

            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public List<ThongKeViewModel> searchNTN(String id) {
        String query = "SELECT ChiTietDienThoai.IMEI,ma_hoa_don,ngay_tao,gia_ban,gia_giam,gia_nhap\n"
                + "                FROM HoaDon JOIN HoaDonChiTiet on HoaDon.id = HoaDonChiTiet.id_hoa_don\n"
                + "               join ChiTietDienThoai on  ChiTietDienThoai.IMEI =HoaDonChiTiet.IMEI \n"
                + "                join QuocGiaDong on ChiTietDienThoai.id_quoc_gia_dong = QuocGiaDong.id\n"
                + "               join  KhuyenMai on HoaDon.id_khuyen_mai = KhuyenMai.id"
                + "               where  ngay_tao = ?";
        List<ThongKeViewModel> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ThongKeViewModel thongKe = new ThongKeViewModel(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6));
                list.add(thongKe);

            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return list;
    }
//    public static void main(String[] args) {
//      List <ThongKeViewModel> thongke = new ThongKeRespository().searchNgay("2022-11-11");
//    }
}
