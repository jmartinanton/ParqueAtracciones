/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author MiguelAngel
 */
public class ParcAtraccionsForm {

    private JFrame frame;
    private Integer amplada = 300;
    private Integer alcada = 200;

    private JLabel lCodi;
    private JTextField tCodi;
    private JLabel lNom;
    private JTextField tNom;
    private JLabel lAdreça;
    private JTextField tAdreça;

    private JButton bDesar;   
    private JButton bSortir;   

    public ParcAtraccionsForm() {
        /*
        Amb les propietats d'aquesta classe, heu de fer el següent (no afegiu cap listener a cap control)
            Heu de crear l'objecte JFrame amb títol "Formulari Parc d'Atraccions" i layout Grid d'una columna
            Heu de crear els controls del formulari (labels i textFields) 
            Heu de crear els botons del formulari
            Heu d'afegir-ho tot al frame
            Heu de fer visible el frame amb l'amplada i alçada que proposen les propietats d'aquest nom
            Heu de fer que la finestra es tanqui quan l'usuari ho fa amb el control "X" de la finestra
        */

    }
    public ParcAtraccionsForm(Integer codi, String nom, String adreça){
        this();
        tCodi.setText(codi.toString());
        tNom.setText(nom);
        tAdreça.setText(adreça);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTextField getCodi() {
        return tCodi;
    }

    public void setCodi(JTextField tCodi) {
        this.tCodi = tCodi;
    }

    public JTextField getNom() {
        return tNom;
    }

    public void setNom(JTextField tNom) {
        this.tNom = tNom;
    }

    public JTextField getAdreca() {
        return tAdreça;
    }

    public void setAdreca(JTextField tAdreça) {
        this.tAdreça = tAdreça;
    }

    public JButton getDesar() {
        return bDesar;
    }

    public void setDesar(JButton bDesar) {
        this.bDesar = bDesar;
    }

    
    public JButton getSortir() {
        return bSortir;
    }

    public void setSortir(JButton bSortir) {
        this.bSortir = bSortir;
    }

}
