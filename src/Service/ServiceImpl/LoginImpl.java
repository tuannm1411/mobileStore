package Service.ServiceImpl;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import DomainModel.ChucVu;
import DomainModel.NhanVien;
import Repository.ChucVuRepository;
import Repository.LoginRepository;
import Repository.NhanVienRepository;
import Service.LoginService;
import ViewModel.DangNhapFile;
import ViewModel.LoginViewModel;
import ViewModel.MaNVViewModel;
import ViewModel.NhanVienView;
import ViewModel.loginWebCamView;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author buiti
 */
public class LoginImpl implements LoginService {

    NhanVienRepository Nvrp = new NhanVienRepository();

    @Override
    public String login(String username, String pass) {
        List<LoginViewModel> lg = new LoginRepository().getAll();
        for (LoginViewModel loginViewModel : lg) {
            if (loginViewModel.getMa().equalsIgnoreCase(username) && loginViewModel.getMatKhau().equalsIgnoreCase(pass) && loginViewModel.getTenCV().equalsIgnoreCase("Nhân viên")) {
                return "NV";
            }
            if (loginViewModel.getMa().equalsIgnoreCase(username) && loginViewModel.getMatKhau().equalsIgnoreCase(pass) && loginViewModel.getTenCV().equalsIgnoreCase("Quản lý")) {
                return "QL";
            }
        }
        return "NOT";
    }

    @Override
    public List<String> ChucVuCBB() {
        List<String> cbb = new ArrayList<>();
        ChucVuRepository cv = new ChucVuRepository();
        List<ChucVu> fullCH = cv.getAll();
        for (ChucVu chucVu : fullCH) {
            cbb.add(chucVu.getTen());
        }
        return cbb;
    }

    @Override
    public List<String> IDChucVu() {
        List<String> cbb = new ArrayList<>();
        ChucVuRepository cv = new ChucVuRepository();
        List<ChucVu> fullCH = cv.getAll();
        for (ChucVu chucVu : fullCH) {
            cbb.add(chucVu.getId());
        }
        return cbb;
    }

    @Override
    public String dangKi(NhanVien nv) {
        LoginRepository nva = new LoginRepository();
        if (nva.addNV(nv)) {
            return "them thanh cong";
        }

        return "them that bai";
    }

    @Override
    public String loginWebCam(String cmnd) {
        List<loginWebCamView> lg = new LoginRepository().getAllWebCam();
        for (loginWebCamView loginViewModel : lg) {
            if (loginViewModel.getCmnd().equalsIgnoreCase(cmnd) && loginViewModel.getTenChucVu().equalsIgnoreCase("Nhân viên")) {
                return "NV";
            }
            if (loginViewModel.getCmnd().equalsIgnoreCase(cmnd) && loginViewModel.getTenChucVu().equalsIgnoreCase("Quản lý")) {
                return "QL";
            }
        }
        return "NOT";
    }

//    public String rememberName(String name, String pass) {
//        try {
//            //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
//            FileOutputStream fos = new FileOutputStream("login.txt");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            //Bước 2: Ghi dữ liệu
//            DangNhapFile[] dn = {new DangNhapFile(name, pass)};
//            oos.writeObject(dn);
//            //Bước 3: Đóng luồng
//            fos.close();
//            oos.close();
//            return "DONE";
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            return "FAIL";
//        }
//
//    }
    @Override
    public DangNhapFile auto() {
        DangNhapFile dnf = new DangNhapFile();
        try {

            //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
            FileInputStream fis = new FileInputStream("login.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            //Bước 2: Ghi dữ liệu
            DangNhapFile[] dn = (DangNhapFile[]) ois.readObject();
            dnf = dn[0];
            //Bước 3: Đóng luồng
            fis.close();
            ois.close();
            System.out.println("Done!");
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return dnf;
    }

    @Override
    public String dangXuat() {
        try {
            //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
            FileOutputStream fos = new FileOutputStream("login.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //Bước 2: Ghi dữ liệu
            DangNhapFile[] dn = {new DangNhapFile("", "")};
            oos.writeObject(dn);
            //Bước 3: Đóng luồng
            fos.close();
            oos.close();
            return "DANG XUAT THANH CONG";
        } catch (IOException ex) {
            ex.printStackTrace();
            return "FAIL";
        }
    }

    @Override
    public String RememberName(String name, String pass) {
        try {
            //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
            FileOutputStream fos = new FileOutputStream("login.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //Bước 2: Ghi dữ liệu
            DangNhapFile[] dn = {new DangNhapFile(name, pass)};
            oos.writeObject(dn);
            //Bước 3: Đóng luồng
            fos.close();
            oos.close();
            return "DONE";
        } catch (IOException ex) {
            ex.printStackTrace();
            return "FAIL";
        }
    }

    @Override
    public List<MaNVViewModel> getMaNV(String cmnd) {
        List<MaNVViewModel> list = new ArrayList<>();
        list = new LoginRepository().getMaNV(cmnd);
        return list;
    }

    public static void main(String[] args) {
        LoginImpl impl = new LoginImpl();
        System.out.println(impl.getMaNV("034203013817"));
    }

    @Override
    public String quenMK(String MaNV, String email) {
        List<NhanVienView> lg = new NhanVienRepository().getAll();
        for (NhanVienView nhanVienView : lg) {
            if (nhanVienView.getMa().equalsIgnoreCase(MaNV) && nhanVienView.getEmail().equalsIgnoreCase(email)) {
                return "yes";
            }

        }
        return "NOT";
    }

    @Override
    public String updatePass( String pass,String maNV) {
        boolean update = Nvrp.QuenMK(pass,maNV);
        if (update == true) {
            return "Cập nhật thành công";
        } else {
            return "Cập nhật thất bại";
        }
    }
}
