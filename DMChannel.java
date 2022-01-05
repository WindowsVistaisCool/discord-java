public class DMChannel extends BaseChannel {
    private int sender = 0;
    private int reciever = 0;

    public DMChannel(int sender, int reciever) { // Assigns sender and reciever
        this.sender = sender;
        this.reciever = reciever;
    }

    public int returnSender() {
        return sender;
    }

    public int returnReciever() {
        return reciever;
    }

}