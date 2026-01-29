package sparta.firstevent.adapter.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import sparta.firstevent.adapter.dto.EventRequestDto;
import sparta.firstevent.application.ports.in.AdminEventManageUseCase;
import sparta.firstevent.domain.event.Event;
import sparta.firstevent.domain.event.EventFixture;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AdminEventController.class)
class AdminEventControllerMockTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private AdminEventManageUseCase adminEventManageUseCase;

    @Test
    void Event_생성_성공() throws Exception {
        // given
        EventRequestDto requestDto = new EventRequestDto(
                "title length is",          // 10자 이상
                "description",
                10,
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(2)
        );

        Event event = EventFixture.registEvent();
        ReflectionTestUtils.setField(event, "id", 1L);

        when(adminEventManageUseCase.regist(any(EventRequestDto.class)))
                .thenReturn(event);

        // when & then
        mockMvc.perform(
                        post("/api/admin/events")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(requestDto))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value(event.getTitle()))
                .andExpect(jsonPath("$.status").value(event.getStatus().name()));

        verify(adminEventManageUseCase).regist(any(EventRequestDto.class));
    }
}
