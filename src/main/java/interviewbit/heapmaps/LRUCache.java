package interviewbit.heapmaps;

import java.util.*;


class LRUCache {

    public static void main(String[] args) {
        LRUCache s = new LRUCache(4);
        s.set( 5 ,13);
        s.set( 9 ,6);
        s.set( 4 ,1);
        System.out.println(s.get( 4));
        s.set( 6 ,1);
        s.set( 8 ,11);
        System.out.println(s.get( 13));
        System.out.println(s.get( 1));
        s.set( 12 ,12);
        System.out.println(s.get( 10));
        s.set( 15 ,13);
        s.set( 2 ,13);
        s.set( 7 ,5);
        s.set( 10 ,3);
        System.out.println(s.get( 6));
        System.out.println(s.get( 10));
        s.set( 15 ,14);
        s.set( 5 ,12);
        System.out.println(s.get( 5));
        System.out.println(s.get( 7));
        System.out.println(s.get( 15));
        System.out.println(s.get( 5));
        System.out.println(s.get( 6));
        System.out.println(s.get( 10));
        s.set( 7 ,13);
        System.out.println(s.get( 14));
        s.set( 8 ,9);
        System.out.println(s.get( 4));
        s.set( 6 ,11);
        System.out.println(s.get( 9));
        s.set( 6 ,12);
        System.out.println(s.get( 3));
    }

    private Map<CacheData, Integer> caches = new HashMap<>();
    private PriorityQueue<CacheData> timings = new PriorityQueue<>(Comparator.comparing(CacheData::getTime));

    private Long operationsCount = 0L;
    private int capacity = 0;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    private synchronized Long getTime(){
        return operationsCount++;
    }

    public int get(int key) {
        //System.out.println("Getting: " + key);
        CacheData cacheData = new CacheData(key, getTime());
        if(caches.containsKey(cacheData)){
            return  updateCache(cacheData, caches.get(cacheData));
        } else {
            return -1;
        }
    }

    private Integer updateCache(CacheData cacheData, Integer value) {
        caches.remove(cacheData);
        caches.put(cacheData, value);

        timings.remove(cacheData);
        timings.add(cacheData);

        //caches.keySet().forEach(System.out::println);
        return value;
    }

    public void set(int key, int value) {
        //System.out.println("Setting: " + key);

        CacheData cacheData = new CacheData(key, getTime());

        if(caches.size() >= this.capacity && !caches.keySet().contains(cacheData)){
            CacheData oldest = timings.poll();
            //System.out.println("Removing: " + oldest.id);
            caches.remove(oldest);
        }

        updateCache(cacheData, value);
    }

    class CacheData {
        private Integer id;
        private Long time;

        public Integer getId() {
            return id;
        }

        public Long getTime() {
            return time;
        }


        CacheData(Integer id, Long time) {
            this.id = id;
            this.time = time;
        }

        @Override
        public int hashCode() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof CacheData && Objects.equals(id, ((CacheData) o).getId());
        }
        @Override
        public String toString() {
            return "id: " + id + ", time:" + time;
        }
    }
}
