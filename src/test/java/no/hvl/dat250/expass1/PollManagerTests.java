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
public class  PollManagerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PollManager pollManager;

    @Test
    public void testCreateNewUser() throws Exception {
        String userInfoJson = "{ \"username\": \"tester\", \"email\": \"tester@example.com\"}";

        MvcResult result = mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userInfoJson))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println("User added status: " + result.getResponse().getStatus());

        // Verify that the user is present in the PollManager
        Polls.User user = pollManager.getUserByUsername("tester");
        System.out.println("User from PollManager: " + user);
        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo("tester");
        assertThat(user.getEmail()).isEqualTo("tester@example.com");
    }
}
