package com.watermelon.dp;

import java.util.LinkedList;

/**
 * <h1>DecodeString</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/12
 */
public class DecodeString {

    /**
     * 解码字符串
     * 输入格式为：k[encoded_string]，其中方括号内部的 encoded_string 正好重复 k 次
     * 例如：输入 "3[a2[c]]"，输出 "accaccacc"
     *
     * @param s 需要解码的字符串
     * @return 解码后的字符串
     */
    public String decodeString(String s) {
        // 用于存储解码后的结果
        StringBuilder res = new StringBuilder();
        // 用于存储数字(即重复次数)
        int multi = 0;
        // 存储所有的重复次数
        LinkedList<Integer> stack_multi = new LinkedList<>();
        // 存储所有的中间结果
        LinkedList<String> stack_res = new LinkedList<>();

        for(Character c : s.toCharArray()) {
            if(c == '[') {
                // 遇到左括号，将当前的multi和res入栈
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            }
            else if(c == ']') {
                // 遇到右括号，出栈并计算重复字符串
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for(int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast() + tmp);
            }
            else if(c >= '0' && c <= '9') {
                // 遇到数字，计算重复次数;之所以乘10是因为可能有连续数字
                multi = multi * 10 + Integer.parseInt(c + "");
            }
            else {
                // 遇到字母，直接添加到结果中
                res.append(c);
            }
        }
        return res.toString();
    }

}