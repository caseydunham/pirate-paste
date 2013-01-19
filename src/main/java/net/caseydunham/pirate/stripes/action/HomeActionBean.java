package net.caseydunham.pirate.stripes.action;

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

	@DontValidate
	@DefaultHandler
	public Resolution view() {
		LOG.info("forwarding to " + HOME_PAGE);
		return new ForwardResolution(HOME_PAGE);
	}

	public void setContext(ActionBeanContext context) { this.context = context;	}
	public ActionBeanContext getContext() { return context; }

}
