package com.example.test.StringTips;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        //printDistinctCharsWithCountMerge("abcedacbde");
        //reverseInputString("1234");
        checkPalindromeString("1234  4321");
    }

    //在字符串中获取不同的字符及其数量
    private static void printDistinctCharsWithCountMerge(String input) {
        Map<Character, Integer> charsWithCountMap = new LinkedHashMap<>();

        for (char c : input.toCharArray()) {
            charsWithCountMap.merge(c, 1, Integer::sum);
        }
        System.out.println(charsWithCountMap);
    }

    //反转字符串
    private static void reverseInputString(String input) {
        StringBuilder sb = new StringBuilder(input);
        String result = sb.reverse().toString();
        System.out.println(result);
    }

    //判断一个字符串是前后对称的
    private static void checkPalindromeString(String input) {
        boolean result = true;
        int length = input.length();
        for (int i = 0; i < length / 2; i++) {
            if (input.charAt(i) != input.charAt(length - i - 1)) {
                result = false;
                break;
            }
        }
        System.out.println(input + " 对称吗？ " + result);
    }

    //删除所有出现的指定字符
    private static void removeCharFromString(String input, char c) {
        String result = input.replaceAll(String.valueOf(c), "");
        System.out.println(result);
    }

    //统计字符串中的单词数
    private static void countNumberOfWords(String line) {
        String trimmedLine = line.trim();
        int count = trimmedLine.isEmpty() ? 0 : trimmedLine.split("\\s+").length;

        System.out.println(count);
    }

    //检查两个字符串中的字符是相同的
    private static void sameCharsStrings(String s1, String s2) {
        Set<Character> set1 = s1.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        System.out.println(set1);
        Set<Character> set2 = s2.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        System.out.println(set2);
        System.out.println(set1.equals(set2));
    }

    //检查字符串中只包含数字
    private static void digitsOnlyString(String string) {
        if (string.matches("\\d+")) {
            System.out.println("只包含数字的字符串：" + string);
        }
    }
}
