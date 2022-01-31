package cz.cvut.fit.tjv.dnd_bot.business;

import cz.cvut.fit.tjv.dnd_bot.dao.ItemJpaRepository;
import cz.cvut.fit.tjv.dnd_bot.domain.Item;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class ItemService extends AbstractCrudService<Long, Item> {
    public ItemService(ItemJpaRepository repository){
        super(repository);
    }
}
