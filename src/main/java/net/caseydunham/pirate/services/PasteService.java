package net.caseydunham.pirate.services;

import net.caseydunham.pirate.model.Paste;

import java.util.List;

public interface PasteService {

	void create(Paste p);
	List<Paste> getRecentPastes();

}
