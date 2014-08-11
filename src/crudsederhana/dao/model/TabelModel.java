/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crudsederhana.dao.model;

import crudsederhana.dao.entity.Mahasiswa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author bahrie
 */
public class TabelModel extends AbstractTableModel {

    List<Mahasiswa> list = new ArrayList<Mahasiswa>();

    public TabelModel(List list) {
        this.list=list;
    }


    public int getRowCount() {
        return this.list.size();
    }

    public int getColumnCount() {
        return 3;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getNim();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getAlamat();
            default:
                return null;
        }

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nim";
            case 1:
                return "Nama";
            case 2:
                return "Alamat";
            default:
                return null;
        }

    }

    public Mahasiswa select(int index) {
        return list.get(index);
    }
}
