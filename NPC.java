import java.util.Random;
public class NPC extends User {
    private static String[] textOptions = {"Robots are cool :D", "oh no i gotta do my jira ticket", "god damn it kyle why did you commit before pulling bruh", "i am removing your bad code", "i have 3 hr of sleep plez help", "goodbye bozo", "zzzzz", "*goes to the supermarket to buy milk*"};

    public NPC(String name) { // Initialize a new bot user
        super(name, true);
        ChangeDiscrim(0420);
    }

    public String response() { // Return a string randomly picked from `textOptions`
        Random rand = new Random();
        int optionsIndex = rand.nextInt(textOptions.length);
        return textOptions[optionsIndex];
    }
}
