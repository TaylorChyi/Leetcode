package test;
import java.util.Arrays;

public class test28 {

    public static void main(String[] args) {
        String[] patterns = {
            // "abababca",
            // "abcabcabc",
            "abbaabb",//
            "abcdabc",
            "aabaaab",//
            "abcde",
            "aaaaa",
            "a",
            "ab",
            "aab"
        };

        for (String pattern : patterns) {
            int[] next1 = getNext(pattern);

            int[] next2 = getNext2(pattern);
            Arrays.stream(next1).forEach(n -> System.out.print(n));
            System.out.println();
            Arrays.stream(next2).forEach(n -> System.out.print(n));
            System.out.println("\n=====");
        }
    }

    public int strStr(String haystack, String needle) {
        int[] next = getNext(needle);
        Arrays.stream(next).forEach(System.out::println);
        int index = 0;
        for (int j = 0; j < haystack.length(); j++) {
            while (index > 0 && needle.charAt(index) != haystack.charAt(j)) {
                index = next[index-1];
            }

            while (index < needle.length() && j < next.length && haystack.charAt(j) == needle.charAt(index)) {
                index++;
                j++;
            }
            System.out.println(index);
            System.out.println(j);
            System.out.println("-----");

            if (index == needle.length()) {
                System.out.println("======");
                System.out.println(j - index);
                return j - index;
            }
        }

        return -1;
    }

    public static int[] getNext(String needle) {
        // "aabaaab",//
        // "abbaabb",//

        int index = 0;
        int[] next = new int[needle.length()];
        next[0] = 0;
        for (int j = 1; j < needle.length(); j++) {
            if (needle.charAt(index) == needle.charAt(j)) {
                index++;
                next[j] = index;
            }
            else {
                if (index == 0) {
                    next[j] = 0;
                }
                else {
                    index = next[index-1];
                    j--;
                }
                
            }
            
        }
        return next;
    }

    public static int[] getNext2(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = 0;
        int i = 0, j = 1;
        while (j < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                i++;
                next[j] = i;
                j++;
            } else if (i == 0) {
                next[j] = 0;
                j++;
            } else {
                i = next[i - 1];
            }
        }
        return next;
    }


}
