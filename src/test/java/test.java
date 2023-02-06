import com.sun.xml.internal.ws.encoding.MtomCodec;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class test {

    @Test
    public void example() {

        String s = "()[]{}";
        boolean output = true;
        Assert.assertEquals(validPranthasis(s), output);
    }

        public boolean validPranthasis( String s){
            char[] brackets= s.toCharArray();
            Stack<Character> stack = new Stack<>();
            for( char c : brackets){
                if(c =='('){
                    stack.push(')');
                }
                else if( c=='['){
                    stack.push(']');
                }
                else if( c=='{'){
                    stack.push('}');
                } else if(stack.isEmpty() || c!=stack.pop()  ) return false;
            }
            return stack.isEmpty();
        }
}