import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
/*

Basic idea is use map to save the fraction and its frequency, and traverse.
each time, use  (Y[i] - X[i]) / Y[i] as "target" to check if it is in map,
if we find target in map, we sum up the frequency,
otherwise we add it into map and continue traverse.

n is length if X or Y
Time O(n)
Space O(n)
*/

class Solution {
    public static void main(String[] args) {

    }
    public int solution(int[] X, int[] Y) {
        // write your code in Java SE 8
        // corner cases

        if (X == null || Y == null || X.length != Y.length) throw new IllegalArgumentException("input invalid!");

        // base cannot be 0
        for (int n : Y) {
            if (n == 0)
                throw new IllegalArgumentException("input invalid!");
        }

        // in case Integer overflow
        int mod = (int)1e9 + 7;
        int res = 0;

        // use hashmap to save the fraction and its frequency
        // key is the fraction
        // value is the occurrence or times this particular fraction we found
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < X.length; i++) {
            int g = gcd(X[i], Y[i]);

            // num is the fraction, for example 1/3
            String num = X[i] / g + "/" + Y[i] / g;
            // we are looking for 2 fractions sum up to 1
            // we alread have one, which is X[i] / Y[i]
            // the another one should be (Y[i] - X[i]) / Y[i]
            // up is the numerator of another fraction we are looking for
            String up = Y[i]/g - X[i]/g + "";
            // base of the fraction
            String bot = Y[i] / g + "";
            // X[i]/Y[i] + target = 1
            // target is the another fraction we looking for
            String target = up + "/" + bot;

            // if map contains target, we know that we can  get a sum == 1
            if (map.containsKey(target)) {
                res = (res + map.get(target)) % mod;
            }
            // otherwise, we just add it into map, continue looking for
            // two fractions which can sum to 1
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return res;
    }

    // get the common factor of two value
    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}
