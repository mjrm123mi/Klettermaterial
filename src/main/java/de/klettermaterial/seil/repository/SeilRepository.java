package de.klettermaterial.seil.repository;

import de.klettermaterial.seil.material.Seil;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * SeilRepository ist ein Interface für den Zugriff auf Seil Entitäten in der Datenbank.
 * Es erbt vom CrudRepository und enthält somit die CRUD-Operationen sowie weitere
 * Standartmethoden.
 */
@Repository
public interface SeilRepository extends CrudRepository<Seil, Long> {


    //TODO: Liste statt Iterable returnen

    void deleteByName(String name);
// deleteByName() Methode


    /* Methoden:

       <S extends T> S save(S entity);

    <S extends T> java.lang.Iterable<S> saveAll(java.lang.Iterable<S> entities);

    java.util.Optional<T> findById(ID id);

    boolean existsById(ID id);

    java.lang.Iterable<T> findAll();

    java.lang.Iterable<T> findAllById(java.lang.Iterable<ID> ids);

    long count();

    void deleteById(ID id);

    void delete(T entity);

    void deleteAllById(java.lang.Iterable<? extends ID> ids);

    void deleteAll(java.lang.Iterable<? extends T> entities);

    void deleteAll();
     */
}
