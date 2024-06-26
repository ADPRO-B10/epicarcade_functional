package adpro.b10.epicarcade_functional.Review.Model;

import jakarta.persistence.*;
import lombok.Getter;
@Getter
@Entity
@Table(name = "game")
public class Game {

    @Id
    @Column(name = "id_game", nullable = false, unique = true)
    private String id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description", nullable = false, unique = true)
    private String description;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "stock", nullable = false)
    private int stock;

    public Game(){
    }

    public Game(String id, String name, String description, int price, int stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public String setId(String id){
        return
                this.id = id;
    }

    public void setDescription(String description) {
        if(description == null){
            throw new IllegalArgumentException("Game description cannot be empty");
        }
        this.description = description;
    }
    public void setName(String name) {
        if(name == null){
            throw new IllegalArgumentException("Game name cannot be empty");
        }
        this.name = name;
    }

    public void setPrice(int price) {
        if(price == 0){
            throw new IllegalArgumentException("Game price cannot be free");
        }
        this.price = price;
    }

    public void setStock(int stock) {
        if(stock == 0){
            throw new IllegalArgumentException("Game price cannot be free");
        }
        this.stock = stock;
    }
}