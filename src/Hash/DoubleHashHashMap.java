package Hash;

public class DoubleHashHashMap extends LinProbHashMap implements MyHashMap{

    public DoubleHashHashMap(int capacity) {
        super(capacity);
    }

    @Override
    public void add(int key, Integer value) {
        int index = ((Integer) key).hashCode() % capacity;
        int hash2 = key;
        while (table[index] != null) {
            index = (index + hash2) % capacity;
        }
        table[index] = new HashMapNode(key, value);
        size++;
        if (size / capacity >= loadFactor) { rehash(); }
    }

    @Override
    public void remove(int key) {
        int index = ((Integer) key).hashCode() % capacity;
        int hash2 = key;
        while (table[index] != null && table[index].key != key) {
            index = (index + hash2) % capacity;
        }
        if (table[index] != null) {
            size--;
        }
        table[index] = null;
    }

    @Override
    public int find(int key) {
        int index = ((Integer)key).hashCode() % capacity;
        int hash2 = key;
        while (table[index] != null && table[index].key != key) {
            index = (index + hash2) % capacity;
        }
        return table[index]==null ? 0 : table[index].value;
    }

    private void rehash() {
        DoubleHashHashMap newMap = new DoubleHashHashMap(capacity*2);
        for (HashMapNode node : table) {
            newMap.add(node.key, node.value);
        }
        this.table = newMap.table;
        this.size = newMap.size;
        this.capacity = newMap.capacity;
    }
}
