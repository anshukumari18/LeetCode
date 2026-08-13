class Solution {
    public boolean isMatch(String s, String p) {
        int i=0,j=0,si=-1,m=0;
        char S[]=s.toCharArray();
        char P[]=p.toCharArray();
        int ns=s.length();
        int np=p.length();
        while(i<ns){
            if(j<np&&(S[i]==P[j]||P[j]=='?')){
                j++;
                i++;
            }
            else if(j<np&&P[j]=='*'){
                si=j;
                m=i;
                j++;
            }
            else if(si!=-1){
                j=si+1;
                m++;
                i=m;
            }
            else{
                return false;
            }
        }
        while(j<np&&P[j]=='*'){
            j++;
        }
        return j==np;
    }
}