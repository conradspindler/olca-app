package org.openlca.app;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.eclipse.osgi.util.NLS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class Messages extends NLS {

	public static String AccessAndUseRestrictions;
	public static String Actor;
	public static String Actors;
	public static String CreatesANewActor;
	public static String NewActor;
	public static String Add;
	public static String CreateNew;
	public static String AdditionalInformation;
	public static String Address;
	public static String AdministrativeInformation;
	public static String AllocationMethod;
	public static String Amount;
	public static String AsDefinedInProcesses;
	public static String Author;
	public static String AvoidedProduct;
	public static String BuildNextTier;
	public static String Calculate;
	public static String CalculateCosts;
	public static String CalculateDefaultValues;
	public static String CalculationWizardDescription;
	public static String Analysis;
	public static String CalculationType;
	public static String NumberOfIterations;
	public static String QuickResults;
	public static String CalculationProperties;
	public static String CASNumber;
	public static String Category;
	public static String Causal;
	public static String CheckForUpdates;
	public static String ChooseDirectory;
	public static String ToDirectory;
	public static String City;
	public static String Code;
	public static String Complete;
	public static String CompleteReferenceData;
	public static String ConnectProviders;
	public static String ConnectRecipients;
	public static String ConsumedBy;
	public static String Context;
	public static String Contribution;
	public static String ConversionFactor;
	public static String Copy;
	public static String Copyright;
	public static String Country;
	public static String CreateANewProductFlowForTheProcess;
	public static String CreateProductSystem;
	public static String CreationDate;
	public static String Cut;
	public static String Cutoff;
	public static String Daily;
	public static String Database;
	public static String DatabaseImport;
	public static String DatabaseImportDescription;
	public static String DataCollectionPeriod;
	public static String DataCompleteness;
	public static String DataDocumentor;
	public static String DataGenerator;
	public static String DataSelection;
	public static String DataSetOtherEvaluation;
	public static String DataSetOwner;
	public static String DataSourceInformation;
	public static String DataTreatment;
	public static String DefaultMethod;
	public static String DefaultFlowProperty;
	public static String DefaultProvider;
	public static String Delete;
	public static String DeleteDatabase;
	public static String AnalyzingForProblems;
	public static String SolvingProblems;
	public static String Description;
	public static String Direction;
	public static String Doi;
	public static String Economic;
	public static String CreatingEcoSpoldFolder;
	public static String ExportingProcesses;
	public static String ExportEcoSpold;
	public static String ImportEcoSpold;
	public static String Edit;
	public static String ElementaryFlow;
	public static String Email;
	public static String EmptyDatabase;
	public static String NoQuantitativeReferenceSelected;
	public static String NoReferenceFlowPropertySelected;
	public static String ReferenceUnitIsEmptyOrInvalid;
	public static String EndDate;
	public static String English;
	public static String Error;
	public static String ProcessEvaluationAndValidation;
	public static String Export;
	public static String ExportingTo;
	public static String ExportToExcel;
	public static String ExportDatabase;
	public static String Factor;
	public static String NoDescription;
	public static String File;
	public static String FileAlreadyExists;
	public static String FromDirectory;
	public static String FileImportPage_Description;
	public static String SelectImportFiles;
	public static String Filter;
	public static String Flow;
	public static String FlowContributions;
	public static String FlowProperties;
	public static String FlowProperty;
	public static String NoUnitGroupSelected;
	public static String FlowPropertyType;
	public static String CreatesANewFlowProperty;
	public static String Flows;
	public static String CreatesANewFlow;
	public static String FlowType;
	public static String Formula;
	public static String FunctionalUnit;
	public static String GeneralInformation;
	public static String Geography;
	public static String GeometricMean;
	public static String GeometricStandardDeviation;
	public static String German;
	public static String Global;
	public static String GlobalParameters;
	public static String Goal;
	public static String GoalAndScope;
	public static String Group;
	public static String Grouping;
	public static String Groups;
	public static String Hourly;
	public static String ExportILCD;
	public static String ImportILCD;
	public static String ImpactCategories;
	public static String ImpactCategory;
	public static String ImpactContributions;
	public static String ImpactFactors;
	public static String ImpactAssessmentMethod;
	public static String ImpactAssessmentMethods;
	public static String Import;
	public static String ImportDatabase;
	public static String Information;
	public static String InfrastructureProcess;
	public static String InputsOutputs;
	public static String Inputs;
	public static String IntendedApplication;
	public static String InfrastructureFlow;
	public static String IsReference;
	public static String Language;
	public static String SelectAUserInterfaceLanguage;
	public static String SelectLanguageNoteMessage;
	public static String LastChange;
	public static String LastModificationDate;
	public static String Latitude;
	public static String LifeCycleInventory;
	public static String LCIMethod;
	public static String Location;
	public static String Locations;
	public static String LogNormalDistribution;
	public static String Longitude;
	public static String Map;
	public static String Maximum;
	public static String Mean;
	public static String Help;
	public static String Showviews;
	public static String Window;
	public static String CreatesANewImpactMethod;
	public static String NewImpactMethod;
	public static String Minimum;
	public static String Mode;
	public static String ModelGraph;
	public static String ModelingAndValidation;
	public static String ModelingConstants;
	public static String MonteCarloSimulation;
	public static String Monthly;
	public static String Move;
	public static String Name;
	public static String AddNewChildCategory;
	public static String DoYouReallyWantToDelete;
	public static String NewCategory;
	public static String PleaseEnterTheNameOfTheNewCategory;
	public static String No;
	public static String Remove;
	public static String PleaseEnterNewName;
	public static String Rename;
	public static String Yes;
	public static String Never;
	public static String NewDatabase;
	public static String NewDatabase_AlreadyExists;
	public static String CreateDatabase;
	public static String CreateANewDatabase;
	public static String NewDatabase_InvalidName;
	public static String DatabaseName;
	public static String NewDatabase_NameToShort;
	public static String DatabaseContent;
	public static String NoDistribution;
	public static String None;
	public static String NormalDistribution;
	public static String Normalization;
	public static String NormalizationFactor;
	public static String NormalizationWeighting;
	public static String NormalizationWeightingSet;
	public static String NormalizationWeightingSets;
	public static String Note;
	public static String NumberFormatPage_Description;
	public static String NumberFormatPage_Example;
	public static String NumberFormatPage_NumberOfPlaces;
	public static String NormalizationweightingSet;
	public static String OnlineHelp;
	public static String Open;
	public static String OpenEditorAction_Text;
	public static String OpenLCAUpdateCheckJobname;
	public static String Outputs;
	public static String OverwriteFileQuestion;
	public static String Parameter;
	public static String Parameters;
	public static String Paste;
	public static String PedigreeUncertainty;
	public static String Physical;
	public static String PleaseEnterName;
	public static String ProblemsPage_FoundProblems;
	public static String Process;
	public static String ProcessContributions;
	public static String Processes;
	public static String Processes_WizardMessage;
	public static String Processes_WizardTitle;
	public static String ProcessType;
	public static String ProducedBy;
	public static String Product;
	public static String ProductSystem;
	public static String ProductSystems;
	public static String Progress;
	public static String Project;
	public static String Projects;
	public static String ProjectInfoSectionLabel;
	public static String Projects_WizardMessage;
	public static String Projects_WizardTitle;
	public static String Properties;
	public static String Publication;
	public static String QuantitativeReference;
	public static String ReferenceFlowProperty;
	public static String ReferenceProcess;
	public static String ReferenceUnit;
	public static String Reload;
	public static String RemoveAction_Text;
	public static String Report;
	public static String ReportParameters;
	public static String Reserve;
	public static String Reset;
	public static String Rest;
	public static String ResultContributions;
	public static String ResultOf;
	public static String Results;
	public static String ResultsOf;
	public static String Reviewer;
	public static String Sampling;
	public static String Sankey_ActionText;
	public static String Sankey_Cutoff;
	public static String Sankey_DialogDescription;
	public static String Sankey_NoOptions;
	public static String Sankey_SavingAsImage;
	public static String Sankey_ScaleDescription;
	public static String Save;
	public static String SaveAs;
	public static String SaveAsImage;
	public static String SaveChanges;
	public static String SaveChangesQuestion;
	public static String SaveDefaults;
	public static String Search;
	public static String Searching;
	public static String SelectExportFile;
	public static String SelectObjectPage_Description;
	public static String SelectObjectPage_Title;
	public static String SelectParameter;
	public static String Settings;
	public static String ShowFormulas;
	public static String ShowValues;
	public static String Simulation_NumberOfSimulations;
	public static String SingleAmount;
	public static String Source;
	public static String Sources;
	public static String Sources_WizardMessage;
	public static String Sources_WizardTitle;
	public static String StandardDeviation;
	public static String Start;
	public static String StartDate;
	public static String SubCategory;
	public static String Synonyms;
	public static String SystemProcess;
	public static String Systems_AddSupplyChain;
	public static String Systems_AppActionBarContributorClass_LayoutActionText;
	public static String Systems_AvoidedProductFlow;
	public static String Systems_AvoidedWasteFlow;
	public static String Systems_BuildSupplyChainAction_Text;
	public static String Systems_CalculateButtonText;
	public static String Systems_CreatingProductSystem;
	public static String Systems_EmptyReferenceProcessError;
	public static String Systems_ExpandAllQuestion_Title;
	public static String Systems_ExpandAllQuestion_Text;
	public static String Systems_ExpandAllAction_Text;
	public static String Systems_ExpansionCommand_ExpandText;
	public static String Systems_ExpansionCommand_CollapseText;
	public static String Systems_CollapseAllAction_Text;
	public static String Systems_GetLinksAction_ProviderText;
	public static String Systems_GetLinksAction_RecipientText;
	public static String Systems_GraphLayoutType_MinimalTree;
	public static String Systems_GraphLayoutType_Tree;
	public static String Systems_HideShowAction_HideText;
	public static String Systems_HideShowAction_ShowText;
	public static String Systems_HideShowCommand_HideText;
	public static String Systems_HideShowCommand_ShowText;
	public static String Systems_LayoutAction_Text;
	public static String Systems_LayoutCommand_LayoutText;
	public static String Systems_MarkProcess;
	public static String Systems_MatrixExportAction_Text;
	public static String Systems_MaximizeAllProcessesAction_Text;
	public static String Systems_MaximizeCommand_Text;
	public static String Systems_MinimizeAllProcessesAction_Text;
	public static String Systems_MinimizeCommand_Text;
	public static String Systems_OpenMiniatureViewAction_Text;
	public static String Systems_Prefer;
	public static String Systems_ProcessCreateCommand_Text;
	public static String Systems_ProcessDeleteCommand_Text;
	public static String Systems_ProcessLinkCreateCommand_Text;
	public static String Systems_ProcessLinkDeleteCommand_Text;
	public static String Systems_ProcessLinkReconnectCommand_Text;
	public static String Systems_ProductSystemGraphEditor_FilterLabel;
	public static String Systems_ProductSystemInfoSectionLabel;
	public static String Systems_RemoveAllConnectionsAction_Text;
	public static String Systems_RemoveSupplyChainAction_Text;
	public static String Systems_Route;
	public static String Systems_SelectPossibleProcessesDialog_Connect;
	public static String Systems_SelectPossibleProcessesDialog_Create;
	public static String Systems_SelectPossibleProcessesDialog_Exists;
	public static String Systems_SelectPossibleProcessesDialog_IsConnected;
	public static String Systems_SelectPossibleProcessesDialog_SelectProviders;
	public static String Systems_SelectPossibleProcessesDialog_SelectRecipients;
	public static String Systems_ShowOutlineAction_Text;
	public static String Systems_UnmarkProcess;
	public static String Systems_UseSystemProcesses;
	public static String Systems_WizardMessage;
	public static String Systems_WizardTitle;
	public static String Systems_XYLayoutCommand_MoveText;
	public static String Systems_XYLayoutCommand_ResizeText;
	public static String TargetAmount;
	public static String TechnologyInfoSectionLabel;
	public static String Telefax;
	public static String Telephone;
	public static String TextDropComponent_RemoveButtonText;
	public static String TextDropComponent_ToolTipText;
	public static String TextReference;
	public static String TimeInfoSectionLabel;
	public static String TotalAmount;
	public static String TriangleDistribution;
	public static String UIFactory_CategoryLabel;
	public static String Uncertainty;
	public static String UncertaintyDistribution;
	public static String UniformDistribution;
	public static String Unit;
	public static String UnitExists;
	public static String UnitExistsError;
	public static String UnitGroup;
	public static String UnitGroupInfoSectionLabel;
	public static String UnitGroups;
	public static String UnitMappingPage_CheckingUnits;
	public static String UnitMappingPage_Description;
	public static String UnitMappingPage_Title;
	public static String UnitProcess;
	public static String Units_WizardMessage;
	public static String Units_WizardTitle;
	public static String UnitsAndFlowProps;
	public static String UpdatePreferences;
	public static String Usage;
	public static String UsageOf;
	public static String UsedInProcesses;
	public static String UserFriendlyName;
	public static String Value;
	public static String Version;
	public static String Warning;
	public static String WasteFlow;
	public static String WebSite;
	public static String Weekly;
	public static String Weighting;
	public static String WeightingFactor;
	public static String Year;
	public static String ZipCode;
	public static String Unknown;
	public static String NewLCIAMethod;

	public static String NewFlow;
	public static String NewFlowProperty;
	public static String NewProcess;
	public static String NewProductSystem;
	public static String NewProject;
	public static String NewSource;
	public static String NewUnitGroup;

	private static Map<String, String> map;

	static {
		NLS.initializeMessages("org.openlca.app.messages", Messages.class);
	}

	private Messages() {
	}

	public static Map<String, String> getMap() {
		if (map == null)
			map = new HashMap<>();
		try {
			for (Field field : Messages.class.getDeclaredFields()) {
				if (!Objects.equals(field.getType(), String.class))
					continue;
				if (!Modifier.isStatic(field.getModifiers()))
					continue;
				if (!Modifier.isPublic(field.getModifiers()))
					continue;
				String val = (String) field.get(null);
				map.put(field.getName(), val);
			}
		} catch (Exception e) {
			Logger log = LoggerFactory.getLogger(Messages.class);
			log.error("failed to get messages as map", e);
		}
		return map;
	}

	public static String asJson() {
		try {
			Gson gson = new Gson();
			return gson.toJson(getMap());
		} catch (Exception e) {
			Logger log = LoggerFactory.getLogger(Messages.class);
			log.error("failed to get messages as JSON string", e);
			return "{}";
		}
	}
}
