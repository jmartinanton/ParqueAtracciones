package vista;

import java.awt.*;
import javax.swing.*;

public class ParcAtraccionsLlista {

    private JFrame frame;
    private Integer amplada = 600;
    private Integer alcada = 200;
    
    private JTable taulaParcAtraccions;

    private JButton bSortir;   
    

    public ParcAtraccionsLlista() {
        
        GridLayout layoutGrid = new GridLayout(0, 1);
        frame = new JFrame("Llista de parcs d'atraccions");
        frame.setLayout(layoutGrid);
        
        taulaParcAtraccions = new JTable(new ParcAtraccionsTableModel());
        bSortir = new JButton("Sortir");
        frame.add(taulaParcAtraccions);
        frame.add(bSortir);
        

        frame.setSize(amplada, alcada);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
        Amb les propietats d'aquesta classe, heu de fer el següent (no afegiu cap listener a cap control)
            Heu de crear l'objecte JFrame amb títol "Llista de parcs d'atraccions" i layout Grid d'una columna
            Heu de crear la taula amb un nou objecte ParcAtraccionsTableModel com a model
            Heu de crear el botó del formulari
            Heu d'afegir-ho tot al frame
            Heu de fer visible el frame amb l'amplada i alçada que proposen les propietats d'aquest nom
            Heu de fer que la finestra es tanqui quan l'usuari ho fa amb el control "X" de la finestra
        */
    }


    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTable getTaulaParcAtraccions() {
        return taulaParcAtraccions;
    }

    public void setTaulaParcAtraccions(JTable pTaulaParcAtraccions) {
        taulaParcAtraccions = pTaulaParcAtraccions;
    }    
    
    public JButton getSortir() {
        return bSortir;
    }

    public void setSortir(JButton bSortir) {
        this.bSortir = bSortir;
    }

}
