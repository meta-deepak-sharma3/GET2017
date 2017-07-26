package Assignments;

public class NQueen {
	int[] x;
    public NQueen(int N) {
        x = new int[N];							//number of Queens.
    }
   //Returns TRUE if a queen can be placed in row r and column c.
    public boolean canPlaceQueen(int r, int c) {
        for (int i = 0; i < r; i++) {
            if (x[i] == c || (i - r) == (x[i] - c) ||(i - r) == (c - x[i])) 
            {
                return false;
            }
        }
        return true;								//passing column number for row.
    }
    public void printQueens(int[] x) {
        int N = x.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (x[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    //Using backtracking this method prints all possible placements of n
    public void placeNqueens(int r, int n) {
        for (int c = 0; c < n; c++) {
            if (canPlaceQueen(r, c)) {
                x[r] = c;							//placing column number for row, where row number is index of x.
                if (r == (n - 1)) {
                    printQueens(x);
                }else {
                    placeNqueens(r + 1, n);
                }
            }
        }
    }
    
    
}

