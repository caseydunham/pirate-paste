package net.caseydunham.pirate.services;

import net.caseydunham.pirate.dao.PasteDao;
import net.caseydunham.pirate.model.Paste;

import java.util.List;

public interface PasteService {

	Paste getById(Long id);
	void create(Paste p);
	List<Paste> getRecentPastes();

	PasteDao getPasteDao();
	void setPasteDao(PasteDao pasteDao);

}
