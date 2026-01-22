package sparta.firstevent.application.parts.out;

import org.springframework.data.jpa.repository.JpaRepository;
import sparta.firstevent.domain.event.Event;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {
    Event save(Event event);

    Optional<Event> findById(Long id);

    List<Event> findAll();
}
