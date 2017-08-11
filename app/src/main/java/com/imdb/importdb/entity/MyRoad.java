package com.imdb.importdb.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2017/8/10.
 */

@Entity(nameInDb = "ROAD", createInDb = false)
public class MyRoad {
    @Property(nameInDb = "_id")
    @Id
    private Long id;
    @Property(nameInDb = "NAME")
    private String name;
    @Generated(hash = 1714365344)
    public MyRoad(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 724547472)
    public MyRoad() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
