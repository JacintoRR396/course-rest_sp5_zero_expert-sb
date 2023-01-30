package com.sdjr2.rest_sp5_ztoe.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import com.fasterxml.jackson.databind.deser.std.NumberDeserializers.IntegerDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;

/**
* Config Spring Kafka to manager messages, producers and consumers.
*
* @author jroldan
* @version 1.0
* @since 23/01/30
* @upgrade 23/01/30
* @category Bean
*/
@Configuration
public class KafkaConfig {

	// Consumer properties
	@Bean
	public Map<String, Object> consumerProps(){
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "group");
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
		props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return props;
	}

	@Bean
	public ConsumerFactory<Integer, String> consumerFactory(){
		return new DefaultKafkaConsumerFactory<>(this.consumerProps());
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, String> kafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<> ();
		factory.setConsumerFactory(this.consumerFactory());
		return factory;
	}

}
