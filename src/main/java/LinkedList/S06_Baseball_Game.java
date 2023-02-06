package LinkedList;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class S06_Baseball_Game {

    @Test
    public void example1() {
        String[] ops = {"5, 2, C, D, +"};
        int output = 30;
        Assert.assertEquals(calPoints(ops), output);
    }

    @Test
    public void example2() {
        String[] ops = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        int output = 27;
        Assert.assertEquals(calPoints(ops), output);
    }

    @Test
    public void example3() {
        String[] ops = {"1", "C"};
        int output = 0;
        Assert.assertEquals(calPoints(ops), output);
    }

   /* Pseudo code for Stack :

        1. Create a stack
        2. Traverse while i<ops.length
        3. If value is +,
              * pop and store the value in a variable
              * peek and add with the variable
              * push the variable value and then the added value
        4. If value is C, then pop.
        5. If value is D, then do peek *2 and push to stack
        6. Else Convert to integer and push to stack
        7. A loop while stack goes empty - pop and add the values to sum
        8. Return sum
    */


    public int calPoints(String[] ops) { // 5 2 C D +

        Stack<Integer> stack = new Stack<>();
        int sum=0;

        for(int i=0;i<ops.length;i++){

            if (ops[i].equals("+")) {
                int pop = stack.pop();
                int add = stack.peek() + pop;
                stack.push(pop);
                stack.push(add);
            }
            else if (ops[i].equals("C")) {
                stack.pop();
            }
            else if (ops[i].equals("D")) {
                stack.push(stack.peek()*2);
            }
            else {
                stack.push(Integer.valueOf(ops[i]));
            }
        }

        while(!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}

/*   public int calPoints(String[] ops) {

        LinkedList<Integer> list = new LinkedList<>();
        int sum = 0;

        for(int i=0;i<ops.length;i++){

            if (ops[i].equals("+")) {
                list.add(list.getLast() + list.getLast()-1);
            }
            else if (ops[i].equals("D")) {
                list.add(list.getLast() * 2);
            }
            else if (ops[i].equals("C")) {
                list.removeLast();
            }
            else {
                list.add(Integer.valueOf(ops[i]));
            }
        }

        for (int i : list) {
            sum += i;
        }

        return sum;
    }
} */