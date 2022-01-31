package cz.cvut.fit.tjv.dnd_bot.business;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public abstract class AbstractCrudService<K, E> {
    protected final JpaRepository<E, K> repository;

    protected AbstractCrudService(JpaRepository<E, K> repository) {
        this.repository = repository;
    }

    public void create(E entity, K key) throws EntityStateException {
        if( !repository.existsById(key) )
            repository.save(entity);
        else
            throw new EntityStateException(entity);
    }

    public void update(E entity, K key) throws EntityStateException {
        if( repository.existsById(key) )
            repository.save(entity);
        else
            throw new EntityStateException(entity);
    }

    public void deleteByID(K key){
        repository.deleteById(key);
    }

    public Optional<E> readByID( K key ){
        return repository.findById(key);
    }
}
