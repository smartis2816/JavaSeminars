package seminar_4;

import java.util.Stack;

public class SimplifyPath71 {
    public String simplifyPath(String path) {
        Stack<String> dir = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String[] newArr = path.split("/");
        for (String token : newArr) {
            if ("".equals(token) || ".".equals(token)) {
                continue;
            }
            if ("..".equals(token)) {
                if (!dir.isEmpty()) {
                    dir.pop();
                }
            } else {
                dir.push(token);
            }
        }
        if (dir.isEmpty()) return "/";
        while (!dir.isEmpty()) {
            sb.insert(0, dir.pop());
            sb.insert(0, "/");
        }
        return sb.toString();
    }
}
