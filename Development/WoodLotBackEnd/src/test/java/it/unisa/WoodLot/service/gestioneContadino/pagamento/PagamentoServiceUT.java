package it.unisa.WoodLot.service.gestioneContadino.pagamento;

import it.unisa.WoodLot.model.entity.Contadino;
import it.unisa.WoodLot.model.entity.Pagamento;
import it.unisa.WoodLot.model.repository.ContadinoRepository;
import it.unisa.WoodLot.model.repository.PagamentoRepository;
import it.unisa.WoodLot.sevice.gestioneContadino.eccezioni.ContadinoException;
import it.unisa.WoodLot.sevice.gestioneContadino.pagamento.GestionePagamentoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Test di unità per la classe GestionePagamentoService
 *
 * @author Alessia Ture
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PagamentoServiceUT {

    @Mock
    private PagamentoRepository pagamentoRepository;
    @Mock
    private ContadinoRepository contadinoRepository;
    @InjectMocks
    private GestionePagamentoService gestionePagamentoService;

    /**
     * Testa il caso in cui vengono visualizzati tutti i pagamenti presenti
     * Il test risulta superato se vengono recuperati tutti i pagamenti
     */
    @Test
    public void testVisualizzaElencoPagamenti() {
        Long idContadino = 1L;
        Pagamento pagamento = new Pagamento();
        pagamento.setId(1L);
        Pagamento pagamento1 = new Pagamento();
        pagamento.setId(2L);

        ArrayList<Pagamento> pagamenti = new ArrayList<>();
        pagamenti.add(pagamento);
        pagamenti.add(pagamento1);

        when(pagamentoRepository.findAllByContadino_Id(idContadino)).thenReturn(pagamenti);

        Iterable<Pagamento> result = gestionePagamentoService.visualizzaElencoPagamenti(idContadino);

        assertEquals(result, pagamenti);
    }

    /**
     * Testa il caso in cui si effettua un nuovo pagamento con successo
     * Il test risulta superato se viene creato un nuovo pagamento
     */
    @Test
    void testEffettuarePagamentoSuccesso() {
        Contadino contadino = new Contadino();
        contadino.setId(1L);

        Pagamento pagamento = new Pagamento();
        pagamento.setContadino(contadino);
        pagamento.setMotivazioni("Test");
        pagamento.setImporto(10.0);

        when(contadinoRepository.findById(1L)).thenReturn(Optional.of(contadino));
        when(pagamentoRepository.save(any(Pagamento.class))).thenReturn(pagamento);

        try {
            Pagamento result = gestionePagamentoService.effettuarePagamento(pagamento);

            assertNotNull(result);
            assertEquals(pagamento.getMotivazioni(), result.getMotivazioni());
            assertEquals(pagamento.getImporto(), result.getImporto());
            assertEquals(contadino, result.getContadino());
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
        pagamento.getContadino().setId(2L);

        when(contadinoRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(ContadinoException.class, () -> {
            gestionePagamentoService.effettuarePagamento(pagamento);
        });
    }
}
