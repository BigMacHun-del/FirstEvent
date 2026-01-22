package sparta.firstevent.application.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sparta.firstevent.adapter.dto.EventRequestDto;
import sparta.firstevent.application.parts.in.EventManageUseCase;
import sparta.firstevent.domain.event.Event;
import sparta.firstevent.domain.event.EventFixture;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EventCommandServiceTest {

    @Autowired
    EventManageUseCase eventManageUseCase;

    @Test
    void regist() {
        EventRequestDto requestDto = EventFixture.createEventRequestDto();
        Event savedEvent = eventManageUseCase.regist(requestDto);

        assertThat(savedEvent.getId()).isNotNull();
        assertThat(savedEvent.getTitle()).isEqualTo(requestDto.getTitle());
    }

//    @Test
//    void modify() {
//        String title = "modified title";
//        EventRequestDto requestDto = EventFixture.createEventRequestDto();
//        Event savedEvent = eventManageUseCase.regist(requestDto);
//
//        Event updatedEvent = eventManageUseCase.update(savedEvent.getId(), EventFixture.createEventRequestDto(title));
//
//        assertThat(updatedEvent.getTitle()).isEqualTo(title);
//    }

    //SpringBootTest를 쓰지 않는 단위 테스트
    /*
    @Test
    void registStub() {

        EventManageUseCase eventManageUseCase = new EventCommandService(new EventRepositoryStub());
        EventRequestDto requestDto = new EventRequestDto(
            "test title",
            "test description",
            10,
            LocalDateTime.now(),
            LocalDateTime.now().plusHours(1)
        );

        Event savedEvent = eventManageUseCase.regist(requestDto);
        assertThat(savedEvent.getId()).isNotNull();

    }

    @Test
    void regist() {
        EventRepository repository = mock(EventRepository.class);

        EventManageUseCase eventManageUseCase = new EventCommandService(repository);
        EventRequestDto requestDto = new EventRequestDto(
            "test title",
            "test description",
            10,
            LocalDateTime.now(),
            LocalDateTime.now().plusHours(1)
        );

        Event savedEvent = eventManageUseCase.regist(requestDto);

        verify(repository).save(any());
    }

    static class EventRepositoryStub implements EventRepository {


        @Override
        public Event save(Event event) {
            ReflectionTestUtils.setField(event, "id", 1L);
            return event;
        }
    }
    */
}
