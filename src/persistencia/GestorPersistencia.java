package persistencia;

import principal.ParcAtraccions;
import principal.ParcAtraccionsExcepcio;
//dasdasdasdasdadadasdasd


/**
 *
 * @author Francesca
 */
public class GestorPersistencia {
    private GestorXML gestor;

    public GestorXML getGestor() {
        return gestor;
    }

    public void setGestor(GestorXML pGestor) {
        gestor = pGestor;
    }  

    public void desarParcAtraccions(String tipusPersistencia, String nomFitxer, ParcAtraccions parcAtraccions) throws ParcAtraccionsExcepcio {
        if (tipusPersistencia.equals("XML")) {
            gestor = new GestorXML();
            gestor.desarParcAtraccions(nomFitxer, parcAtraccions);
        }
    }

    public void carregarParcAtraccions(String tipusPersistencia, String nomFitxer) throws ParcAtraccionsExcepcio {
        if (tipusPersistencia.equals("XML")) {
            gestor = new GestorXML();
            gestor.carregarParcAtraccions(nomFitxer);
        }
    }
}
