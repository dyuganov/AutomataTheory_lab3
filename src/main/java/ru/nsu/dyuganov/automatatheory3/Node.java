package ru.nsu.dyuganov.automatatheory3;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Node {
    @Getter @Setter
    private String stack;
    @Getter
    private Deque<Character> word;

    public Node(String word) {
        this.stack = "";
        this.word = str2stack(word);
    }

    public Node(Deque<Character> word, String stack) {
        this.stack = stack;
        this.word = word;
    }

    public Deque<Character> str2stack(String str) {
        Deque<Character> newStack = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            newStack.addLast(c);
        }
        return newStack;
    }

    public String deq2str(Deque<Character> deque) {
        Iterator i = deque.iterator();
        String str = new String();
        while (i.hasNext()) {
            str += i.next();
        }
        return str;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Node treeNode = (Node) obj;
        return stack.equals(treeNode.stack) && word.equals(treeNode.word);
    }

    @Override
    public String toString() {
        return "(" +
                "word = " + deq2str(word) +
                ", stack = " + stack +
                ')';
    }
}
