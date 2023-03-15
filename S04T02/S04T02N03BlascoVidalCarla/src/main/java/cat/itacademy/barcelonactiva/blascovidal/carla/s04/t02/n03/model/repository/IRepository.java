package cat.itacademy.barcelonactiva.blascovidal.carla.s04.t02.n03.model.repository;

import cat.itacademy.barcelonactiva.blascovidal.carla.s04.t02.n03.model.domain.Fruit;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IRepository extends MongoRepository<Fruit, ObjectId> {

    List<Fruit> findByNameContaining(String name);

}

