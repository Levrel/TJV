package cz.cvut.fit.tjv.dnd_bot.business;

public class EntityStateException extends Exception {
    public <E> EntityStateException (E entity) { super("Ilegal state of entity" + entity); }
}
