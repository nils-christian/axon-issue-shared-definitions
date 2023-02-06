package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import( {
		org.axonframework.springboot.autoconfig.MetricsAutoConfiguration.class,
		org.axonframework.springboot.autoconfig.MicrometerMetricsAutoConfiguration.class,
		org.axonframework.springboot.autoconfig.EventProcessingAutoConfiguration.class,
		org.axonframework.springboot.autoconfig.AxonAutoConfiguration.class,
		org.axonframework.springboot.autoconfig.legacyjpa.JpaJavaxAutoConfiguration.class,
		org.axonframework.springboot.autoconfig.legacyjpa.JpaJavaxEventStoreAutoConfiguration.class,
		org.axonframework.springboot.autoconfig.JpaAutoConfiguration.class,
		org.axonframework.springboot.autoconfig.JpaEventStoreAutoConfiguration.class,
		org.axonframework.springboot.autoconfig.JdbcAutoConfiguration.class,
		org.axonframework.springboot.autoconfig.TransactionAutoConfiguration.class,
		org.axonframework.springboot.autoconfig.NoOpTransactionAutoConfiguration.class,
		org.axonframework.springboot.autoconfig.InfraConfiguration.class,
		org.axonframework.springboot.autoconfig.ObjectMapperAutoConfiguration.class,
		org.axonframework.springboot.autoconfig.AxonServerAutoConfiguration.class,
		org.axonframework.springboot.autoconfig.XStreamAutoConfiguration.class,
		org.axonframework.springboot.autoconfig.AxonServerActuatorAutoConfiguration.class,
		org.axonframework.springboot.autoconfig.AxonServerBusAutoConfiguration.class,
		org.axonframework.springboot.autoconfig.AxonTracingAutoConfiguration.class,
		org.axonframework.springboot.autoconfig.OpenTelemetryAutoConfiguration.class
} )
public class MyAxonConfiguration {

}
