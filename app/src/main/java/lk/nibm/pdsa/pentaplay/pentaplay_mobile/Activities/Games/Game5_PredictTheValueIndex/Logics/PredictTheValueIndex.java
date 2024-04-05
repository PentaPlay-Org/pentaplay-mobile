package lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game5_PredictTheValueIndex.Logics;

import java.util.Random;

public class PredictTheValueIndex {
    final int ARRAY_SIZE = 5000;
    final int MAXVALUE = 1000000;

    SearchAlgorithmType[] algorithmTypes =  new SearchAlgorithmType[4];
    int correctIndex = -1;
    int key = 0;

    public PredictTheValueIndex(){
        algorithmTypes[0] = new SearchAlgorithmType("BINARY SEARCH");
        algorithmTypes[1] = new SearchAlgorithmType("JUMP SEARCH");
        algorithmTypes[2] = new SearchAlgorithmType("EXPONENTIAL SEARCH");
        algorithmTypes[3] = new SearchAlgorithmType("FIBONACCI SEARCH");
    }
    public int[] generateSoredRandomNumbers(){
        int[] numberArray = new int[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE-1; i++) {
            numberArray[i] = generateRandomInt(MAXVALUE);
        }
        numberArray = new Helper().sortArray(numberArray);
        return numberArray;
    }

    public int generateRandomInt(int max){
        return  new Random().nextInt(max);
    }
    public int getKey(){return key;}

    public int preStartRound(){
        int[] sortedArray = generateSoredRandomNumbers();
        int index = new Random().nextInt(ARRAY_SIZE-1);
        this.key = sortedArray[index];
        ISearchAlgorithm searchAlgorithm = new SearchAlgorithm(sortedArray , this.key);
        for (SearchAlgorithmType algo:algorithmTypes) {
            long startTime = System.nanoTime();
            algo.index  = searchAlgorithm.searchIndex(algo.name);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000;  //in milliseconds
            algo.duration = (int)duration;
            //SAVE algo model in database
        }
        return index;
    }

    public int[] startRound(){
        this.correctIndex = preStartRound();
        int[]  selections = new int[4];
        int selectionIndex = new Random().nextInt(3);
        selections[selectionIndex] = this.correctIndex;
        for (int i = 0; i < selections.length; i++) {
            if(i != selectionIndex)
                selections[i] = this.getRandomUniqueIndex(selections);
        }
        return selections;
    }

    private int getRandomUniqueIndex(int[] selections){
        int randomIndex = new Random().nextInt(ARRAY_SIZE-1);
        ISearchAlgorithm algorithm = new SearchAlgorithm(selections , randomIndex);
        if(algorithm.searchIndex("BINARY SEARCH") != -1)
            return getRandomUniqueIndex(selections);
        return  randomIndex;
    }

    public boolean checkAnswer(int index){
        return  index == correctIndex;
    }
}


