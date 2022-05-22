package com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.repository;

import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.event.Event;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class EventStore {

  private final List<Event> eventStore = new ArrayList<>();

  public void addEvent(Event event) {
    eventStore.add(event);
  }

  public List<Event> getEventsAfterOrderAsc(Date dateAfter) {
    List<Event> events = eventStore.stream().filter(e -> e.getCreatedDate().after(dateAfter))
      .collect(Collectors.toList());
    Collections.reverse(events); // Return events in creation order
    return events;
  }
}
