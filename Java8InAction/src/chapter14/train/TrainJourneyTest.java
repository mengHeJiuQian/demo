package chapter14.train;

public class TrainJourneyTest {

    public static void main(String[] args) {
        TrainJourney a = new TrainJourney(11, null);
        TrainJourney b = new TrainJourney(22, null);

        TrainJourney append = append(a, b);
        System.out.println("over");
    }

    // 不愧是写书的歪果仁，代码逻辑太6了，看了好一会儿
    public static TrainJourney append(TrainJourney a, TrainJourney b) {
        return null == a ? b : new TrainJourney(a.price, append(a.onward, b));
    }
}
