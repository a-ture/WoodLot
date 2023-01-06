package it.unisa.WoodLot.model.repository;

import it.unisa.WoodLot.model.entity.Albero;
import it.unisa.WoodLot.model.entity.Categoria;
import it.unisa.WoodLot.model.entity.PaeseOrigine;
import it.unisa.WoodLot.model.entity.UsoLocale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

/**
 * Interfaccia che definisce le operazioni per la modellazione e l'accesso
 * alle informazioni persistenti relative ad un albero
 *
 * @author Alessia Ture
 * @see Albero
 */
public interface AlberoRepository extends JpaRepository<Albero, String> {
    /**
     * Restituisce tutti gli alberi che vengono piantati in dato paese
     *
     * @param paeseOrigine è il paese che permette di effettuare la ricerca
     * @return un set di alberi che vengono piantati nel paese indicato
     */
    Set<Albero> findAllByPaeseOrigine(Optional<PaeseOrigine> paeseOrigine);

    /**
     * Restituisce tutti gli alberi che hanno come uso locale indicato dal parametro
     *
     * @param usoLocale è l'uso locale ricercato
     * @return un set di alberi che hanno l'uso locale indicato
     */
    Set<Albero> findAllByUsiLocali(Optional<UsoLocale> usoLocale);

    /**
     * Restuisce tutti gli alberi che hanno come categoria quello indicata
     *
     * @param categoria la categoria ricercata
     * @return un set degli alberi che hanno come categoria quella indicata
     */
    Set<Albero> findAllByCategoria(Optional<Categoria> categoria);

    /**
     * Restuisce gli alberi del catalogo ordinati per prezzo crescente
     *
     * @return un set contente gli alberi del catalogo ordinati per prezzo crescente
     */
    Set<Albero> findAllByOrderByPrezzoAsc();

    /**
     * Restuisce gli alberi del catalogo ordinati per prezzo decrescente
     *
     * @return un set contente gli alberi del catalogo ordinati per prezzo decrescente
     */
    Set<Albero> findAllByOrderByPrezzoDesc();

    /**
     * Restuisce gli alberi del catalogo ordinati per anidrice carbonica crescente
     *
     * @return un set contente gli alberi del catalogo ordinati per anidrice carbonica crescente
     */
    Set<Albero> findAllByOrderByAnidirdeCarbonicaAssorbitaAsc();

    /**
     * Restuisce gli alberi del catalogo ordinati per anidrice carbonica decrescente
     *
     * @return un set contente gli alberi del catalogo ordinati per anidrice carbonica decrescente
     */
    Set<Albero> findAllByOrderByAnidirdeCarbonicaAssorbitaDesc();
}
