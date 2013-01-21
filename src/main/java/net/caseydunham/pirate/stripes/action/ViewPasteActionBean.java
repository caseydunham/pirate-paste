package net.caseydunham.pirate.stripes.action;

import net.caseydunham.pirate.model.Paste;
import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.controller.LifecycleStage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@UrlBinding(BaseActionBean.VIEW_PASTE_ACTION + "/{id}")
public class ViewPasteActionBean extends BaseActionBean {

	private static final Logger LOG = LoggerFactory.getLogger(ViewPasteActionBean.class);

	private Long id;
	private Paste paste;

	@After(stages = {LifecycleStage.BindingAndValidation})
	public void bind() {
		if (getId() != null) {
			Paste p = getPasteService().getById(getId());
			setPaste(p);
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

}
