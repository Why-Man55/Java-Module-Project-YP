
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Уважаемый ревьюрер, я забыл при прошлом отправлении сделать коммит, прошу прощения.
        while (true) {
            System.out.println("На сколько человек хотите разделить покупку?");
            Scanner scan = new Scanner(System.in);

            int n = Actions.GetNumber(scan);

            if (n == 1) {
                System.out.println("Ощибка! Введите значение >1!");
            } else if (n < 1) {
                System.out.println("Ощибка! Некорректное число! Введите значение >1!");
            } else {
                double prices = 0.0;
                String products = "";

                while (true) {
                    System.out.println("Введите название товара или \"Завершить!\"");
                    scan.nextLine();
                    String name = scan.nextLine();
                    if (name.equalsIgnoreCase("Завершить")) {
                        System.out.println("Ваши товары: \n" + products);
                        Actions.ShowResult(prices / n);
                        scan.close();
                        break;
                    } else {
                        double price = Actions.GetProductPrice(scan);
                        prices = Actions.GetPrices(price, prices);
                        products = Actions.GetProducts(name, products);
                    }
                }
                break;
            }
        }
    }
}
