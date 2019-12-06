package com.process.boot.config.mybatis;

import java.util.Collection;

/**
 * @author xukaixuan
 */
public class Page extends com.github.pagehelper.Page {
    private Collection entities;

    public Collection getEntities() {
        return entities;
    }

    public void setEntities(Collection entities) {
        this.entities = entities;
    }
}
