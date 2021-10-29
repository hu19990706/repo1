public class IsPoker implements Comparable<IsPoker>{
    private char color;
    private int score;

    IsPoker(){

    }
    IsPoker(char color,int score){
        this.color=color;
        this.score=score;
    }

    public char getColor() {
        return color;
    }


    public void setColor(char color) {
        this.color = color;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "IsPoker{" +
                "color=" + color +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(IsPoker isPoker) {
        return isPoker.getScore()-this.getScore();
    }
}
