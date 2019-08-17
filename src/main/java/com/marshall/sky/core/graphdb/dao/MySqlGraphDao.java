package com.marshall.sky.core.graphdb.dao;

import com.marshall.sky.core.graphdb.model.Relation;

public interface MySqlGraphDao {
    boolean insert(Relation relation);

    boolean remove(Relation relation);

    boolean batchInsert(Relation[] relations);

    boolean batchRemove(Relation[] relations);

}
