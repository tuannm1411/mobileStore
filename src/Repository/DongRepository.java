/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to cdien_thoaie this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.Dong;
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
public class DongRepository {

    public List<Dong> getAll(int tt) {
        List<Dong> ls = new ArrayList<>();
        try ( Connection conn = new SQLServerConnection().getConnection()) {
            String query = "SELECT [id]\n"
                    + "      ,[ma_dong]\n"
                    + ",ten_dong"
                    + "      ,[id_dien_thoai]\n"
                    + "      ,[trang_thai]\n"
                    + "  FROM [dbo].[Dong]"
                    + "where trang_thai = ?";

            PreparedStatement ps = conn.prepareCall(query);
            ps.setObject(1, tt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                ls.add(new Dong(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
            }
            return ls;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public boolean sua(Dong cv) {
        String query = "UPDATE [dbo].[Dong]\n"
                + "   SET [ma_dong] = ?\n"
                + "      ,[ten_dongsa] = ?\n"
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

    public boolean add(Dong cv) {
        String query = "INSERT INTO [dbo].[Dong]\n"
                + "           ([ma_dong]\n"
                + "           ,[ten_dong]\n"
                + "           ,[id_dien_thoai]\n"
                + "           ,[trang_thai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        int check = 0;
        try ( Connection conn = new SQLServerConnection().getConnection();  PreparedStatement ps = conn.prepareCall(query);) {
            ps.setObject(1, cv.getMa());
            ps.setObject(2, cv.getTen());
            ps.setObject(3, cv.getIdDienThoai());
            ps.setObject(4, cv.getTrangThai());
         
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        for (Dong quocGia : new DongRepository().getAll(1)) {
            System.out.println(quocGia.toString());
        }
    }
}
