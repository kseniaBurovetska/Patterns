package strategy;

import java.util.Arrays;

public class StrategyPattern {

    public static void main(String[] args) {
        StrategyClient strategyClient = new StrategyClient();

        int[] arr1 = {6, 5, 3, 3, 7, 5, 7, 6, 6, 5};
        strategyClient.setStrategy(new BubbleSort());
        strategyClient.executeStrategy(arr1);

        int[] arr2 = {8, 9, 6, 7, 4, 8, 2, 10, 5, 8};
        strategyClient.setStrategy(new MergeSort());
        strategyClient.executeStrategy(arr2);

        int[] arr3 = {4, 8, 4, 4, 2, 7, 4, 5, 5, 3};
        strategyClient.setStrategy(new InsertionSort());
        strategyClient.executeStrategy(arr3);
    }

}

//Strategy Client

class StrategyClient {
    Sorting strategy;

    void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }

    void executeStrategy(int[] arr) {
        strategy.sort(arr);
    }
}

//Strategy
interface Sorting {
    void sort(int[] arr);
}

class BubbleSort implements Sorting {

    @Override
    public void sort(int[] arr) {

        /*
        Bubble sorting
         */

        System.out.println("Bubble sorting: ");
        Arrays.stream(arr).sorted().forEach(x -> System.out.print(x+" "));
        System.out.println();
    }
}

class InsertionSort implements Sorting {

    @Override
    public void sort(int[] arr) {

        /*
        Insertion sorting
         */

        System.out.println("Insertion sorting: ");
        Arrays.stream(arr).sorted().forEach(x -> System.out.print(x+" "));
        System.out.println();
    }
}

class MergeSort implements Sorting {

    @Override
    public void sort(int[] arr) {

        /*
        Merge sorting
         */

        System.out.println("Merge sorting: ");
        Arrays.stream(arr).sorted().forEach(x -> System.out.print(x+" "));
        System.out.println();
    }
}