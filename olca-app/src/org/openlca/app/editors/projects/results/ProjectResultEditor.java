package org.openlca.app.editors.projects.results;

import org.eclipse.swt.SWT;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.openlca.app.M;
import org.openlca.app.db.Cache;
import org.openlca.app.db.Database;
import org.openlca.app.editors.Editors;
import org.openlca.app.editors.SimpleEditorInput;
import org.openlca.app.editors.SimpleFormEditor;
import org.openlca.app.editors.projects.reports.ReportEditor;
import org.openlca.app.rcp.images.Images;
import org.openlca.app.util.Controls;
import org.openlca.app.util.FileType;
import org.openlca.app.util.Labels;
import org.openlca.app.util.UI;
import org.openlca.core.matrix.NwSetTable;
import org.openlca.core.model.ModelType;

public class ProjectResultEditor extends SimpleFormEditor {

	private ResultData data;

	public static void open(ResultData data) {
		if (data == null)
			return;
		var id = Cache.getAppCache().put(data);
		var input = new SimpleEditorInput(
			id, "Result of: " + Labels.name(data.project()));
		Editors.open(input, "ProjectResultEditor");
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
		throws PartInitException {
		super.init(site, input);
		var simpleInput = (SimpleEditorInput) input;
		var obj = Cache.getAppCache().remove(simpleInput.id);
		if (!(obj instanceof ResultData))
			throw new PartInitException("editor input must be a project result");
		data = (ResultData) obj;
		setPartName("Result of: " + Labels.name(data.project()));
	}

	@Override
	protected FormPage getPage() {
		return new Page(this);
	}

	private static class Page extends FormPage {

		private final ResultData data;

		Page(ProjectResultEditor editor) {
			super(editor, "ProjectResultEditor.Page", "Results");
			this.data = editor.data;
		}

		@Override
		protected void createFormContent(IManagedForm mform) {
			var form = UI.formHeader(mform,
				"Results of: " + Labels.name(data.project()));
			var tk = mform.getToolkit();
			var body = UI.formBody(form, tk);

			var buttonComp = tk.createComposite(body);
			UI.gridLayout(buttonComp, 2);
			var excelBtn = tk.createButton(
				buttonComp, M.ExcelExport, SWT.NONE);
			excelBtn.setImage(Images.get(FileType.EXCEL));
			UI.gridData(excelBtn, false, false).widthHint = 120;

			// report button
			var reportBtn = tk.createButton(
				buttonComp, "Create Report", SWT.NONE);
			reportBtn.setImage(Images.get(ModelType.PROJECT));
			UI.gridData(reportBtn, false, false).widthHint = 120;
			Controls.onSelect(
				reportBtn, $ -> ReportEditor.open(project, result));

			// create the sections
			ProjectVariantSection.of(data).renderOn(body, tk);
			TotalImpactSection.of(data).renderOn(body, tk);
			if (data.hasNormalization()) {
				NwSection.forNormalization(data).renderOn(body, tk);
			}
			if (data.hasWeighting()) {
				NwSection.forWeighting(data).renderOn(body, tk);
				SingleScoreSection.of(data).renderOn(body, tk);
			}
			ContributionSection.of(data).renderOn(body, tk);
		}
	}
}
