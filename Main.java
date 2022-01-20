import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String[] products = {"Молоко", "Хлеб  ", "Гречка"};
        final int[] prices = {50, 14, 80};
        int[] counts = new int[products.length];
        int sumProducts = 0;
        boolean[] filledProduct = new boolean[products.length];

        System.out.println("Список возможных товаров для покупки");
        for (int i = 0; i < products.length; i++) {
            System.out.println(i + 1 + ". " + products[i] + " " + prices[i] + " руб/шт");
        }
        while (true) {
            System.out.println("Выберите товар и количество или введите `end`");
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            } else {
                String[] parts = input.split(" ");
                int productNumber = Integer.parseInt(parts[0]) - 1;
                int productCount = Integer.parseInt(parts[1]);
                counts[productNumber] += productCount;
                filledProduct[productNumber] = counts[productNumber] > 0;
            }
        }
        System.out.println("Ваша корзина:");
        System.out.println("Наименование товара   Количество  Цена/за.ед  Общая стоимость");
        for (int i = 0; i < filledProduct.length; i++) {
            if (filledProduct[i]) {
                int rezult = prices[i] * counts[i];
                System.out.println(products[i] + "                   "
                        + counts[i] + "          "
                        + prices[i] + "              "
                        + rezult);
                sumProducts += rezult;
            }
        }
        System.out.println("                                    "
                + "Итого:          "
                + sumProducts);
    }
}

