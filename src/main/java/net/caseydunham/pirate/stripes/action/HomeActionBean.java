package net.caseydunham.pirate.stripes.action;

import net.sourceforge.stripes.action.*;

@UrlBinding("/home")
public class HomeActionBean implements ActionBean {

	private ActionBeanContext context;

	@DontValidate
	@DefaultHandler
	public Resolution view() {
		return new ForwardResolution("/WEB-INF/jsps/Home.jsp");
	}

	@Override
	public void setContext(ActionBeanContext context) { this.context = context;	}
	@Override
	public ActionBeanContext getContext() { return context; }

}
