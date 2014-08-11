/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crudsederhana.dao.model;

import crudsederhana.dao.entity.Mahasiswa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bahrie
 */
public class ImplementMahasiswa implements MahasiswaInterface {

    private String dbHost = "jdbc:mysql://localhost:3306/mahasiswa";
    private String dbUser = "root";
    private String dbPass = "";
    private Connection conn;

    public ImplementMahasiswa() {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(ImplementMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ImplementMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ImplementMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ImplementMahasiswa(Connection conn) {
        this.conn = conn;
    }

    public void connect() throws SQLException {
        this.conn = DriverManager.getConnection(dbHost, dbUser, dbPass);

    }

    public void disconnect() throws SQLException {
        this.conn.close();
    }

    public List read() throws SQLException {
        Statement st = conn.createStatement();
        String sql = "select *from mahasiswa";
        ResultSet rs = st.executeQuery(sql);
        List list = new ArrayList();
        while (rs.next()) {
            Mahasiswa mhs = new Mahasiswa();
            mhs.setNim(rs.getString("nim"));
            mhs.setNama(rs.getString("nama"));
            mhs.setAlamat(rs.getString("alamat"));
            list.add(mhs);
        }
        return list;



    }

    public void insert(Mahasiswa mahasiswa) throws SQLException {
        String sql = "insert into mahasiswa (nim, nama, alamat) values(?,?,?);";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, mahasiswa.getNim());
        ps.setString(2, mahasiswa.getNama());
        ps.setString(3, mahasiswa.getAlamat());
        ps.executeUpdate();

    }

    public void update(String nim, Mahasiswa mahasiswa) throws SQLException {
        String sql = "update mahasiswa set nim=?,nama=?,alamat=? where nim=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, mahasiswa.getNim());
        ps.setString(2, mahasiswa.getNama());
        ps.setString(3, mahasiswa.getAlamat());
        ps.setString(4, nim);
        ps.executeUpdate();

    }

    public void delete(String nim) throws SQLException {
        String sql = "delete from mahasiswa where nim=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, nim);
        ps.executeUpdate();

    }

    public Mahasiswa read(String nim) throws SQLException {
        String sql = "select *from mahasiswa where nim = ?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, nim);
        ResultSet rs = ps.executeQuery();
        Mahasiswa mahasiswa = new Mahasiswa();
        while (rs.next()) {
            mahasiswa.setNim(rs.getString("nim"));
            mahasiswa.setNama(rs.getString("nama"));
            mahasiswa.setAlamat(rs.getString("alamat"));
        }
        return mahasiswa;

    }
}
