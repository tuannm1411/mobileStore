package Repository;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import DomainModel.NhanVien;
import Ultilities.SQLServerConnection;
import ViewModel.CMNDViewModel;
import ViewModel.CheckEmail;
import ViewModel.CheckSDT;
import ViewModel.LoginViewModel;
import ViewModel.NhanVienView;
import ViewModel.ThongTinNguoiDungView;
import ViewModel.checkTrungManv;
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
public class NhanVienRepository {

    public List<NhanVienView> getAll() {
        List<NhanVienView> ls = new ArrayList<>();
        try ( Connection conn = new SQLServerConnection().getConnection()) {
            String query = "SELECT        dbo.NhanVien.id, dbo.NhanVien.ma_nhan_vien, dbo.NhanVien.ten_nhan_vien, dbo.NhanVien.id_chuc_vu, dbo.ChucVu.ten_chuc_vu, dbo.NhanVien.ngay_sinh, dbo.NhanVien.sdt, dbo.NhanVien.email, dbo.NhanVien.dia_chi, \n"
                    + "                         dbo.NhanVien.mat_khau, dbo.NhanVien.trang_thai, dbo.NhanVien.cmnd\n"
                    + "FROM            dbo.ChucVu RIGHT OUTER JOIN\n"
                    + "                         dbo.NhanVien ON dbo.ChucVu.id = dbo.NhanVien.id_chuc_vu";
            PreparedStatement ps = conn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ls.add(new NhanVienView(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getString(12)));
            }
//            rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11)),rs.getString(12)
            return ls;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public List<NhanVien> getAlls() {
        List<NhanVien> ls = new ArrayList<>();
        try ( Connection conn = new SQLServerConnection().getConnection()) {
            String query = "SELECT  * from nhanvien";
            PreparedStatement ps = conn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ls.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11)));
            }
            return ls;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public boolean addNV(NhanVien nv) {
        int check = 0;
        try ( Connection conn = new SQLServerConnection().getConnection()) {
            String query = "INSERT INTO [dbo].[NhanVien]\n"
                    + "           ([ma_nhan_vien]\n"
                    + "           ,[ten_nhan_vien]\n"
                    + "           ,[id_chuc_vu]\n"
                    + "           ,[ngay_sinh]\n"
                    + "           ,[sdt]\n"
                    + "           ,[email]\n"
                    + "           ,[dia_chi]\n"
                    + "           ,[mat_khau]\n"
                    + "           ,[trang_thai],cmnd)\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?,?)";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setObject(1, nv.getMa());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.getIdChucVu());
            ps.setObject(4, nv.getNgaySinh());
            ps.setObject(5, nv.getSdt());
            ps.setObject(6, nv.getEmail());
            ps.setObject(7, nv.getDiaChi());
            ps.setObject(8, nv.getMatKhau());
            ps.setObject(9, nv.getTrangThai());
            ps.setObject(10, nv.getCmnd());

            check = ps.executeUpdate();
            return check > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return check < 0;
        }

    }



    public boolean chuyenTTNV(String id) {
        String query = "UPDATE [dbo].[NhanVien]\n"
                + "   SET[id_chuc_vu] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE id = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, null);
            ps.setObject(2, "1");
            ps.setObject(3, id);

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean QuenMK(String pass, String maNV) {
        String query = "UPDATE [dbo].[NhanVien]\n"
                + "   SET[mat_khau] = ?\n"
                + "\n"
                + " WHERE \n"
                + " ma_nhan_vien =?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {

            ps.setObject(1, pass);
            ps.setObject(2, maNV);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateSVDiem(NhanVien sv, String id) {
        String query = "UPDATE [dbo].[NhanVien]\n"
                + "   SET [ma_nhan_vien] = ?\n"
                + "      ,[ten_nhan_vien] = ?\n"
                + "      ,[id_chuc_vu] = ?\n"
                + "      ,[ngay_sinh] = ?\n"
                + "      ,[sdt] = ?\n"
                + "      ,[email] = ?\n"
                + "      ,[dia_chi] = ?\n"
                + "      ,[mat_khau] = ?\n"
                + ",[trang_thai] = ?"
                + " WHERE  id = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {

            ps.setObject(1, sv.getMa());
            ps.setObject(2, sv.getTen());
            ps.setObject(3, sv.getIdChucVu());
            ps.setObject(4, sv.getNgaySinh());
            ps.setObject(5, sv.getSdt());
            ps.setObject(6, sv.getEmail());
            ps.setObject(7, sv.getDiaChi());
            ps.setObject(8, sv.getMatKhau());
            ps.setObject(9, sv.getTrangThai());
            ps.setObject(10, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public List<NhanVienView> searchNhanVien(String name) {
        String query = "SELECT        dbo.NhanVien.id, dbo.NhanVien.ma_nhan_vien, dbo.NhanVien.ten_nhan_vien, dbo.NhanVien.id_chuc_vu, dbo.ChucVu.ten_chuc_vu, dbo.NhanVien.ngay_sinh, dbo.NhanVien.sdt, dbo.NhanVien.email, dbo.NhanVien.dia_chi, \n"
                + "                         dbo.NhanVien.mat_khau, dbo.NhanVien.trang_thai, dbo.NhanVien.cmnd\n"
                + "FROM            dbo.NhanVien left JOIN\n"
                + "                         dbo.ChucVu ON dbo.NhanVien.id_chuc_vu = dbo.ChucVu.id where ten_nhan_vien like ?";
        List<NhanVienView> list = new ArrayList<>();
        String a = "%" + name + "%";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, a);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                NhanVienView nv = new NhanVienView(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getString(12));
                list.add(nv);
            }

        } catch (Exception e) {
        }
        return list;
    }
        public List<NhanVienView> searchNhanVienSDT(String sdt) {
        String query = "SELECT        dbo.NhanVien.id, dbo.NhanVien.ma_nhan_vien, dbo.NhanVien.ten_nhan_vien, dbo.NhanVien.id_chuc_vu, dbo.ChucVu.ten_chuc_vu, dbo.NhanVien.ngay_sinh, dbo.NhanVien.sdt, dbo.NhanVien.email, dbo.NhanVien.dia_chi, \n"
                + "                         dbo.NhanVien.mat_khau, dbo.NhanVien.trang_thai, dbo.NhanVien.cmnd\n"
                + "FROM            dbo.NhanVien left JOIN\n"
                + "                         dbo.ChucVu ON dbo.NhanVien.id_chuc_vu = dbo.ChucVu.id where sdt like ?";
        List<NhanVienView> list = new ArrayList<>();
        String a = "%" + sdt + "%";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, a);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                NhanVienView nv = new NhanVienView(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getString(12));
                list.add(nv);
            }

        } catch (Exception e) {
        }
        return list;
    }
             public List<NhanVienView> searchNhanVienMaNV(String maNV) {
        String query = "SELECT        dbo.NhanVien.id, dbo.NhanVien.ma_nhan_vien, dbo.NhanVien.ten_nhan_vien, dbo.NhanVien.id_chuc_vu, dbo.ChucVu.ten_chuc_vu, dbo.NhanVien.ngay_sinh, dbo.NhanVien.sdt, dbo.NhanVien.email, dbo.NhanVien.dia_chi, \n"
                + "                         dbo.NhanVien.mat_khau, dbo.NhanVien.trang_thai, dbo.NhanVien.cmnd\n"
                + "FROM            dbo.NhanVien left JOIN\n"
                + "                         dbo.ChucVu ON dbo.NhanVien.id_chuc_vu = dbo.ChucVu.id where ma_nhan_vien like ?";
        List<NhanVienView> list = new ArrayList<>();
        String a = "%" + maNV + "%";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, a);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                NhanVienView nv = new NhanVienView(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getString(12));
                list.add(nv);
            }

        } catch (Exception e) {
        }
        return list;
    }
             public List<NhanVienView> searchNhanViencmnd(String cmnd) {
        String query = "SELECT        dbo.NhanVien.id, dbo.NhanVien.ma_nhan_vien, dbo.NhanVien.ten_nhan_vien, dbo.NhanVien.id_chuc_vu, dbo.ChucVu.ten_chuc_vu, dbo.NhanVien.ngay_sinh, dbo.NhanVien.sdt, dbo.NhanVien.email, dbo.NhanVien.dia_chi, \n"
                + "                         dbo.NhanVien.mat_khau, dbo.NhanVien.trang_thai, dbo.NhanVien.cmnd\n"
                + "FROM            dbo.NhanVien left JOIN\n"
                + "                         dbo.ChucVu ON dbo.NhanVien.id_chuc_vu = dbo.ChucVu.id where cmnd like ?";
        List<NhanVienView> list = new ArrayList<>();
        String a = "%" + cmnd + "%";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, a);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                NhanVienView nv = new NhanVienView(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getString(12));
                list.add(nv);
            }

        } catch (Exception e) {
        }
        return list;
    }
            public static void main(String[] args) {
        List<NhanVienView> l = new NhanVienRepository().searchNhanVienSDT("0");
        for (NhanVienView nhanVien : l) {
            System.out.println(nhanVien.toString());
        }
    }
            

    public List<ThongTinNguoiDungView> layThongTin(String ma) {
        String query = "SELECT       dbo.NhanVien.ten_nhan_vien, dbo.ChucVu.ten_chuc_vu, dbo.NhanVien.ngay_sinh, dbo.NhanVien.sdt, dbo.NhanVien.email, dbo.NhanVien.dia_chi, \n"
                + "                         dbo.NhanVien.cmnd\n"
                + "FROM            dbo.NhanVien INNER JOIN\n"
                + "                         dbo.ChucVu ON dbo.NhanVien.id_chuc_vu = dbo.ChucVu.id where  ma_nhan_vien = ?";
        List<ThongTinNguoiDungView> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ThongTinNguoiDungView nv = new ThongTinNguoiDungView(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));

                list.add(nv);
            }

        } catch (Exception e) {
        }
        return list;
    }

    public List<NhanVienView> getAllNhanVienSearch(int rowOffset) {
        String query = "select NhanVien.id,ma_nhan_vien,ten_nhan_vien,id_chuc_vu,ten_chuc_vu,ngay_sinh,sdt,email,dia_chi,mat_khau,NhanVien.trang_thai  \n"
                + "from NhanVien left join ChucVu on NhanVien.id_chuc_vu = ChucVu.id\n"
                + "order by id\n"
                + "offset ? rows\n"
                + "fetch next 5 rows only";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, rowOffset);
            ResultSet rs = ps.executeQuery();

            List<NhanVienView> list = new ArrayList<>();
            while (rs.next()) {
                NhanVienView kh = new NhanVienView(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getString(12));
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<checkTrungManv> getAllHoaDonCheckTrung(String maNV) {
        String query = "SELECT [ma_nhan_vien]\n"
                + "\n"
                + "  FROM [dbo].[NhanVien] where ma_nhan_vien = ?";
        List<checkTrungManv> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maNV);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                checkTrungManv a = new checkTrungManv(rs.getString(1));
                list.add(a);
            }
            return list;
        } catch (SQLException s) {
            s.printStackTrace(System.out);
        }
        return null;
    }
     public List<CMNDViewModel> getAllCheckTrungCMND(String cmnd) {
        String query = "SELECT cmnd\n"
                + "\n"
                + "  FROM [dbo].[NhanVien] where cmnd= ?";
        List<CMNDViewModel> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, cmnd);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CMNDViewModel a = new CMNDViewModel(rs.getString(1));
                list.add(a);
            }
            return list;
        } catch (SQLException s) {
            s.printStackTrace(System.out);
        }
        return null;
    }
      public List<CheckEmail> getAllCheckTrunggEmail(String email) {
        String query = "SELECT email\n"
                + "\n"
                + "  FROM [dbo].[NhanVien] where email= ?";
        List<CheckEmail> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, email);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CheckEmail a = new CheckEmail(rs.getString(1));
                list.add(a);
            }
            return list;
        } catch (SQLException s) {
            s.printStackTrace(System.out);
        }
        return null;
    }
          public List<CheckSDT> getAllCheckTrungsdt(String sdt) {
        String query = "SELECT sdt\n"
                + "\n"
                + "  FROM [dbo].[NhanVien] where sdt= ?";
        List<CheckSDT> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, sdt);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CheckSDT a = new CheckSDT(rs.getString(1));
                list.add(a);
            }
            return list;
        } catch (SQLException s) {
            s.printStackTrace(System.out);
        }
        return null;
    }
}
