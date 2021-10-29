
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Poker {
    static Pattern r1 = Pattern.compile("[2-9AJQK]");
    static Pattern r2 = Pattern.compile("[HSCD]");

    public static void main(String[] args) throws Exception {
        ArrayList<String> leonWin = new ArrayList<>();  //个人获胜记录
        ArrayList<String> judyWin = new ArrayList<>();

        FileReader fileReader = new FileReader("D:\\poker.txt");  //读取比赛结果记录
        BufferedReader br = new BufferedReader(fileReader);
        String line=null;
        while((line=br.readLine())!=null){    //遍历每一场比赛
            Person leon =new Person();  //每场比赛个人（手牌和点数）
            Person judy =new Person();

            String split[] = line.split(";");
            flag:for (int s=0;s<split.length;s++  //每场比赛两副牌
                 ) {
                char c[] = split[s].toCharArray();
                if (c.length<10||c.length>14) {
                    break;  //丢弃不完整数据（牌多牌少）
                }
                ArrayList<Integer> score = new ArrayList<>();  //每张牌点数
                ArrayList<Character> color = new ArrayList<>(); //每张牌花色
                ArrayList<IsPoker> list = new ArrayList<>();  //手牌
                for (int i=c.length-1;i>=0;i=i-2){  //从后开始分割每一副扑克牌
                    IsPoker isPoker;
                    if (c[i]=='0'){  //检测到点数为10
                        color.add(c[i-2]);
                        score.add(10);
                        isPoker = new IsPoker(c[i-2],10);
                        list.add(isPoker);
                        i--;
                        continue;
                    }
                    String s1 = String.valueOf(c[i]); //其他牌面点数
                    String s2 = String.valueOf(c[i-1]);
                    String s3 = String.valueOf(c[i]);
                    Matcher m1 =r1.matcher(s1);
                    Matcher m2 =r2.matcher(s2);
                    if (!m1.find()||!m2.find()) {  //点数和花色不对
                        break flag;
                    }
                    switch (c[i]){
                        case 'A' : s1="1";s3="1";break;
                        case 'J' : s1="10";s3="11";break;
                        case 'Q' : s1="10";s3="12";break;
                        case 'K' : s1="10";s3="13";break;
                    }
                    isPoker = new IsPoker(c[i-1],Integer.parseInt(s3));
                    color.add(c[i-1]);
                    score.add(Integer.parseInt(s1));
                    list.add(isPoker);
                }
                if (color.size()!=5) break ;  //去掉少牌和多牌
                List<List<Integer>> res = new ArrayList<>();
                List<Integer> temp =new ArrayList<>();
                dfs(res,temp,score,0);  //求每幅牌的子数组
                int num=0;//最终整幅牌的点数
                for (int i = 0; i <res.size() ; i++) {
                    if (res.get(i).size()!=3){
                        continue;
                    }
                    int sum=res.get(i).get(0)+res.get(i).get(1)+res.get(i).get(2);
                    if (sum%10==0){  //有
                        score.remove(res.get(i).get(0));
                        score.remove(res.get(i).get(1));
                        score.remove(res.get(i).get(2));
                        num=score.get(0)+score.get(1);
                        if (num>10){
                            num-=10;
                        }
                        break;
                    }
                }

                if (s==0){
                    leon.setIsPoker(list);
                    leon.setSum(num);
                }else {
                    judy.setIsPoker(list);
                    judy.setSum(num);

                }
            }

            //比较两副牌大小
            if(leon.getIsPoker()!=null&&judy.getIsPoker()!=null) {
                 //System.out.println(leon.getIsPoker().size()+judy.getIsPoker().size()+"-"+leon+";"+judy);
                if (leon.getSum() > judy.getSum()) {  //总点数
                    leonWin.add(line);
                } else if (leon.getSum() == judy.getSum()) {
                    Collections.sort(leon.getIsPoker());
                    Collections.sort(judy.getIsPoker());
                    for (int i = 0; i < 5; i++) {
                        if (leon.getIsPoker().get(i).getScore() > judy.getIsPoker().get(i).getScore()) { //单牌点数
                            leonWin.add(line);
                            break;
                        } else if (leon.getIsPoker().get(i).getScore() == judy.getIsPoker().get(i).getScore()) {
                            int a = leon.getIsPoker().get(i).getScore() - 65; //s-18，h-7,c-2,d-3;黑红梅方
                            int b = judy.getIsPoker().get(i).getScore() - 65;
                            if (a == 2) a += 2;  //梅花牌变成比方块大
                            if (b == 2) b += 2;
                            if (a > b) { //花色
                                leonWin.add(line);
                                break;
                            } else if (a < b) {
                                judyWin.add(line);
                                break;
                            }
                        }else judyWin.add(line);
                    }
                }else judyWin.add(line);
            }

        }
        br.close();
        fileReader.close();

        //输出
        BufferedWriter bw1 = new BufferedWriter(new FileWriter("d:\\leon.txt"));
        BufferedWriter bw2 = new BufferedWriter(new FileWriter("d:\\judy.txt"));
        for (String s:leonWin
             ) {
            bw1.write(s);
            bw1.newLine();
        }
        for (String s:judyWin
        ) {
            bw2.write(s);
            bw2.newLine();
        }
        bw1.close();
        bw2.close();

    }

    static void dfs(List<List<Integer>> res, List<Integer> temp, ArrayList<Integer> nums, int j){
        res.add(new ArrayList<>(temp));
        for (int i = j; i < nums.size() ; i++) {
            temp.add(nums.get(i));
            dfs(res,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
