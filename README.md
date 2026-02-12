#  Palindrome Partitioning (Java - Backtracking)

##  Overview

This project implements the **Palindrome Partitioning** problem using  
Recursion and Backtracking in Java.

Given a string `s`, the goal is to partition the string such that every
substring of the partition is a palindrome.

The program returns **all possible palindrome partition combinations**.

---

##  Problem Statement

Given a string `s`, partition `s` such that every substring of the partition
is a palindrome.

Return all possible palindrome partitioning of `s`.

---


---

##  Approach

This solution uses:

- Recursion
- Backtracking
- Partition Logic
- Two Pointer Technique (for palindrome checking)

###  Algorithm Steps

1. Start from index `0`
2. Try every possible substring from current index
3. Check if the substring is a palindrome
4. If yes:
   - Add it to current list
   - Recursively call for remaining string
5. Backtrack by removing the last added substring
6. Repeat until all combinations are explored

---

##  Implementation

```java
import java.util.*;

public class PalindromePartitioning {

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(String s, int start,
                                  List<String> current,
                                  List<List<String>> result) {

        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int end = start; end < s.length(); end++) {

            if (isPalindrome(s, start, end)) {

                current.add(s.substring(start, end + 1));

                backtrack(s, end + 1, current, result);

                // Backtracking step
                current.remove(current.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }
}

