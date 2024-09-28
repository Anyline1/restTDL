package ru.anyline.resttdl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import ru.anyline.resttdl.DTO.ApplicationDTO;

import java.util.Optional;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.put;
import static org.springframework.test.web.client.ExpectedCount.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturn404NotFoundWhenRequestingNonExistentApplication() throws Exception {
        mockMvc.perform(get("/api/applications/999999")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldDeleteAnApplicationWhenItExists() throws Exception {
        Long existingAppId = 1L;
        when(applicationService.findById(existingAppId)).thenReturn(Optional.of(new ApplicationDTO(existingAppId, "Test App", "Test Developer")));

        mockMvc.perform(delete("/api/applications/" + existingAppId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(applicationService, times(1)).deleteById(existingAppId);
    }

    @Test
    public void shouldReturn405MethodNotAllowedForNonDeleteRequests() throws Exception {
        mockMvc.perform(post("/api/applications/999999")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isMethodNotAllowed());

        mockMvc.perform(put("/api/applications/999999")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isMethodNotAllowed());

        mockMvc.perform(get("/api/applications/999999")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotMethodNotAllowed());

        mockMvc.perform(delete("/api/applications/999999")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldHandleLargeApplicationIds() throws Exception {
        Long largeAppId = 999999999999999999L;
        when(applicationService.findById(largeAppId)).thenReturn(Optional.empty());

        mockMvc.perform(delete("/api/applications/" + largeAppId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturn404NotFoundWhenRequestingApplicationWithNegativeId() throws Exception {
        Long negativeAppId = -1L;
        when(applicationService.findById(negativeAppId)).thenReturn(Optional.empty());

        mockMvc.perform(delete("/api/applications/" + negativeAppId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

}


