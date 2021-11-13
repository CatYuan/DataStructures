package Hash;

public class LinProbHashMap implements MyHashMap{
    HashMapNode[] table;
    int capacity;
    int size;
    double loadFactor;

    public LinProbHashMap(int capacity) {
        this.capacity = capacity;
        table = new HashMapNode[capacity];
        size = 0;
        loadFactor = 0.75;
        for (int i = 0; i < capacity; i++) {
            table[i] = null;
        }
    }

    @Override
    public void add(int key, Integer value) {
        int index = ((Integer) key).hashCode() % capacity;
        while (table[index] != null) {
            index = (index + 1) % capacity;
        }
        table[index] = new HashMapNode(key, value);
        size++;
        if (size/capacity >= loadFactor) {
            rehash();
        }
    }

    @Override
    public void remove(int key) {
        int index = ((Integer) key).hashCode() % capacity;
        while (table[index] != null && table[index].key!=key) {
            index = (index + 1) % capacity;
        }
        if (table[index] == null) { return; }
        table[index] = null;
        size--;
    }

    @Override
    public int find(int key) {
        int index = ((Integer) key).hashCode() % capacity;
        while (table[index] != null && table[index].key!=key) {
            index = (index + 1) % capacity;
        }
        if (table[index] == null) { return 0; }
        return table[index].value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void rehash() {
        LinProbHashMap newMap = new LinProbHashMap(capacity*2);
        for (HashMapNode node : table) {
            newMap.add(node.key, node.value);
        }
        this.table = newMap.table;
        this.size = newMap.size;
        this.capacity = newMap.capacity;
    }
}
