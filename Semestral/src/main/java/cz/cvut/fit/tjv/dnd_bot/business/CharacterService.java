package cz.cvut.fit.tjv.dnd_bot.business;

import cz.cvut.fit.tjv.dnd_bot.dao.CharacterJpaRepository;
import org.springframework.stereotype.Component;
import cz.cvut.fit.tjv.dnd_bot.domain.Character;

import javax.transaction.Transactional;

@Component
@Transactional
public class CharacterService extends AbstractCrudService<Long, Character> {
    public CharacterService(CharacterJpaRepository repository){
        super(repository);
    }
}
