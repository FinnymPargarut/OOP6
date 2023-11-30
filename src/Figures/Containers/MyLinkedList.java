package Figures.Containers;

import Figures.Figure;

import java.awt.*;

class Node {
    public Figure figure;
    public Node next;
}

public class MyLinkedList extends MyContainer {
    private Node head;

    public Figure getFigure(int id) {
        if (id < 0) return null;
        Node current = head;
        for (int i = 0; i < id && current != null; i++) {
            current = current.next;
        }
        if (current == null) return null;
        return current.figure;
    }

    public void removeFigure(int id) {
        if (head == null) return;
        if (id < 0) return;
        if (id == 0) {
            head = head.next;
            return;
        }
        Node current = head;
        for (int i = 0; i < id - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) return;
        current.next = current.next.next;
    }

    public void addFigure(Figure figure) {
        if (head == null) {
            head = new Node();
            head.figure = figure;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        Node newNode = new Node();
        newNode.figure = figure;
        current.next = newNode;
    }

    public int getSize() {
        Node current = head;
        int size = 0;
        while (current != null) {
            current = current.next;
            size += 1;
        }
        return size;
    }

    public void iteratorMethod(int methodNumber) {
        Node current = head;
        while (current != null) {
            Node next = current.next;
            switch (methodNumber) {
                case 1 -> {
                    if (current.figure.isShowed && current.figure.getColor() == Color.BLUE) {
                        current.figure.Show();
                        current.figure.setColor(Color.BLUE);
                    }
                    current.figure.MoveTo(x, y);
                }
                case 2 -> current.figure.Show();
                case 3 -> {if (current.figure.isShowed && current.figure.getColor() == Color.white) current.figure.Show();}
                case 4 -> {if (current.figure.isShowed && current.figure.getColor() == Color.BLUE) current.figure.Show();}
                case 5 -> {
                    if (current.figure.isShowed && current.figure.getColor() == Color.BLUE) current.figure.Show();
                    current.figure = null;
                    current.next = null;
                }
            }
            current = next;
        }
    }


    public void removeAllFigures() {
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.figure = null;
            current.next = null;
            current = next;
        }
    }
    public void free() {
        removeAllFigures();
        head = null;
    }
}
