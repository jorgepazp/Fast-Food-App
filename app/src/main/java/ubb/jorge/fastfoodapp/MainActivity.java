package ubb.jorge.fastfoodapp;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.content.pm.ActivityInfo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView isotipo;
    private ImageView logotipo;
    private Button  botonMenu;
    private Button botonVerMas;


    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);


        isotipo = (ImageView) findViewById(R.id.isotipo);
        logotipo = (ImageView) findViewById(R.id.logotipo);
        botonMenu = (Button) findViewById(R.id.botonMenu);
        botonVerMas = (Button) findViewById(R.id.botonVerMas);

        //Configuramos animaciones (opacidad y posición desde la que empezarán a moverse
        //Definimos animaciones para el isotipo y logotipo
        isotipo.setTranslationX(-1000f); // AJustamos posicion inicial en X del isotipo
        logotipo.setTranslationX(-1000f); //Lo mismo pero con el logotipo
        //tambien para los botones
        botonMenu.setTranslationY(100f);
        botonVerMas.setTranslationY(100f);

        //la siguient animación anima la propiedad opacidad alfa de un elemento ImageView
        //en ese sentido, nos ahorramos crear una distinta para el isotipo y logotipo
        AlphaAnimation alphaAnim = new AlphaAnimation(0.1f,1.0f);
        alphaAnim.setDuration(1000);
        alphaAnim.setFillAfter(true);

        AlphaAnimation alphaAnimButtons = new AlphaAnimation( 0f,1f);
        alphaAnimButtons.setDuration(1000);
        alphaAnimButtons.setFillAfter(true);
        alphaAnimButtons.setStartOffset(1300);

        //Animamos logotipo e isotipo a su ubicación final
        ObjectAnimator anim_isotipo_translate = (ObjectAnimator) ObjectAnimator.ofFloat
                (isotipo,"translationX",0f);
        ObjectAnimator anim_logotipo_translate = (ObjectAnimator) ObjectAnimator.ofFloat
                (logotipo,"translationX",0f);

        ObjectAnimator anim_btn_menu = (ObjectAnimator) ObjectAnimator.ofFloat
                (botonMenu,"translationY",0f);
        ObjectAnimator anim_btn_verMas = (ObjectAnimator) ObjectAnimator.ofFloat
                (botonVerMas,"translationY",0f);

        isotipo.startAnimation(alphaAnim);
        logotipo.startAnimation(alphaAnim);
        anim_isotipo_translate.setDuration(500);
        anim_logotipo_translate.setDuration(500);
        anim_logotipo_translate.setStartDelay(700);

        anim_btn_menu.setDuration(1000);
        anim_btn_verMas.setDuration(1200);
        anim_btn_menu.setStartDelay(1000);
        anim_btn_verMas.setStartDelay(1000);

        //inicia secuencia de animación
        anim_isotipo_translate.start();
        anim_logotipo_translate.start();
        anim_btn_menu.start();
        anim_btn_verMas.start();

        botonMenu.startAnimation(alphaAnimButtons);
        botonVerMas.startAnimation(alphaAnimButtons);



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "contacto: paz.jorge1@gmail.com \n" +
                        "Proyecto final Electivo de Android", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void verMenu(View view){
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

    public void verAboutUs(View view){
        Intent intent = new Intent(this, about_us.class);
        startActivity(intent);
    }


}
