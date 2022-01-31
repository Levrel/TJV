package cz.cvut.fit.tjv.dnd_bot.api.converter;

import cz.cvut.fit.tjv.dnd_bot.api.dtos.UserDto;
import cz.cvut.fit.tjv.dnd_bot.domain.User;

public class UserConverter {
    public static User fromDto(UserDto dto){
        return new User(dto.getUsername(), dto.getPassword(), dto.getUserID());
    }

    public static UserDto toDto(User user){
        UserDto dto = new UserDto();
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setUserID(user.getUserID());
        return dto;
    }
}
