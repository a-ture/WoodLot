package it.unisa.WoodLot.service.gestioneCarrello;

import it.unisa.WoodLot.model.entity.Albero;
import it.unisa.WoodLot.model.entity.Carrello;
import it.unisa.WoodLot.model.entity.ProdottoCarrello;
import it.unisa.WoodLot.model.entity.Utente;
import it.unisa.WoodLot.model.repository.AlberoRepository;
import it.unisa.WoodLot.model.repository.CarrelloRepository;
import it.unisa.WoodLot.model.repository.ProdottoCarrelloRepository;
import it.unisa.WoodLot.model.repository.UtenteRepository;
import it.unisa.WoodLot.sevice.gestioneCarrello.GestioneCarrelloService;
import it.unisa.WoodLot.sevice.gestioneCarrello.eccezzioni.CarrelloException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Date;

import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Test di unità per la classe GestioneCarrelloService
 *
 * @author Alessia Ture
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CarrelloServiceUT {
    @Mock
    private UtenteRepository utenteRepository;

    @Mock

    private CarrelloRepository carrelloRepository;
    @Mock

    AlberoRepository alberoRepository;
    @Mock
    ProdottoCarrelloRepository prodottoCarrelloRepository;

    @InjectMocks
    private GestioneCarrelloService gestioneCarrelloService;


    /**
     * Testa il caso in cui il recupero del carrello di un utente avviene con successo
     *
     * @result Il test è superato se il carrello viene visualizzato con successo
     */
    @Test
    public void getCarrelloConSuccesso() {
        Long idUtente = 1L;
        Utente utente = new Utente();
        Carrello carrello = new Carrello();
        carrello.setUtente(utente);
        when(utenteRepository.findById(idUtente)).thenReturn(Optional.of(utente));
        when(carrelloRepository.findByUtente_Id(idUtente)).thenReturn(carrello);

        try {
            Carrello result = gestioneCarrelloService.getCarrello(idUtente);
            verify(utenteRepository, times(1)).findById(idUtente);
            verify(carrelloRepository, times(1)).findByUtente_Id(idUtente);
            assertNotNull(result);
            assertEquals(utente, result.getUtente());
        } catch (CarrelloException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Testa il caso in cui il recupero del carrello di un utente avviene con successo
     * (in questo caso il carrello esiste)
     *
     * @result Il test è superato se il carrello viene visualizzato con successo
     */
    @Test
    public void getCarrelloConInsuccesso() {
        String messaggio = "L'idUtente fornito non risulta associato a nessun utente";
        try {
            gestioneCarrelloService.getCarrello(989L);
        } catch (CarrelloException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    @Test
    public void testGetCarrelloCarrelloNotFound() {
        // arrange
        Carrello carrello = new Carrello();

        Long idUtente = 1L;
        Utente utente = new Utente();
        carrello.setUtente(utente);
        
        when(utenteRepository.findById(idUtente)).thenReturn(Optional.of(utente));
        when(carrelloRepository.findByUtente_Id(idUtente)).thenReturn(null);
        when(carrelloRepository.save(carrello)).thenReturn(carrello);
        try {
            Carrello result = gestioneCarrelloService.getCarrello(idUtente);
            // assert
            verify(utenteRepository, times(1)).findById(idUtente);
            verify(carrelloRepository, times(1)).findByUtente_Id(idUtente);
            verify(carrelloRepository, times(1)).save(any(Carrello.class));
            assertNotNull(result);
            assertEquals(utente, result.getUtente());
        } catch (CarrelloException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Testa il caso in cui viene aggiunto un prodotto al carrello con successo
     *
     * @result Il test è superato se il prodotto viene aggiunto con successo
     */
    @Test
    public void aggiungiProdottoCarrelloSuccesso() {
        Carrello carrello = new Carrello();
        Albero albero = new Albero();
        albero.setNome("Acero");

        when(carrelloRepository.findById(1L)).thenReturn(Optional.of(carrello));
        when(alberoRepository.findById("Acero")).thenReturn(Optional.of(albero));
        when(carrelloRepository.save(carrello)).thenReturn(carrello);

        try {
            Carrello result = gestioneCarrelloService.aggiungiProdotto(1L, "Acero");

            assertEquals(1, result.getProdottiCarrello().size());
            assertEquals("Acero", result.getProdottiCarrello().get(0).getAlbero().getNome());
        } catch (CarrelloException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Testa il caso in cui il prodotto da aggiungere al carrello non viene trovato
     *
     * @result Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    public void aggiungiProdottoCarrelloAlberoNull() {
        String messaggio = "L'albero non è stato trovato";
        Albero albero = new Albero();
        albero.setNome("AceroNonEsiste");

        try {
            gestioneCarrelloService.aggiungiProdotto(1L, "AceroNonEsiste");
        } catch (CarrelloException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui il carrello non viene trovato
     *
     * @result Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    public void aggiungiProdottoCarrelloCarrelloNull() {
        String messaggio = "Il carrello non  è stato trovato";
        Albero albero = new Albero();
        albero.setNome("Acero");
        when(alberoRepository.findById("Acero")).thenReturn(Optional.of(albero));
        try {
            gestioneCarrelloService.aggiungiProdotto(1L, "Acero");
        } catch (CarrelloException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui il prodotto che si vuole aggiungere è già presente nel carrello
     *
     * @result Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    public void aggiungiProdottoCarrelloPresente() {
        String messaggio = "Il prodotto è già presente nel carrello";
        Carrello carrello = new Carrello();
        Albero albero = new Albero();
        albero.setNome("Acero");

        when(carrelloRepository.findById(1L)).thenReturn(Optional.of(carrello));
        when(alberoRepository.findById("Acero")).thenReturn(Optional.of(albero));
        when(carrelloRepository.save(carrello)).thenReturn(carrello);
        try {
            gestioneCarrelloService.aggiungiProdotto(1L, "Acero");
            gestioneCarrelloService.aggiungiProdotto(1L, "Acero");
        } catch (CarrelloException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui il carrello viene svuotato con successo
     *
     * @result Il test è superato se il carrello viene svuotato con successo
     */
    @Test
    public void svuotaCarrelloSuccesso() {
        Carrello carrello = new Carrello();
        Utente utente = new Utente();
        carrello.setUtente(utente);
        when(carrelloRepository.findById(1L)).thenReturn(Optional.of(carrello));
        when(carrelloRepository.save(carrello)).thenReturn(carrello);
        try {
            Carrello result = gestioneCarrelloService.svuotareCarrello(1L);
            assertEquals(0, result.getProdottiCarrello().size());
            assertEquals(utente, result.getUtente());
        } catch (CarrelloException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Testa il caso in cui l'id del carrello non è valido
     *
     * @result Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    public void svuotaCarrelloInsuccesso() {
        String messaggio = "Carrello non trovato";
        Carrello carrello = new Carrello();
        Utente utente = new Utente();
        carrello.setUtente(utente);
        when(carrelloRepository.findById(1L)).thenReturn(Optional.empty());
        try {
            gestioneCarrelloService.svuotareCarrello(1L);
        } catch (CarrelloException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui un prodotto viene rimosso con un successo
     *
     * @result Il prodotto viene eliminato
     */
    @Test
    public void testRimuoviProdottoSuccesso() {
        Long idCarrello = 1L;
        Long idProdottoCarrello = 2L;

        Carrello carrello = new Carrello();
        carrello.setId(idCarrello);

        ProdottoCarrello prodottoCarrello = new ProdottoCarrello();

        when(carrelloRepository.findById(idCarrello)).thenReturn(Optional.of(carrello));
        when(prodottoCarrelloRepository.findById(idProdottoCarrello)).thenReturn(Optional.of(prodottoCarrello));

        try {
            Carrello result = gestioneCarrelloService.rimuoviProdotto(idCarrello, idProdottoCarrello);

            verify(carrelloRepository, times(1)).save(carrello);
            verify(prodottoCarrelloRepository, times(1)).deleteById(idProdottoCarrello);
            assertNotNull(result);
        } catch (CarrelloException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Testa il caso in cui l'id del prodotto fornito non è valido
     *
     * @result Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    public void testRimuoviProdottoNull() {
        String messaggio = "L'id del prodotto fornito non è valido";
        Long idCarrello = 1L;
        Long idProdottoCarrello = 2L;

        Carrello carrello = new Carrello();
        carrello.setId(idCarrello);

        when(carrelloRepository.findById(idCarrello)).thenReturn(Optional.of(carrello));
        when(prodottoCarrelloRepository.findById(idProdottoCarrello)).thenReturn(Optional.empty());

        try {
            gestioneCarrelloService.rimuoviProdotto(idCarrello, idProdottoCarrello);
        } catch (CarrelloException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui l'id del carrello fornito non è valido
     *
     * @result Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    public void testRimuoviCarrelloNull() {
        String messaggio = "Il carrello non  è stato trovato";
        Long idCarrello = 1L;
        Long idProdottoCarrello = 2L;

        Carrello carrello = new Carrello();
        carrello.setId(idCarrello);

        when(carrelloRepository.findById(idCarrello)).thenReturn(Optional.empty());


        try {
            gestioneCarrelloService.rimuoviProdotto(idCarrello, idProdottoCarrello);
        } catch (CarrelloException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }
}