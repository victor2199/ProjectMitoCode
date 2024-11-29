package com.mitocode.servicesrest.services.impl;

import com.mitocode.servicesrest.exception.ModelNotFoundException;
import com.mitocode.servicesrest.repo.IGenericRepo;
import com.mitocode.servicesrest.services.ICrud;

import java.lang.reflect.Method;
import java.util.List;

public abstract class CrudImpl<T, ID> implements ICrud<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(ID id, T t) throws Exception {

        Class<?> clazz = t.getClass();
        String className = clazz.getSimpleName();

        String methodName = "setId" + className;
        Method setIdMethod = clazz.getMethod(methodName, id.getClass());
        setIdMethod.invoke(t, id);

        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NO ENCONTRADO: "+ id));
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) throws Exception {
        return getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NO ENCONTRADO: "+ id));
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NO ENCONTRADO: "+ id));
        getRepo().deleteById(id);
    }
}
