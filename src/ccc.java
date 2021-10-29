import java.util.ArrayList;
import java.util.List;

public class ccc {
    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp =new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(10);
        nums.add(5);
        nums.add(10);
        nums.add(3);
        dfs(res,temp,nums,0);
        System.out.println(res);
        System.out.println(res.size());
        for (int i = 0; i <res.size() ; i++) {
            if (res.get(i).size()!=3){
                res.remove(res.get(i));
                i--;
            }

        }
        System.out.println(res);
        System.out.println(res.size());

    }
    static void dfs(List<List<Integer>> res, List<Integer> temp, List<Integer> nums, int j){
        res.add(new ArrayList<>(temp));
        for (int i = j; i < nums.size() ; i++) {
            temp.add(nums.get(i));
            dfs(res,temp,nums,i+1);
            //Integer lastElement = temp.get(temp.size()-1);
            temp.remove(temp.size()-1);

        }
    }
}
