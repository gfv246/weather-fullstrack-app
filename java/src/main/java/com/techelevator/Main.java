package com.techelevator;

public class Main {
    public static void main(String[] args){
        Main kata = new Main();
        int[] testArray = {2,5};
        String str = "2 and 5";
        boolean result = kata.has23(testArray);
        System.out.println("The result for " + str + " is: " + result);
    }


    public boolean has23(int array[]) {
        boolean result = false;
        if(array[0] == 2 || array[0] == 3 || array[1] ==2 || array[1] == 3) {
            result = true;
        }
        return result;
    }









}
