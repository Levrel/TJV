package cz.cvut.fit.tjv.dnd_bot.api.converter;

import cz.cvut.fit.tjv.dnd_bot.api.dtos.ItemDto;
import cz.cvut.fit.tjv.dnd_bot.domain.Item;

public class ItemConverter {
    public static Item fromDto(ItemDto dto){ return new Item(dto.getName(), dto.getAmount(), dto.getPrice() ); }

    public static ItemDto toDto( Item item ){
        ItemDto dto = new ItemDto( item.getItemID() );
        dto.setItemID( item.getItemID() );
        dto.setName( item.getName() );
        dto.setAmount( item.getAmount() );
        dto.setPrice( item.getPrice() );
        return dto;
    }
}
