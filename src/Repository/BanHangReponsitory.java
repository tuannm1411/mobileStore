/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.ChiTietDienThoai;
import DomainModel.HoaDon;
import DomainModel.HoaDonChiTiet;
import Ultilities.SQLServerConnection;
import ViewModel.ChiTietDienThoaiViewModel;
import ViewModel.DienThoaiViewModel;
import ViewModel.HoaDonChiTietViewModel;
import ViewModel.ViewModelHoaDon;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class BanHangReponsitory {

    public List<DienThoaiViewModel> getAll() {
        String query = "SELECT DienThoai.[id]\n"
                + "      ,[ma_dien_thoai]\n"
                + "      ,[ten_dien_thoai]\n"
                + "      ,[id_hang]\n"
                + "      ,DienThoai.[trang_thai]\n"
                + "  FROM [dbo].[DienThoai]\n"
                + "  join Dong on Dong.id_dien_thoai = DienThoai.id\n"
                + "join QuocGiaDong on QuocGiaDong.id_dong = Dong.id\n"
                + "join ChiTietDienThoai on QuocGiaDong.id=ChiTietDienThoai.id_quoc_gia_dong\n"
                + "group by DienThoai.[id]\n"
                + "      ,[ma_dien_thoai]\n"
                + "      ,[ten_dien_thoai]\n"
                + "      ,[id_hang]\n"
                + "      ,DienThoai.[trang_thai]";
        List<DienThoaiViewModel> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DienThoaiViewModel a = new DienThoaiViewModel(rs.getString("id"), rs.getString("ma_dien_thoai"), rs.getString("ten_dien_thoai"), rs.getString("id_hang"), rs.getInt("trang_thai"));
                list.add(a);
            }
            return list;
        } catch (SQLException s) {
            s.printStackTrace(System.out);
        }
        return null;
    }

    public int layGia(String maDT) {
        String query = "select gia_ban\n"
                + "from DienThoai \n"
                + "join Dong on DienThoai.id = Dong.id_dien_thoai\n"
                + "join QuocGiaDong on QuocGiaDong.id_dong = Dong.id\n"
                + "join ChiTietDienThoai on ChiTietDienThoai.id_quoc_gia_dong=QuocGiaDong.id\n"
                + "where DienThoai.ma_dien_thoai = ?\n"
                + "group by gia_ban";
        int a = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maDT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getInt(1);
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return 0;
    }

    public int layGiaHoaDon(String imei) {
        String query = "SELECT [gia_ban]\n"
                + "FROM [dbo].[QuocGiaDong]\n"
                + "join ChiTietDienThoai on ChiTietDienThoai.id_quoc_gia_Dong=QuocGiaDong.id\n"
                + "where ChiTietDienThoai.IMEI = ? ";
        int a = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, imei);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getInt(1);
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return 0;
    }

    public List<String> getAllMaHoaDon() {
        String query = "SELECT [ma_hoa_don]\n"
                + "  FROM [dbo].[HoaDon]\n";
        List<String> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("ma_hoa_don"));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDonChiTietViewModel> getAllHoaDon(String maHD) {
        String query = "SELECT HoaDonChiTiet.[id]\n"
                + "      ,[IMEI]\n"
                + "      ,[id_hoa_don]\n"
                + "  FROM [dbo].[HoaDonChiTiet]\n"
                + "  join HoaDon on HoaDon.id=HoaDonChiTiet.id_hoa_don\n"
                + "  where ma_hoa_don = ?";
        List<HoaDonChiTietViewModel> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTietViewModel a = new HoaDonChiTietViewModel(rs.getString("id"), rs.getString("IMEI"), rs.getString("id_hoa_don"));
                list.add(a);
            }
            return list;
        } catch (SQLException s) {
            s.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDonChiTietViewModel> getAllHoaDonCheckTrung(String maHD, String IMEI) {
        String query = "SELECT HoaDonChiTiet.[id]\n"
                + "      ,[IMEI]\n"
                + "      ,[id_hoa_don]\n"
                + "  FROM [dbo].[HoaDonChiTiet]\n"
                + "  join HoaDon on HoaDon.id=HoaDonChiTiet.id_hoa_don\n"
                + "  where ma_hoa_don= ? and IMEI = ?";
        List<HoaDonChiTietViewModel> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maHD);
            ps.setObject(2, IMEI);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTietViewModel a = new HoaDonChiTietViewModel(rs.getString("id"), rs.getString("IMEI"), rs.getString("id_hoa_don"));
                list.add(a);
            }
            return list;
        } catch (SQLException s) {
            s.printStackTrace(System.out);
        }
        return null;
    }

    public List<String> getAllKH() {
        String query = "SELECT [ten_khach_hang]\n"
                + "  FROM [dbo].[KhachHang]";
        List<String> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("ten_khach_hang"));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<String> getAllMaNV() {
        String query = "SELECT [ma_nhan_vien]\n"
                + "  FROM [dbo].[NhanVien]";
        List<String> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("ma_nhan_vien"));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<String> getAllMaGG() {
        String query = "SELECT [ma_khuyen_mai] + ' '+ mo_ta\n"
                + "                  FROM [dbo].[KhuyenMai]";
        List<String> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String getIdHD(String maHD) {
        String query = "SELECT [id]\n"
                + "  FROM [dbo].[HoaDon]\n"
                + "  where ma_hoa_don = ?";
        String a = "";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getString("id");
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean addVaoHoaDonCT(String imei, String maHD) {
        String query = "INSERT INTO [dbo].[HoaDonChiTiet]\n"
                + "           ([IMEI]\n"
                + "           ,[id_hoa_don])\n"
                + "     VALUES\n"
                + "           (?,?)";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, imei);
            ps.setObject(2, getIdHD(maHD));
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean deleteHoaDonCT(String imei, String maHD) {
        String query = "DELETE FROM [dbo].[HoaDonChiTiet]\n"
                + "      WHERE IMEI = ? and id_hoa_don = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, imei);
            ps.setObject(2, getIdHD(maHD));
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean addHoaDon() {
        String query = "INSERT INTO [dbo].[HoaDon]\n"
                + "           ([ma_hoa_don]\n"
                + "           ,[ngay_tao]\n"
                + "		   ,[trang_thai])\n"
                + "     VALUES\n"
                + "           (?,GETDATE(),0)";
        int check = 0;
        String maHD = maHD();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maHD);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public String maHD() {
        HoaDon hd = new HoaDon();
        List<String> hdl = getAllMaHoaDon();
        List<Integer> hds = new ArrayList<>();
        for (String hoaDon : hdl) {
            int soHD = Integer.valueOf(hoaDon.substring(2)) + 1;
            hds.add(soHD);
        }
        int j = 0;
        for (Integer integer : hds) {
            int i = integer;
            if (j < i) {
                j = i;
            }
        }
        return "HD" + j;
    }

    public int layGiaTien(String maHD) {
        String query = "Select SUM(gia_ban) from QuocGiaDong\n"
                + "join ChiTietDienThoai on QuocGiaDong.id=ChiTietDienThoai.id_quoc_gia_dong\n"
                + "join HoaDonChiTiet on ChiTietDienThoai.IMEI=HoaDonChiTiet.IMEI\n"
                + "join HoaDon on HoaDon.id=HoaDonChiTiet.id_hoa_don\n"
                + "where ma_hoa_don = ?";
        int a = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getInt(1);
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return 0;

    }

    public int layGiaGiamGiaPhantram(int giaTien, String maKM) {
        String query = "Select ? * (KhuyenMai.gia_giam / 100) from KhuyenMai\n"
                + "where ma_khuyen_mai = ?";
        int a = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, giaTien);
            ps.setObject(2, maKM);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getInt(1);
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return 0;

    }

    public int layGiaGiamGiaK(String maKM) {
        String query = "SELECT	KhuyenMai.gia_giam\n"
                + "FROM KhuyenMai\n"
                + "where ma_khuyen_mai = ?";
        int a = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maKM);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getInt(1);
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return 0;

    }

    public int layThanhTien(int tongTien, int giamGia) {
        String query = "select ? - ?";
        int a = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, tongTien);
            ps.setObject(2, giamGia);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getInt(1);
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return 0;

    }

    public boolean layDonVi(String maKM) {
        String query = "select KhuyenMai.don_vi \n"
                + "from KhuyenMai\n"
                + "where ma_khuyen_mai = ?";
        boolean a = false;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maKM);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getBoolean(1);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return a;
    }

    public String layIDKH(String tenKH) {
        String query = "SELECT [id]\n"
                + "  FROM [dbo].[KhachHang]\n"
                + "  where ten_khach_hang = ?";
        String a = "";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, tenKH);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getString("id");
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String layIDNV(String maNV) {
        String query = "SELECT [id]\n"
                + "  FROM [dbo].[NhanVien]\n"
                + "  where ma_nhan_vien = ?";
        String a = "";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maNV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getString("id");
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String layIDKM(String maKM) {
        String query = "SELECT [id]\n"
                + "  FROM [dbo].[KhuyenMai]\n"
                + "  where ma_khuyen_mai = ?";
        String a = "";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maKM);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getString("id");
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean thanhToan(String tenKH, String maNV, String maKM, String maHD) {
        String query = "UPDATE [dbo].[HoaDon]\n"
                + "   SET [id_nhan_vien] = ?\n"
                + "      ,[id_khach_hang] = ?\n"
                + "      ,[id_khuyen_mai] = ?\n"
                + "      ,[trang_thai] = 1\n"
                + " WHERE ma_hoa_don = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, layIDNV(maNV));
            ps.setObject(2, layIDKH(tenKH));
            ps.setObject(3, layIDKM(maKM));
            ps.setObject(4, maHD);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public String layTenDong(String maDT) {
        String query = "select ten_dien_thoai+' '+ ten_dong as ten\n"
                + "from DienThoai \n"
                + "join Dong on DienThoai.id = Dong.id_dien_thoai\n"
                + "join QuocGiaDong on QuocGiaDong.id_dong = Dong.id\n"
                + "join ChiTietDienThoai on ChiTietDienThoai.id_quoc_gia_dong=QuocGiaDong.id\n"
                + "where DienThoai.ma_dien_thoai = ? \n"
                + "group by ten_dien_thoai,ten_dong";
        String a = "";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maDT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getString(1);
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDon> getAllHoaDonChuaThanhToan() {
        String query = "SELECT [id]\n"
                + "      ,[ma_hoa_don]\n"
                + "      ,[ngay_tao]\n"
                + "      ,[id_nhan_vien]\n"
                + "      ,[id_khach_hang]\n"
                + "      ,[id_khuyen_mai]\n"
                + "      ,[mo_ta]\n"
                + "      ,[trang_thai]\n"
                + "  FROM [dbo].[HoaDon]\n"
                + "  where trang_thai = 0";
        List<HoaDon> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon a = new HoaDon(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                list.add(a);
            }
            return list;
        } catch (SQLException s) {
            s.printStackTrace(System.out);
        }
        return null;
    }

    public List<String> layIMEITheoMaDT(String maDT) {
        String query = "SELECT [IMEI]\n"
                + "  FROM [dbo].[ChiTietDienThoai]\n"
                + "  join QuocGiaDong on QuocGiaDong.id=ChiTietDienThoai.id_quoc_gia_dong\n"
                + "  join Dong on dong.id=QuocGiaDong.id_dong\n"
                + "  join DienThoai on DienThoai.id = Dong.id_dien_thoai\n"
                + "  where ma_dien_thoai = ? and ChiTietDienThoai.trang_thai=1";
        List<String> list = new ArrayList<>();
        String a = "";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maDT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getString(1);
                list.add(a);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String layTenSP(String imei) {
        String query = "select ten_dien_thoai+' '+ ten_dong as ten\n"
                + "from DienThoai \n"
                + "join Dong on DienThoai.id = Dong.id_dien_thoai\n"
                + "join QuocGiaDong on QuocGiaDong.id_dong = Dong.id\n"
                + "join ChiTietDienThoai on ChiTietDienThoai.id_quoc_gia_dong=QuocGiaDong.id\n"
                + "where ChiTietDienThoai.IMEI= ?";
        String a = "";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, imei);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getString(1);
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean themThongTinVaoHoaDon(String tenKH, String maNV, String maHD) {
        String query = "UPDATE [dbo].[HoaDon]\n"
                + "   SET [id_nhan_vien] = ?\n"
                + "      ,[id_khach_hang] = ?\n"
                + " WHERE ma_hoa_don = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, layIDNV(maNV));
            ps.setObject(2, layIDKH(tenKH));
            ps.setObject(3, maHD);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public String layTenKH(String idKH) {
        String query = "SELECT [ten_khach_hang]\n"
                + "  FROM [dbo].[KhachHang]\n"
                + "  where id = ?";
        String a = "";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idKH);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getString("ten_khach_hang");
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String layMaNV(String idNV) {
        String query = "SELECT [ma_nhan_vien]\n"
                + "  FROM [dbo].[NhanVien]\n"
                + "  where id = ?";
        String a = "";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idNV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getString("ma_nhan_vien");
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<DienThoaiViewModel> timKiemTheoTen(String ten) {
        String query = "SELECT DienThoai.[id]\n"
                + "                      ,[ma_dien_thoai]\n"
                + "                      ,[ten_dien_thoai]\n"
                + "                      ,[id_hang]\n"
                + "                      ,DienThoai.[trang_thai]\n"
                + "                 FROM [dbo].[DienThoai]\n"
                + "                 join Dong on Dong.id_dien_thoai = DienThoai.id\n"
                + "                join QuocGiaDong on QuocGiaDong.id_dong = Dong.id\n"
                + "                join ChiTietDienThoai on QuocGiaDong.id=ChiTietDienThoai.id_quoc_gia_dong\n"
                + "				where ten_dien_thoai like ?\n"
                + "                group by DienThoai.[id] \n"
                + "                     ,[ma_dien_thoai]\n"
                + "                     ,[ten_dien_thoai]\n"
                + "                    ,[id_hang]\n"
                + "                     ,DienThoai.[trang_thai]";
        List<DienThoaiViewModel> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            String tenTim = "%" + ten + "%";
            ps.setObject(1, tenTim);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DienThoaiViewModel a = new DienThoaiViewModel(rs.getString("id"), rs.getString("ma_dien_thoai"), rs.getString("ten_dien_thoai"), rs.getString("id_hang"), rs.getInt("trang_thai"));
                list.add(a);
            }
            return list;
        } catch (SQLException s) {
            s.printStackTrace(System.out);
        }
        return null;
    }

    public boolean updateTrangThaiChiTietDienThoai(String imei) {
        String query = "UPDATE [dbo].[ChiTietDienThoai]\n"
                + "   SET [trang_thai] = 0\n"
                + " WHERE IMEI = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, imei);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public void xoaSPDaCoTrongHD(String imei, String maHD) {
        String query = "DELETE HoaDonChiTiet FROM [dbo].[HoaDonChiTiet] \n"
                + "inner join HoaDon on HoaDon.id=HoaDonChiTiet.id_hoa_don\n"
                + "      WHERE IMEI = ? and HoaDon.ma_hoa_don != ? and HoaDon.trang_thai = 0";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, imei);
            ps.setObject(2, maHD);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
}
