package sparta.firstevent.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sparta.firstevent.adapter.dto.EventRequestDto;
import sparta.firstevent.application.parts.in.EventGetUseCase;
import sparta.firstevent.application.parts.in.EventManageUserCase;
import sparta.firstevent.application.parts.out.EventRepository;
import sparta.firstevent.domain.event.Event;

@Service
@RequiredArgsConstructor
public class EventCommandService implements EventManageUserCase {
    private final EventRepository eventRepository;


    @Override
    public Event regist(EventRequestDto requestDto) {
        return eventRepository.save(Event.regist(requestDto));
    }
}
