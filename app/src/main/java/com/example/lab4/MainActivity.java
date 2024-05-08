package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnFadeInXml, btnFadeInCode, btnFadeOutXml, btnFadeOutCode,
            btnBlinkXml,
            btnBlinkCode, btnZoomInXml, btnZoomInCode, btnZoomOutXml,
            btnZoomOutCode, btnRotateXml,
            btnRotateCode, btnMoveXml, btnMoveCode, btnSlideUpXml, btnSlideUpCode,
            btnBounceXml,
            btnBounceCode, btnCombineXml, btnCombineCode;
    private ImageView ivUitLogo;
    private Animation.AnimationListener animationListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewsByIds();
        initVariables();

        final Animation fade_in_animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim_fade_in);
        final Animation fade_out_animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim_fade_out);
        final Animation blink_animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim_blink);
        final Animation zoom_in_animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim_zoom_in);
        final Animation zoom_out_animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim_zoom_out);
        final Animation rotate_animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim_rotate);
        final Animation move_animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim_move);
        final Animation slide_up_animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim_slide_up);
        final Animation bounce_animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim_bounce);
        final Animation combine_animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim_combine);

        handleClickAnimationXml(btnFadeInXml,fade_in_animation);
        handleClickAnimationXml(btnFadeOutXml,fade_out_animation);
        handleClickAnimationXml(btnBlinkXml,blink_animation);
        handleClickAnimationXml(btnZoomInXml,zoom_in_animation);
        handleClickAnimationXml(btnZoomOutXml,zoom_out_animation);
        handleClickAnimationXml(btnRotateXml,rotate_animation);
        handleClickAnimationXml(btnMoveXml,move_animation);
        handleClickAnimationXml(btnSlideUpXml,slide_up_animation);
        handleClickAnimationXml(btnBounceXml,bounce_animation);
        handleClickAnimationXml(btnCombineXml,combine_animation);

        handleClickAnimationXml(btnFadeInCode,initFadeInAnimation());
        handleClickAnimationXml(btnFadeOutCode,initFadeOutAnimation());
        handleClickAnimationXml(btnBlinkCode,initBlinkAnimation());
        handleClickAnimationXml(btnZoomInCode,initZoomInAnimation());
        handleClickAnimationXml(btnZoomOutCode,initZoomOutAnimation());
        handleClickAnimationXml(btnRotateCode,initRotateAnimation());
        handleClickAnimationXml(btnMoveCode,initMoveAnimation());
        handleClickAnimationXml(btnSlideUpCode,initSlideUpAnimation());
        handleClickAnimationXml(btnBounceCode,initBounceAnimation());
        handleClickAnimationXml(btnCombineCode,initCombineAnimation());

        ivUitLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_move2, R.anim.anim_fade_in);
            }
        });

    }
    private void findViewsByIds() {
        ivUitLogo = (ImageView) findViewById(R.id.iv_uit_logo);
        btnFadeInXml = (Button) findViewById(R.id.btn_fade_in_xml);
        btnFadeInCode = (Button) findViewById(R.id.btn_fade_in_code);
        btnFadeOutXml = (Button) findViewById(R.id.btn_fade_out_xml);
        btnFadeOutCode = (Button) findViewById(R.id.btn_fade_out_code);
        btnBlinkXml = (Button) findViewById(R.id.btn_blink_xml);
        btnBlinkCode = (Button) findViewById(R.id.btn_blink_code);
        btnZoomInXml = (Button) findViewById(R.id.btn_zoom_in_xml);
        btnZoomInCode = (Button) findViewById(R.id.btn_zoom_in_code);
        btnZoomOutXml = (Button) findViewById(R.id.btn_zoom_out_xml);
        btnZoomOutCode = (Button) findViewById(R.id.btn_zoom_out_code);
        btnRotateXml = (Button) findViewById(R.id.btn_rotate_xml);
        btnRotateCode = (Button) findViewById(R.id.btn_rotate_code);
        btnMoveXml = (Button) findViewById(R.id.btn_move_xml);
        btnMoveCode = (Button) findViewById(R.id.btn_move_code);
        btnSlideUpXml = (Button) findViewById(R.id.btn_slide_up_xml);
        btnSlideUpCode = (Button) findViewById(R.id.btn_slide_up_code);
        btnBounceXml = (Button) findViewById(R.id.btn_bounce_xml);
        btnBounceCode = (Button) findViewById(R.id.btn_bounce_code);
        btnCombineXml = (Button) findViewById(R.id.btn_combine_xml);
        btnCombineCode = (Button) findViewById(R.id.btn_combine_code);
    }
    private void initVariables() {
        animationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(getApplicationContext(), "Animation Stopped", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        };
    }
    private void handleClickAnimationXml(Button btn, final Animation animation){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation);
            }
        });

    }
    private Animation initFadeInAnimation(){
        AlphaAnimation animation=new AlphaAnimation(0f,1f);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }
    private Animation initFadeOutAnimation(){
        AlphaAnimation animation=new AlphaAnimation(0f,1f);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }
    private Animation initBlinkAnimation(){
        AlphaAnimation animation=new AlphaAnimation(0f,1f);
        animation.setDuration(300);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setRepeatCount(3);
        animation.setAnimationListener(animationListener);
        return animation;
    }
    private Animation initZoomInAnimation(){
        ScaleAnimation animation=new ScaleAnimation(1.0f,3.0f,1.0f,3.0f,0.5f,0.5f);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        AnimationSet animationSet=new AnimationSet(false);
        animationSet.addAnimation(animation);
        return animationSet;
    }
    private Animation initZoomOutAnimation(){
        ScaleAnimation animation=new ScaleAnimation(1.0f,0.5f,1.0f,0.5f,0.5f,0.5f);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        AnimationSet animationSet=new AnimationSet(false);
        animationSet.addAnimation(animation);
        return animationSet;
    }
    private Animation initRotateAnimation(){
        RotateAnimation animation=new RotateAnimation(0.0f,360.0f,
                0.5f,0.5f);
        animation.setDuration(600);
        animation.setRepeatMode(Animation.RESTART);
        animation.setRepeatCount(2);
        AnimationSet animationSet=new AnimationSet(false);
        animationSet.addAnimation(animation);
        animationSet.setInterpolator(AnimationUtils.loadInterpolator(this, android.R.anim.cycle_interpolator));

        return animationSet;
    }
    private Animation initMoveAnimation(){
        TranslateAnimation animation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.75f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        animation.setDuration(800);

        AnimationSet animationSet=new AnimationSet(false);
        animationSet.addAnimation(animation);
        animationSet.setInterpolator(AnimationUtils.loadInterpolator(this, android.R.anim.linear_interpolator));
        animationSet.setFillAfter(true);

        return animationSet;
    }
    private Animation initSlideUpAnimation(){
        ScaleAnimation animation=new ScaleAnimation(1.0f,1.0f,
                1.0f,0f, 0.5f, 0.5f);
        animation.setDuration(500);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }
    private Animation initBounceAnimation(){
        ScaleAnimation animation=new ScaleAnimation(1f,1f,0f,1f);
        animation.setDuration(500);
        animation.setFillAfter(true);
        animation.setInterpolator(AnimationUtils.loadInterpolator(this,android.R.anim.bounce_interpolator));
        animation.setAnimationListener(animationListener);
        return animation;
    }
    private Animation initCombineAnimation(){
        ScaleAnimation ScaleAnimation=new ScaleAnimation(1f,3f,1f,3f, 0.5f, 0.5f);
        ScaleAnimation.setDuration(4000);
        ScaleAnimation.setFillAfter(true);
        RotateAnimation RotateAnimation=new RotateAnimation(0f,360f,0.5f, 0.5f);
        RotateAnimation.setDuration(500);
        RotateAnimation.setRepeatMode(Animation.RESTART);
        RotateAnimation.setRepeatCount(2);

        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(ScaleAnimation);
        animationSet.addAnimation(RotateAnimation);
        return animationSet;
    }
}