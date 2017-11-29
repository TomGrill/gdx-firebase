package de.tomgrill.gdxfirebase.android.fcm;


import android.content.Intent;
import com.google.firebase.messaging.FirebaseMessagingService;
import de.tomgrill.gdxfirebase.core.fcm.RemoteMessage;

import java.util.Map;

public class GDXFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(com.google.firebase.messaging.RemoteMessage remoteMessage) {

        RemoteMessage message = new RemoteMessage();
        message.setFrom(remoteMessage.getFrom());
        message.setTo(remoteMessage.getTo());
        message.setMessageId(remoteMessage.getMessageId());
        message.setSentTime(remoteMessage.getSentTime());
        message.setCollapseKey(remoteMessage.getCollapseKey());
        message.setMessageType(remoteMessage.getMessageType());


        // notification
        if (remoteMessage.getNotification() != null) {
            RemoteMessage.Notification notification = new RemoteMessage.Notification();
            notification.setTitle(remoteMessage.getNotification().getTitle());
            notification.setBody(remoteMessage.getNotification().getBody());
            notification.setIcon(remoteMessage.getNotification().getIcon());
            notification.setColor(remoteMessage.getNotification().getColor());
            notification.setSound(remoteMessage.getNotification().getSound());
            notification.setTag(remoteMessage.getNotification().getTag());
            notification.setClickAction(remoteMessage.getNotification().getClickAction());

            message.setNotification(notification);

        }

        // data

        if (remoteMessage.getData() != null) {
            for (Map.Entry<String, String> entry : remoteMessage.getData().entrySet()) {
                message.getData().put(entry.getKey(), entry.getValue());
            }
        }

        Intent intent = new Intent(Action.MESSAGE_SERVICE);
        intent.putExtra("message", message);
        sendBroadcast(intent);

    }

    @Override
    public void onDeletedMessages() {
        throw new RuntimeException("MUST HANDLE DELETE MESSAGES ASAP");
    }
}
