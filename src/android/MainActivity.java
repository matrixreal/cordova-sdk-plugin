package com.sampleapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.io.InputStream;
import rm.com.android.sdk.Rm;
import rm.com.android.sdk.RmListener;
import rm.com.android.sdk.ads.banner.RMBannerView;
import rm.com.android.sdk.ads.nativeAd.RMNativeAdObject;
import rm.com.android.sdk.ads.nativeAd.RMNativeViewStandard;

public class MainActivity extends Activity {

    Context context;
    final String REVMOB_APP_ID = "593872a453357e13083fea52";
    final String REVMOB_PLACEMENT_ID  = "58813039204a109282723488";
    final String REVMOB_NATIVE_ID     = "585af145129d5fb00e38cfdc";
    RMBannerView banner;
    RMNativeAdObject nativeObject;
    RMNativeViewStandard rmNativeViewHtml;
    LinearLayout nativeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
    }

    public void revmobInit(View v) {
        Rm.init(context, REVMOB_APP_ID);
        toastOnUiThread("Init complete");
    }

    public void cacheRewardedVideo(final View v) {

        Rm.cacheRewardedVideo(REVMOB_PLACEMENT_ID, new RmListener.Cache() {

            @Override
            public void onRmAdReceived() {
                toastOnUiThread("onRevmob AdReceived");
            }

            @Override
            public void onRmAdNotReceived(String message) {
                toastOnUiThread("onRevmobAd NotReceived with error: " + message);
            }
        });
    }

    public void showRewardedVideo(View v) {

        if (Rm.isRewardedVideoLoaded(REVMOB_PLACEMENT_ID)) {
            Rm.showRewardedVideo(this, REVMOB_PLACEMENT_ID, new RmListener.ShowRewardedVideo() {

                @Override
                public void onRmRewardedVideoCompleted() {
                    toastOnUiThread("onRevmobRewardedVideoCompleted");
                }

                @Override
                public void onRmAdDisplayed() {
                    toastOnUiThread("onRevmobAd Displayed");
                }

                @Override
                public void onRmAdFailed(String message) {
                    toastOnUiThread("onRevmobAd Failed with error: " + message);
                }

                @Override
                public void onRmAdDismissed() {
                    toastOnUiThread("onRevmobAd Dismissed");
                }

                @Override
                public void onRmAdClicked() {
                    toastOnUiThread("onRevmobAd Clicked");
                }
            });

        } else {
            toastOnUiThread("Revmob Fullscreen not cached yet");
        }
    }

    public void cacheInterstitial(final View v) {


        Rm.cacheInterstitial(REVMOB_PLACEMENT_ID, new RmListener.Cache() {

            @Override
            public void onRmAdReceived() {
                toastOnUiThread("onRevmob AdReceived");
            }

            @Override
            public void onRmAdNotReceived(String message) {
                toastOnUiThread("onRevmobAd NotReceived with error: " + message);
            }
        });
    }

    public void showInterstitial(View v) {

        if (Rm.isInterstitialLoaded(REVMOB_PLACEMENT_ID)) {
            Rm.showInterstitial(this, REVMOB_PLACEMENT_ID, new RmListener.Show() {

                @Override
                public void onRmAdDisplayed() {
                    toastOnUiThread("onRevmobAd Displayed");
                }

                @Override
                public void onRmAdFailed(String message) {
                    toastOnUiThread("onRevmobAd Failed with error: " + message);
                }

                @Override
                public void onRmAdDismissed() {
                    toastOnUiThread("onRevmobAd Dismissed");
                }

                @Override
                public void onRmAdClicked() {
                    toastOnUiThread("onRevmobAd Clicked");
                }
            });

        } else {
            toastOnUiThread("Revmob Fullscreen not cached yet");
        }
    }

    public void cacheBanner(final View v) {
        /** Cache Banner **/
        Rm.cacheBanner(REVMOB_PLACEMENT_ID, new RmListener.Cache() {

            @Override
            public void onRmAdReceived() {
                toastOnUiThread("onRevmob AdReceived");
            }

            @Override
            public void onRmAdNotReceived(String message) {
                toastOnUiThread("onRevmobAd NotReceived with error: " + message);
            }
        });
    }

    public void showBanner(View v) {

        if (Rm.isBannerLoaded(REVMOB_PLACEMENT_ID)) {
            banner = Rm.getBanner(this, REVMOB_PLACEMENT_ID, new RmListener.Get() {

                @Override
                public void onRmAdDisplayed() {
                    toastOnUiThread("onRevmobAd Displayed");
                }

                @Override
                public void onRmAdFailed(String message) {
                    toastOnUiThread("onRevmobAd Failed with error: " + message);
                }

                @Override
                public void onRmAdDismissed() {
                    toastOnUiThread("onRevmobAd Dismissed");
                }

                @Override
                public void onRmAdClicked() {
                    toastOnUiThread("onRevmobAd Clicked");
                }
            });


            ViewGroup view = (ViewGroup) findViewById (R.id.banner);
            view.removeAllViews();
            view.addView(banner);

        } else {
            toastOnUiThread("Revmob Banner not cached yet");
        }
    }

    public void showBannerWithoutReload(View v) {

        if (Rm.isBannerLoaded(REVMOB_PLACEMENT_ID)) {
            banner = Rm.getBannerNoRefresh(this, REVMOB_PLACEMENT_ID, new RmListener.Get() {

                @Override
                public void onRmAdDisplayed() {
                    toastOnUiThread("onRevmobAd Displayed");
                }

                @Override
                public void onRmAdFailed(String message) {
                    toastOnUiThread("onRevmobAd Failed with error: " + message);
                }

                @Override
                public void onRmAdDismissed() {
                    toastOnUiThread("onRevmobAd Dismissed");
                }

                @Override
                public void onRmAdClicked() {
                    toastOnUiThread("onRevmobAd Clicked");
                }
            });


            ViewGroup view = (ViewGroup) findViewById (R.id.banner);
            view.removeAllViews();
            view.addView(banner);

        } else {
            toastOnUiThread("Revmob Banner not cached yet");
        }
    }

    public void hideBanner(View v) {
        if(banner != null) banner.hide();
    }

    public void releaseBanner(View v) {
        if(banner != null) banner.release();
    }

    public void reshowBanner(View v) {
        if(banner != null) banner.show();
        else toastOnUiThread("There's no banner to show. Please cache again.");
    }

    public void cacheNativeHtml(View v) {
        Rm.cacheNativeStandard(REVMOB_NATIVE_ID, 370, 250,  new RmListener.Cache() {
            @Override
            public void onRmAdReceived() {
                toastOnUiThread("onRevmob AdReceived");
            }

            @Override
            public void onRmAdNotReceived(String message) {
                toastOnUiThread("onRevmobAd NotReceived with error: " + message);
            }
        });
    }

    public void showNativeHtml(View v) {

        if (Rm.isNativeStandardLoaded(REVMOB_NATIVE_ID)) {
            rmNativeViewHtml = Rm.getNativeStandard(this, REVMOB_NATIVE_ID, new RmListener.Get() {

                @Override
                public void onRmAdDisplayed() {
                    toastOnUiThread("onRevmobAd Displayed");
                }

                @Override
                public void onRmAdFailed(String message) {
                    toastOnUiThread("onRevmobAd Failed with error: " + message);
                }

                @Override
                public void onRmAdDismissed() {
                    toastOnUiThread("onRevmobAd Dismissed");
                }

                @Override
                public void onRmAdClicked() {
                    toastOnUiThread("onRevmobAd Clicked");
                }
            });

            ViewGroup view = (ViewGroup) findViewById (R.id.nativeHtml);
            view.removeAllViews ();
            view.addView (rmNativeViewHtml);

        } else {
            toastOnUiThread("Revmob Native not cached yet");
        }
    }

    public void cacheNative(View v) {

        Rm.cacheNativeCustom(REVMOB_NATIVE_ID, new RmListener.Cache() {

            @Override
            public void onRmAdReceived() {
                toastOnUiThread("onRevmob AdReceived");
            }

            @Override
            public void onRmAdNotReceived(String message) {
                toastOnUiThread("onRevmobAd NotReceived with error: " + message);
            }
        });
    }

    public void showNative(final View v) {

        if (Rm.isNativeCustomLoaded(REVMOB_NATIVE_ID)) {
            nativeObject = Rm.getNativeCustom(this, REVMOB_NATIVE_ID, new RmListener.Get() {

                @Override
                public void onRmAdDisplayed() {
                    toastOnUiThread("onRevmobAd Displayed");
                }

                @Override
                public void onRmAdFailed(String message) {
                    toastOnUiThread("onRevmobAd Failed with error: " + message);
                }

                @Override
                public void onRmAdDismissed() {
                    toastOnUiThread("onRevmobAd Dismissed");
                }

                @Override
                public void onRmAdClicked() {
                    toastOnUiThread("onRevmobAd Clicked");
                }
            });

            nativeContainer = (LinearLayout) findViewById(R.id.native_ad_container);
            nativeContainer.setVisibility(View.VISIBLE);
            nativeContainer.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick (View view) {
                    reportClick();
                    Rm.cacheNativeCustom(REVMOB_NATIVE_ID, new RmListener.Cache() {

                        @Override
                        public void onRmAdReceived() {
                            toastOnUiThread("onRevmob AdReceived");
                            showNative(v);
                        }

                        @Override
                        public void onRmAdNotReceived(String message) {
                            toastOnUiThread("onRevmobAd NotReceived with error: " + message);
                        }
                    });
                }
            });

            TextView textView = (TextView) findViewById(R.id.native_ad_title);
            TextView textBody = (TextView) findViewById(R.id.native_ad_body);
            ImageView imageView = (ImageView) findViewById(R.id.native_ad_icon);
            textView.setText(nativeObject.getTitle());
            textBody.setText(nativeObject.getDescription());

            new DownloadImageTask(imageView).execute(nativeObject.getIconImageUrl());

            reportImpression();
        } else {
            toastOnUiThread("Revmob Native not cached yet");
        }
    }

    public void reportImpression() {
        if (nativeObject != null) {
            nativeObject.reportImpression(this);
        }
    }

    public void reportClick() {
        if (nativeObject != null) {
            nativeObject.reportClick(this);
        }
    }

    public void releaseNative(View v) {
        if(rmNativeViewHtml != null) rmNativeViewHtml.release();
    }

    public void cacheLink(View v){
        Rm.cacheLink(REVMOB_PLACEMENT_ID, new RmListener.Cache() {

            @Override
            public void onRmAdReceived() {
                toastOnUiThread("onRevmob AdReceived");
            }

            @Override
            public void onRmAdNotReceived(String message) {
                toastOnUiThread("onRevmobAd NotReceived with error: " + message);
            }
        });
    }

    public void openLink(View v) {
        if (Rm.isLinkLoaded(REVMOB_PLACEMENT_ID)) {
            Rm.openLink(this, REVMOB_PLACEMENT_ID, new RmListener.Open() {

                @Override
                public void onRmAdFailed(String message) {
                    toastOnUiThread("onRevmobAd Failed with error: " + message);
                }

                @Override
                public void onRmAdClicked() {
                    toastOnUiThread("onRevmobAd Clicked");
                }
            });
        } else {
            toastOnUiThread("onRevmobAd NotReceived with error: ");
        }
    }


    void toastOnUiThread(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        public DownloadImageTask(ImageView imageView) {
            this.imageView = imageView;
        }

        protected Bitmap doInBackground(String... urls) {
            String url = urls[0];
            Bitmap bitmap = null;
            try {
                InputStream in = new java.net.URL(url).openStream();
                bitmap = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        protected void onPostExecute(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
