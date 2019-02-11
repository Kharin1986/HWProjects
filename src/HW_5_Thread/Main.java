package HW_5_Thread;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];
    static float[] arr1 = new float[h];
    static float[] arr2 = new float[size-h];
    static long a;
    static long b;


    static class MyThread extends Thread {
        private int index;
        private  MyArrays myArr;
        MyThread(MyArrays myArr, int index){
            this.myArr=myArr;
            this.index = index;
        }
        @Override
        public void run() {
            if(index==1){
                myArr.calcSomeFunction(myArr.getArrayFirstHalf(),0);
            }
            if (index==2){
                myArr.calcSomeFunction(myArr.getArraySecondHalf(),h);
            }
        }
    }


    public static void main(String[] args) {
        // Пересчет без разбиения
        MyArrays myArrays = new MyArrays(arr,arr1,arr2);
        myArrays.init(myArrays.getArrayBefore());
         a = System.currentTimeMillis();
         myArrays.calcSomeFunction(myArrays.getArrayBefore(),0);
         b=System.currentTimeMillis()-a;
        System.out.println("Время пересчета целого массива "+b+" милисекунд");
        // Пересчет с разбиением
        MyArrays myArrays2 = new MyArrays(arr,arr1,arr2);
        myArrays2.init(myArrays2.getArrayBefore());
        a = System.currentTimeMillis();
        myArrays2.splitArray(h);

        MyThread thread1 = new MyThread(myArrays2,1);
        thread1.start();
        MyThread thread2 = new MyThread(myArrays2,2);
        thread2.start();

        try{
            thread1.join();
        }
        catch(InterruptedException e){

            System.out.printf("%s has been interrupted", thread1.getName());
        }

        try{
            thread2.join();
        }
        catch(InterruptedException e){

            System.out.printf("%s has been interrupted", thread2.getName());
        }

        myArrays2.spliceArray(h);
        b=System.currentTimeMillis()-a;
        System.out.println("Время пересчета массива с разбиением "+b+" милисекунд");
    }
}
