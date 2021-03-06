package com.skalvasociety.skalva.service;

import java.io.Serializable;
import java.util.List;

import com.skalvasociety.skalva.bean.IFiltre;
import com.skalvasociety.skalva.daoTools.PageRequest;
import com.skalvasociety.skalva.enumeration.IOrderBy;
import com.skalvasociety.skalva.enumeration.SortDirection;

public interface IService<PK extends Serializable, T>  {
	public void save(T entite);
	public void delete(T entity);
	public T getByKey(PK key);
	public T getByKeyWithGraph(Serializable key);
	public T getByKeyWithGraph(Serializable key, List<String> entites);
	public List<T> getAll();
	public List<T> getAll(IOrderBy orderBy, SortDirection sort);
	public List<T> getByFiltre (IFiltre<T> filtre);
	public List<T> getAllByPage(PageRequest<T> pageRequest);
	public List<T> getAllByFiltrePage(PageRequest<T> pageRequest, IFiltre<T> filtre);
}
