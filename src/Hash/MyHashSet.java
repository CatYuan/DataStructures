package Hash;

public class MyHashSet {
    MyHashMap map;

    public MyHashSet() {
        map = new LinProbHashMap(3);
    }

    public void add(int key) {
        if (map.find(key) == 0) {
            map.add(key, 1);
        }
    }

    public void remove(int key) {
        map.remove(key);
    }

    public boolean contains(int key) {
        return map.find(key) != 0;
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public int size() {
        return map.size();
    }
}
