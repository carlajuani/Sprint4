package cat.itacademy.barcelonactiva.blascovidal.carla.s04.t02.n01.controllers;

/*La classe ubicada al paquet controllers (FruitaController, per exemple), haurà de ser capaç de donar resposta a
les següents peticions per actualitzar i consultar informació:
http://localhost:8080/fruites/add
http://localhost:8080/fruites/update
http://localhost:8080/fruites/delete/{id}
http://localhost:8080/fruites/getOne/{id}
http://localhost:8080/fruites/getAll*/

import cat.itacademy.barcelonactiva.blascovidal.carla.s04.t02.n01.model.domain.Fruit;
import cat.itacademy.barcelonactiva.blascovidal.carla.s04.t02.n01.model.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController

public class FruitController {
    @Autowired
    IRepository repository;

    @PostMapping("/fruits/add")
    public ResponseEntity<Fruit> createFruit(@RequestBody Fruit fruit) {
        try {
            Fruit _fruit = repository
                    .save(new Fruit(fruit.getName(), fruit.getKilosQuantity()));
            return new ResponseEntity<>(_fruit, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/fruits/update/{id}")
    public ResponseEntity<Fruit> updateFruit(@PathVariable("id") int id, @RequestBody Fruit fruit) {
        Optional<Fruit> fruitData = repository.findById(id);

        if (fruitData.isPresent()) {
            Fruit _fruit= fruitData.get();
            _fruit.setName(fruit.getName());
            _fruit.setKilosQuantity(fruit.getKilosQuantity());
            return new ResponseEntity<>(repository.save(_fruit), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/fruits/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFruit(@PathVariable("id") int id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/fruits/getOne/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable("id") int id) {
        Optional<Fruit> fruitData = repository.findById(id);

        if (fruitData.isPresent()) {
            return new ResponseEntity<>(fruitData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/fruits/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits(@RequestParam(required = false) String name) {
        try {
            List<Fruit> fruits;
            if (name == null) {
                fruits = repository.findAll();
            } else {
                fruits = repository.findByNameContaining(name);
            }
            if (fruits.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(fruits, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
