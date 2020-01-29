package view;

import controller.PredmetFileDownloader;
import controller.PredmetParser;
import model.PredmetTableModel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;

public class MainWindow extends JFrame{
    private JPanel panel;
    private JTable table;
    private JTextField tfPredmet;
    private JTextField tfKatedra;
    private JButton searchButton;
    private JLabel lblCelkem;
    private JLabel lblPrednasky;
    private JLabel lblCviceni;

    private PredmetTableModel model = new PredmetTableModel();
    private PredmetFileDownloader downloader = new PredmetFileDownloader();
    private PredmetParser parser = new PredmetParser();

    public MainWindow(){
        add(panel);
        setVisible(true);
        setSize(800,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        table.setModel(model);

        parser.setModel(model);
        parser.setWindow(this);
        downloader.setParser(parser);

        searchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String predmet = tfPredmet.getText();
                String katedra = tfKatedra.getText();
                try {
                    model.clear();
                    downloader.getCSV(predmet, katedra);
                } catch (URISyntaxException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public void setData(int all, int prednasky, int cviceni){
        lblCelkem.setText("Celkem : "+all);
        lblCviceni.setText("Počet cvičení : "+cviceni);
        lblPrednasky.setText("Počet přednášek : "+prednasky);
    }

    public static void main(String[] args) {
        MainWindow m = new MainWindow();
    }


}
