package com.mycompany.bintreeintarray;

import java.util.Arrays;
import java.util.Stack;

public class BinTreeIntArray {

    private Integer[] _tree;

    public BinTreeIntArray(int size) {
        _tree = new Integer[size];
    }

    public Integer[] getTree() {
        return _tree;
    }

    public void insert(int value) {

        var index = 0;
        while (index < _tree.length) {
            if (_tree[index] == null) {
                _tree[index] = value;
                break;
            }
            if (value == _tree[index]) {
                break;
            }
            if (value < _tree[index]) {

                index = 2 * index + 1;
            } else {
                index = 2 * index + 2;
            }
        }

        System.out.println(" ↳ insert: " + value + " → " + Arrays.toString(_tree));
    }

    public void inOrderTraversal() { // left -> root -> right
        System.out.print(" ↳ inOrderTraversal → ");
        var stack = new Stack<Integer>();
        var index = 0;
        while (!stack.isEmpty() || (index < _tree.length && _tree[index] != null)) {
            while (index < _tree.length && _tree[index] != null) {
                stack.push(index);
                index = 2 * index + 1;
            }
            index = stack.pop();
            System.out.print(_tree[index] + " ");
            index = 2 * index + 2;
        }
        System.out.println();
    }

    public void preOrderTraversal() { // root -> left -> right
        System.out.print(" ↳ preOrderTraversal → ");

       if (_tree.length == 0 || _tree[0] == null) {
            System.out.println();
            return;
        }
        var stack = new Stack<Integer>();
        stack.push(0); 
        while (!stack.isEmpty()) {
            int index = stack.pop();

            System.out.print(_tree[index] + " ");
            int rightIndex = 2 * index + 2;
            if (rightIndex < _tree.length && _tree[rightIndex] != null) {
                stack.push(rightIndex);
            }
            int leftIndex = 2 * index + 1;
            if (leftIndex < _tree.length && _tree[leftIndex] != null) {
                stack.push(leftIndex);
            }
        }
        System.out.println();
    }

    public void postOrderTraversal() { // left -> right -> root
        System.out.print(" ↳ postOrderTraversal → ");

        if (_tree.length == 0 || _tree[0] == null) {
            System.out.println();
            return;
        }

        var stack = new Stack<Integer>();
        int index = 0;     
        int lastVisited = -1; 

        while (!stack.isEmpty() || (index < _tree.length && _tree[index] != null)) {
            while (index < _tree.length && _tree[index] != null) {
                stack.push(index);
                index = 2 * index + 1;
            }
            if (stack.isEmpty()) break;
            int peekIndex = stack.peek();
            int rightIndex = 2 * peekIndex + 2;
            if (rightIndex < _tree.length && _tree[rightIndex] != null && rightIndex != lastVisited) {
                index = rightIndex; // Mover a la derecha para iniciar la exploración del subárbol derecho.
            } 
            else {
                stack.pop();
                System.out.print(_tree[peekIndex] + " ");
                lastVisited = peekIndex; // Marcar como visitado/impreso
                index = -1; // Resetear 'index' para que se base en el pop de la pila.
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        var tree = new BinTreeIntArray(7);
        System.out.println("Empty array → " + Arrays.toString(tree.getTree()));
        tree.insert(4);
        tree.insert(6);
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(3);
        System.out.println("\nFull array → " + Arrays.toString(tree.getTree()));
        tree.inOrderTraversal(); // 1 2 3 4 5 6 7
        tree.preOrderTraversal(); // 4 2 1 3 6 5 7
        tree.postOrderTraversal(); // 1 3 2 5 7 6 4
    }
}
