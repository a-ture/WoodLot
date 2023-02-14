package it.unisa.WoodLot.sevice.gestioneStatistiche;

import it.unisa.WoodLot.model.entity.Ordine;
import it.unisa.WoodLot.model.entity.ProdottoOrdine;
import it.unisa.WoodLot.model.repository.ContadinoRepository;
import it.unisa.WoodLot.model.repository.OrdineRepository;
import it.unisa.WoodLot.model.repository.PaeseOrigineRepository;
import it.unisa.WoodLot.model.repository.ProdottoOrdineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe fornisce i metodi per la logica di business per la gestione delle statistiche
 *
 * @author Alessia Ture
 */
@Service
public class GestioneStatisticheService implements StatisticheService {

    @Autowired
    private OrdineRepository ordineRepository;

    @Autowired
    private PaeseOrigineRepository paeseOrigineRepository;

    @Autowired
    private ContadinoRepository contadinoRepository;

    @Autowired
    private ProdottoOrdineRepository prodottoOrdineRepository;

    /**
     * Calcala la lista delle statistiche (alberi acquistati utente, anidride carbonica assorbita utente) per la pagina del profilo utente
     */
    @Override
    public Iterable<Double> statistichePaginaUtente(Long idUtente) {
        ArrayList<Double> statistiche = new ArrayList<>(2);

        List<Ordine> list = ordineRepository.findOrdineByUtente_Id(idUtente);
        double alberiPiantati = 0;
        double anidride = 0;
        for (Ordine o : list) {
            alberiPiantati += o.getProdottiOrdine().size();
            for (ProdottoOrdine p : o.getProdottiOrdine())
                anidride += p.getAnidrideCarbonicaAssorbita();
        }
        statistiche.add(alberiPiantati);
        statistiche.add(anidride);

        return statistiche;
    }

    /**
     * Calcala la lista delle statistiche (alberi acquistati, anidride carbonica assorbita) per la pagina diventa un contadino
     * e per il profilo del responsabile catalogo
     */
    @Override
    public Iterable<Double> statistichePaginaResponsabileCatalogo() {
        List<Double> statistiche = new ArrayList<>(4);

        List<Ordine> list = ordineRepository.findAll();
        double alberi = 0, anidride = 0, paesi = 0, contadini = 0;
        for (Ordine o : list) {
            alberi += o.getProdottiOrdine().size();
            for (ProdottoOrdine p : o.getProdottiOrdine())
                anidride += p.getAnidrideCarbonicaAssorbita();
        }

        statistiche.add(alberi);
        statistiche.add(anidride);

        contadini = contadinoRepository.findAll().size();
        statistiche.add(contadini);

        paesi = paeseOrigineRepository.findAll().size();
        statistiche.add(paesi);

        return statistiche;
    }

    /**
     * Calcola la lista delle statistiche di un contadino (alberi curati, frutti raccolti, anidride carbonica)
     *
     * @param idContadino l'id del contadino di cui si vogliono visualizzare le statistiche
     * @return
     */

    @Override
    public Iterable<Double> statistichePaginaContadino(Long idContadino) {
        List<Double> statistiche = new ArrayList<>(3);

        ArrayList<ProdottoOrdine> prodotti = prodottoOrdineRepository.findAllByContadino_Id(idContadino);
        double alberi, frutta = 0, anidride = 0;

        for (ProdottoOrdine p : prodotti) {
            frutta += p.getFrutta();
            anidride += p.getAnidrideCarbonicaAssorbita();
        }
        alberi = prodotti.size();

        statistiche.add(anidride);
        statistiche.add(frutta);
        statistiche.add(alberi);
        return statistiche;
    }

    /**
     * Calcola la lista delle statistiche per la pagina del responsabile degli ordini
     * (alberi piantati, ordini effettuati, contadini coinvolti, paesi)
     */
    @Override
    public Iterable<Double> statistichePaginaResponsabileOrdini() {
        List<Double> statistiche = new ArrayList<>(3);
        double ordini, contadini, paesi, alberi = 0;

        ordini = ordineRepository.findAll().size();
        paesi = paeseOrigineRepository.findAll().size();
        contadini = contadinoRepository.findAll().size();

        for (Ordine p : ordineRepository.findAll())
            alberi += p.getProdottiOrdine().size();

        statistiche.add(alberi);
        statistiche.add(contadini);
        statistiche.add(ordini);
        statistiche.add(paesi);

        return statistiche;
    }
}
