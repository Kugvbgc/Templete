package com.khair.templete;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeAdView;

public class MainActivity extends AppCompatActivity {
    private NativeAd nativeAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onAdloded();

    }

    ///=============================================
    public void onAdloded(){

        nativeAd = new NativeAd(this, "YOUR_PLACEMENT_ID");
        NativeAdListener nativeAdListener = new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {

            }

            @Override
            public void onError(Ad ad, AdError adError) {

            }

            @Override
            public void onAdLoaded(Ad ad) {

                View adView = NativeAdView.render(MainActivity.this, nativeAd);
                LinearLayout nativeAdContainer = (LinearLayout) findViewById(R.id.native_ad_container);
                // Add the Native Ad View to your ad container.
                // The recommended dimensions for the ad container are:
                // Width: 280dp - 500dp
                // Height: 250dp - 500dp
                // The template, however, will adapt to the supplied dimensions.
                nativeAdContainer.addView(adView, new LinearLayout.LayoutParams(MATCH_PARENT, 800));

            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        };


        // Initiate a request to load an ad.
        nativeAd.loadAd(
                nativeAd.buildLoadAdConfig()
                        .withAdListener(nativeAdListener)
                        .withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL)
                        .build());

    }

    ///////////=======================================
}