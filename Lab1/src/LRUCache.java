import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache<K, V> {

    private final int sizeLimit;

    private final HashMap<K, V> map = new HashMap<>();
    private final LinkedList<K> linkedList = new LinkedList<>();

    public LRUCache(int sizeLimit) {
        if (sizeLimit <= 0)
            throw new IllegalArgumentException("Expected sizeLimit > 0");
        this.sizeLimit = sizeLimit;
    }

    public boolean add(K key, V value) {
        assert keySyncAssertion(key);
        if (map.containsKey(key)) {
            return false;
        } else {
            map.put(key, value);
            linkedList.addFirst(key);
            if (map.size() > sizeLimit) {
                map.remove(linkedList.removeLast());
            }
            assert sizeSyncAssertion();
            assert sizeAssertion();
            return true;
        }
    }

    public boolean put(K key, V value) {
        assert keySyncAssertion(key);
        boolean verdict = true;
        if (map.containsKey(key)) {
            map.remove(key);
            linkedList.remove(key);
            verdict = false;
        }
        map.put(key, value);
        linkedList.addFirst(key);
        if (map.size() > sizeLimit) {
            map.remove(linkedList.removeLast());
        }
        assert sizeSyncAssertion();
        assert sizeAssertion();
        return verdict;
    }

    public V getOrPut(K key, V defaultValue) {
        assert keySyncAssertion(key);
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            put(key, defaultValue);
            return defaultValue;
        }
    }

    public V get(K key) {
        assert keySyncAssertion(key);
        return map.getOrDefault(key, null);
    }


    private boolean keySyncAssertion(K key) {
        return map.containsKey(key) == linkedList.contains(key);
    }

    private boolean sizeSyncAssertion() {
        return map.size() == linkedList.size();
    }

    private boolean sizeAssertion() {
        return map.size() <= sizeLimit;
    }

}
