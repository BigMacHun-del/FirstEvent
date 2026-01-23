package sparta.firstevent.application.ports.in;

import sparta.firstevent.domain.event.Event;

import java.util.List;

public interface EventGetUseCase {
    List<Event> getAll();
}
