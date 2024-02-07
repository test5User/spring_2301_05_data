package by.itclass._02_jpa.repositories;

import by.itclass._02_jpa.entities.Airplane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirplaneRepository extends CrudRepository<Airplane, Integer> {
    //find, get, query, delete, update, exist (start word)
    //By    (where)
    //Model (where condition)
    Airplane findByModel(String model);
    Airplane findByModelAndPlace(String model, int place);
    Airplane findByModelLike(String model);
    List<Airplane> findByPlaceBetween(int start, int end);

}
