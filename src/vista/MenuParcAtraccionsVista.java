package vista;

import java.awt.*;
import javax.swing.*;

public class MenuParcAtraccionsVista {

    private JFrame frame;

    private JButton[] menuButtons = new JButton[7];

    private Integer amplada = 800;
    private Integer alcada = 600;
        
    public MenuParcAtraccionsVista() {
        
        
        menuButtons[0] = new JButton("0. Sortir");
        menuButtons[1] = new JButton("1. Alta");
        menuButtons[2] = new JButton("2. Registrar parc d'atraccions");
        menuButtons[3] = new JButton("3. Modificar parc d'atraccions");
        menuButtons[4] = new JButton("4. Llistar parc d'atraccions");
        menuButtons[5] = new JButton("5. Carregar parc d'atraccions");
        menuButtons[6] = new JButton("6. Desar parc d'atraccions");

        setMenuButtons(menuButtons);
        
        GridLayout layoutGrid = new GridLayout(0, 1);
        frame = new JFrame("Menú Parc d'Atraccions");
        frame.setLayout(layoutGrid);
        
        for (JButton menuButton : menuButtons) {
            frame.add(menuButton);
        }

        frame.setSize(amplada, alcada);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         /*
        Amb les propietats d'aquesta classe, heu de fer el següent (no afegiu cap listener a cap control)
            Heu de crear l'objecte JFrame amb títol "Menú Parc d'Atraccions" i layout Grid d'una columna
            Heu de crear els botons del formulari. Cada botó serà un element de l'array de botons amb les següents etiquetes:
                        "0. Sortir"
                        "1. Alta"
                        "2. Registrar parc d'atraccions"
                        "3. Modificar parc d'traccions"
                        "4. Llistar parc d'atraccions"
                        "5. Carrega parc d'atraccions"
                        "6. Desar parc d'atraccions"
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
