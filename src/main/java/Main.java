import java.util.Scanner;

public class Main {
    private static final int NUM_CARS = 3;
    private static final int MIN_SPEED = 0;
    private static final int MAX_SPEED = 250;

    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        System.out.println("Добро пожаловать на гонку \"24 часа Ле-Мана\"!");

        Race race = new Race();

        Scanner in = new Scanner(System.in);

        for (int i = 0; i < NUM_CARS; i++) {
            String name = "";
            int speed = -1;

            while (name.isEmpty()) {
                System.out.println("— Введите название машины №" + (i + 1) + ":");
                name = scanName(in.nextLine());
                if (!name.isEmpty()) break;
            }

            while (speed == -1) {
                System.out.println("— Введите скорость машины №" + (i + 1) + ":");
                speed = scanSpeed(in.nextLine());
                if (speed != -1) break;
            }

            Car car = new Car(name, speed);

            race.compete(car);
        }
        race.result();
    }

    public static String scanName(String str) {
        String strName = str.trim();
        if (strName.isEmpty())
            System.out.println("— Название не должно быть пустым");
        return strName;
    }

    public static int scanSpeed(String str) {

        if (str.matches("\\d+")) { //введена одна или больше цифр
            int speed = Integer.parseInt(str);
            if (speed < MIN_SPEED || speed > MAX_SPEED) {
                System.out.println("— Неправильная скорость");
                return -1;
            }
            return speed;
        } else {
            System.out.println("— Неправильная скорость");
        }
        return -1;
    }
}
