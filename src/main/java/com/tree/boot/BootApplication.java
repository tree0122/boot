package com.tree.boot;

import com.tree.boot.statemachine.Event;
import com.tree.boot.statemachine.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

@SpringBootApplication
public class BootApplication implements CommandLineRunner{

	@Autowired
	private StateMachine<State, Event> stateMachine;

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		stateMachine.start();
		stateMachine.sendEvent(Event.PAY);
		stateMachine.sendEvent(Event.RECEIVE);
	}
}
