/*******************************************************************************
 * Copyright (c) 2016 AgentLab.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ru.agentlab.maia.agent.impl;

import java.lang.reflect.Method;
import java.util.Map;

import ru.agentlab.maia.agent.IPlanBody;
import ru.agentlab.maia.container.IInjector;

public class PlanBodyStateles implements IPlanBody {

	protected final Object role;

	protected final Method method;

	public PlanBodyStateles(Object role, Method method) {
		this.role = role;
		this.method = method;
	}

	@Override
	public void execute(IInjector injector, Map<String, Object> variables) throws Exception {
		method.invoke(role);
	}

}