/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View.SanPham;

import DomainModel.BoNho;
import DomainModel.Camera;
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
import DomainModel.QuocGiaDong;
import DomainModel.ThietKe;
import DomainModel.ThongSo;
import DomainModel.TienIch;
import Service.AddElementServices;
import Service.SanPhamServices;
import Service.ServiceImpl.AddElementImpl;
import Service.ServiceImpl.SanPhamServicesImpl;
import Service.ServiceImpl.TSPImpl;
import Service.ThemSPServices;
import ViewModel.SanPhamViewModel;
import ViewModel.ThongSoViewModel;
import ViewModel.vts;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import table.TableCustom;

/**
 *
 * @author haha
 */
public class ViewADDSP extends javax.swing.JDialog {

    DecimalFormat df = new DecimalFormat("###,###,###,###");
    private KetNoi kn = new KetNoi();
    private Hang hang = new Hang();
    private DienThoai dt = new DienThoai();
    private Dong dong = new Dong();
    private QuocGia quocGia = new QuocGia();
    private BoNho boNho = new BoNho();
    private MauSac ms = new MauSac();
    private ThietKe tk = new ThietKe();
    private Pin pin = new Pin();
    private Cpu cpu = new Cpu();
    private HangView hv = new HangView(new javax.swing.JFrame(), true, "");
    private QuocGiaView qgv = new QuocGiaView(new javax.swing.JFrame(), true, "");
    private QuocGiaDong qgd = new QuocGiaDong();
    private ViewBoNho bnv = new ViewBoNho(new javax.swing.JFrame(), true, "");
    private ViewCamera cmdv = new ViewCamera(new javax.swing.JFrame(), true, "");
    private ViewKetNoi vkn = new ViewKetNoi(new javax.swing.JFrame(), true, "");
    private ViewMH vmh = new ViewMH(new javax.swing.JFrame(), true, "");
    private ViewTI vti = new ViewTI(new javax.swing.JFrame(), true, "");
    private ViewTK vtk = new ViewTK(new javax.swing.JFrame(), true, "");
    private ViewViXuLy vcpu = new ViewViXuLy(new javax.swing.JFrame(), true, "");
    private ViewHDH vhdh = new ViewHDH(new javax.swing.JFrame(), true, "");
    private ViewPinSac vpin = new ViewPinSac(new javax.swing.JFrame(), true, "");
    private ViewSacMau vsm = new ViewSacMau(new javax.swing.JFrame(), true, "");
    private String srcAnh = "";
    private List<String> imei = new ArrayList<>();
    private DefaultComboBoxModel modelCBB;
    private DefaultTableModel modelTT;
    private ThongSoViewModel ts = new ThongSoViewModel();
    private final AddElementServices ae = new AddElementImpl();
    private ThongSo tsAdd = new ThongSo();
    TienIch ti = new TienIch();
    HeDieuHanh hdh = new HeDieuHanh();
    Camera cmd = new Camera();
    ManHinh mh = new ManHinh();
    SanPhamServices sps = new SanPhamServicesImpl();
    ThemSPServices tsp = new TSPImpl();
    String idSQGD = "";
    int doMoi = 100;

    /**
     * Creates new form ViewADDSP
     */
    public ViewADDSP(java.awt.Frame parent, boolean modal, SanPhamViewModel idQGD) {
        super(parent, modal);

        initComponents();
        modelCBB = (DefaultComboBoxModel) cbbIMEI.getModel();
        modelCBB.removeAllElements();
        modelTT = (DefaultTableModel) tblThongTin.getModel();
        srcAnh = "source\\No-Image-Placeholder.png";
        try {
            Image im = ImageIO.read(new File(srcAnh));
            anhSanPham.setText("");
            anhSanPham.setIcon(new ImageIcon(im.getScaledInstance(250, 250, Image.SCALE_DEFAULT)));
        } catch (IOException e) {
            System.out.println("lỗi ảnh");
        }
        if (idQGD != null) {
            if (idQGD.getId().isBlank() == false) {
                ts = sps.getAllThongSo(idQGD.getId());
                idSQGD = idQGD.getId();
                txtHang.setText(idQGD.getTenHang());
                txtDT.setText(idQGD.getTen());
                txtDong.setText(idQGD.getTenDong());
                txtQuocGia.setText(idQGD.getTenQuocGia());
                star();
            }
        }
        loadThongSo();
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);

    }

    private void loadThongSo() {
        modelTT.setRowCount(0);
        for (vts x : ae.view(ts)) {
            Object[] row = new Object[]{x.getThuocTinh(), x.getGiaTri()};
            modelTT.addRow(row);
        }

    }

    private void star() {

        qgd = ae.getf(idSQGD).get(0);
        txtGiaBan.setText(df.format(qgd.getGiaBan()));
        txtGiaNhap.setText(df.format(qgd.getGiaNhap()));
        srcAnh = qgd.getSrcAnh();
        modelCBB.removeAllElements();
        modelCBB.addAll(sps.getImei(idSQGD));
        try {
            Image im = ImageIO.read(new File(srcAnh));
            anhSanPham.setText("");
            anhSanPham.setIcon(new ImageIcon(im.getScaledInstance(250, 250, Image.SCALE_DEFAULT)));
        } catch (Exception e) {
            System.out.println("lỗi ảnh");
        }

    }

    private void addQGD() {

        double giaNhap = 0.0;
        double giaBan = 0.0;
        try {
            giaNhap = Double.parseDouble(txtGiaNhap.getText().replace(",", ""));
            giaBan = Double.parseDouble(txtGiaBan.getText().replace(",", ""));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Giá không được có dấu");
        }
        String idDong = dong.getId();
        String idQuocGia = quocGia.getId();
        qgd = new QuocGiaDong(null, idDong, idQuocGia, giaBan, giaNhap, srcAnh);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        anhSanPham = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtHang = new javax.swing.JTextField();
        btnHang = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtDT = new javax.swing.JTextField();
        btnDienThoai = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();
        txtDong = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnKetNoi = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnQuocGia = new javax.swing.JButton();
        txtQuocGia = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnKetNoi1 = new javax.swing.JButton();
        btnKetNoi2 = new javax.swing.JButton();
        btnKetNoi3 = new javax.swing.JButton();
        btnKetNoi4 = new javax.swing.JButton();
        btnKetNoi5 = new javax.swing.JButton();
        btnKetNoi6 = new javax.swing.JButton();
        btnKetNoi7 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        btnKetNoi8 = new javax.swing.JButton();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtDoMoi = new javax.swing.JTextField();
        btnKetNoi9 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongTin = new javax.swing.JTable();
        cbbIMEI = new combo_suggestion.ComboBoxSuggestion();
        jLabel13 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin cơ bản"));

        anhSanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        anhSanPham.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 204)));
        anhSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anhSanPhamMouseClicked(evt);
            }
        });

        jButton1.setText("Chọn ảnh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Hãng");

        btnHang.setText("Edit");
        btnHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHangActionPerformed(evt);
            }
        });

        jLabel2.setText("Điện thoại");

        btnDienThoai.setText("Edit");
        btnDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDienThoaiActionPerformed(evt);
            }
        });

        btnDong.setText("Edit");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        jLabel3.setText("Dòng");

        btnKetNoi.setText("Edit");
        btnKetNoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetNoiActionPerformed(evt);
            }
        });

        jLabel5.setText("Vi xử lý");

        jLabel6.setText("Bộ nhớ");

        jLabel8.setText("Hệ điều hành");

        jLabel9.setText("Pin");

        jLabel10.setText("Màu sắc");

        jLabel11.setText("Thiết kế");

        jLabel12.setText("Tiện ích");

        jLabel14.setText("Quốc gia");

        btnQuocGia.setText("Edit");
        btnQuocGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuocGiaActionPerformed(evt);
            }
        });

        jLabel15.setText("Kết nối");

        btnKetNoi1.setText("Edit");
        btnKetNoi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetNoi1ActionPerformed(evt);
            }
        });

        btnKetNoi2.setText("Edit");
        btnKetNoi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetNoi2ActionPerformed(evt);
            }
        });

        btnKetNoi3.setText("Edit");
        btnKetNoi3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetNoi3ActionPerformed(evt);
            }
        });

        btnKetNoi4.setText("Edit");
        btnKetNoi4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetNoi4ActionPerformed(evt);
            }
        });

        btnKetNoi5.setText("Edit");
        btnKetNoi5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetNoi5ActionPerformed(evt);
            }
        });

        btnKetNoi6.setText("Edit");
        btnKetNoi6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetNoi6ActionPerformed(evt);
            }
        });

        btnKetNoi7.setText("Edit");
        btnKetNoi7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetNoi7ActionPerformed(evt);
            }
        });

        jLabel16.setText("Camera");

        btnKetNoi8.setText("Edit");
        btnKetNoi8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetNoi8ActionPerformed(evt);
            }
        });

        txtGiaNhap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGiaNhapKeyReleased(evt);
            }
        });

        jLabel4.setText("Giá nhập");

        jLabel7.setText("Giá bán");

        txtGiaBan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGiaBanKeyReleased(evt);
            }
        });

        jLabel17.setText("Độ mới");

        txtDoMoi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDoMoiKeyReleased(evt);
            }
        });

        btnKetNoi9.setText("Edit");
        btnKetNoi9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetNoi9ActionPerformed(evt);
            }
        });

        jLabel19.setText("Màn hình");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane2.setViewportView(txtMoTa);

        jLabel20.setText("Mô tả");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnKetNoi6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnKetNoi7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnKetNoi8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnKetNoi9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)))
                    .addComponent(btnKetNoi3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtHang)
                                    .addComponent(btnHang, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(btnDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnQuocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(txtDT, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDong, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtQuocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(btnKetNoi, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnKetNoi1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnKetNoi2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(132, 132, 132)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(btnKetNoi4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnKetNoi5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(129, 129, 129)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(anhSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGiaNhap)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGiaBan)
                                    .addComponent(jLabel17)
                                    .addComponent(txtDoMoi)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(anhSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButton1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(5, 5, 5)
                        .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel7)
                        .addGap(6, 6, 6)
                        .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel17)
                        .addGap(6, 6, 6)
                        .addComponent(txtDoMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel14))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHang)
                            .addComponent(btnDienThoai)
                            .addComponent(btnDong)
                            .addComponent(btnQuocGia))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnKetNoi)
                            .addComponent(btnKetNoi1)
                            .addComponent(btnKetNoi2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnKetNoi3)
                            .addComponent(btnKetNoi4)
                            .addComponent(btnKetNoi5))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel16))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnKetNoi8)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnKetNoi6)
                                .addComponent(btnKetNoi7))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(6, 6, 6)
                        .addComponent(btnKetNoi9))))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin Chi tiết"));

        tblThongTin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Thuộc tính", "Thông tin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThongTin.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblThongTin.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblThongTin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThongTinMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblThongTin);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cbbIMEI.setEditable(true);
        cbbIMEI.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbbIMEI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IMEI 1", "IMEI 2", "IMEI 3", "IMEI 4" }));
        cbbIMEI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbIMEIActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Danh sách IMEI");

        jButton14.setText("IMEI");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save-regular-24.png"))); // NOI18N
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exit-regular-24.png"))); // NOI18N
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trash-regular-24.png"))); // NOI18N
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit-alt-regular-24.png"))); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbIMEI, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbbIMEI)
                        .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblThongTinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongTinMouseClicked

    }//GEN-LAST:event_tblThongTinMouseClicked

    private void anhSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anhSanPhamMouseClicked


    }//GEN-LAST:event_anhSanPhamMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        anhSanPham.setText("");
        try {
            JFileChooser jfc = new JFileChooser("source");

            FileNameExtensionFilter fnf = new FileNameExtensionFilter("Hình ảnh", "jpg", "png");
            jfc.setFileFilter(fnf);
            jfc.setMultiSelectionEnabled(false);
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();
            if (file != null) {

                srcAnh = file.getPath();
                System.out.println(srcAnh);
                Image im = ImageIO.read(file);
                anhSanPham.setText("");
                anhSanPham.setIcon(new ImageIcon(im.getScaledInstance(250, 250, Image.SCALE_DEFAULT)));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        ViewIMEIexcel c = new ViewIMEIexcel(new javax.swing.JFrame(), true);
        c.setVisible(true);
        if (c.allIMEI().isEmpty() == false) {
            modelCBB.removeAllElements();
            imei = c.allIMEI();
            modelCBB.addAll(imei);
            cbbIMEI.setSelectedIndex(0);
        }

    }//GEN-LAST:event_jButton14ActionPerformed

    private void btnKetNoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetNoiActionPerformed
        vkn.setVisible(true);
        if (vkn.returnKetNoi() != null) {
            kn = vkn.returnKetNoi();
            ts.setKetNoiID(kn.getId());
            ts.setSIM(kn.getSim());
            ts.setBlutooth(kn.getBlutooth());
            ts.setHongNgoai(kn.getHongNgoai());
            ts.setMangHoTro(kn.getHoTroMang());
            ts.setWifi(kn.getWifi());
            ts.setJackTaiNghe(kn.getJackTaiNghe());
            ts.setGPS(kn.getGPS());
            loadThongSo();
        }

    }//GEN-LAST:event_btnKetNoiActionPerformed

    private void btnHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHangActionPerformed
        hv.setVisible(true);
        if (hv.returnHang() != null) {
            hang = hv.returnHang();
            txtHang.setText(hang.getTen());
        }

    }//GEN-LAST:event_btnHangActionPerformed

    private void btnDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDienThoaiActionPerformed

        if (hang == null) {
            JOptionPane.showMessageDialog(rootPane, "vui lòng chọn hãng trước");
        } else {
            DienThoaiView dtv = new DienThoaiView(new javax.swing.JFrame(), true, hang.getId());
            dtv.setVisible(true);
            if (dtv.returnDT() != null) {
                dt = dtv.returnDT();
                txtDT.setText(dt.getTen());
            }
        }
    }//GEN-LAST:event_btnDienThoaiActionPerformed

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        if (dt == null) {
            JOptionPane.showMessageDialog(rootPane, "vui lòng chọn điện thoại trước");
        } else {
            DongView dv = new DongView(new javax.swing.JFrame(), true, dt.getId());

            dv.setVisible(true);
            if (dv.returnDong() != null) {
                dong = dv.returnDong();
                txtDong.setText(dong.getTen());
            }
        }    }//GEN-LAST:event_btnDongActionPerformed

    private void btnQuocGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuocGiaActionPerformed
        qgv.setVisible(true);
        if (qgv.returnQuocGia() != null) {
            quocGia = qgv.returnQuocGia();
            txtQuocGia.setText(quocGia.getTen());
        }
    }//GEN-LAST:event_btnQuocGiaActionPerformed

    private void btnKetNoi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetNoi1ActionPerformed
        vpin.setVisible(true);
        if (vpin.returnPin() != null) {
            pin = vpin.returnPin();
            ts.setPinID(pin.getId());
            ts.setPinDungLuong(pin.getDungLuong());
            ts.setPinLoai(pin.getLoaiPin());
            ts.setPindacBiet(pin.getDacBiet());
            ts.setSac(pin.getSac());
            loadThongSo();

        }
    }//GEN-LAST:event_btnKetNoi1ActionPerformed

    private void btnKetNoi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetNoi2ActionPerformed
        vcpu.setVisible(true);
        if (vcpu.returnCpu() != null) {
            cpu = vcpu.returnCpu();
            ts.setCPU(cpu.getCPU());
            ts.setGPU(cpu.getGPU());
            ts.setCPUHang(cpu.getHang());
            ts.setCPULoai(cpu.getLoai());
            ts.setTienTrinh(cpu.getTienTrinh());
            loadThongSo();
        }
    }//GEN-LAST:event_btnKetNoi2ActionPerformed

    private void btnKetNoi3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetNoi3ActionPerformed
        bnv.setVisible(true);
        if (bnv.returnBoNho() != null) {
            boNho = bnv.returnBoNho();
            ts.setBoNhoID(boNho.getId());
            ts.setRam(boNho.getRAM());
            ts.setRom(boNho.getROM());
            ts.setTheNho(boNho.getTheNho());
            loadThongSo();

        }
    }//GEN-LAST:event_btnKetNoi3ActionPerformed

    private void btnKetNoi4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetNoi4ActionPerformed
        vtk.setVisible(true);
        if (vtk.returnThietKe() != null) {
            tk = vtk.returnThietKe();
            ts.setThietKeID(tk.getId());
            ts.setMatLung(tk.getMatLung());
            ts.setMatTruoc(tk.getMatTruoc());
            ts.setKhungVien(tk.getVien());
            ts.setTrongLuong(tk.getTrongLuong());
            loadThongSo();
        }
    }//GEN-LAST:event_btnKetNoi4ActionPerformed

    private void btnKetNoi5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetNoi5ActionPerformed
        vti.setVisible(true);
        if (vti.returnTienIch() != null) {
            ti = vti.returnTienIch();
            ts.setBaoMat(ti.getBaoMat());
            ts.setKhangNuoc(ti.getKhangNuoc());
            ts.setTienIchID(ti.getId());
            ts.setDacBiet(ti.getDacBiet());
            loadThongSo();
        }
    }//GEN-LAST:event_btnKetNoi5ActionPerformed

    private void btnKetNoi6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetNoi6ActionPerformed
        vsm.setVisible(true);
        if (vsm.returnMauSac() != null) {
            ms = vsm.returnMauSac();
            ts.setMauSacID(ms.getId());
            ts.setMauMa(ms.getMa());
            ts.setMauTen(ms.getTen());
            loadThongSo();
        }
    }//GEN-LAST:event_btnKetNoi6ActionPerformed

    private void btnKetNoi7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetNoi7ActionPerformed
        vhdh.setVisible(true);
        if (vhdh.returnHeDieuHanh() != null) {
            hdh = vhdh.returnHeDieuHanh();
            ts.setHDHID(hdh.getId());
            ts.setHDHphienBan(hdh.getPhienBan());
            ts.setHeDieuhanh(hdh.getTenHDH());
            loadThongSo();
        }
    }//GEN-LAST:event_btnKetNoi7ActionPerformed

    private void btnKetNoi8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetNoi8ActionPerformed
        cmdv.setVisible(true);
        if (cmdv.returnCamera() != null) {
            cmd = cmdv.returnCamera();
            ts.setCameraID(cmd.getId());
            ts.setCameraTruoc(cmd.getCameraTruoc());
            ts.setCameraSau(cmd.getCameraSau());
            ts.setCameraDacBiet(cmd.getDacBiet());
            ts.setQuayVideo(cmd.getQuayVideo());
            ts.setChongRung(cmd.getChongRung());
            ts.setZoom(cmd.getZoom());
            loadThongSo();
        }
    }//GEN-LAST:event_btnKetNoi8ActionPerformed

    private void btnKetNoi9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetNoi9ActionPerformed
        vmh.setVisible(true);
        if (vmh.returnManHinh() != null) {
            mh = vmh.returnManHinh();
            ts.setManHinhID(mh.getId());
            ts.setManHinhKichThuoc(mh.getKichThuoc());
            ts.setManHinhCongNghe(mh.getCongNghe());
            ts.setManHinhKieu(mh.getKieu());
            ts.setManHinhLoai(mh.getLoai());
            ts.setTangSoQuet(mh.getTangSoQuet());
            ts.setDoPhanGiai(mh.getDoPhanGiai());
            loadThongSo();

        }

    }//GEN-LAST:event_btnKetNoi9ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        addQGD();
        if (ae.themQuocGiaDong(qgd).isBlank() == false) {
            JOptionPane.showMessageDialog(this, ae.themQuocGiaDong(qgd) + txtQuocGia.getText());
        }

        tsAdd = new ThongSo(null, ae.idQGD(qgd), hdh.getId(),
                cpu.getId(), boNho.getId(), pin.getId(), kn.getId(),
                mh.getId(), tk.getId(), ti.getId(), ms.getId(), cmd.getId());
        System.out.println(ae.themThongSo(tsAdd));
        doMoi = Integer.parseInt(txtDoMoi.getText());
        for (String string : imei) {
            String po = tsp.themCTDT(new ChiTietDienThoai(string, 1, doMoi, txtMoTa.getText(), ae.idQGD(qgd)));
            JOptionPane.showMessageDialog(rootPane, po);
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void txtGiaNhapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiaNhapKeyReleased
        if (txtGiaNhap.getText().isEmpty() == false) {
            String gia = txtGiaNhap.getText().replace(",", "");

            txtGiaNhap.setText(df.format(Double.valueOf(gia)));
        }


    }//GEN-LAST:event_txtGiaNhapKeyReleased

    private void txtGiaBanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiaBanKeyReleased
        if (txtGiaBan.getText().isEmpty() == false) {
            String gia = txtGiaBan.getText().replace(",", "");
            txtGiaBan.setText(df.format(Double.valueOf(gia)));
        }
    }//GEN-LAST:event_txtGiaBanKeyReleased

    private void txtDoMoiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDoMoiKeyReleased
        try {
            if (Integer.parseInt(txtDoMoi.getText()) > 100 && txtDoMoi.getText().isEmpty() == false) {
                txtDoMoi.setText(100 + "");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Độ mới phải là số");
        }
    }//GEN-LAST:event_txtDoMoiKeyReleased

    private void cbbIMEIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbIMEIActionPerformed
        if (cbbIMEI.getSelectedIndex() > -1) {
            int o = cbbIMEI.getSelectedIndex();
            String imei = sps.getImei(idSQGD).get(o);
            txtDoMoi.setText(sps.moi(imei) + "");
        }
    }//GEN-LAST:event_cbbIMEIActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        if (cbbIMEI.getSelectedIndex() > -1) {
            int o = cbbIMEI.getSelectedIndex();
            String imei = sps.getImei(idSQGD).get(o);
            JOptionPane.showMessageDialog(rootPane, ae.xoaCTDT(imei));
        } else {
            JOptionPane.showMessageDialog(rootPane, "vui lòng chọn imei");
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
         Object[] option = {"Sửa Thông số", "Sửa giá bán"}; 
        int port = JOptionPane.showOptionDialog(this, "Chọn loại sửa", null, 0, 1, null, option, EXIT_ON_CLOSE);
        if ( port == 0) {
           JOptionPane.showMessageDialog(rootPane, "Vui lòng xác nhận lại thông tin về hãng");
        } else {
           
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anhSanPham;
    private javax.swing.JButton btnDienThoai;
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnHang;
    private javax.swing.JButton btnKetNoi;
    private javax.swing.JButton btnKetNoi1;
    private javax.swing.JButton btnKetNoi2;
    private javax.swing.JButton btnKetNoi3;
    private javax.swing.JButton btnKetNoi4;
    private javax.swing.JButton btnKetNoi5;
    private javax.swing.JButton btnKetNoi6;
    private javax.swing.JButton btnKetNoi7;
    private javax.swing.JButton btnKetNoi8;
    private javax.swing.JButton btnKetNoi9;
    private javax.swing.JButton btnQuocGia;
    private javax.swing.JButton btnSua;
    private javax.swing.JComboBox<String> cbbIMEI;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton18;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblThongTin;
    private javax.swing.JTextField txtDT;
    private javax.swing.JTextField txtDoMoi;
    private javax.swing.JTextField txtDong;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtHang;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtQuocGia;
    // End of variables declaration//GEN-END:variables
}
