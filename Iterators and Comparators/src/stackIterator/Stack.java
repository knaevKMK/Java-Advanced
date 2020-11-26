package stackIterator;

import org.w3c.dom.NodeList;

import java.security.InvalidParameterException;
import java.util.Iterator;

public class Stack<E> implements Iterable<E> {
    public class Node<E> {
        private Node<E> prev;
        private E element;

        private Node(E element) {
            this.prev = null;
            this.element = element;
        }
    }

    private Node<E> top;

    public Stack() {
        this.top = null;
    }

    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.prev = this.top;
        this.top = newNode;
    }

    public E pop() {
        if (this.top == null) {
            throw new InvalidParameterException("No elements");
        }
        E element = this.top.element;
        this.top = this.top.prev;
        return element;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = top;

            @Override
            public boolean hasNext() {
                return this.current != null;
            }

            @Override
            public E next() {
                E element = this.current.element;
                this.current = this.current.prev;
                return element;
            }
        };
    }
}
