package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combine77 {
    List<List<Integer>> res;
    int n;
    int k;
    public List<List<Integer>> combine(int n, int k) {
        res = new LinkedList<>();
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<Integer>());
        return res;
    }

    private void backtrack(int first, LinkedList<Integer> curr){
        if (curr.size() == k){
            res.add(new LinkedList<>(curr));
        }

        for (int i = first;i <= n;i++){
            curr.add(i);
            backtrack(i + 1, curr);
            curr.removeLast();
        }
    }

    private void backtrackPrune(int first, LinkedList<Integer> curr){
        if (curr.size() == k){
            res.add(new LinkedList<>(curr));
            return;
        }

        for (int i = first;i <= n - (k - curr.size()) + 1;i++){
            curr.add(i);
            backtrackPrune(i + 1, curr);
            curr.removeLast();
        }
    }
}
