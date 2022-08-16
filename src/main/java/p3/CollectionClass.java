package p3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionClass {

    private static final List<User> users = new ArrayList<>();
    protected static final boolean ACTIVE = true;
    private static final boolean INACTIVE = false;

    static {
        users.add(new User("jkowalski", ACTIVE));
        users.add(new User("akowalski", ACTIVE));
        users.add(new User("jnowak", INACTIVE));
        users.add(new User("anowak", INACTIVE));
        users.add(new User("abach", INACTIVE));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public List<User> getAllActiveUsers() {
        return users.stream()
                .filter(User::isActive)
                .collect(Collectors.toList());
    }

    public List<User> getAllInactiveUsers() {
        return users.stream()
                .filter(user -> !user.isActive())
                .collect(Collectors.toList());
    }
}
