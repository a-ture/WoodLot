package it.unisa.WoodLot.sevice.gestioneStatistiche;

/**
 * Interfaccia che fornisce i metodi per la logica di business delle statistiche
 *
 * @author Alessia Ture
 */
public interface StatisticheService {

    Iterable<Double> statistichePaginaUtente(Long idUtente);

    Iterable<Double> statistichePaginaResponsabileCatalogo();

    Iterable<Double> statistichePaginaContadino(Long idContadino);

    Iterable<Double> statistichePaginaResponsabileOrdini();
}
