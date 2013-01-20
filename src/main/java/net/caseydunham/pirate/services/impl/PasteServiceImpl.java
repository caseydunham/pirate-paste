package net.caseydunham.pirate.services.impl;

import net.caseydunham.pirate.model.Paste;
import net.caseydunham.pirate.services.PasteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class PasteServiceImpl implements PasteService {

	private static final Logger LOG = LoggerFactory.getLogger(PasteServiceImpl.class);

	private static List<Paste> pastes = new ArrayList<Paste>();

	@Override
	public void create(Paste p) {
		LOG.info("Creating new Paste " + p);
		pastes.add(p);
	}

	@Override
	public List<Paste> getRecentPastes() {
		return pastes;
	}

}
