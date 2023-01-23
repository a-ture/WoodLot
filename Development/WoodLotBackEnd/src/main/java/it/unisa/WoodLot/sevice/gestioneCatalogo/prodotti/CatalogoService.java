package it.unisa.WoodLot.sevice.gestioneCatalogo.prodotti;

import it.unisa.WoodLot.model.entity.Albero;


/**
 * Interfaccia che fornisce i metodi per la logica di business della gestione del catalogo
 *
 * @author Alessia Ture
 */
public interface CatalogoService {


    Albero aggiungiProdotto(Albero albero);

    void eliminaProdotto(Albero albero);
}
