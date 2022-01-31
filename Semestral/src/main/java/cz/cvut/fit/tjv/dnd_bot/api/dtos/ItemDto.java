package cz.cvut.fit.tjv.dnd_bot.api.dtos;

import com.fasterxml.jackson.annotation.JsonView;
import cz.cvut.fit.tjv.dnd_bot.api.controller.Views;

import java.util.Objects;

public class ItemDto {
    public ItemDto(){}

    public ItemDto( Long itemID ){ this.itemID = itemID; }

    public Long getItemID() {
        return itemID;
    }

    public void setItemID(Long itemID) {
        this.itemID = itemID;
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
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @JsonView(Views.Detailed.class)
    public Long itemID;
    @JsonView(Views.Overview.class)
    public String name;
    @JsonView(Views.Overview.class)
    public int amount;
    @JsonView(Views.Overview.class)
    public int price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDto itemDto = (ItemDto) o;
        return itemID.equals(itemDto.itemID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemID);
    }
}
