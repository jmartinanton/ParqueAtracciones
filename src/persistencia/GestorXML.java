/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;
//MODIFICADO POR MARC
//modificado por martin
//Modificado por tervera vez

import atraccions.Atraccio;
import java.io.FileWriter;
import nu.xom.*;
import personal.Coordinador;
import personal.Persona;
import personal.PersonaManteniment;
import principal.ParcAtraccions;
import principal.ParcAtraccionsExcepcio;
import zones.Zona;

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
        Element raiz = new Element("parcAtraccions");
        raiz.addAttribute(new Attribute("codi", pParcAtraccions.getCodi().toString()));
        raiz.addAttribute(new Attribute("nom", pParcAtraccions.getNom()));
        raiz.addAttribute(new Attribute("adreca", pParcAtraccions.getAdreca()));
        Element coordinadores = new Element("coordinadores");
        raiz.appendChild(coordinadores);
        Element personasMantenimiento = new Element("personasMantenimiento");
        raiz.appendChild(personasMantenimiento);
        Element atracciones = new Element("atracciones");
        raiz.appendChild(atracciones);
        Element zonas = new Element("zonas");
        raiz.appendChild(zonas);
        for (int i = 0; i < pParcAtraccions.getComptaElements(); i++) {
            Element elemento = new Element("");
            if (pParcAtraccions.getElements()[i] instanceof Atraccio) {
                elemento = new Element("atraccion");
                Element nombre = new Element("nombre");
                nombre.appendChild(((Atraccio)pParcAtraccions.getElements()[i]).getNom());
                elemento.appendChild(nombre);
                Element tipus = new Element("tipus");
                tipus.appendChild(((Atraccio)pParcAtraccions.getElements()[i]).getTipus());
                elemento.appendChild(tipus);
                Element restriccionEdad = new Element("restriccionEdad");
                restriccionEdad.appendChild(String.valueOf(((Atraccio)pParcAtraccions.getElements()[i]).getRestriccioEdat()));
                elemento.appendChild(restriccionEdad);
                Element restriccionAltura = new Element("restriccionAltura");
                restriccionAltura.appendChild(String.valueOf(((Atraccio)pParcAtraccions.getElements()[i]).getRestriccioAlcada()));
                elemento.appendChild(restriccionAltura);
                Element tieneProblema = new Element("tieneProblema");
                tieneProblema.appendChild(String.valueOf(((Atraccio)pParcAtraccions.getElements()[i]).getTeProblema()));
                elemento.appendChild(tieneProblema);
                Element codigoProblema = new Element("codigoProblema");
                codigoProblema.appendChild(String.valueOf(((Atraccio)pParcAtraccions.getElements()[i]).getCodiProblema()));
                elemento.appendChild(codigoProblema);
                Element estaSolucionado = new Element("estaSolucionado");
                estaSolucionado.appendChild(String.valueOf(((Atraccio)pParcAtraccions.getElements()[i]).getEstaSolucionat()));
                elemento.appendChild(estaSolucionado);
                atracciones.appendChild(elemento);
                continue;
            }        
            if (pParcAtraccions.getElements()[i] instanceof Zona) {
                Element raiz2 = new Element("zona");
                raiz2.addAttribute(new Attribute("nombre", pParcAtraccions.getCodi().toString()));
                Element coordinadores2 = new Element("coordinadores");
                raiz2.appendChild(coordinadores2);
                Element personasMantenimiento2 = new Element("personasMantenimiento");
                raiz2.appendChild(personasMantenimiento2);
                Element atracciones2 = new Element("atracciones");
                raiz2.appendChild(atracciones2);
                
                for (int j = 0; j < ((Zona)pParcAtraccions.getElements()[i]).getComptaElements(); j++) {
                    Element elemento2 = new Element("");
                    if (pParcAtraccions.getElements()[j] instanceof Atraccio) {
                        elemento2 = new Element("atraccion");
                        Element nombre = new Element("nombre");
                        nombre.appendChild(((Atraccio) pParcAtraccions.getElements()[j]).getNom());
                        elemento2.appendChild(nombre);
                        Element tipus = new Element("tipus");
                        tipus.appendChild(((Atraccio) pParcAtraccions.getElements()[j]).getTipus());
                        elemento2.appendChild(tipus);
                        Element restriccionEdad = new Element("restriccionEdad");
                        restriccionEdad.appendChild(String.valueOf(((Atraccio) pParcAtraccions.getElements()[j]).getRestriccioEdat()));
                        elemento2.appendChild(restriccionEdad);
                        Element restriccionAltura = new Element("restriccionAltura");
                        restriccionAltura.appendChild(String.valueOf(((Atraccio) pParcAtraccions.getElements()[j]).getRestriccioAlcada()));
                        elemento2.appendChild(restriccionAltura);
                        Element tieneProblema = new Element("tieneProblema");
                        tieneProblema.appendChild(String.valueOf(((Atraccio) pParcAtraccions.getElements()[j]).getTeProblema()));
                        elemento2.appendChild(tieneProblema);
                        Element codigoProblema = new Element("codigoProblema");
                        codigoProblema.appendChild(String.valueOf(((Atraccio) pParcAtraccions.getElements()[j]).getCodiProblema()));
                        elemento2.appendChild(codigoProblema);
                        Element estaSolucionado = new Element("estaSolucionado");
                        estaSolucionado.appendChild(String.valueOf(((Atraccio) pParcAtraccions.getElements()[j]).getEstaSolucionat()));
                        elemento2.appendChild(estaSolucionado);
                        atracciones2.appendChild(elemento2);
                        continue;
                    }
                    if (pParcAtraccions.getElements()[i] instanceof Coordinador) {
                        elemento2 = new Element("coordinador");
                        coordinadores2.appendChild(elemento2);
                    } else {
                        elemento2 = new Element("personaManteniment");
                        personasMantenimiento2.appendChild(elemento2);
                    }

                    Element nif = new Element("nif");
                    nif.appendChild(((Persona) pParcAtraccions.getElements()[i]).getNif());
                    elemento2.appendChild(nif);
                    Element nom = new Element("nom");
                    nom.appendChild(((Persona) pParcAtraccions.getElements()[i]).getNom());
                    elemento2.appendChild(nom);
                    Element cognom = new Element("cognom");
                    cognom.appendChild(((Persona) pParcAtraccions.getElements()[i]).getCognom());
                    elemento2.appendChild(cognom);
                }
                zonas.appendChild(raiz2);
            }
            if (pParcAtraccions.getElements()[i] instanceof Coordinador) {
                elemento = new Element("coordinador");
                coordinadores.appendChild(elemento);
            } else {
                elemento = new Element("personaManteniment");
                personasMantenimiento.appendChild(elemento);
            }        
            
            Element nif = new Element("nif");
            nif.appendChild(((Persona)pParcAtraccions.getElements()[i]).getNif());
            elemento.appendChild(nif);
            Element nom = new Element("nom");
            nom.appendChild(((Persona)pParcAtraccions.getElements()[i]).getNom());
            elemento.appendChild(nom);
            Element cognom = new Element("cognom");
            cognom.appendChild(((Persona)pParcAtraccions.getElements()[i]).getCognom());
            elemento.appendChild(cognom);
        }
        doc.setRootElement(raiz);
        System.out.println(doc.toXML());
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
    ///HOLAAAAAAAAAAAAAAAAAaaaaaaaaaaaa

    private void fitxerGranja() throws ParcAtraccionsExcepcio {
        //Mètode on heu de crear objectes a partir de les dades guardades en el
        //document XML.
        Element raiz = doc.getRootElement();
        Elements elemento = raiz.getChildElements();
        for (int i = 0; i < elemento.size(); i++) {
            if (elemento.get(i).)
        }
        
    }

}