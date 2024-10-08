/*
문제 설명
1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
  3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> proQueue = new LinkedList<>();
        Queue<Integer> orderQueue = new LinkedList<>();
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < priorities.length; i++) {
            proQueue.add(priorities[i]);
            orderQueue.add(i);
        }

        while (proQueue.peek() != null) {
            int value = proQueue.poll();
            int orderValue = orderQueue.poll();

            if (proQueue.stream().filter(number -> value < number).toArray().length == 0) {
                order.add(orderValue);
            } else {
                proQueue.add(value);
                orderQueue.add(orderValue);
            }
        }

        return order.indexOf(location) + 1;
    }
}