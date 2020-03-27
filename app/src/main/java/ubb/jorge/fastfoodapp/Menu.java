package ubb.jorge.fastfoodapp;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;

public class Menu extends AppCompatActivity {

    ArrayList<Sandwiches> lista_productos; // Create an ArrayList object

    private ImageView placeholder;
    private ImageView arrow_left;
    private ImageView arrow_right;
    private ImageView tab;
    private int index; //con esta variable iteraremos por sandwiches

    private TextView title;
    private TextView description;
    private TextView price;
    private Button btn_ordenar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        lista_productos =  new ArrayList<Sandwiches>();
        mockSandwiches();
        index = 0;
        //String tray = getResources().getValue();

        placeholder = (ImageView) findViewById(R.id.placeholder);
        arrow_left = (ImageView)  findViewById(R.id.leftArrow);
        arrow_right = (ImageView) findViewById(R.id.rightArrow);
        //ARROW LISTENERS BELOW

        // sandwich attributes
        title = (TextView) findViewById(R.id.title);
        description = (TextView) findViewById(R.id.description);
        price = (TextView) findViewById(R.id.price);
        tab = ( ImageView ) findViewById(R.id.tab);
        btn_ordenar = (Button) findViewById(R.id.order_btn);


        tab.setTranslationY(3000f);
        entranceAnimation();
        (new Handler()).postDelayed(this::finishLoading, 1500);

        arrow_left.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pulseFader(arrow_left,700);
                if(index==0){
                    index=6;
                }else index--;

                mountSandwich(index);
                //animation in

                itemFadeIn();
            }
        });
        arrow_right.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pulseFader(arrow_right,700);
                if(index==6){
                    index=0;
                }else index++
                        ;
                //animation out
                mountSandwich(index);
                //animation in
                itemFadeIn();
            }
        });

        btn_ordenar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Backend no implementado " , Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }));
    }



    private void finishLoading(){
        findViewById(R.id.loadingPanel).setVisibility(View.GONE);
    }

//
    private void animationIn(long offset,long duration){
        AlphaAnimation fadeIn = new AlphaAnimation( 0f,1f);
        fadeIn.setDuration(duration);
        fadeIn.setFillAfter(true);
        fadeIn.setStartOffset(offset);
        fadeIn.setInterpolator(new DecelerateInterpolator());

    }

    private void entranceAnimation(){
        ObjectAnimator anim_tab = (ObjectAnimator) ObjectAnimator.ofFloat
                (tab,"translationY",0f);
        anim_tab.setDuration(600);
        anim_tab.setInterpolator(new DecelerateInterpolator());
        fadeIn(0,tab,300);
        anim_tab.start();

        fadeIn(1500,title,1000);
        fadeIn(1600,description,1000);
        fadeIn(1700,price,1000);
        fadeIn(1800,btn_ordenar,1000);

        fadeIn( 1700,placeholder,1000);
        fadeIn(2100,arrow_left,400);
        fadeIn(2100,arrow_right,400);

    }

    private void fadeIn(long offset, View target,long duration){
        AlphaAnimation fadeIn = new AlphaAnimation( 0f,1f);
        fadeIn.setDuration(duration);
        fadeIn.setFillAfter(true);
        fadeIn.setStartOffset(offset);
        fadeIn.setInterpolator(new DecelerateInterpolator());
        target.startAnimation(fadeIn);
    }

    //unused
    private void fadeOut(long offset, View target,long duration){
        AlphaAnimation fadeOut = new AlphaAnimation( 1f,0f);
        fadeOut.setDuration(duration);
        fadeOut.setFillAfter(true);
        fadeOut.setStartOffset(offset);
        fadeOut.setInterpolator(new DecelerateInterpolator());
        target.startAnimation(fadeOut);
    }

    //fades like pulse
    private void pulseFader( View target,long duration){
        AlphaAnimation fadeIn = new AlphaAnimation( 0.4f,1f);
        AlphaAnimation fadeOut = new AlphaAnimation( 1f,0.4f);
        fadeIn.setDuration(duration/2);
        fadeOut.setDuration(duration/2);
        fadeIn.setFillAfter(true);
        fadeOut.setFillAfter(true);
        fadeIn.setStartOffset(duration/2);

        fadeIn.setInterpolator(new DecelerateInterpolator());
        fadeOut.setInterpolator(new DecelerateInterpolator());

        target.startAnimation(fadeOut);
        target.startAnimation(fadeIn);
    }

    private void itemFadeIn(){
        fadeIn(300,title,700);
        fadeIn(300,description,900);
        fadeIn(300,price,1000);
        fadeIn(300,btn_ordenar,1100);
        fadeIn( 300,placeholder,1200);
    }


    //we create mock data
    private void mockSandwiches(){
        lista_productos.add(new Sandwiches(getResources().getString(R.string.title_1),getResources().getString(R.string.description_1),
                getResources().getString(R.string.description_1),getDrawable(R.drawable.neoyorkina)));
        lista_productos.add(new Sandwiches(getResources().getString(R.string.title_2),getResources().getString(R.string.description_2),
                getResources().getString(R.string.description_2),getDrawable(R.drawable.arequipa)));
        lista_productos.add(new Sandwiches(getResources().getString(R.string.title_3),getResources().getString(R.string.description_3),
                getResources().getString(R.string.description_3),getDrawable(R.drawable.churrasco)));
        lista_productos.add(new Sandwiches(getResources().getString(R.string.title_4),getResources().getString(R.string.description_4),
                getResources().getString(R.string.description_4),getDrawable(R.drawable.cangreburger)));
        lista_productos.add(new Sandwiches(getResources().getString(R.string.title_5),getResources().getString(R.string.description_5),
                getResources().getString(R.string.description_5),getDrawable(R.drawable.clasica)));
        lista_productos.add(new Sandwiches(getResources().getString(R.string.title_6),getResources().getString(R.string.description_6),
                getResources().getString(R.string.description_6),getDrawable(R.drawable.tostadas)));
        lista_productos.add(new Sandwiches(getResources().getString(R.string.title_7),getResources().getString(R.string.description_7),
                getResources().getString(R.string.description_7),getDrawable(R.drawable.viajero)));

    }

    //


    //with this method we mount the sandwich at index on lista_productos to the screen
    private void mountSandwich(int index){
        System.out.println("MONTANDO "+index);
        switch (index){
            case 0:
                System.out.println("CASE 0");
                title.setText(getResources().getText(R.string.title_1));
                description.setText(getResources().getText(R.string.description_1));
                price.setText(getResources().getText(R.string.precio_1));
                placeholder.setImageResource(R.drawable.neoyorkina);
                return
                ;
            case 1:
                System.out.println("CASE 1");
                title.setText(getResources().getText(R.string.title_2));
                description.setText(getResources().getText(R.string.description_2));
                price.setText(getResources().getText(R.string.precio_2));
                placeholder.setImageResource(R.drawable.arequipa);
                return;
            case 2:
                System.out.println("CASE 2");
                title.setText(getResources().getText(R.string.title_3));
                description.setText(getResources().getText(R.string.description_3));
                price.setText(getResources().getText(R.string.precio_3));
                placeholder.setImageResource(R.drawable.churrasco);
                return;
            case 3:
                System.out.println("CASE 3");
                title.setText(getResources().getText(R.string.title_4));
                description.setText(getResources().getText(R.string.description_4));
                price.setText(getResources().getText(R.string.precio_4));
                placeholder.setImageResource(R.drawable.cangreburger);
                return;
            case 4:
                System.out.println("CASE 4");
                title.setText(getResources().getText(R.string.title_5));
                description.setText(getResources().getText(R.string.description_5));
                price.setText(getResources().getText(R.string.precio_5));
                placeholder.setImageResource(R.drawable.clasica);
                return;
            case 5:
                System.out.println("CASE 5");
                title.setText(getResources().getText(R.string.title_6));
                description.setText(getResources().getText(R.string.description_6));
                price.setText(getResources().getText(R.string.precio_6));
                placeholder.setImageResource(R.drawable.tostadas);
                return;
            case 6:
                System.out.println("CASE 6");
                title.setText(getResources().getText(R.string.title_7));
                description.setText(getResources().getText(R.string.description_7));
                price.setText(getResources().getText(R.string.precio_7));
                placeholder.setImageResource(R.drawable.viajero);
                return;

            default: return;
        }
    }

}
