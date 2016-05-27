/**
 *   To implement, test and deploy a HSV color picker Android app
 *   @author Paul Harvey (harv0116@algonquinlive.com)
 *
 */

package com.algonquincollege.harv0116.hsvcolorpicker;

import android.app.DialogFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mColorSwatch;
    private SeekBar mHueSB;
    private SeekBar mSaturationSB;
    private SeekBar mValueSB;
    private Button mBlackButton;
    private Button mRedButton;
    private Button mLimeButton;
    private Button mBlueButton;
    private Button mYellowButton;
    private Button mCyanButton;
    private Button mMagentaButton;
    private Button mSilverButton;
    private Button mGrayButton;
    private Button mMaroonButton;
    private Button mOliveButton;
    private Button mGreenButton;
    private Button mPurpleButton;
    private Button mTealButton;
    private Button mNavyButton;
    private static final String ABOUT_DIALOG_TAG;

    static {
        ABOUT_DIALOG_TAG = "About Dialog";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mColorSwatch = (TextView) findViewById(R.id.colorSwatch);

        mHueSB = (SeekBar) findViewById(R.id.hueSB);
        mHueSB.setMax(359);

        mSaturationSB = (SeekBar) findViewById(R.id.saturationSB);
        mSaturationSB.setMax(100);

        mValueSB = (SeekBar) findViewById(R.id.valueSB);
        mValueSB.setMax(100);

        mBlackButton = (Button) findViewById(R.id.blackButton);
        mRedButton = (Button) findViewById(R.id.redButton);
        mLimeButton = (Button) findViewById(R.id.limeButton);
        mBlueButton = (Button) findViewById(R.id.blueButton);
        mYellowButton = (Button) findViewById(R.id.yellowButton);
        mCyanButton = (Button) findViewById(R.id.cyanButton);
        mMagentaButton = (Button) findViewById(R.id.magentaButton);
        mSilverButton = (Button) findViewById(R.id.silverButton);
        mGrayButton = (Button) findViewById(R.id.grayButton);
        mMaroonButton = (Button) findViewById(R.id.maroonButton);
        mOliveButton = (Button) findViewById(R.id.oliveButton);
        mGreenButton = (Button) findViewById(R.id.greenButton);
        mPurpleButton = (Button) findViewById(R.id.purpleButton);
        mTealButton = (Button) findViewById(R.id.tealButton);
        mNavyButton = (Button) findViewById(R.id.navyButton);

        // Activity on the Main Color Swatch - Long Click
        mColorSwatch.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "H: " + mHueSB.getProgress() + "\u00B0 S: " + mSaturationSB.getProgress() + "% V: " + +mValueSB.getProgress() + "%.", Toast.LENGTH_LONG).show();
                return true;
            }
        });

        // Activity on the Hue Seek Bar - Change
        mHueSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser == true) {
                    TextView hueText = (TextView) findViewById(R.id.hue);
                    String displayHueText = "HUE " + mHueSB.getProgress() + "\u00B0";
                    hueText.setText(displayHueText);
                }

                float hueValue = (float) mHueSB.getProgress();
                float satValue = (float) mSaturationSB.getProgress() / 100;
                float valValue = (float) mValueSB.getProgress() /100;

                int outputColor = Color.HSVToColor(new float[]{hueValue, satValue, valValue});

                mColorSwatch.setBackgroundColor(outputColor);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                TextView hueText = (TextView) findViewById(R.id.hue);
                String displayHueText = "Hue";
                hueText.setText(displayHueText);
            }
        });

        // Activity on the Saturation Bar - change
        mSaturationSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser == true) {
                    TextView satText = (TextView) findViewById(R.id.saturation);
                    String displaySaturationText = "SATURATION " + mSaturationSB.getProgress() + "%";
                    satText.setText(displaySaturationText);
                }
                float hueValue = (float) mHueSB.getProgress();
                float satValue = (float) mSaturationSB.getProgress() / 100;
                float valValue = (float) mValueSB.getProgress() /100;

                int outputColor = Color.HSVToColor(new float[]{hueValue, satValue, valValue});
                mColorSwatch.setBackgroundColor(outputColor);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                TextView satText = (TextView) findViewById(R.id.saturation);
                String displaySaturationText = "Saturation";
                satText.setText(displaySaturationText);
            }
        });

        // Activity on the Value Bar - change
        mValueSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser == true) {
                    TextView valueText = (TextView) findViewById(R.id.value);
                    String displayValueText = "VALUE / LIGHTNESS " + mValueSB.getProgress() + "%";
                    valueText.setText(displayValueText);
                }
                float hueValue = (float) mHueSB.getProgress();
                float satValue = (float) mSaturationSB.getProgress() / 100;
                float valValue = (float) mValueSB.getProgress() /100;

                int outputColor = Color.HSVToColor(new float[]{hueValue, satValue, valValue});

                mColorSwatch.setBackgroundColor(outputColor);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                TextView valueText = (TextView) findViewById(R.id.value);
                String displayValueText = "Value / Lightness";
                valueText.setText(displayValueText);
            }
        });

        // The Following are Click Listeners for the buttons
        // When clicked the Swatch is changed and the Seekbars are updated

        mBlackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set swatch

                int outputColor = Color.HSVToColor(new float[]{0.f, 0.f, 0.f});
                mColorSwatch.setBackgroundColor(outputColor);

                // set hue bar
                mHueSB.setProgress(0);

                // set sat bar
                mSaturationSB.setProgress(0);
                // set value bar
                mValueSB.setProgress(0);
                // display toast
                Toast.makeText(MainActivity.this, "H: " + mHueSB.getProgress() + "\u00B0 S: " + mSaturationSB.getProgress() + "% V: " + +mValueSB.getProgress() + "%.", Toast.LENGTH_SHORT).show();
            }
        });

        mRedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set swatch

                int outputColor = Color.HSVToColor(new float[]{0.f, 1.f, 1.f});
                mColorSwatch.setBackgroundColor(outputColor);

                // set hue bar
                mHueSB.setProgress(0);

                // set sat bar
                mSaturationSB.setProgress(100);
                // set value bar
                mValueSB.setProgress(100);
                // display toast
                Toast.makeText(MainActivity.this, "H: " + mHueSB.getProgress() + "\u00B0 S: " + mSaturationSB.getProgress() + "% V: " + +mValueSB.getProgress() + "%.", Toast.LENGTH_SHORT).show();
            }
        });

        mLimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set swatch

                int outputColor = Color.HSVToColor(new float[]{120.f, 1.f, 1.f});
                mColorSwatch.setBackgroundColor(outputColor);

                // set hue bar
                mHueSB.setProgress(120);

                // set sat bar
                mSaturationSB.setProgress(100);
                // set value bar
                mValueSB.setProgress(100);
                // display toast
                Toast.makeText(MainActivity.this, "H: " + mHueSB.getProgress() + "\u00B0 S: " + mSaturationSB.getProgress() + "% V: " + +mValueSB.getProgress() + "%.", Toast.LENGTH_SHORT).show();
            }
        });

        mBlueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set swatch

                int outputColor = Color.HSVToColor(new float[]{240.f, 1.f, 1.f});
                mColorSwatch.setBackgroundColor(outputColor);

                // set hue bar
                mHueSB.setProgress(240);

                // set sat bar
                mSaturationSB.setProgress(100);
                // set value bar
                mValueSB.setProgress(100);
                // display toast
                Toast.makeText(MainActivity.this, "H: " + mHueSB.getProgress() + "\u00B0 S: " + mSaturationSB.getProgress() + "% V: " + +mValueSB.getProgress() + "%.", Toast.LENGTH_SHORT).show();
            }
        });

        mYellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set swatch

                int outputColor = Color.HSVToColor(new float[]{60.f, 1.f, 1.f});
                mColorSwatch.setBackgroundColor(outputColor);

                // set hue bar
                mHueSB.setProgress(60);

                // set sat bar
                mSaturationSB.setProgress(100);
                // set value bar
                mValueSB.setProgress(100);
                // display toast
                Toast.makeText(MainActivity.this, "H: " + mHueSB.getProgress() + "\u00B0 S: " + mSaturationSB.getProgress() + "% V: " + +mValueSB.getProgress() + "%.", Toast.LENGTH_SHORT).show();
            }
        });

        mCyanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set swatch

                int outputColor = Color.HSVToColor(new float[]{180.f, 1.f, 1.f});
                mColorSwatch.setBackgroundColor(outputColor);

                // set hue bar
                mHueSB.setProgress(180);

                // set sat bar
                mSaturationSB.setProgress(100);
                // set value bar
                mValueSB.setProgress(100);
                // display toast
                Toast.makeText(MainActivity.this, "H: " + mHueSB.getProgress() + "\u00B0 S: " + mSaturationSB.getProgress() + "% V: " + +mValueSB.getProgress() + "%.", Toast.LENGTH_SHORT).show();
            }
        });

        mMagentaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set swatch

                int outputColor = Color.HSVToColor(new float[]{300.f, 1.f, 1.f});
                mColorSwatch.setBackgroundColor(outputColor);

                // set hue bar
                mHueSB.setProgress(300);

                // set sat bar
                mSaturationSB.setProgress(100);
                // set value bar
                mValueSB.setProgress(100);
                // display toast
                Toast.makeText(MainActivity.this, "H: " + mHueSB.getProgress() + "\u00B0 S: " + mSaturationSB.getProgress() + "% V: " + +mValueSB.getProgress() + "%.", Toast.LENGTH_SHORT).show();
            }
        });

        mSilverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set swatch

                int outputColor = Color.HSVToColor(new float[]{0.f, 0.f, .75f});
                mColorSwatch.setBackgroundColor(outputColor);

                // set hue bar
                mHueSB.setProgress(0);

                // set sat bar
                mSaturationSB.setProgress(0);
                // set value bar
                mValueSB.setProgress(75);
                // display toast
                Toast.makeText(MainActivity.this, "H: " + mHueSB.getProgress() + "\u00B0 S: " + mSaturationSB.getProgress() + "% V: " + +mValueSB.getProgress() + "%.", Toast.LENGTH_SHORT).show();
            }
        });

        mGrayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set swatch

                int outputColor = Color.HSVToColor(new float[]{0.f, 0.f, .50f});
                mColorSwatch.setBackgroundColor(outputColor);

                // set hue bar
                mHueSB.setProgress(0);

                // set sat bar
                mSaturationSB.setProgress(0);
                // set value bar
                mValueSB.setProgress(50);
                // display toast
                Toast.makeText(MainActivity.this, "H: " + mHueSB.getProgress() + "\u00B0 S: " + mSaturationSB.getProgress() + "% V: " + +mValueSB.getProgress() + "%.", Toast.LENGTH_SHORT).show();
            }
        });

        mMaroonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set swatch

                int outputColor = Color.HSVToColor(new float[]{0.f, 1.f, .5f});
                mColorSwatch.setBackgroundColor(outputColor);

                // set hue bar
                mHueSB.setProgress(0);

                // set sat bar
                mSaturationSB.setProgress(100);
                // set value bar
                mValueSB.setProgress(50);
                // display toast
                Toast.makeText(MainActivity.this, "H: " + mHueSB.getProgress() + "\u00B0 S: " + mSaturationSB.getProgress() + "% V: " + +mValueSB.getProgress() + "%.", Toast.LENGTH_SHORT).show();
            }
        });

        mOliveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set swatch

                int outputColor = Color.HSVToColor(new float[]{50.f, 1.f, .5f});
                mColorSwatch.setBackgroundColor(outputColor);

                // set hue bar
                mHueSB.setProgress(50);

                // set sat bar
                mSaturationSB.setProgress(100);
                // set value bar
                mValueSB.setProgress(50);
                // display toast
                Toast.makeText(MainActivity.this, "H: " + mHueSB.getProgress() + "\u00B0 S: " + mSaturationSB.getProgress() + "% V: " + +mValueSB.getProgress() + "%.", Toast.LENGTH_SHORT).show();
            }
        });

        mGreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set swatch

                int outputColor = Color.HSVToColor(new float[]{120.f, 1.f, .5f});
                mColorSwatch.setBackgroundColor(outputColor);

                // set hue bar
                mHueSB.setProgress(120);

                // set sat bar
                mSaturationSB.setProgress(100);
                // set value bar
                mValueSB.setProgress(50);
                // display toast
                Toast.makeText(MainActivity.this, "H: " + mHueSB.getProgress() + "\u00B0 S: " + mSaturationSB.getProgress() + "% V: " + +mValueSB.getProgress() + "%.", Toast.LENGTH_SHORT).show();
            }
        });

        mPurpleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set swatch

                int outputColor = Color.HSVToColor(new float[]{300.f, 1.f, .5f});
                mColorSwatch.setBackgroundColor(outputColor);

                // set hue bar
                mHueSB.setProgress(300);

                // set sat bar
                mSaturationSB.setProgress(100);
                // set value bar
                mValueSB.setProgress(50);
                // display toast
                Toast.makeText(MainActivity.this, "H: " + mHueSB.getProgress() + "\u00B0 S: " + mSaturationSB.getProgress() + "% V: " + +mValueSB.getProgress() + "%.", Toast.LENGTH_SHORT).show();
            }
        });

        mTealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set swatch

                int outputColor = Color.HSVToColor(new float[]{180.f, 1.f, .5f});
                mColorSwatch.setBackgroundColor(outputColor);

                // set hue bar
                mHueSB.setProgress(180);

                // set sat bar
                mSaturationSB.setProgress(100);
                // set value bar
                mValueSB.setProgress(50);
                // display toast
                Toast.makeText(MainActivity.this, "H: " + mHueSB.getProgress() + "\u00B0 S: " + mSaturationSB.getProgress() + "% V: " + +mValueSB.getProgress() + "%.", Toast.LENGTH_SHORT).show();
            }
        });

        mNavyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set swatch

                int outputColor = Color.HSVToColor(new float[]{240.f, 1.f, .5f});
                mColorSwatch.setBackgroundColor(outputColor);

                // set hue bar
                mHueSB.setProgress(240);

                // set sat bar
                mSaturationSB.setProgress(100);
                // set value bar
                mValueSB.setProgress(50);
                // display toast
                Toast.makeText(MainActivity.this, "H: " + mHueSB.getProgress() + "\u00B0 S: " + mSaturationSB.getProgress() + "% V: " + +mValueSB.getProgress() + "%.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Activity for the About Dialog
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            DialogFragment newFragment = new AboutDialogFragment();
            newFragment.show( getFragmentManager(), ABOUT_DIALOG_TAG);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
