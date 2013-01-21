package net.caseydunham.pirate.stripes.ext.guice.config;

import com.google.inject.AbstractModule;
import net.caseydunham.pirate.dao.PasteDao;
import net.caseydunham.pirate.dao.impl.HibernatePasteDao;
import net.caseydunham.pirate.services.PasteService;
import net.caseydunham.pirate.services.impl.PasteServiceImpl;

public class GuiceConfigModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(PasteService.class).to(PasteServiceImpl.class);
		bind(PasteDao.class).to(HibernatePasteDao.class);
	}

}
