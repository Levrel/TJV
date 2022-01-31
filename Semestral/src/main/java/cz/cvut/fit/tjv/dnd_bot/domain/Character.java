package cz.cvut.fit.tjv.dnd_bot.domain;

//REST
//CREATE    POST /characters
//READ      GET /characters/{id}
//UPDATE    PUT /characters/{id}
//DELETE    DELETE /characters/{id}
//add item POST /characters/{id}/items

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity( name = "player_character" )
public class Character implements Serializable {
    //Enter character data, such as name or stats
    public Character(){}

    public Character( String name, String nickname, int level, Long characterID ){
        this.characterID=characterID;
        this.name=name;
        this.nickname=nickname;
        this.level=level;
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

    public Long getID() {
        return characterID;
    }

    public void setID(Long ID) {
        this.characterID = ID;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void addItem( Item newItem ){
        itemList.add( newItem );
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    @SequenceGenerator( name = "characterSqGen", sequenceName = "characterSqGen", initialValue = 1, allocationSize = 1)
    private Long characterID;
    private String name;
    private String nickname;
    private int level;
    @ManyToOne
    private User owner;
    @ManyToMany
    @JoinTable(
            name = "character_owned_items",
            joinColumns = @JoinColumn( name = "characterID" ),
            inverseJoinColumns = @JoinColumn( name = "itemID" )
    )
    List<Item> itemList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return characterID == character.characterID && Objects.equals(name, character.name) && Objects.equals(nickname, character.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterID, name, nickname);
    }


}
