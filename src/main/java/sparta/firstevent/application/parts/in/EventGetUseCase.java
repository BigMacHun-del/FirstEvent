package sparta.firstevent.application.parts.in;

import sparta.firstevent.domain.event.Event;

import java.util.List;

public interface EventGetUseCase {
    List<Event> getAll();
}
