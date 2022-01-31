package cz.cvut.fit.tjv.dnd_bot.api.dtos;

import com.fasterxml.jackson.annotation.JsonView;
import cz.cvut.fit.tjv.dnd_bot.api.controller.Views;

import javax.swing.text.View;
import java.util.Objects;

public class UserDto {
    public UserDto(){}

    public UserDto(String username, Long userID, String password) {
        this.username = username;
        this.userID = userID;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonView(Views.Overview.class)
    public String username;
    @JsonView(Views.Detailed.class)
    public Long userID;
    @JsonView(Views.Detailed.class)
    public String password;
    //Character list when the user is created will always be null

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(userID, userDto.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID);
    }
}
