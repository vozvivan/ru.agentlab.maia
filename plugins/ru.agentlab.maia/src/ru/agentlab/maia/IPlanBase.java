/*******************************************************************************
 * Copyright (c) 2016 AgentLab.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ru.agentlab.maia;

import java.util.Collection;
import java.util.stream.Stream;

public interface IPlanBase {

	void add(Class<?> type, IPlan plan);

	void remove(Class<?> type, IPlan plan);

	Collection<IPlan> getPlans();

	Stream<IPlan> getPlansStream();

	Iterable<Option> getOptions(IEvent<?> event);

}
