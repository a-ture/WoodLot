package it.unisa.WoodLot.sevice;

import it.unisa.WoodLot.model.entity.Orso;
import it.unisa.WoodLot.model.repository.OrsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GestioneOrsoService implements OrsoService{
    @Autowired
    private OrsoRepository orsoRepository;

    public Orso addNewOrso(Orso orso){
        return orsoRepository.save(orso);
    }

    public Orso getOrsoById(Long id){
        Optional<Orso> o = orsoRepository.findById(id);
        return o.isPresent() == true ? o.get() : new Orso();
    }
}
