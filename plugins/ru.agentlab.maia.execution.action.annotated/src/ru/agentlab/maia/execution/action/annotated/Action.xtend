package ru.agentlab.maia.execution.action.annotated

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

/**
 * <p>Annotation indicated method of behaviour contributor to be invoked while 
 * behaviour execute. Execution order will depends on behaviour type (e.g. OneShot, 
 * Cyclyc, Ticker or any others. Set of supported behaviour types depends 
 * on installed {@link IBehaviourFactory IBehaviourFactory} 
 * implementation).</p>
 * <p>Example of using annotation:</p>
 * <pre>
 * public class BehaviourExample {
 * 
 *   &#64;Action
 *   public void action() {
 *     System.out.println("On Action...");
 *   }
 * 
 * }</pre>
 * 
 * @author <a href='shishkin_dimon@gmail.com'>Shishkin Dmitriy</a> - Initial contribution.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
annotation Action {
}