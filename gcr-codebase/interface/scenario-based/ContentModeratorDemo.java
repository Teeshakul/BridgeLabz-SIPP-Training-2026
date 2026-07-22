interface TextModeration {

    boolean checkOffensive(String post);

    default void displayModerationPolicy() {
        System.out.println("No offensive language allowed.");
    }

    static boolean containsRestrictedWords(String post) {
        return post.toLowerCase().contains("bad");
    }
}

interface SpamDetection {

    boolean checkSpam(String post);

    default void displayModerationPolicy() {
        System.out.println("No spam allowed.");
    }
}

class ContentModerator implements TextModeration, SpamDetection {

    public boolean checkOffensive(String post) {
        return TextModeration.containsRestrictedWords(post);
    }

    public boolean checkSpam(String post) {
        return post.toLowerCase().contains("buy now");
    }

    @Override
    public void displayModerationPolicy() {
        System.out.println("Follow Community Guidelines.");
    }
}

public class ContentModeratorDemo {
    public static void main(String[] args) {

        String[] posts = {
                "Hello everyone",
                "Buy now and win",
                "This is a bad post",
                "Enjoy learning Java"
        };

        ContentModerator cm = new ContentModerator();

        cm.displayModerationPolicy();

        for (String post : posts) {

            if (cm.checkSpam(post))
                System.out.println(post + " -> Spam");

            else if (cm.checkOffensive(post))
                System.out.println(post + " -> Offensive");

            else
                System.out.println(post + " -> Valid");
        }
    }
}