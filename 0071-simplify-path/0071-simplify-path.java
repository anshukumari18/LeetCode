class Solution {
    public String simplifyPath(String path) {
      String[] parts=path.split("/");
      StringBuilder spath=new StringBuilder();
       for(String part: parts){
           if(part.isEmpty() || part.equals(".")){
               continue;
           }
           else if(part.equals("..")){
               if(spath.length()>0){
                   int lastindex=spath.lastIndexOf("/");
                   spath.delete(lastindex,spath.length());
               }
           }
           else{
               spath.append("/").append(part);
           }
       }  
       if(spath.length()==0){
           spath.append("/");
       }
       return spath.toString();
    }
}