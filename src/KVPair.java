public class KVPair<K extends Comparable<K>> {
    private K key;
    private Object value; // Value type is kept as Object to allow any type
    private int id;

    public KVPair(K key, Object value, int id) {
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

    public int getId() {
        return id;
    }

    public int compareTo(K otherKey) {
        return key.compareTo(otherKey);
    }
    @Override
    public String toString() {
        return value.toString();
    }
}
