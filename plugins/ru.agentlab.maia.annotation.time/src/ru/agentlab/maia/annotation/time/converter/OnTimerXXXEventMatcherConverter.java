package ru.agentlab.maia.annotation.time.converter;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static ru.agentlab.maia.agent.EventMatchers.hamcrest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.UUID;

import ru.agentlab.maia.IEventMatcher;
import ru.agentlab.maia.annotation.IEventMatcherConverter;

public class OnTimerXXXEventMatcherConverter implements IEventMatcherConverter {

	public static final String EVENT_KEY = "eventKey";

	@Override
	@SuppressWarnings("unchecked")
	public IEventMatcher getMatcher(Object role, Method method, Annotation annotation, Map<String, Object> customData) {
		final UUID eventKey = UUID.randomUUID();
		customData.put(EVENT_KEY, eventKey);
		return hamcrest(allOf(hasProperty(EVENT_KEY, equalTo(eventKey))));
	}

}