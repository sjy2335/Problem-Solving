class Solution {
    public int solution(String s) {
        char[] arr = s.toCharArray();
        int max = 1;
        
        for (int mid = 1; mid < arr.length - 1; mid++) {
            int left = mid - 1;
            int right = mid + 1;
            while (left >= 0 && right < arr.length && arr[left] == arr[right]) {
                left--;
                right++;
            }
            max = Math.max(max, right - left - 1);
        }
        
        for (int mid = 1; mid < arr.length; mid++) {
            int left = mid - 1;
            int right = mid;
            while (left >= 0 && right < arr.length && arr[left] == arr[right]) {
                left--;
                right++;
            }
            max = Math.max(max, right - left - 1);
        }
        System.out.println(max);
        
        return max;
    }
}