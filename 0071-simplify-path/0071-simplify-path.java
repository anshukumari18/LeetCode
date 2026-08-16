class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
// Example: /.../a/../b/c/../d/./
        String[] arr = path.split("/");
//Split result: ["", "...", "a", "..", "b", "c", "..", "d", ".", ""]

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("") || arr[i].equals(".")) continue;
            else if (arr[i].equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(arr[i]);
            }
        }

        StringBuilder res = new StringBuilder();
        for (String s : stack) {
            res.append("/").append(s);
        }

        return res.isEmpty() ? "/" : res.toString();
    }
}