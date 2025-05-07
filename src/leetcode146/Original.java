package leetcode146;

import java.util.*;

public class Original {

    public static void main(String[] args) {

    }


    public static class Cache{

        public Map<Integer, Integer> cache;
        public List<Integer> order;
        public int capacity;

        public Cache(int capacity){
            this.capacity = capacity;
            this.cache = new HashMap<>();
            this.order = new LinkedList<>();
        }

        public void put(int key, int val){
            Integer keyInt = (Integer) key;
            if(this.cache.containsKey(key)){
                this.cache.put(keyInt, val);
                this.order.remove(keyInt);
                this.order.addFirst(keyInt);
            } else {
                this.cache.put(keyInt, val);
                this.order.addFirst(keyInt);
            }

            if(this.order.size() > capacity){
                Integer lastKey = this.order.removeLast();
                this.cache.remove(lastKey);
            }
        }

        public int get(int key){
            Integer keyInt = (Integer) key;
            if(this.cache.containsKey(keyInt)){
                this.order.remove(keyInt);
                this.order.addFirst(keyInt);
                return this.cache.get(keyInt);
            } else {
                return -1;
            }
        }

        public void delete(int key){
            Integer keyInt = (Integer) key;
            if(this.cache.containsKey(keyInt)){
                this.cache.remove(keyInt);
                this.order.remove(keyInt);
            }
        }

        public int getLast(){
            if(this.order.isEmpty()){
                return -1;
            } else {
               return this.order.getFirst();
            }
        }
    }
}
