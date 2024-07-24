import java.util.Scanner;

public class Main {
    private static final int NUM_CARS = 3;

    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        System.out.println("Добро пожаловать на гонку \"24 часа Ле-Мана\"!");

        Car[] cars = new Car[3];//

        Race race = new Race();

        Scanner in = new Scanner(System.in);

        for (int i=0; i< NUM_CARS; i++) {
            String name="";
            int speed =-1;

            System.out.println("— Введите название машины №" + (i+1) +":");

            while (name.isEmpty()) {
                name = getName(in.nextLine());
                if (!name.isEmpty() )  break;
            }

            System.out.println("— Введите скорость машины №" + (i+1) +":");

            while (speed == -1) {
                speed = getSpeed(in.nextLine());
                if (speed != -1) break;
            }

            Car car = new Car(name,speed);

            cars[i]=car; //

            race.compete(car);
        }

        System.out.println("Участники гонки:" );

        for (int i=0; i< NUM_CARS; i++) {
            System.out.println("Машина №" + (i+1) + ": " + cars[i].name + ", " + cars[i].speed +" км/ч" );
        }

        race.result();
    }

    public static  String getName(String str) {
        String strName= str.trim();
        if (strName.isEmpty() )
            System.out.println("—  Название не должно быть пустым, введите еще раз:");
        return strName;
    }

    public static int getSpeed(String str) {

        if (str.matches(".*\\d.*")) {
            int speed = Integer.parseInt(str.replaceAll("[^\\d.]+", "").trim());
            if (speed <0 || speed >250 ) {
                System.out.println("— На гонку принимаются автомобили со скоростью не меньше 0 и не больше 250 км/ч, введите корректное значение:");
                return -1;
            }
            return speed;
        } else {
            System.out.println("— Скорость должна быть задана в цифрах, попробуйте еще раз:");
        }
        return -1;
    }
}
