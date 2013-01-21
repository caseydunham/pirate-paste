package net.caseydunham.pirate.services.impl;

import com.google.inject.Inject;
import net.caseydunham.pirate.dao.PasteDao;
import net.caseydunham.pirate.model.Paste;
import net.caseydunham.pirate.services.PasteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PasteServiceImpl implements PasteService {

	private static final Logger LOG = LoggerFactory.getLogger(PasteServiceImpl.class);

	@Inject
	private PasteDao pasteDao;

	public PasteDao getPasteDao() { return pasteDao; }
	public void setPasteDao(PasteDao pasteDao) { this.pasteDao = pasteDao; }

	@Override
	public Paste getById(Long id) {
		return getPasteDao().getById(id);
	}

	@Override
	public void create(Paste p) {
		LOG.info("Creating new Paste " + p);
		getPasteDao().saveOrUpdate(p);
	}

	@Override
	public List<Paste> getRecentPastes() {
		return getPasteDao().getRecentPastes();
	}

}
