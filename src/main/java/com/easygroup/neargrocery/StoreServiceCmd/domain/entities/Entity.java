package com.easygroup.neargrocery.StoreServiceCmd.domain.entities;

/**
 *
 * @author Vass Chile
 * @param <T>
 */
public abstract class Entity<T> {

    
    String name;

    
    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

}
