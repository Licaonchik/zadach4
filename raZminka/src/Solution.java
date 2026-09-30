import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Чтение чисел из файла
        List<Integer> nums = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("1111.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    nums.add(Integer.parseInt(line));
                }
            }
        }


        int min37 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n % 37 == 0 && n < min37) {
                min37 = n;
            }
        }


        int max73 = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n % 73 == 0 && n > max73) {
                max73 = n;
            }
        }


        int low = Math.min(min37, max73);
        int high = Math.max(min37, max73);

        // Поиск подходящих пар
        int count = 0;
        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < nums.size() - 1; i++) {
            int a = nums.get(i);
            int b = nums.get(i + 1);

            boolean inA = (a > low && a < high);
            boolean inB = (b > low && b < high);

            // ровно одно число попадает в интервал
            if (inA ^ inB) {
                count++;
                int sum = a + b;
                if (sum < minSum) {
                    minSum = sum;
                }
            }
        }

        System.out.println(count + " " + minSum);
    }
}