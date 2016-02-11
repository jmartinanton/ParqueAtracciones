package controlador;

import persistencia.GestorPersistencia;
import model.ParcAtraccions;
import vista.ParcAtraccionsForm;
import vista.ParcAtraccionsLlista;
import vista.MenuParcAtraccionsVista;
import java.awt.event.*;
import javax.swing.*;
import model.ParcAtraccions;
import principal.ParcAtraccionsExcepcio;


public class ControladorParcAtraccions implements ActionListener {

    private MenuParcAtraccionsVista menuParcAtraccionsVista;
    private ParcAtraccionsForm parcAtraccionsForm = null;
    private ParcAtraccionsLlista parcAtraccionsLlista = null;
    private Integer opcioSeleccionada = 0;

    public ControladorParcAtraccions() {
       /*
        S'inicialitza la propietat menuPrincipalVista (això mostrarà el menú Parc d'atraccions)
        Es crida a afegirListenersMenu
        */ 
    }

    //El controlador com a listener dels controls de les finestres que gestionen els parcs d'atraccions
    //S'AFEGEIX EL CONTROLADOR COM A LISTENER DELS BOTONS DEL MENU
    private void afegirListenersMenu() {
        /*
        A cada botó del menú Parc d'atraccions, s'afegeix aquest mateix objecte (ControladorParcAtraccions) com a listener
        */
    }

    //S'AFEGEIX EL CONTROLADOR COM A LISTENER DELS BOTONS DEL FORMULARI
    private void afegirListenersForm() {
        /*
        A cada botó del formulari Parc d'atraccions, s'afegeix aquest mateix objecte (ControladorParcAtraccions) com a listener
        */ 
    }

    //S'AFEGEIX EL CONTROLADOR COM A LISTENER DEL BOTO DE LA LLISTA
    private void afegirListenersLlista() {
        /*
        Al botó de sortir de la llista parc d'atraccions, s'afegeix aquest mateix objecte (ControladorParcAtraccions) com a listener
        */
    }


    public void actionPerformed(ActionEvent e) {
        //Accions per al menú
        /*
        Nota:
            Com ControladorParcAtraccions és listener del menú Parc d'atraccions, del formulari i de la llista, llavors en aquest mètode
            actionPerformed heu de controlar si l'usuari ha premut cap botó de qualsevol dels esmentats frames.
            En el cas del formulari i de la llista, com provenen del menú (els llança el menú parc d'atraccions), heu de verificar
            primer que els objectes parcAtraccionsForm o parcAtraccionsLlista no són nulls, per tal de saber si podeu comparar amb
            cap botó d'aquests frames
        Accions per al menú:
            S'ha de cridar a bifurcaOpcio segons l'opció premuda. Penseu que l'opció es correspon amb
            la posició que el botó ocupa a l'array de botons de menuPrincipalVista
            També, heu d'actualitzar la propietat opcioSeleccionada (amb l'opció que ha premut l'usuari)
        Accions per al formulari Parc d'atraccions:
            ---- DESAR ----
            Si el botó premut per l'usuari és el botó de desar del formulari parc d'atraccions, llavors
                Si l'opció seleccionada (al menú parc d'atraccions) era 1 (alta), llavors
                    Es validen les dades (validaParcAtraccions())
                    Si no són correctes, ja s'haurà mostrat un missatge al mateix validaParcAtraccions()
                    Si són correctes,
                        Es crea un nou objecte ParcAtraccions amb les dades del formulari
                        S'afegeix el parc d'atraccions creada a la llista de ControladorPrincipal
                        S'inhibeix el codi del formulari
                        Es posa aquest parc d'atraccions com parcAtraccionsActual (de ControladorPrincipal) i es canvia la propietat
                        opcioSeleccionada a 2
                Si l'opció seleccionada (al menú parc d'atraccions) era 3 (modificació), llavors
                    Nota: no es validen dades amb aquesta opció (per simplificar)
                    Es modifica l'objecte parcAtraccions amb les dades del formulari (penseu que és el parcAtraccionsActual de ControladorPrincipal)
            ---- SORTIR ----
            Si el botó premut per l'usuari és el botó de sortir del formulari parc d'atraccions, llavors
                Heu de tornar al menú parc d'atraccions (i amagar el formulari)
        Accions per a la llista de parcs d'atraccions:
            ---- SORTIR ----
            Si el botó premut per l'usuari és el botó de sortir de la llista de parcs d'atraccions, llavors
                Heu de tornar al menú parc d'atraccions (i amagar la llista)
        */ 

    }

    private void bifurcaOpcio(Integer opcio) {
        switch (opcio) {
            case 0: //sortir
                ControladorPrincipal.getMenuPrincipalVista().getFrame().setVisible(true);
                break;
            case 1: // alta
                if (ControladorPrincipal.getComptaParcsAtraccions() < ControladorPrincipal.getMAXPARCSATRACCIONS()) {
                    parcAtraccionsForm = new ParcAtraccionsForm();
                    afegirListenersForm();
                } else {
                    menuParcAtraccionsVista.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuParcAtraccionsVista.getFrame(), "Màxim nombre de parcs d'atraccions assolit.");
                }
                break;
            case 2: //registrar
                menuParcAtraccionsVista.getFrame().setVisible(true);
                if (ControladorPrincipal.getParcsAtraccions()[0] != null) {
                    seleccionaParcAtraccions();
                } else {
                    JOptionPane.showMessageDialog(menuParcAtraccionsVista.getFrame(), "Abans s'ha de crear al menys un parc d'atraccions");
                }
                break;
            case 3: //modificar
                if (ControladorPrincipal.getParcsAtraccions()[0] != null) {
                    seleccionaParcAtraccions();
                    parcAtraccionsForm = new ParcAtraccionsForm(ControladorPrincipal.getParcAtraccionsActual().getCodi(), ControladorPrincipal.getParcAtraccionsActual().getNom(), ControladorPrincipal.getParcAtraccionsActual().getAdreca());
                    parcAtraccionsForm.getCodi().setEnabled(false);
                    afegirListenersForm();
                } else {
                    menuParcAtraccionsVista.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuParcAtraccionsVista.getFrame(), "Abans s'ha de crear al menys un parc d'atraccions");
                }
                break;
            case 4: // llista
                if (ControladorPrincipal.getParcsAtraccions()[0] != null) {
                    parcAtraccionsLlista = new ParcAtraccionsLlista();
                    afegirListenersLlista();
                } else {
                    menuParcAtraccionsVista.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuParcAtraccionsVista.getFrame(), "Abans s'ha de crear al menys un parc d'atraccions");
                }
                break;
            case 5: //carregar
               /*
            Es mostra un dialog (JOptionPane.showOptionDialog) amb un botó per carregar els documents XML
            Un cop seleccionat el botó, amb un altre dialeg, es demana el codi del parc d'atraccions a carregar 
                            (recordeu que el nom del fitxer és el codi del parc d'atraccions i l'extensió)
            Un cop l'usuari ha entrat el codi i ha premut OK,
                Es crea un objecte parcAtraccions (nouParcAtraccions) com retorn de cridar a carregarParcAtraccions del gestor de persistència
                Es comprova si el codi del nouParcAtraccions ja existeix a la llista de parcs d'atraccions (això donarà la posició on s'ha trobat a la llista)
                Si existeix,
                    es mostra un dialog notificant l'usuari si vol substituir el parc d'atraccions de la llista per la que es carregarà des de el fitxer (JOptionPane.showOptionDialog)
                    Si l'usuari cancela, no es fa res
                    Si l'usuari accepta, llavors es posa el nou parc d'atraccions a la llista a la mateixa posició on s'havia trobat aquest codi
                Si no existeix,
                    S'afegeix el nouParcAtraccions a la llista de parcs d'atracció a la darrera posició
                    Es mostra un missatge confirmant l'addició (JOptionPane.showMessageDialog)
            */
                break;
            case 6: //desar
                /*
                Es comprova si s'ha registrar el parc d'atraccions, mostrant, si correspon, missatges d'error (JOptionPane.showMessageDialog)
                Si el parc d'atraccions està fixat, 
                    Es mostra un diàleg (JOptionPane.showOptionDialog) amb un botó, que representa al mètode de carrega de documents XML
                                    (propietat a Controlador Principal: ara XML)
                    Un cop escollit el mètode, es desa el parc d'atraccions cridant a desarParcAtraccions del gestor de persistència
                */
                break;
        }
    }

    private void seleccionaParcAtraccions() {
        String[] nomParcsAtraccions = new String[ControladorPrincipal.getComptaParcsAtraccions()];
        Integer i = 0;
        for (ParcAtraccions parcAtraccions : ControladorPrincipal.getParcsAtraccions()) {
            if (parcAtraccions != null) {
                nomParcsAtraccions[i] = parcAtraccions.getNom();
            }
            i++;
        }
        int messageType = JOptionPane.QUESTION_MESSAGE;
        int code = JOptionPane.showOptionDialog(null, "Selecciona un parc d'atraccions", "Selecció d'un parc d'atraccions", 0, messageType, null, nomParcsAtraccions, "A");
        if (code != JOptionPane.CLOSED_OPTION) {
            ControladorPrincipal.setParcAtraccionsActual(ControladorPrincipal.getParcsAtraccions()[code]);
        }
    }

    private Integer comprovaParcAtraccions(Integer codi) {
        Integer index = -1;
        Integer i = 0;
        for (ParcAtraccions parcAtraccions : ControladorPrincipal.getParcsAtraccions()) {
            if (parcAtraccions != null) {
                if (parcAtraccions.getCodi().equals(codi)) {
                    index = i;
                    break;
                }
            }
            i++;
        }
        return index;
    }

    private Boolean validaParcAtraccions() {
        Boolean retorna = true;
        try {
            Integer codi = Integer.parseInt(parcAtraccionsForm.getCodi().getText());
            Integer index = comprovaParcAtraccions(codi);
            if (index >= 0) {
                retorna = false;
                JOptionPane.showMessageDialog(menuParcAtraccionsVista.getFrame(), "El codi ja existeix");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(menuParcAtraccionsVista.getFrame(), "El codi ha de ser numèric");
            retorna = false;
        }
        if (parcAtraccionsForm.getNom().getText().equals("") || parcAtraccionsForm.getAdreca().getText().equals("")) {
            JOptionPane.showMessageDialog(menuParcAtraccionsVista.getFrame(), "S'han d'introduir el nom i l'adreça");
            retorna = false;
        }

        return retorna;
    }

}