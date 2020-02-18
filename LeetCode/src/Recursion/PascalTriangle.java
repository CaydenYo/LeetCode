package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ansList = new ArrayList<>();
        if (numRows == 0){
            return ansList;
        }
        // the exit of recursion
        if (numRows == 1){
            ansList.add(new ArrayList<>());
            ansList.get(0).add(1);
            return ansList;
        }
        // recursion
        ansList = generate(numRows - 1);
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1;i < numRows - 1;i++){
            row.add(ansList.get(numRows - 2).get(i - 1) + ansList.get(numRows - 2).get(i));
        }
        row.add(1);
        ansList.add(row);
        return ansList;
    }

    public List<List<Integer>> generateIteratively(int numRows) {
        List<List<Integer>> ansList = new ArrayList<>();
        if (numRows == 0){
            return ansList;
        }
        ansList.add(new ArrayList<>());
        ansList.get(0).add(1);

        for (int rowNum = 1;rowNum < numRows;rowNum++){
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = ansList.get(rowNum - 1);
            row.add(1);
            for (int j = 1;j < rowNum;j++){
                row.add(preRow.get(j - 1) + preRow.get(j));
            }
            row.add(1);
            ansList.add(row);
        }
        return ansList;
    }




    public static void main(String[] args){
        for (List item : new PascalTriangle().generate(5)){
            System.out.println(item);
        }
    }
}
