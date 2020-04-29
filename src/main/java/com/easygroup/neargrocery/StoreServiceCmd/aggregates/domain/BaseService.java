package com.easygroup.neargrocery.StoreServiceCmd.aggregates.domain;


import java.util.Collection;

import com.easygroup.neargrocery.StoreServiceCmd.domain.repository.Repository;





/**
 *
 * @author Vass Chile
 * @param <TE>
 * @param <T>
 */
public abstract class BaseService<TE, T> extends ReadOnlyBaseService<TE, T> {

    private Repository<TE, T> _repository;

    public BaseService(Repository<TE, T> repository) {
        super(repository);
        _repository = repository;
    }

    /**
     *
     * @param entity
     * @throws Exception
     */
    public boolean add(TE entity) throws Exception {
        return _repository.add(entity);
    }

    /**
     *
     * @return
     */
    public Collection<TE> getAll(T t) throws Exception {
        return _repository.getAll(t);
    }
    /**
    *
    * @param entity
    * @throws Exception
    */
   public void update(TE entity) throws Exception {
       _repository.update(entity);
   }

}
