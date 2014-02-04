package org.openlca.app.results.analysis;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.openlca.app.Messages;
import org.openlca.app.analysis.AnalyzeEditorInput;
import org.openlca.app.analysis.sankey.SankeyDiagram;
import org.openlca.app.db.Cache;
import org.openlca.app.results.TotalFlowResultPage;
import org.openlca.app.results.TotalImpactResultPage;
import org.openlca.core.math.CalculationSetup;
import org.openlca.core.model.ProductSystem;
import org.openlca.core.results.FullResult;
import org.openlca.core.results.FullResultProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * View for the analysis results of a product system.
 */
public class AnalyzeEditor extends FormEditor {

	public static final String ID = "editors.analyze";

	private Logger log = LoggerFactory.getLogger(getClass());

	private SankeyDiagram diagram;
	private int diagramIndex;
	private CalculationSetup setup;
	private FullResultProvider result;

	public CalculationSetup getSetup() {
		return setup;
	}

	public FullResultProvider getResult() {
		return result;
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		super.init(site, input);
		AnalyzeEditorInput editorInput = (AnalyzeEditorInput) input;
		String resultKey = editorInput.getResultKey();
		String setupKey = editorInput.getSetupKey();
		FullResult result = Cache.getAppCache().remove(resultKey,
				FullResult.class);
		setup = Cache.getAppCache().remove(setupKey, CalculationSetup.class);
		ProductSystem system = setup.getProductSystem();
		String name = Messages.ResultOf + " " + system.getName();
		setPartName(name);
		this.result = new FullResultProvider(result, Cache.getEntityCache());
	}

	@Override
	protected void addPages() {
		try {
			addPage(new AnalyzeInfoPage(this, result, setup));
			addPage(new TotalFlowResultPage(this, result));
			if (result.hasImpactResults())
				addPage(new TotalImpactResultPage(this, result));
			// addPage(new ContributionTablePage(this, result));
			// addPage(new ProcessResultPage(this, result));
			// if (result.hasImpactResults())
			// addPage(new FlowImpactPage(this, result));
			// addPage(new ContributionTreePage(this, result));
			// addPage(new GroupPage(this, result));
			// addPage(new LocationContributionPage(this, result));
			// if (FeatureFlag.SUNBURST_CHART.isEnabled())
			// addPage(new SunBurstView(this, result));
			// if (FeatureFlag.LOCALISED_LCIA.isEnabled()
			// && result.hasImpactResults())
			// addPage(new LocalisedImpactPage(this, result));
			// diagram = new SankeyDiagram(setup, result);
			// diagramIndex = addPage(diagram, getEditorInput());
			// setPageText(diagramIndex, "Sankey diagram");
		} catch (final PartInitException e) {
			log.error("Add pages failed", e);
		}
	}

	@Override
	public void doSave(final IProgressMonitor monitor) {
	}

	@Override
	public void doSaveAs() {

	}

	public SankeyDiagram getDiagram() {
		return diagram;
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public Object getSelectedPage() {
		Object page = super.getSelectedPage();
		if (page == null && getActivePage() == diagramIndex) {
			page = diagram;
		}
		return page;
	}

	@Override
	public void setFocus() {
	}

	@Override
	public void close(boolean save) {
		super.close(save);
	}

}
