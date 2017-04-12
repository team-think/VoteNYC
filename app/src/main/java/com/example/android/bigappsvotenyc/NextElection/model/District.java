package com.example.android.bigappsvotenyc.NextElection.model;

/**
 * Created by catwong on 4/6/17.
 */

public class District {

    private String name;
    private String scope;
    private String id;
    private String kgForeignKey;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKgForeignKey() {
        return kgForeignKey;
    }

    public void setKgForeignKey(String kgForeignKey) {
        this.kgForeignKey = kgForeignKey;
    }
}
