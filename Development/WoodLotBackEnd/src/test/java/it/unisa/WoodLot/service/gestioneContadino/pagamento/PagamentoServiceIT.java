package it.unisa.WoodLot.service.gestioneContadino.pagamento;

import it.unisa.WoodLot.model.entity.Contadino;
import it.unisa.WoodLot.model.entity.Pagamento;
import it.unisa.WoodLot.model.repository.ContadinoRepository;
import it.unisa.WoodLot.model.repository.PagamentoRepository;
import it.unisa.WoodLot.sevice.gestioneContadino.eccezioni.ContadinoException;
import it.unisa.WoodLot.sevice.gestioneContadino.pagamento.GestionePagamentoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test d'integrazione fra la classe GestionePagamentoService e la repository.
 *
 * @author Alessia Ture
 */
@SpringBootTest
@Transactional
@Rollback
@ExtendWith(SpringExtension.class)
public class PagamentoServiceIT {
    @Autowired
    private ContadinoRepository contadinoRepository;
    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private GestionePagamentoService gestionePagamentoService;

    /**
     * Testa il caso in cui vengono visualizzati tutti i pagamenti presenti
     * Il test risulta superato se vengono recuperati tutti i pagamenti
     */
    @Test
    public void testVisualizzaElencoPagamenti() {
        Contadino contadino = new Contadino();
        contadino.setNome("Luca");
        contadino.setCoordinateGeografiche("string");
        contadino.setCognome("Rossi");
        contadino.setSwift("34");
        contadino.setEmail("lucarossi@gmail.com");
        contadino.setPassword("password");
        contadino.setTitolareConto("Luca Rossi");
        contadino.setDataDiNascita(new Date());
        contadino = contadinoRepository.save(contadino);

        Pagamento pagamento1 = new Pagamento();
        pagamento1.setContadino(contadino);
        pagamento1.setDataPagamento(new Date());
        pagamento1.setImporto(120);
        pagamento1.setMotivazioni("Motivazione");
        pagamento1 = pagamentoRepository.save(pagamento1);

        Pagamento pagamento2 = new Pagamento();
        pagamento2.setContadino(contadino);
        pagamento2.setDataPagamento(new Date());
        pagamento2.setImporto(1320);
        pagamento2.setMotivazioni("Motivazione");
        pagamento2 = pagamentoRepository.save(pagamento2);

        Iterable<Pagamento> pagamenti = gestionePagamentoService.visualizzaElencoPagamenti(contadino.getId());

        List<Pagamento> pagamentiList = StreamSupport.stream(pagamenti.spliterator(), false)
                .collect(Collectors.toList());

        assertEquals(2, pagamentiList.size());
        assertTrue(pagamentiList.contains(pagamento1));
        assertTrue(pagamentiList.contains(pagamento2));
    }

    /**
     * Testa il caso in cui si effettua un nuovo pagamento
     * Il test risulta superato se viene creato un nuovo pagamento
     */
    @Test
    @Transactional
    void testEffettuarePagamento() {
        Contadino contadino = new Contadino();
        contadino.setNome("Mario");
        contadino.setCognome("Rossi");
        contadino.setEmail("mario.rossi@example.com");
        contadino.setPassword("password");
        contadino.setCoordinateGeografiche("Paese");
        contadino.setDataDiNascita(new Date());
        contadino = contadinoRepository.save(contadino);

        Pagamento pagamento = new Pagamento();
        pagamento.setImporto(500);
        pagamento.setMotivazioni("Acquisto di frutta e verdura dal contadino");
        pagamento.setContadino(contadino);

        try {
            Pagamento result = gestionePagamentoService.effettuarePagamento(pagamento);

            assertNotNull(result);
            assertNotNull(result.getId());
            assertEquals(pagamento.getImporto(), result.getImporto());
            assertEquals(pagamento.getMotivazioni(), result.getMotivazioni());
            assertNotNull(result.getDataPagamento());
            assertNotNull(result.getContadino());
            assertEquals(contadino.getId(), result.getContadino().getId());

            Pagamento foundPagamento = pagamentoRepository.findById(result.getId()).orElse(null);
            assertNotNull(foundPagamento);
            assertEquals(result, foundPagamento);
        } catch (ContadinoException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Testa il caso in cui si effettua un nuovo pagamento ma si fornisce un id di un contadino non valido
     * Il test risulta superato se viene lanciata l'eccezione
     */
    @Test
    public void testEffettuarePagamentoWithInvalidContadinoId() {
        Pagamento pagamento = new Pagamento();
        pagamento.setContadino(new Contadino());
        pagamento.getContadino().setId(258L);

        // Act & Assert
        ContadinoException exception = assertThrows(ContadinoException.class, () -> {
            gestionePagamentoService.effettuarePagamento(pagamento);
        });

        assertEquals("L'id fornito non è valido", exception.getMessage());
    }
}
