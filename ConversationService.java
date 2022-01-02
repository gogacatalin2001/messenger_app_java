import java.util.ArrayList;
import java.util.List;

public class ConversationService {

    private final ConversationRepository conversationRepository = new ConversationRepository();

    public Conversation createConversation(User u1, User u2, UserService uServ) throws ConversationException {
        if(uServ.isRegistered(u1) && uServ.isRegistered(u2))
        {
            Conversation c = new Conversation(u1, u2);
            conversationRepository.save(c);
            return c;
        }

        else
            throw new UserNotRegisteredException("One or both users are not registered!");
    }

    public boolean send(Conversation conv, Message msg) {
        if(conversationRepository.conversationExists(conv) && !msg.getText().isBlank())
            return conv.addMessage(msg);
        return false;
    }

    public List<Conversation> findAllByUser(User user) {
        List<Conversation> userConversations = new ArrayList<>();
        for(Conversation c : conversationRepository.conversations.values()) {
            if(c.getUser1().equals(user) || c.getUser2().equals(user))
                userConversations.add(c);
        }
        return userConversations;
    }

    public String delete(Conversation conversation, Message message) {
        if(!conversationRepository.conversationExists(conversation))
            return "The conversation doesn't exist!";
        if(!conversation.deleteMessage(message))
            return "Message \"" + message.getText() + "\" doesn't exist!";
        return "Message \"" + message.getText() + "\" deleted successfully";
        }
}
