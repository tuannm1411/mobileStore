/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.KhuyenMai;
import Ultilities.SQLServerConnection;
import ViewModel.KhuyenMaiViewModel;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author togia
 */
public class KhuyenMaiResponsitory {

    public List<KhuyenMaiViewModel> getAll() {
        String query = "SELECT [id]\n"
                + "      ,[ma_khuyen_mai]\n"
                + "      ,[ngay_bat_dau]\n"
                + "      ,[ngay_ket_thuc]\n"
                + "      ,[gia_giam]\n"
                + "      ,[don_vi]\n"
                + "      ,[mo_ta]\n"
                + "      ,[trang_thai]\n"
                + "  FROM [dbo].[KhuyenMai]";
        List<KhuyenMaiViewModel> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMaiViewModel km = new KhuyenMaiViewModel(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getDouble(5), rs.getBoolean(6), rs.getString(7), rs.getInt(8));
                list.add(km);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public List<KhuyenMaiViewModel> getAllvali(String maKM) {
        String query = "SELECT [id]\n"
                + "      ,[ma_khuyen_mai]\n"
                + "      ,[ngay_bat_dau]\n"
                + "      ,[ngay_ket_thuc]\n"
                + "      ,[gia_giam]\n"
                + "      ,[don_vi]\n"
                + "      ,[mo_ta]\n"
                + "      ,[trang_thai]\n"
                + "  FROM [dbo].[KhuyenMai]\n"
                + "  where ma_khuyen_mai = ?  ";
        List<KhuyenMaiViewModel> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maKM);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMaiViewModel km = new KhuyenMaiViewModel(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getDouble(5), rs.getBoolean(6), rs.getString(7), rs.getInt(8));
                list.add(km);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public List<KhuyenMaiViewModel> getAllDem(int rowOffset) {
        String query = "SELECT [id]\n"
                + "      ,[ma_khuyen_mai]\n"
                + "      ,[ngay_bat_dau]\n"
                + "      ,[ngay_ket_thuc]\n"
                + "      ,[gia_giam]\n"
                + "      ,[don_vi]\n"
                + "      ,[mo_ta]\n"
                + "      ,[trang_thai]\n"
                + "  FROM [dbo].[KhuyenMai]"
                + "  order by id\n"
                + "  offset ? rows\n"
                + "  fetch next 5 rows only  ";
        List<KhuyenMaiViewModel> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, rowOffset);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMaiViewModel km = new KhuyenMaiViewModel(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getDouble(5), rs.getBoolean(6), rs.getString(7), rs.getInt(8));
                list.add(km);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public boolean add(KhuyenMaiViewModel km) {
        String query = "INSERT INTO [dbo].[KhuyenMai]\n"
                + "           (\n"
                + "           [ma_khuyen_mai]\n"
                + "           ,[ngay_bat_dau]\n"
                + "           ,[ngay_ket_thuc]\n"
                + "           ,[gia_giam]\n"
                + "           ,[don_vi]\n"
                + "           ,[mo_ta]\n"
                + ")\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {

            ps.setObject(1, km.getMa());
            ps.setObject(2, km.getNgayBatDau());
            ps.setObject(3, km.getNgayKetThuc());
            ps.setObject(4, km.getGiaGiam());
            ps.setObject(5, km.isDonVi());
            ps.setObject(6, km.getMoTa());

            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String idKM) {
        String query = "DELETE FROM [dbo].[KhuyenMai]\n"
                + "      WHERE id = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idKM);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(KhuyenMaiViewModel km, String idKM) {
        String query = "UPDATE [dbo].[KhuyenMai]\n"
                + "   SET [ma_khuyen_mai] =?\n"
                + "      ,[ngay_bat_dau] = ?\n"
                + "      ,[ngay_ket_thuc] = ?\n"
                + "      ,[gia_giam] = ?\n"
                + "      ,[don_vi] = ?\n"
                + "      ,[mo_ta] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE id = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, km.getMa());
            ps.setObject(2, km.getNgayBatDau());
            ps.setObject(3, km.getNgayKetThuc());
            ps.setObject(4, km.getGiaGiam());
            ps.setObject(5, km.isDonVi());
            ps.setObject(6, km.getMoTa());
            ps.setObject(7, km.getTrangThai());
            ps.setObject(8, idKM);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public void upDateTrangThai() {
        String query = "UPDATE [dbo].[KhuyenMai]\n"
                + "   SET trang_thai= 0 where ngay_bat_dau <=  GETDATE() and ngay_ket_thuc >= GETDATE()\n"
                + "UPDATE [dbo].[KhuyenMai]\n"
                + "   SET trang_thai= 1  where ngay_bat_dau > GETDATE()    \n"
                + " UPDATE [dbo].[KhuyenMai]\n"
                + "   SET trang_thai= 2  where  ngay_ket_thuc < GETDATE()  ";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

    }

}
