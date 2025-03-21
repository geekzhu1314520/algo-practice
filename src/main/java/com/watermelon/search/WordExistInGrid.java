package com.watermelon.search;

/**
 * <h1>WordExistInGrid</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/13
 */
public class WordExistInGrid {

    /**
     * 判断二维字符网格中是否存在指定的单词
     *
     * @param board 二维字符网格
     * @param word  要搜索的单词
     * @return 如果找到单词返回true，否则返回false
     */
    public boolean exist(char[][] board, String word) {
        // 边界条件检查
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        // 获取网格的行数和列数
        int m = board.length;
        int n = board[0].length;
        // 创建访问标记数组
        boolean[][] visited = new boolean[m][n];

        // 遍历网格的每个位置作为起点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 深度优先搜索判断是否存在目标单词
     *
     * @param board   二维字符网格
     * @param word    目标单词
     * @param i       当前行坐标
     * @param j       当前列坐标
     * @param index   当前匹配到单词的位置
     * @param visited 访问标记数组
     * @return 是否找到目标单词
     */
    private boolean dfs(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        // 已经完全匹配了单词的所有字符
        if (index == word.length()) {
            return true;
        }

        // 检查边界条件和当前字符是否匹配
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
            || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        // 标记当前位置已访问
        visited[i][j] = true;
        // 向四个方向继续搜索
        boolean result = dfs(board, word, i + 1, j, index + 1, visited)
            || dfs(board, word, i - 1, j, index + 1, visited)
            || dfs(board, word, i, j + 1, index + 1, visited)
            || dfs(board, word, i, j - 1, index + 1, visited);
        // 回溯，恢复未访问状态
        visited[i][j] = false;

        return result;
    }

}