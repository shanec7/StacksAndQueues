package com.company;

import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	    String t = "(){}[]";
	    String t1 = "(({[]}))";
	    String t2 = "{(})";
        boolean test = validateCharacters(t1);
        String S = "ab#c";
        String T = "ad#c";
        boolean test2 = backspaceCompare(S,T);
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

    // Runtime: O(N + M) where N is the number of characters in s and M is the number of characters in t.
    // Space complexity: O(N + M) where N is the number of characters in s and M is the number of characters in t.
    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> sStack = new Stack<Character>();
        for(char c : S.toCharArray()) {
            if(c != '#') {
                sStack.push(c);
            } else if (!sStack.isEmpty()) {
                sStack.pop();
            }
        }
        Stack<Character> tStack = new Stack<Character>();
        for(char c : T.toCharArray()) {
            if(c != '#') {
                tStack.push(c);
            } else if (!tStack.isEmpty()) {
                tStack.pop();
            }
        }
        while(!sStack.isEmpty() && !tStack.isEmpty()) {
            if(sStack.pop() != tStack.pop()) {
                return false;
            }
        }

        return sStack.isEmpty() && tStack.isEmpty();
    }
}
