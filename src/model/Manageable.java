package model;

public interface Manageable<T> {
    void add(T item);
    void update(int id, T item);
    void delete(int id , T item);
}
