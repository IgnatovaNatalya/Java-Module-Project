public class Race {

    private static final int RACE_TIME = 24; //время гонки

    String leader; //текущий лидер
    int distance =0; //текущая лидерская дистанция

    public void compete(Car car) {
        int dist = RACE_TIME * car.getSpeed();
        if (dist > distance) {
            distance = dist;
            leader = car.getName();
        }
    }
    public void result() {
        System.out.println("Самая быстрая машина: "+ leader);
    }

}
