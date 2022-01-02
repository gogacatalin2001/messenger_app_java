public class Messenger {
    public static void main(String[] args) {

        UserService userService = new UserService();
        ConversationService conversationService = new ConversationService();

        User user1, user2, user3;

        try {
            user1 = userService.register(new User("gogacatalin", "cata2001", "gogacatalin2001@yahoo.com"));
            user2 = userService.register(new User("gabriel_crisan", "gabitza", "gabibaba@yahoo.com"));
            user3 = userService.register(new User("moga_bogdan", "sparta", "moga_b@yahoo.com"));
            //User userT = userService.register(new User("gogacatalin", "cata2001", "gogacatalin2001@yahoo.com"));

            Message m1 = new Message(user1, user2, "Hello! Is this working?");
            Conversation c1 = conversationService.createConversation(user1, user2, userService);
            conversationService.send(c1, m1);
            conversationService.send(c1, new Message(user2, user1, "It seems like."));
            c1.printAllMessages();

            System.out.println(conversationService.delete(c1, m1));
            System.out.println(conversationService.delete(c1, m1));

            Conversation c2 = conversationService.createConversation(user1, user3, userService);
            conversationService.send(c2, new Message(user1, user3, "La cat ajungeti?"));
            conversationService.send(c2, new Message(user3, user1, "In vreo ora."));

            Conversation c3 = new Conversation(user2, user3);
            System.out.println(conversationService.delete(c3, new Message(user3, user2, "No message")));

        } catch (EmailAlreadyRegisteredException e) {
            e.printStackTrace();
        } catch (ConversationException e) {
            e.printStackTrace();
        }


    }
}
