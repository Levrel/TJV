package cz.cvut.fit.tjv.dnd_bot.dao;

import cz.cvut.fit.tjv.dnd_bot.domain.Character;
import cz.cvut.fit.tjv.dnd_bot.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CharacterJpaRepository extends JpaRepository<Character, Long> {
    /*@Query( "SELECT ch.itemList FROM Character ch WHERE :item MEMBER ch.itemList" )
    List<Item> findAllOwnedItems( Item item );*/
}
