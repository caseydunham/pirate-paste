package net.caseydunham.pirate.dao;

import net.caseydunham.pirate.model.IValueObject;

public interface IDao<T extends IValueObject> {

	T getById(Long id);
	void saveOrUpdate(T valueObject);

}
