import java.util.Scanner;

public class Actions {
    public static double GetProductPrice(Scanner scan) {
        while (true) {
            System.out.println("Введите цену товара!");
            if (scan.hasNextDouble()) {
                double price = scan.nextDouble();
                if(price <= 0)
                {
                    System.out.println("Ошибка! Ведите цену больше 0!");
                }
                else
                {
                    return price;
                }
            } else {
                scan.nextLine();
                System.out.println("Ошибка! Введите дробное число!");
            }
        }
    }

    public static int GetNumber(Scanner scan) {
        while (true) {
            if (scan.hasNextInt()) {
                return scan.nextInt();
            } else {
                scan.nextLine();
                System.out.println("Ошибка! Введите число!");
            }
        }
    }

    public static String GetProducts(String name, String allNames) {
        allNames = allNames + name + ".\n";
        return allNames;
    }

    public static double GetPrices(double price, double allPrice) {
        allPrice += price;
        return allPrice;
    }

    public static void ShowResult(double price) {
        String result = "Цена для каждого: \"%.2f %s\"";
        if (Math.floor(price) > 11 && Math.floor(price) < 15) {
            System.out.println(String.format(result, price, "рублей"));
        } else if (Math.floor(price) % 10 == 1) {
            System.out.println(String.format(result, price, "рубль"));
        } else if (Math.floor(price) % 10 > 1 && Math.floor(price) % 10 < 5) {
            System.out.println(String.format(result, price, "рубля"));
        } else {
            System.out.println(String.format(result, price, "рублей"));
        }
    }
}
