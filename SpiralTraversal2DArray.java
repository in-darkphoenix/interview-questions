import java.util.ArrayList;

public class SpiralTraversal2DArray {

    // This is the question where we have to print the 2d array or matrix in spiral
    // order staring from the left-top element.

    // The approach that can be used is we can track the direction of the flow in
    // the matrix, i.e, top, down, left and right

    // Another approach is that we can use the parameter as tracker and print all
    // its element keeping in mind that the value do not duplicate and then shrink
    // the perimeter. We will implement this approach

    // Iterative implementation, O(mn) time | O(mn) space
    public static ArrayList<Integer> spiralOrderI(int[][] arr) {
        ArrayList<Integer> l = new ArrayList<>(); // resultant array list

        int sr = 0; // starting row
        int er = arr.length - 1; // ending row
        int sc = 0; // starting column
        int ec = arr[0].length - 1; // ending column

        while (sr <= er && sc <= ec) {
            // for top perimeter
            for (int c = sc; c <= ec; c++)
                l.add(arr[sr][c]);

            // for right perimeter, staring with sr+1 to prevent dup.
            for (int r = sr + 1; r <= er; r++)
                l.add(arr[r][ec]);

            // for bottom perimeter, can't start with ec
            for (int c = ec - 1; c >= sc; c--)
                l.add(arr[er][c]);

            // for left perimeter, also we cannot go to starting row
            for (int r = er - 1; r > sr; r--)
                l.add(arr[r][sc]);

            // shrinking perimeter;
            sr++;
            er--;
            sc++;
            ec--;
        }

        return l;
    }

    // recurive approach, O(mn) time | O(mn) space
    public static ArrayList<Integer> spiralOrderR(int[][] arr) {
        ArrayList<Integer> l = new ArrayList<>();
        spiralOrderR(arr, 0, arr.length - 1, 0, arr[0].length - 1, l);
        return l;
    }

    private static void spiralOrderR(int[][] arr, int sr, int er, int sc, int ec, ArrayList<Integer> l) {
        // base case, recursion break point
        if (sr > er || sc > ec)
            return;

        // current perimeter traversal
        for (int c = sc; c <= ec; c++)
            l.add(arr[sr][c]);

        for (int r = sr + 1; r <= er; r++)
            l.add(arr[r][ec]);

        for (int c = ec - 1; c >= sc; c--)
            l.add(arr[er][c]);

        for (int r = er - 1; r > sr; r--)
            l.add(arr[r][sc]);

        // inner perimeter call
        spiralOrderR(arr, sr + 1, er - 1, sc + 1, ec - 1, l);
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3, 4 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6 }, { 10, 9, 8, 7 } };
        System.out.println(spiralOrderI(arr));
        System.out.println(spiralOrderR(arr));
    }
}