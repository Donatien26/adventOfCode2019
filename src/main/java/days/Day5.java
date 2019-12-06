package days;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import utils.utils;

/**
 * Day5
 */
public class Day5 implements Days{

    @Override
    public String part1(String input, Object... params) {
        int nom = (int) params[0];
        int verb = (int) params[1];
        String[] myTab = utils.readFile(input).get(0).split(",");
        List<Integer> myList = Arrays.asList(myTab).stream().map(s -> Integer.valueOf(s)).collect(Collectors.toList());
        int i = 0;
        myList.set(1, nom);
        myList.set(2, verb);
        while (myList.get(i) != 99) {
            if (myList.get(i) == 1) {
                myList.set(myList.get(i + 3), myList.get(myList.get(i + 1)) + myList.get(myList.get(i + 2)));
                i = i + 4;
            } else if (myList.get(i) == 2) {
                myList.set(myList.get(i + 3), myList.get(myList.get(i + 1)) * myList.get(myList.get(i + 2)));
                i = i + 4;
            }
            else if(myList.get(i) == 3){
                int entrée = 0;
                myList.set(myList.get(i+1),entrée);
                i = i + 2;
            }
            else if (myList.get(i)==4){
                myList.get(i+1);
            }
        }
        return myList.toString();
    }

    @Override
    public String part2(String input, Object... params) {
        // TODO Auto-generated method stub
        return null;
    }

    
}