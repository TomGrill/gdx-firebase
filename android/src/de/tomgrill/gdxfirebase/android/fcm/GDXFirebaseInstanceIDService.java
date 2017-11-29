package de.tomgrill.gdxfirebase.android.fcm;


import android.content.Intent;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class GDXFirebaseInstanceIDService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        Intent intent = new Intent(Action.TOKEN_REFRESH);
        if (refreshedToken != null) {
            intent.putExtra("token", refreshedToken);
        }
        sendBroadcast(intent);

    }
}
