package it.unisa.WoodLot.service.gestioneOrdine.ordini;

import it.unisa.WoodLot.model.entity.Ordine;
import it.unisa.WoodLot.model.entity.Utente;
import it.unisa.WoodLot.model.repository.OrdineRepository;
import it.unisa.WoodLot.model.repository.UtenteRepository;
import it.unisa.WoodLot.sevice.gestioneOrdine.ordini.GestioneOrdineService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test d'integrazione fra la classe GestioneOrdineService e la repository.
 *
 * @author Alessia Ture
 */
@SpringBootTest
@Transactional
@Rollback
@ExtendWith(SpringExtension.class)
public class OrdineServiceIT {

    @Autowired
    private OrdineRepository ordineRepository;
    @Autowired
    private GestioneOrdineService gestioneOrdineService;
    @Autowired
    private UtenteRepository utenteRepository;
    private Utente utente;
    private Ordine ordine1;
    private Ordine ordine2;
    private List<Ordine> ordini;

    @BeforeEach
    void setUp() {
        utente = new Utente();
        utente.setNome("John");
        utente.setCognome("Doe");
        utente.setDataDiNascita(new Date(2001 - 02 - 23));
        utente.setEmail("john.doe@example.com");
        utente.setPassword("password");
        utente = utenteRepository.save(utente);

        ordine1 = new Ordine();
        ordine1.setDataOrdine(LocalDate.from(LocalDateTime.now()));
        ordine1.setUtente(utente);
        ordine1.setId(56L);
        ordine1 = ordineRepository.save(ordine1);

        ordine2 = new Ordine();
        ordine2.setDataOrdine(LocalDate.from(LocalDateTime.now()));
        ordine2.setUtente(utente);
        ordine2.setId(57L);
        ordine2 = ordineRepository.save(ordine2);

        ordini = new ArrayList<>();
        ordini.add(ordine1);
        ordini.add(ordine2);
    }

    /**
     * Testa il caso in cui vengono visualizzati tutti gli ordini
     * Il test risulta superato se tutti gli ordini vengono visualizzati con successo
     */
    @Test
    public void testRestituisciOrdini() {
        Iterable<Ordine> risultato = gestioneOrdineService.restituisciOrdini();
        List<Ordine> ordini = ordineRepository.findAll();
        assertNotNull(risultato);
        assertEquals(ordini, risultato);
    }

    /**
     * Testa il caso in cui viene visualizzato lo storico degli ordini di un utente
     * Il test risulta superato se tutti gli ordini vengono visualizzati con successo
     */
    @Test
    public void testVisualizzaOrdiniUtente() {
        List<Ordine> ordiniUtente = gestioneOrdineService.visualizzaOrdiniUtente(utente.getId());
        assertEquals(2, ordiniUtente.size());
        assertEquals(ordine1, ordiniUtente.get(0));
        assertEquals(ordine2, ordiniUtente.get(1));
    }
}
