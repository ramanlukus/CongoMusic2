package com.africanetlab.congomusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MainActivity extends AppCompatActivity {

    private Button mChansonsPatrioques, mKoffiOlomide, mPapaWemba, mFallyIpupa, mJbMpiana, mFrancoLuambo, mPepeKale, mSelectionMusiqueCongolaise;

    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChansonsPatrioques = (Button) findViewById(R.id.chansons_patriotiques);
        mKoffiOlomide = (Button) findViewById(R.id.koffi_olomide);
        mPapaWemba = (Button) findViewById(R.id.papa_wemba);
        mFallyIpupa = (Button) findViewById(R.id.fally_ipupa);
        mJbMpiana = (Button) findViewById(R.id.jb_mpiana);
        mFrancoLuambo = (Button)findViewById(R.id.franco_luambo);
        mPepeKale = (Button) findViewById(R.id.pepe_kale);
        mSelectionMusiqueCongolaise= (Button) findViewById(R.id.selection_musique_congolaise);


        mChansonsPatrioques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChansonsPatriotiquesActivity.class);
                startActivity(intent);
                finish();
                return;


            }
        });

        mKoffiOlomide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KoffiOlomideActivity.class);
                startActivity(intent);
                finish();
                return;


            }
        });

        mPapaWemba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PapaWembaActivity.class);
                startActivity(intent);
                finish();
                return;


            }
        });

        mFallyIpupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FallyIpupaActivity.class);
                startActivity(intent);
                finish();
                return;


            }
        });

        mJbMpiana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, JbMpianaActivity.class);
                startActivity(intent);
                finish();
                return;


            }
        });

        mFrancoLuambo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FrancoLuamboActivity.class);
                startActivity(intent);
                finish();
                return;


            }
        });

        mPepeKale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PepeKaleActivity.class);
                startActivity(intent);
                finish();
                return;


            }
        });

        mSelectionMusiqueCongolaise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectionMusiqueCongolaiseActivity.class);
                startActivity(intent);
                finish();
                return;


            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();

        // Prepare the Interstitial Ad
        interstitial = new InterstitialAd(MainActivity.this);
// Insert the Ad Unit ID
        interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));

        interstitial.loadAd(adRequest);
// Prepare an Interstitial Ad Listener
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
// Call displayInterstitial() function
                displayInterstitial();
            }
        });

        AdView mAdView = (AdView) findViewById(R.id.adview);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



    }



    public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }



    public class MyFirebaseMessagingService extends FirebaseMessagingService {
        private static final String TAG = "FCM Service";
        @Override
        public void onMessageReceived(RemoteMessage remoteMessage) {
            // TODO: Handle FCM messages here.
            // If the application is in the foreground handle both data and notification messages here.
            // Also if you intend on generating your own notifications as a result of a received FCM
            // message, here is where that should be initiated.
            Log.d(TAG, "From: " + remoteMessage.getFrom());
            Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());
        }
    }
    public class FirebaseIDService extends FirebaseInstanceIdService {
        private static final String TAG = "FirebaseIDService";

        @Override
        public void onTokenRefresh() {
            // Get updated InstanceID token.
            String refreshedToken = FirebaseInstanceId.getInstance().getToken();
            Log.d(TAG, "Refreshed token: " + refreshedToken);

            // TODO: Implement this method to send any registration to your app's servers.
            sendRegistrationToServer(refreshedToken);
        }

        /**
         * Persist token to third-party servers.
         *
         * Modify this method to associate the user's FCM InstanceID token with any server-side account
         * maintained by your application.
         *
         * @param token The new token.
         **/
        private void sendRegistrationToServer(String token) {
            // Add custom implementation, as needed.
        }
    }
}
