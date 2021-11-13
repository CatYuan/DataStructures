package Hash;

import java.util.ArrayList;
import java.util.LinkedList;

public class SepChainHashMap implements MyHashMap {
    private ArrayList<LinkedList<HashMapNode>> table;
    private int capacity;
    private int size;
    private double loadFactor;

    public SepChainHashMap(int capacity) {
        this.capacity = capacity;
        size = 0;
        loadFactor = 0.75;
        table = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            table.add(new LinkedList<>());
        }
    }

    @Override
    public void add(int key, Integer value) {
        int index = ((Integer) key).hashCode() % capacity;
        table.get(index).add(new HashMapNode(key, value));
        size++;
        if (size/capacity >= loadFactor) {
            rehash();
        }
    }

    @Override
    public void remove(int key) {
        int index = ((Integer) key).hashCode() % capacity;
        Integer value = null;
        for (HashMapNode node : table.get(index)) {
            if (node.key == key) {
                value = node.value;
                break;
            }
        }
        if (value == null) { return; }
        table.get(index).remove(new HashMapNode(key, value));
        size--;
    }

    @Override
    public int find(int key) {
        int index = ((Integer) key).hashCode() % capacity;
        LinkedList<HashMapNode> currList = table.get(index);
        for (HashMapNode currNode : currList) {
            if (currNode.key == key) {
                return currNode.value;
            }
        }
        return 0;
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
        SepChainHashMap newMap = new SepChainHashMap(capacity * 2);
        for (LinkedList<HashMapNode> list : table) {
            for (HashMapNode node : list) {
                newMap.add(node.key, node.value);
            }
        }
        this.table = newMap.table;
        this.capacity = newMap.capacity;
        this.size = newMap.size;
    }
}
