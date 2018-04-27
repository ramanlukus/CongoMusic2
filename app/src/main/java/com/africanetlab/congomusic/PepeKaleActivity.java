package com.africanetlab.congomusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class PepeKaleActivity extends AppCompatActivity {

    private android.webkit.WebView WebView;
    private Button mRetour, mSuivent;

    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pepe_kale);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        WebView = (android.webkit.WebView) findViewById( R.id.webview);
        WebView.setWebViewClient(new WebViewClient());
        WebView.loadUrl("https://www.nexell.co.za/music/pepe-kale/");

        android.webkit.WebView myWebView = (android.webkit.WebView) findViewById(R.id.webview);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        AdRequest adRequest = new AdRequest.Builder().build();

        // Prepare the Interstitial Ad
        interstitial = new InterstitialAd(PepeKaleActivity.this);
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

        mRetour = (Button) findViewById(R.id.retour);
        mSuivent = (Button) findViewById(R.id.suivent);

        mRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PepeKaleActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                return;


            }
        });

        mSuivent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PepeKaleActivity.this, SelectionMusiqueCongolaiseActivity.class);
                startActivity(intent);
                finish();
                return;


            }
        });



    }



    public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (WebView.canGoBack()) {
                        WebView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }

}
