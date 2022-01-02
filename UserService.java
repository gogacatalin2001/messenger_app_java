public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public User register (User user) throws EmailAlreadyRegisteredException{
        try {
            userRepository.save(user);
        } catch (EmailAlreadyRegisteredException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public User getUser(Long id) {
        return userRepository.findById(id);
    }

    public boolean isRegistered(User user) {
        for(User u : userRepository.users.values()) {
            if(u.equals(user))
                return true;
        }
        return false;
    }
}
