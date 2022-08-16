package p3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CollectionClassTest {

    private CollectionClass collectionClass = new CollectionClass();

    @Test
    void shouldGetAllUsers() {
        // when
        List<User> allUsers = collectionClass.getAllUsers();
        // then
        assertThat(allUsers)
                .hasSize(5)
                .isNotNull();
    }

    @Test
    void shouldGetAllActiveUsers() {
        // when
        List<User> allActiveUsers = collectionClass.getAllActiveUsers();
        // then
        assertThat(allActiveUsers).extracting("isActive").containsOnly(true);
    }

    @Test
    void shouldGetAllInactiveUsers() {
        // when
        List<User> allInactiveUsers = collectionClass.getAllInactiveUsers();
        // then
        assertThat(allInactiveUsers).extracting("isActive").containsOnly(false);
    }

    @Test
    void shouldContainSpecificUsersInOrder() {
        // when
        List<User> allActiveUsers = collectionClass.getAllActiveUsers();
        // then
        assertThat(allActiveUsers).extracting("isActive").containsOnly(true);
        assertThat(allActiveUsers).extracting("name")
                .containsExactly("jkowalski", "akowalski");
    }
}