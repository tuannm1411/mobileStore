package Repository;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import DomainModel.NhanVien;
import Ultilities.SQLServerConnection;
import ViewModel.LoginViewModel;
import ViewModel.MaNVViewModel;
import ViewModel.loginWebCamView;
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
public class LoginRepository {

    public List<LoginViewModel> getAll() {
        List<LoginViewModel> ls = new ArrayList<>();
        try ( Connection conn = new SQLServerConnection().getConnection()) {
            String query = "Select ma_nhan_vien,mat_khau,ten_chuc_vu,cmnd from NhanVien join ChucVu on NhanVien.id_chuc_vu = ChucVu.id";
            PreparedStatement ps = conn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ls.add(new LoginViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            return ls;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public List<MaNVViewModel> getMaNV(String cmnd) {
        String query = "select ma_nhan_vien  from NhanVien where cmnd = ? ";
        List<MaNVViewModel> list = new ArrayList<>();

        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, cmnd);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                MaNVViewModel nv = new MaNVViewModel(rs.getString(1));
                list.add(nv);
            }

        } catch (Exception e) {
        }
        return list;
    }

    public List<loginWebCamView> getAllWebCam() {
        List<loginWebCamView> ls = new ArrayList<>();
        try ( Connection conn = new SQLServerConnection().getConnection()) {
            String query = "SELECT        dbo.ChucVu.ma_chuc_vu, dbo.ChucVu.ten_chuc_vu, dbo.NhanVien.cmnd\n"
                    + "FROM            dbo.NhanVien INNER JOIN\n"
                    + "                         dbo.ChucVu ON dbo.NhanVien.id_chuc_vu = dbo.ChucVu.id";
            PreparedStatement ps = conn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ls.add(new loginWebCamView(rs.getString(1), rs.getString(2), rs.getString(3)));
            }

            return ls;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void main(String[] args) {
        List<loginWebCamView> l = new LoginRepository().getAllWebCam();
        for (loginWebCamView nhanVien : l) {
            System.out.println(nhanVien.toString());
        }
    }

    public boolean addNV(NhanVien nv) {
        int check = 0;
        try ( Connection conn = new SQLServerConnection().getConnection()) {
            String query = "INSERT INTO [dbo].[NhanVien]\n"
                    + "           ([ma_nhan_vien]\n"
                    + "           ,[ten_nhan_vien]\n"
                    + "           ,[ngay_sinh]\n"
                    + "           ,[sdt]\n"
                    + "           ,[email]\n"
                    + "           ,[dia_chi]\n"
                    + "           ,[mat_khau]\n"
                    + "           ,[cmnd])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setObject(1, nv.getMa());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.getNgaySinh());
            ps.setObject(4, nv.getSdt());
            ps.setObject(5, nv.getEmail());
            ps.setObject(6, nv.getDiaChi());
            ps.setObject(7, nv.getMatKhau());
            ps.setObject(8, nv.getCmnd());

            check = ps.executeUpdate();
            return check > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return check < 0;
        }

    }

}
