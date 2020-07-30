import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

enum Color {
    RED,
    GREEN
}

public class FilteringApples {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red")
        );

        // java 8 이전 스타일
        List<Apple> greenApples = filterGreenApples(inventory);
        List<Apple> heavyApples = filterHeavyApples(inventory);

        System.out.println(greenApples.toString());
        System.out.println(heavyApples.toString());
    }

    /**
     * 녹색 사과 필터링
     * @param inventory
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple: inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 무거운 사과 필터링
     * @param inventory
     * @return
     */
    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple: inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }

        return result;
    }

    @Getter
    private static class Apple {
        private final int weight;
        private final String color;

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        @Override
        public String toString() {
            return String.format("Apple{color='%s', weight=%d}", color, weight);
        }
    }
}
