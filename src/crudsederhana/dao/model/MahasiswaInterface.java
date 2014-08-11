/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package crudsederhana.dao.model;

import crudsederhana.dao.entity.Mahasiswa;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author bahrie
 */
public interface MahasiswaInterface {

     public void connect() throws SQLException;//inget di beri throws SQLException
    public void disconnect() throws SQLException;
    public List  read() throws SQLException;
    public void insert(Mahasiswa mahasiswa) throws  SQLException;
    public void update(String nim, Mahasiswa mahasiswa) throws SQLException;
    public void delete(String nim) throws SQLException;
    public Mahasiswa read(String nim) throws  SQLException;


}
