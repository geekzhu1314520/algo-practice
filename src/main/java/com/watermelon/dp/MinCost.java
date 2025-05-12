package com.watermelon.dp;

/**
 * <h1>MinCost</h1>
 *
 * @author zhujiashuai
 * @since 2025/5/7
 */
public class MinCost {

    /**
     * 计算从起点到终点的最小移动成本
     *
     * @param startPos 起始位置坐标 [row, col]
     * @param homePos  目标位置坐标 [row, col]
     * @param rowCosts 每行移动的成本数组
     * @param colCosts 每列移动的成本数组
     * @return 从起点到终点的最小移动成本
     */
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        // 获取起点和终点的行列坐标
        int startRow = startPos[0], startCol = startPos[1];
        int homeRow = homePos[0], homeCol = homePos[1];

        int cost = 0;

        // 处理行移动的成本
        if (startRow < homeRow) {
            // 如果起点行小于终点行,向下移动
            for (int i = startRow + 1; i <= homeRow; i++) {
                cost += rowCosts[i];
            }
        } else {
            // 如果起点行大于终点行,向上移动
            for (int i = startRow - 1; i >= homeRow; i--) {
                cost += rowCosts[i];
            }
        }

        // 处理列移动的成本
        if (startCol < homeCol) {
            // 如果起点列小于终点列,向右移动
            for (int i = startCol + 1; i <= homeCol; i++) {
                cost += colCosts[i];
            }
        } else {
            // 如果起点列大于终点列,向左移动
            for (int i = startCol - 1; i >= homeCol; i--) {
                cost += colCosts[i];
            }
        }

        return cost;
    }

}