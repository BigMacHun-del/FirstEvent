package sparta.firstevent.application.service;

import sparta.firstevent.adapter.dto.EventRequestDto;
import sparta.firstevent.application.parts.in.EventGetUseCase;
import sparta.firstevent.application.parts.out.EventRepository;
import sparta.firstevent.domain.event.Event;

public class EventQueryService implements EventGetUseCase {
    private  EventRepository eventRepository;

}
