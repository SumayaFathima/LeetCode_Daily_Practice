package Hashing;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class S06_Unique_Email_Addresses {

    /* Leetcode_929 : https://leetcode.com/problems/unique-email-addresses/

     Every valid email consists of a local name and a domain name, separated by the '@' sign. Besides lowercase letters,
     the email may contain one or more '.' or '+'.

     For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
     If you add periods '.' between some characters in the local name part of an email address, mail sent there will be
     forwarded to the same address without dots in the local name. Note that this rule does not apply to domain names.

     For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
     If you add a plus '+' in the local name, everything after the first plus sign will be ignored. This allows certain
     emails to be filtered. Note that this rule does not apply to domain names.

     For example, "m.y+name@email.com" will be forwarded to "my@email.com".
     It is possible to use both of these rules at the same time.

     Given an array of strings emails where we send one email to each emails[i], return the number of different addresses
     that actually receive mails.

   */

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

        String[] emails = {"...a@x.com"};
        int output = 1;
        Assert.assertEquals(numUniqueEmails(emails), output);
    }

    /* Pseudo code:

    1. Declare a HashMap to store email address
    2. Using for each loop, split each email with @ (This will give the local name)
    3. Then with the first value, split with +
    4. Then with the first value, split with .
    5. Place the local name in loop and save in result
    6. Add the result of local name with @ and domain name
    7. Place the email in map
    8. Take the count of keyset and return the count

   */
    public int numUniqueEmails(String[] emails) {

        Map<String,Integer> map = new HashMap<String, Integer>();

        for(String email : emails){

            String result = "";
            String [] split1 = email.split("\\@");
            String [] split2 = split1[0].split("\\+");
            String [] split3 = split2[0].split("\\.");

            for(String subStr: split3){
                result += subStr;
            }
            result = result + "@" + split1[1];

            map.put(result, map.getOrDefault(result, 0) +1);
        }

        int count = 0;
        for(String key: map.keySet()){
            count++;
        }

        return count;
    }
}
