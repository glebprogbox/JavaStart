package core.generic;

public class Keys<K, V> {
    private final K key;
    private final V value;

    public Keys(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public K getKey() {
        return key;
    }

    public V getValueByKey(K key) {
        return value;
    }

    public K getKeyByValue(V value) {
        return key;
    }

}
