package com.francis.leetcode.p149_maxPoints;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n < 3) return n;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> record = new HashMap<>();
            int same = 0;
            for (int j = 0; j < n; j++) {
                if (same(points[i], points[j])) same++;
                else {
                    String slope = slope(points[i], points[j]);
                    record.put(slope, record.getOrDefault(slope, 0) + 1);
                }
            }
            ans = Math.max(ans, same);
            for (int value : record.values()) {
                ans = Math.max(value + same, ans);
            }
        }
        return ans;
    }

    private boolean same(int[] pa, int[] pb) {
        return pa[0] == pb[0] && pa[1] == pb[1];
    }

    private String slope(int[] pa, int[] pb) {
        int dy = pb[1] - pa[1];
        int dx = pb[0] - pa[0];
        if (dx == 0) return "1/0";
        if (dy == 0) return "0/1";
        int g = gcd(Math.abs(dx), Math.abs(dy));
        dy /= g;
        dx /= g;
        if (dx < 0) {
            dx = -dx;
            dy = -dy;
        }
        return dy + "/" + dx;
    }

    private int gcd(int a, int b) {
        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }

    @Test
    public void test() {
        int[][] points_1 = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println(maxPoints(points_1));

        int[][] points_2 = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        System.out.println(maxPoints(points_2));

        int[][] points_3 = {{40, -23}, {9, 138}, {429, 115}, {50, -17}, {-3, 80}, {-10, 33}, {5, -21}, {-3, 80}, {-6, -65}, {-18, 26}, {-6, -65}, {5, 72}, {0, 77}, {-9, 86}, {10, -2}, {-8, 85}, {21, 130}, {18, -6}, {-18, 26}, {-1, -15}, {10, -2}, {8, 69}, {-4, 63}, {0, 3}, {-4, 40}, {-7, 84}, {-8, 7}, {30, 154}, {16, -5}, {6, 90}, {18, -6}, {5, 77}, {-4, 77}, {7, -13}, {-1, -45}, {16, -5}, {-9, 86}, {-16, 11}, {-7, 84}, {1, 76}, {3, 77}, {10, 67}, {1, -37}, {-10, -81}, {4, -11}, {-20, 13}, {-10, 77}, {6, -17}, {-27, 2}, {-10, -81}, {10, -1}, {-9, 1}, {-8, 43}, {2, 2}, {2, -21}, {3, 82}, {8, -1}, {10, -1}, {-9, 1}, {-12, 42}, {16, -5}, {-5, -61}, {20, -7}, {9, -35}, {10, 6}, {12, 106}, {5, -21}, {-5, 82}, {6, 71}, {-15, 34}, {-10, 87}, {-14, -12}, {12, 106}, {-5, 82}, {-46, -45}, {-4, 63}, {16, -5}, {4, 1}, {-3, -53}, {0, -17}, {9, 98}, {-18, 26}, {-9, 86}, {2, 77}, {-2, -49}, {1, 76}, {-3, -38}, {-8, 7}, {-17, -37}, {5, 72}, {10, -37}, {-4, -57}, {-3, -53}, {3, 74}, {-3, -11}, {-8, 7}, {1, 88}, {-12, 42}, {1, -37}, {2, 77}, {-6, 77}, {5, 72}, {-4, -57}, {-18, -33}, {-12, 42}, {-9, 86}, {2, 77}, {-8, 77}, {-3, 77}, {9, -42}, {16, 41}, {-29, -37}, {0, -41}, {-21, 18}, {-27, -34}, {0, 77}, {3, 74}, {-7, -69}, {-21, 18}, {27, 146}, {-20, 13}, {21, 130}, {-6, -65}, {14, -4}, {0, 3}, {9, -5}, {6, -29}, {-2, 73}, {-1, -15}, {1, 76}, {-4, 77}, {6, -29}};
        System.out.println(maxPoints(points_3));
    }

}
