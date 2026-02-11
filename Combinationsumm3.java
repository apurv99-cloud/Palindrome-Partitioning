import java.util.*;

public class Combinationsumm3 {
    public static List<List<Integer>> combinationsumm3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k, n, 1, new ArrayList<>(), result);
        return result;

    }

    private static void backtrack(int k, int target, int start, List<Integer> curr, List<List<Integer>> result) {
        if (curr.size() == k) {
            if (target == 0) {
                result.add(new ArrayList<>(curr));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (i > target)
                break;

            curr.add(i);
            backtrack(k, target - i, i + 1, curr, result);
            curr.remove(curr.size() - 1);

        }
    }

}