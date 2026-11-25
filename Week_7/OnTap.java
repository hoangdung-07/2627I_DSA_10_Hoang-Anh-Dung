package Week_7;


import java.util.*;

public class OnTap {

    public static String Filter(String string){
        Stack<Character> stack1 = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(int i=0; i<string.length();i++){
            stack1.push(string.charAt(i));
        }
        for(int i = 0; i<stack1.size(); i++){
            char a = stack1.pop();
            if(!stack1.peek().equals(a)){
                result.append(a);
                result.append(stack1.pop());
            }
            else{
                stack1.pop();
            }
        }
        return result.toString();
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        sc.next();
        System.out.println(Filter(line));
    }
}
