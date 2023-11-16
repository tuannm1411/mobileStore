/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.ChiTietDienThoai;
import DomainModel.DienThoai;
import DomainModel.Dong;
import DomainModel.Hang;
import DomainModel.HeDieuHanh;
import DomainModel.QuocGia;
import DomainModel.QuocGiaDong;
import DomainModel.ThongSo;
import Ultilities.SQLServerConnection;
import ViewModel.SanPhamViewModel;
import ViewModel.ThongSoViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haha
 */
public class SanPhamRespository {

    public ChiTietDienThoai getMoi(String imei) {
        String query = " select moi,gia_ban_CT,gia_nhap_CT from chitietdienthoai where imei =? ";
        ChiTietDienThoai ct = new ChiTietDienThoai();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, imei);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ct.setMoi(rs.getByte(1));
                ct.setGiaban(rs.getDouble(2));
                ct.setGiaNhap(rs.getDouble(3));
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return ct;
    }

    public String XoaQ(String id, int tt) {
        String query = "UPDATE [dbo].[ChiTietDienThoai]\n"
                + "   SET [trang_thai] = ?\n"
                + " WHERE id_quoc_gia_dong = ?";
        int moi = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, tt);
            ps.setObject(2, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                moi = rs.getInt(1);
            }
            return "Thành công";
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            return "Thất bại";
        }

    }

    public boolean idTS(ChiTietDienThoai id) {
        String query = "UPDATE [dbo].[ChiTietDienThoai]\n"
                + "   SET [gia_ban_CT] = ?\n"
                + "      ,[gia_nhap_CT] = ?\n"
                + " WHERE imei = ?";
        int moi = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {

            ps.setObject(1, id.getGiaban());
            ps.setObject(2, id.getGiaNhap());
            ps.setObject(3, id.getIMEI());
            moi = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);

        }
        return moi > 0;

    }

    public boolean idST(QuocGiaDong id) {
        String query = "UPDATE [dbo].[QuocGiaDong]\n"
                + "   SET [gia_ban] = ?\n"
                + "      ,[gia_nhap] = ?\n"
                + "     \n"
                + " WHERE id = ? ";
        int moi = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {

            ps.setObject(1, id.getGiaBan());
            ps.setObject(2, id.getGiaNhap());
            ps.setObject(3, id.getId());
            moi = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);

        }
        return moi > 0;

    }

    public boolean capNhat(ThongSo ts) {
        String query = "UPDATE [dbo].[ThongSo]\n"
                + "   SET [id_tien_ich] = ?\n"
                + "      ,[id_mau] = ?\n"
                + "      ,[id_bo_nho] = ?\n"
                + "      ,[id_he_dieu_hanh] = ?\n"
                + "      ,[id_man_hinh] = ?\n"
                + "      ,[id_CPU] = ?\n"
                + "      ,[id_ket_noi] = ?\n"
                + "      ,[id_thiet_ke] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + "      ,[id_pin] = ?\n"
                + "      ,[id_camera] = ?\n"
                + " WHERE id_dong =?";
        int moi = -1;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {

            ps.setObject(1, ts.getTienIch());
            ps.setObject(2, ts.getMauSac());
            ps.setObject(3, ts.getBoNho());
            ps.setObject(4, ts.getHeDieuhanh());
            ps.setObject(5, ts.getManHinh());
            ps.setObject(6, ts.getCpu());
            ps.setObject(7, ts.getKetNoi());
            ps.setObject(8, ts.getThietKe());
            ps.setObject(9, 1);
            ps.setObject(10, ts.getPin());
            ps.setObject(11, ts.getCamera());
            ps.setObject(12, ts.getIdQuocGiaDong());

            moi = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);

        }
        return moi > 0;

    }

    public String XoaDTCT(String imei) {
        String query = "delete ChiTietDienThoai\n"
                + "where trang_thai = 1 and IMEI = ?";
        int moi = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, imei);
            moi = ps.executeUpdate();
            return "Thành công";
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            return "Thất bại";
        }

    }

    public List<Hang> getHang() {
        String query = " select id,ten_hang from hang ";
        List<Hang> hang = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                hang.add(new Hang(rs.getString(1), rs.getString(2)));
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return hang;
    }

    public List<QuocGia> getQuocGia() {
        String query = " select id,ten_quoc_gia from quocGia ";
        List<QuocGia> QuocGia = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                QuocGia.add(new QuocGia(rs.getString(1), rs.getString(2)));
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return QuocGia;
    }

    public List<Dong> getDong(int tt, String ds) {
        String query = " select * from Dong where trang_thai =? and id_dien_thoai = ?";
        List<Dong> hang = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, tt);
            ps.setObject(2, ds);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                hang.add(new Dong(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return hang;
    }

    public List<DienThoai> getDT(int tt, String idh) {
        String query = " select * from dienThoai where trang_thai = ? and id_hang = ?";
        List<DienThoai> hang = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, tt);
            ps.setObject(2, idh);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                hang.add(new DienThoai(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return hang;
    }

    public List<String> getIMEI(String id) {
        String query = " select IMEI from chitietdienthoai where id_quoc_gia_dong = ? and trang_thai= 1";
        List<String> hangList = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                hangList.add(rs.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return hangList;
    }

    public List<SanPhamViewModel> getAll() {
        String query = "select QuocGiaDong.id ,anh,ten_dien_thoai,ma_dien_thoai,ten_hang,ten_dong,ten_quoc_gia,COUNT(ChiTietDienThoai.IMEI)as soluong,gia_ban,gia_nhap from QuocGiaDong \n"
                + "                                              						join ChiTietDienThoai on QuocGiaDong.id = ChiTietDienThoai.id_quoc_gia_Dong \n"
                + "                                              						join Dong on dong.id = QuocGiaDong.id_dong  \n"
                + "                                              						join DienThoai on DienThoai.id = Dong.id_dien_thoai  \n"
                + "                              										join Hang on Hang.id = DienThoai.id_hang \n"
                + "																	join QuocGia on QuocGia.id = QuocGiaDong.id_quoc_gia\n"
                + "             where ChiTietDienThoai.trang_thai =1  \n"
                + "             group by anh, QuocGiaDong.id,gia_ban,gia_nhap,ten_dien_thoai,ten_hang,ten_dong,ten_quoc_gia,ma_dien_thoai";
        List<SanPhamViewModel> listSanPhamViewModelView = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                SanPhamViewModel sp = new SanPhamViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8),
                        rs.getDouble(9), rs.getDouble(10));
                listSanPhamViewModelView.add(sp);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return listSanPhamViewModelView;
    }

    public List<SanPhamViewModel> getAll2() {
        String query = "select QuocGiaDong.id ,anh,ten_dien_thoai,ma_dien_thoai,ten_hang,ten_dong,ten_quoc_gia,COUNT(ChiTietDienThoai.IMEI)as soluong,gia_ban,gia_nhap from QuocGiaDong \n"
                + "                                              						join ChiTietDienThoai on QuocGiaDong.id = ChiTietDienThoai.id_quoc_gia_Dong \n"
                + "                                              						join Dong on dong.id = QuocGiaDong.id_dong  \n"
                + "                                              						join DienThoai on DienThoai.id = Dong.id_dien_thoai  \n"
                + "                              										join Hang on Hang.id = DienThoai.id_hang \n"
                + "																	join QuocGia on QuocGia.id = QuocGiaDong.id_quoc_gia\n"
                + "             where ChiTietDienThoai.trang_thai =0  \n"
                + "             group by anh, QuocGiaDong.id,gia_ban,gia_nhap,ten_dien_thoai,ten_hang,ten_dong,ten_quoc_gia,ma_dien_thoai";
        List<SanPhamViewModel> listSanPhamViewModelView = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                SanPhamViewModel sp = new SanPhamViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8),
                        rs.getDouble(9), rs.getDouble(10));
                listSanPhamViewModelView.add(sp);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return listSanPhamViewModelView;
    }

    public ThongSoViewModel getAllThongSoView(String id) {
        String queryx = "SELECT BoNho.id, BoNho.so_luong_ram, BoNho.so_Luong_rom, BoNho.the_nho, CPU.id AS Expr1, CPU.ten_CPU, CPU.GPU, CPU.loai, CPU.hang_cpu, CPU.tien_trinh, PIN.id AS Expr2,  \n"
                + "                                  PIN.dung_luong, PIN.loai_pin, PIN.sac, PIN.dac_biet, HeDieuHanh.id AS Expr3, HeDieuHanh.ten_he_dieu_hanh, HeDieuHanh.phien_ban, ThietKe.id AS Expr4, ThietKe.mat_truoc, ThietKe.mat_lung,  \n"
                + "                                  ThietKe.vien, ThietKe.trong_luong, ManHinh.id AS Expr5, ManHinh.loai_man_hinh, ManHinh.kieu_man_hinh, ManHinh.tang_so_quet, ManHinh.do_phan_giai, ManHinh.kich_thuoc,  \n"
                + "                                  ManHinh.cong_nghe_di_kem, KetNoi.id AS Expr6, KetNoi.sim, KetNoi.hong_ngoai, KetNoi.jack35, KetNoi.ho_tro_mang, KetNoi.wifi, KetNoi.blutooth, KetNoi.GPS, MauSac.id AS Expr7,  \n"
                + "                                  MauSac.ma_mau, MauSac.ten_mau, TienIch.id AS Expr8, TienIch.bao_mat, TienIch.khang_nuoc, TienIch.dac_biet AS Expr9, Camera.id , Camera.camera_truoc,camera.camera_sau,camera.quay_video,camera.max_zoom,camera.chong_rung,camera.dac_biet\n"
                + "                FROM     ThongSo inner join BoNho on BoNho.id = ThongSo.id_bo_nho \n"
                + "                inner join CPU on CPU.id = ThongSo.id_CPU \n"
                + "                inner join PIN on PIN.id = ThongSo.id_pin \n"
                + "                inner join ManHinh on ManHinh.id = ThongSo.id_man_hinh \n"
                + "                inner join KetNoi on KetNoi.id = ThongSo.id_ket_noi \n"
                + "                inner join ThietKe on ThietKe.id = ThongSo.id_thiet_ke \n"
                + "                inner join TienIch on TienIch.id = ThongSo.id_tien_ich \n"
                + "                inner join MauSac on MauSac.id	= ThongSo.id_mau \n"
                + "                inner join HeDieuHanh on HeDieuHanh.id = ThongSo.id_he_dieu_hanh \n"
                + "				join camera on camera.id = ThongSo.id_camera\n"
                + "				where thongso.id_dong =?";
        ThongSoViewModel sp = new ThongSoViewModel();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(queryx);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sp = new ThongSoViewModel(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
                        rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17),
                        rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22),
                        rs.getString(23), rs.getString(24), rs.getString(25), rs.getString(26),
                        rs.getString(27), rs.getString(28), rs.getString(29), rs.getString(30),
                        rs.getString(31), rs.getString(32), rs.getString(33), rs.getString(34), rs.getString(35), rs.getString(36), rs.getString(37),
                        rs.getString(38), rs.getString(39), rs.getString(40), rs.getString(41),
                        rs.getString(42), rs.getString(43), rs.getString(44), rs.getString(45), rs.getString(46), rs.getString(47), rs.getString(48),
                        rs.getString(49), rs.getString(50), rs.getString(51), rs.getString(52));
            }

        } catch (SQLException e) {
            //   e.printStackTrace(System.out);
        }
        return sp;
    }

    public boolean ban(String IMEI) {
        String query = "update ChiTietDienThoai\n"
                + "set trang_thai = 0\n"
                + "where IMEI =?";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, IMEI);
            sp = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }

    public boolean ThemHDH(HeDieuHanh hdh) {
        String query = "insert into HeDieuHanh(ten_he_dieu_hanh,phien_ban,trang_thai)\n"
                + "values(?,?,?)";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getTenHDH());
            ps.setObject(2, hdh.getPhienBan());
            ps.setObject(3, hdh.getTrangThai());
            sp = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }

    public boolean SuaHDH(HeDieuHanh hdh) {
        String query = "UPDATE [dbo].[HeDieuHanh]\n"
                + "   SET [ten_he_dieu_hanh] =?\n"
                + "      ,[phien_ban] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE id = ?";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getTenHDH());
            ps.setObject(2, hdh.getPhienBan());
            ps.setObject(3, hdh.getTrangThai());
            ps.setObject(4, hdh.getId());
            sp = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }

    public boolean suaDong(Dong hdh) {
        String query = "UPDATE [dbo].[Dong]\n"
                + "   SET [ma_dong] = ?\n"
                + "      ,[ten_dong] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE  id = ?";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getMa());
            ps.setObject(2, hdh.getTen());
            ps.setObject(3, hdh.getTrangThai());
            ps.setObject(4, hdh.getId());
            sp = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }

    public boolean xoaDong(Dong hdh, int tt) {
        String query = "UPDATE [dbo].[Dong]\n"
                + "   SET [ma_dong] = ?\n"
                + "      ,[ten_dong] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE  id = ?";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getMa());
            ps.setObject(2, hdh.getTen());
            ps.setObject(3, tt);
            ps.setObject(4, hdh.getId());
            sp = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }

    public boolean xoaHDH(HeDieuHanh hdh, int tt) {
        String query = "UPDATE [dbo].[HeDieuHanh]\n"
                + "   SET [ten_he_dieu_hanh] =?\n"
                + "      ,[phien_ban] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE id = ?";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getTenHDH());
            ps.setObject(2, hdh.getPhienBan());
            ps.setObject(3, tt);
            ps.setObject(4, hdh.getId());
            sp = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }

    public boolean ThemDienThoai(ThongSo ts) {
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
                + "           ,[id_pin])\n"
                + "     VALUES\n"
                + "           (?,? ,? ,? ,? ,? ,? ,? ,?,?,? )";
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
            ps.setObject(9, ts.getPin());
            sp = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }

    public List<HeDieuHanh> getHDH(int x) {
        String query = "select * from HeDieuHanh  where trang_thai = ?";
        List<HeDieuHanh> ls = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, x);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                HeDieuHanh sp = new HeDieuHanh(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                ls.add(sp);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return ls;
    }

    public static void main(String[] args) {
        String id = "27560504-d668-427a-8f60-5585c5d0937d";
        System.out.println(new SanPhamRespository().getAllThongSoView(id).toString());

    }
}
