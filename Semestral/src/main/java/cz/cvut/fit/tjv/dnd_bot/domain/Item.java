package cz.cvut.fit.tjv.dnd_bot.domain;

//REST
//CREATE    POST /items
//READ      GET/items/{id}
//UPDATE    PUT /items/{id}
//DELETE    DELETE /items/{id}

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity( name = "game_item" )
public class Item implements Serializable {
    public Item(){}

    public Item(String name, int numOfItems, int price) {
        this.name = name;
        this.amount = numOfItems;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if( amount > 0 )
            this.amount = amount;
        else
            this.amount = 0;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getItemID() {
        return itemID;
    }

    public void setItemID(Long ID) {
        this.itemID = ID;
    }

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    @SequenceGenerator( name = "itemSqGen", sequenceName = "itemSqGen", initialValue = 1, allocationSize = 1)
    private Long itemID;
    private String name;
    private int amount;
    private int price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return itemID == item.itemID && price == item.price && name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemID, name, price);
    }
}