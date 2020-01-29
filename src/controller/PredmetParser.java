package controller;

import model.Predmet;
import model.PredmetTableModel;
import view.MainWindow;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class PredmetParser {
    private PredmetTableModel model;
    private int all , cviceni, prednasky;

    private MainWindow window;

    public void setWindow(MainWindow window) {
        this.window = window;
    }

    public void setModel(PredmetTableModel model) {
        this.model = model;
    }

    public PredmetParser() {

    }

    public void fromCSVFile(String path) throws FileNotFoundException {

        model.clear();
        all = 0;
        prednasky = 0;
        cviceni = 0;

        Path file = Path.of(path);
        try (InputStream in = Files.newInputStream(file);

             BufferedReader reader =
                     new BufferedReader(new InputStreamReader(in,"UTF-8"))) {
            String line = null;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                if(i !=0){
                    createPredmet(line);
                }
                i++;
            }
        } catch (IOException x) {
            System.err.println(x);
        }
        window.setData(all, prednasky, cviceni);
        File f= new File("predmety.csv");
        f.delete();
    }

    public void createPredmet(String line){
        all++;
        line = line.replaceAll("\"", "");
        String [] atr = line.split(";");

        if(atr[21].equals("Cv") )
            cviceni++;
        else
            prednasky++;

        model.addPredmet(new Predmet(atr[24], atr[29], atr[30], atr[25], atr[1], atr[20],atr[16], atr[8]));

    }


}
