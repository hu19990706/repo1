import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Find {
    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader("D:\\ddd.txt");//文本存放Heaviest Prime Words
        BufferedReader br = new BufferedReader(fileReader);
        String line = null;

        HashMap<Integer,String> map = new HashMap<>();
        ArrayList<Integer> l = new ArrayList<>();

        while ((line = br.readLine())!=null) {
            line=line.trim();  //去掉每行前后空格
            if("".equals(line)) continue; //跳过换行
            String[] split = line.split(" "); //分割单词

            for (String s:split
                 ) {
                int sum=0;
                String a=s.toUpperCase();  //大小字母重量相同，变为大写字母
                char b[]=a.toCharArray();

                for (char i:b //计算单词重量
                     ) {
                    int j=i-65;
                    if(j>=0&&j<=25)  //字符不计重量，去掉
                        sum+=(j);
                }
                if(IsPrime(sum)) {  //取重量单词
                    l.add(sum);
                    map.put(sum,s);  //原素数单词及其重量
                }
            }
        }
        br.close();

        Collections.sort(l);
        for (int i=l.size()-1;i>l.size()-4;i--){
            System.out.println(map.get(l.get(i)));
        }

    }


    static boolean IsPrime(int n){
        if (n%2==0)
            return false;

        for (int i=3;i<=Math.sqrt(n);i+=2){
            if(n%i==0)
                return false;
        }
        return true;
    }
}
