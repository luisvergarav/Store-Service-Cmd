package com.easygroup.neargrocery.StoreServiceCmd.eventsource.service;

import com.easygroup.neargrocery.StoreServiceCmd.eventsource.domain.message.Message;

public interface DomainEventSourceSender {

    void send( final Message<?> event );
}
