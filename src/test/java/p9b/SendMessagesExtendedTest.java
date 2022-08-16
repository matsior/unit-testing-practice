package p9b;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import p9b.Model.Statistic;
import p9b.Model.User;
import p9b.Service.MessageService;
import p9b.Service.UserService;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SendMessagesExtendedTest {

    @Mock
    private UserService userService;

    @Mock
    private MessageService messageService;

    @InjectMocks
    private SendMessagesExtended sendMessagesExtended;

    private Map<String, String> toSend = new HashMap<>();

    @BeforeEach
    void setUp() {
        toSend.put("jkowalski", "Hello jkowalski");
        toSend.put("anowak", "Hello anowak");
        toSend.put("mdabrowski", "Hello mdabrowski");
    }

    @Test
    void shouldSendMessagesToAllUsers() {
        when(userService.existsByUserName(anyString())).thenReturn(true);
        when(userService.getUserByName("jkowalski"))
                .thenReturn(new User("jkowalski", "jkowalski@test.pl"));
        when(userService.getUserByName("anowak"))
                .thenReturn(new User("anowak", "anowak@test.pl"));
        when(userService.getUserByName("mdabrowski"))
                .thenReturn(new User("mdabrowski", "mdabrowski@test.pl"));

        when(messageService.sendMessage(anyString(), anyString())).thenReturn(true);
        // when
        Statistic statistic = sendMessagesExtended.send(toSend);
        // then
        Assertions.assertThat(statistic.getSuccess()).isEqualTo(3);
        Assertions.assertThat(statistic.getFailure()).isEqualTo(0);
    }

    @Test
    void shouldNotSendMessagesToAnyUser() {
        when(userService.existsByUserName(anyString())).thenReturn(false);
        // when
        Statistic statistic = sendMessagesExtended.send(toSend);
        // then
        Assertions.assertThat(statistic.getSuccess()).isEqualTo(0);
        Assertions.assertThat(statistic.getFailure()).isEqualTo(3);
    }

    @Test
    void shouldNotSendMessagesToAnyUserWhenMessageServiceFailure() {
        when(userService.existsByUserName(anyString())).thenReturn(true);

        when(userService.getUserByName("jkowalski"))
                .thenReturn(new User("jkowalski", "jkowalski@test.pl"));
        when(userService.getUserByName("anowak"))
                .thenReturn(new User("anowak", "anowak@test.pl"));
        when(userService.getUserByName("mdabrowski"))
                .thenReturn(new User("mdabrowski", "mdabrowski@test.pl"));
        when(messageService.sendMessage(anyString(), anyString())).thenReturn(false);
        // when
        Statistic statistic = sendMessagesExtended.send(toSend);
        // then
        Assertions.assertThat(statistic.getSuccess()).isEqualTo(0);
        Assertions.assertThat(statistic.getFailure()).isEqualTo(3);
    }
}