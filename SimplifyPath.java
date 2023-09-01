import java.util.Stack;
public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");
        for (String component : components) {
            if (component.equals(".") || component.isEmpty()) {
                continue;
            } else if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(component);
            }
        }
        StringBuilder simplifiedPath = new StringBuilder();
        for (String dir : stack) {
            simplifiedPath.append("/").append(dir);
        }
        return simplifiedPath.length() > 0 ? simplifiedPath.toString() : "/";
    }
    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        String path = "/a/./b/../../c/";
        String simplified = simplifyPath.simplifyPath(path);
        System.out.println(simplified);
    }
}
