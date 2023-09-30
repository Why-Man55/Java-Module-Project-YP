
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("На сколько человек хотите разделить покупку?");
        int n = scan.nextInt();
        while(true)
        {
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
                double allPrice = 0;
                String allNames = "";

                while(true)
                {
                    System.out.println("Введите название товара или Завершить!");
                    String name = scan.next();
                    if(name.equalsIgnoreCase("Завершить"))
                    {
                        System.out.println("Ваши товары: " + allNames);
                        Res(allPrice / n);
                        break;
                    }
                    else
                    {
                        allNames = allNames + name + " ";
                        System.out.println("Введите цену товара!");
                        double price = scan.nextDouble();
                        allPrice += price;
                    }
                }
                break;
            }
        }

    }

    public static void Res(double price)
    {
        String res = "Цена для каждого: %.2f %s";
        if(Math.floor(price) == 11)
        {
            System.out.println(String.format(res, price, "рублей"));
        }
        else if(Math.floor(price) % 10 == 1)
        {
            System.out.println(String.format(res, price, "рубль"));
        }
        else if(Math.floor(price) % 10 > 1 && Math.floor(price) % 10 < 5)
        {
            System.out.println(String.format(res, price, "рубля"));
        }
        else
        {
            System.out.println(String.format(res, price, "рублей"));
        }
    }
}