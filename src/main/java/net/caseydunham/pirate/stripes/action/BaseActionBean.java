package net.caseydunham.pirate.stripes.action;

import com.google.inject.Inject;
import net.caseydunham.pirate.services.PasteService;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;

public class BaseActionBean implements ActionBean {

	public static final String PAGE_LOCATION = "/WEB-INF/jsps";

	public static final String HOME_ACTION = "/home";
	public static final String HOME_PAGE = PAGE_LOCATION + "/Home.jsp";

	public static final String VIEW_PASTE_ACTION = "/pastes";
	public static final String VIEW_PASTE_PAGE = PAGE_LOCATION + "/ViewPaste.jsp";

	@Inject
	private PasteService pasteService;
	private ActionBeanContext context;

	public PasteService getPasteService() { return pasteService; }
	public void setPasteService(PasteService pasteService) { this.pasteService = pasteService; }

	public void setContext(ActionBeanContext context) { this.context = context;	}
	public ActionBeanContext getContext() { return context; }

}
