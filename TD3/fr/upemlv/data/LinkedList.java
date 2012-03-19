package fr.upemlv.data;

import libs.MediaBuyable;
import java.util.Iterator;

/**
*   LinkedList class
*/
public class LinkedList implements Iterable<MediaBuyable> {

    /**
    *   Link class
    */
    public static class Link {
        public final MediaBuyable data;
        public Link next;    
        public Link(MediaBuyable data){
            this.data = data;
            this.next = null;
        }
        public void setNext(Link next){
            this.next = next;
        }
    }

    /**
    *   LinkedListIterator class
    */
    public class LinkedListIterator implements Iterator {
        private Link elt;

        public LinkedListIterator(Link elt) {
            this.elt = elt;
        }
        public boolean hasNext() {
            return elt.next instanceof Link;
        }
        public MediaBuyable next() {
            Link a = elt;
            elt = a.next;
            return elt.data;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // links attributes
    private int _size = 0;
    public Link first = null;
    
    public void addFirst(MediaBuyable m){
        Link l = new Link(m);
        l.setNext(this.first);
        this.first=l;
        this._size++;
    }

    public int size() {
        return _size;
    }

    public MediaBuyable get(int i) {
        int currentI = 0;
        if(i == 0)
            return first.data;
        else if(i < _size)
            for(Iterator<MediaBuyable> it = iterator(); it.hasNext(); ++currentI) {
                MediaBuyable media = it.next();
                if(currentI == i-1)
                    return media;
            }
        else
            throw new java.lang.IndexOutOfBoundsException();
        return null;
    }

    public Iterator<MediaBuyable> iterator() {
        return new LinkedListIterator(first);
    }

    
}
