package it.unisa.WoodLot.web.controller.gestioneContadino.pagamento;

import it.unisa.WoodLot.model.entity.Pagamento;
import it.unisa.WoodLot.model.entity.ProdottoOrdine;
import it.unisa.WoodLot.sevice.gestioneContadino.eccezioni.ContadinoException;
import it.unisa.WoodLot.sevice.gestioneContadino.pagamento.PagamentoService;
import it.unisa.WoodLot.web.controller.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller per la gestione dei pagamenti ai contadini
 */
@RestController
@RequestMapping("/api/pagamento")
public class ControllerPagamento {

    @Autowired
    private PagamentoService pagamentoService;

    /**
     * Metodo GET per visalizzare l'elenco dei pagamenti
     *
     * @param idContadino
     * @return
     */
    @GetMapping("/elencoPagamenti/{idContadino}")
    public ResponseEntity<Object> elencoPagamentiContadino(@PathVariable Long idContadino) {
        return new ResponseEntity<>(pagamentoService.visualizzaElencoPagamenti(idContadino), HttpStatus.ACCEPTED);
    }

    /**
     * Metodo POST per effettuare un nuovo pagamento
     *
     * @return
     */
    @PostMapping
    public ResponseEntity<Object> effettuarePagamento(@RequestBody Pagamento pagamento) {
        try {
            return new ResponseEntity<>(pagamentoService.effettuarePagamento(pagamento), HttpStatus.CREATED);
        } catch (ContadinoException e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
