public class ddd {
    public static void main(String[] args) {
        System.out.println(test1(3,5,100,10));
    }

    /*小牛牛为了向他的父母表现他已经长大独立了,他决定搬出去自己居住一段时间。
    一个人生活增加了许多花费: 牛牛每天必须吃一个水果并且需要每天支付x元的房屋租金。
    当前牛牛手中已经有f个水果和d元钱,牛牛也能去商店购买一些水果,商店每个水果售卖p元。
    牛牛为了表现他独立生活的能力,希望能独立生活的时间越长越好,牛牛希望你来帮他计算一下他最多能独立生活多少天。
    输入包括一行,四个整数x, f, d, p(1 <= x,f,d,p <= 2 * 10^9),以空格分割
    输出一个整数, 表示牛牛最多能独立生活多少天。
    */
    public static int test1(int x,int f,int d,int p){
        int sum = 0;
        if (f>0){
            if(d/x>=f){
                sum=f+(d-f*x)/(x+p);
            }else{
                sum=d/x;
            }
        }else{
            sum=d/(x+p);
        }
        return sum;
    }
}
