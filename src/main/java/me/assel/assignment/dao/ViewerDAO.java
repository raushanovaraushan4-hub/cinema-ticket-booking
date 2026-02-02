package me.assel.assignment.dao;

import me.assel.assignment.DBConnection;
import me.assel.assignment.objects.Viewer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViewerDAO {

    public static void insertViewer(Viewer v) throws Exception {
        Connection conn = DBConnection.connect();
        String sql = "INSERT INTO viewer VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, v.getId());
        ps.setString(2, v.getName());
        ps.setString(3, v.getEmail());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public static List<Viewer> readViewers() throws Exception {
        List<Viewer> list = new ArrayList<>();
        Connection conn = DBConnection.connect();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM viewer");

        while(rs.next()) {
            list.add(new Viewer(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }

        rs.close();
        st.close();
        conn.close();
        return list;
    }

    public static Viewer findViewerById(int id) throws Exception {
        Connection conn = DBConnection.connect();
        String sql = "SELECT * FROM viewer WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        Viewer v = null;
        if(rs.next()) {
            v = new Viewer(rs.getInt(1), rs.getString(2), rs.getString(3));
        }

        rs.close();
        ps.close();
        conn.close();
        return v;
    }

    public static void updateViewerNameById(int id, String newName) throws Exception {
        Connection conn = DBConnection.connect();
        String sql = "UPDATE viewer SET name = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, newName);
        ps.setInt(2, id);
        int rows = ps.executeUpdate();
        if(rows > 0) System.out.println("Viewer updated successfully");
        else System.out.println("Viewer not found");
        ps.close();
        conn.close();
    }

    public static void deleteViewerById(int id) throws Exception {
        Connection conn = DBConnection.connect();
        String sql = "DELETE FROM viewer WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        int rows = ps.executeUpdate();
        if(rows > 0) System.out.println("Viewer deleted successfully");
        else System.out.println("Viewer not found");
        ps.close();
        conn.close();
    }
}