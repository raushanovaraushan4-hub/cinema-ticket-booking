package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {

    public static void insertMovie(Movie m) throws Exception {
        Connection conn = DBConnection.connect();
        String sql = "INSERT INTO movie VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, m.getId());
        ps.setString(2, m.getTitle());
        ps.setString(3, m.getGenre());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public static List<Movie> readMovies() throws Exception {
        List<Movie> list = new ArrayList<>();
        Connection conn = DBConnection.connect();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM movie");

        while(rs.next()) {
            list.add(new Movie(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }

        rs.close();
        st.close();
        conn.close();
        return list;
    }

    public static List<Movie> readMoviesSortedByTitle() throws Exception {
        List<Movie> list = new ArrayList<>();
        Connection conn = DBConnection.connect();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM movie ORDER BY title");

        while(rs.next()) {
            list.add(new Movie(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }

        rs.close();
        st.close();
        conn.close();
        return list;
    }

    public static Movie findMovieById(int id) throws Exception {
        Connection conn = DBConnection.connect();
        String sql = "SELECT * FROM movie WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        Movie m = null;
        if(rs.next()) {
            m = new Movie(rs.getInt(1), rs.getString(2), rs.getString(3));
        }

        rs.close();
        ps.close();
        conn.close();
        return m;
    }

    public static void updateMovieTitleById(int id, String newTitle) throws Exception {
        Connection conn = DBConnection.connect();
        String sql = "UPDATE movie SET title = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, newTitle);
        ps.setInt(2, id);
        int rows = ps.executeUpdate();
        if(rows > 0) System.out.println("Movie updated successfully");
        else System.out.println("Movie not found");
        ps.close();
        conn.close();
    }

    public static void deleteMovieById(int id) throws Exception {
        Connection conn = DBConnection.connect();
        String sql = "DELETE FROM movie WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        int rows = ps.executeUpdate();
        if(rows > 0) System.out.println("Movie deleted successfully");
        else System.out.println("Movie not found");
        ps.close();
        conn.close();
    }
}