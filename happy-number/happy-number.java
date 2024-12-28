class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        seen.add(n);
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        
        while(!stack.isEmpty()){
            int k = stack.pop();
            if (k == 1) return true;
            
            int sum = 0;
            
            while(k > 0){
                sum += (k % 10) * (k % 10);
                k = k / 10;
            }
            
            if (seen.contains(sum)) return false;
            seen.add(sum);
            stack.push(sum);
        }
        
        return false;
    }
}