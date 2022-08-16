package p4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import p3.User;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CollectionClassExtendedTest {
    private static final boolean ACTIVE = true;
    private static final boolean INACTIVE = false;
    private CollectionClassExtended collectionClassExtended;

    @BeforeEach
    void setUp() {
        List<User> users = Arrays.asList(
                new User("jkowalski", ACTIVE),
                new User("akowalski", ACTIVE),
                new User("jnowak", INACTIVE),
                new User("anowak", INACTIVE),
                new User("abach", INACTIVE)
        );
        collectionClassExtended = new CollectionClassExtended(users);
    }

    @Test
    void shouldGetAllUsers() {
        // given
        // when
        List<User> allUsers = collectionClassExtended.getAllUsers();
        // then
        assertThat(allUsers).hasSize(5);
    }
}