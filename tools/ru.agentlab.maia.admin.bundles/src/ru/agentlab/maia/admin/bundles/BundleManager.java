package ru.agentlab.maia.admin.bundles;

import static ru.agentlab.maia.annotation.belief.AxiomType.DATA_PROPERTY_ASSERTION;
import static ru.agentlab.maia.annotation.belief.AxiomType.OBJECT_PROPERTY_ASSERTION;

import javax.inject.Named;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

import ru.agentlab.maia.admin.bundles.internal.Activator;
import ru.agentlab.maia.annotation.belief.HaveBelief;
import ru.agentlab.maia.annotation.belief.Prefix;
import ru.agentlab.maia.annotation.goal.AddedGoal;

@Prefix(name = "osgi", namespace = "http://www.agentlab.ru/ontologies/osgi")
public class BundleManager {

	@AddedGoal(value = { "?bundle", "osgi:hasBundleState", "osgi:STARTRED" }, type = OBJECT_PROPERTY_ASSERTION)
	@HaveBelief(value = { "?bundle", "osgi:hasBundleState", "osgi:INSTALLED" }, type = OBJECT_PROPERTY_ASSERTION)
	@HaveBelief(value = { "?bundle", "osgi:hasBundleId", "?bundleId" }, type = DATA_PROPERTY_ASSERTION)
	public void startBundle(@Named("bundleId") long bundleId) throws BundleException {
		Bundle bundle = Activator.context.getBundle(bundleId);
		bundle.start();
	}

	@AddedGoal(value = { "?bundle", "osgi:hasBundleState", "osgi:INSTALLED" }, type = OBJECT_PROPERTY_ASSERTION)
	@HaveBelief(value = { "?bundle", "osgi:hasBundleLocation", "?location" }, type = DATA_PROPERTY_ASSERTION)
	public void installBundle(@Named("location") String location) throws BundleException {
		Activator.context.installBundle(location);
	}

}
