package com.tree.boot.statemachine;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<State, Event>{

    @Override
    public void configure(StateMachineStateConfigurer<State, Event> stateConfigurer) throws Exception {
        stateConfigurer.withStates()
                .initial(State.UNPAID)
                .states(EnumSet.allOf(State.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<State, Event> transitionConfigurer) throws Exception {
        transitionConfigurer
                .withExternal()
                .source(State.UNPAID).target(State.WAITING_FOR_RECEIVE)
                .event(Event.PAY)
                .and()
                .withExternal()
                .source(State.WAITING_FOR_RECEIVE).target(State.DONE)
                .event(Event.RECEIVE);
    }

}
