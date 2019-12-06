package days;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import utils.utils;

/**
 * Day6
 */
public class Day6 implements Days {

    public static void main(String[] args) {
        Days day = new Day6();
        day.part1("day6/input-day-6.txt");
    }

    @Override
    public String part1(String input, Object... params) {
        Map<String, String> listOrbitres = utils.readFile(input).stream()
        .map(s -> s.split("\\)")).collect(Collectors.toMap(a -> a[1], a -> a[0]));
        int compteur = 0;
        for (String planete : listOrbitres.keySet()) {
            String centre = planete;
            while (true){
                compteur ++;
                centre = listOrbitres.get(centre);
                if (centre.equals("COM")){
                    break;
                }
            }
        }
        System.out.println(compteur);
        return String.valueOf(compteur);
    }

    @Override
    public String part2(String input, Object... params) {
        // TODO Auto-generated method stub
        return null;
    }

}