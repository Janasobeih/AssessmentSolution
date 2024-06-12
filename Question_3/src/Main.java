import java.util.Stack;

public class Main {
    public static boolean isValid(String delimiters) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < delimiters.length(); i++) {
            char current = delimiters.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else if (current == ')' || current == ']' || current == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.peek();
                if ((current == ')' && top != '(') ||
                        (current == ']' && top != '[') ||
                        (current == '}' && top != '{')) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        //Some Test cases
        System.out.println(isValid("()"));   // true
        System.out.println(isValid("([])")); // true
        System.out.println(isValid("([)]")); // false
        System.out.println(isValid("{[}"));  // false
    }
}
