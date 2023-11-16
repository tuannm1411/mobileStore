/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import ViewModel.VIewModelSanPhamHoaDon;
import ViewModel.ViewModelHoaDon;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class WriteWordHoaDon {

    private HoaDonImpl sv = new HoaDonImpl();
    private List<VIewModelSanPhamHoaDon> list = new ArrayList<>();

    public void exportWord(ViewModelHoaDon hd, String file) {

        DecimalFormat df = new DecimalFormat("###,###,###");

        list = sv.getAllSp(hd.getMaHD());

        String tenSp = "";
        String giaBan;
        String hang = "";
        String giaGiam;

        //tao ducument
        XWPFDocument document = new XWPFDocument();

        //tieu de
        XWPFParagraph title = document.createParagraph();
        title.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun runlogo = title.createRun();
        runlogo.setFontSize(32);
        runlogo.setBold(true);
        runlogo.setFontFamily("Sitka Small");
        runlogo.setText("BEEPHONE STORE");
        runlogo.addBreak();

        XWPFRun Unicode1 = title.createRun();
        Unicode1.setFontFamily("Wingdings");
        Unicode1.setText("");
        XWPFRun DiaChi = title.createRun();
        DiaChi.setFontSize(14);
        DiaChi.setFontFamily("sansserif");
        DiaChi.setText("phố Trịnh Văn Bô, phường Phương Canh, quận Nam Từ Liêm, TP.Hà Nội");
        DiaChi.addBreak();

        XWPFRun Unicode2 = title.createRun();
        Unicode2.setFontFamily("Wingdings");
        Unicode2.setText("");
        XWPFRun email = title.createRun();
        email.setFontFamily("sansserif");
        email.setFontSize(14);
        email.setText("E-mail: beephone123@gmail.com");
        email.addBreak();

        XWPFRun Unicode3 = title.createRun();
        Unicode3.setFontFamily("Wingdings");
        Unicode3.setText("");
        XWPFRun tel = title.createRun();
        tel.setFontSize(14);
        tel.setFontFamily("sansserif");
        tel.setText("Tel: 03846935472");
        tel.addBreak();
        tel.addBreak();
        tel.addBreak();
        tel.addBreak();

        XWPFRun runTitle = title.createRun();
        runTitle.setFontSize(25);
        runTitle.setBold(true);
        runTitle.setFontFamily("Sitka Text Semibold");
        runTitle.setText("HÓA ĐƠN");
        runTitle.addBreak();

        // ctao paragraph
        XWPFParagraph ParagraphLeft = document.createParagraph();
        ParagraphLeft.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun runNgay = ParagraphLeft.createRun();
        runNgay.setFontSize(14);
        runNgay.setFontFamily("Times New Roman");

        String tenNV = hd.getTenNV();
        runNgay.setText("Thu ngân: ");
        runNgay.setText(tenNV);
        runNgay.addBreak();

        runNgay.setText("Khách hàng: ");
        String tenKH = hd.getTenKH();
        runNgay.setText(tenKH);
        runNgay.addTab();
        runNgay.addTab();
        runNgay.addTab();
        runNgay.addTab();
        runNgay.addTab();
        runNgay.setText("Mã HD: " + hd.getMaHD());
        runNgay.addBreak();
        runNgay.addBreak();

        XWPFRun column = ParagraphLeft.createRun();
        column.setBold(true);
        column.setFontFamily("Calibri");
        column.setFontSize(15);
        column.setText("Tên SP");
        column.addTab();
        column.addTab();
        column.addTab();
        column.addTab();
        column.setText("Hãng");
        column.addTab();
        column.addTab();
        column.addTab();
        column.addTab();
        column.addTab();
        column.setText("Đ.Giá");
        column.addBreak();
        XWPFRun ke1 = ParagraphLeft.createRun();
        ke1.setFontSize(20);
        ke1.setText("________________________________________");
        ke1.addBreak();

        XWPFRun sp = ParagraphLeft.createRun();
        sp.setFontFamily("Calibri");
        sp.setFontSize(15);

        for (VIewModelSanPhamHoaDon x : list) {
            tenSp = x.getTenSp();
            hang = x.getTenHang();
            giaBan = String.valueOf(x.getGiaBan());

            sp.setText(tenSp);
            sp.addTab();
            sp.addTab();
            sp.addTab();
            sp.addTab();
            sp.setText(hang);
            sp.addTab();
            sp.addTab();
            sp.addTab();
            sp.setText(String.valueOf(df.format(x.getGiaBan()) + " VND"));
            sp.addBreak();
        }

        XWPFRun ke = ParagraphLeft.createRun();
        ke.setFontSize(15);
        ke.setText("_______________________________________________________");
        ke.addBreak();
        ke.setText("Tổng số SP: ");
        ke.addTab();
        ke.addTab();
        ke.addTab();
        ke.addTab();
        ke.addTab();
        ke.addTab();
        ke.addTab();
        ke.setText(String.valueOf(hd.getTongSoSP()));
        ke.addBreak();
        ke.setText("Giá giảm: ");
        ke.addTab();
        ke.addTab();
        ke.addTab();
        ke.addTab();
        ke.addTab();
        ke.addTab();
        ke.addTab();
        ke.addTab();
        ke.setText(String.valueOf(df.format(hd.getGiaGiam()) + " VND"));
        ke.addBreak();
        ke.setText("Tổng tiền (Đã giảm theo KM): ");
        ke.addTab();
        ke.addTab();
        ke.addTab();
        ke.addTab();
        ke.setText(String.valueOf(df.format(hd.getTongTien()) + " VND"));
        ke.addBreak();

        XWPFParagraph ParagraphCamOn = document.createParagraph();

        ParagraphCamOn.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun Camon = ParagraphCamOn.createRun();
        Camon.setFontFamily("Cambria");
        Camon.setFontSize(20);
        Camon.addBreak();
        Camon.setText("Cảm ơn Quý khách. Hẹn gặp lại !");
        // Write the Document in file system
        // xuất file ra word
        try {
            FileOutputStream out = new FileOutputStream(new File(file));
            document.write(out);
            out.close();
            document.close();
            System.out.println("thành công");
        } catch (FileNotFoundException ex) {
            System.out.println("trung ten File dang mo");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
