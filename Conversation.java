import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Conversation {

    final private User user1;
    final private User user2;
    final private LocalDateTime createdOn;
    private ArrayList<Message> messages;

    public Conversation(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
        this.createdOn = LocalDateTime.now();
        this.messages = new ArrayList<>();
    }

    public User getUser1() {
        return user1;
    }

    public User getUser2() {
        return user2;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public LocalDateTime getDateTime() {
        return createdOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conversation that = (Conversation) o;
        return user1.equals(that.user1) && user2.equals(that.user2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user1, user2);
    }

    public boolean addMessage(Message msg) {
        if(msg != null)
            return messages.add(msg);
        return false;
    }

    public boolean deleteMessage(Message message) {
        return messages.remove(message);
    }

    public void printAllMessages() {
        for(Message msg : messages) {
            System.out.println("Sent by " + msg.getSender().getUsername() + ": " + msg.getText());
        }
    }

}
