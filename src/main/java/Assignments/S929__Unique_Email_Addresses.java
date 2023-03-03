package Assignments;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.HashSet;
import java.util.Set;

public class S929__Unique_Email_Addresses {
    @Test
    public void example1() {
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        int output = 2;
        Assert.assertEquals(numUniqueEmails(emails), output);
    }

    @Test
    public void example2() {
        String[] emails = {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
        int output = 3;
        Assert.assertEquals(numUniqueEmails(emails), output);
    }

    @Test
    public void example3() {
        String[] emails = {"m+.a++@x.com"};
        int output = 1;
        Assert.assertEquals(numUniqueEmails(emails), output);
    }

    @Test
    public void example4() {
        String[] emails = {".xyz@gmail.com", "abc@leetcode.com", "a+b.c@gmail.com", "a.+@gmail.com"};
        int output = 3;
        Assert.assertEquals(numUniqueEmails(emails), output);
    }

    @Test
    public void example5() {

        String[] emails = {"......n@s.com"};
        int output = 1;
        Assert.assertEquals(numUniqueEmails(emails), output);
    }

    /* Pseudo code :
        - Traverse each string and first split using @
        - then with split1 - split using +
        - with split 2 - split using .
        - add last split to a result string
        - then add result string with @ and domain name of split 1
        - add in set and return the set size
     */
    public int numUniqueEmails(String[] emails) {

        Set<String> set = new HashSet<>();

        for(String email : emails){

            String result = "";
            String [] split1 = email.split("\\@");
            String [] split2 = split1[0].split("\\+");
            String [] split3 = split2[0].split("\\.");

            for(String subStr: split3){
                result += subStr;
            }
            result = result + "@" + split1[1];
            set.add(result);
        }

        return set.size();
    }
}

