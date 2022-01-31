package cz.cvut.fit.tjv.dnd_bot.dao;

import cz.cvut.fit.tjv.dnd_bot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {

}
