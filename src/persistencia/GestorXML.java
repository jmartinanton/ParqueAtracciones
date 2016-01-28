/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;


import java.io.FileWriter;
import nu.xom.*;
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
