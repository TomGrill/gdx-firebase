package de.tomgrill.gdxfirebase.core.fcm;


import com.badlogic.gdx.utils.ObjectMap;

import java.io.Serializable;
import java.util.HashMap;

public class RemoteMessage implements Serializable{
    private String from;
    private Notification notification;
    private String messageId;
    private String to;
    private long sentTime;
    private String collapseKey;
    private int ttl;
    private String messageType;
    private HashMap<String, Object> data = new HashMap<>();

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setSentTime(long sentTime) {
        this.sentTime = sentTime;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public void setCollapseKey(String collapseKey) {
        this.collapseKey = collapseKey;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }

    public String getMessageType() {
        return messageType;
    }

    public int getTtl() {
        return ttl;
    }

    public String getCollapseKey() {
        return collapseKey;
    }

    public long getSentTime() {
        return sentTime;
    }

    public String getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "{\n" +
                "from: " + from + "\n" +
                "to: " + to + "\n" +
                "messageId: " + messageId + "\n" +
                "sentTime: " + sentTime + "\n" +
                "ttl: " + ttl + "\n" +
                "collapseKey: " + collapseKey + "\n" +
                "messageType: " + messageType + "\n" +
                "notification: " + notification + "\n" +
                "data: " + data + "\n" +
                "}";
    }

    public static class Notification implements Serializable{

        private String title;
        private String body;
        private String icon;
        private String sound;
        private String tag;
        private String color;
        private String clickAction;

        @Override
        public String toString() {
            return "{\n" +
                    "title: " + title + "\n" +
                    "body: " + body + "\n" +
                    "icon: " + icon + "\n" +
                    "sound: " + sound + "\n" +
                    "tag: " + tag + "\n" +
                    "color: " + color + "\n" +
                    "clickAction: " + clickAction + "\n" +
                    "}";
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getSound() {
            return sound;
        }

        public void setSound(String sound) {
            this.sound = sound;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getClickAction() {
            return clickAction;
        }

        public void setClickAction(String clickAction) {
            this.clickAction = clickAction;
        }

//        public Uri getLink() {
//            return this.zznwp;
//        }
    }
}
