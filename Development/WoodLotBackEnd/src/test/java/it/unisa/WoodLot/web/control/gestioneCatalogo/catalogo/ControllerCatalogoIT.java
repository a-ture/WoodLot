package it.unisa.WoodLot.web.control.gestioneCatalogo.catalogo;

import it.unisa.WoodLot.model.entity.*;
import it.unisa.WoodLot.model.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test d'integrazione per la classe ControllerCatalogo
 *
 * @author Alessia Ture
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerCatalogoIT {

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private PaeseOrigineRepository paeseOrigineRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private UsoLocaleRepository usoLocaleRepository;
    @Autowired
    private BeneficioRepository beneficioRepository;
    @Autowired
    private AlberoRepository alberoRepository;
    private Albero albero;

    @BeforeEach
    void setUp() {
        PaeseOrigine paeseOrigine = new PaeseOrigine();
        paeseOrigine.setNome("Paese 1");
        paeseOrigine.setDescrizione("string");
        paeseOrigineRepository.save(paeseOrigine);

        Categoria categoria = new Categoria();
        categoria.setNome("Categoria 1");
        categoria.setDescrizione("string");
        categoriaRepository.save(categoria);

        UsoLocale usoLocale = new UsoLocale();
        usoLocale.setNome("Uso locale 1");
        usoLocale.setDescrizione("string");
        usoLocaleRepository.save(usoLocale);

        Beneficio beneficio = new Beneficio();
        beneficio.setNome("Beneficio");
        beneficio.setDescrizione("string");
        beneficioRepository.save(beneficio);

        albero = new Albero();
        albero.setNome("Albero di Natale");
        albero.setPrezzo(56);
        albero.setSalvaguardia(3);
        albero.setDescrizione("String string");
        albero.setDescrizioneBreve("string");
        albero.setPaeseOrigine(paeseOrigine);
        albero.setCategoria(categoria);
        albero.setAnidrideCarbonicaAssorbita(78);
        albero.setSpecieScientifica("Specie");
        albero.setUsiLocali(Arrays.asList(usoLocale));
        albero.setBenefici(Arrays.asList(beneficio));
    }

    /**
     * Testa il caso in cui l'albero viene aggiunto con successo al catalogo
     * <p>
     * Il test risulta superato se il prodotto viene aggiunto con successo al catalogo
     */
    @Test
    void testInserimentoCatalogoSuccesso() {
        albero.setNome("Test");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Albero> request = new HttpEntity<>(albero, headers);
        ResponseEntity<Albero> response = restTemplate.postForEntity("http://localhost:8090/api/catalogo/inserimentoProdotto", request, Albero.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(albero.getNome(), response.getBody().getNome());
        assertEquals(albero.getDescrizione(), response.getBody().getDescrizione());
        assertEquals(albero.getPrezzo(), response.getBody().getPrezzo(), 0.001);
        assertEquals(albero.getBenefici(), response.getBody().getBenefici());
        assertEquals(albero.getCategoria(), response.getBody().getCategoria());
        assertEquals(albero.getUsiLocali(), response.getBody().getUsiLocali());
        assertEquals(albero.getPaeseOrigine(), response.getBody().getPaeseOrigine());
    }

    /**
     * Testa il caso in cui si vuole aggiungere un albero al catalogo ma si verifica un eccezione
     * <p>
     * Il test è superato se la risposta HTTP generata dal sistema è uguale a quella
     * *previsto dall'oracolo.
     */
    @Test
    void testInserimentoCatalogoInsuccesso() {
        albero = alberoRepository.save(albero);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Albero> request = new HttpEntity<>(albero, headers);
        ResponseEntity<Albero> response = restTemplate.postForEntity("http://localhost:8090/api/catalogo/inserimentoProdotto", request, Albero.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    /**
     * Testa il caso in cui il prodotto viene eliminato correttamente
     * Il test risulta superato se il prodotto viene eliminato correttamente
     */
    @Test
    void testEliminaProdottoCatalogo() {
        albero = alberoRepository.save(albero);

        ResponseEntity<Void> deleteResponse = restTemplate.exchange("http://localhost:8090/api/catalogo/eliminaProdotto/" + albero.getNome(), HttpMethod.GET, null, Void.class);
        assertEquals(HttpStatus.OK, deleteResponse.getStatusCode());
    }

    /**
     * Testa il caso in cui viene caricata un img correttamente
     * Il test risulta superato se l'img viene caricata
     */
    @Test
    void testUploadImage() {
        // Create a mock file
        byte[] content = "test file content".getBytes();
        MockMultipartFile file = new MockMultipartFile("file", "test.jpg", "image/jpeg", content);
        String treeName = "test-tree";

        Resource resource = new ByteArrayResource(content) {
            @Override
            public String getFilename() {
                return "test.jpg";
            }
        };

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", resource);
        body.add("treeName", treeName);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<Object> responseEntity = restTemplate.exchange("http://localhost:8090/api/catalogo/upload", HttpMethod.POST, requestEntity, Object.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}
