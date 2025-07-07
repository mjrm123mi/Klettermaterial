package de.klettermaterial.seil;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeilRepository extends CrudRepository<Seil, Long> {

}
