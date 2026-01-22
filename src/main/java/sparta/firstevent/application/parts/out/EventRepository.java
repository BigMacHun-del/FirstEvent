package sparta.firstevent.application.parts.out;

import org.springframework.data.jpa.repository.JpaRepository;
import sparta.firstevent.domain.event.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
