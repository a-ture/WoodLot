package it.unisa.WoodLot.service.gestioneOrdine.checkout;

import it.unisa.WoodLot.model.entity.*;
import it.unisa.WoodLot.model.repository.*;
import it.unisa.WoodLot.sevice.gestioneOrdine.checkout.GestioneCheckoutService;
import it.unisa.WoodLot.sevice.gestioneOrdine.eccezioni.OrdineException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Test di unità per la classe GestioneCheckoutService
 *
 * @author Alessia Ture
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CheckoutServiceUT {

    @Mock
    private OrdineRepository ordineRepository;
    @Mock
    private CarrelloRepository carrelloRepository;
    @Mock
    private ProdottoOrdineRepository prodottoOrdineRepository;
    @Mock
    private ProdottoCarrelloRepository prodottoCarrelloRepository;
    @Mock
    private UtenteRepository utenteRepository;
    @InjectMocks
    private GestioneCheckoutService gestioneCheckoutService;

    /**
     * Testa il caso in cui l'ordine viene effettuato con successo
     * Il test risulta superato se l'ordine viene creato
     */
    @Test
    public void effettuaOrdineSuccesso() {
        Long idUtente = 1L;
        Utente utente = new Utente();
        Carrello carrello = new Carrello();
        Albero albero = new Albero();
        albero.setNome("Avocado");

        List<Beneficio> beneficioList = new ArrayList<>();
        Beneficio beneficio = new Beneficio();
        beneficio.setNome("CO2");
        beneficio.setDescrizione("string");
        beneficioList.add(beneficio);
        albero.setBenefici(beneficioList);

        List<UsoLocale> usoLocaleList = new ArrayList<>();
        UsoLocale usoLocale = new UsoLocale();
        usoLocale.setNome("Medicina");
        usoLocale.setDescrizione("string");
        albero.setUsiLocali(usoLocaleList);

        ProdottoCarrello prodottoCarrello = new ProdottoCarrello();
        prodottoCarrello.setAlbero(albero);
        carrello.aggiungiProdottoCarrello(prodottoCarrello);
        carrello.setUtente(utente);

        Ordine ordine = new Ordine();
        ordine.setDataOrdine(LocalDate.now());
        ordine.setUtente(utente);

        ProdottoOrdine prodottoOrdine = new ProdottoOrdine();
        prodottoOrdine.setAnidrideCarbonicaAssorbita(albero.getAnidrideCarbonicaAssorbita());
        prodottoOrdine.setBenefici(albero.getBenefici());
        prodottoOrdine.setUsiLocali(albero.getUsiLocali());
        prodottoOrdine.setNomeAlbero(albero.getNome());
        prodottoOrdine.setPrezzoUnitario(albero.getPrezzo());
        prodottoOrdine.setStato(ProdottoOrdine.Stato.NonAssegnato);
        ordine.aggiungiProdotto(prodottoOrdine);

        when(utenteRepository.findById(idUtente)).thenReturn(Optional.of(utente));
        when(carrelloRepository.findByUtente_Id(idUtente)).thenReturn(carrello);
        doNothing().when(prodottoCarrelloRepository).deleteById(prodottoCarrello.getId());
        when(carrelloRepository.save(carrello)).thenReturn(carrello);
        when(prodottoOrdineRepository.saveAll(ordine.getProdottiOrdine())).thenReturn(ordine.getProdottiOrdine());
        when(ordineRepository.save(ordine)).thenReturn(ordine);

        try {
            Ordine ordine1 = gestioneCheckoutService.effettuareOrdine(idUtente);
            assertNotNull(ordine1);
            assertEquals(ordine1, ordine);
            assertEquals(1, ordine.getProdottiOrdine().size());
            assertEquals(albero.getAnidrideCarbonicaAssorbita(), prodottoOrdine.getAnidrideCarbonicaAssorbita());
            assertEquals(albero.getBenefici(), prodottoOrdine.getBenefici());
            assertEquals(albero.getUsiLocali(), prodottoOrdine.getUsiLocali());
            assertEquals(albero.getNome(), prodottoOrdine.getNomeAlbero());
            assertEquals(albero.getPrezzo(), prodottoOrdine.getPrezzoUnitario());
            assertEquals(ProdottoOrdine.Stato.NonAssegnato, prodottoOrdine.getStato());

            verify(utenteRepository, times(1)).findById(idUtente);
            verify(carrelloRepository, times(1)).findByUtente_Id(idUtente);
            verify(ordineRepository, times(1)).save(ordine);
            verify(prodottoCarrelloRepository, times(1)).deleteById(prodottoCarrello.getId());
            verify(prodottoOrdineRepository, times(1)).saveAll(ordine.getProdottiOrdine());
        } catch (OrdineException e) {
            fail(e.getMessage());
        }

    }

    /**
     * Testa il caso in cui l'id dell utente non corrisponde a nessun utente
     * <p>
     * Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    void effettuareOrdineUtenteNullo() {
        Long idUtente = 123L;
        String messaggio = "L'utente non è stato trovato";
        when(utenteRepository.findById(idUtente)).thenReturn(Optional.empty());
        try {
            gestioneCheckoutService.effettuareOrdine(idUtente);
        } catch (OrdineException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui l'id dell carrello non corrisponde a nessun carrello
     * <p>
     * Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    void effettuareOrdineCarrelloNullo() {
        String messaggio = "Il tuo carrello è nullo";
        Long idUtente = 123L;
        Utente utente = new Utente();
        when(utenteRepository.findById(idUtente)).thenReturn(Optional.of(utente));
        when(carrelloRepository.findByUtente_Id(idUtente)).thenReturn(null);
        try {
            gestioneCheckoutService.effettuareOrdine(idUtente);
        } catch (OrdineException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui il carrello è vuoto
     * <p>
     * Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    void carrelloVuoto() {
        String messaggio = "Il tuo carrello è vuoto! Aggiungi degli alberi prima di continuare";
        Long idUtente = 123L;
        Utente utente = new Utente();
        Carrello carrello = new Carrello();
        when(utenteRepository.findById(idUtente)).thenReturn(Optional.of(utente));
        when(carrelloRepository.findByUtente_Id(idUtente)).thenReturn(carrello);
        try {
            gestioneCheckoutService.effettuareOrdine(idUtente);
        } catch (OrdineException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }
}
