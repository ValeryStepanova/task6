package org.example.DAO;

public interface DAO<T> {
    void create(T obj);
    T update(T obj);
    T read(int id);
    T delete(int id);
}
