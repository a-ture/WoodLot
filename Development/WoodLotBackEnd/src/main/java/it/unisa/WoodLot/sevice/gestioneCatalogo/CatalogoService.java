package it.unisa.WoodLot.sevice.gestioneCatalogo;

import it.unisa.WoodLot.model.entity.Albero;

import java.util.List;
import java.util.Set;

/**
 * Interfaccia che fornisce i metodi per la logica di business della gestione del catalgo
 *
 * @author Alessia Ture
 */
public interface CatalogoService {

    Set<Albero> getProdotti();

    Set<Albero> getProdottiFiltratiByPrezzo(String parametro);

    Set<Albero> getProdottiFiltratiByAnidrideCarbonica(String parametro);

    Set<Albero> getProdottiFiltratiByPaese(String nomePaese);

    Set<Albero> getProdottiFiltratiByUsoLocale(String usoLocale);

    Set<Albero> getProdottiFiltratiByCategoria(String nomeCategoria);

    Albero aggiungiProdotto(Albero albero);

    void eliminaProdotto(Albero albero);
}
