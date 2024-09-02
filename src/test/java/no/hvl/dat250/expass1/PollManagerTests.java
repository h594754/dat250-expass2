package no.hvl.dat250.expass1;

import no.hvl.dat250.expass1.components.PollManager;
import no.hvl.dat250.expass1.domains.Polls;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PollManagerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PollManager pollManager;

    @BeforeEach
    public void setup() {
        pollManager = new PollManager();
    }

    @Test
    public void testCreateNewUser() throws Exception {
        String userInfoJson = "{ \"username\": \"test_user\", \"email\": \"test_user@example.com\"}";


        MvcResult result = mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userInfoJson))
                .andExpect(status().isOk())
                .andReturn();

        Polls.User user = pollManager.getUserByUsername("test_user");
        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo("test_user");
        assertThat(user.getEmail()).isEqualTo("test_user@example.com");
    }
}
