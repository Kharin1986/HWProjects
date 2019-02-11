package HW_5_Thread;


public class MyArrays {
    private float[] arrayBefore;
    private float[] arrayFirstHalf;
    private float[] arraySecondHalf;
  //  private int size;
  //  private int newSize;

    public MyArrays(float[] arrayBefore, float[] arrayFirstHalf, float[] arraySecondHalf) {
        this.arrayBefore = arrayBefore;
        this.arrayFirstHalf = arrayFirstHalf;
        this.arraySecondHalf = arraySecondHalf;

    }

    public void init(float testArr[]){
        for (int i = 0; i <testArr.length; i++) {
            testArr[i]=1f;
        }

    }
    public void splitArray(int newSize){
        System.arraycopy(arrayBefore, 0, arrayFirstHalf, 0, newSize);
        System.arraycopy(arrayBefore, newSize, arraySecondHalf, 0, newSize);
    }

    public void spliceArray(int exSize){
        System.arraycopy(arrayFirstHalf, 0, arrayBefore, 0, exSize);
        System.arraycopy(arraySecondHalf, 0, arrayBefore, exSize, exSize);
    }

    public void calcSomeFunction(float testArr[],int shift){ //shift - т.к. индексы во второй половине идут с нуля
        for (int i = 0; i <testArr.length; i++) {
            testArr[i] = (float)(testArr[i] * Math.sin(0.2f + (i+shift) / 5) * Math.cos(0.2f + (i+shift) / 5) * Math.cos(0.4f + (i+shift) / 2));
        }
    }

    public float[] getArrayBefore() {
        return arrayBefore;
    }

    public float[] getArrayFirstHalf() {
        return arrayFirstHalf;
    }

    public float[] getArraySecondHalf() {
        return arraySecondHalf;
    }

}
