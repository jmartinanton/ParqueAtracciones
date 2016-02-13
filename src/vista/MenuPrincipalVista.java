package vista;

import java.awt.*;
import javax.swing.*;
import principal.ParcAtraccionsExcepcio;

public class MenuPrincipalVista {

    private JFrame frame;

    private JButton[] menuButtons = new JButton[3];

    private Integer amplada = 800;
    private Integer alcada = 600;
    

    public MenuPrincipalVista() {
        
        JButton btnSalir = new JButton("0. Sortir");
        JButton btnMenuParc = new JButton("1. Menú parc d'atraccions");
        JButton btnMenuAtraccions = new JButton("2. Menú atraccions");
        JButton[] arrayBotones = {btnSalir,btnMenuParc,btnMenuAtraccions};
        setMenuButtons(arrayBotones);
        
        GridLayout layoutGrid = new GridLayout(0, 1);
        frame = new JFrame("Menu Principal");
        frame.setLayout(layoutGrid);
        
        for (JButton menuButton : menuButtons) {
            frame.add(menuButton);
        }

        frame.setSize(amplada, alcada);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /*
        Amb les propietats d'aquesta classe, heu de fer el següent (no afegiu cap listener a cap control)
            Heu de crear l'objecte JFrame amb títol "Menú Principal" i layout Grid d'una columna
            Heu de crear els botons del formulari. Cada botó serà un element de l'array de botons amb les següents etiquetes:
                        "0. Sortir"
                        "1. Menú parc d'atraccions"
                        "2. Menú atraccions"
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

    public JButton[] getMenuButtons() {
        return menuButtons;
    }

    public void setMenuButtons(JButton[] menuButtons) {
        this.menuButtons = menuButtons;
    }



}
