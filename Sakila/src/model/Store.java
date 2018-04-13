package model;

import java.sql.Timestamp;

public class Store {
    private int store_id;
    private int managerstaff_id;
    private Address address;
    private Timestamp last_update;

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getManagerstaff_id() {
        return managerstaff_id;
    }

    public void setManagerstaff_id(int managerstaff_id) {
        this.managerstaff_id = managerstaff_id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Timestamp getLast_update() {
        return last_update;
    }

    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }
}
