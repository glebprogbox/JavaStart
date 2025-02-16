package core.generic;

import java.util.HashMap;
import java.util.Map;

public class MyMaps<K, V> {
    private final Map<K, V> mapKey = new HashMap<>();
    private final Map<V, K> mapValue = new HashMap<>();

    public void put(K key, V value) {
        mapKey.put(key, value);
        mapValue.put(value, key);
    }

    public V getValueByKey(K key) {
        return mapKey.get(key);
    }

    public K getKeyByValue(V value) {
        return mapValue.get(value);
    }

}
