public class assignment3_3_1 {
    public class HashTable<T1, T2> {
        private int size = 10;
        private Entry<T1, T2>[] table;

        private static class Entry<K, V> {
            K key;
            V value;
            int state; // 0 - empty, 1 - occupied
        }

        public HashTable() {
            this.table = new Entry[this.size];
            for (int i = 0; i < this.size; i++) {
                this.table[i] = new Entry<>(); // Initialize entries to prevent NullPointerException
            }
        }

        // Hash function using key's hashCode()
        private int hash(T1 key) {
            return key.hashCode() % this.size;
        }

        // Quadratic probing
        private int find(T1 key) {
            int index = hash(key);
            int i = 0;
            while (this.table[index] != null && this.table[index].state != 0 && !this.table[index].key.equals(key)) {
                index = (index + i * i) % this.size;
                i++;
            }
            return index;
        }

        public void insert(T1 key, T2 value) {
            int index = find(key);
            if (this.table[index].state == 0) {
                this.table[index].key = key;
                this.table[index].value = value;
                this.table[index].state = 1; // Mark as occupied
            }
        }

        public void delete(T1 key) {
            int index = find(key);
            if (this.table[index].state != 0 && this.table[index].key.equals(key)) {
                this.table[index].state = 0; // Mark as deleted
            }
        }
    }

    public static void main(String[] args) {
        assignment3_3_1.HashTable<Integer, String> hashTable = new assignment3_3_1().new HashTable<>();
        hashTable.insert(1, "One");
        hashTable.insert(2, "Two");
        hashTable.delete(1);
    }
}
