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
        return 0;
    }

    @Override
    public int exponential() {
        return 0;
    }
    @Override
    public int  searchIndex(String algorithm){
        switch (algorithm){
            case "BINARY SEARCH":
                return binary(0 , list.length-1);
            case "JUMP SEARCH":
                return jump();
            case "EXPONENTIAL SEARCH":
                return -1;
            case "FIBONACCI_SEARCH":
                return fibonacci();
            default:
                return 0;
        }
    }
}
