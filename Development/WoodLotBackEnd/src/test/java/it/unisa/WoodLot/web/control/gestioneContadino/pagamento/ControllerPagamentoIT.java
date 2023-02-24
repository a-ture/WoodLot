package it.unisa.WoodLot.web.control.gestioneContadino.pagamento;

import it.unisa.WoodLot.model.entity.Pagamento;
import it.unisa.WoodLot.model.repository.PagamentoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Test d' integrazione per la classe ControllerPagamento
 *
 * @author Alessia Ture
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerPagamentoIT {

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private PagamentoRepository pagamentoRepository;

    /**
     * Testa il caso in cui si vuole recuperare l'elenco dei pagamenti a un contadino
     * Il test è superato se l'elenco viene recuperato correttamente
     */
    @Test
    public void testElencoPagamentiContadino() {
        Long idContadino = 1L;
        List<Pagamento> pagamenti = pagamentoRepository.findAllByContadino_Id(idContadino);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        Map<String, Long> uriVariables = new HashMap<>();
        uriVariables.put("idContadino", idContadino);

        ResponseEntity<List> response = restTemplate.exchange(
                "http://localhost:8090/api/pagamento/elencoPagamenti/{idContadino}" + idContadino,
                HttpMethod.GET, entity, List.class, uriVariables);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(pagamenti.size(), response.getBody().size());
    }

}
