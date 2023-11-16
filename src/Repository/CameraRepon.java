/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.Camera;
import DomainModel.DienThoai;
import Ultilities.SQLServerConnection;
import ViewModel.CameraModelView;
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
public class CameraRepon {

    public boolean ThemCamera(Camera hdh) {
        String query = "INSERT INTO [dbo].[Camera]\n"
                + "           ([camera_truoc]\n"
                + "           ,[camera_sau]\n"
                + "           ,[quay_video]\n"
                + "           ,[max_zoom]\n"
                + "           ,[chong_rung]\n"
                + "           ,[dac_biet]\n"
                + "           ,[trang_thai])\n"
                + "     VALUES\n"
                + "           (?   ,?   ,?   ,?  ,?  ,? ,?    )";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getCameraTruoc());
            ps.setObject(2, hdh.getCameraSau());
            ps.setObject(3, hdh.getQuayVideo());
            ps.setObject(4, hdh.getZoom());
            ps.setObject(5, hdh.getChongRung());
            ps.setObject(6, hdh.getDacBiet());
            ps.setObject(7, hdh.getTrangThai());
            sp = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }

    public boolean SuaCamera(Camera hdh) {
        String query = "UPDATE [dbo].[Camera]\n"
                + "   SET [camera_truoc] = ?\n"
                + "      ,[camera_sau] = ?\n"
                + "      ,[quay_video] = ?\n"
                + "      ,[max_zoom] = ?\n"
                + "      ,[chong_rung] = ?\n"
                + "      ,[dac_biet] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE id =?";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getCameraTruoc());
            ps.setObject(2, hdh.getCameraSau());
            ps.setObject(3, hdh.getQuayVideo());
            ps.setObject(4, hdh.getZoom());
            ps.setObject(5, hdh.getChongRung());
            ps.setObject(6, hdh.getDacBiet());
            ps.setObject(7, hdh.getTrangThai());
            ps.setObject(8, hdh.getId());
            sp = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }

    public boolean xoaCamera(Camera hdh, int tt) {
        String query = "UPDATE [dbo].[Camera]\n"
                + "   SET [camera_truoc] = ?\n"
                + "      ,[camera_sau] = ?\n"
                + "      ,[quay_video] = ?\n"
                + "      ,[max_zoom] = ?\n"
                + "      ,[chong_rung] = ?\n"
                + "      ,[dac_biet] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE id =?";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getCameraTruoc());
            ps.setObject(2, hdh.getCameraSau());
            ps.setObject(3, hdh.getQuayVideo());
            ps.setObject(4, hdh.getZoom());
            ps.setObject(5, hdh.getChongRung());
            ps.setObject(6, hdh.getDacBiet());
            ps.setObject(7, tt);
            ps.setObject(8, hdh.getId());
            sp = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }

    public List<Camera> getCamera(int x) {
        String query = "select * from Camera where trang_thai =?";
        List<Camera> ls = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, x);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Camera sp = new Camera(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                ls.add(sp);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return ls;
    }
    public List<DienThoai> getDTLisst() {
        String query = "select * from DienThoai";
        List<DienThoai> ls = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
           
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ls.add(new DienThoai(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 0));
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return ls;
    }

}
