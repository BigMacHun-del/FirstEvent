package sparta.firstevent.application.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.transaction.annotation.Transactional;
import sparta.firstevent.adapter.dto.EventRequestDto;
import sparta.firstevent.application.ports.in.EventManageUseCase;
import sparta.firstevent.application.ports.out.EventRepository;
import sparta.firstevent.domain.event.Event;
import sparta.firstevent.domain.event.EventFixture;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@SpringBootTest
@Transactional
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

    @Test
    void modify() {
        String title = "modified title";
        EventRequestDto requestDto = EventFixture.createEventRequestDto();
        Event savedEvent = eventManageUseCase.regist(requestDto);

        Event updatedEvent = eventManageUseCase.update(savedEvent.getId(), EventFixture.createEventRequestDto(title));

        assertThat(updatedEvent.getTitle()).isEqualTo(title);
    }

//    @Test
//    void registStub() {
//
//        EventManageUseCase eventManageUseCase = new EventCommandService(new EventRepositoryStub());
//        EventRequestDto requestDto = new EventRequestDto(
//            "test title",
//            "test description",
//            10,
//            LocalDateTime.now(),
//            LocalDateTime.now().plusHours(1)
//        );
//
//        Event savedEvent = eventManageUseCase.regist(requestDto);
//        assertThat(savedEvent.getId()).isNotNull();
//
//    }
//
//    @Test
//    void regist() {
//        EventRepository repository = mock(EventRepository.class);
//
//        EventManageUseCase eventManageUseCase = new EventCommandService(repository);
//        EventRequestDto requestDto = new EventRequestDto(
//            "test title",
//            "test description",
//            10,
//            LocalDateTime.now(),
//            LocalDateTime.now().plusHours(1)
//        );
//
//        Event savedEvent = eventManageUseCase.regist(requestDto);
//
//        verify(repository).save(any());
//    }
//
//    static class EventRepositoryStub implements EventRepository {
//
//
//        @Override
//        public Event save(Event event) {
//            ReflectionTestUtils.setField(event, "id", 1L);
//            return event;
//        }
//    }

}