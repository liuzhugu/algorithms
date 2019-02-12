package struct;

/**
 * 位图
 * */
public class BitMap {
    private int nbits;
    private char[] bytes;

    public BitMap(int nbits) {
        this.nbits = nbits;
        bytes = new char[nbits/8+1];
    }

    public void set(int k){
        if (k>nbits) {
            return;
        }
        int index = k / 8;
        bytes[index] |= 1 << (k % 8);
    }

    public boolean get(int k){
        if (k>nbits) {
            return false;
        }
        int index = k / 8;
        return (bytes[index] & 1 << (k % 8)) != 0;
    }

}
