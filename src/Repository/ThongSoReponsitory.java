/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.BoNho;
import DomainModel.Cpu;
import DomainModel.KetNoi;
import DomainModel.ManHinh;
import DomainModel.MauSac;
import DomainModel.Pin;
import DomainModel.ThietKe;
import DomainModel.TienIch;
import Ultilities.SQLServerConnection;
import ViewModel.CameraModelView;
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
public class ThongSoReponsitory {
    
    public boolean ThemHDH(Pin hdh) {
        String query = "INSERT INTO [dbo].[PIN]\n"
                + "           ([dung_luong]\n"
                + "           ,[loai_pin]\n"
                + "           ,[sac]\n"
                + "           ,[dac_biet]\n"
                + "           ,[trang_thai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getDungLuong());
            ps.setObject(2, hdh.getLoaiPin());
            ps.setObject(3, hdh.getSac());
            ps.setObject(4, hdh.getDacBiet());
            ps.setObject(5, hdh.getTrangThai());
            sp = ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }
    
    public boolean SuaHDH(Pin hdh) {
        String query = "UPDATE [dbo].[PIN]\n"
                + "   SET \n"
                + "      [dung_luong] = ?\n"
                + "      ,[loai_pin] = ?\n"
                + "      ,[sac] = ?\n"
                + "      ,[dac_biet] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE id =?";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getDungLuong());
            ps.setObject(2, hdh.getLoaiPin());
            ps.setObject(3, hdh.getSac());
            ps.setObject(4, hdh.getDacBiet());
            ps.setObject(5, hdh.getTrangThai());
            ps.setObject(6, hdh.getId());
            sp = ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }

    public boolean xoaPin(Pin hdh, int tt) {
        String query = "UPDATE [dbo].[PIN]\n"
                + "   SET \n"
                + "      [dung_luong] = ?\n"
                + "      ,[loai_pin] = ?\n"
                + "      ,[sac] = ?\n"
                + "      ,[dac_biet] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE id =?";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getDungLuong());
            ps.setObject(2, hdh.getLoaiPin());
            ps.setObject(3, hdh.getSac());
            ps.setObject(4, hdh.getDacBiet());
            ps.setObject(5, tt);
            ps.setObject(6, hdh.getId());
            sp = ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }
    
    public List<Pin> getPin(int x) {
        String query = "select * from Pin where trang_thai =?";
        List<Pin> ls = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, x);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                Pin sp = new Pin(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
                ls.add(sp);
            }
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return ls;
    }
    
    public boolean ThemThietKe(ThietKe hdh) {
        String query = "INSERT INTO [dbo].[ThietKe]\n"
                + "           ([mat_truoc]\n"
                + "           ,[mat_lung]\n"
                + "           ,[vien]\n"
                + "           ,[trong_luong]\n"
                + "           ,[trang_thai])\n"
                + "     VALUES\n"
                + "         (?,?,?,?,?)";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getMatTruoc());
            ps.setObject(2, hdh.getMatLung());
            ps.setObject(3, hdh.getVien());
            ps.setObject(4, hdh.getTrongLuong());
            ps.setObject(5, hdh.getTrangThai());
            sp = ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }
    
    public boolean SuaThietKe(ThietKe hdh) {
        String query = "UPDATE [dbo].[ThietKe]\n"
                + "   SET [mat_truoc] = ?\n"
                + "      ,[mat_lung] = ?\n"
                + "      ,[vien] = ?\n"
                + "      ,[trong_luong] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE id =?";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getMatTruoc());
            ps.setObject(2, hdh.getMatLung());
            ps.setObject(3, hdh.getVien());
            ps.setObject(4, hdh.getTrongLuong());
            ps.setObject(5, hdh.getTrangThai());
            ps.setObject(6, hdh.getId());
            sp = ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }
    
    public boolean xoaThietKe(ThietKe hdh, int tt) {
        String query = "UPDATE [dbo].[ThietKe]\n"
                + "   SET [mat_truoc] = ?\n"
                + "      ,[mat_lung] = ?\n"
                + "      ,[vien] = ?\n"
                + "      ,[trong_luong] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE id =?";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getMatTruoc());
            ps.setObject(2, hdh.getMatLung());
            ps.setObject(3, hdh.getVien());
            ps.setObject(4, hdh.getTrongLuong());
            ps.setObject(5, tt);
            ps.setObject(6, hdh.getId());
            sp = ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }
    
    public List<ThietKe> getThietKe(int x) {
        String query = "select * from ThietKe where trang_thai =?";
        List<ThietKe> ls = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, x);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                ThietKe sp = new ThietKe(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
                ls.add(sp);
            }
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return ls;
    }
    
    public boolean ThemBN(BoNho hdh) {
        String query = "INSERT INTO [dbo].[BoNho]\n"
                + "           ([so_luong_ram]\n"
                + "           ,[so_Luong_rom]\n"
                + "           ,[the_nho]\n"
                + "           ,[trang_thai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getRAM());
            ps.setObject(2, hdh.getROM());
            ps.setObject(3, hdh.getTheNho());
            ps.setObject(4, hdh.getTrangThai());
            sp = ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }
    
    public boolean SuaBN(BoNho hdh) {
        String query = "UPDATE [dbo].[BoNho]\n"
                + "   SET [so_luong_ram] = ?\n"
                + "      ,[so_Luong_rom] = ?\n"
                + "      ,[the_nho] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE id =?\n";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getRAM());
            ps.setObject(2, hdh.getROM());
            ps.setObject(3, hdh.getTheNho());
            ps.setObject(4, hdh.getTrangThai());
            ps.setObject(5, hdh.getId());
            sp = ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }
    
    public boolean xoaBN(BoNho hdh, int tt) {
        String query = "UPDATE [dbo].[BoNho]\n"
                + "   SET [so_luong_ram] = ?\n"
                + "      ,[so_Luong_rom] = ?\n"
                + "      ,[the_nho] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE id =?\n";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getRAM());
            ps.setObject(2, hdh.getROM());
            ps.setObject(3, hdh.getTheNho());
            ps.setObject(4, tt);
            ps.setObject(5, hdh.getId());
            sp = ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }
    
    public List<BoNho> getBN(int i) {
        String query = "select * from BoNho where trang_thai = ?";
        List<BoNho> ls = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, i);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BoNho sp = new BoNho(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                ls.add(sp);
            }
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return ls;
    }
    
    public boolean ThemCPU(Cpu hdh) {
        String query = "INSERT INTO [dbo].[CPU]\n"
                + "           ([ten_CPU]\n"
                + "           ,[GPU]\n"
                + "           ,[loai]\n"
                + "           ,[hang_cpu]\n"
                + "           ,[tien_trinh]\n"
                + "           ,[trang_thai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getCPU());
            ps.setObject(2, hdh.getGPU());
            ps.setObject(3, hdh.getLoai());
            ps.setObject(5, hdh.getTienTrinh());
            ps.setObject(4, hdh.getHang());
            ps.setObject(6, hdh.getTrangThai());
            sp = ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }
    
    public boolean SuaCPU(Cpu hdh) {
        String query = "UPDATE [dbo].[CPU]\n"
                + "   SET [ten_CPU] = ?\n"
                + "      ,[GPU] = ?\n"
                + "      ,[loai] = ?\n"
                + "      ,[hang_cpu] = ?\n"
                + "      ,[tien_trinh] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE id =?";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getCPU());
            ps.setObject(2, hdh.getGPU());
            ps.setObject(3, hdh.getLoai());
            ps.setObject(5, hdh.getTienTrinh());
            ps.setObject(4, hdh.getHang());
            ps.setObject(6, hdh.getTrangThai());
            ps.setObject(7, hdh.getId());
            sp = ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }

    public boolean xoaCPU(Cpu hdh, int tt) {
        String query = "UPDATE [dbo].[CPU]\n"
                + "   SET [ten_CPU] = ?\n"
                + "      ,[GPU] = ?\n"
                + "      ,[loai] = ?\n"
                + "      ,[hang_cpu] = ?\n"
                + "      ,[tien_trinh] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE id =?";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getCPU());
            ps.setObject(2, hdh.getGPU());
            ps.setObject(3, hdh.getLoai());
            ps.setObject(5, hdh.getTienTrinh());
            ps.setObject(4, hdh.getHang());
            ps.setObject(6, tt);
            ps.setObject(7, hdh.getId());
            sp = ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }
    
    public List<Cpu> getCpu(int x) {
        String query = "select * from CPU where trang_thai = ?";
        List<Cpu> ls = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, x);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                Cpu sp = new Cpu(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getInt(7));
                
                ls.add(sp);
            }
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return ls;
    }
    
    public boolean ThemMau(MauSac hdh) {
        String query = "INSERT INTO [dbo].[MauSac]\n"
                + "           ([ma_mau]\n"
                + "           ,[ten_mau]\n"
                + "           ,[trang_thai])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getMa());
            ps.setObject(2, hdh.getTen());
            
            ps.setObject(3, hdh.getTrangThai());
            sp = ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }
    
    public boolean SuaMau(MauSac hdh) {
        String query = "UPDATE [dbo].[MauSac]\n"
                + "   SET [ma_mau] = ?\n"
                + "      ,[ten_mau] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE id =?";
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

    public boolean xoaMau(MauSac hdh, int tt) {
        String query = "UPDATE [dbo].[MauSac]\n"
                + "   SET [ma_mau] = ?\n"
                + "      ,[ten_mau] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE id =?";
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
    
    public List<MauSac> getMau(int x) {
        String query = "select * from MauSac where trang_thai = ?";
        List<MauSac> ls = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, x);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                MauSac sp = new MauSac(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                
                ls.add(sp);
            }
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return ls;
    }
    
    public boolean ThemTi(TienIch hdh) {
        String query = "INSERT INTO [dbo].[TienIch]\n"
                + "           ([bao_mat]\n"
                + "           ,[khang_nuoc]\n"
                + "           ,[dac_biet]\n"
                + "           ,[trang_thai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getBaoMat());
            ps.setObject(2, hdh.getKhangNuoc());
            ps.setObject(3, hdh.getDacBiet());
            ps.setObject(4, hdh.getTrangThai());
            sp = ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }
    
    public boolean SuaTi(TienIch hdh) {
        String query = "UPDATE [dbo].[TienIch]\n"
                + "   SET [bao_mat] = ?\n"
                + "      ,[khang_nuoc] =?\n"
                + "      ,[dac_biet] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE id =?";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getBaoMat());
            ps.setObject(2, hdh.getKhangNuoc());
            ps.setObject(3, hdh.getDacBiet());
            ps.setObject(4, hdh.getTrangThai());
            ps.setObject(5, hdh.getId());
            sp = ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }

    public boolean xoaTi(TienIch hdh, int tt) {
        String query = "UPDATE [dbo].[TienIch]\n"
                + "   SET [bao_mat] = ?\n"
                + "      ,[khang_nuoc] =?\n"
                + "      ,[dac_biet] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE id =?";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getBaoMat());
            ps.setObject(2, hdh.getKhangNuoc());
            ps.setObject(3, hdh.getDacBiet());
            ps.setObject(4, tt);
            ps.setObject(5, hdh.getId());
            sp = ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }
    
    public List<TienIch> getTi(int x) {
        String query = "select * from TienIch where trang_thai = ?";
        List<TienIch> ls = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, x);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                TienIch sp = new TienIch(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                
                ls.add(sp);
            }
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return ls;
    }
    
    public boolean ThemMH(ManHinh hdh) {
        String query = "INSERT INTO [dbo].[ManHinh]\n"
                + "           ([loai_man_hinh]\n"
                + "           ,[kieu_man_hinh]\n"
                + "           ,[tang_so_quet]\n"
                + "           ,[do_phan_giai]\n"
                + "           ,[kich_thuoc]\n"
                + "           ,[cong_nghe_di_kem]\n"
                + "           ,[trang_thai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?)";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getLoai());
            ps.setObject(2, hdh.getKieu());
            ps.setObject(3, hdh.getTangSoQuet());
            ps.setObject(4, hdh.getDoPhanGiai());
            ps.setObject(5, hdh.getKichThuoc());
            ps.setObject(6, hdh.getCongNghe());
            ps.setObject(7, hdh.getTrangThai());
            sp = ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }
    
    public boolean SuaMH(ManHinh hdh) {
        String query = "UPDATE [dbo].[ManHinh]\n"
                + "   SET [loai_man_hinh] = ?\n"
                + "      ,[kieu_man_hinh] = ?\n"
                + "      ,[tang_so_quet] = ?\n"
                + "      ,[do_phan_giai] = ?\n"
                + "      ,[kich_thuoc] = ?\n"
                + "      ,[cong_nghe_di_kem] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE id =?";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getLoai());
            ps.setObject(2, hdh.getKieu());
            ps.setObject(3, hdh.getTangSoQuet());
            ps.setObject(4, hdh.getDoPhanGiai());
            ps.setObject(5, hdh.getKichThuoc());
            ps.setObject(6, hdh.getCongNghe());
            ps.setObject(7, hdh.getTrangThai());
            ps.setObject(8, hdh.getId());
            sp = ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }

    public boolean xoaMH(ManHinh hdh, int tt) {
        String query = "UPDATE [dbo].[ManHinh]\n"
                + "   SET [loai_man_hinh] = ?\n"
                + "      ,[kieu_man_hinh] = ?\n"
                + "      ,[tang_so_quet] = ?\n"
                + "      ,[do_phan_giai] = ?\n"
                + "      ,[kich_thuoc] = ?\n"
                + "      ,[cong_nghe_di_kem] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE id =?";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getLoai());
            ps.setObject(2, hdh.getKieu());
            ps.setObject(3, hdh.getTangSoQuet());
            ps.setObject(4, hdh.getDoPhanGiai());
            ps.setObject(5, hdh.getKichThuoc());
            ps.setObject(6, hdh.getCongNghe());
            ps.setObject(7, tt);
            ps.setObject(8, hdh.getId());
            sp = ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }
    
    public List<ManHinh> getMH(int x) {
        String query = "select * from ManHinh where trang_thai = ?";
        List<ManHinh> ls = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, x);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                ManHinh sp = new ManHinh(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                
                ls.add(sp);
            }
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return ls;
    }
    
    public boolean ThemKN(KetNoi hdh) {
        String query = "INSERT INTO [dbo].[KetNoi]\n"
                + "           ([sim]\n"
                + "           ,[hong_ngoai]\n"
                + "           ,[jack35]\n"
                + "           ,[ho_tro_mang]\n"
                + "           ,[wifi]\n"
                + "           ,[blutooth]\n"
                + "           ,[GPS]\n"
                + "           ,[trang_thai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?)";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getSim());
            ps.setObject(2, hdh.getHongNgoai());
            ps.setObject(3, hdh.getJackTaiNghe());
            ps.setObject(4, hdh.getHoTroMang());
            ps.setObject(5, hdh.getWifi());
            ps.setObject(6, hdh.getBlutooth());
            ps.setObject(7, hdh.getGPS());
            ps.setObject(8, hdh.getTrangThai());
            sp = ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }
    
    public boolean SuaKN(KetNoi hdh) {
        String query = "UPDATE [dbo].[KetNoi]\n"
                + "   SET [sim] = ?\n"
                + "      ,[hong_ngoai] = ?\n"
                + "      ,[jack35] = ?\n"
                + "      ,[ho_tro_mang] = ?\n"
                + "      ,[wifi] = ?\n"
                + "      ,[blutooth] = ?\n"
                + "      ,[GPS] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE id =?";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getSim());
            ps.setObject(2, hdh.getHongNgoai());
            ps.setObject(3, hdh.getJackTaiNghe());
            ps.setObject(4, hdh.getHoTroMang());
            ps.setObject(5, hdh.getWifi());
            ps.setObject(6, hdh.getBlutooth());
            ps.setObject(7, hdh.getGPS());
            ps.setObject(8, hdh.getTrangThai());
            ps.setObject(9, hdh.getId());
            sp = ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }
    
    public boolean xoaKN(KetNoi hdh, int tt) {
        String query = "UPDATE [dbo].[KetNoi]\n"
                + "   SET [sim] = ?\n"
                + "      ,[hong_ngoai] = ?\n"
                + "      ,[jack35] = ?\n"
                + "      ,[ho_tro_mang] = ?\n"
                + "      ,[wifi] = ?\n"
                + "      ,[blutooth] = ?\n"
                + "      ,[GPS] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE id =?";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getSim());
            ps.setObject(2, hdh.getHongNgoai());
            ps.setObject(3, hdh.getJackTaiNghe());
            ps.setObject(4, hdh.getHoTroMang());
            ps.setObject(5, hdh.getWifi());
            ps.setObject(6, hdh.getBlutooth());
            ps.setObject(7, hdh.getGPS());
            ps.setObject(8, tt);
            ps.setObject(9, hdh.getId());
            sp = ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }
    
    public List<KetNoi> getKN(int x) {
        String query = "select * from KetNoi where trang_thai = ?";
        List<KetNoi> ls = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, x);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                KetNoi sp = new KetNoi(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
                
                ls.add(sp);
            }
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return ls;
    }
    
    public List<CameraModelView> getCMD() {
        String query = "select cam_bien,khau_do, chuc_nang,max_zoom,quay_video from Camera join CamBien on CamBien.id = Camera.id_cam_bien";
        List<CameraModelView> ls = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                CameraModelView sp = new CameraModelView(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                
                ls.add(sp);
            }
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return ls;
    }
    
    public List<CameraModelView> get1CMD(String id) {
        String query = "select cam_bien,khau_do, chuc_nang,max_zoom,quay_video from Camera join CamBien on CamBien.id = Camera.id_cam_bien\n"
                + "where id_thong_so = ?";
        List<CameraModelView> ls = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                CameraModelView sp = new CameraModelView(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                
                ls.add(sp);
            }
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return ls;
    }
    
    public static void main(String[] args) {
        for (KetNoi cpu : new ThongSoReponsitory().getKN(0)) {
            System.out.println(cpu.toString());
        }
    }
}
