package net.caseydunham.pirate.stripes.action;

import net.caseydunham.pirate.model.Paste;
import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.controller.LifecycleStage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@UrlBinding(BaseActionBean.HOME_ACTION)
public class HomeActionBean extends BaseActionBean {

	private static final Logger LOG = LoggerFactory.getLogger(HomeActionBean.class);

	private String title;
	private String username;
	private String content;

	private List<Paste> recentPastes;

	@After(stages = {LifecycleStage.BindingAndValidation})
	public void bind() {
		setRecentPastes(getPasteService().getRecentPastes());
	}

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

		getPasteService().create(p);
		return new RedirectResolution(HOME_ACTION);
	}

	public List<Paste> getRecentPastes() { return recentPastes; }
	public void setRecentPastes(List<Paste> recentPastes) { this.recentPastes = recentPastes; }

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }

	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; }

}
