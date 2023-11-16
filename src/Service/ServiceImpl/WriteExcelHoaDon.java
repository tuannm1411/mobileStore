/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import ViewModel.ViewModelHoaDon;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelHoaDon {

    //HoaDonImpl hd = new HoaDonImpl();
    //String file = "C:\\Users\\PC\\Documents\\du_an_1JDBC\\source\\25.xlsx";

    public String trangthai(int trangthai) {
        String st = "";
        if (trangthai == 0) {
            st = "Chưa thanh toán";
        } else {
            st = "Đã thanh toán";
        }
        return st;
    }

    public void exportExcel(List<ViewModelHoaDon> listHoaDon, String file) {

        System.out.println("Create File Excel");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("List of Bill");
        int rowNum = 0;
        Row firstRow = sheet.createRow(rowNum++);

        // tao dinh dang 
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // font color

        // tao cell style: nen xanh, dinh dang border duoi
        CellStyle cellstyle = sheet.getWorkbook().createCellStyle();
        cellstyle.setFont(font);
        cellstyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        cellstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellstyle.setBorderBottom(BorderStyle.THIN);

        Cell CellHD = firstRow.createCell(0);
        CellHD.setCellStyle(cellstyle);
        CellHD.setCellValue("Mã Hóa Đơn");

        Cell cellTenNV = firstRow.createCell(1);
        cellTenNV.setCellStyle(cellstyle);
        cellTenNV.setCellValue("Tên nhân viên");

        Cell cellTenKH = firstRow.createCell(2);
        cellTenKH.setCellStyle(cellstyle);
        cellTenKH.setCellValue("Tên khách hàng");

        Cell cellNgayTao = firstRow.createCell(3);
        cellNgayTao.setCellStyle(cellstyle);
        cellNgayTao.setCellValue("Ngày tạo");

        Cell cellMKM = firstRow.createCell(4);
        cellMKM.setCellStyle(cellstyle);
        cellMKM.setCellValue("Mã khuyến mãi");

        Cell cellGiaGiam = firstRow.createCell(5);
        cellGiaGiam.setCellStyle(cellstyle);
        cellGiaGiam.setCellValue("Giá giảm");

        Cell cellTongTien = firstRow.createCell(6);
        cellTongTien.setCellStyle(cellstyle);
        cellTongTien.setCellValue("Tổng Tiền");

        Cell cellTrangThai = firstRow.createCell(7);
        cellTrangThai.setCellStyle(cellstyle);
        cellTrangThai.setCellValue("Trạng Thái");

        Cell cellTongSoSP = firstRow.createCell(8);
        cellTongSoSP.setCellStyle(cellstyle);
        cellTongSoSP.setCellValue("Tổng số SP");


        for (ViewModelHoaDon view : listHoaDon) {
            Row row = sheet.createRow(rowNum++);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(view.getMaHD());

            Cell cell2 = row.createCell(1);
            cell2.setCellValue(view.getTenNV());

            Cell cell3 = row.createCell(2);
            cell3.setCellValue(view.getTenKH());

            Cell cell4 = row.createCell(3);
            cell4.setCellValue(view.getNgayTao());

            Cell cell5 = row.createCell(4);
            cell5.setCellValue(view.getMaKhuyenMai());

            Cell cell6 = row.createCell(5);
            cell6.setCellValue(view.getGiaGiam());

            Cell cell7 = row.createCell(6);
            cell7.setCellValue(view.getTongTien());

            Cell cell8 = row.createCell(7);
            cell8.setCellValue(trangthai(view.getTrangThai()));

            Cell cell9 = row.createCell(8);
            cell9.setCellValue(view.getTongSoSP());
        }

        try {
            FileOutputStream fos = new FileOutputStream(file);
            workbook.write(fos);
            workbook.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }

}
