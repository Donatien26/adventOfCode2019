package days;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import utils.utils;

public class Day2 {

    public static List<Integer> part1(String name, int verb, int nom ) {
        String[] myTab = utils.readFile(name).get(0).split(",");
        List<Integer> myList = Arrays.asList(myTab).stream().map(s -> Integer.valueOf(s)).collect(Collectors.toList());
        int i = 0;
        myList.set(1, nom);
        myList.set(2, verb);
        while (myList.get(i) != 99) {
            if (myList.get(i) == 1) {
                myList.set(myList.get(i + 3), myList.get(myList.get(i + 1)) + myList.get(myList.get(i + 2)));
            } else if (myList.get(i) == 2) {
                myList.set(myList.get(i + 3), myList.get(myList.get(i + 1)) * myList.get(myList.get(i + 2)));
            }
            i = i + 4;
        }
        return myList;
    }

    public static int part2(String name) {
        int nom = 0;
        while (nom<100){
            int verb = 0;
            while(verb<100){
                if (part1(name, verb, nom).get(0)==19690720){
                    return 100*nom+verb;
                }
                verb++; 
            }
            nom++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer result = part2("day2/input-day-2.txt");
        System.out.println(result);
    }
}