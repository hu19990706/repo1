import java.util.ArrayList;

public class Person {
    private ArrayList<IsPoker> isPoker;
    private int sum;

    public ArrayList<IsPoker> getIsPoker() {
        return isPoker;
    }

    public void setIsPoker(ArrayList<IsPoker> isPoker) {
        this.isPoker = isPoker;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Person{" +
                "isPoker=" + isPoker +
                ", sum=" + sum +
                '}';
    }
}
