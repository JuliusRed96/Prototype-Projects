package it.gianluca.MySpring;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface GenericDao<T> {

	public abstract List<T> findAll();

	public abstract int save(T t);

	public abstract T update(int id, T t);

	public abstract int delete(int id);

	public abstract T findById(int id);
}
