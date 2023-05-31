package daily._2023._05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.junit.jupiter.api.Test;

public class Day_30 {
    private static class MyHashSet {
        private final int size;
        private List<List<Integer>> buckets;

        public MyHashSet() {
            size = 1000;

            buckets = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                buckets.add(new LinkedList<>());
            }
        }

        public void add(int key) {
            final int hash = hash(key);
            final List<Integer> bucket = buckets.get(hash);
            if (!bucket.contains(key)) {
                bucket.add(key);
            }
        }

        public void remove(int key) {
            final int hash = hash(key);
            buckets.get(hash).remove(Integer.valueOf(key));
        }

        public boolean contains(int key) {
            final int hash = hash(key);
            return buckets.get(hash).contains(key);
        }

        private int hash(int key) {
            return key % size;
        }
    }
}
