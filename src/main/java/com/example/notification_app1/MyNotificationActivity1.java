package com.example.notification_app1;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MyNotificationActivity1 extends AppCompatActivity {

    int i1 = 8, counter = 0;
    int i2;
    private NotificationManager nm;
    private final int NOTIFICATION_ID = 127;
    public Button mButton;
    public String strDate;
    Notification.Builder builder;
    TextView textV1;
    WebView wv;
    ViewPager vp1;
    FrameLayout frameLayout;
    ImageView img1;

    String desT = "04 22:13";

    Timer timer;
    TimerTask mTimerTask;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_my_notification1);
        frameLayout = findViewById(R.id.frame1);
        frameLayout.setBackgroundColor(Color.WHITE);
        //vp1.setBackgroundColor(Color.WHITE);
        wv = findViewById(R.id.webView1);
        wv.loadUrl("file:///android_asset/2.gif");
        img1 = findViewById(R.id.imageView);

        mButton = (Button)findViewById(R.id.button2);
        textV1 = findViewById(R.id.textV1);

        mButton.setEnabled(false);
        mButton.setText("");
        //mButton.setEnabled(false);
        mButton.setVisibility(View.VISIBLE);

        timer = new Timer();
        mTimerTask = new MyTimerTask();

        timer.schedule(mTimerTask, 0, 1000);

        nm = (NotificationManager)getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);


        mediaPlayer = MediaPlayer.create(this, R.raw.sound1);
        mediaPlayer.start();

        //mediaPlayer.reset();


    }
    public void pressed(View view){
        //timer.cancel();
        //builder.setOngoing(false);
        Intent intent1 = new Intent(MyNotificationActivity1.this,MainActivity.class);
        startActivity(intent1);
        //showNotification();
    }

    public void pressed1(View view){
        // i1--;
        counter++;
        if(counter>=8){

            showNotification();

        }
    }


    public void showNotification(){
        builder = new Notification.Builder(getApplicationContext());
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        builder
                .setContentIntent(pendingIntent)
                //.setSmallIcon(R.mipmap.ic_launcher)
                .setSmallIcon(R.mipmap.gift_flat)
                //.setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.mipmap.ic_launcher))
                .setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.mipmap.gift_flat))
                .setTicker("Новое уведомление")
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentTitle("Настко, время пришло:D")
                .setContentText("Жмакай судо")
                //.setSound("")
                .setOngoing(true);


        Notification notification = builder.build();
        nm.notify(NOTIFICATION_ID, notification);
    }

    class MyTimerTask extends TimerTask {


        @Override
        public void run() {


            // Берем дату и время с системного календаря:
            Calendar calendar = Calendar.getInstance();
            //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM.dd HH:mm");
            //
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");
            // Преобразуем информацию в строковые данные:
            strDate = simpleDateFormat.format(calendar.getTime());
            i2 = Integer.parseInt(strDate);



            runOnUiThread(new Runnable() {


                // Отображаем информацию в текстовом поле count:
                @Override
                public void run() {
                    mButton.setText(Integer.toString(i1-i2));
                    if(i1-i2==0) {
                        textV1.setText("Вперед!!!");
                        mButton.setEnabled(true);
                        mButton.setText("Чего же ты ждешь?!;DD");
                        showNotification();
                        mButton.setVisibility(View.VISIBLE);
                    }

                }
            });
        }
    }
}


