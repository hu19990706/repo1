import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class bbb {
    /*public static void main(String[] args) {
       char a = 'A';
       int b=a-64;
        System.out.println(b);
    }*/
    /*public static void main(String[] args) {
        String s = "HAC5S8D8C10";
        char c[] = s.toCharArray();
        //HashMap<Character,Integer> map = new HashMap<>();
        ArrayList<Character> color = new ArrayList<>();
        ArrayList<Integer> score = new ArrayList<>();
        for (int i=c.length-1;i>=0;i=i-2){
            if (c[i]=='0'){
                color.add(c[i-2]);
                score.add(10);
                i--;
                continue;
            }
            String s1 = String.valueOf(c[i]);
            switch (c[i]){
                case 'A' : s1="1";break;
                case 'J' : s1="10";break;
                case 'Q' : s1="10";break;
                case 'K' : s1="10";break;
            }
            color.add(c[i-1]);
            score.add(Integer.parseInt(s1));
        }

        for (int j=0;j<color.size();j++) {
            System.out.println(color.get(j)+":"+score.get(j));
        }
    }*/

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //数组长度
        int k;
        System.out.println("请输入数组长度");
        Scanner in=new Scanner(System.in);
        k=in.nextInt();
        int a[]=new int[k];
        //输入数组的元素
        System.out.println("输入数组的元素");
        for(int i=0;i<k;i++){
            int n;
            n=in.nextInt();
            a[i]=n;
        }
        int m = 0;
        int max = 0;
        int g=0;
        int l;
        l=2*k;
        //循环定义b数组长度为a的两倍
        int b[]=new int[l];
        for(int e=0;e<l;e++){
            if(e!=k){
                b[e]=a[e];
            }
            if(e==k){
                for(int r=0;r<k;r++){
                    b[r+k]=a[r];
                    e++;
                }
            }
        }
        //计算子数组和的最大值
        int s=0;
        int j;
        for(j=0;j<k+s;j++){
            m+=b[j];
            if(m>max){
                max=m;
            }
            if(j==k-1+s){
                s++;
                if(s<k){
                    j=s-1;
                    m=0;
                }
                else
                    break;
            }

        }
        System.out.println("数组的最大子数组的和为："+max);


    }

}
