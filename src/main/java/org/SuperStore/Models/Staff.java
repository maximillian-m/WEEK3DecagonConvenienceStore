package org.SuperStore.Models;

public abstract class Staff extends Person{
    protected  String staffId;
    public Staff (String name){
        super(name);
        staffId = setId();
        System.out.println(name + " has a staff Identity of " + staffId);
    }
    private String setId(){
        int random = (int) (Math.random() * 1000000) + 122556;
        return "" + random;
    }
    abstract String getStaffId();


}
