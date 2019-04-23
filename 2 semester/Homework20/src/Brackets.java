public class Brackets {
    private Stack stack;

    public Brackets(Stack stack) {
        this.stack = stack;
    }

    public boolean bracketsAreCorrect(String s) {
        char[] symbols = s.toCharArray();
        for (int i = 0; i < symbols.length; i++) {
            char c = symbols[i];
            if (c == '(' || c == '{' || c =='['){
                stack.push(c);
            }

        }
        return false;
    }
}
