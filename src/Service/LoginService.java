package Service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */


import DomainModel.NhanVien;
import ViewModel.DangNhapFile;
import ViewModel.MaNVViewModel;
import java.util.List;

/**
 *
 * @author buiti
 */
public interface LoginService {

    String login(String username, String pass);

    List<String> ChucVuCBB();

    List<String> IDChucVu();

    String dangKi(NhanVien nv);
 
    String loginWebCam(String cmnd);
    
    String RememberName(String name,String pass);
    
    DangNhapFile auto();
    
    String dangXuat();
    
    List<MaNVViewModel> getMaNV(String cmnd);
    
    String quenMK(String MaNV,String email);
    
    String updatePass(String pass,String maNV);
    
}
