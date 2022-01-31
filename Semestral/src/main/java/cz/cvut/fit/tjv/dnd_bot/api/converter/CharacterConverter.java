package cz.cvut.fit.tjv.dnd_bot.api.converter;

import cz.cvut.fit.tjv.dnd_bot.api.dtos.CharacterDto;
import cz.cvut.fit.tjv.dnd_bot.domain.Character;

public class CharacterConverter {
    public static Character fromDto(CharacterDto dto){
        return new Character( dto.getName(), dto.getNickname(), dto.getLevel(), dto.getCharacterID() );
    }

    public static CharacterDto toDto(Character character){
        CharacterDto dto = new CharacterDto( character.getID() );
        dto.setCharacterID( character.getID() );
        dto.setLevel( character.getLevel() );
        dto.setNickname( character.getNickname() );
        dto.setName( character.getName() );
        dto.setOwner( character.getOwner() );
        return dto;
    }
}
