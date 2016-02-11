package enunciatPracticaUF5Part2;


import model.ParcAtraccions;
import persistencia.GestorXML;
import persistencia.ProveedorPersistencia;
import principal.ParcAtraccionsExcepcio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fta
 */
public class MetodesNous {
        
    /*Mètode a modificar en la interfície ProveedorPersistencia*/
     public ParcAtraccions carregarParcAtraccions(String nomFitxer) throws ParcAtraccionsExcepcio;
     
     /*Mètode a modificar en la interfície GestorXML*/
    public ParcAtraccions carregarParcAtraccions(String nomFitxer) throws ParcAtraccionsExcepcio {
        carregarFitxer(nomFitxer);
        fitxerParcAtraccions();
        return parcAtraccions;
    }
    
    /*Mètode a modificar en la classe GestorPersistencia*/
    public ParcAtraccions carregarParcAtraccions(String tipusPersistencia, String nomFitxer) throws ParcAtraccionsExcepcio {
        ProveedorPersistencia gestor = null;
        ParcAtraccions parcAtraccions = null;
        if (tipusPersistencia.equals("XML")) {
            gestor = new GestorXML();
            parcAtraccions= gestor.carregarParcAtraccions(nomFitxer);
        }
        return parcAtraccions;
    }
}
