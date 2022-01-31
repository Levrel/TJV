package cz.cvut.fit.tjv.dnd_bot.api.controller;

import com.fasterxml.jackson.annotation.JsonView;
import cz.cvut.fit.tjv.dnd_bot.api.converter.UserConverter;
import cz.cvut.fit.tjv.dnd_bot.api.dtos.UserDto;
import cz.cvut.fit.tjv.dnd_bot.business.EntityStateException;
import cz.cvut.fit.tjv.dnd_bot.business.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@RestController
public class UserController {
    public UserController(UserService userService) {
        this.userService = userService;
    }

    private UserService userService;

    @PostMapping("/users")
    public void create(@RequestBody UserDto user){
        try {
            userService.create(UserConverter.fromDto(user), user.getUserID());
        }catch (EntityStateException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/users/{id}")
    public void update(@RequestBody UserDto user, @PathVariable Long id){
        try {
            userService.update(UserConverter.fromDto(user), id);
        }catch (EntityStateException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/users/{id}")
    @JsonView(Views.Detailed.class)
    public UserDto readById(@PathVariable Long id){
        try {
            return UserConverter.toDto(userService.readByID(id).orElseThrow());
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    /*@GetMapping("/users")
    @JsonView(Views.Overview.class)
    public Iterable<UserDto> ReadAll(){
        return userService.readByID();
    }*/

    @DeleteMapping("users/{id}")
    public void deleteById(@PathVariable Long id){
        try {
            userService.deleteByID(id);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}

