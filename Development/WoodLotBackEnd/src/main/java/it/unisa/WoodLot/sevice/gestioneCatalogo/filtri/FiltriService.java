package it.unisa.WoodLot.sevice.gestioneCatalogo.filtri;

import it.unisa.WoodLot.model.entity.Albero;

/**
 * Interfaccia che fornisce i metodi per filtrare i prodotti del catalogo
 *
 * @author Alessia Ture
 */
public interface FiltriService {

    Iterable<Albero> getProdotti();
    Iterable<Albero> getProdottiFiltratiByPrezzo(String parametro);

    Iterable<Albero> getProdottiFiltratiByAnidrideCarbonica(String parametro);

    Iterable<Albero> getProdottiFiltratiByPaese(String nomePaese);

    Iterable<Albero> getProdottiFiltratiByUsoLocale(String usoLocale);

    Iterable<Albero> getProdottiFiltratiByCategoria(String nomeCategoria);
}
