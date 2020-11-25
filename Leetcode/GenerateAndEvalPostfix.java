/**
 * @see <a href=
 *      "https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/567/week-4-november-22nd-november-28th/3542/">some
 *      other link</a>
 * 
 */

class Solution {

    public static boolean isHighPrecedence(char oper1, char oper2) {
        if ((oper1 == '*' && (oper2 == '+' || oper2 == '-')) || (oper1 == '/' && (oper2 == '+' || oper2 == '-'))) {
            return true;
        }
        return false;

    }

    public static int calcAirthmeticOperation(int operand1, int operand2, char operator) {
        switch (operator) {
            case '+':
                return operand2 + operand1;
            case '-':
                return operand2 - operand1;
            case '/':
                return operand2 / operand1;
            default:
                return operand2 * operand1;
        }
    }

    public static int getPostFixExpression(String infix) {
        Stack<Character> operators = new Stack<Character>();
        Stack<Integer> operands = new Stack<Integer>();
        String digit = "";
        for (char c : infix.toCharArray()) {
            if (c != '+' && c != '-' && c != '*' && c != '/') {
                digit += c;
            }

            else {
                if (!digit.isEmpty()) {
                    operands.push(Integer.parseInt(digit));
                    digit = "";
                }

                if (operators.size() == 0) {
                    operators.push(c);
                } else {
                    while (!isHighPrecedence(c, operators.peek())) {
                        int operand1 = operands.pop();
                        int operand2 = operands.pop();
                        char operator = operators.pop();
                        operands.push(calcAirthmeticOperation(operand1, operand2, operator));

                        if (operators.size() == 0) {
                            break;
                        }
                    }

                    operators.push(c);

                }
            }
        }
        operands.push(Integer.parseInt(digit));
        System.out.println(operators.size() + " " + operands.size());
        while (operators.size() != 0) {
            int operand1 = operands.pop();
            int operand2 = operands.pop();
            char operator = operators.pop();
            operands.push(calcAirthmeticOperation(operand1, operand2, operator));
        }
        return operands.pop();
    }

    public int calculate(String s) {
        s = s.replaceAll("\\s", "");
        return getPostFixExpression(s);
    }
}