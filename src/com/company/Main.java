package com.company;

import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	    String t = "(){}[]";
	    String t1 = "(({[]}))";
	    String t2 = "{(})";
        //boolean test = validateCharacters(t1);
        String S = "ab#c";
        String T = "ad#c";
        //boolean test2 = backspaceCompare(S,T);
        String s = "foobar";
        String res = removeAdjDupes(s);
        System.out.println(res);
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

    //Runtime: O(N) where N is the number of characters in s.
    //Space complexity: O(N) where N is the number of characters in s.
    public static String removeAdjDupes(String s) {
        //Shane Method first try
//        Stack<Character> stack = new Stack<Character>();
//        for(char c : s.toCharArray()) {
//            if(stack.isEmpty()) {
//                stack.push((c));
//            }else if(stack.peek() == c) {
//                stack.pop();
//            } else {
//                stack.push(c);
//            }
//        }
//        StringBuilder str = new StringBuilder();
//        for(char c : stack){
//            str.append(c);
//        }
//        return str.toString();

        // Daily Byte answer that is twice as fast as mine
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }
}
