package it.unisa.WoodLot.web.controller.gestioneContadino;

import it.unisa.WoodLot.model.entity.Contadino;
import it.unisa.WoodLot.model.entity.ProdottoOrdine;
import it.unisa.WoodLot.sevice.gestioneContadino.ContadinoService;
import it.unisa.WoodLot.sevice.gestioneContadino.eccezioni.ContadinoException;
import it.unisa.WoodLot.web.controller.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Controller per la gestione dei contadini
 */
@RestController
@RequestMapping("/api/contadino")
public class ControllerContadino {

    @Autowired
    private ContadinoService contadinoService;

    /**
     * Metodo GET per visualizzare l'elenco dei contadini
     *
     * @return
     */
    @GetMapping("")
    public ResponseEntity<Object> visualizzaElencoContadini() {
        return new ResponseEntity<>(contadinoService.getElencoContadini(), HttpStatus.ACCEPTED);
    }

    /**
     * Metodo GET per visualizzare l'elenco degli alberi non ancora assegnati
     *
     * @return
     */
    @GetMapping("/alberiNonAssegnati")
    public ResponseEntity<Object> elencoAlberiNonAssegnati() {
        return new ResponseEntity<>(contadinoService.getAlberiNonAssegnati(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/aggiornaStato")
    public ResponseEntity<Object> aggiornaStato(@RequestBody ProdottoOrdine prodottoOrdine) {
        try {
            return new ResponseEntity<>(contadinoService.aggiornaStato(prodottoOrdine), HttpStatus.CREATED);
        } catch (ContadinoException e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    /**
     * Permette di salvare le foto nella loro posizione
     */
    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<Object> uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("contadinoId") String contadinoId) throws IOException {
        String UPLOAD_DIR = "/Users/alessiature/Desktop/WoodLot/Development/WoodLotFrontEnd/src/assets/img/alberiUtente/";

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        File directory = new File(UPLOAD_DIR + "/" + contadinoId);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        File dest = new File(directory.getAbsolutePath() + File.separator + fileName);
        file.transferTo(dest);
        System.out.println(dest);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/alberiContadino/{idContadino}")
    public ResponseEntity<Object> restituisceAlberiContadino(@PathVariable Long idContadino) {
        return new ResponseEntity<>(contadinoService.elencoAlberiContadino(idContadino), HttpStatus.ACCEPTED);
    }
}
