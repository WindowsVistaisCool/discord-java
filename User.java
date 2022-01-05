import java.util.Random;
public class User {
    private String name = null;
    private int id = 0;
    private int discriminator = 0000;
    private boolean hasNitro = false;
    private boolean isBot = false;

    public User(String name, boolean isBot) {
        this.name = name;
        this.id = GenerateID();
        this.discriminator = GenerateDiscrim();
        this.isBot = isBot;
    }
    
    private int GenerateDiscrim() { // Generate a new discriminator for the user
        Random rand = new Random();
        return rand.nextInt(10000); // Return a value from 0 to 9999
    }

    private int GenerateID() { // Generate ID (called from constructor)
        Random rand = new Random();
        return rand.nextInt(10000000);
    }

    public String getUser() { // Return a user with its respective discriminator
        return "" + this.name + "#" + this.discriminator;
    }

    public int getID() { // Return a user's ID 
        return this.id;
    }

    public boolean hasNitro() { // Return a user's nitro status
        return this.isBot ? this.hasNitro : false;
    }

    // 2 functions below change discriminators to parameter specified, one just also activates the nitro status
    public void ActivateNitro(int newDiscrim) { 
        if (isBot) { return; }
        this.discriminator = newDiscrim;
        this.hasNitro = true;
    }

    public void ChangeDiscrim(int newDiscrim) {
        if (!isBot) { return; }
        this.discriminator = newDiscrim;
    }

    public void DisableNitro() { // Disable nitro status
        if (isBot) { return; }
        this.discriminator = GenerateDiscrim();
        this.hasNitro = false;
    }
}
