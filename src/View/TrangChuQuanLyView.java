package View;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
import DomainModel.NhanVien;
import Service.LoginService;
import Service.NhanVienService;
import Service.ServiceImpl.LoginImpl;
import Service.ServiceImpl.NhanVienServiceImpl;
import ViewModel.CMNDViewModel;
import ViewModel.CheckEmail;
import ViewModel.CheckSDT;
import ViewModel.ClockThread;
//import Service.LoginService;
//import Service.NhanVienService;
//import Service.ServiceImpl.LoginImpl;
//import Service.ServiceImpl.NhanVienImpl;
import ViewModel.NhanVienView;
import ViewModel.checkTrungManv;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import table.TableCustom;

/**
 *
 * @author buiti
 */
public class TrangChuQuanLyView extends javax.swing.JDialog {

    /**
     * Creates new form TrangChuQuanLyView
     */
    private DefaultTableModel dtm = new DefaultTableModel();
    private List<NhanVienView> listNV = new ArrayList<>();
    private NhanVienService impl = new NhanVienServiceImpl();
    private LoginService implDX = new LoginImpl();
    private DefaultComboBoxModel modelccbCV;
    List<String> idCV = impl.IDChucVu();
    int index = 1;
    String name = "";
    String a2 = "";
    int width = 260;
    int height = 950;
    String namx;
    String ngayx;
    String thangx;

    public TrangChuQuanLyView(String a) {
        initComponents();
        String header[] = {"id", "Mã Nhân viên", "Tên Nhân viên", "id Chức vụ", "Chức vụ", "Ngày sinh", "SDT", "Email", "Địa chỉ", "Mật khẩu", "Trạng thái", "CMND"};
        jTable1.setModel(dtm);
        dtm.setColumnIdentifiers(header);
        listNV = impl.getAll();
        txtLayMa.setText(a);
        impl.showData(dtm, listNV);
        addCbb();
        a2 = a;
        ClockThread clockThread = new ClockThread(lblTime);
        Thread t1 = new Thread(clockThread);
        textNgay.setText(java.time.LocalDate.now() + "");
        t1.start();
        //chỉnh table
        getContentPane().setBackground(Color.WHITE);
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
//        testData();
        txtCMND.setBackground(new java.awt.Color(0, 0, 4, 0));
        getContentPane().setBackground(new Color(255, 255, 255));
        combobox1.setSelectedIndex(0);
        cbbCV.setSelectedIndex(0);
    }

    public void addCbb() {
        modelccbCV = (DefaultComboBoxModel) cbbCV.getModel();
        modelccbCV.addAll(impl.ChucVuCBB());

    }

    void openMenuBar() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < width; i++) {
                    pnMenu.setSize(i, height);
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TrangChuQuanLyView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    void closeMenuBar() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = width; i > 0; i--) {
                    pnMenu.setSize(i, height);
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TrangChuQuanLyView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    public void DangKi() {
        NhanVien nv = new NhanVien();
        Boolean conf1 = false;
        Boolean conf2 = false;
        Boolean conf3 = false;
        Boolean conf4 = false;
        Boolean conf5 = false;
        Boolean conf6 = false;
        Boolean conf7 = false;
        Boolean conf8 = false;
        Boolean conf9 = false;

        List<checkTrungManv> list = new ArrayList<>();
        impl.checkTrungIMEI(txtMaNV.getText(), list);
        List<CMNDViewModel> listcmnd = new ArrayList<>();
        impl.checkTrungCMND(txtCMND.getText(), listcmnd);
        List<CheckSDT> listsdt = new ArrayList<>();
        impl.checkTrungsdt(txtSDT.getText(), listsdt);
        List<CheckEmail> listEmail = new ArrayList<>();
        impl.checkTrungEmail(txtEmail.getText(), listEmail);

        if (txtMaNV.getText().isEmpty()) {
            txtRPMa.setText("Mã không được để Trống");
            txtRPMa.setForeground(Color.red);
        } else if (txtMaNV.getText().matches("/^[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]*$/")) {
            txtRPMa.setText("Mã không được chứa kí tự đặc biệt");
            txtRPMa.setForeground(Color.red);
        }else
        if (list.size() > 0) {
            JOptionPane.showMessageDialog(rootPane, "Mã nhân viên đã tồn tại");
            txtRPMa.setText("*");
            txtRPMa.setForeground(Color.yellow);
        } else {
            txtRPMa.setText("*");
            txtRPMa.setForeground(Color.green);
            nv.setMa(txtMaNV.getText());
            conf1 = true;
        }
        if (txtTenNV.getText().isEmpty()) {
            txtRPTen.setText("Tên không được để Trống");
            txtRPTen.setForeground(Color.red);
        } else if (!txtTenNV.getText().matches("^[A-Z a-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]{1,150}+$")) {
            txtRPTen.setText("Tên không được số hoặc kí tự");
            txtRPTen.setForeground(Color.red);
        } else {
            txtRPTen.setText("*");
            txtRPTen.setForeground(Color.green);
            nv.setTen(txtTenNV.getText());
            conf2 = true;
        }
        if (txtNgaySinhNV.getText().isEmpty()) {
            txtRPNgaySinh.setText("Ngày Sinh đang trống");
            txtRPNgaySinh.setForeground(Color.red);

        } else if (!txtNgaySinhNV.getText().matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$")) {
            txtRPNgaySinh.setText("Sai định dạng [Năm-Tháng-Ngày(yyyy-mm-dd)]");
            txtRPNgaySinh.setForeground(Color.red);

        } else {
            txtRPNgaySinh.setText("*");

            txtRPNgaySinh.setForeground(Color.green);
            nv.setNgaySinh(txtNgaySinhNV.getText());
            conf3 = true;

        }
        if (txtDiaChiNV.getText().isEmpty()) {
            txtRPDiaChi.setText("Ngày sinh đang trống");
            txtRPDiaChi.setForeground(Color.red);

        } else {
            txtRPDiaChi.setText("*");
            txtRPDiaChi.setForeground(Color.GREEN);

            nv.setDiaChi(txtDiaChiNV.getText());
            conf4 = true;
        }

        String validateEmail = txtEmail.getText();
        if (txtEmail.getText().isEmpty()) {
            txtRPEmail.setText("Email đang trống");
            txtRPEmail.setForeground(Color.red);

        } else if (!validateEmail.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            txtRPEmail.setText("Sai định dạng email (example@gmail.com)");
            txtRPEmail.setForeground(Color.red);

        }else
        if (listEmail.size() > 0) {
            JOptionPane.showMessageDialog(rootPane, "Email đã tồn tại");
            txtRPEmail.setText("*");
            txtRPEmail.setForeground(Color.yellow);
        } else {
            txtRPEmail.setText("*");

            txtRPEmail.setForeground(Color.GREEN);
            nv.setEmail(txtEmail.getText());
            conf5 = true;
        }
        String vadidateSDT = txtSDT.getText();
        if (txtSDT.getText().isEmpty()) {
            txtRPSDT.setText("Số điện thoại đang trống");
            txtRPSDT.setForeground(Color.red);

        } else if (!vadidateSDT.matches("(84|0[3|5|7|8|9])+([0-9]{8})\\b")) {
            txtRPSDT.setText("Sai định dạng số điện thoại");
            txtRPSDT.setForeground(Color.red);

        } else if (listsdt.size() > 0) {
            JOptionPane.showMessageDialog(rootPane, "Số điện thoại đã tồn tại");
            txtRPSDT.setText("*");
            txtRPSDT.setForeground(Color.yellow);
        }else {
            txtRPSDT.setText("*");
            txtRPSDT.setForeground(Color.GREEN);

            nv.setSdt(txtSDT.getText());
            conf6 = true;
        }
        if (txtPass.getText().isEmpty()) {
            txtRPMatKhau.setText("Mật khậu đang trống");
            txtRPMatKhau.setForeground(Color.red);

        } else {
            txtRPMatKhau.setText("*");
            txtRPMatKhau.setForeground(Color.GREEN);
            nv.setSdt(txtSDT.getText());

            conf7 = true;
        }
//        if (cbbCV.getSelectedIndex() == -1) {
//            cbbRPCV.setForeground(Color.red);
//            cbbRPCV.setText("Hãy chọn chức vụ");
//        } else {
//            nv.setIdChucVu(idCV.get(cbbCV.getSelectedIndex()));
//            conf8 = true;
//        }
        if (txtCMND.getText().isEmpty()) {
            txtRPCMND.setText("Mật khậu đang trống");
            txtRPCMND.setForeground(Color.red);

        }else
        if (listcmnd.size() > 0) {
            JOptionPane.showMessageDialog(rootPane, "Số CMND đã tồn tại");
               txtRPCMND.setText("*");
            txtRPCMND.setForeground(Color.yellow);
        } else {
            txtRPCMND.setText("*");
            txtRPCMND.setForeground(Color.GREEN);
            nv.setCmnd(txtCMND.getText());

            conf9 = true;
        }
//        nv.setMa(txtMaNV.getText());
//        nv.setTen(txtTenNV.getText());
//        nv.setNgaySinh(txtNgaySinhNV.getText());
//        nv.setEmail(txtEmail.getText());
//        nv.setDiaChi(txtDiaChiNV.getText());
//        nv.setSdt(txtSDT.getText());

//        System.out.println(nv.toString());
//        JOptionPane.showMessageDialog(rootPane, impl.dangKi(nv));
        if (conf1 == true && conf2 == true && conf3 == true && conf4 == true && conf5 == true && conf6 == true && conf7 == true && conf9==true) {
            nv.setMatKhau(txtPass.getText());
            JOptionPane.showMessageDialog(rootPane, impl.dangKi(nv));
            System.out.println(nv.toString());
//            System.out.println(impl.dangKi(nv));
            listNV = impl.getAll();
            impl.showData(dtm, listNV);
        }
//        
    }

    public String takemaNV() {
        return a2;
    }

    public void fillData(int index) {
        NhanVienView nv = listNV.get(index);
        id.setText(nv.getId());
        txtMaNV.setText(nv.getMa());
        txtTenNV.setText(nv.getTen());
        txtNgaySinhNV.setText(nv.getNgaySinh());
        txtDiaChiNV.setText(nv.getDiaChi());
        txtEmail.setText(nv.getEmail());
        txtPass.setText(nv.getMatKhau());
        txtSDT.setText(nv.getSdt());
        cbbCV.setSelectedItem(nv.getTenChucVu());
        txtCMND.setText(nv.getCmnd());
        if (nv.getTrangThai() == 0) {
            radioNghi.setSelected(true);

        } else {
            radioDangLam.setSelected(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        textNgay = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtCMND = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtRPMa = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        txtRPTen = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNgaySinhNV = new javax.swing.JTextField();
        txtRPNgaySinh = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDiaChiNV = new javax.swing.JTextField();
        txtRPDiaChi = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        txtRPSDT = new javax.swing.JLabel();
        cbbRPCV = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtRPEmail = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPass = new javax.swing.JTextField();
        txtRPMatKhau = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        radioNghi = new javax.swing.JRadioButton();
        radioDangLam = new javax.swing.JRadioButton();
        btnDangKy = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        txtRPCMND = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtttSo = new javax.swing.JLabel();
        txtttHoTen = new javax.swing.JLabel();
        txtttNgaySinh = new javax.swing.JLabel();
        txtttGioiTinh = new javax.swing.JLabel();
        txttDiaChi = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnUpdate1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        combobox1 = new javax.swing.JComboBox<>();
        cbbCV = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        pnMenu = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtLayMa = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 153, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(204, 0, 51), new java.awt.Color(204, 51, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách người dùng"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 508, 1400, 360));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 153, 0));
        jLabel20.setText("  |<");
        jLabel20.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(255, 51, 0), new java.awt.Color(255, 102, 0)));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 890, 60, 40));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 153, 0));
        jLabel21.setText(" <<");
        jLabel21.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 153, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(255, 51, 0), new java.awt.Color(255, 102, 0)));
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 890, 57, 40));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 153, 0));
        jLabel22.setText(" >>");
        jLabel22.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 153, 0), new java.awt.Color(255, 0, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(255, 204, 0)));
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 890, 53, 40));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 153, 0));
        jLabel23.setText("  >|");
        jLabel23.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 102, 0), new java.awt.Color(255, 51, 0), new java.awt.Color(255, 204, 0), new java.awt.Color(255, 204, 0)));
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 890, 60, 40));

        lblTime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTime.setText("00:00 AM");
        jPanel4.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 480, -1, 22));

        textNgay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textNgay.setText("Date");
        jPanel4.add(textNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 480, 120, 20));

        jLabel15.setText("ID");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setText(" ");
        jPanel4.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 275, 25));

        jLabel25.setText("CMND");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        txtCMND.setBackground(new java.awt.Color(102, 102, 102));
        txtCMND.setForeground(new java.awt.Color(255, 255, 255));
        txtCMND.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 51), new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(204, 204, 204)));
        jPanel4.add(txtCMND, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 260, 26));

        jLabel4.setText("Mã nhân viên");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 74, -1));

        txtMaNV.setBackground(new java.awt.Color(102, 102, 102));
        txtMaNV.setForeground(new java.awt.Color(255, 255, 255));
        txtMaNV.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(204, 204, 204), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(51, 51, 51)));
        jPanel4.add(txtMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 260, 30));
        jPanel4.add(txtRPMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 210, 16));

        jLabel5.setText("Tên nhân viên");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        txtTenNV.setBackground(new java.awt.Color(102, 102, 102));
        txtTenNV.setForeground(new java.awt.Color(255, 255, 255));
        txtTenNV.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(204, 204, 204), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(51, 51, 51)));
        jPanel4.add(txtTenNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 262, 30));
        jPanel4.add(txtRPTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 210, 16));

        jLabel6.setText("Ngày sinh");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 74, -1));

        txtNgaySinhNV.setBackground(new java.awt.Color(102, 102, 102));
        txtNgaySinhNV.setForeground(new java.awt.Color(255, 255, 255));
        txtNgaySinhNV.setText("yyyy-mm-dd");
        txtNgaySinhNV.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 51), new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(204, 204, 204)));
        jPanel4.add(txtNgaySinhNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 262, 30));
        jPanel4.add(txtRPNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 290, 20));

        jLabel7.setText("Địa chỉ");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 37, -1));

        txtDiaChiNV.setBackground(new java.awt.Color(102, 102, 102));
        txtDiaChiNV.setForeground(new java.awt.Color(255, 255, 255));
        txtDiaChiNV.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 51), new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(204, 204, 204)));
        jPanel4.add(txtDiaChiNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 660, 30));
        jPanel4.add(txtRPDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 641, 16));

        jLabel8.setText("Số điện thoại");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 74, -1));

        txtSDT.setBackground(new java.awt.Color(102, 102, 102));
        txtSDT.setForeground(new java.awt.Color(255, 255, 255));
        txtSDT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 51), new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(204, 204, 204)));
        jPanel4.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 221, 30));
        jPanel4.add(txtRPSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 220, 18));
        jPanel4.add(cbbRPCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, 220, 20));

        jLabel10.setText("Email");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, -1, -1));

        txtEmail.setBackground(new java.awt.Color(102, 102, 102));
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 51), new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(204, 204, 204)));
        jPanel4.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 221, 30));
        jPanel4.add(txtRPEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 220, 22));

        jLabel11.setText("Mật khẩu");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 63, -1));

        txtPass.setBackground(new java.awt.Color(102, 102, 102));
        txtPass.setForeground(new java.awt.Color(255, 255, 255));
        txtPass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 51), new java.awt.Color(0, 0, 0), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        jPanel4.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 220, 30));
        jPanel4.add(txtRPMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 221, 20));

        jLabel14.setText("Trạng thái");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, -1, -1));

        buttonGroup1.add(radioNghi);
        radioNghi.setSelected(true);
        radioNghi.setText("Nghỉ");
        jPanel4.add(radioNghi, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, -1, -1));

        buttonGroup1.add(radioDangLam);
        radioDangLam.setText("Đang làm");
        jPanel4.add(radioDangLam, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, -1, -1));

        btnDangKy.setBackground(new java.awt.Color(51, 51, 51));
        btnDangKy.setForeground(new java.awt.Color(255, 255, 255));
        btnDangKy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/use.png"))); // NOI18N
        btnDangKy.setText("Thêm");
        btnDangKy.setBorder(null);
        btnDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKyActionPerformed(evt);
            }
        });
        jPanel4.add(btnDangKy, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 130, 50));

        btnUpdate.setBackground(new java.awt.Color(51, 51, 51));
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Sửa");
        btnUpdate.setBorder(null);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel4.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, 130, 50));

        jButton6.setBackground(new java.awt.Color(51, 51, 51));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Chuyển trạng thái");
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, 130, 50));

        jButton11.setBackground(new java.awt.Color(0, 102, 0));
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/excel.png"))); // NOI18N
        jButton11.setText("import Excel");
        jButton11.setBorder(null);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, 130, 50));
        jPanel4.add(txtRPCMND, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 260, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 153, 0));
        jLabel13.setText("arch");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, -1, 20));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("Se");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, -1, 20));

        txtSearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(255, 0, 51), new java.awt.Color(255, 51, 0)));
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel4.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, 310, 38));

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 51), new java.awt.Color(0, 0, 0), java.awt.Color.gray, new java.awt.Color(204, 204, 204)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Thông tin căn cước");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 9, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Họ và Tên :");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Số / No     :");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 55, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Ngày sinh  :");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 125, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Giới tính     :");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 154, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Địa chỉ        :");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 189, -1, -1));

        txtttSo.setForeground(new java.awt.Color(255, 255, 255));
        txtttSo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtttSo.setText("jLabel26");
        jPanel5.add(txtttSo, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 56, -1, -1));

        txtttHoTen.setForeground(new java.awt.Color(255, 255, 255));
        txtttHoTen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtttHoTen.setText("jLabel27");
        jPanel5.add(txtttHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 91, -1, -1));

        txtttNgaySinh.setForeground(new java.awt.Color(255, 255, 255));
        txtttNgaySinh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtttNgaySinh.setText("jLabel29");
        jPanel5.add(txtttNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 126, -1, -1));

        txtttGioiTinh.setForeground(new java.awt.Color(255, 255, 255));
        txtttGioiTinh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtttGioiTinh.setText("jLabel30");
        jPanel5.add(txtttGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 155, -1, -1));

        txttDiaChi.setForeground(new java.awt.Color(255, 255, 255));
        txttDiaChi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txttDiaChi.setText("jLabel32");
        jPanel5.add(txttDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 190, -1, -1));

        jButton12.setBackground(new java.awt.Color(51, 51, 51));
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/inBox.png"))); // NOI18N
        jButton12.setText("Lấy thông tin");
        jButton12.setBorder(null);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 130, 50));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/z3946860666735_30f52c7f5e3d1a6b5fd11409bdce2492.jpg"))); // NOI18N
        jButton1.setText("ADD QR");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 130, 50));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 30, 520, 380));

        btnUpdate1.setBackground(new java.awt.Color(51, 51, 51));
        btnUpdate1.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate1.setText("Refresh Table");
        btnUpdate1.setBorder(null);
        btnUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnUpdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 380, 130, 50));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("X");
        jLabel19.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 51), new java.awt.Color(0, 0, 0), java.awt.Color.white, new java.awt.Color(204, 204, 204)));
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 0, 40, 30));

        combobox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên nhân viên", "Mã nhân viên", "SDT", "CMND" }));
        jPanel4.add(combobox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 450, 130, 30));

        jPanel4.add(cbbCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, 220, 30));

        jLabel9.setText("Chức vụ");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 1410, 950));

        pnMenu.setBackground(new java.awt.Color(102, 102, 102));
        pnMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Account.png"))); // NOI18N
        jLabel16.setText("Mã :");
        pnMenu.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 60));

        txtLayMa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtLayMa.setForeground(new java.awt.Color(255, 255, 255));
        pnMenu.add(txtLayMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 140, 40));

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/NguoiDUng1.png"))); // NOI18N
        jButton2.setText("Chức vụ");
        jButton2.setBorder(null);
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnMenu.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 240, 52));

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/SAnPham1.png"))); // NOI18N
        jButton3.setText("Sản phẩm");
        jButton3.setBorder(null);
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        pnMenu.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 240, 52));

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/KhachHang.png"))); // NOI18N
        jButton4.setText("Khách hàng");
        jButton4.setBorder(null);
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        pnMenu.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 240, 52));

        jButton5.setBackground(new java.awt.Color(51, 51, 51));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ThongKe.png"))); // NOI18N
        jButton5.setText("Thống kê");
        jButton5.setBorder(null);
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        pnMenu.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 240, 52));

        jButton7.setBackground(new java.awt.Color(51, 51, 51));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Gif.png"))); // NOI18N
        jButton7.setText("Khuyến mại");
        jButton7.setBorder(null);
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        pnMenu.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 240, 52));

        jButton8.setBackground(new java.awt.Color(51, 51, 51));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/banHang.png"))); // NOI18N
        jButton8.setText("Bán hàng");
        jButton8.setBorder(null);
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        pnMenu.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 240, 52));

        jButton9.setBackground(new java.awt.Color(51, 51, 51));
        jButton9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/HoaDon.png"))); // NOI18N
        jButton9.setText("Hóa đơn");
        jButton9.setBorder(null);
        jButton9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        pnMenu.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 240, 52));

        jButton10.setBackground(new java.awt.Color(51, 51, 51));
        jButton10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logout.png"))); // NOI18N
        jButton10.setText("Đăng xuất");
        jButton10.setBorder(null);
        jButton10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        pnMenu.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 800, 240, 52));

        jButton13.setBackground(new java.awt.Color(51, 51, 51));
        jButton13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ThongTincaNhan.png"))); // NOI18N
        jButton13.setText("Hồ sơ cá nhân");
        jButton13.setBorder(null);
        jButton13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        pnMenu.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 240, 52));

        jPanel1.add(pnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 960));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/brackgroudTrangChu.jpg"))); // NOI18N
        jLabel28.setText("jLabel28");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1690, 1030));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1691, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        fillData(row);

    }//GEN-LAST:event_jTable1MouseClicked

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        name = txtSearch.getText();
        if(combobox1.getSelectedIndex()==0){
        listNV = impl.searchNhanVien(name);
        impl.showData(dtm, listNV);
    }if(combobox1.getSelectedIndex()==2){
        listNV = impl.searchsdt(name);
        impl.showData(dtm, listNV);
                }
    if(combobox1.getSelectedIndex()==3){
        listNV = impl.searchcmnd(name);
        impl.showData(dtm, listNV);
                }
        if(combobox1.getSelectedIndex()==1){
        listNV = impl.searchMaNV(name);
        impl.showData(dtm, listNV);
                }
        
        
        

    }//GEN-LAST:event_txtSearchKeyReleased

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        index--;
        if (index == 0) {

            index = listNV.size() - 1;
        }
        fillData(index);
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        index++;
        if (index > listNV.size() - 1) {

            index = 0;
        }
        fillData(index);
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        index = 0;

        fillData(index);
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        index = listNV.size() - 1;
        fillData(index);
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String cmnd = "";
//        int camera = ccbWebcam.getSelectedIndex();
        ScanCode sc = new ScanCode(new java.awt.Frame(), true, 0);
        sc.setVisible(true);
        cmnd = sc.getScanResutlx();
        String soCC = cmnd.substring(0, 12);
        txtCMND.setText(soCC);
        txtttSo.setText(soCC);
        String withouTen = cmnd.substring(14, cmnd.length());

        System.out.println(withouTen);
        String[] splits = withouTen.split("[|]");
        txtttHoTen.setText(splits[0]);
        txttDiaChi.setText(splits[3]);
        txtttGioiTinh.setText(splits[2]);
        String nam = splits[1].substring(4, 8);

        String ngay = splits[1].substring(0, 2);
        String thang = splits[1].substring(2, 4);
        String NS = (ngay + "/" + thang + "/" + nam);
        txtttNgaySinh.setText(NS);
        namx = nam;
        ngayx = ngay;
        thangx = thang;

//        txtTenNV.setText(splits[0]);
//        txtDiaChiNV.setText(splits[3]);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_maActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int row = jTable1.getSelectedRow();
        NhanVienView nv = listNV.get(row);
        String id = nv.getId();
        JOptionPane.showMessageDialog(rootPane, impl.chuyenTTNV(id));
        listNV.add(nv);
        listNV = impl.getAll();
        impl.showData(dtm, listNV);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKyActionPerformed
        DangKi();   // TODO add your handling code here:
    }//GEN-LAST:event_btnDangKyActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        NhanVien nv = new NhanVien();
        String ids = id.getText();
        nv.setMa(txtMaNV.getText());
        nv.setTen(txtTenNV.getText());
        nv.setNgaySinh(txtNgaySinhNV.getText());
        nv.setEmail(txtEmail.getText());
        nv.setDiaChi(txtDiaChiNV.getText());
        nv.setSdt(txtSDT.getText());
        nv.setIdChucVu(idCV.get(cbbCV.getSelectedIndex()));
        nv.setMatKhau(txtPass.getText());
        if (radioNghi.isSelected()) {
            nv.setTrangThai(1);
        } else {
            nv.setTrangThai(2);
        }
        JOptionPane.showMessageDialog(rootPane, impl.update(nv, ids));
        listNV = impl.getAll();
        impl.showData(dtm, listNV);
        System.out.println(id);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new ViewChucVu().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        QuanLySanPhamView spv = new QuanLySanPhamView();
        spv.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        new KhachHangViewQuanLy().setVisible(true);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new ThongKeView().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        new ViewKhuyenMai().setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        new BanHangView().setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        new ViewHoaDon().setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        System.out.println(implDX.dangXuat());
        this.dispose();
        new LOGINview().setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        txtCMND.setText(txtttSo.getText());
        txtDiaChiNV.setText(txttDiaChi.getText());

        txtNgaySinhNV.setText(namx + "-" + thangx + "-" + ngayx);
        txtPass.setText(UUID.randomUUID().toString().substring(0, 8));
        txtTenNV.setText(txtttHoTen.getText());
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        HoSoCaNhanView ql = new HoSoCaNhanView(a2);
        ql.setVisible(true);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        ImportExcelNhanVienView excelNhanVienView = new ImportExcelNhanVienView();
        excelNhanVienView.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void btnUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate1ActionPerformed
listNV = impl.getAll();
        impl.showData(dtm, listNV);
    }//GEN-LAST:event_btnUpdate1ActionPerformed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel19MouseClicked
    public void setColor(JPanel p) {
        p.setBackground(new Color(255, 105, 0));
    }

    public void retColor(JPanel p1) {
        p1.setBackground(new Color(255, 153, 0));
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangKy;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdate1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbCV;
    private javax.swing.JLabel cbbRPCV;
    private javax.swing.JComboBox<String> combobox1;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblTime;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JRadioButton radioDangLam;
    private javax.swing.JRadioButton radioNghi;
    private javax.swing.JLabel textNgay;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtDiaChiNV;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JLabel txtLayMa;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNgaySinhNV;
    private javax.swing.JTextField txtPass;
    private javax.swing.JLabel txtRPCMND;
    private javax.swing.JLabel txtRPDiaChi;
    private javax.swing.JLabel txtRPEmail;
    private javax.swing.JLabel txtRPMa;
    private javax.swing.JLabel txtRPMatKhau;
    private javax.swing.JLabel txtRPNgaySinh;
    private javax.swing.JLabel txtRPSDT;
    private javax.swing.JLabel txtRPTen;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JLabel txttDiaChi;
    private javax.swing.JLabel txtttGioiTinh;
    private javax.swing.JLabel txtttHoTen;
    private javax.swing.JLabel txtttNgaySinh;
    private javax.swing.JLabel txtttSo;
    // End of variables declaration//GEN-END:variables

}
