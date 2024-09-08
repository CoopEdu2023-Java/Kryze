public class assignment3_1_3 {
    public static class ArrayList<T> {
        private T[] data;
        private int size;

        public ArrayList(int capacity) {
            this.data = (T[]) new Object[capacity];
            this.size = 0;
        }

        public void insert(int index, T value) {
            if (index < 0 || index > this.size) {
                throw new IndexOutOfBoundsException();
            }
            if (this.size == this.data.length) {
                expandCapacity();
            }
            for (int i = this.size; i > index; i--) {
                this.data[i] = this.data[i - 1];
            }
            this.data[index] = value;
            this.size++;
        }

        public T delete(int index) {
            if (index < 0 || index >= this.size) {
                throw new IndexOutOfBoundsException();
            }
            T deletedValue = this.data[index];
            for (int i = index; i < this.size - 1; i++) {
                this.data[i] = this.data[i + 1];
            }
            this.data[this.size - 1] = null;
            this.size--;
            return deletedValue;
        }

        public T get(int index) {
            if (index < 0 || index >= this.size) {
                throw new IndexOutOfBoundsException();
            }
            return this.data[index];
        }

        public void set(int index, T value) {
            if (index < 0 || index >= this.size) {
                throw new IndexOutOfBoundsException();
            }
            this.data[index] = value;
        }

        private void expandCapacity() {
            int newCapacity = this.data.length * 2;
            T[] newData = (T[]) new Object[newCapacity];
            for (int i = 0; i < this.size; i++) {
                newData[i] = this.data[i];
            }
            this.data = newData;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(50);
        arr.insert(0, 10);
        arr.insert(1, 20);
        arr.insert(2, 30);
        arr.insert(1, 15);
        for (int i = 0; i < arr.size; i++) {
            System.out.println("元素在索引 " + i + ": " + arr.get(i));
        }
        arr.delete(1);
        System.out.println("删除后的结果:");
        for (int i = 0; i < arr.size; i++) {
            System.out.println("元素在索引 " + i + ": " + arr.get(i));
        }
        arr.set(1, 100);
        System.out.println("设置后的结果:");
        for (int i = 0; i < arr.size; i++) {
            System.out.println("元素在索引 " + i + ": " + arr.get(i));
        }
    }
}
