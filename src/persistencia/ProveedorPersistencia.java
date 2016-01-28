package persistencia;

import principal.ParcAtraccions;
import principal.ParcAtraccionsExcepcio;

/**
 *
 * @author MiguelAngel
 */
public interface ProveedorPersistencia {
    public void desarParcAtraccions(String nomFitxer, ParcAtraccions parcAtraccions) throws ParcAtraccionsExcepcio;
    public void carregarParcAtraccions(String nomFitxer) throws ParcAtraccionsExcepcio;
}
