package solutions.combinations;

import java.util.List;
import java.util.ArrayList;
/**
 * Given a set of candidate numbers (candidates) (without duplicates)
 * and a target number (target), find all unique combinations in candidates
 * where the candidate numbers sums to target.
 *
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
    private List<List<Integer>> result;

    public List<List<Integer>> solve(int[] candidates, int target) {
        result = new ArrayList<>();
        backtrackDfs(candidates, new ArrayList<>(), target, 0, 0);
        return result;
    }

    private void backtrackDfs(int[] candidates, ArrayList<Integer> solution, int target, int k, int sum) {
        if (k == candidates.length || sum >= target) {
            if (sum == target) {
                result.add(new ArrayList<>(solution));
            }
        } else {
            solution.add(candidates[k]);
            backtrackDfs(candidates, solution, target, k, sum + candidates[k]);
            solution.remove(solution.size() - 1);
            backtrackDfs(candidates, solution, target, k+1, sum);
        }
    }
}
