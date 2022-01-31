package cz.cvut.fit.tjv.dnd_bot.api.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import cz.cvut.fit.tjv.dnd_bot.api.controller.Views;
import cz.cvut.fit.tjv.dnd_bot.domain.Item;
import cz.cvut.fit.tjv.dnd_bot.domain.User;

import java.util.List;
import java.util.Objects;

public class CharacterDto {
    public CharacterDto(){}

    public CharacterDto(Long characterID ){ this.characterID = characterID; }

    public Long getCharacterID() {
        return characterID;
    }

    public void setCharacterID(Long characterID) {
        this.characterID = characterID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @JsonView(Views.Detailed.class)
    private Long characterID;
    @JsonView(Views.Overview.class)
    private String name;
    @JsonView(Views.Overview.class)
    private String nickname;
    @JsonView(Views.Overview.class)
    private int level;
    @JsonView(Views.Overview.class)
    private User owner;
    @JsonView(Views.Overview.class)
    List<Item> itemList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterDto that = (CharacterDto) o;
        return characterID.equals(that.characterID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterID);
    }


}
