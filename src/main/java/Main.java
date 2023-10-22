
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Уважаемый ревьюрер, я забыл при прошлом отправлении сделать коммит, прошу прощения.
        while(true)
        {
            System.out.println("На сколько человек хотите разделить покупку?");
            Scanner scan = new Scanner(System.in);

            int n = GetNumber(scan);

            if(n == 1)
            {
                System.out.println("Ощибка! Введите значение >1!");
            }
            else if(n < 1)
            {
                System.out.println("Ощибка! Некорректное число! Введите значение >1!");
            }
            else
            {
                double prices = 0.0;
                String products = "";

                while(true)
                {
                    System.out.println("Введите название товара или Завершить!");
                    scan.nextLine();
                    String name = scan.nextLine();
                    if(name.equalsIgnoreCase("Завершить"))
                    {
                        System.out.println("Ваши товары: " + products);
                        ShowResult(prices / n);
                        scan.close();
                        break;
                    }
                    else
                    {
                        double price = GetProductPrice(scan);
                        prices = GetPrices(price, prices);
                        products = GetProducts(name, products);
                    }
                }
                break;
            }
        }
    }

    public static double GetProductPrice(Scanner scan)
    {
        while(true)
        {
            System.out.println("Введите цену товара!");
            if(scan.hasNextDouble())
            {
                return scan.nextDouble();
            }
            else
            {
                scan.nextLine();
                System.out.println("Ошибка! Введите дробное число!");
            }
        }
    }

    public static int GetNumber(Scanner scan)
    {
        while(true)
        {
            if(scan.hasNextInt())
            {
                return scan.nextInt();
            }
            else
            {
                scan.nextLine();
                System.out.println("Ошибка! Введите число!");
            }
        }
    }

    public static String GetProducts(String name, String allNames)
    {
        allNames = allNames + name + ". ";
        return allNames;
    }

    public static double GetPrices(double price, double allPrice)
    {
        allPrice += price;
        return allPrice;
    }

    public static void ShowResult(double price)
    {
        String result = "Цена для каждого: %.2f %s";
        if(Math.floor(price) > 11 && Math.floor(price) < 15)
        {
            System.out.println(String.format(result, price, "рублей"));
        }
        else if(Math.floor(price) % 10 == 1)
        {
            System.out.println(String.format(result, price, "рубль"));
        }
        else if(Math.floor(price) % 10 > 1 && Math.floor(price) % 10 < 5)
        {
            System.out.println(String.format(result, price, "рубля"));
        }
        else
        {
            System.out.println(String.format(result, price, "рублей"));
        }
    }
}