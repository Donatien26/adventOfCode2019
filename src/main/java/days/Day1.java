package days;

import java.util.List;
import java.util.stream.Collectors;

import utils.utils;

public class Day1 {

    public static int part1(String fileName) {
        List<Integer> tab = utils.readFile(fileName).stream().map(s -> Integer.valueOf(s)).collect(Collectors.toList());
        int fuelForAllModule=0;
        for (int number : tab){
            fuelForAllModule+= Math.floor(number/3)-2;
        }
        return fuelForAllModule;
    }

    public static int part2(String fileName) {
        List<Integer> tab = utils.readFile(fileName).stream().map(s -> Integer.valueOf(s)).collect(Collectors.toList());
        int fuelForAllModule=0;
        for (int number : tab){
            int fuelForModule= (int) (Math.floor(number / 3) - 2);
            while (fuelForModule>0){
                fuelForAllModule +=fuelForModule;
                fuelForModule= (int) (Math.floor(fuelForModule / 3) - 2);
            }
        }
        return fuelForAllModule;
    }

    public static void main(String[] args) {
        System.out.println(part1("day1/input-day-1.txt"));
        System.out.println(part2("day1/input-day-1.txt"));
    }
}