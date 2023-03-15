package cat.itacademy.barcelonactiva.blascovidal.carla.s04.t02.n03.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "Fruit")
public class Fruit {

    private ObjectId id;
    private String name;
    private int kilosQuantity;

    public Fruit(String name, int kilosQuantity) {
        this.name = name;
        this.kilosQuantity = kilosQuantity;
    }

}
