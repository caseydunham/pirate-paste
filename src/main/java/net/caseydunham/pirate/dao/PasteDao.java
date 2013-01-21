package net.caseydunham.pirate.dao;

import net.caseydunham.pirate.model.Paste;

import java.util.List;

public interface PasteDao extends IDao<Paste> {

	Paste getById(Long id);
	void saveOrUpdate(Paste paste);
	List<Paste> getRecentPastes();

}
