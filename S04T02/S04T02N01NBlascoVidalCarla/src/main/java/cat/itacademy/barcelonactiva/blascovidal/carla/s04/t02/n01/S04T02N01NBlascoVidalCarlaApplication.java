package cat.itacademy.barcelonactiva.blascovidal.carla.s04.t02.n01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class S04T02N01NBlascoVidalCarlaApplication {

	public static void main(String[] args) {
		SpringApplication.run(S04T02N01NBlascoVidalCarlaApplication.class, args);
	}

}

/*Exercici CRUD amb H2
Tenim una entitat anomenada "Fruita", que disposa de les següents propietats:
    int id
    String nom
    Int quantitatQuilos
Aprofitant l’especificació JPA, hauràs de persistir aquesta entitat a una base de dades H2, seguint el patró MVC.
La classe ubicada al paquet controllers (FruitaController, per exemple), haurà de ser capaç de donar resposta a
les següents peticions per actualitzar i consultar informació:
http://localhost:8080/fruita/add
http://localhost:8080/fruita/update
http://localhost:8080/fruita/delete/{id}
http://localhost:8080/fruita/getOne/{id}
http://localhost:8080/fruita/getAll
Hauràs de tenir en compte les bones pràctiques de disseny de les API, fent servir correctament els codis d'error
i les respostes en cas d'invocacions incorrectes. (Pots consultar informació sobre ResponseEntity).*/
