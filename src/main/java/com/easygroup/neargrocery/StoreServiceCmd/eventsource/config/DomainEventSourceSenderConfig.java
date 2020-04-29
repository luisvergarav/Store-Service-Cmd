package com.easygroup.neargrocery.StoreServiceCmd.eventsource.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.easygroup.neargrocery.StoreServiceCmd.eventsource.service.DomainEventSourceSender;
import com.easygroup.neargrocery.StoreServiceCmd.eventsource.service.DomainEventSourceSenderImpl;


@Profile( "kafka" )
@Configuration
@EnableAutoConfiguration
public class DomainEventSourceSenderConfig {

    public static final String BOARD_EVENTS_SNAPSHOTS = "board-events-snapshots";

    @Bean
    @Primary
    public DomainEventSourceSender domainEventSourceSender(  ) {

        return new DomainEventSourceSenderImpl( );
    }

}
