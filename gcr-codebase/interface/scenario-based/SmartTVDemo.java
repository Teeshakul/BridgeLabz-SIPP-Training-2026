interface StreamingService {

    void streamMovie();

    default void showSubscriptionDetails() {
        System.out.println("Streaming Subscription");
    }
}

interface GamingService {

    void playGame();

    default void showSubscriptionDetails() {
        System.out.println("Gaming Subscription");
    }
}

class SmartTV implements StreamingService, GamingService {

    public void streamMovie() {
        System.out.println("Streaming Movie");
    }

    public void playGame() {
        System.out.println("Playing Game");
    }

    @Override
    public void showSubscriptionDetails() {
        System.out.println("Streaming and Gaming Subscription");
    }
}

public class SmartTVDemo {
    public static void main(String[] args) {

        String[] movies = {"Avengers", "Avatar", "Interstellar"};
        String[] games = {"FIFA", "Minecraft", "PUBG"};

        SmartTV tv = new SmartTV();

        tv.showSubscriptionDetails();

        System.out.println("Movies:");
        for (String movie : movies)
            System.out.println(movie);

        System.out.println("Games:");
        for (String game : games)
            System.out.println(game);
    }
}