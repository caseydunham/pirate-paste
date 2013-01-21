package net.caseydunham.pirate.stripes.action;

import com.google.inject.Inject;
import net.caseydunham.pirate.model.Paste;
import net.caseydunham.pirate.services.PasteService;
import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.controller.LifecycleStage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@UrlBinding(ViewPasteActionBean.VIEW_PASTE_ACTION + "/{id}")
public class ViewPasteActionBean implements ActionBean {

	private static final Logger LOG = LoggerFactory.getLogger(ViewPasteActionBean.class);

	public static final String PAGE_LOCATION = "/WEB-INF/jsps";

	public static final String VIEW_PASTE_ACTION = "/pastes";
	public static final String VIEW_PASTE_PAGE = PAGE_LOCATION + "/ViewPaste.jsp";

	private ActionBeanContext context;

	@Inject
	private PasteService pasteService;

	private Long id;
	private Paste paste;

	@After(stages = {LifecycleStage.BindingAndValidation})
	public void bind() {
		if (getId() != null) {
			setPaste(pasteService.getById(getId()));
		}
	}

	@DontValidate
	@DefaultHandler
	public Resolution view() {
		LOG.info("forwarding to " + VIEW_PASTE_PAGE);
		return new ForwardResolution(VIEW_PASTE_PAGE);
	}

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public Paste getPaste() { return paste; }
	public void setPaste(Paste paste) { this.paste = paste; }

	@Override
	public void setContext(ActionBeanContext context) { this.context = context; }
	@Override
	public ActionBeanContext getContext() { return context; }

}
