package ru.agentlab.maia.time.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

import ru.agentlab.maia.converter.PlanEventFilterConverter;
import ru.agentlab.maia.converter.PlanEventType;
import ru.agentlab.maia.converter.PlanExtraConverter;
import ru.agentlab.maia.time.TimerEvent;
import ru.agentlab.maia.time.annotation.converter.OnTimerFixedPeriodExtraPlansConverter;
import ru.agentlab.maia.time.annotation.converter.OnTimerXXXEventMatcherConverter;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@PlanEventType(TimerEvent.class)
@PlanEventFilterConverter(OnTimerXXXEventMatcherConverter.class)
@PlanExtraConverter(OnTimerFixedPeriodExtraPlansConverter.class)
public @interface OnTimerFixedPeriod {

	long value();

	long delay() default 0;

	TimeUnit unit() default TimeUnit.MILLISECONDS;

}