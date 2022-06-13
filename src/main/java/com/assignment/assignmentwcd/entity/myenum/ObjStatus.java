package com.assignment.assignmentwcd.entity.myenum;

public enum ObjStatus {
    ACTIVE(1),DEACTIVE(0),DELETED(-1),UNDEFINED(-2);
    private final int value;
    ObjStatus(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
    public static ObjStatus getAccountStatus(int value){
        for(ObjStatus accountStatus : ObjStatus.values()){
            if(accountStatus.getValue() == value){
                return accountStatus;
            }
        }
        return UNDEFINED;
    }
}
