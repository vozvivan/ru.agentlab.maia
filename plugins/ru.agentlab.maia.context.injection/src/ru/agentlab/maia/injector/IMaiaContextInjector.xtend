package ru.agentlab.maia.injector

import java.lang.annotation.Annotation
import ru.agentlab.maia.context.IMaiaContext
import ru.agentlab.maia.context.IMaiaContextListener

interface IMaiaContextInjector {

	val public static String EVENT_INJECTOR_MAKE = "ru/agentlab/maia/injector/Make"

	val public static String EVENT_INJECTOR_INVOKE = "ru/agentlab/maia/injector/Invoke"

	val public static String EVENT_INJECTOR_INJECT = "ru/agentlab/maia/injector/Inject"

	def <T> T make(Class<T> contributorClass, IMaiaContext context)

	def Object invoke(Object object, Class<? extends Annotation> ann, IMaiaContext context)

	def Object invoke(Object object, Class<? extends Annotation> ann, IMaiaContext context, Object defaultValue)

	def void inject(Object service, IMaiaContext toContext)

	def void addListener(IMaiaContext context, String key, IMaiaContextListener listener)

	def void addListener(IMaiaContext context, Class<?> key, IMaiaContextListener listener)

}