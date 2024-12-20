package it.unisa.WoodLot.sevice.gestioneCatalogo.catalogo;

import it.unisa.WoodLot.model.entity.*;
import it.unisa.WoodLot.model.repository.*;
import it.unisa.WoodLot.sevice.gestioneCatalogo.eccezioni.AlberoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * La classe fornisce i metodi per la logica di business della gestione del catalogo
 *
 * @author Alessia Ture
 */
@Service
public class GestioneCatalogoService implements CatalogoService {

    @Autowired
    private AlberoRepository alberoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private UsoLocaleRepository usoLocaleRepository;

    @Autowired
    private BeneficioRepository beneficioRepository;

    @Autowired
    private PaeseOrigineRepository paeseOrigineRepository;

    /**
     * Permette di aggiungere un prodotto nel catalogo
     *
     * @param albero è il prodotto da inserire
     * @return albero il prodotto inserito nel database.
     */
    @Override
    public Albero aggiungiProdotto(Albero albero) throws AlberoException {
        if (alberoRepository.existsById(albero.getNome().toLowerCase()))
            throw new AlberoException("Questo nome è già presente nel catalogo! Scegline un altro");

        Categoria categoria = categoriaRepository.findById(albero.getCategoria().getNome()).orElse(null);

        if (categoria == null)
            throw new AlberoException("La categoria fornita non è valida");

        ArrayList<UsoLocale> usiLocali = new ArrayList<>();
        for (UsoLocale u : albero.getUsiLocali()) {
            u = usoLocaleRepository.findById(u.getNome()).orElse(null);
            if (u == null)
                throw new AlberoException("L'uso locale fornito non è valido");
            usiLocali.add(u);
        }

        ArrayList<Beneficio> benefici = new ArrayList<>();
        for (Beneficio b : albero.getBenefici()) {
            b = beneficioRepository.findById(b.getNome()).orElse(null);
            if (b == null)
                throw new AlberoException("Il beneficio fornito non è valido");
            benefici.add(b);
        }

        PaeseOrigine p = paeseOrigineRepository.findById(albero.getPaeseOrigine().getNome()).orElse(null);
        if (p == null)
            throw new AlberoException("Il paese fornito non è valido");

        albero.setBenefici(benefici);
        albero.setUsiLocali(usiLocali);
        albero.setCategoria(categoria);

        return alberoRepository.save(albero);
    }

    /**
     * Permette di eliminare un albero dal catalogo
     *
     * @param idAlbero l'id dell'albero da eliminare
     */
    @Override
    public void eliminaProdotto(String idAlbero) throws AlberoException {
        Albero albero = alberoRepository.findById(idAlbero).orElse(null);
        if (albero == null)
            throw new AlberoException("L'id fornito non è associato a nessun albero");
        alberoRepository.deleteById(idAlbero);
    }
}
