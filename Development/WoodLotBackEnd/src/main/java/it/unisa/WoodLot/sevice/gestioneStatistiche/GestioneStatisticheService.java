package it.unisa.WoodLot.sevice.gestioneStatistiche;

import it.unisa.WoodLot.model.entity.Ordine;
import it.unisa.WoodLot.model.entity.ProdottoOrdine;
import it.unisa.WoodLot.model.repository.OrdineRepository;
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

    /**
     * La lista delle statistiche (alberi acquistati, anidride carbonica assorbita) per la pagina del profilo utente
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
}
