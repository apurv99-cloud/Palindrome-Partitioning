#  Backtracking Deep Dive  
### Palindrome Partitioning & Subsets II (Duplicate Handling)

This repository contains two classic backtracking problems that helped me deeply understand recursion trees, decision making, and duplicate handling strategies.

Both problems look similar at first glance — but their internal decision logic differs significantly.

---

#  1️ Palindrome Partitioning

##  Problem Statement

Given a string `s`, partition `s` such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of `s`.

---

##  Core Idea

At each index:

- Cut the string
- Check if left substring is palindrome
- If valid → Recurse on remaining string
- Backtrack after exploration

This is a **Partition-style Backtracking** problem.

---

##  Java Implementation

```java
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start,
                           List<String> temp,
                           List<List<String>> result) {

        if(start == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start; i < s.length(); i++) {
            if(isPalindrome(s, start, i)) {
                temp.add(s.substring(start, i + 1));
                backtrack(s, i + 1, temp, result);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
```

---

#  2️ Subsets II (Handling Duplicates)

##  Problem Statement

Given an integer array `nums` that may contain duplicates, return all possible subsets (power set).

The solution set must not contain duplicate subsets.

---

##  Core Idea

- Sort the array first
- At each step:
  - Include element
  - Recurse
  - Backtrack
- Skip duplicates at the same recursion level

This is a **Combination-style Backtracking** problem.

---

##  Java Implementation

```java
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start,
                           List<Integer> temp,
                           List<List<Integer>> result) {

        result.add(new ArrayList<>(temp));

        for(int i = start; i < nums.length; i++) {

            if(i > start && nums[i] == nums[i - 1]) continue;

            temp.add(nums[i]);
            backtrack(nums, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}
```

---

#  Comparison: Partition vs Combination Backtracking

| Feature | Palindrome Partitioning | Subsets II |
|----------|------------------------|------------|
| Input Type | String | Integer Array |
| Decision Type | Cut substring | Include/Skip element |
| Validation Required | Palindrome check | Duplicate check |
| Sorting Needed | No | Yes |
| Recursion Style | Partition-based | Combination-based |

---

#  Recursion Tree Insight

Both problems:

- Use a decision tree structure
- Follow: Choose → Recurse → Backtrack
- Explore all possible valid paths
- Require careful pruning (Palindrome check / Duplicate skip)

But:

- **Palindrome Partitioning** focuses on validating substrings.
- **Subsets II** focuses on avoiding duplicate subset generation.

---

#  Time Complexity

Both problems have exponential complexity:

- **Time:** O(2^n) (or more depending on branching)
- **Space:** O(n) recursion stack (excluding output)

---

#  Key Learnings

- Importance of recursion tree visualization
- Difference between partition-style and combination-style backtracking
- Why sorting is critical for duplicate handling
- How small logic differences create entirely different recursion behaviors

---

# 🏷 Tags

`Backtracking` `Recursion` `Duplicate Handling`  
`Partitioning Problems` `Combinations` `Power Set`


