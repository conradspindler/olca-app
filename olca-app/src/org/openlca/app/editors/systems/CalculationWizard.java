package org.openlca.app.editors.systems;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.Wizard;
import org.openlca.app.App;
import org.openlca.app.Messages;
import org.openlca.app.db.Cache;
import org.openlca.app.results.ResultEditorInput;
import org.openlca.app.results.analysis.AnalyzeEditor;
import org.openlca.app.results.quick.QuickResultEditor;
import org.openlca.app.results.regionalized.RegionalizedResultEditor;
import org.openlca.app.results.simulation.SimulationInit;
import org.openlca.app.util.Editors;
import org.openlca.app.util.Info;
import org.openlca.core.math.CalculationSetup;
import org.openlca.core.math.SystemCalculator;
import org.openlca.core.model.ProductSystem;
import org.openlca.core.results.ContributionResult;
import org.openlca.core.results.FullResult;
import org.openlca.geo.RegionalizedCalculator;
import org.openlca.geo.RegionalizedResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Wizard for setting calculation properties and run the calculation of a
 * product system
 */
class CalculationWizard extends Wizard {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	private CalculationWizardPage calculationPage;
	private ProductSystem productSystem;

	public CalculationWizard(ProductSystem productSystem) {
		this.productSystem = productSystem;
		setNeedsProgressMonitor(true);
		setWindowTitle(Messages.CalculationProperties);
	}

	@Override
	public void addPages() {
		calculationPage = new CalculationWizardPage(productSystem);
		addPage(calculationPage);
	}

	@Override
	public boolean performFinish() {
		CalculationSetup setup = calculationPage.getSetup();
		CalculationType type = calculationPage.getCalculationType();
		try {
			Calculation calculation = new Calculation(setup, type);
			getContainer().run(true, true, calculation);
			return calculation.done;
		} catch (Exception e) {
			log.error("Calculation failed", e);
			return false;
		}
	}

	private class Calculation implements IRunnableWithProgress {

		private CalculationSetup setup;
		private CalculationType type;
		private boolean done;

		public Calculation(CalculationSetup setup, CalculationType type) {
			this.setup = setup;
			this.type = type;
		}

		@Override
		public void run(IProgressMonitor monitor)
				throws InvocationTargetException, InterruptedException {
			monitor.beginTask(Messages.RunCalculation, IProgressMonitor.UNKNOWN);
			int size = productSystem.getProcesses().size();
			log.trace("calculate a {} x {} system", size, size);
			switch (type) {
			case ANALYSIS:
				analyse();
				break;
			case MONTE_CARLO:
				simulate();
				break;
			case QUICK:
				solve();
				break;
			case REGIONALIZED:
				calcRegionalized();
				break;
			default:
				break;
			}
			monitor.done();
		}

		private void analyse() {
			log.trace("run analysis");
			SystemCalculator calculator = new SystemCalculator(
					Cache.getMatrixCache(), App.getSolver());
			FullResult result = calculator.calculateFull(setup);
			log.trace("calculation done, open editor");
			ResultEditorInput input = getEditorInput(result);
			Editors.open(input, AnalyzeEditor.ID);
			done = true;
		}

		private void solve() {
			log.trace("run quick calculation");
			SystemCalculator calculator = new SystemCalculator(
					Cache.getMatrixCache(), App.getSolver());
			ContributionResult result = calculator
					.calculateContributions(setup);
			log.trace("calculation done, open editor");
			ResultEditorInput input = getEditorInput(result);
			Editors.open(input, QuickResultEditor.ID);
			done = true;
		}

		private void calcRegionalized() {
			log.trace("calculate regionalized result");
			RegionalizedCalculator calculator = new RegionalizedCalculator(
					Cache.getMatrixCache(), App.getSolver());
			RegionalizedResult result = calculator.calculate(setup,
					Cache.getEntityCache());
			if (result == null) {
				Info.showBox("No regionalized information available for this system");
				return;
			}
			ResultEditorInput input = getEditorInput(result);
			Editors.open(input, RegionalizedResultEditor.ID);
			done = true;
		}

		private void simulate() {
			log.trace("init Monte Carlo Simulation");
			SimulationInit init = new SimulationInit(setup,
					Cache.getMatrixCache());
			init.run();
			done = true;
		}

		private ResultEditorInput getEditorInput(Object result) {
			String resultKey = Cache.getAppCache().put(result);
			String setupKey = Cache.getAppCache().put(setup);
			return new ResultEditorInput(setup.getProductSystem().getId(),
					resultKey, setupKey);
		}

	}
}
