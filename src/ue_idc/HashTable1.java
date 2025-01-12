package ue_idc;

import kapitel_3.vl.*;

//Aufgabe 2: Entwickeln Sie einen Hashtable, der Kollisionen durch lineares Sondieren auflöst.
public class HashTable1 {
    protected Bucket[] buckets = null;
    protected int size = 0;
    protected int maxLoad = 0;
    protected int currentLoad = 0;

    protected static class Bucket {//
        private Tuple entry=null;

        public Bucket() {
        }
    }

    protected static class Tuple {
        public long hash;
        public String key;
        public Object data;

        public Tuple(long hash, String key, Object data) {
            this.hash = hash;
            this.key = key;
            this.data = data;
        }
    }

    protected static class TupleKey implements IKey {
        String key;

        public TupleKey(String key) {
            this.key = key;
        }

        public boolean matches(Object data) {
            return key.equals(((Tuple) data).key);
        }
    }

    private static long sdbm(String s) {
        long hash = 0;

        for (int i = 0; i < s.length(); i++) {
            hash = s.charAt(i) + (hash << 6) + (hash << 16) - hash;
        }

        return hash;
    }

    public HashTable1() {
        this(0);
    }

    public HashTable1(int exponent) {
        size = 1 << exponent;
        maxLoad = (int) (size * 0.75);
        buckets = initBuckets(size);
    }

    private static Bucket[] initBuckets(int size) {
        Bucket[] b = new Bucket[size];

        for (int i = 0; i < b.length; i++) {
            b[i] = new Bucket();
        }
        return b;
    }

    public void insert(String key, Object data) {
        long hash = sdbm(key);
        int d=1;//change steps/distance here if desired

        while(buckets[(int) (hash & (size - 1))].entry != null){//moves on until a space is open
            hash += d;
        }
        buckets[(int) (hash & (size - 1))].entry=new Tuple(hash, key, data);

        currentLoad++;
        if (currentLoad >= maxLoad) {
            resize();
        }
    }

    public void resize() {
        Bucket[] newBuckets = initBuckets(size << 1);

        for (int i = 0; i < size; i++) {//keeping it manual just to be safe
            newBuckets[i]=buckets[i];
        }
        size <<= 1;
        maxLoad = (int) (size * 0.75);
        buckets = newBuckets;
    }

    public Object get(String key) {
        long hash = sdbm(key);
        Bucket bucket = buckets[(int) (hash & (size -1 ))];

        Object ret = null;
        if (bucket.entry != null) {
            ret = bucket.entry.data;
        }
        return ret;
    }

    public void remove(String key) {
        long hash = sdbm(key);
        Bucket bucket = buckets[(int) (hash & (size -1 ))];

        bucket.entry=null;
    }
}
