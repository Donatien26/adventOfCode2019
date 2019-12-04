package days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.Coordinate;
import utils.utils;

public class Day2 {
    public static final SmartCoordinate startingCoordinate = new SmartCoordinate(0, 0, 0);

    public static void main(String[] args) {
        System.out.println("answer A: " + part1("day2/input-day-2.txt"));
        System.out.println("answer B: " + part2("day2/input-day-2.txt"));
    }

    public static int part1(String filePath) {
        List<String> input = utils.readFile(filePath);
        List<SmartCoordinate> coordsFromRoute1 = getCoordsFromRoute(input.get(0));
        List<SmartCoordinate> coordsFromRoute2 = getCoordsFromRoute(input.get(1));

        coordsFromRoute1.remove(startingCoordinate);
        return coordsFromRoute1.stream()
                .filter(coordinate -> coordsFromRoute2.contains(coordinate))
                .mapToInt(coordinate -> coordinate.getManhattanDistance(startingCoordinate))
                .min()
                .getAsInt();
    }

    public static List<SmartCoordinate> getCoordsFromRoute(String route) {
        List<SmartCoordinate> coordinateList = new ArrayList<>();
        // add starting position
        coordinateList.add(startingCoordinate);

        Arrays.stream(route.split(",")).forEach(routePart -> addRouteLineToCoords(routePart, coordinateList));
        return coordinateList;
    }

    public static void addRouteLineToCoords(String routePart, List<SmartCoordinate> coordinateList) {
        // example routeparts: R1008 L339 U12 D965
        int steps = Integer.parseInt(routePart.substring(1));
        switch (routePart.substring(0, 1)) {
            case "R": createLineFromLastCoordinate(steps, coordinateList, true); break;
            case "L": createLineFromLastCoordinate(-steps, coordinateList, true); break;
            case "U": createLineFromLastCoordinate(steps, coordinateList, false); break;
            case "D": createLineFromLastCoordinate(-steps, coordinateList, false); break;
            default:
                throw new UnsupportedOperationException("This isn't a direction." + routePart.substring(0, 1));
        }
    }

    public static void createLineFromLastCoordinate(int steps, List<SmartCoordinate> coordinateList, boolean horizontal) {
        int modifier = steps < 0 ? -1 : 1;
        SmartCoordinate startingCoordinate = coordinateList.get(coordinateList.size() - 1);

        for (int i = 1; i <= steps * modifier; i++) {
            int x = horizontal ? startingCoordinate.x + (i * modifier) : startingCoordinate.x;
            int y = horizontal ? startingCoordinate.y : startingCoordinate.y + (i * modifier);
            coordinateList.add(new SmartCoordinate(x, y, startingCoordinate.stepsAlongRoute + i));
        }
    }

    public static int part2(String filePath) {
        List<String> input = utils.readFile(filePath);
        List<SmartCoordinate> coordsFromRoute1 = getCoordsFromRoute(input.get(0));
        List<SmartCoordinate> coordsFromRoute2 = getCoordsFromRoute(input.get(1));

        coordsFromRoute1.remove(startingCoordinate);
        return coordsFromRoute1.stream()
                .filter(coordinate -> coordsFromRoute2.contains(coordinate))
                .mapToInt(coordinate -> coordinate.getStepsAlongRoute() + coordsFromRoute2.get(coordsFromRoute2.indexOf(coordinate)).getStepsAlongRoute())
                .min()
                .getAsInt();
    }

    public static class SmartCoordinate extends Coordinate {
        public int stepsAlongRoute;

        public SmartCoordinate(int x, int y, int stepsAlongRoute) {
            super(x, y);
            this.stepsAlongRoute = stepsAlongRoute;
        }

        public int getStepsAlongRoute() {
            return stepsAlongRoute;
        }
    }
}


