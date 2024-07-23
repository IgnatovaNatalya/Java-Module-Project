import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        System.out.println("Добро пожаловать на гонку \"24 часа Ле-Мана\"!");

        Car[] cars = new Car[3];

        Scanner in = new Scanner(System.in);

        for (int i=0; i< cars.length; i++) {
            System.out.println("— Введите название машины №" + (i+1) +":");
            String name = in.nextLine().trim();
            System.out.println("— Введите скорость машины №" + (i+1) +":");

            int speed =-1;
            while (speed==-1)
                speed = getSpeed(in.nextLine().trim());

            cars[i] = new Car(name,speed);
        }

        System.out.println("Участники гонки:" );

        for (int i=0; i< cars.length; i++) {
            System.out.println("Машина №" + (i+1) + ": " + cars[i].name + ", " + cars[i].speed +" км/ч" );
        }

    }

    static int getSpeed(String str) {

         if (str.matches(".*\\d.*")) {
                int num = Integer.parseInt(str.replaceAll("[^\\d.]+", "").trim());
                if (num<=250 && num>=0) return num;
                else System.out.println("— Неправильная скорость");
            } else {
                System.out.println("— Задайте скорость машины в цифрах");
            }

        return -1;
    }
}



class Car {

    String name;
    int speed;

    public Car(String name,int speed) {
        this.name = name;
        this.speed = speed;
    }
}
