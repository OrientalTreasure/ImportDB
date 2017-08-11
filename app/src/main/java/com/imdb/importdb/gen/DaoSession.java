package com.imdb.importdb.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.imdb.importdb.entity.MyRoad;

import com.imdb.importdb.gen.MyRoadDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig myRoadDaoConfig;

    private final MyRoadDao myRoadDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        myRoadDaoConfig = daoConfigMap.get(MyRoadDao.class).clone();
        myRoadDaoConfig.initIdentityScope(type);

        myRoadDao = new MyRoadDao(myRoadDaoConfig, this);

        registerDao(MyRoad.class, myRoadDao);
    }
    
    public void clear() {
        myRoadDaoConfig.clearIdentityScope();
    }

    public MyRoadDao getMyRoadDao() {
        return myRoadDao;
    }

}