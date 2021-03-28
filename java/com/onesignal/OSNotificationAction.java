package com.onesignal;

public class OSNotificationAction {
    public String actionID;
    public ActionType type;

    public enum ActionType {
        Opened,
        ActionTaken
    }
}
