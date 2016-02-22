package model;

import java.util.ArrayList;
import java.util.Scanner;
import principal.Element;

/**
 *
 * @author Francesca
 */
public class Zona implements Element {

    private String nom;
    //private Element[] elements = new Element[100];
    private ArrayList<Element> elements = new ArrayList<>();
    //private Integer comptaElements = 0;

    public Zona(String pNom) {
        nom = pNom;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    public void setElements(ArrayList<Element> elements) {
        this.elements = elements;
    }

   public static Zona novaZona() {
        Scanner dades = new Scanner(System.in);
        String nomZona;
        System.out.println("Nom de la zona:");;
        nomZona = dades.nextLine();
        return new Zona(nomZona);
    }

    public void afegeixElementZona(Element element) {
        //elements[comptaElements] = element;
        elements.set(elements.size(), element);
        //comptaElements++;
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
        for (int i = 0; i < elements.size(); i++) {
            getElements().get(i).mostraElement();
        }
    }
    
    public int getComptaElements() {
        return elements.size();
    }

}
