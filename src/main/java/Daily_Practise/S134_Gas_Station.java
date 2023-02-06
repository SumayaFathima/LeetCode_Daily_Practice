package Daily_Practise;

import org.junit.jupiter.api.Test;
import org.testng.Assert;


public class S134_Gas_Station {

    @Test
    public void example1() {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int output = 3;
        Assert.assertEquals(canCompleteCircuit(gas, cost), output);
    }

    @Test
    public void example2() {
        int[] gas = {2,3,4};
        int[] cost = {3,4,5};
        int output = -1;
        Assert.assertEquals(canCompleteCircuit(gas, cost), output);
    }

    @Test
    public void example3() {
        int[] gas = {5,8,2,8};
        int[] cost = {6,5,6,6};
        int output = 3;
        Assert.assertEquals(canCompleteCircuit(gas, cost), output);
    }

    @Test
    public void example4() {
        int[] gas = {5,1,2,3,4};
        int[] cost = {4,4,1,5,1};
        int output = 4;
        Assert.assertEquals(canCompleteCircuit(gas, cost), output);
    }

    /*
     Pseudo code:

     1. Since the amount cost should be more than gas, if gasSum < costSum then return -1
     2. Else, Traverse till length of either of the arrays
     3. Add the previous efficiency value with next gas cost - travel cost
     4. If the efficiency value is < 0, reset the index as current +1 and efficiency as 0
     5. Return the start index finally
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int efficiency = 0,startIndex = 0, gasSum = 0,costSum = 0;

        for(int i=0;i<gas.length;i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }

        if(gasSum < costSum) return -1;
        else {
            for(int i=0;i<gas.length;i++) {
                efficiency += gas[i] - cost[i];
                if(efficiency < 0) {
                    startIndex = i+1;
                    efficiency = 0;
                }
            }
        }
        return startIndex;
    }
}