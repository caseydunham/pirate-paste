package net.caseydunham.pirate.stripes.action;

import net.caseydunham.pirate.model.Paste;
import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.controller.LifecycleStage;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@UrlBinding(BaseActionBean.HOME_ACTION)
public class HomeActionBean extends BaseActionBean {

	private static final Logger LOG = LoggerFactory.getLogger(HomeActionBean.class);

	public static final String DEFAULT_TITLE = "Untitled";
	public static final String DEFAULT_USERNAME = "Unknown";

	private String title;
	private String username;
	private String content;

	private Paste paste;

	@DontValidate
	@DefaultHandler
	public Resolution view() {
		LOG.info("forwarding to " + HOME_PAGE);
		return new ForwardResolution(HOME_PAGE);
	}

	@After(stages = {LifecycleStage.BindingAndValidation})
	public void bind() {
		if (StringUtils.isEmpty(getTitle())) {
			setTitle(DEFAULT_TITLE);
		}
		if (StringUtils.isEmpty(getUsername())) {
			setUsername(DEFAULT_USERNAME);
		}
	}

	@HandlesEvent("submit")
	public Resolution submit() {
		Paste p = new Paste();
		p.setTitle(getTitle());
		p.setUsername(getUsername());
		p.setContent(getContent());

		getPasteService().create(p);
		setPaste(p);
		return new RedirectResolution(VIEW_PASTE_ACTION + "/" + p.getId());
	}

	public void setPaste(Paste paste) { this.paste = paste;  }
	public Paste getPaste() { return paste; }

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }

	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; }

}
