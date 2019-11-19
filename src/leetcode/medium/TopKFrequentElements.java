package leetcode.medium;

import java.lang.reflect.Array;
import java.util.*;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //store data in Hashmap with key (num) and value(how many the number exists in array)
        HashMap<Integer, Integer> storage = new HashMap<>();
        for (int num : nums) {
            storage.put(num, storage.getOrDefault(num, 0)+1);
        }

        //make the heap which is min heap(the value is the count)
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> storage.get(n1) - storage.get(n2));

        //loop through Hashmap and put data into heap
        //if the heap size is bigger than k, remove it,
        // because root value is the less count of array. if it's not included into k, we don't need it anymore
        for (int num : storage.keySet()){
            heap.add(num);
            if(heap.size() > k) {
                heap.poll();
            }
        }

        //add value in heap into LinkedList, then reverse the list and return
        List<Integer> topList = new LinkedList<>();
        while(!heap.isEmpty()){
            topList.add(heap.poll());
        }
        Collections.reverse(topList);
        return topList;


    }

    public static void main(String[] args) {
        TopKFrequentElements t = new TopKFrequentElements();
        t.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    }
}
