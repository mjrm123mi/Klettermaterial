package de.klettermaterial.seil.repository;

import de.klettermaterial.seil.material.Seil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * SeilRepository ist ein Interface für den Zugriff auf Seil Entitäten in der Datenbank.
 * Es erbt vom CrudRepository und enthält somit die CRUD-Operationen sowie weitere
 * Standartmethoden.
 */
@Repository
public interface SeilRepository extends JpaRepository<Seil, Long> {

    void deleteByName(String name);

    List<Seil> findAllByOrderByAblaufdatum();

}
