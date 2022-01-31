package cz.cvut.fit.tjv.dnd_bot.api.controller;

import com.fasterxml.jackson.annotation.JsonView;
import cz.cvut.fit.tjv.dnd_bot.api.converter.ItemConverter;
import cz.cvut.fit.tjv.dnd_bot.api.dtos.ItemDto;
import cz.cvut.fit.tjv.dnd_bot.business.EntityStateException;
import cz.cvut.fit.tjv.dnd_bot.business.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@RestController
public class ItemController {
    private ItemService itemService;

    public ItemController( ItemService itemService ){ this.itemService = itemService; }

    @PostMapping("/items")
    public void create(@RequestBody ItemDto item){
        try {
            itemService.create(ItemConverter.fromDto(item), item.getItemID());
        } catch (EntityStateException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/items/{id}")
    public void create(@RequestBody ItemDto item, @PathVariable Long id){
        try {
            itemService.update(ItemConverter.fromDto(item), id);
        }catch ( EntityStateException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    @GetMapping( "/items/{id}" )
    @JsonView(Views.Overview.class)
    public ItemDto readByID(@PathVariable Long id){
        try {
            return ItemConverter.toDto(itemService.readByID(id).orElseThrow());
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/items/{id}")
    public void deleteByID(@PathVariable Long id){
        try{
            itemService.deleteByID(id);
        }catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
