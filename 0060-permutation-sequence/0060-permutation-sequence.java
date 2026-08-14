class Solution {
    public String getPermutation(int n, int k) {
        int i=1,fact=1; k-=1;
        List<Integer> l=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for(i=1;i<=n;i++){
            l.add(i); fact*=i;
        }
        for(i=n;i>=1;i--){
            fact/=i;
            int x=k/fact;
            sb.append(l.get(x));
            l.remove(x);
            k%=fact;
        }
        return sb.toString();
    }
}