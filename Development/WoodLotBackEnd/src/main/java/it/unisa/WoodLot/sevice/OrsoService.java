package it.unisa.WoodLot.sevice;

import it.unisa.WoodLot.model.entity.Orso;

public interface OrsoService {

    public Orso addNewOrso(Orso orso);
    public Orso getOrsoById(Long id);
}
