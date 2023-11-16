/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Ultilities.SQLServerConnection;
import ViewModel.KhachHangViewModel;
import ViewModel.SanPhamDaMuaViewModel;
import ViewModel.SoLanMuaViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author quanl
 */
public class ThongKeKhachHangRepository {

    public List<SoLanMuaViewModel> getAll(int rowOffset) {
        String query = "SELECT KhachHang.id, ten_khach_hang, count(HoaDon.id_khach_hang)\n"
                + "  FROM [dbo].[KhachHang]  inner join HoaDon on KhachHang.id = HoaDon.id_khach_hang \n"
                + "  group by KhachHang.id,KhachHang.id,ten_khach_hang\n"
                + "  order by ten_khach_hang\n"
                + " offset ? rows\n"
                + " fetch next 5 rows only ";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, rowOffset);
            ResultSet rs = ps.executeQuery();

            List<SoLanMuaViewModel> list = new ArrayList<>();
            while (rs.next()) {
                SoLanMuaViewModel sl = new SoLanMuaViewModel(rs.getString(1), rs.getString(2), rs.getInt(3));
                list.add(sl);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<SoLanMuaViewModel> getAllKPT() {
        String query = "SELECT KhachHang.id,ten_khach_hang, count(HoaDon.id_khach_hang)\n"
                + "  FROM [dbo].[KhachHang]  inner join HoaDon on KhachHang.id = HoaDon.id_khach_hang \n"
                + "  group by KhachHang.id,KhachHang.id,ten_khach_hang\n"
                + "  order by ten_khach_hang\n";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();

            List<SoLanMuaViewModel> list = new ArrayList<>();
            while (rs.next()) {
                SoLanMuaViewModel sl = new SoLanMuaViewModel(rs.getString(1), rs.getString(2), rs.getInt(3));
                list.add(sl);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<SoLanMuaViewModel> searchSoLuong(int soLuong, int rowOffset) {
        String query = "SELECT KhachHang.id,ten_khach_hang ,count(HoaDon.id_khach_hang)\n"
                + "  FROM [dbo].[KhachHang]   join HoaDon on KhachHang.id = HoaDon.id_khach_hang  \n"
                + "  group by KhachHang.id,ten_khach_hang\n"
                + "  having count(HoaDon.id_khach_hang) > ?\n"
                + "  order by KhachHang.id,ten_khach_hang\n"
                + " offset ? rows\n"
                + " fetch next 5 rows only";
        List<SoLanMuaViewModel> list = new ArrayList<>();

        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, soLuong);
            ps.setObject(2, rowOffset);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SoLanMuaViewModel sl = new SoLanMuaViewModel(rs.getString(1), rs.getString(2), rs.getInt(3));
                list.add(sl);
            }

        } catch (Exception e) {
        }
        return list;
    }

    public List<SoLanMuaViewModel> searchTen(String ten, int rowOffset) {
        String query = "SELECT KhachHang.id,ten_khach_hang ,count(HoaDon.id_khach_hang)\n"
                + "  FROM [dbo].[KhachHang]   join HoaDon on KhachHang.id = HoaDon.id_khach_hang  \n"
                + "  where ten_khach_hang like ?\n"
                + "  group by KhachHang.id,ten_khach_hang\n"
                + "  order by ten_khach_hang\n"
                + " offset ? rows\n"
                + " fetch next 5 rows only";
        List<SoLanMuaViewModel> list = new ArrayList<>();
        String a = "%" + ten + "%";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, a);
            ps.setObject(2, rowOffset);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SoLanMuaViewModel sl = new SoLanMuaViewModel(rs.getString(1), rs.getString(2), rs.getInt(3));
                list.add(sl);
            }

        } catch (Exception e) {
        }
        return list;
    }

    public List<SanPhamDaMuaViewModel> getAllSPDL(String imei) {
        String query = "SELECT dbo.ChiTietDienThoai.IMEI, dbo.DienThoai.ten_dien_thoai, dbo.Dong.ten_dong, dbo.QuocGiaDong.gia_ban\n"
                + "FROM     dbo.HoaDon INNER JOIN\n"
                + "                  dbo.HoaDonChiTiet ON dbo.HoaDon.id = dbo.HoaDonChiTiet.id_hoa_don INNER JOIN\n"
                + "                  dbo.KhachHang ON dbo.HoaDon.id_khach_hang = dbo.KhachHang.id INNER JOIN\n"
                + "                  dbo.ChiTietDienThoai ON dbo.HoaDonChiTiet.IMEI = dbo.ChiTietDienThoai.IMEI INNER JOIN\n"
                + "                  dbo.QuocGiaDong ON dbo.ChiTietDienThoai.id_quoc_gia_dong = dbo.QuocGiaDong.id INNER JOIN\n"
                + "                  dbo.Dong ON dbo.QuocGiaDong.id_dong = dbo.Dong.id INNER JOIN\n"
                + "                  dbo.DienThoai ON dbo.Dong.id_dien_thoai = dbo.DienThoai.id INNER JOIN\n"
                + "                  dbo.Hang ON dbo.DienThoai.id_hang = dbo.Hang.id\n"
                + "where KhachHang.id = ?";
        List<SanPhamDaMuaViewModel> list = new ArrayList<>();

        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, imei);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPhamDaMuaViewModel sl = new SanPhamDaMuaViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(sl);
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public static void main(String[] args) {
        ThongKeKhachHangRepository s = new ThongKeKhachHangRepository();
        List<SoLanMuaViewModel> l = new ArrayList<>();
        l = s.getAll(0);
        System.out.println(l);
    }
}
