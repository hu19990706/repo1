import java.util.Iterator;

public class aaa {
    public static void main(String[] args) {
        int i = 10;
        switch (i){
            case 0:
                System.out.println("执行case0");
                break;
            case 5:
                System.out.println("执行case5");
            case 10:
                System.out.println("执行case10");
            default:
                System.out.println("执行default");
        }

        int[] arr = {1,3,5};
        System.out.println(arr[0]);
        change(arr);
        System.out.println(arr[0]);


        int a = 1;
        int b = 2;
        System.out.println(a);
        System.out.println(b);
        change(a, b);
        System.out.println(a);
        System.out.println(b);

        
    }

    public int a(){
        if (3>2)
        return 1;
        System.out.println("ss");
        return 2;
    }

    public static void change(int[] arr) {
        arr[0] = 200;
    }

    public static void change(int a, int b) {
        a = a + b;
        b = b + a;
    }

}
