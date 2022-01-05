import java.util.Scanner;
public class Discord {
    // Print function just to make it easier
    private static void print(String toPrint) { System.out.println(toPrint); }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        print("Welcome to \"Discord\"!");
        print("Let's create a new account for you...");
        print("What is your name? ");

        String name = sc.next();

        User account = new User(name, false); // Creates a new user, not a bot
        NPC fritz = new NPC("Fritz"); // Generate an NPC for fritz

        print("You are now logged in as " + account.getUser());

        while (true) {
            print("What would you like to do (? for help)? ");
            String action = sc.next();

            if (action.equals("?")) {
                print("You can do one of these options:\n- (nitro) to enable or disable nitro\n- (chat) to chat with Fritz\n-(guild) join a guild and start chatting\n- (exit) to exit discord");
            } else if (action.equals("nitro")) {
                if (account.hasNitro()) {
                    account.DisableNitro();
                    print("Disabled nitro");
                } else {
                    print("What do you want your discriminator to be?");
                    int discrim = 0001;
                    try {
                        discrim = sc.nextInt();
                    } catch (Exception e) {
                        print("Invalid discriminator, defaulting to 0001");
                    }
                    account.ActivateNitro(discrim);
                    print("Activated nitro with discriminator " + discrim);
                }
            } else if (action.equals("chat")) {
                DMChannel channel = new DMChannel(account.getID(), fritz.getID()); // Create a new channel with 2 users
                print("You have opened a chat with Fritz. Please type your message or '/q' to break:");
                while (true) {
                    String message = sc.next();
                    if (message.equals("/q")) {
                        print("Closed chat with Fritz");
                        break;
                    }
                    channel.send(account.getUser(), message);
                    String response = fritz.response();
                    channel.send(fritz.getUser(), response);
                }
            } else if (action.equals("exit")) {
                print("Thank you for using \"Discord\"!\nUnfortunately, your account has been flagged for scamming, so we have terminated your account.");
                System.exit(0);
            } else {
                print("Invalid option!");
            }
        }
    }
}