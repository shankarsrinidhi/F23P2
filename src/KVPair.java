public class KVPair<K extends Comparable<K>> {
    K key;
    Object value; // Value type is kept as Object to allow any type
    private int id;

    public KVPair(K key, Object value) {
        this.key = key;
        this.value = value;
        this.id = id;
    }

    public K getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public int compareTo(K otherKey) {
        return key.compareTo(otherKey);
    }
    public int getId() {
        return id;
    }
}
