import java.util.ArrayList;
import java.util.HashMap;

public class ConversationRepository implements AppRepository<Conversation, Long> {

    HashMap<Long, Conversation> conversations = new HashMap<>();
    @Override
    public Conversation save(Conversation conv) throws ConversationException {
        if (conv.getUser1().equals(conv.getUser2()))
            throw new SameSenderReceiverException("The sender is the same as the receiver");
        for (Conversation c : conversations.values())
        {
            if(conv.getUser1().equals(c.getUser2()) && conv.getUser2().equals(c.getUser1()))
                throw new ConversationAlreadyExistsException("The conversation already exists!");
        }
        conversations.put((long)conversations.size() + 1, conv);
        return conv;
    }

    @Override
    public Conversation findById(Long id) {
        return conversations.get(id);
    }

    @Override
    public Conversation delete(Conversation conv) {
        conversations.remove(conv);
        return conv;
    }

    public boolean conversationExists(Conversation conv) {
        for(Conversation c : conversations.values()) {
            if(c.equals(conv))
                return true;
        }
        return false;
    }
}
