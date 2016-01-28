/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;


import atraccions.Atraccio;
import java.io.FileWriter;
import nu.xom.*;
import personal.Coordinador;
import personal.Persona;
import personal.PersonaManteniment;
import principal.ParcAtraccions;
import principal.ParcAtraccionsExcepcio;

public class GestorXML implements ProveedorPersistencia {

    private Document doc;
    private ParcAtraccions parcAtraccions;

    public ParcAtraccions getParcAtraccions() {
        return parcAtraccions;
    }

    public void setParcAtraccions(ParcAtraccions pParcAtraccions) {
        parcAtraccions = pParcAtraccions;
    }
    
    public void gg(String... params) {
        
    }
    

    @Override
    public void desarParcAtraccions(String nomFitxer, ParcAtraccions pParcAtraccions) throws ParcAtraccionsExcepcio {
        construeixModel(pParcAtraccions);
        desarModel(nomFitxer);
    }

    @Override
    public void carregarParcAtraccions(String nomFitxer) throws ParcAtraccionsExcepcio {
        carregarFitxer(nomFitxer);
        fitxerGranja();
    }
    
    private void construeixModel(ParcAtraccions pParcAtraccions) throws ParcAtraccionsExcepcio {
       //Mètode on heu de construir el document XML
        Element raiz = new Element("parc atraccions");
        Element coordinadores = new Element("coordinadores");
        Element personasMantenimiento = new Element("personas mantenimiento");
        Element atracciones = new Element("atracciones");
        for (int i = 0; i < pParcAtraccions.getComptaElements(); i++) {
            if (pParcAtraccions.getElements()[i] instanceof Coordinador) {
                //pParcAtraccions.getElements()[i].mostraElement()
                Element coordinador = new Element("coordinador");
                Element nif = new Element("nif");
                nif.appendChild(((Persona)pParcAtraccions.getElements()[i]).getNif());
                Element nom = new Element("nom");
                nom.appendChild(((Persona)pParcAtraccions.getElements()[i]).getNom());
                Element cognom = new Element("cognom");
                cognom.appendChild(((Persona)pParcAtraccions.getElements()[i]).getCognom());
            }
            if (pParcAtraccions.getElements()[i] instanceof PersonaManteniment) {
                pParcAtraccions.getElements()[i].mostraElement();
            }
            if (pParcAtraccions.getElements()[i] instanceof Atraccio) {
                pParcAtraccions.getElements()[i].mostraElement();
            }
        }
    }

    private void desarModel(String rutaFitxer) throws ParcAtraccionsExcepcio {
        try {            
            FileWriter fitxer = new FileWriter(rutaFitxer,false); //Obrim fitxer per sobreescriure
            fitxer.write(doc.toXML()); 
            fitxer.close(); 
        } catch (Exception e) {
            throw new ParcAtraccionsExcepcio("GestorXML.desar");
        }
    }

    private void carregarFitxer(String rutaFitxer) throws ParcAtraccionsExcepcio {
        Builder builder = new Builder();
        try {
            doc = builder.build(rutaFitxer);
        } catch (Exception e) {
            throw new ParcAtraccionsExcepcio("GestorXML.carregar");
        }
    }

    private void fitxerGranja() throws ParcAtraccionsExcepcio {
        //Mètode on heu de crear objectes a partir de les dades guardades en el
        //document XML.
    }

}
