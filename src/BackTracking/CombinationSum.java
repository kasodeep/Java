package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);

        dfs(0, new ArrayList<>(), nums, target);
        return res;
    }

    private void dfs(int i, List<Integer> cur, int[] nums, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (nums[j] > target) {
                return;
            }
            cur.add(nums[j]);
            dfs(j, cur, nums, target - nums[j]);
            cur.remove(cur.size() - 1);
        }
    }
}
