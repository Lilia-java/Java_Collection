import java.util.Iterator;

public class MyLinkedList<E> implements ILinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    //private transient Node<E> header = new Node<E>(null, null, null);
    private int size;

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            private E[] arrList;
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size && arrList[index] != null;
            }

            @Override
            public E next() {
                return arrList[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }


    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void add(E element) {
        Node<E> e =new Node<E>((E)element,null,last);
        if (size == 0)
            first = last = e;
        else {
            e.prev = last;
            last.next = e;
            last = e;
        }
        size++;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Add element is impossible: " + element.toString() +
                    "on this index: " + index);
        }
        if (index == this.size) {
            add(element);
        } else if (index == 0) {
            addFirst(element);
        } else {
            // go to list from start(0) to given index
            Node<E> nodeBefore = first;
            for (int i = 0; i < index - 1 ; i++) {
                nodeBefore = nodeBefore.next;
            }
            Node<E> nodeAfter = nodeBefore.next;
            Node<E> addedNode = new Node<E>(element, nodeBefore, nodeAfter);
            nodeBefore.next = addedNode;
            nodeAfter.prev = addedNode;
            this.size++;
        }
    }

    public boolean addFirst(E element) {
        Node<E> node = new Node<E>(element, null, this.first);
        if (this.first == null) {
            this.last = node;
        } else {
            this.first.prev = node;
        }
        this.first = node;
        this.size++;
        return true;
    }

    @Override
    public void clear() {
        Node<E> curr = this.first;
        while (curr != null) {
            Node<E> nodeForRemove = curr;
            curr = curr.next;
            killLink(nodeForRemove);
        }
        this.size = 0;
        this.first = null;
        this.last = null;
    }
    private void killLink(Node<E> node) {
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        if (prev == null) {
            this.first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            this.last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }
        this.size--;
        node.element = null;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size:"
                    + size);
        return getNode(index).element;
    }

    @Override
    public int indexOf(E element) {
        int index = 0;
        if (element == null) {
            for (Node<E> e = first; e != null; e = e.next) {
                if (e.element == null)
                    return index;
                index++;

            }
        } else {
            for (Node<E> e = first; e != null; e = e.next) {
                if (element.equals(e.element))
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size:"
                    + size);
        Node<E> e = getNode(index);
        size--;
        if (size == 0)
            first = last = null;
        else
        {
            if (e == first)
            {
                first = e.next;
                e.next.prev = null;
            }
            else if (e == last)
            {
                last = e.prev;
                e.prev.next = null;
            }
            else {
                e.next.prev = e.prev;
                e.prev.next = e.next;
            }
        }
        return  e.element;
    }
    Node<E> getNode (int n){
        Node<E> e;
        if (n < size / 2)
        {
            e = first;
            // n less than size/2, iterate from start
            while (n-- > 0)
                e = e.next;
        }
        else
        {
            e = last;
            // n greater than size/2, iterate from end
            while (++n < size)
                e = e.prev;
        }
        return e;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node =new Node<E>((E)element,null,last);
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size:"
                    + size);
        Node<E> e =getNode(index);
        E old=e.element;
        e.element= (E) element;
        return old;
    }

    @Override
    public int size() {
        return size;
    }

    /*@Override
    public E[] toArray() {
        E[] resultArr = (E[]) new Object[this.size];
        Node<E> curr = this.first;
        for (int i = 0; i < this.size; i++) {
            resultArr[i] = curr.element;
            curr = curr.next;
        }
        return resultArr;
    }*/
    //@Override
    public  E[] toArray(E[] a) {
        if (a.length < this.size) {
            a = (E[])  java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), this.size);
        }
        Object[] result = a;
        Node<E> curr = this.first;
        for (int i = 0; i < this.size; i++) {
            result[i] = curr.element;
            curr = curr.next;
        }
        if (a.length > this.size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> e = first; e != null; e = e.next)
            result[i++] = e.element;
        return result;
    }

}
