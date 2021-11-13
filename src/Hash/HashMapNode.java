package Hash;

public class HashMapNode {
    int key;
    Integer value;

    public HashMapNode(int key, Integer value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) { return true; }
        if (!(o instanceof HashMapNode)) { return false; }
        HashMapNode other = (HashMapNode) o;
        return other.key==this.key && other.value.equals(this.value);
    }
}
