import java.util.Arrays;
import java.util.List;
 
public class Problem {
    public static void main(String args[]) {
        String[] arr = { "Analytics", "Geometry", "Greedy", "DynamicPlanning", "Graph" };
        List<String> list = Arrays.asList(arr);
        for (String s : list) {
            System.out.println(s);
        }
    } 
}