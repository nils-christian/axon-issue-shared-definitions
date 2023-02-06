package com.example.demo;

import java.util.HashSet;
import java.util.List;
import org.axonframework.messaging.annotation.HandlerEnhancerDefinition;
import org.axonframework.messaging.annotation.MultiHandlerDefinition;
import org.axonframework.messaging.annotation.MultiHandlerEnhancerDefinition;
import org.axonframework.spring.config.annotation.HandlerDefinitionFactoryBean;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.ParentContextApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class DemoApplication {

	public static void main( final String[] args ) {
		final SpringApplication parentApplication = new SpringApplication( DemoApplication.class );
		parentApplication.setBannerMode( Mode.OFF );
		final ConfigurableApplicationContext parentContext = parentApplication.run( args );

		final SpringApplication springApplication1 = new SpringApplication( MyAxonConfiguration.class );
		springApplication1.addInitializers( new ParentContextApplicationContextInitializer( parentContext ) );
		springApplication1.setBannerMode( Mode.OFF );
		final ConfigurableApplicationContext child1Context = springApplication1.run( args );

		final SpringApplication springApplication2 = new SpringApplication( MyAxonConfiguration.class );
		springApplication2.addInitializers( new ParentContextApplicationContextInitializer( parentContext ) );
		springApplication2.setBannerMode( Mode.OFF );
		final ConfigurableApplicationContext child2Context = springApplication2.run( args );

		final MultiHandlerDefinition handlerDefinitionChild1 = ( MultiHandlerDefinition ) child1Context.getBean( HandlerDefinitionFactoryBean.class ).getObject( );
		final MultiHandlerDefinition handlerDefinitionChild2 = ( MultiHandlerDefinition ) child2Context.getBean( HandlerDefinitionFactoryBean.class ).getObject( );
		final List<HandlerEnhancerDefinition> handlerEnhancerDefinitionsChild1 = ( ( MultiHandlerEnhancerDefinition ) handlerDefinitionChild1.getHandlerEnhancerDefinition( ) ).getDelegates( );
		final List<HandlerEnhancerDefinition> handlerEnhancerDefinitionsChild2 = ( ( MultiHandlerEnhancerDefinition ) handlerDefinitionChild2.getHandlerEnhancerDefinition( ) ).getDelegates( );

		final HashSet<Object> intersectionOfDefinitions = new HashSet<>( );
		intersectionOfDefinitions.addAll( handlerEnhancerDefinitionsChild1 );
		intersectionOfDefinitions.retainAll( handlerEnhancerDefinitionsChild2 );
		System.out.println( intersectionOfDefinitions );
	}

}
