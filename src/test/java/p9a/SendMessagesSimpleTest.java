package p9a;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SendMessagesSimpleTest {

    private SendMessagesSimple sendMessagesSimple = new SendMessagesSimple();

    @Test
    void shouldSendMessageToUser() {
        // given
        sendMessagesSimple.addMessage("jkowalski", "Hello jkowalski");
        sendMessagesSimple.addMessage("anowak", "Hello anowak");
        sendMessagesSimple.addMessage("mdabrowski", "Hello mdabrowski");
        // when
        Statistic statistic = sendMessagesSimple.send();
        // then
        assertThat(statistic.getSuccess()).isEqualTo(3);
        assertThat(statistic.getFailure()).isEqualTo(0);
    }

    @Test
    void shouldNotSendMessageToNonExistingUser() {
        // given
        sendMessagesSimple.addMessage("xyx", "Hello xyx");
        sendMessagesSimple.addMessage("qwe", "Hello qwe");
        sendMessagesSimple.addMessage("abc", "Hello abc");
        // when
        Statistic statistic = sendMessagesSimple.send();
        // then
        assertThat(statistic.getFailure()).isEqualTo(3);
        assertThat(statistic.getSuccess()).isEqualTo(0);
    }

    @Test
    void shouldNotSendMessageToAnyUser() {
        // when
        Statistic statistic = sendMessagesSimple.send();
        // then
        assertThat(statistic.getSuccess()).isEqualTo(0);
        assertThat(statistic.getFailure()).isEqualTo(0);
    }
}