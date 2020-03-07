package solutions.combinations;

/**
 * Print all subsets of { 1, ..., n }
 *
 * Time complexity:  O(2^n * n)
 * Space complexity: O(n) (stack space). That's not counting the memory used to display them all.
 */
public class AllSubsets {

    public void solve(int n) {
        System.out.format("Printing %d subsets:\n", 1 << n);
        boolean a[] = new boolean[n+1];
        backtrackDfs(a, 1);
    }

    private void backtrackDfs(boolean[] a, int k) {
        if (k == a.length) {
            processSolution(a);
        } else {
            a[k] = true;
            backtrackDfs(a, k + 1);
            a[k] = false;
            backtrackDfs(a, k + 1);
        }
    }

    private void processSolution(boolean[] a) {
        System.out.print("{ ");
        for (int i = 1; i < a.length; i++) {
            if (a[i]) {
                System.out.format("%d ", i);
            }
        }
        System.out.println("}");
    }
}
