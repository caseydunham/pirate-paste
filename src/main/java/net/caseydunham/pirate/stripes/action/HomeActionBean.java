package net.caseydunham.pirate.stripes.action;

import net.sourceforge.stripes.action.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@UrlBinding("/home")
public class HomeActionBean implements ActionBean {

	private static final Logger LOG = LoggerFactory.getLogger(HomeActionBean.class);

	private ActionBeanContext context;

	@DontValidate
	@DefaultHandler
	public Resolution view() {
		LOG.info("testing log setup");
		return new ForwardResolution("/WEB-INF/jsps/Home.jsp");
	}

	@Override
	public void setContext(ActionBeanContext context) { this.context = context;	}
	@Override
	public ActionBeanContext getContext() { return context; }

}
