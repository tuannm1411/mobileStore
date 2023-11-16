/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.ChucVu;
import DomainModel.NhanVien;
import Ultilities.SQLServerConnection;
import ViewModel.ChucVuViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author buiti
 */
public class ChucVuRepository {

    public List<ChucVu> getAll() {
        List<ChucVu> ls = new ArrayList<>();
        try ( Connection conn = new SQLServerConnection().getConnection()) {
            String query = "SELECT [id]\n"
                    + "      ,[ma_chuc_vu]\n"
                    + "      ,[ten_chuc_vu]\n"
                    + "  FROM [dbo].[ChucVu]";

            PreparedStatement ps = conn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                ls.add(new ChucVu(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            return ls;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public List<ChucVuViewModel> getAllCV() {

        String query = "SELECT [id]\n"
                + "      ,[ma_chuc_vu]\n"
                + "      ,[ten_chuc_vu]\n"
                + "  FROM [dbo].[ChucVu]";
        List<ChucVuViewModel> cv = new ArrayList<>();
        try ( Connection conn = new SQLServerConnection().getConnection()) {
            PreparedStatement ps = conn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChucVuViewModel chucVu = new ChucVuViewModel(rs.getString(1), rs.getString(2), rs.getString(3));
                cv.add(chucVu);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return cv;

    }

    public List<NhanVien> getCV(String ma) {

        String query = "SELECT ma_nhan_vien, ten_nhan_vien\n"
                + "     FROM NhanVien join ChucVu on NhanVien.id_chuc_vu = ChucVu.id\n"
                + "     where ma_chuc_vu =?";
        List<NhanVien> nhanVien = new ArrayList<>();
        try ( Connection conn = new SQLServerConnection().getConnection()) {

            PreparedStatement ps = conn.prepareCall(query);
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2));
                nhanVien.add(nv);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return nhanVien;

    }

    public boolean add(ChucVuViewModel cv) {
        String query = "INSERT INTO [dbo].[ChucVu]\n"
                + "           ([ma_chuc_vu]\n"
                + "           ,[ten_chuc_vu])\n"
                + "     VALUES\n"
                + "           (?,?)";
        int check = 0;
        try ( Connection conn = new SQLServerConnection().getConnection();  PreparedStatement ps = conn.prepareCall(query);) {
            ps.setObject(1, cv.getMa());
            ps.setObject(2, cv.getTen());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public ChucVuViewModel getOne(String ma) {
        String query = "SELECT [id]\n"
                + "      ,[ma_chuc_vu]\n"
                + "      ,[ten_chuc_vu]\n"
                + "  FROM [dbo].[ChucVu]"
                + "where ma_chuc_vu =?";

        try ( Connection conn = new SQLServerConnection().getConnection()) {

            PreparedStatement ps = conn.prepareCall(query);
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return new ChucVuViewModel(rs.getString(1), rs.getString(2), rs.getString(3));

            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

}
