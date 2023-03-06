package it.unisa.WoodLot.web.control.gestioneContadino.pagamento;

import it.unisa.WoodLot.model.entity.Contadino;
import it.unisa.WoodLot.model.entity.Pagamento;
import it.unisa.WoodLot.model.repository.ContadinoRepository;
import it.unisa.WoodLot.model.repository.PagamentoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


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
    @Autowired
    private ContadinoRepository contadinoRepository;

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
    }

    /**
     * Testa il caso in cui si vuole effettuare un pagamento ma viene sollevata un eccezione
     * Il test risulta essere superato se il messaggio generato corrisponde all'oracolo
     */
    @Test
    void testEffettuarePagamento_Exception() {
        Contadino contadino = new Contadino();
        contadino.setId(345L);
        Pagamento pagamento = new Pagamento();
        pagamento.setMotivazioni("Test");
        pagamento.setImporto(345);
        pagamento.setContadino(contadino);

        ResponseEntity<Object> responseEntity = restTemplate.postForEntity("http://localhost:8090/api/pagamento", pagamento, Object.class);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    /**
     * Testa il caso in cui si vuole effettuare un pagamento
     * Il test risulta essere superato se viene effettuato il pagamento
     */
    @Test
    void testEffettuarePagamento() {
        Contadino contadino = contadinoRepository.findById(6L).orElse(null);

        Pagamento pagamento = new Pagamento();
        pagamento.setMotivazioni("Test");
        pagamento.setImporto(345);
        pagamento.setContadino(contadino);
        ResponseEntity<Object> responseEntity = restTemplate.postForEntity("http://localhost:8090/api/pagamento", pagamento, Object.class);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }
}
