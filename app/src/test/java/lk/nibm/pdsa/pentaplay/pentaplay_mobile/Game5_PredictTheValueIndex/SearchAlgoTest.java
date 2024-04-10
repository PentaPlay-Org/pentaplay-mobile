package lk.nibm.pdsa.pentaplay.pentaplay_mobile.Game5_PredictTheValueIndex;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game5_PredictTheValueIndex.Logics.ISearchAlgorithm;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game5_PredictTheValueIndex.Logics.SearchAlgorithm;

public class SearchAlgoTest {
    int[] list = {1,3,4,5,6,7,8,9};
    @Test
    public void binarySearchTest() {
        assertEquals(
                3 ,
                new SearchAlgorithm(list , 5).searchIndex("BINARY SEARCH"));
        assertEquals(
                0 ,
                new SearchAlgorithm(list , 1).searchIndex("BINARY SEARCH"));
        assertEquals(
                7 ,
                new SearchAlgorithm(list , 9).searchIndex("BINARY SEARCH"));
        assertEquals(
                -1 ,
                new SearchAlgorithm(list , 10).searchIndex("BINARY SEARCH"));
        assertEquals(
                -1 ,
                new SearchAlgorithm(list , -1).searchIndex("BINARY SEARCH"));
    }

    @Test
    public void jumpSearchTest() {
        assertEquals(
                3 ,
                new SearchAlgorithm(list , 5).searchIndex("JUMP SEARCH"));
        assertEquals(
                0 ,
                new SearchAlgorithm(list , 1).searchIndex("JUMP SEARCH"));
        assertEquals(
                7 ,
                new SearchAlgorithm(list , 9).searchIndex("JUMP SEARCH"));
        assertEquals(
                -1 ,
                new SearchAlgorithm(list , 10).searchIndex("JUMP SEARCH"));
        assertEquals(
                -1 ,
                new SearchAlgorithm(list , -1).searchIndex("JUMP SEARCH"));
    }

    @Test
    public void exponentialSearchTest() {
        assertEquals(
                3 ,
                new SearchAlgorithm(list , 5).searchIndex("EXPONENTIAL SEARCH"));
        assertEquals(
                0 ,
                new SearchAlgorithm(list , 1).searchIndex("EXPONENTIAL SEARCH"));
        assertEquals(
                7 ,
                new SearchAlgorithm(list , 9).searchIndex("EXPONENTIAL SEARCH"));
        assertEquals(
                -1 ,
                new SearchAlgorithm(list , 10).searchIndex("EXPONENTIAL SEARCH"));
        assertEquals(
                -1 ,
                new SearchAlgorithm(list , -1).searchIndex("EXPONENTIAL SEARCH"));
    }

    @Test
    public void fibonacciSearchTest() {
        assertEquals(
                3 ,
                new SearchAlgorithm(list , 5).searchIndex("EXPONENTIAL SEARCH"));
        assertEquals(
                0 ,
                new SearchAlgorithm(list , 1).searchIndex("EXPONENTIAL SEARCH"));
        assertEquals(
                7 ,
                new SearchAlgorithm(list , 9).searchIndex("EXPONENTIAL SEARCH"));
        assertEquals(
                -1 ,
                new SearchAlgorithm(list , 10).searchIndex("EXPONENTIAL SEARCH"));
        assertEquals(
                -1 ,
                new SearchAlgorithm(list , -1).searchIndex("EXPONENTIAL SEARCH"));
    }
}
