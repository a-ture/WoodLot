package it.unisa.WoodLot.web.controller.gestioneOrso.orso;

import it.unisa.WoodLot.model.entity.Orso;
import it.unisa.WoodLot.sevice.gestioneOrso.orso.OrsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ControllerOrso {
    @Autowired
    private OrsoService orsoService;

    @PostMapping("/inserimentoOrso")
    public boolean inserimentoOrso(@RequestBody Orso orso){
       Orso o = orsoService.addNewOrso(orso);
       return o.getId() == null ? false : true;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Orso> getOrsoById(@PathVariable (value = "id") Long id){
       Orso orsetto = orsoService.getOrsoById(id);
       return ResponseEntity.ok().body(orsetto);

    }
}
