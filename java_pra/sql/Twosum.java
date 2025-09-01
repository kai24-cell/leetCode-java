import java.util.ArrayList;
import java.util.List;

public class Twosum {
    public static void main(String[] args) {
        // int nums[] = { 2, 7, 11, 15 };
        // int nums[] = { 3, 2, 4 };
        int nums[] = { 3, 3 };
        List<Integer> output = new ArrayList<>();
        int target = 6;
        Solutions x = new Solutions();
        output = x.twoSum(nums, target);
        x.printer(output);

    }
}

class Solutions {
    public List<Integer> twoSum(int[] num, int target) {
        int sum = 0;
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length; j++) {
                sum = num[i] + num[j];
                if (sum == target && i != j) {
                    output.add(i);
                    output.add(j);
                    return output;
                }
            }
        }
        return output;
    }

    public void printer(List<Integer> output) {
        for (int x : output) {
            System.out.println(x);
        }
    }
}