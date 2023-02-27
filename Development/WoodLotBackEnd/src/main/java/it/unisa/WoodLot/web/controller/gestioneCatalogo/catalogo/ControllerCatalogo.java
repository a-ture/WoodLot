package it.unisa.WoodLot.web.controller.gestioneCatalogo.catalogo;

import it.unisa.WoodLot.model.entity.Albero;
import it.unisa.WoodLot.sevice.gestioneCatalogo.eccezioni.AlberoException;
import it.unisa.WoodLot.sevice.gestioneCatalogo.catalogo.CatalogoService;
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
 * Controller per la gestione del catalogo
 *
 * @author Alessia Ture
 */

@RestController
@RequestMapping("/api/catalogo")
public class ControllerCatalogo {

    @Autowired
    private CatalogoService catalogoService;

    /**
     * Metodo POST per inserire un prodotto nel catalogo
     *
     * @param albero è il prodotto da inserire nel catalogo
     * @return true se l'inserimento ha avuto esito positivo, false altrimenti
     */
    @PostMapping("/inserimentoProdotto")
    public ResponseEntity<Object> inserimentoCatalogo(@RequestBody Albero albero) {
        try {
            Albero a = catalogoService.aggiungiProdotto(albero);
            return new ResponseEntity<>(a, HttpStatus.CREATED);
        } catch (AlberoException e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST,
                    e.getMessage());
        }
    }

    /**
     * Permette di salvare le foto nella loro posizione
     */
    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<Object> uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("treeName") String treeName) throws IOException {
        String UPLOAD_DIR = "/Users/alessiature/Desktop/WoodLot/Development/WoodLotFrontEnd/src/assets/img/alberi";

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        File directory = new File(UPLOAD_DIR + "/" + treeName);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        File dest = new File(directory.getAbsolutePath() + File.separator + fileName);
        file.transferTo(dest);
        System.out.println(dest);

        return ResponseEntity.ok().build();
    }

    /**
     * Metodo GET per eliminare un prodotto dal catalogo
     *
     * @param idAlbero è l'id del albero da eliminare dal catalogo
     */
    @GetMapping("/eliminaProdotto/{idAlbero}")
    public void eliminaProdottoCatalogo(@PathVariable String idAlbero) throws AlberoException {
        catalogoService.eliminaProdotto(idAlbero);
    }

}
