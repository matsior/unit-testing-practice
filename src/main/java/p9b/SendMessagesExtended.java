package p9b;

import p9b.Model.Statistic;
import p9b.Model.User;
import p9b.Service.MessageService;
import p9b.Service.UserService;

import java.util.HashMap;
import java.util.Map;

public class SendMessagesExtended {

    private final Map<String, String> toSend = new HashMap<>();
    private final UserService userService;
    private final MessageService messageService;

    public SendMessagesExtended(UserService userService, MessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;
    }

    public Statistic send(Map<String, String> toSend) {
        Statistic statistic = new Statistic();
        for (Map.Entry<String, String> entry : toSend.entrySet()) {
            boolean sent  = sendMessage(entry.getKey(), entry.getValue());
            statistic.collect(sent);
        }
        return statistic;
    }

    private boolean sendMessage(String username, String message) {
        if (userService.existsByUserName(username)) {
            User user = userService.getUserByName(username);
            return messageService.sendMessage(user.getEmail(), message);
        }
        return false;
    }
}
