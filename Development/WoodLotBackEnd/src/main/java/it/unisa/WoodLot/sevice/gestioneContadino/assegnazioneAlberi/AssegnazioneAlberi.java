package it.unisa.WoodLot.sevice.gestioneContadino.assegnazioneAlberi;

import it.unisa.WoodLot.model.entity.Contadino;
import it.unisa.WoodLot.model.entity.ProdottoOrdine;
import it.unisa.WoodLot.model.repository.ProdottoOrdineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Algoritmo greedy per l'assegnamento degli alberi ai contadini
 *
 * @author Alessia Ture
 */
@Service
public class AssegnazioneAlberi {
    @Autowired
    private ProdottoOrdineRepository contadinoRepository;

    public List<ProdottoOrdine> assegnazione(List<Contadino> farmers, List<ProdottoOrdine> trees) {
        List<ProdottoOrdine> prodotti = new ArrayList<>();
        List<Contadino> assignedFarmers = new ArrayList<>();

        for (ProdottoOrdine tree : trees) {
            // creiamo una lista di contadini compatibili per ogni albero, escludendo quelli già assegnati
            List<Contadino> compatibleFarmers = new ArrayList<>();
            for (Contadino farmer : farmers) {
                if (!assignedFarmers.contains(farmer) && farmer.getCoordinateGeografiche().equals(tree.getPaeseOrigine().getNome())) {
                    compatibleFarmers.add(farmer);
                }
            }

            // ordiniamo i contadini compatibili in base al numero di alberi piantati
            Collections.sort(compatibleFarmers, new Comparator<Contadino>() {
                public int compare(Contadino f1, Contadino f2) {
                    return contadinoRepository.findAllByContadino_Id(f1.getId()).size() - contadinoRepository.findAllByContadino_Id(f2.getId()).size();
                }
            });

            // assegniamo l'albero al contadino con meno alberi piantati solo se ci sono contadini compatibili
            if (compatibleFarmers.size() > 0) {
                Contadino assignedFarmer = compatibleFarmers.get(0);
                tree.setContadino(assignedFarmer);
                prodotti.add(tree);
                assignedFarmers.add(assignedFarmer);
            }
        }
        return prodotti;
    }
}
