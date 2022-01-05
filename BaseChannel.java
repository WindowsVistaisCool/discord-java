public class BaseChannel {
    
    public void send(String authorID, String content) {
        System.out.println("<" + authorID + "> " + content); // "Send" a message to the "channel"
    }

}
