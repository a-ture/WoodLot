package it.unisa.WoodLot.sevice.gestioneOrso.orso;

import it.unisa.WoodLot.model.entity.Orso;

public interface OrsoService {

    public Orso addNewOrso(Orso orso);
    public Orso getOrsoById(Long id);
}
