package TheMedianInTheDataStream;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    /**
     *  小顶堆，默认容量为11
     */
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    /**
     * 大顶堆，容量11
     */
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public void insert(Integer num){
        if (((minHeap.size() + maxHeap.size()) & 1) == 0){
            // 偶数时，下个数字加入小顶堆
            if (!maxHeap.isEmpty() && maxHeap.peek() > num){
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        }else {
            if (!minHeap.isEmpty() && minHeap.peek() < num){
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }

    public Double getMedian(){
        if ((minHeap.size() + maxHeap.size()) == 0){
            return (double) 0;
        }
        double median;
        if ((minHeap.size() + maxHeap.size() & 1 ) == 0){
            median = (maxHeap.peek() + minHeap.peek()) / 2.0;
        }else {
            median = minHeap.peek();
        }
        return median;
    }
}
