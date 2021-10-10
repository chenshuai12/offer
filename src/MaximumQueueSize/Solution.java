package MaximumQueueSize;

import java.util.ArrayDeque;

public class Solution {

    private ArrayDeque<InternalData> data = new ArrayDeque<InternalData>();
    private ArrayDeque<InternalData> maximum = new ArrayDeque<InternalData>();
    private class InternalData{
        int number;
        int index;
        public InternalData(int number,int index) {
            this.number=number;
            this.index=index;
        }
    }
    private int curIndex;

    public void push_back(int number) {
        InternalData curData = new InternalData(number,curIndex);
        data.addLast(curData);

        while(!maximum.isEmpty() && maximum.getLast().number<number)
            maximum.removeLast();
        maximum.addLast(curData);

        curIndex++;  //别漏了这句
    }

    public void pop_front() {
        if(data.isEmpty()) {
            System.out.println("队列为空，无法删除！");
            return;
        }
        InternalData curData = data.removeFirst();
        if(curData.index==maximum.getFirst().index)
            maximum.removeFirst();
    }

    public int max() {
        if(maximum==null){
            System.out.println("队列为空，无法删除！");
            return 0;
        }
        return maximum.getFirst().number;
    }

    public static void main(String[] args) {
        Solution testQueue = new Solution();
        // {2}
        testQueue.push_back(2);
        System.out.println(testQueue.max()==2);
        // {2, 3}
        testQueue.push_back(3);
        System.out.println(testQueue.max()==3);
        // {2, 3, 4}
        testQueue.push_back(4);
        System.out.println(testQueue.max()==4);
        // {2, 3, 4, 2}
        testQueue.push_back(2);
        System.out.println(testQueue.max()==4);
        // {3, 4, 2}
        testQueue.pop_front();
        System.out.println(testQueue.max()==4);
        // {4, 2}
        testQueue.pop_front();
        System.out.println(testQueue.max()==4);
        // {2}
        testQueue.pop_front();
        System.out.println(testQueue.max()==2);
        // {2, 6}
        testQueue.push_back(6);
        System.out.println(testQueue.max()==6);
        // {2, 6, 2}
        testQueue.push_back(2);
        System.out.println(testQueue.max()==6);
        // {2, 6, 2, 5}
        testQueue.push_back(5);
        System.out.println(testQueue.max()==6);
        // {6, 2, 5}
        testQueue.pop_front();
        System.out.println(testQueue.max()==6);
        // {2, 5}
        testQueue.pop_front();
        System.out.println(testQueue.max()==5);
        // {5}
        testQueue.pop_front();
        System.out.println(testQueue.max()==5);
        // {5, 1}
        testQueue.push_back(1);
        System.out.println(testQueue.max()==5);
    }
}
