package net.caseydunham.pirate.stripes.action;

import net.caseydunham.pirate.model.Paste;
import net.caseydunham.pirate.services.PasteService;
import net.caseydunham.pirate.services.impl.PasteServiceImpl;
import net.sourceforge.stripes.action.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@UrlBinding(HomeActionBean.HOME_ACTION)
public class HomeActionBean implements ActionBean {

	private static final Logger LOG = LoggerFactory.getLogger(HomeActionBean.class);

	public static final String PAGE_LOCATION = "/WEB-INF/jsps";

	public static final String HOME_ACTION = "/home";
	public static final String HOME_PAGE = PAGE_LOCATION + "/Home.jsp";

	private ActionBeanContext context;

	private String title;
	private String username;
	private String content;

	@DontValidate
	@DefaultHandler
	public Resolution view() {
		LOG.info("forwarding to " + HOME_PAGE);
		return new ForwardResolution(HOME_PAGE);
	}

	@HandlesEvent("submit")
	public Resolution submit() {
		Paste p = new Paste();
		p.setTitle(getTitle());
		p.setUsername(getUsername());
		p.setContent(getContent());

		PasteService pasteService = new PasteServiceImpl();
		pasteService.create(p);
		return new RedirectResolution(HOME_ACTION);
	}

	public void setContext(ActionBeanContext context) { this.context = context;	}
	public ActionBeanContext getContext() { return context; }

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }

	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; }

}
