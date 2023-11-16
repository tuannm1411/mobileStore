/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.KhachHang;
import Ultilities.SQLServerConnection;
import ViewModel.KhachHangViewModel;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author quanl
 */
public class KhachHangRepository {

    public List<KhachHangViewModel> getAllKhachHang1() {
        String query = "SELECT [id]\n"
                + "      ,[ten_khach_hang]\n"
                + "      ,[ngay_sinh]\n"
                + "      ,[sdt]\n"
                + "      ,[email]\n"
                + "      ,[dia_chi]\n"
                + "      ,[trang_thai]\n"
                + "  FROM [dbo].[KhachHang]\n";

        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();

            List<KhachHangViewModel> list = new ArrayList<>();
            while (rs.next()) {
                KhachHangViewModel kh = new KhachHangViewModel(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<KhachHangViewModel> getAllKhachHang(int rowOffset) {
        String query = "SELECT [id]\n"
                + "      ,[ten_khach_hang]\n"
                + "      ,[ngay_sinh]\n"
                + "      ,[sdt]\n"
                + "      ,[email]\n"
                + "      ,[dia_chi]\n"
                + "      ,[trang_thai]\n"
                + "  FROM [dbo].[KhachHang]\n"
                + "  order by id\n"
                + "  offset ? rows\n"
                + "  fetch next 5 rows only  ";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, rowOffset);
            ResultSet rs = ps.executeQuery();

            List<KhachHangViewModel> list = new ArrayList<>();
            while (rs.next()) {
                KhachHangViewModel kh = new KhachHangViewModel(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<KhachHangViewModel> searchKhachHang(String id, int rowOffset) {
        String query = "SELECT\n"
                + "      id,[ten_khach_hang]\n"
                + "      ,[ngay_sinh]\n"
                + "      ,[sdt]\n"
                + "      ,[email]\n"
                + "      ,[dia_chi]\n"
                + "  FROM [dbo].[KhachHang]"
                + "where ten_khach_hang like ?"
                + "  order by id\n"
                + "  offset ? rows\n"
                + "  fetch next 5 rows only  ";
        List<KhachHangViewModel> list = new ArrayList<>();
        String a = "%" + id + "%";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, a);
            ps.setObject(2, rowOffset);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                KhachHangViewModel kh = new KhachHangViewModel(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(kh);
            }

        } catch (Exception e) {
        }
        return list;
    }

    public List<KhachHangViewModel> searchKhachHangdiaChi(String id, int rowOffset) {
        String query = "SELECT\n"
                + "      id,[ten_khach_hang]\n"
                + "      ,[ngay_sinh]\n"
                + "      ,[sdt]\n"
                + "      ,[email]\n"
                + "      ,[dia_chi]\n"
                + "  FROM [dbo].[KhachHang]"
                + "where dia_chi like ?"
                + "  order by id\n"
                + "  offset ? rows\n"
                + "  fetch next 5 rows only  ";
        List<KhachHangViewModel> list = new ArrayList<>();
        String a = "%" + id + "%";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, a);
            ps.setObject(2, rowOffset);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                KhachHangViewModel kh = new KhachHangViewModel(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(kh);
            }

        } catch (Exception e) {
        }
        return list;
    }

    public Boolean addKhachHang(KhachHang kh) {
        String query = "INSERT INTO [dbo].[KhachHang]\n"
                + "           ([ten_khach_hang]\n"
                + "           ,[ngay_sinh]\n"
                + "           ,[sdt]\n"
                + "           ,[email]\n"
                + "           ,[dia_chi])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, kh.getTen());
            ps.setObject(2, kh.getNgaySinh());
            ps.setObject(3, kh.getSdt());
            ps.setObject(4, kh.getEmail());
            ps.setObject(5, kh.getDiaChi());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public Boolean editKhachHang(KhachHang kh, String id) {
        String query = "UPDATE [dbo].[KhachHang]\n"
                + "   SET [ten_khach_hang] = ?\n"
                + "      ,[ngay_sinh] = ?\n"
                + "      ,[sdt] = ?\n"
                + "      ,[email] = ?\n"
                + "      ,[dia_chi] = ?\n"
                + " WHERE id = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, kh.getTen());
            ps.setObject(2, kh.getNgaySinh());
            ps.setObject(3, kh.getSdt());
            ps.setObject(4, kh.getEmail());
            ps.setObject(5, kh.getDiaChi());
            ps.setObject(6, id);

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public Boolean deleteKhachHang(String id) {
        String query = "delete from HoaDonChiTiet where id_hoa_don = (select HoaDon.id from HoaDon join KhachHang on HoaDon.id_khach_hang = KhachHang.id where id_khach_hang = ?)\n"
                + "delete from HoaDon where id_khach_hang =?\n"
                + "DELETE FROM [dbo].[KhachHang]\n"
                + "      WHERE id = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ps.setObject(2, id);
            ps.setObject(3, id);

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        KhachHangRepository repository = new KhachHangRepository();
        List<KhachHangViewModel> list = repository.getAllKhachHang1();
        list.subList(0, 3);
    }

    public List<KhachHangViewModel> searchKhachSDT(String sdt, int rowOffset) {
        String query = "SELECT\n"
                + "      id,[ten_khach_hang]\n"
                + "      ,[ngay_sinh]\n"
                + "      ,[sdt]\n"
                + "      ,[email]\n"
                + "      ,[dia_chi]\n"
                + "  FROM [dbo].[KhachHang]"
                + "where sdt like ?"
                + "  order by id\n"
                + "  offset ? rows\n"
                + "  fetch next 5 rows only  ";
        List<KhachHangViewModel> list = new ArrayList<>();
        String a = "%" + sdt + "%";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, a);
            ps.setObject(2, rowOffset);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                KhachHangViewModel kh = new KhachHangViewModel(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(kh);
            }

        } catch (Exception e) {
        }
        return list;
    }
}
