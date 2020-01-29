package model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class PredmetTableModel extends AbstractTableModel {
    private String[] pole= {"asfd"};
    private ArrayList<String> cols = new ArrayList<String>(){
        {
            add("Den");
            add("Začátek");
            add("Konec");
            add("Zkratka");
            add("Název");
            add("Typ akce");
            add("Mísnost");
            add("Vyučující");
        }
    };
    private ArrayList<Predmet> predmety = new ArrayList<>();

    @Override
    public int getRowCount() {
        return predmety.size();
    }

    @Override
    public int getColumnCount() {
        return cols.size();
    }

    @Override
    public String getColumnName(int column) {
        return cols.get(column);
    }

    public PredmetTableModel() {
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return predmety.get(rowIndex).getDay();
            case 1:
                return predmety.get(rowIndex).getStart();
            case 2:
                return predmety.get(rowIndex).getEnd();
            case 3:
                return predmety.get(rowIndex).getZkratka();
            case 4:
                return predmety.get(rowIndex).getName();
            case 5:
                return predmety.get(rowIndex).getType();
            case 6:
                return predmety.get(rowIndex).getRoom();
            case 7:
                return predmety.get(rowIndex).getTeacher();
        }
        return null;
    }

    public void addPredmet(Predmet predmet){
        predmety.add(predmet);
        fireTableDataChanged(); 
    }

    public void clear(){
        predmety.clear();
        fireTableDataChanged();
    }
}
