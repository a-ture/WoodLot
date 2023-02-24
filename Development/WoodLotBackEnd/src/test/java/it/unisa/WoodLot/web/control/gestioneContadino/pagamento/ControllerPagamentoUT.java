package it.unisa.WoodLot.web.control.gestioneContadino.pagamento;

import it.unisa.WoodLot.model.entity.Pagamento;
import it.unisa.WoodLot.sevice.gestioneContadino.pagamento.GestionePagamentoService;
import it.unisa.WoodLot.web.controller.gestioneContadino.pagamento.ControllerPagamento;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


/**
 * Test di unità per la classe ControllerPagamento
 *
 * @author Alessia Ture
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ControllerPagamentoUT {

    @Mock
    private GestionePagamentoService gestionePagamentoService;
    @InjectMocks
    private ControllerPagamento controllerPagamento;

    /**
     * Testa il caso in cui si vuole recuperare l'elenco dei pagamenti a un contadino
     * Il test è superato se l'elenco viene recuperato correttamente
     */
    @Test
    public void testElencoPagamentiContadino() {
        Long idContadino = 1L;
        List<Pagamento> elencoPagamenti = new ArrayList<>();
        elencoPagamenti.add(new Pagamento());

        when(gestionePagamentoService.visualizzaElencoPagamenti(idContadino)).thenReturn(elencoPagamenti);

        ResponseEntity<Object> response = controllerPagamento.elencoPagamentiContadino(idContadino);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(elencoPagamenti, response.getBody());
    }
}
