package com.ycy.contentjavaapp.event;

/**
 * Created by wanghao2 on 2017/5/17.
 */

public class CloseActivityEvent {
    private String activityName;
    private Object object;

    public CloseActivityEvent(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityName() {
        return activityName;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
