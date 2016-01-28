package zones;

import java.util.Scanner;
import principal.Element;

/**
 *
 * @author Francesca
 */
public class Zona implements Element {

    private String nom;
    private Element[] elements = new Element[100];
    private Integer comptaElements = 0;

    public Zona(String pNom) {
        nom = pNom;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

   public static Zona novaZona() {
        Scanner dades = new Scanner(System.in);
        String nomZona;
        System.out.println("Nom de la zona:");;
        nomZona = dades.nextLine();
        return new Zona(nomZona);
    }

    public void afegeixElementZona(Element element) {
        elements[comptaElements] = element;
        comptaElements++;
    }

    public void modificaElement() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\nNom de la zona és: " + getNom());
        System.out.println("\nEntra el nou nom:");
        this.setNom(teclado.next());
    }

    public void mostraElement() {
        System.out.println("\nNom:" + getNom());
        System.out.println("Aquesta zona està formada pels elements:");
        for (int i = 0; i < getComptaElements(); i++) {
            getElements()[i].mostraElement();
        }
    }

}
