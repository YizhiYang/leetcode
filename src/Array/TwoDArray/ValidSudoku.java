package Array.TwoDArray;

import java.util.HashSet;


/**
 * Great solution!. Just trying to explain how to think about % and /. These two operators can be helpful for matrix traversal problems.
 * <p>
 * For a block traversal, it goes the following way.
 * <p>
 * 0,0, 0,1, 0,2; < --- 3 Horizontal Steps followed by 1 Vertical step to next level.
 * <p>
 * 1,0, 1,1, 1,2; < --- 3 Horizontal Steps followed by 1 Vertical step to next level.
 * <p>
 * 2,0, 2,1, 2,2; < --- 3 Horizontal Steps.
 * <p>
 * And so on...
 * But, the j iterates from 0 to 9.
 * <p>
 * But we need to stop after 3 horizontal steps, and go down 1 step vertical.
 * <p>
 * Use % for horizontal traversal. Because % increments by 1 for each j : 0%3 = 0 , 1%3 = 1, 2%3 = 2,
 * and resets back. So this covers horizontal traversal for each block by 3 steps.
 * <p>
 * Use / for vertical traversal. Because / increments by 1 after every 3 j: 0/3 = 0; 1/3 = 0; 2/3 =0; 3/3 = 1.
 * <p>
 * So far, for a given block, you can traverse the whole block using just j.
 * <p>
 * <p>
 * But because j is just 0 to 9, it will stay only first block. But to increment block, use i.
 * To move horizontally to next block, use % again : ColIndex = 3 * i%3 (Multiply by 3 so that the next block is after 3 columns.
 * Ie 0,0 is start of first block, second block is 0,3 (not 0,1);
 * <p>
 * Similarly, to move to next block vertically, use / and multiply by 3 as explained above. Hope this helps.
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {

            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();

            boolean cubeFlag = false;
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] != '.' && !rows.add(board[i][j])){
                    return false;
                }
                if (board[j][i] != '.' && !cols.add(board[j][i])){
                    return false;
                }
                int rowIndex = 3 * (i / 3);         // i / 3 计算在那个
                int colIndex = 3 * (i % 3);

                if (board[rowIndex + j / 3][colIndex + j % 3] != '.' && !cube.add(board[rowIndex + j / 3][colIndex + j % 3])){
                    return false;
                }
            }
        }
        return true;
    }
}
