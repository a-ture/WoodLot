package it.unisa.WoodLot.service.gestioneContadino.pagamento;

import it.unisa.WoodLot.model.entity.Pagamento;
import it.unisa.WoodLot.model.repository.PagamentoRepository;
import it.unisa.WoodLot.sevice.gestioneContadino.pagamento.GestionePagamentoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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
}


