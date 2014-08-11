/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crudsederhana.dao.entity;

/**
 *
 * @author bahrie
 */
public class Mahasiswa {

    private String nim;
    private String nama;
    private String alamat;

    public Mahasiswa() {
    }

    public Mahasiswa(String nim, String nama, String alamat) {
        this.nim = nim;
        this.nama = nama;
        this.alamat = alamat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }
}
