package net.caseydunham.pirate.dao.impl;

import net.caseydunham.pirate.dao.HibernateBaseDao;
import net.caseydunham.pirate.dao.PasteDao;
import net.caseydunham.pirate.model.Paste;

import java.util.List;

public class HibernatePasteDao extends HibernateBaseDao<Paste> implements PasteDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<Paste> getRecentPastes() {
		return (List<Paste>) getSession().createQuery("select p from Paste p order by p.created desc").list();
	}

}
