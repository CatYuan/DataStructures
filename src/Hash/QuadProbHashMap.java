package Hash;

public class QuadProbHashMap extends LinProbHashMap implements MyHashMap{

    public QuadProbHashMap(int capacity) {
        super(capacity);
    }

    @Override
    public void add(int key, Integer value) {
        int index = ((Integer) key).hashCode() % capacity;
        int h = 1;
        while (table[index] != null) {
            index = (index + h*h) % capacity;
            h++;
        }
        table[index] = new HashMapNode(key, value);
        size++;
        if (size / capacity >= loadFactor) { rehash(); }
    }

    @Override
    public void remove(int key) {
        int index = ((Integer) key).hashCode() % capacity;
        int h = 1;
        while (table[index] != null && table[index].key != key) {
            index = (index + h*h) % capacity;
            h++;
        }
        if (table[index] != null) {
            size--;
        }
        table[index] = null;
    }

    @Override
    public int find(int key) {
        int index = ((Integer)key).hashCode() % capacity;
        int h = 1;
        while (table[index] != null && table[index].key != key) {
            index = (index + h*h) % capacity;
            h++;
        }
        return table[index]==null ? 0 : table[index].value;
    }

    private void rehash() {
        QuadProbHashMap newMap = new QuadProbHashMap(capacity * 2);
        for (HashMapNode node : table) {
            newMap.add(node.key, node.value);
        }
        this.table = newMap.table;
        this.size = newMap.size;
        this.capacity = newMap.capacity;
    }
}
