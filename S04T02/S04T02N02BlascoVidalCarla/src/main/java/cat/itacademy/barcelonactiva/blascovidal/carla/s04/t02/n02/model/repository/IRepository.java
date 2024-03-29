package cat.itacademy.barcelonactiva.blascovidal.carla.s04.t02.n02.model.repository;

import cat.itacademy.barcelonactiva.blascovidal.carla.s04.t02.n02.model.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRepository extends JpaRepository<Fruit, Integer> {

    List<Fruit> findByNameContaining(String name);

}
