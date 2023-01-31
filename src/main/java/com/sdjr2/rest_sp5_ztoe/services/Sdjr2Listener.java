package com.sdjr2.rest_sp5_ztoe.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Component to manage listener of Kafka Server.
 *
 * @author jroldan
 * @version 1.0
 * @category Controller
 * @since 23/01/31
 * @upgrade 23/01/31
 */
//@Component
public class Sdjr2Listener {
	
	private static final Logger log = LoggerFactory.getLogger( Sdjr2Listener.class );

	@KafkaListener(topics="sdjr2-topic", groupId="sdjr2Group")
	public void listen( String msg ){
		log.info( "Message received {}", msg );
	}

}
