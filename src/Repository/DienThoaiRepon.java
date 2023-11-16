/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.DienThoai;
import Ultilities.SQLServerConnection;
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
public class DienThoaiRepon {

    public List<DienThoai> getAll(int tt) {
        List<DienThoai> ls = new ArrayList<>();
        try ( Connection conn = new SQLServerConnection().getConnection()) {
            String query = "SELECT [id]\n"
                    + "      ,[ma_dien_thoai]\n"
                    + ",ten_dien_thoai"
                    + "      ,[id_hang]\n"
                    + "      ,[trang_thai]\n"
                    + "  FROM [dbo].[DienThoai]"
                    + "where trang_thai = ?";

            PreparedStatement ps = conn.prepareCall(query);
            ps.setObject(1, tt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                ls.add(new DienThoai(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
            }
            return ls;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    
    public int ton() {
        String query = "select COUNT(IMEI) from ChiTietDienThoai\n"
                + "where DATEDIFF(DD,getDate(),ngay_nhap) > 365 and trang_thai =1";
        int check = 0;
        try ( Connection conn = new SQLServerConnection().getConnection();  PreparedStatement ps = conn.prepareCall(query);) {
            ResultSet rs = ps.executeQuery();
         check =   rs.getInt(1);

            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check;
    }
    public int moi() {
        String query = "select COUNT(IMEI) from ChiTietDienThoai\n"
                + "where DATEDIFF(DD,getDate(),ngay_nhap) < 365 and trang_thai =1";
        int check = 0;
        try ( Connection conn = new SQLServerConnection().getConnection();  PreparedStatement ps = conn.prepareCall(query);) {
            ResultSet rs = ps.executeQuery();
         check =   rs.getInt(1);

            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check;
    }



    public boolean sua(DienThoai cv) {
        String query = "UPDATE [dbo].[DienThoai]\n"
                + "   SET [ma_dien_thoai] = ?\n"
                + "      ,[ten_dien_thoai] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE  id =?";
        int check = 0;
        try ( Connection conn = new SQLServerConnection().getConnection();  PreparedStatement ps = conn.prepareCall(query);) {
            ps.setObject(1, cv.getMa());
            ps.setObject(2, cv.getTen());
            ps.setObject(3, cv.getTrangThai());
            ps.setObject(4, cv.getId());

            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        for (DienThoai quocGia : new DienThoaiRepon().getAll(1)) {
            System.out.println(quocGia.toString());
        }
    }
}
