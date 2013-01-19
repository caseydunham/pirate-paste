package net.caseydunham.pirate.services.impl;

import net.caseydunham.pirate.model.Paste;
import net.caseydunham.pirate.services.PasteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PasteServiceImpl implements PasteService {

	private static final Logger LOG = LoggerFactory.getLogger(PasteServiceImpl.class);

	@Override
	public void create(Paste p) {
		LOG.info("Creating new Paste " + p);
	}

}
