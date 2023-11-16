/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.QuocGia;
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
public class QuocGiaRepon {

    public List<QuocGia> getAll(int tt) {
        List<QuocGia> ls = new ArrayList<>();
        try ( Connection conn = new SQLServerConnection().getConnection()) {
            String query = "SELECT [id]\n"
                    + "      ,[ma_quoc_gia]\n"
                    + "      ,[ten_quoc_gia]\n"
                    + "      ,[trang_thai]\n"
                    + "  FROM [dbo].[QuocGia]"
                    + "where trang_thai = ?";

            PreparedStatement ps = conn.prepareCall(query);
            ps.setObject(1, tt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                ls.add(new QuocGia(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
            return ls;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public boolean add(QuocGia cv) {
        String query = "INSERT INTO [dbo].[QuocGia]\n"
                + "           ([ma_quoc_gia]\n"
                + "           ,[ten_quoc_gia]\n"
                + "           ,[trang_thai])\n"
                + "     VALUES\n"
                + "           (?,? ,?)";
        int check = 0;
        try ( Connection conn = new SQLServerConnection().getConnection();  PreparedStatement ps = conn.prepareCall(query);) {
            ps.setObject(1, cv.getMa());
            ps.setObject(2, cv.getTen());
            ps.setObject(3, cv.getTrangThai());

            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean sua(QuocGia cv) {
        String query = "UPDATE [dbo].[QuocGia]\n"
                + "   SET [ma_quoc_gia] = ?\n"
                + "      ,[ten_quoc_gia] = ?\n"
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
        for (QuocGia quocGia : new QuocGiaRepon().getAll(1)) {
            System.out.println(quocGia.toString());
        }
    }
}
