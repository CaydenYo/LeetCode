package Recursion;

/**
 * @Author cayden
 * @Date 2020/7/17 5:50 下午
 */
public class ValidTicTacToe794 {
    public boolean validTicTacToe(String[] board) {
        int countX = 0;
        int countO = 0;
        char[][] chars = new char[3][3];
        chars[0] = board[0].toCharArray();
        chars[1] = board[1].toCharArray();
        chars[2] = board[2].toCharArray();
        for (char[] ca : chars) {
            for (char c : ca) {
                if (c == 'X') {
                    countX++;
                }
                if (c == 'O') {
                    countO++;
                }
            }
        }
        if (countO > countX || countX - countO > 1) {
            return false;
        }

        //相等的时候说明最后一步是0走的，X不可能赢
        if (countX == countO && hasSuccess(chars, 'X')) {
            return false;
        }

        //大于1的时候说明最后一步是X走的，0不可能赢
        if (countX - countO == 1 && hasSuccess(chars, 'O')) {
            return false;
        }
        return true;
    }

    private boolean hasSuccess(char[][] chars, char c) {
        //横着三排
        if (chars[0][0] == c && chars[0][1] == c && chars[0][2] == c) {
            return true;
        }
        if (chars[1][0] == c && chars[1][1] == c && chars[1][2] == c) {
            return true;
        }

        if (chars[1][0] == c && chars[2][1] == c && chars[2][2] == c) {
            return true;
        }
        //竖着三排
        if (chars[0][0] == c && chars[1][0] == c && chars[2][0] == c) {
            return true;
        }
        if (chars[0][1] == c && chars[1][1] == c && chars[2][1] == c) {
            return true;
        }
        if (chars[0][2] == c && chars[1][2] == c && chars[2][2] == c) {
            return true;
        }
        //斜着两个
        if (chars[0][0] == c && chars[1][1] == c && chars[2][2] == c) {
            return true;
        }
        if (chars[0][2] == c && chars[1][1] == c && chars[2][0] == c) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] board = {"XXX","OOX","OOX"};
        System.out.println(new ValidTicTacToe794().validTicTacToe(board));
    }
}
