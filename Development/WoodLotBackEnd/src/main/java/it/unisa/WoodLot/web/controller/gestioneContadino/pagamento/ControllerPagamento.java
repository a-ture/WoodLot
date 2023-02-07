package it.unisa.WoodLot.web.controller.gestioneContadino.pagamento;

import it.unisa.WoodLot.sevice.gestioneContadino.pagamento.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller per la gestione dei pagamenti ai contadini
 */
@RestController
@RequestMapping("/api/pagamento")
public class ControllerPagamento {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping("/elencoPagamenti/{idContadino}")
    public ResponseEntity<Object> elencoPagamentiContadino(@PathVariable Long idContadino) {
        return new ResponseEntity<>(pagamentoService.visualizzaElencoPagamenti(idContadino), HttpStatus.ACCEPTED);
    }
}
