package arraysAndHashing;

import java.util.*;

public class ArraysAndHashing {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        for (Integer x : nums) {
            if (visited.contains(x)) return true;
            visited.add(x);
        }
        return false;
    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> sFreq = new HashMap<>();
        Map<Character, Integer> tFreq = new HashMap<>();
        for (Character c : s.toCharArray()) {
            Integer count = sFreq.getOrDefault(c, 0);
            sFreq.put(c, count + 1);
        }
        for (Character c : t.toCharArray()) {
            Integer count = tFreq.getOrDefault(c, 0);
            tFreq.put(c, count + 1);
        }
        if (sFreq.size() != tFreq.size()) return false;
        for (Map.Entry<Character, Integer> e : sFreq.entrySet()) {
            if (!tFreq.containsKey(e.getKey()) || !tFreq.get(e.getKey()).equals(e.getValue())) {
                return false;
            }
        }
        return true;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> compMap = new HashMap<>();
        int[] out = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (compMap.containsKey(nums[i])) {
                out[0] = compMap.get(nums[i]);
                out[1] = i;
                break;
            } else {
                compMap.put(complement, i);
            }
        }
        return out;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        // runtime: O(n)
        for (String s : strs) {
            // runtime: O(1), since m is 26 (we assume only lowercase english letters)
            char[] sChars = s.toCharArray();
            // runtime: typically O(mlogm), but since m is finite at 26, O(1).
            Arrays.sort(sChars);
            anagrams.computeIfAbsent(new String(sChars), k -> new ArrayList<String>()).add(s);
        }
        return new ArrayList<>(anagrams.values());
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // map(k: num, v: freq)
        // O(n) time and space to populate
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.merge(n, 1, Integer::sum);
        }

        // priority queue(entry)
        // O(nlogk) time and O(k) space
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                Map.Entry.comparingByValue()
        );
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            pq.offer(e);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            if (!pq.isEmpty()) {
                topK[i] = pq.poll().getKey();
            }
        }
        return topK;
    }

    public static int[] productExceptSelf(int[] nums) {
        // We want to calculate the prefix and suffix product for a given
        // element in nums. Calculate product from 0->n-1, then calculate
        // product from n-1->0 to maintain O(n) runtime, and apply each
        // update to the output array to keep O(1) space.
        int n = nums.length;
        int[] answer = new int[n];
        Arrays.fill(answer, 1); // base case for multiplication: 1 * x = x
        int current = 1;

        // calculate prefix product
        for (int i = 0; i < n; i++) {
            answer[i] *= current;
            current *= nums[i];
        }

        current = 1;

        // calculate suffix product
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= current;
            current *= nums[i];
        }

        return answer;
    }

    public static int[] sumExceptSelf(int[] nums) {
        // We want to calculate the prefix and suffix sum for a given
        // element in nums. Calculate sum from 0->n-1, then calculate sum
        // from n-1->0 to maintain O(n) runtime, and apply each update to
        // the output array to keep O(1) space, not including the output.
        int n = nums.length;
        int[] answer = new int[n];
        Arrays.fill(answer, 0); // addition's base case is 0 + x = x
        int current = 0;

        // calculate prefix sum
        for (int i = 0; i < n; i++) {
            answer[i] += current;
            current += nums[i];
        }
        current = 0;

        // calculate suffix sum
        for (int i = n - 1; i >= 0; i--) {
            answer[i] += current;
            current += nums[i];
        }
        return answer;
    }
}
