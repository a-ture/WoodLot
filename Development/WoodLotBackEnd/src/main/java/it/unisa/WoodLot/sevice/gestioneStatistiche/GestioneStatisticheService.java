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
     * La lista delle statistiche (alberi acquistati utente, anidride carbonica assorbita utente) per la pagina del profilo utente
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
                anidride += p.getAlbero().getAnidrideCarbonicaAssorbita();
        }
        statistiche.add(alberiPiantati);
        statistiche.add(anidride);

        return statistiche;
    }

    /**
     * La lista delle statistiche (alberi acquistati, anidride carbonica assorbita) per la pagina diventa un contadino
     * e per il profilo del responsabile catalogo
     */
    @Override
    public Iterable<Double> statistichePaginaResponsabileCatalogo() {
        ArrayList<Double> statistiche = new ArrayList<>(4);

        List<Ordine> list = ordineRepository.findAll();
        double alberi = 0, anidride = 0, paesi = 0, contadini = 0;
        for (Ordine o : list) {
            alberi += o.getProdottiOrdine().size();
            for (ProdottoOrdine p : o.getProdottiOrdine())
                anidride += p.getAlbero().getAnidrideCarbonicaAssorbita();
        }

        statistiche.add(alberi);
        statistiche.add(anidride);

        paesi = paeseOrigineRepository.findAll().size();
        statistiche.add(paesi);

        contadini = contadinoRepository.findAll().size();
        statistiche.add(contadini);

        return statistiche;
    }

    /**
     * La lista delle statistiche di un contadino (alberi curati, frutti raccolti, anidride carbonica)
     *
     * @param idContadino l'id del contadino di cui si vogliono visualizzare le statistiche
     * @return
     */

    @Override
    public Iterable<Double> statistichePaginaContadino(Long idContadino) {
        ArrayList<Double> statistiche = new ArrayList<>(3);

        ArrayList<ProdottoOrdine> prodotti = prodottoOrdineRepository.findAllByContadino_Id(idContadino);
        double alberi, frutta = 0, anidride = 0;

        for (ProdottoOrdine p : prodotti) {
            frutta += p.getFrutta();
            anidride += p.getAlbero().getAnidrideCarbonicaAssorbita();
        }
        alberi = prodotti.size();

        statistiche.add(anidride);
        statistiche.add(frutta);
        statistiche.add(alberi);
        return statistiche;
    }
}
