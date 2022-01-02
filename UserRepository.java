import java.util.HashMap;
import java.util.HashSet;

public class UserRepository implements AppRepository<User, Long> {

    public HashMap<Long, User> users = new HashMap<>();
    private HashSet<String> registeredEmails = new HashSet<>();

    @Override
    public User save(User user) throws EmailAlreadyRegisteredException {

        if (!registeredEmails.add(user.getEmail()) )
            throw new EmailAlreadyRegisteredException("A user with this email is already registered!");
        users.put((long) users.size() + 1, user);
        return user;
    }

    @Override
    public User findById(Long id) {
        return users.get(id);
    }

    @Override
    public User delete(User user) {
        users.remove(user);
        registeredEmails.remove(user.getEmail());
        return user;
    }
}
