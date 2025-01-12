package ue_idc;

import kapitel_3.vl.*;

//aufgabe 1: replace SList in buckets with AVLTree
public class Hashtable {
    protected Bucket[] buckets = null;
    protected int size = 0;
    protected int maxLoad = 0;
    protected int currentLoad = 0;

    protected static IComparator comparator;
    //I want to be able to reference this in static functions too
    //(mainly I don't want to have to add it to every bucket)

    protected static class Bucket {
        private AVLTree tree;

        public Bucket() {
            tree = new AVLTree(comparator);
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

    private static long sdbm(String s) {//only copying one of these
        long hash = 0;

        for (int i = 0; i < s.length(); i++) {
            hash = s.charAt(i) + (hash << 6) + (hash << 16) - hash;
        }

        return hash;
    }

    public Hashtable(IComparator comparator) {
        this(comparator,0);
    }

    public Hashtable(IComparator comparator,int exponent) {
        Hashtable.comparator = comparator;
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

        buckets[(int) (hash & (size - 1))].tree.insert(new Tuple(hash, key, data));

        currentLoad++;
        if (currentLoad >= maxLoad) {
            resize();
        }
    }

    public void resize() {
        Bucket[] newBuckets = initBuckets(size << 1);

        for (int i = 0; i < size; i++) {
            AVLTree tree = buckets[i].tree;
            IFIterator it = tree.iterator();//avltree base btree has an iterator too
            while(it.hasNext()) {
                Tuple entry = (Tuple) it.next();
                newBuckets[(int) (entry.hash & ((size << 1) - 1))].tree.insert(entry);
            }
        }
        size <<= 1;
        maxLoad = (int) (size * 0.75);
        buckets = newBuckets;
    }

    public Object get(String key) {
        long hash = sdbm(key);
        Bucket bucket = buckets[(int) (hash & (size -1 ))];

        TupleKey tupleKey = new TupleKey(key);

        Tuple entry = (Tuple) bucket.tree.search(tupleKey);

        Object ret = null;
        if (entry != null) {
            ret = entry.data;
        }
        return ret;
    }

    public void remove(String key) {
        long hash = sdbm(key);
        Bucket bucket = buckets[(int) (hash & (size -1 ))];

        TupleKey tupleKey = new TupleKey(key);
        Tuple entry = (Tuple) bucket.tree.search(tupleKey);

        bucket.tree.remove(entry);
    }
}
