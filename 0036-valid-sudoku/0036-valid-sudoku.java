import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char number = board[r][c];

                if (number != '.') {
                    // Create unique strings for each constraint
                    String rowKey = number + " in row " + r;
                    String colKey = number + " in col " + c;
                    String boxKey = number + " in box " + (r / 3) + "-" + (c / 3);

                    // If any string is already in the set, add() returns false
                    if (!seen.add(rowKey) || 
                        !seen.add(colKey) || 
                        !seen.add(boxKey)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}