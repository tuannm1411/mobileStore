/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.ChiTietDienThoai;
import DomainModel.DienThoai;
import DomainModel.QuocGiaDong;
import DomainModel.ThongSo;
import Ultilities.SQLServerConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haha
 */
public class ThemSanPhamRepon {

    public boolean ThemSP(ThongSo ts) {
        String query = "INSERT INTO [dbo].[ThongSo]\n"
                + "           ([id_dong]\n"
                + "           ,[id_tien_ich]\n"
                + "           ,[id_mau]\n"
                + "           ,[id_bo_nho]\n"
                + "           ,[id_he_dieu_hanh]\n"
                + "           ,[id_man_hinh]\n"
                + "           ,[id_CPU]\n"
                + "           ,[id_ket_noi]\n"
                + "           ,[id_thiet_ke]\n"
                + "           ,[trang_thai]\n"
                + "           ,[id_pin],"
                + "[id_camera])\n"
                + "     VALUES\n"
                + "           (?,?,?,? ,? ,? ,? ,?,?,?,?,?)";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ts.getIdQuocGiaDong());
            ps.setObject(2, ts.getTienIch());
            ps.setObject(3, ts.getMauSac());
            ps.setObject(4, ts.getBoNho());
            ps.setObject(5, ts.getHeDieuhanh());
            ps.setObject(6, ts.getManHinh());
            ps.setObject(7, ts.getCpu());
            ps.setObject(8, ts.getKetNoi());
            ps.setObject(9, ts.getThietKe());
            ps.setObject(10, 1);
            ps.setObject(11, ts.getPin());
            ps.setObject(12, ts.getCamera());

            sp = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }

    public boolean ThemQGD(QuocGiaDong ts) {
        String query = "INSERT INTO [dbo].[QuocGiaDong]\n"
                + "           ([id_dong]\n"
                + "           ,[id_quoc_gia]\n"
                + "           ,[gia_ban]\n"
                + "           ,[gia_nhap]\n"
                + "           ,[anh]\n"
                + "           )\n"
                + "     VALUES\n"
                + "           (?,? ,?,?  ,?  )";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ts.getIdDong());
            ps.setObject(2, ts.getIdQuocGia());
            ps.setObject(3, ts.getGiaBan());
            ps.setObject(4, ts.getGiaNhap());
            ps.setObject(5, ts.getSrcAnh());

            sp = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }

    public List<QuocGiaDong> getQGD() {
        String query = "select * from quocGiaDong";

        List<QuocGiaDong> qgd = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                qgd.add(new QuocGiaDong(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5), rs.getString(6)));

            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return qgd;
    }

    public List<QuocGiaDong> getQGD2(String id) {
        String query = "select * from quocGiaDong where id =?";

        List<QuocGiaDong> qgd = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                qgd.add(new QuocGiaDong(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5), rs.getString(6)));

            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return qgd;
    }

    public boolean ThemDT(DienThoai ts) {
        String query = "INSERT INTO [dbo].[DienThoai]\n"
                + "           ([ma_dien_thoai]\n"
                + "           ,[ten_dien_thoai]\n"
                + "           ,[id_hang]\n"
                + "           ,[trang_thai])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,1)";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ts.getMa());
            ps.setObject(2, ts.getTen());
            ps.setObject(3, ts.getIdHang());

            sp = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }

    public boolean ThemCTDT(ChiTietDienThoai ts) {
        String query = "INSERT INTO [dbo].[ChiTietDienThoai]\n"
                + "           ([IMEI]\n"
                + "           ,[trang_thai]\n"
                + "           ,[moi]\n"
                + "           ,[mo_ta]\n"
                + "           ,[id_quoc_gia_dong]\n"
                + "           ,[ngay_nhap])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,GETDATE())\n"
                + "GO";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ts.getIMEI());
            ps.setObject(2, 1);
            ps.setObject(3, ts.getMoi());
            ps.setObject(4, ts.getMoTa());
            ps.setObject(5, ts.getIdQuocGiaDong());

            sp = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }

    public boolean Xoa(String id) {
        String query = "UPDATE [dbo].[ChiTietDienThoai]\n"
                + "   SET [trang_thai] = 0\n"
                + "      \n"
                + " WHERE id_quoc_gia_dong = ?";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);

            sp = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }

}
