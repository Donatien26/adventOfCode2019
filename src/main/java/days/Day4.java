package days;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import utils.utils;

/**
 * Day3
 */
public class Day4 implements Days {
    public static int part1(String PathFile) {
        String[] input = utils.readFile(PathFile).get(0).split("-");
        int debut = Integer.valueOf(input[0]);
        int fin = Integer.valueOf(input[1]);
        int compteur = 0;
        for (int nombre = debut; nombre < fin; nombre++) {
            if (aUnDouble(nombre) && aDesChiffresCroissant(nombre)) {
                compteur++;
            }
        }
        return compteur;
    }

    public static Boolean aDesChiffresCroissant(int nombre) {
        String nombreString = String.valueOf(nombre);
        for (int i = 1; i < nombreString.length(); i++) {
            if (Integer.valueOf(nombreString.charAt(i)) < Integer.valueOf(nombreString.charAt(i - 1))) {
                return false;
            }
        }
        return true;
    }

    public static boolean aUnDouble(int nombre) {
        String nombreString = String.valueOf(nombre);
        for (int i = 1; i < nombreString.length(); i++) {
            if (Integer.valueOf(nombreString.charAt(i)) == Integer.valueOf(nombreString.charAt(i - 1))) {
                return true;
            }
        }
        return false;
    }

    public static boolean contientUnDouble(int nombre){
        String nombreString = String.valueOf(nombre);
        List<Integer> listOccurenceDeChaqueNombre = new ArrayList<>();
        for (int i = 0; i < nombreString.length(); i++) {
            int occurence = 0;
            for (int j = 0; j < nombreString.length(); j++) {
                if (nombreString.charAt(i)==nombreString.charAt(j)){
                    occurence++;
                }
            }
            listOccurenceDeChaqueNombre.add(occurence);
        }
        if(listOccurenceDeChaqueNombre.contains(2)){
            return true;
        }
        return false;
    }

    public static List<Integer> part2(String PathFile) {
        String[] input = utils.readFile(PathFile).get(0).split("-");
        int debut = Integer.valueOf(input[0]);
        int fin = Integer.valueOf(input[1]);
        List<Integer> passwords = new ArrayList<>();
        for (int nombre = debut; nombre < fin; nombre++) {
            if (aUnDouble(nombre) && aDesChiffresCroissant(nombre)) {
                passwords.add(nombre);
            }
        }
        return passwords.stream().filter(number -> contientUnDouble(number)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(part1("day4/input-day-4.txt"));
        System.out.println(part2("day4/input-day-4.txt").size());
    }
}