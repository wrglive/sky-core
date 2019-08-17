package com.marshall.sky.core.graphdb.dao;

import com.marshall.sky.core.graphdb.constant.SQLConstant;
import com.marshall.sky.core.graphdb.model.Relation;
import java.text.MessageFormat;

public class MySqlGraphDaoImpl implements MySqlGraphDao{

    String tableName;

    @Override
    public boolean insert(Relation relation) {
        String insertSQL = MessageFormat.format(SQLConstant.CREATE_AND_UPDATE, tableName);
        return false;
    }

    @Override
    public boolean remove(Relation relation) {
        return false;
    }

    @Override
    public boolean batchInsert(Relation[] relations) {
        return false;
    }

    @Override
    public boolean batchRemove(Relation[] relations) {
        return false;
    }
}
