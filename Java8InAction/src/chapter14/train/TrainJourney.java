package chapter14.train;

public class TrainJourney {

    public int price;
    public TrainJourney onward;

    public TrainJourney(int p, TrainJourney t) {
        this.price = p;
        this.onward = t;
    }
}
