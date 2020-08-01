/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS2;

import javax.swing.JOptionPane;

/**
 *
 * @author alfian
 */
public class update {

    Koneksi konek = new Koneksi();

    public void update(int kta, String nama, String alamat, String jk) {

        try {
            konek.koneksi();
            java.sql.Statement statement = konek.con.createStatement();

            String sql_nama = "update ipsi set nama = '" + nama + "'where kta = '" + kta + "'";
            String sql_alamat = "update ipsi set alamat = '" + alamat + "'where kta = '" + kta + "'";
            String sql_jk = "update ipsi set jeniskelamin = '" + jk + "'where kta = '" + kta + "'";
            String sql_kta1 = "update ipsi set kta = '" + kta + "'where nama = '" + nama + "'";
            String sql_kta2 = "update ipsi set kta = '" + kta + "'where alamat = '" + alamat + "'";

            statement.executeUpdate(sql_kta1);
            statement.executeUpdate(sql_kta2);
            statement.executeUpdate(sql_nama);
            statement.executeUpdate(sql_alamat);
            statement.executeUpdate(sql_jk);
            statement.close();

            JOptionPane.showMessageDialog(null, "Berhasil Diubah");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
