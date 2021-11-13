package Hash;

public interface MyHashMap {
    void add(int key, Integer value);
    void remove(int key);
    int find(int key);
    boolean isEmpty();
    int size();
}
