import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main (String[] args) {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] expression_array = scanner.nextLine().split("");

            check_brackets(expression_array);
        }

        scanner.close();
    }

    public static void check_brackets(String[] expression_array){

        Stack<String> temp_stack = new Stack<String>();

        for(int i = expression_array.length-1; i>0; i--){

            if(!temp_stack.empty()){

                String temp_bracket = temp_stack.pop();

                if(!(find_pair(temp_bracket).equals(expression_array[i]))) {
                    temp_stack.push(temp_bracket);
                    temp_stack.push(expression_array[i]);
                }
            }
            else

                temp_stack.push(expression_array[i]);

        }

        if(temp_stack.empty())
            System.out.println("YES");
        else
            System.out.println("NO");

    }

    public static String find_pair(String bracket){
        switch (bracket){

            case "{":
                return "}";

            case "(":
                return ")";

            case "[":
                return "]";

            case "}":
                return "{";

            case ")":
                return "(";

            case "]":
                return "[";

            default:
                System.out.println("yanlis parantez");
                return "";
        }

    }
}