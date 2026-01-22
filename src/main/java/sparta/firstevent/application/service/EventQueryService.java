package sparta.firstevent.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sparta.firstevent.adapter.dto.EventRequestDto;
import sparta.firstevent.application.parts.in.EventGetUseCase;
import sparta.firstevent.application.parts.out.EventRepository;
import sparta.firstevent.domain.event.Event;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventQueryService implements EventGetUseCase {
    private final EventRepository eventRepository;

    @Override
    public List<Event> getAll() {
        return eventRepository.findAll();
    }
}
