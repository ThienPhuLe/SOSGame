public class Pair {
    int r;
    int c;
    Pair(int aR, int aC) {
        this.r = aR;
        this.c = aC;
    }

    public int getR(){
        return r;
    }

    public int getC(){
        return c;
    }

    public Pair add(Pair other)
    {
        return new Pair(r + other.getR(), c + other.getC());
    }

    public Pair sub(Pair other)
    {
        return new Pair(r - other.getR(), c - other.getC());
    }
}
