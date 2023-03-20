package cat.itacademy.barcelonactiva.blascovidal.carla.s04.t02.n02.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Fruit")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "kilosQuantity")
    private int kilosQuantity;

    protected Fruit() {
    }

    public Fruit(String name, int kilosQuantity) {
        this.name = name;
        this.kilosQuantity = kilosQuantity;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKilosQuantity() {
        return kilosQuantity;
    }

    public void setKilosQuantity(int kilosQuantity) {
        this.kilosQuantity = kilosQuantity;
    }

    @Override
    public String toString() {
        return "Fruit [id=" + id + ", name=" + this.name + ", quantity=" + this.kilosQuantity + "kg ]";
    }
}
