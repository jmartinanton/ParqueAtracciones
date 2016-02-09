package principal;

import personal.PersonaManteniment;
import atraccions.Atraccio;
import zones.Zona;
import java.util.Scanner;
import gestions.RegistreUsuaris;
import personal.Coordinador;

/**
 *
 * @author Francesca
 */
public class ParcAtraccions {

    static private Integer comptaCodi = 1; //El proper codi a assignar
    private Integer codi;
    private String nom;
    private String adreca;
    private Element[] elements = new Element[10];
    private Integer comptaElements = 0;
    private RegistreUsuaris[] registres = new RegistreUsuaris[100];
    private Integer comptaRegistres = 0;

    public ParcAtraccions(String pNom, String pAdreca) {
        codi = getComptaCodi();
        setComptaCodi();
        nom = pNom;
        adreca = pAdreca;
    }

    public ParcAtraccions(Integer pCodi, String pNom, String pAdreca) {
        codi = pCodi;
        nom = pNom;
        adreca = pAdreca;
    }

    public static Integer getComptaCodi() {
        return comptaCodi;
    }

    public static void setComptaCodi() {
        comptaCodi++;
    }

    public Integer getCodi() {
        return codi;
    }

    public void setCodi(Integer pCodi) {
        codi = pCodi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String pNom) {
        nom = pNom;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreça(String pAdreca) {
        adreca = pAdreca;
    }

    public Element[] getElements() {
        return elements;
    }

    public void setElements(Element[] elements) {
        this.elements = elements;
    }

    public Integer getComptaElements() {
        return comptaElements;
    }

    public void setComptaElements(Integer comptaElements) {
        this.comptaElements = comptaElements;
    }

    public RegistreUsuaris[] getRegistres() {
        return registres;
    }

    public void setRegistres(RegistreUsuaris[] registres) {
        this.registres = registres;
    }

    public Integer getComptaRegistres() {
        return comptaRegistres;
    }

    public void setComptaRegistres(Integer comptaRegistres) {
        this.comptaRegistres = comptaRegistres;
    }

    public static ParcAtraccions nouParcAtraccions() {
        Scanner dades = new Scanner(System.in);
        String nom;
        String adreca;
        System.out.println("Nom del parc d'atraccions:");
        nom = dades.nextLine();
        System.out.println("Adreça del parc d'atraccions:");
        adreca = dades.nextLine();
        return new ParcAtraccions(nom, adreca);
    }

    public void modificaParcAtraccions() {
        Scanner dades = new Scanner(System.in);
        System.out.println("\nNom del parc d'atraccions és: " + getNom());
        System.out.println("\nEntra el nou nom:");
        this.setNom(dades.nextLine());
        System.out.println("\nAdreça del parc d'atraccions és: " + getAdreca());
        System.out.println("\nEntra la nova adreça:");
        this.setAdreça(dades.nextLine());
    }

    public void mostraParcAtraccions() {
        System.out.println("\nLes dades del parc d'atraccions amb codi " + getCodi() + " són:");
        System.out.println("\nNom:" + getNom());
        System.out.println("\nAdreça:" + getAdreca());
    }

    /*
     Coordinadors
     */
    public void nouCoordinador(Coordinador coordinador) {
        Coordinador nouCoord;
        if (coordinador == null) {
            nouCoord = Coordinador.nouCoordinador();
        } else {

            nouCoord = coordinador;
        }
        try {
            if (seleccionaCoordinador(nouCoord.getNif()) == -1) {
                elements[comptaElements] = nouCoord;
                comptaElements++;
            }
        } catch (ParcAtraccionsExcepcio ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Integer seleccionaCoordinador(String pNif) throws ParcAtraccionsExcepcio {
        int codiResposta = -1;
        if (seleccionaElement(1, pNif) != -1) { //SE HA ENCONTRADO EL DNI
            throw new ParcAtraccionsExcepcio("3");
        } else {
            return codiResposta;
        }
    }

    /*
     Personal manteniment
     */
    public void novaPersonaManteniment(PersonaManteniment personamanteniment) {
        PersonaManteniment novaPersManten;
        if (personamanteniment == null) {
            novaPersManten = PersonaManteniment.novaPersonaManteniment();
        } else {
            novaPersManten = personamanteniment;
        }

        if (seleccionaElement(2, novaPersManten.getNif()) == -1) {
            elements[comptaElements] = novaPersManten;
            comptaElements++;
        } else {
            System.out.println("La persona de manteniment ja existeix");
        }
    }

    /*
     Atraccions
     */
    public void novaAtraccio(Atraccio atraccio) {
        Atraccio novaAtrac;
        if (atraccio == null) {
            novaAtrac = Atraccio.novaAtraccio();
        } else {
            novaAtrac = atraccio;
        }

        if (seleccionaElement(3, novaAtrac.getNom()) == -1) {
            elements[comptaElements] = novaAtrac;
            comptaElements++;
        } else {
            System.out.println("La atracció ja existeix");
        }

    }

    /*
     Zones
     */
    public void novaZona(Zona zona) {
        Zona novaZo;
        if (zona == null) {
            novaZo = Zona.novaZona();
        } else {
            novaZo = zona;
        }

        if (seleccionaElement(4, novaZo.getNom()) == -1) {
            elements[comptaElements] = novaZo;
            comptaElements++;
        } else {
            System.out.println("La zona ja existeix");
        }

    }

    /*
     Elements
     */
    public Integer seleccionaElement(Integer tipusElement, String pCodi) {
        Scanner teclado = new Scanner(System.in);
        Integer laClasse = tipusElement;
        String codiSel = "";
        if (pCodi.equals("")) {
            switch (laClasse) {
                case 0:
                    System.out.println("\nQuè vols seleccionar?:");
                    System.out.println("1. Coordinador:");
                    System.out.println("2. Persona demanteniment:");
                    System.out.println("3. Atracció:");
                    System.out.println("4. Zona:");
                    laClasse = teclado.nextInt();
                    break;
                case 1:
                    System.out.println("Nif del coordinador?:");
                    break;
                case 2:
                    System.out.println("Nif de la persona de manteniment?:");
                    break;
                case 3:
                    System.out.println("Nom de l'Atracció?:");
                    break;
                case 4:
                    System.out.println("Nom de la Zona?:");
                    break;
            }
            codiSel = teclado.next();
        } else {
            codiSel = pCodi;
        }

        Integer indexSel = -1;
        for (int i = 0;
                i < comptaElements;
                i++) {
            if (elements[i] instanceof Coordinador && laClasse == 1) {
                if (((Coordinador) elements[i]).getNif().equals(codiSel)) {
                    indexSel = i;
                    break;
                }
            }
            if (elements[i] instanceof PersonaManteniment && laClasse == 2) {
                if (((PersonaManteniment) elements[i]).getNif().equals(codiSel)) {
                    indexSel = i;
                    break;
                }
            }
            if (elements[i] instanceof Atraccio && laClasse == 3) {
                if (((Atraccio) elements[i]).getNom().equals(codiSel)) {
                    indexSel = i;
                    break;
                }
            }
            if (elements[i] instanceof Zona && laClasse == 4) {
                if (((Zona) elements[i]).getNom().equals(codiSel)) {
                    indexSel = i;
                    break;
                }
            }
        }
        return indexSel;
    }

    public void afegeixElementZona(Integer tipusElement) {
        Zona nauSel = null;
        Integer indexSelNau = seleccionaElement(4, "");
        if (indexSelNau >= 0) {
            nauSel = (Zona) this.getElements()[indexSelNau];
        } else {
            System.out.println("\nNo existeix aquesta nau");
        }
        Integer indexSel = seleccionaElement(tipusElement, "");
        if (indexSel >= 0) {
            nauSel.afegeixElementZona(getElements()[indexSel]);
        } else {
            System.out.println("\nNo existeix aquest element");
        }
    }

    public void afegeixRegistre() {
        registres[comptaRegistres] = RegistreUsuaris.nouRegistre();
        comptaRegistres++;
    }
}
