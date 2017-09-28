package de.tomgrill.gdxfirebase.android.admob;

import android.app.Activity;
import android.provider.Settings;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import de.tomgrill.gdxfirebase.core.FirebaseConfiguration;
import de.tomgrill.gdxfirebase.core.admob.Admob;
import de.tomgrill.gdxfirebase.core.admob.VideoRewardAd;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class AndroidAdmob implements Admob {

    private final FirebaseConfiguration firebaseConfiguration;
    private final Activity activity;
    private final AdRequest adRequest;

    public AndroidAdmob(Activity activity, FirebaseConfiguration firebaseConfiguration) {
        this.firebaseConfiguration = firebaseConfiguration;
        this.activity = activity;

        MobileAds.initialize(activity, firebaseConfiguration.admobAppId);

        if (firebaseConfiguration.admobUseTestDevice) {
            adRequest = new AdRequest.Builder().addTestDevice(getDeviceId()).build();
        } else {
            adRequest = new AdRequest.Builder().build();
        }
    }


    @Override
    public VideoRewardAd loadVideoRewardAd(String adUnit) {
        AndroidVideoRewardAd androidVideoRewardAd = new AndroidVideoRewardAd(activity, adRequest, adUnit);
        return androidVideoRewardAd;
    }

    @Override
    public boolean isTestDevice() {
        return adRequest.isTestDevice(activity);
    }

    private String getDeviceId() {
        String android_id = Settings.Secure.getString(activity.getContentResolver(), Settings.Secure.ANDROID_ID);
        return md5(android_id).toUpperCase(Locale.ENGLISH);
    }

    private String md5(final String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                String h = Integer.toHexString(0xFF & messageDigest[i]);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
