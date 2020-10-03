package com.company;

import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	    String t = "(){}[]";
	    String t1 = "(({[]}))";
	    String t2 = "{(})";
        boolean test = validateCharacters(t1);
    }

    public static boolean validateCharacters(String s) {
        // check if the strings length is an even number because odd would return false
        if(s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();

    }
}
