package days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import utils.utils;

/**
 * day2
 */
public class Day2 {

    public static Integer part1(String filePath) {
        List<Point> listPoint = new ArrayList<>();
        Point depart = new Point(0, 0);
        listPoint.add(depart);

        List<String> input = utils.readFile(filePath);

        for (String string : input) {
            List<String> instructions = Arrays.asList(string.split(","));
            Point oldPoint = depart;
            Point point;

            for (String instruction : instructions) {
                int move = Integer.valueOf(instruction.substring(1));
                String direction = instruction.substring(0, 1);
                if (direction.equals("U")) {
                    point = new Point(oldPoint.getAbscisse(), oldPoint.getOrdonnee() + move);
                    listPoint.add(point);
                    oldPoint = point;

                } else if (direction.equals("R")) {

                    point = new Point(oldPoint.getAbscisse() + move, oldPoint.getOrdonnee());
                    listPoint.add(point);
                    oldPoint = point;

                } else if (direction.equals("L")) {
                    point = new Point(oldPoint.getAbscisse() - move, oldPoint.getOrdonnee());
                    listPoint.add(point);
                    oldPoint = point;

                } else {
                    point = new Point(oldPoint.getAbscisse(), oldPoint.getOrdonnee() - move);
                    listPoint.add(point);
                    oldPoint = point;

                }
            }
        }
        List<Integer> toto = construireDoublonsliste(listPoint).stream().map(point2 -> point2.DistanceManahatan())
                .collect(Collectors.toList());
        return Collections.min(toto);
    }

    public static List<Point> construireDoublonsliste(List<Point> list) {
        List<Point> listeDouble = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j && list.get(i).equals(list.get(j))) {
                    listeDouble.add(list.get(i));
                }
            }
        }
        return listeDouble;
    }

    public static Point transformerEnVecteur(Point pointA, Point pointB) {
        return new Point(pointB.getAbscisse() - pointA.getAbscisse(), pointB.getOrdonnee() - pointA.getOrdonnee());
    }

    public int produitVectoriel(Point vecteurA, Point vecteurB) {
        return vecteurA.getOrdonnee()*vecteurB.getAbscisse()-vecteurA.getAbscisse()*vecteurB.getOrdonnee();
    }

    public static void main(String[] args) {
        System.out.println(part1("day2/test/input-day-3-test.txt"));
    }

    static class Point {

        int abscisse;
        int ordonnee;

        public Point(int x, int y) {
            abscisse = x;
            ordonnee = y;
        }

        /**
         * @return the abscisse
         */
        public int getAbscisse() {
            return abscisse;
        }

        /**
         * @return the ordonnee
         */
        public int getOrdonnee() {
            return ordonnee;
        }

        public int DistanceManahatan() {
            return Math.abs(this.abscisse) + Math.abs(this.ordonnee);
        }

        /**
         * @param abscisse the abscisse to set
         */
        public void setAbscisse(int abscisse) {
            this.abscisse = abscisse;
        }

        /**
         * @param ordonnee the ordonnee to set
         */
        public void setOrdonnee(int ordonnee) {
            this.ordonnee = ordonnee;
        }

        public boolean equals(Point obj) {
            return this.abscisse == obj.abscisse && this.ordonnee == obj.ordonnee;
        }

        @Override
        public String toString() {
            return "(" + this.abscisse + "," + this.ordonnee + ")";
        }
    }

}