package cz.cvut.fit.tjv.dnd_bot.domain;

//REST
//CREATE POST /users (without id)
//UPDATE POST /users/{id}
//READ   GET /users/{id}
//DELETE DELETE /users/{id}

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity(name = "user_account")//maps class to database, attributed name prevents conflicts
public class User implements Serializable {
    public User(){}

    public User(String username, String password, Long userID){
        this.userID=userID;
        this.username=username;
        this.password=password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Character> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(List<Character> characterList) {
        this.characterList = characterList;
    }

    public void addCharacter( Character newCharacter ){
        characterList.add( newCharacter );
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    @SequenceGenerator( name = "userSqGen", sequenceName = "userSqGen", initialValue = 1, allocationSize = 1)
    private Long userID;
    private String username;
    private String password;
    @OneToMany( mappedBy = "owner" )
    List<Character> characterList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
