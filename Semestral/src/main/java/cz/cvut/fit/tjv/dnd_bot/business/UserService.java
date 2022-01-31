package cz.cvut.fit.tjv.dnd_bot.business;

import cz.cvut.fit.tjv.dnd_bot.dao.UserJpaRepository;
import cz.cvut.fit.tjv.dnd_bot.domain.User;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class UserService extends AbstractCrudService<Long, User>{
    public UserService(UserJpaRepository repository) {
        super(repository);
    }
}
