package p9a;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SendMessagesSimple {

    private final List<String> existingUserList = Arrays.asList("jkowalski", "anowak", "mdabrowski");
    private final Map<String, String> toSend = new HashMap<>();

    public Statistic send() {
        Statistic statistic = new Statistic();
        for (Map.Entry<String, String> entry : toSend.entrySet()) {
            boolean sent  = sendMessage(entry.getKey(), entry.getValue());
            statistic.collect(sent);
        }
        return statistic;
    }

    public void addMessage(String user, String message) {
        toSend.put(user, message);
    }

    private boolean sendMessage(String user, String message) {
        if (existingUserList.contains(user)) {
            System.out.println("Send message to user: " + user + " message: " + message);
            return true;
        }
        return false;
    }
}
