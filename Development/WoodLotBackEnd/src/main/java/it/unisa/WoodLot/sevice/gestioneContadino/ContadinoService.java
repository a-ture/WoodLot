package it.unisa.WoodLot.sevice.gestioneContadino;

import it.unisa.WoodLot.model.entity.Contadino;
import it.unisa.WoodLot.model.entity.ProdottoOrdine;
import it.unisa.WoodLot.sevice.gestioneContadino.eccezioni.ContadinoException;

/**
 * Interfaccia che fornisce i metodi per la logica di business per la gestione dei contadini
 *
 * @author Alessia Ture
 */
public interface ContadinoService {

    Iterable<Contadino> getElencoContadini();

    Iterable<ProdottoOrdine> getAlberiNonAssegnati();

    ProdottoOrdine aggiornaStato(ProdottoOrdine prodottoOrdine) throws ContadinoException;
}
