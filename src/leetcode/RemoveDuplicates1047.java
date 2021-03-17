package leetcode;

import java.util.Stack;

public class RemoveDuplicates1047 {
    public static void main(String[] args) {

    }

    public String removeDuplicates(String S) {
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (characterStack.empty()) {
                characterStack.push(c);
            } else {
                char stackChar = characterStack.peek();
                if (c == stackChar) {
                    characterStack.pop();
                } else {
                    characterStack.push(c);
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : characterStack) {
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }
}
