package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValid20 {
    public static void main(String[] args) {
        IsValid20 isValid20 = new IsValid20();
        String s = "([])";
        System.out.println(isValid20.isValid(s));
    }

    public boolean isValid(String s) {
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }

        Stack<Character> leftChars = new Stack<>();
        Map<Character, Character> characterMap = new HashMap<>();
        characterMap.put(')', '(');
        characterMap.put(']', '[');
        characterMap.put('}', '{');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //因为左括号必定出现在右括号之前，所以遇到右括号就去匹配，遇到左括号就先入栈
            if (characterMap.containsKey(c)) {
                if (leftChars.empty() || leftChars.pop() != characterMap.get(c)) {
                    return false;
                }
            } else {
                leftChars.push(c);
            }
        }

        return leftChars.empty();
    }
}
