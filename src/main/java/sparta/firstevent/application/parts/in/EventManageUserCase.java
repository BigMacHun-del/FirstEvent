package sparta.firstevent.application.parts.in;

import sparta.firstevent.adapter.dto.EventRequestDto;
import sparta.firstevent.domain.event.Event;

public interface EventManageUserCase {
    Event regist(EventRequestDto dto);
}
