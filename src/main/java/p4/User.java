package p4;

public class User {
    private String name;
    private boolean isActive;

    public User(String name, boolean isActive) {
        this.name = name;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return isActive;
    }
}
