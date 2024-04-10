package lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game5_PredictTheValueIndex.Logics;


public class  SearchAlgorithm implements ISearchAlgorithm {

    private int[] list;
    private int key;
    public SearchAlgorithm(int[] list , int key){
        this.list = list;
        this.key = key;
    }
    @Override
    public int binary(int first , int last) {
        if(first > last)
            return -1;

        int middleIndex = (first + last) / 2;

        if(key == list[middleIndex])
            return  middleIndex;
        else if(key < list[middleIndex])
            return binary(first , middleIndex-1);
        else
            return binary(middleIndex+1 , last);
    }


    @Override
    public int jump() {
        int stepSize = (int)Math.floor(Math.sqrt(list.length));
        int step = stepSize;
        int N = list.length;

        int prev = 0;
        while (list[Math.min(step , N-1)]<key){
            if(step >= N)
                return -1;
            prev = step;
            step += stepSize;
        }

        int index = prev;
        while (list[index] <= key && index <=step){
            if(list[index] == key)
                return index;
            index++;
        }
        return  -1;
    }


    private int getMin(int i) {
        return Math.min(list.length - 1, i);
    }

    @Override
    public int fibonacci() {
        int n = list.length;
        int offset = -1;
        int fibMMinus2 = 0;
        int fibMMinus1 = 1;
        int fibM = fibMMinus1 + fibMMinus2;

        while (fibM < n) {
            fibMMinus2 = fibMMinus1;
            fibMMinus1 = fibM;
            fibM = fibMMinus1 + fibMMinus2;
        }

        while (fibM > 1) {
            int i = Math.min(offset + fibMMinus2, n - 1);

            if (list[i] < key) {
                fibM = fibMMinus1;
                fibMMinus1 = fibMMinus2;
                fibMMinus2 = fibM - fibMMinus1;
                offset = i;
            } else if (list[i] > key) {
                fibM = fibMMinus2;
                fibMMinus1 = fibMMinus1 - fibMMinus2;
                fibMMinus2 = fibM - fibMMinus1;
            } else {
                return i;
            }
        }

        if (fibMMinus1 == 1 && list[offset+1] == key)
            return offset+1;

        return -1;

    }

    @Override
    public int exponential() {
        int bound = 1;

        while(bound < list.length && list[bound] < key)
            bound *=2;
        int left = bound /2;
        int right = Math.min(bound , list.length - 1);
        return  binary(left, right);
    }
    @Override
    public int  searchIndex(String algorithm){
        switch (algorithm){
            case "BINARY SEARCH":
                return binary(0 , list.length-1);
            case "JUMP SEARCH":
                return jump();
            case "EXPONENTIAL SEARCH":
                return exponential();
            case "FIBONACCI SEARCH":
                return fibonacci();
            default:
                return 0;
        }
    }
}
