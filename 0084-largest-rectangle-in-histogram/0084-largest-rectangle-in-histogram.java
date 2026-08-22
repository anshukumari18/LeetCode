class Solution {
    public int largestRectangleArea(int[] h) {
        int ans= -1;
        Stack<Integer> s= new Stack<>();
        for(int i=0; i<h.length; i++){
        while(!s.isEmpty()&& h[i]<h[s.peek()] ){
            int element= s.pop();
int pse= s.isEmpty()? -1: s.peek();
int nse=i;
            ans= Math.max(ans,h[element]*(nse-pse-1));
        }
        s.push(i);
        }
        while(!s.isEmpty()){
            int nse= h.length;
             int element= s.pop();
            int pse=  s.isEmpty()? -1: s.peek();
            ans= Math.max(ans,h[element]*(nse-pse-1));
        }


        return ans;
    }
}
//traverse in one direc using loop and in other using 
//stack . when poping u get the pse and i is ur nse
// can find area and if st has vlaues means nse is n now 
//can go for pse