package leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        //Min priorityQueue 사용
        //priorityQueue 사이즈가 k보다 크다면 poll 해줌 왜냐하면 k보다 큰 경우 root에 있는 값은
        //k번째 큰 숫자가 될 수 없기 때문
        //heap의 특성상 root밑의 숫자는 다 root보다 큼 그렇기 때문에 size가 k보다 큰경우
        //k번째 큰 숫자가 될 수  없다.
        for(int n : nums){
            priorityQueue.add(n);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }

        return priorityQueue.poll();
    }

    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}

