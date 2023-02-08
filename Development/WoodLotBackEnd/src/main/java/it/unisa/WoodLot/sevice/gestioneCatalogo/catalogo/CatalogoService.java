package it.unisa.WoodLot.sevice.gestioneCatalogo.catalogo;

import it.unisa.WoodLot.model.entity.Albero;
import it.unisa.WoodLot.sevice.gestioneCatalogo.eccezioni.AlberoException;

import java.io.IOException;


/**
 * Interfaccia che fornisce i metodi per la logica di business della gestione del catalogo
 * (inserimento nuovo prodotto ed eliminazione prodotto)
 *
 * @author Alessia Ture
 */
public interface CatalogoService {
    void salvaImmagine(byte[] imageData, String fileName) throws IOException;

    Albero aggiungiProdotto(Albero albero) throws AlberoException;

    void eliminaProdotto(String idAlbero);
}
