package _2021;

public class Counter{
    private int zero;
    private int one;

    Counter(){
        zero = 0;
        one = 0;
    }

    public int getZero() {
        return zero;
    }

    public void setZero(int zero) {
        this.zero = zero;
    }

    public int getOne() {
        return one;
    }

    public void incrementZero(){
        this.zero= this.zero+1;
    }

    public void incrementOne(){
        this.one= this.one+1;
    }

    public void setOne(int one) {
        this.one = one;
    }
}
