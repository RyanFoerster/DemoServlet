package be.technifutur.demoservletjava23.repositories;

import java.sql.Connection;
import java.util.List;

public interface BaseRepository<T> {

    T getById(Integer id);

    List<T> getAll();

    T add(T entity);

    T add(T entity, Connection connection);

    Boolean update(int id, T entity);

    Boolean update(int id, T entity, Connection connection);

    Boolean delete(int id);

    Boolean delete(int id, Connection connection);

    Connection connectDB();

    T getAllInfoById(Integer id);
}
