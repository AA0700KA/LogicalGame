package java.devcolibri.itvdn.com.logicalgame;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by sams9 on 13.01.2020.
 */

public class Nim extends Activity implements View.OnTouchListener {

    private boolean[][] use = new boolean[5][3];
    private boolean[][] deleted = new boolean[5][3];
    private boolean firstUse = true;
    private int counter = 0;
    private int deleteCounter = 0;
    private boolean firstPlayerTurn = true;
    boolean finish = false;

    RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.nim_game);

        relativeLayout = findViewById(R.id.relativeLayout);
        relativeLayout.setOnTouchListener(this);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                use[i][j] = false;
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                deleted[i][j] = false;
            }
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        System.out.println("x = " + x + " y = " + y);
        if(counter == 0 && firstUse == false){
            firstUse = true;
        }
        if (y < 340 && y > 240 && event.getAction() == MotionEvent.ACTION_DOWN) {
            if (x < 200 && x > 100 && use[0][0] == false && deleted[0][0] == false){
                if ((firstUse == true&&deleted[1][0] == true&&deleted[2][0] == true)||use[1][0] == true) {
                    counter++;
                    ImageView imgView = (ImageView) findViewById(R.id.money00);
                    imgView.setImageResource(R.drawable.black2);
                    use[0][0] = true;
                    if (firstUse == true) {
                        firstUse = false;
                    }
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Ход невозможен", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else if (x < 310 && x > 210 && use[1][0] == false && deleted[1][0] == false){
                if((firstUse == true&&deleted[2][0] == true)||use[0][0] == true||use[2][0] == true) {
                    counter++;
                    ImageView imgView = (ImageView) findViewById(R.id.money10);
                    imgView.setImageResource(R.drawable.black2);
                    use[1][0] = true;
                    if (firstUse == true) {
                        firstUse = false;
                    }
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Ход невозможен", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else if (x < 420 && x > 320 && use[2][0] == false && deleted[2][0] == false){
                if(firstUse == true||use[1][0] == true) {
                    counter++;
                    ImageView imgView = (ImageView) findViewById(R.id.money20);
                    imgView.setImageResource(R.drawable.black2);
                    use[2][0] = true;
                    if (firstUse == true) {
                        firstUse = false;
                    }
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Ход невозможен", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }//1end
            else if (x < 200 && x > 100 && use[0][0] == true){
                counter--;
                ImageView imgView = (ImageView) findViewById(R.id.money00);
                imgView.setImageResource(R.drawable.money2);
                use[0][0] = false;
            }
            else if (x < 310 && x > 210 && use[1][0] == true){
                if(use[2][0] == true && use[0][0] == true){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Ход невозможен", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    counter--;
                    ImageView imgView = (ImageView) findViewById(R.id.money10);
                    imgView.setImageResource(R.drawable.money2);
                    use[1][0] = false;
                }
            }
            else if (x < 420 && x > 320 && use[2][0] == true){
                counter--;
                ImageView imgView = (ImageView) findViewById(R.id.money20);
                imgView.setImageResource(R.drawable.money2);
                use[2][0] = false;
            }
        }
        else if (y < 450 && y > 350 && event.getAction() == MotionEvent.ACTION_DOWN) {
            if (x < 200 && x > 100 && use[0][1] == false && deleted[0][1] == false){
                if((firstUse == true&&deleted[1][1] == true&&deleted[2][1] == true&&deleted[3][1] == true)||use[1][1] == true) {
                    counter++;
                    ImageView imgView = (ImageView) findViewById(R.id.money01);
                    imgView.setImageResource(R.drawable.black2);
                    use[0][1] = true;
                    if (firstUse == true) {
                        firstUse = false;
                    }
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Ход невозможен", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else if (x < 310 && x > 210 && use[1][1] == false && deleted[1][1] == false){
                if((firstUse == true&&deleted[2][1] == true&&deleted[3][1] == true)||use[0][1] == true||use[2][1] == true) {
                    counter++;
                    ImageView imgView = (ImageView) findViewById(R.id.money11);
                    imgView.setImageResource(R.drawable.black2);
                    use[1][1] = true;
                    if (firstUse == true) {
                        firstUse = false;
                    }
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Ход невозможен", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else if (x < 420 && x > 320 && use[2][1] == false && deleted[2][1] == false){
                if((firstUse == true&&deleted[3][1] == true)||use[1][1] == true||use[3][1] == true) {
                    counter++;
                    ImageView imgView = (ImageView) findViewById(R.id.money21);
                    imgView.setImageResource(R.drawable.black2);
                    use[2][1] = true;
                    if (firstUse == true) {
                        firstUse = false;
                    }
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Ход невозможен", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else if (x < 530 && x > 430 && use[3][1] == false && deleted[3][1] == false){
                if(firstUse == true||use[2][1] == true) {
                    counter++;
                    ImageView imgView = (ImageView) findViewById(R.id.money31);
                    imgView.setImageResource(R.drawable.black2);
                    use[3][1] = true;
                    if (firstUse == true) {
                        firstUse = false;
                    }
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Ход невозможен", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }//1end
            else if (x < 200 && x > 100 && use[0][1] == true){
                counter--;
                ImageView imgView = (ImageView) findViewById(R.id.money01);
                imgView.setImageResource(R.drawable.money2);
                use[0][1] = false;
            }
            else if (x < 310 && x > 210 && use[1][1] == true){
                if(use[0][1] == true && use[2][1] == true){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Ход невозможен", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    counter--;
                    ImageView imgView = (ImageView) findViewById(R.id.money11);
                    imgView.setImageResource(R.drawable.money2);
                    use[1][1] = false;
                }
            }
            else if (x < 420 && x > 320 && use[2][1] == true){
                if(use[1][1] == true && use[3][1] == true){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Ход невозможен", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    counter--;
                    ImageView imgView = (ImageView) findViewById(R.id.money21);
                    imgView.setImageResource(R.drawable.money2);
                    use[2][1] = false;
                }
            }
            else if (x < 530 && x > 430 && use[3][1] == true){
                counter--;
                ImageView imgView = (ImageView) findViewById(R.id.money31);
                imgView.setImageResource(R.drawable.money2);
                use[3][1] = false;
            }
        }
        else if (y < 560 && y > 460 && event.getAction() == MotionEvent.ACTION_DOWN) {
            if (x < 200 && x > 100 && use[0][2] == false && deleted[0][2] == false){
                if((firstUse == true&&deleted[1][2] == true&&deleted[2][2] == true&&deleted[3][2] == true&&deleted[4][2] == true)||use[1][2] == true) {
                    counter++;
                    ImageView imgView = (ImageView) findViewById(R.id.money02);
                    imgView.setImageResource(R.drawable.black2);
                    use[0][2] = true;
                    if (firstUse == true) {
                        firstUse = false;
                    }
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Ход невозможен", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else if (x < 310 && x > 210 && use[1][2] == false && deleted[1][2] == false){
                if((firstUse == true&&deleted[2][2] == true&&deleted[3][2] == true&&deleted[4][2] == true)||use[0][2] == true||use[2][2] == true) {
                    counter++;
                    ImageView imgView = (ImageView) findViewById(R.id.money12);
                    imgView.setImageResource(R.drawable.black2);
                    use[1][2] = true;
                    if (firstUse == true) {
                        firstUse = false;
                    }
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Ход невозможен", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else if (x < 420 && x > 320 && use[2][2] == false && deleted[2][2] == false){
                if((firstUse == true&&deleted[3][2] == true&&deleted[4][2] == true)||use[1][2] == true||use[3][2] == true) {
                    counter++;
                    ImageView imgView = (ImageView) findViewById(R.id.money22);
                    imgView.setImageResource(R.drawable.black2);
                    use[2][2] = true;
                    if (firstUse == true) {
                        firstUse = false;
                    }
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Ход невозможен", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else if (x < 530 && x > 430 && use[3][2] == false && deleted[3][2] == false){
                if((firstUse == true&&deleted[4][2] == true)||use[2][2] == true||use[4][2] == true) {
                    counter++;
                    ImageView imgView = (ImageView) findViewById(R.id.money32);
                    imgView.setImageResource(R.drawable.black2);
                    use[3][2] = true;
                    if (firstUse == true) {
                        firstUse = false;
                    }
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Ход невозможен", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else if (x < 640 && x > 540 && use[4][2] == false && deleted[4][2] == false){
                if(firstUse == true||use[3][2] == true) {
                    counter++;
                    ImageView imgView = (ImageView) findViewById(R.id.money42);
                    imgView.setImageResource(R.drawable.black2);
                    use[4][2] = true;
                    if (firstUse == true) {
                        firstUse = false;
                    }
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Ход невозможен", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }//1end
            else if (x < 200 && x > 100 && use[0][2] == true){
                counter--;
                ImageView imgView = (ImageView) findViewById(R.id.money02);
                imgView.setImageResource(R.drawable.money2);
                use[0][2] = false;
            }
            else if (x < 310 && x > 210 && use[1][2] == true){
                if(use[0][2] == true && use[2][2] == true){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Ход невозможен", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    counter--;
                    ImageView imgView = (ImageView) findViewById(R.id.money12);
                    imgView.setImageResource(R.drawable.money2);
                    use[1][2] = false;
                }
            }
            else if (x < 420 && x > 320 && use[2][2] == true){
                if(use[1][2] == true && use[3][2] == true){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Ход невозможен", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    counter--;
                    ImageView imgView = (ImageView) findViewById(R.id.money22);
                    imgView.setImageResource(R.drawable.money2);
                    use[2][2] = false;
                }
            }
            else if (x < 530 && x > 430 && use[3][2] == true){
                if(use[2][2] == true && use[4][2] == true){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Ход невозможен", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    counter--;
                    ImageView imgView = (ImageView) findViewById(R.id.money32);
                    imgView.setImageResource(R.drawable.money2);
                    use[3][2] = false;
                }
            }
            else if (x < 640 && x > 540 && use[4][2] == true){
                counter--;
                ImageView imgView = (ImageView) findViewById(R.id.money42);
                imgView.setImageResource(R.drawable.money2);
                use[4][2] = false;
            }
        }

        return true;
    }

    public void onClickOK(View v){
        if(finish){
            Intent intent = new Intent(this, Nim.class);
            startActivity(intent);
        }
        if(use[0][0] == false && use[1][0] == false && use[2][0] == false && use[0][1] == false && use[1][1] == false && use[2][1] == false && use[3][1] == false && use[0][2] == false && use[1][2] == false && use[2][2] == false && use[3][2] == false && use[4][2] == false){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Ход невозможен!\nВы должны выбрать монету/монеты", Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            if (use[0][0] == true) {
                counter--;
                deleteCounter++;
                deleted[0][0] = true;
                use[0][0] = false;
                ImageView imgView = (ImageView) findViewById(R.id.money00);
                imgView.setVisibility(View.INVISIBLE);
            }
            if (use[1][0] == true) {
                counter--;
                deleteCounter++;
                deleted[1][0] = true;
                use[1][0] = false;
                ImageView imgView = (ImageView) findViewById(R.id.money10);
                imgView.setVisibility(View.INVISIBLE);
            }
            if (use[2][0] == true) {
                counter--;
                deleteCounter++;
                deleted[2][0] = true;
                use[2][0] = false;
                ImageView imgView = (ImageView) findViewById(R.id.money20);
                imgView.setVisibility(View.INVISIBLE);
            }
            if (use[0][1] == true) {
                counter--;
                deleteCounter++;
                deleted[0][1] = true;
                use[0][1] = false;
                ImageView imgView = (ImageView) findViewById(R.id.money01);
                imgView.setVisibility(View.INVISIBLE);
            }
            if (use[1][1] == true) {
                counter--;
                deleteCounter++;
                deleted[1][1] = true;
                use[1][1] = false;
                ImageView imgView = (ImageView) findViewById(R.id.money11);
                imgView.setVisibility(View.INVISIBLE);
            }
            if (use[2][1] == true) {
                counter--;
                deleteCounter++;
                deleted[2][1] = true;
                use[2][1] = false;
                ImageView imgView = (ImageView) findViewById(R.id.money21);
                imgView.setVisibility(View.INVISIBLE);
            }
            if (use[3][1] == true) {
                counter--;
                deleteCounter++;
                deleted[3][1] = true;
                use[3][1] = false;
                ImageView imgView = (ImageView) findViewById(R.id.money31);
                imgView.setVisibility(View.INVISIBLE);
            }
            if (use[0][2] == true) {
                counter--;
                deleteCounter++;
                deleted[0][2] = true;
                use[0][2] = false;
                ImageView imgView = (ImageView) findViewById(R.id.money02);
                imgView.setVisibility(View.INVISIBLE);
            }
            if (use[1][2] == true) {
                counter--;
                deleteCounter++;
                deleted[1][2] = true;
                use[1][2] = false;
                ImageView imgView = (ImageView) findViewById(R.id.money12);
                imgView.setVisibility(View.INVISIBLE);
            }
            if (use[2][2] == true) {
                counter--;
                deleteCounter++;
                deleted[2][2] = true;
                use[2][2] = false;
                ImageView imgView = (ImageView) findViewById(R.id.money22);
                imgView.setVisibility(View.INVISIBLE);
            }
            if (use[3][2] == true) {
                counter--;
                deleteCounter++;
                deleted[3][2] = true;
                use[3][2] = false;
                ImageView imgView = (ImageView) findViewById(R.id.money32);
                imgView.setVisibility(View.INVISIBLE);
            }
            if (use[4][2] == true) {
                counter--;
                deleteCounter++;
                deleted[4][2] = true;
                use[4][2] = false;
                ImageView imgView = (ImageView) findViewById(R.id.money42);
                imgView.setVisibility(View.INVISIBLE);
            }
            if (deleteCounter == 12 && firstPlayerTurn == true) {
                TextView textView = (TextView) findViewById(R.id.vinner);
                textView.setText("Игрок1 ПОБЕДИЛ!!!");
                textView.setVisibility(View.VISIBLE);
                TextView textView2 = (TextView) findViewById(R.id.playerTurn);
                textView2.setVisibility(View.INVISIBLE);
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Игра окончена!\nИгрок1 победил!!!", Toast.LENGTH_LONG);
                toast.show();
                finish=true;
            }
            else if(deleteCounter == 12 && firstPlayerTurn == false) {
                TextView textView = (TextView) findViewById(R.id.vinner);
                textView.setText("Игрок2 ПОБЕДИЛ!!!");
                textView.setVisibility(View.VISIBLE);
                TextView textView2 = (TextView) findViewById(R.id.playerTurn);
                textView2.setVisibility(View.INVISIBLE);
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Игра окончена!\nИгрок2 победил!!!", Toast.LENGTH_LONG);
                toast.show();
                finish=true;
            }
            else {
                if (firstPlayerTurn == false) {
                    firstPlayerTurn = true;
                    TextView textView = (TextView) findViewById(R.id.playerTurn);
                    textView.setText("Ход:\nИгрок1");
                } else if (firstPlayerTurn == true) {
                    firstPlayerTurn = false;
                    TextView textView = (TextView) findViewById(R.id.playerTurn);
                    textView.setText("Ход:\nИгрок2");
                }
            }
        }
    }
}
