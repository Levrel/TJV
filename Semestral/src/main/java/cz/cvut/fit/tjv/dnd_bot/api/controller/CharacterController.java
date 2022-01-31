package cz.cvut.fit.tjv.dnd_bot.api.controller;

import com.fasterxml.jackson.annotation.JsonView;
import cz.cvut.fit.tjv.dnd_bot.api.converter.CharacterConverter;
import cz.cvut.fit.tjv.dnd_bot.api.dtos.CharacterDto;
import cz.cvut.fit.tjv.dnd_bot.business.CharacterService;
import cz.cvut.fit.tjv.dnd_bot.business.EntityStateException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@RestController
public class CharacterController {
    public CharacterController(CharacterService characterService){ this.characterService = characterService; }

    private CharacterService characterService;

    @PostMapping( "/characters" )
    public void create(@RequestBody CharacterDto character){
        try{
            characterService.create(CharacterConverter.fromDto(character), character.getCharacterID());
        } catch (EntityStateException e) {
            throw new ResponseStatusException( HttpStatus.CONFLICT );
        }
    }

    @PostMapping( "/characters/{id}" )
    public void update(@RequestBody CharacterDto character, @PathVariable Long id){
        try {
            characterService.update(CharacterConverter.fromDto(character), id);
        }catch (EntityStateException e){
            throw new ResponseStatusException( HttpStatus.NOT_FOUND );
        }
    }

    @GetMapping("/characters/{id}")
    @JsonView(Views.Overview.class)
    public CharacterDto findByID(@PathVariable Long id){
        try{
            return CharacterConverter.toDto(characterService.readByID(id).orElseThrow());
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping( "/characters/{id}" )
    public void deleteByID(@PathVariable Long id){
        try {
            characterService.deleteByID(id);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
