package com.watermelon.segments;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Please use the exact class name, method name and input/output formats in this code template.
 * We are looking for a program that manages “intensity” by segments.
 * Segments are intervals from -infinity to infinity, we’d like you to implement functions that updates intensity by an integer amount for a given range.
 * All intensity starts with 0. Please implement these three functions:
 * NOTE: Feel free to add any extra member variables/functions you like.
 */
public class IntensitySegments {
    // 使用TreeMap存储分段点和对应的强度值
    private final TreeMap<Integer, Integer> segments;

    public IntensitySegments() {
        segments = new TreeMap<>();
    }

    /**
     * 在指定范围内增加强度值
     *
     * @param from   起始位置
     * @param to     结束位置
     * @param amount 增加的强度值
     */
    public void add(int from, int to, int amount) {
        // 获取起始点之前的最后一个点的强度值
        int prevValue = segments.floorEntry(from) != null ?
            segments.floorEntry(from).getValue() : 0;

        // 更新起始点的强度值
        segments.merge(from, prevValue + amount, (old, val) -> old + amount);

        // 获取范围内的所有点
        NavigableMap<Integer, Integer> subMap = segments.subMap(from, false, to, true);
        for (Map.Entry<Integer, Integer> entry : new ArrayList<>(subMap.entrySet())) {
            segments.put(entry.getKey(), entry.getValue() + amount);
        }

        // 更新结束点的强度值
        int endValue = segments.lowerEntry(to) != null ?
            segments.lowerEntry(to).getValue() : 0;
        segments.put(to, endValue - amount);

        // 清理强度值为0的中间点
        cleanupZeroIntensity();
    }

    /**
     * 在指定范围内设置强度值
     *
     * @param from   起始位置
     * @param to     结束位置
     * @param amount 设置的强度值
     */
    public void set(int from, int to, int amount) {
        // 清除原有范围内的所有点
        segments.subMap(from, false, to, true).clear();

        // 设置新的强度值
        segments.put(from, amount);
        segments.put(to, 0);

        // 清理强度值为0的中间点
        cleanupZeroIntensity();
    }

    /**
     * 清理强度值为0的冗余点
     */
    private void cleanupZeroIntensity() {
        List<Integer> keysToRemove = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : segments.entrySet()) {
            if (entry.getValue() == 0 && segments.lowerEntry(entry.getKey()) != null
                && segments.lowerEntry(entry.getKey()).getValue() == 0) {
                keysToRemove.add(entry.getKey());
            }
        }
        keysToRemove.forEach(segments::remove);
    }

    /**
     * 打印当前所有分段点及其强度值
     */
    public void printString() {
        if (segments.isEmpty()) {
            System.out.println("[]");
            return;
        }

        StringBuilder sb = new StringBuilder("[");
        for (Map.Entry<Integer, Integer> entry : segments.entrySet()) {
            sb.append("[").append(entry.getKey()).append(",")
                .append(entry.getValue()).append("],");
        }
        sb.setLength(sb.length() - 1); // 移除最后一个逗号
        sb.append("]");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        // Here is an example sequence:
        // (data stored as an array of start point and value for each segment.)
        IntensitySegments segments = new IntensitySegments();
        segments.printString(); // Should be "[]"
        segments.add(10, 30, 1);
        segments.printString(); // Should be: "[[10,1],[30,0]]"
        segments.add(20, 40, 1);
        segments.printString(); // Should be: "[[10,1],[20,2],[30,1],[40,0]]"
        segments.add(10, 40, -2);
        segments.printString(); // Should be: "[[10,-1],[20,0],[30,-1],[40,0]]"

        // Another example sequence:
        IntensitySegments segments2 = new IntensitySegments();
        segments2.printString(); // Should be "[]"
        segments2.add(10, 30, 1);
        segments2.printString(); // Should be "[[10,1],[30,0]]"
        segments2.add(20, 40, 1);
        segments2.printString(); // Should be "[[10,1],[20,2],[30,1],[40,0]]"
        segments2.add(10, 40, -1);
        segments2.printString(); // Should be "[[20,1],[30,0]]"
        segments2.add(10, 40, -1);
        segments2.printString(); // Should be "[[10,-1],[20,0],[30,-1],[40,0]]"
    }

}