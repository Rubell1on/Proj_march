package com.example.notification_app1;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.content.res.AssetFileDescriptor;
import android.widget.Toast;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.lang.Runnable;

public class MainActivity extends MyNotificationActivity1{

    private SoundPool mSoundPool;

    private int mSound;
    private int mStreamID;
    private AssetManager mAssetManager;

    public static final long DEFAULT_ANIMATION_DURATION = 2500L;
    protected View mFrameLayout;
    protected float mScreenHeight;
    TextView textView;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    Button callButton;

    float value;
    AnimatorSet animatorSet;
    int i = 0, g = 0, g1 = 0;

    private Timer mTimer;
    private MyTimerTask mMyTimerTask;
    //MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        textView = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        ObjectAnimator objectAnimator;

        textView.setAlpha(0);
        ValueAnimator valueAnimator1 = ValueAnimator.ofFloat(-200, 0);

        mFrameLayout = findViewById(R.id.const1);

        callButton = findViewById(R.id.call_button);


        mTimer = new Timer();
        mMyTimerTask = new MyTimerTask();

        mTimer.schedule(mMyTimerTask, 1000);

        /*new CountDownTimer(1000000,10000){
            @Override
            public void onFinish(){

            }
            public void onTick(long millisUntilFinished){
                playSound(mSound);
            }
        }.start();*/
        mediaPlayer.reset();
        mediaPlayer = null;
        mediaPlayer = MediaPlayer.create(this, R.raw.music1);

        //onStartAnimation();
        new CountDownTimer(30000, 3000)
        {
            public void onTick(long millisUntilFinished)
            {
                switch (g)

                {
                    case 0:
                        colAnim(253, 205, 0, 255, 250, 156, 0, 255, 4000L);
                        break;
                    case 1:
                        colAnim(250, 156, 0, 255, 248, 105, 1, 255, 4000L);
                        break;
                    case 2:
                        colAnim(248, 105, 1, 255, 149, 53, 101, 255, 4000L);
                        break;
                    case 3:
                        colAnim(149, 53, 101, 255, 126, 1, 127, 255, 4000L);
                        break;
                    case 4:
                        colAnim(126, 1, 127, 255, 99, 1, 102, 255, 4000L);

                        break;

                }
                g++;
            }
            @Override
            public void onFinish()
            {

            }
        }.start();
        //colAnim(253, 205, 0, 255, 250, 156, 0, 255, 10000L);



        mediaPlayer.start();
        new CountDownTimer(45000, 3000) {
        //new CountDownTimer(3100, 3000) {
            public void onTick(long millisUntilFinished) {

                onStartAnimation();
                switch (i) {
                    case 1:
                        textView.setTextSize(36);
                        //textView.setText("Как дела?");
                        textView.setText("КАК ДЕЛА?");
                        break;
                    case 2:
                        //textView.setText("Не отвечай");
                        textView.setText("НЕ ОТВЕЧАЙ");
                        //onStartAnimation();
                        break;
                    case 3:
                        //textView.setText("Знаю, что оч даже ничего;D");
                        textView.setText("ЗНАЮ, ЧТО ОЧ ДАЖЕ НИЧЕГО;D");
                        //onStartAnimation();
                        break;
                    case 4:
                        //textView.setText("Я тут узнал,");
                        textView.setText("Я ТУТ УЗНАЛ,");
                        //onStartAnimation();
                        break;
                    case 5:
                        //textView.setText("что сегодня праздник;D");
                        textView.setText("ЧТО СЕГОДНЯ ПРАЗДНИК;D");
                        //onStartAnimation();
                        break;
                    case 6:
                        //textView.setText("Щет, тащусь с этого котьке:3");
                        textView.setText("ЩЕТ, ТАЩУСЬ С ЭТОГО КОТЬКЕ:3");
                        break;
                    case 7:
                        //textView.setText("Текс, не отвлекаемся;)");
                        textView.setText("ТЕКС, НЕ ОТВЛЕКАЕМСЯ;)");
                        break;
                    case 8:
                        //textView.setText("Ну и решил сделать подарок своими клешнями");
                        textView.setText("НУ И РЕШИЛ СДЕЛАТЬ ПОДАРОК СВОИМИ КЛЕШНЯМИ");
                        break;
                    case 9:
                        //textView.setText("А ничего лучше чем кодитья я не умею");
                        textView.setText("А НИЧЕГО ЛУЧШЕ ЧЕМ КОДИТЬ Я НЕ УМЕЮ");
                        //onStartAnimation();
                        break;
                    case 10:
                        //textView.setText("P.S. Томас лох;D");
                        textView.setText("P.S. ТОМАС ЛОХ;D");
                        //onStartAnimation();
                        break;
                    case 11:
                        //textView.setText("Хотя вру, еще в доту норм играю");
                        textView.setText("ХОТЯ ВРУ, ЕЩЕ В ДОТУ НОРМ ИГРАЮ");
                        //onStartAnimation();
                        break;
                    case 12:
                        //textView.setText("Так вот получился данный чидевер:В");
                        textView.setText("ТАК ВОТ ПОЛУЧИЛСЯ ДАННЫЙ ЧИДЕВЕР:В");
                        //onStartAnimation();
                        break;
                    case 13:
                        //textView.setText("P.S.S. Продам гараж т.88005553535");
                        textView.setText("P.S.S. ПРОДАМ ГАРАЖ т.88005553535");
                        //onStartAnimation();
                        break;

                }
                i++;
            }
            @Override
            public void onFinish() {
                //textView.setTranslationY(0);
                //textView.setAlpha(1);
                //onStartAnimation();
                //textView.setText(Html.fromHtml("С 8 МАРТА, \n"+"<b>"+"Анастасия:**"+"</b>"));
                textView.setVisibility(View.INVISIBLE);
                onStartAnimation_short(textView2,false);
                textView2.setVisibility(View.VISIBLE);
                onStartAnimation_short(textView3,false);
                textView3.setVisibility(View.VISIBLE);

                onStartAnimation_short(textView4,true);
                textView4.setVisibility(View.VISIBLE);

                new CountDownTimer(5000, 1000) {

                    public void onTick(long millisUntilFinished) {


                        switch (g1) {
                            case 1:
                                //textView3.setTranslationY(200);
                                textView3.setText(Html.fromHtml("НАСТАСЬКО:*"));
                                break;
                            case 2:
                                //textView3.setTranslationY(70);
                                textView3.setText(Html.fromHtml("НАСТАСЬКО:**"));
                                break;
                            case 3:
                                //textView3.setTranslationY(70);
                                textView3.setText(Html.fromHtml("НАСТАСЬКО:***"));

                                break;

                        }
                        g1++;
                    }
                    @Override
                    public void onFinish() {
                        textView.setVisibility(View.VISIBLE);
                        textView2.setVisibility(View.INVISIBLE);
                        textView3.setVisibility(View.INVISIBLE);
                        textView4.setVisibility(View.INVISIBLE);
                        onStartAnimation_short(textView,false);
                        callButton.setVisibility(View.VISIBLE);
                        textView.setText("ТЕПЕРЬ МЕНЯ МОЖН ОДАРИТЬ ПОЦЕЛУЯМИ;D");
                        //textView.setText("Теперь меня можн одарить поцелуями;D");

                    }
                }.start();

            }
        }.start();




    }

    @Override
    protected void onResume() {
        super.onResume();

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        mScreenHeight = displaymetrics.heightPixels;

    }


    //@Override
    protected void onStartAnimation() {


        ValueAnimator valueAnimator1 = ValueAnimator.ofFloat(-200, 0);
        ValueAnimator valueAnimator2 = ValueAnimator.ofFloat(0, 1);
        ValueAnimator valueAnimator3 = ValueAnimator.ofFloat(0, 400);
        ValueAnimator valueAnimator4 = ValueAnimator.ofFloat(1,0);




        valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                textView.setTranslationY(value);
                //textView.setAlpha(-value);
            }
        });

        valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                textView.setAlpha(value);
            }
        });

        valueAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                textView.setTranslationY(value);
                //textView.setAlpha(-value);
            }
        });

        valueAnimator4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                textView.setAlpha(value);
            }
        });

//5

        animatorSet = new AnimatorSet();

        valueAnimator1.setInterpolator(new AccelerateInterpolator(0.1f));
        valueAnimator1.setDuration(DEFAULT_ANIMATION_DURATION);

        valueAnimator2.setInterpolator(new AccelerateInterpolator(0.2f));
        valueAnimator2.setDuration(DEFAULT_ANIMATION_DURATION);

        valueAnimator3.setInterpolator(new AccelerateInterpolator(0.1f));
        valueAnimator3.setDuration(DEFAULT_ANIMATION_DURATION);

        valueAnimator4.setInterpolator(new AccelerateInterpolator(0.01f));
        valueAnimator4.setDuration(DEFAULT_ANIMATION_DURATION);
//6
        //animatorSet.play(valueAnimator3).with(valueAnimator4).after(valueAnimator1).with(valueAnimator2);
        animatorSet.play(valueAnimator4).after(valueAnimator2);
        animatorSet.play(valueAnimator3).after(valueAnimator1);
        //animatorSet.setDuration(DEFAULT_ANIMATION_DURATION);

        animatorSet.start();
        //valueAnimator1.start();
        //valueAnimator2.start();


    }

    protected void onStartAnimation_short(final TextView textView, boolean var1) {


        ValueAnimator valueAnimator1 = ValueAnimator.ofFloat(-200, 0);
        ValueAnimator valueAnimator2 = ValueAnimator.ofFloat(0, 1);
        ValueAnimator valueAnimator3 = ValueAnimator.ofFloat(0, 400);
        ValueAnimator valueAnimator4 = ValueAnimator.ofFloat(1,0);


        valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                textView.setTranslationY(value);
                //textView.setAlpha(-value);
            }
        });

        valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                textView.setAlpha(value);
            }
        });

        valueAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                textView.setTranslationY(value);
                //textView.setAlpha(-value);
            }
        });

        valueAnimator4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                textView.setAlpha(value);
            }
        });

//5

        animatorSet = new AnimatorSet();

        valueAnimator1.setInterpolator(new AccelerateInterpolator(0.1f));
        valueAnimator1.setDuration(DEFAULT_ANIMATION_DURATION);

        valueAnimator2.setInterpolator(new AccelerateInterpolator(0.2f));
        valueAnimator2.setDuration(DEFAULT_ANIMATION_DURATION);

        valueAnimator3.setInterpolator(new AccelerateInterpolator(0.1f));
        valueAnimator3.setDuration(DEFAULT_ANIMATION_DURATION);

        valueAnimator4.setInterpolator(new AccelerateInterpolator(0.01f));
        valueAnimator4.setDuration(DEFAULT_ANIMATION_DURATION);
//6
        //animatorSet.play(valueAnimator3).with(valueAnimator4).after(valueAnimator1).with(valueAnimator2);
        //animatorSet.play(valueAnimator4).after(valueAnimator2);
        //animatorSet.play(valueAnimator3).after(valueAnimator1);

        animatorSet.play(valueAnimator1).with(valueAnimator2);


        animatorSet.start();
        //valueAnimator1.start();
        //valueAnimator2.start();
        if(var1 == true) {
            int ColorTo = Color.WHITE;
            int ColorFrom = Color.argb(255, 255, 63, 95);

            ObjectAnimator objectAnimator = ObjectAnimator.ofObject(textView, "textColor",
                    new ArgbEvaluator(),
                    //ContextCompat.getColor(this, ColorFrom),
                    //ContextCompat.getColor(this, ColorTo));
                    ColorTo,
                    ColorFrom);
            //ContextCompat.getColor(this, R.color.colorAccent),
            //ContextCompat.getColor(this, R.color.colorPrimaryDark));


// 2
            //objectAnimator.setRepeatCount(1);
            //objectAnimator.setRepeatMode(ValueAnimator.REVERSE);

// 3
            objectAnimator.setDuration(2000L);
            objectAnimator.start();
        }


    }

   protected void colAnim(int i1, int i2, int i3, int a1, int i4, int i5, int i6, int a2, long l1){
        int ColorTo = Color.argb(a1, i1, i2, i3);
        int ColorFrom = Color.argb(a2, i4, i5, i6);

       ObjectAnimator objectAnimator = ObjectAnimator.ofObject(mFrameLayout, "backgroundColor",
                new ArgbEvaluator(),
                //ContextCompat.getColor(this, ColorFrom),
                //ContextCompat.getColor(this, ColorTo));
                ColorTo,
                ColorFrom);
                //ContextCompat.getColor(this, R.color.colorAccent),
                //ContextCompat.getColor(this, R.color.colorPrimaryDark));


// 2
        //objectAnimator.setRepeatCount(1);
        //objectAnimator.setRepeatMode(ValueAnimator.REVERSE);

// 3
        objectAnimator.setDuration(l1);
        objectAnimator.start();
    }

    private void createNewSoundPool() {
        AudioAttributes attributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        mSoundPool = new SoundPool.Builder()
                .setAudioAttributes(attributes)
                .build();
    }

    private int loadSound(String fileName) {
        AssetFileDescriptor afd;
        try {
            afd = mAssetManager.openFd(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Не могу загрузить файл " + fileName,
                    Toast.LENGTH_SHORT).show();
            return -1;
        }
        return mSoundPool.load(afd, 1);
    }

    private int playSound(int sound) {
        if (sound > 0) {
            mStreamID = mSoundPool.play(sound, 1, 1, 1, 1, 1);
        }
        return mStreamID;
    }

    public void dial(View v) {
       mediaPlayer.reset();
       String toDial="tel:89232840923";
       startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(toDial)));
       textView.setText("Люблю тебя;***");
    }

}

