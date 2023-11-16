/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.BoNho;
import DomainModel.ChiTietDienThoai;
import DomainModel.Cpu;
import DomainModel.DienThoai;
import DomainModel.Dong;
import DomainModel.Hang;
import DomainModel.HeDieuHanh;
import DomainModel.KetNoi;
import DomainModel.ManHinh;
import DomainModel.MauSac;
import DomainModel.Pin;
import DomainModel.QuocGia;
import DomainModel.ThietKe;
import DomainModel.ThongSo;
import DomainModel.TienIch;
import ViewModel.SanPhamViewModel;
import ViewModel.ThongSoViewModel;
import java.util.List;

/**
 *
 * @author haha
 */
public interface SanPhamServices {

    List<SanPhamViewModel> getAll();

    List<SanPhamViewModel> getAlldx();

    List<SanPhamViewModel> getTimKiemSanPham(String tk);

    ThongSoViewModel getAllThongSo(String id);

    String ban(String IMEI);

    List<SanPhamViewModel> timKiem(String x);

    List<String> getImei(String id);

    List<HeDieuHanh> getHDH(int x);

    String addHDH(HeDieuHanh hdh);

    String addDT(ThongSo ts);

    String suaHDH(HeDieuHanh hdh);

    String xoaHDH(HeDieuHanh hdh, int tt);

    List<Pin> getPin(int x);

    String addPin(Pin hdh);

    String suaPin(Pin hdh);

    String xoaPin(Pin hdh, int tt);

    List<ThietKe> getTK(int x);

    String addTK(ThietKe tk);

    String suaTK(ThietKe tk);

    String xoaTK(ThietKe tk, int tt);

    List<BoNho> getBN(int i);

    String addBN(BoNho tk);

    String suaBN(BoNho tk);

    String xoaBN(BoNho tk, int tt);

    List<Cpu> getCPU(int x);

    String addCPU(Cpu tk);

    String suaCPU(Cpu tk);

    String xoaCPU(Cpu tk, int tt);

    List<MauSac> getMauSacs(int x);

    String addMauSac(MauSac tk);

    String suaMauSac(MauSac tk);

    String xoaMauSac(MauSac tk, int tt);

    List<TienIch> getTI(int x);

    String addTI(TienIch tk);

    String suaTI(TienIch tk);

    String xoaTI(TienIch tk, int tt);

    List<ManHinh> getHM(int x);

    String addHM(ManHinh tk);

    String suaHM(ManHinh tk);

    String xoaHM(ManHinh tk, int tt);

    List<KetNoi> getKN(int x);

    String addKN(KetNoi tk);

    String xoaKN(KetNoi tk, int tt);

    String suaKN(KetNoi tk);

    List<Hang> getHang();

    List<Dong> getDong();

    List<DienThoai> getDT();

    List<QuocGia> getQG();

    ChiTietDienThoai moi(String imei);

}
