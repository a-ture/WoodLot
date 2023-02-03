package it.unisa.WoodLot.sevice.gestioneCatalogo.prodotto;

import it.unisa.WoodLot.model.entity.Albero;
import it.unisa.WoodLot.sevice.gestioneCatalogo.eccezioni.AlberoException;

/**
 * Interfaccia che fornisce i metodi per la logica di business della gestione di un prodotto
 *
 * @author Alessia Ture
 */
public interface ProdottoService {

    Albero getProdotto(String nomeAlbero) throws AlberoException;

}
