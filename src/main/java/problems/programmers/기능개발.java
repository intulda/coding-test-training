package problems.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기능개발 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
    }

    static int[] solution(int[] progresses, int[] speeds) {
        if (progresses.length == 0 || speeds.length == 0) {
            return new int[0];
        }

        if (progresses.length != speeds.length) {
            return new int[0];
        }

        List<Integer> result = new ArrayList<>();
        int count = 1;
        int currentMax = 0;
        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i] + speeds[i] - 1) / speeds[i];

            if (i == 0) {
                currentMax = day;
            } else if (day <= currentMax) {
                count++;
            } else {
                result.add(count);
                count = 1;
                currentMax = day;
            }
        }

        result.add(count);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
