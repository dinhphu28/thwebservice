package com.idb.webservice.Models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventModel {
    private String ticketId;

    private String eventName;

    private LocalDateTime time;
}
