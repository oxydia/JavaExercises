package fr.upemlv.data;
import java.io.Serializable;
import java.io.Externalizable;
import java.util.Iterator;

/**
*   LinkedList class
*/
public class LinkedList<T> implements Iterable<T> {

    /**
    *   Link class
    */
    public static class Link<T> implements Serializable {
        public final T data;
        public Link next;    
        public Link(T data){
            this.data = data;
            this.next = null;
        }
        public void setNext(Link next){
            this.next = next;
        }
        /*
        public void writeExternal(ObjectOutput out) {}
        public void readExternal(ObjectInput in) {}
        */
    }

    /**
    *   LinkedListIterator class
    */
    public class LinkedListIterator implements Iterator {
        private Link<T> elt;

        public LinkedListIterator(Link elt) {
            this.elt = elt;
        }
        public boolean hasNext() {
            return elt.next instanceof Link;
        }
        public T next() {
            Link<T> a = elt;
            elt = a.next;
            return elt.data;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // links attributes
    private int _size = 0;
    public Link<T> first = null;
    
    public void addFirst(T m){
        Link<T> l = new Link(m);
        l.setNext(this.first);
        this.first=l;
        this._size++;
    }

    public int size() {
        return _size;
    }

    public T get(int i) {
        int currentI = 0;
        if(i == 0)
            return first.data;
        else
           
        return null;
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator(first);
    }
    
}
