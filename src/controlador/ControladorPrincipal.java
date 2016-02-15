package controlador;

import persistencia.GestorPersistencia;
import model.ParcAtraccions;
import vista.MenuPrincipalVista;
import java.awt.event.*;
import javax.swing.*;
import principal.ParcAtraccionsExcepcio;

public class ControladorPrincipal implements ActionListener {

    static private MenuPrincipalVista menuPrincipalVista;
    static private final Integer MAXPARCSATRACCIONS = 10;
    static private ParcAtraccions[] parcsAtraccions = new ParcAtraccions[MAXPARCSATRACCIONS];
    static private Integer comptaParcsAtraccions = 0;
    static private ParcAtraccions parcAtraccionsActual = null;
    static private Integer tipusElement = 0;
    static private GestorPersistencia gp = new GestorPersistencia();
    static private final String[] METODEPERSISTENCIA = {"XML"};
    
    public ControladorPrincipal() {
        
        menuPrincipalVista = new MenuPrincipalVista();
        for(JButton menuButton: menuPrincipalVista.getMenuButtons()){
            menuButton.addActionListener(this);
        }
        /*
        S'inicialitza la propietat menuPrincipalVista (això mostrarà el menú principal)
        A cada botó del menú, s'afegeix aquest mateix objecte (ControladorPrincipal) com a listener
        */
    }

    public void actionPerformed(ActionEvent e) {
        JButton botonpresionado = (JButton) e.getSource();
        JButton[] arrayBotones = menuPrincipalVista.getMenuButtons();
        for (int i = 0; i < arrayBotones.length; i++) {
            if (arrayBotones[i] == botonpresionado) bifurcaOpcio (i);
        }
         /*
        S'ha de cridar a bifurcaOpcio segons l'opció premuda. Penseu que l'opció es correspon amb
        la posició que el botó ocupa a l'array de botons de menuPrincipalVista
        */
    }

    private void bifurcaOpcio(Integer opcio) {
        switch (opcio) {
            case 0:
                System.exit(0);
                break;
            case 1:
                menuPrincipalVista.getFrame().setVisible(false);
                ControladorParcAtraccions controladorParcAtraccions = new ControladorParcAtraccions();
                break;
            case 2:
                JOptionPane.showMessageDialog(menuPrincipalVista.getFrame(), "No heu d'implementar aquest menú");              
                break;
        }
    }



    public static MenuPrincipalVista getMenuPrincipalVista() {
        return menuPrincipalVista;
    }

    public static Integer getMAXPARCSATRACCIONS() {
        return MAXPARCSATRACCIONS;
    }

    
    public static ParcAtraccions[] getParcsAtraccions() {
        return parcsAtraccions;
    }

    public static void setParcsAtraccions(ParcAtraccions[] pParcsAtraccions) {
        ControladorPrincipal.parcsAtraccions = pParcsAtraccions;
    }

    public static Integer getComptaParcsAtraccions() {
        return comptaParcsAtraccions;
    }

    public static void setComptaParcsAtraccions() {
        ControladorPrincipal.comptaParcsAtraccions++;
    }

    public static ParcAtraccions getParcAtraccionsActual() {
        return parcAtraccionsActual;
    }

    public static void setParcAtraccionsActual(ParcAtraccions pParcAtraccionsActual) {
        ControladorPrincipal.parcAtraccionsActual = pParcAtraccionsActual;
    }

    public static Integer getTipusElement() {
        return tipusElement;
    }

    public static void setTipusElement(Integer pTipusElement) {
        ControladorPrincipal.tipusElement = pTipusElement;
    }

    public static GestorPersistencia getGp() {
        return gp;
    }

    public static void setGp(GestorPersistencia gp) {
        ControladorPrincipal.gp = gp;
    }

    public static String[] getMETODEPERSISTENCIA() {
        return METODEPERSISTENCIA;
    }
    
}
