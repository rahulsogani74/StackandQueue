import java.util.*;
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int n = heights.length;
        int[] ps = previousSmaller(heights);
        int[] ns = nextSmaller(heights);

        for (int i = 0; i < n; i++) {
            int curr = (ns[i] - ps[i] - 1) * heights[i];
            res = Math.max(res, curr);
        }
        return res;
    }
    public int[] previousSmaller(int[] heights) {
        int[] ans = new int[heights.length];
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            int ele = (st.isEmpty()) ? -1 : st.peek();
            ans[i] = ele;
            st.push(i);
        }
        return ans;
    }
    public int[] nextSmaller(int[] heights) {
        int[] ans = new int[heights.length];
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            int ele = (st.isEmpty()) ? n : st.peek();
            ans[i] = ele;
            st.push(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        LargestRectangleInHistogram solution = new LargestRectangleInHistogram();
        int[] heights = {2, 1, 5, 6, 2, 3};
        int maxArea = solution.largestRectangleArea(heights);
        System.out.println("Maximum Rectangle Area: " + maxArea);
    }
}
