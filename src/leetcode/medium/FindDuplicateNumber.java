package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        Set<Integer> storage = new HashSet<Integer>();
        for (int num : nums) {
            if (storage.contains(num)) {
                return num;
            }
            storage.add(num);
        }

        return -1;
    }
    //Floyd's Tortoise and Hare in Solution
    public int findDuplicate2(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];
        //find intersection
        do{
            tortoise = nums[tortoise]; // one step
            hare = nums[nums[hare]]; //two step
        }while(tortoise != hare);

        //find entrance
        int p1 = nums[0];
        int p2 = tortoise;
        while(p1 != p2){
            p1 = nums[p1];
            p2 = nums[p2];
        }

        return p1;
    }

    /*

    To explain the approach 3. Try to think it as a path
................b.................a...........<-----move this way
|-----@------e----------start
|______________|
.........c

a is the length before the entrance of the cycle
e is the entrance of the cycle
@ is the meet point of tortoise and hare in first loop
b is the length between entrance of the cycle and @
c is the whole length of the cycle minus b

@ must be some point within the cycle
Note hare move faster than tortoise, in order to get to tortoise position,
hare must have gone through a cycle. That's what first loop is doing. Trying to find @ position
a == c
Note the length tortoise has gone is a+b,
and the length hare has gone is a+b+c+b.
we know hare goes twice faster as tortoise, which means 2(a+b) = a+b+c+b which implies c = a
Since a = c, the entrance position is exactly a away from starting position, and c or a away from the @.
Since the is only one duplicated point, t
here is only one cycle therefore only one entrance(could be the starting position or not, we dont know),
but we do know that after 'a' position from starting point and @,
it will be the only duplicate point or entrance point or the only point where hare = tortoise,
that's what the second loop is doing, find the point hare = tortoise and return the value.
we could also create an additional variable to track the value of 'a',
so that we only walk in the path 'a' away from the starting point or @
    */
}
