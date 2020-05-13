package java.devcolibri.itvdn.com.logicalgame;

import android.app.Activity;
import android.content.Intent;
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

public class JustNim extends Activity implements View.OnTouchListener {
    private boolean[] use0 = new boolean[3];
    private boolean[] use1 = new boolean[4];
    private boolean[] use2 = new boolean[5];
    private boolean[] delete0 = new boolean[3];
    private boolean[] delete1 = new boolean[4];
    private boolean[] delete2 = new boolean[5];
    private int counter = 0;
    private int deleteCounter = 0;
    private boolean firstPlayerTurn = true;
    private boolean firstUse = true;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.nim_game);

        relativeLayout = findViewById(R.id.relativeLayout);
        relativeLayout.setOnTouchListener(this);
    }

    public boolean onTouch(View view, MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        System.out.println("x = " + x + " y = " + y);
        if(counter == 0 && firstUse == false){
            firstUse = true;
        }
        if (y < 100 && y > 0 && event.getAction() == MotionEvent.ACTION_DOWN && x > 0 && x < 300) {
            if(!use0[2] && firstUse && !delete0[2]){
                ImageView imgView = (ImageView) findViewById(R.id.money20);
                imgView.setImageResource(R.drawable.cross);
                firstUse = false;
                use0[2] = true;
                counter++;
            }
            else if((!use0[1] && use0[0] && !delete0[1])){
                ImageView imgView = (ImageView) findViewById(R.id.money10);
                imgView.setImageResource(R.drawable.cross);
                use0[1] = true;
                counter++;
            }
            else if(!use0[0] && (use0[1]||(delete0[1] && firstUse)) && !delete0[0]){
                ImageView imgView = (ImageView) findViewById(R.id.money00);
                imgView.setImageResource(R.drawable.cross);
                use0[0] = true;
                counter++;
            }
        }
        else if (y < 200 && y > 100 && event.getAction() == MotionEvent.ACTION_DOWN && x > 0 && x < 400) {
            if(!use1[3] && firstUse && !delete1[3]){
                ImageView imgView = (ImageView) findViewById(R.id.money31);
                imgView.setImageResource(R.drawable.cross);
                firstUse = false;
                use1[3] = true;
                counter++;
            }
            else if(!use1[2] && (use1[3]||(delete1[0] && firstUse)) && !delete1[2]){
                ImageView imgView = (ImageView) findViewById(R.id.money21);
                imgView.setImageResource(R.drawable.cross);
                use1[2] = true;
                counter++;
            }
            else if(!use1[1] && (use1[2]||(delete1[1] && firstUse)) && !delete1[1]){
                ImageView imgView = (ImageView) findViewById(R.id.money11);
                imgView.setImageResource(R.drawable.cross);
                use1[1] = true;
                counter++;
            }
            else if(!use1[0] && (use1[1]||(delete1[2] && firstUse)) && !delete1[0]){
                ImageView imgView = (ImageView) findViewById(R.id.money01);
                imgView.setImageResource(R.drawable.cross);
                use1[0] = true;
                counter++;
            }
        }
        else if (y < 300 && y > 200 && event.getAction() == MotionEvent.ACTION_DOWN && x > 0 && x < 500) {
            if(!use2[4] && firstUse && !delete2[4]){
                ImageView imgView = (ImageView) findViewById(R.id.money42);
                imgView.setImageResource(R.drawable.cross);
                firstUse = false;
                use2[4] = true;
                counter++;
            }
            else if(!use2[3] && (use2[4]||(delete2[0] && firstUse)) && !delete2[3]){
                ImageView imgView = (ImageView) findViewById(R.id.money32);
                imgView.setImageResource(R.drawable.cross);
                use2[3] = true;
                counter++;
            }
            else if(!use2[2] && (use2[3]||(delete2[1] && firstUse)) && !delete2[2]){
                ImageView imgView = (ImageView) findViewById(R.id.money22);
                imgView.setImageResource(R.drawable.cross);
                use2[2] = true;
                counter++;
            }
            else if(!use2[1] && (use2[2]||(delete2[2] && firstUse)) && !delete2[1]){
                ImageView imgView = (ImageView) findViewById(R.id.money12);
                imgView.setImageResource(R.drawable.cross);
                use2[1] = true;
                counter++;
            }
            else if(!use2[0] && (use2[1]||(delete2[3] && firstUse)) && !delete2[0]){
                ImageView imgView = (ImageView) findViewById(R.id.money02);
                imgView.setImageResource(R.drawable.cross);
                use2[0] = true;
                counter++;
            }
        }
        return true;
    }
    public void onClickOK(View v){
        if(!use0[2]&&!use0[1]&&!use0[0]&&!use1[3]&&!use1[2]&&!use1[1]&&!use1[0]&&!use2[4]&&!use2[3]&&!use2[2]&&!use2[1]&&!use2[0]){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Ход невозможен!\nВы должны выбрать монету/монеты", Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            if (use0[0]) {
                counter--;
                deleteCounter++;
                delete0[0] = true;
                use0[0] = false;
                ImageView imgView = (ImageView) findViewById(R.id.money00);
                imgView.setVisibility(View.INVISIBLE);
            }
            if(use0[1]){
                counter--;
                deleteCounter++;
                delete0[1] = true;
                use0[1] = false;
                ImageView imgView = (ImageView) findViewById(R.id.money10);
                imgView.setVisibility(View.INVISIBLE);
            }
            if(use0[2]){
                counter--;
                deleteCounter++;
                delete0[2] = true;
                use0[2] = false;
                ImageView imgView = (ImageView) findViewById(R.id.money20);
                imgView.setVisibility(View.INVISIBLE);
            }
            if (use1[0]) {
                counter--;
                deleteCounter++;
                delete1[0] = true;
                use1[0] = false;
                ImageView imgView = (ImageView) findViewById(R.id.money01);
                imgView.setVisibility(View.INVISIBLE);
            }
            if (use1[1]) {
                counter--;
                deleteCounter++;
                delete1[1] = true;
                use1[1] = false;
                ImageView imgView = (ImageView) findViewById(R.id.money11);
                imgView.setVisibility(View.INVISIBLE);
            }
            if (use1[2]) {
                counter--;
                deleteCounter++;
                delete1[2] = true;
                use1[2] = false;
                ImageView imgView = (ImageView) findViewById(R.id.money21);
                imgView.setVisibility(View.INVISIBLE);
            }
            if (use1[3]) {
                counter--;
                deleteCounter++;
                delete1[3] = true;
                use1[3] = false;
                ImageView imgView = (ImageView) findViewById(R.id.money31);
                imgView.setVisibility(View.INVISIBLE);
            }
            if (use2[0]) {
                counter--;
                deleteCounter++;
                delete2[0] = true;
                use2[0] = false;
                ImageView imgView = (ImageView) findViewById(R.id.money02);
                imgView.setVisibility(View.INVISIBLE);
            }
            if (use2[1]) {
                counter--;
                deleteCounter++;
                delete2[1] = true;
                use2[1] = false;
                ImageView imgView = (ImageView) findViewById(R.id.money12);
                imgView.setVisibility(View.INVISIBLE);
            }
            if (use2[2]) {
                counter--;
                deleteCounter++;
                delete2[2] = true;
                use2[2] = false;
                ImageView imgView = (ImageView) findViewById(R.id.money22);
                imgView.setVisibility(View.INVISIBLE);
            }
            if (use2[3]) {
                counter--;
                deleteCounter++;
                delete2[3] = true;
                use2[3] = false;
                ImageView imgView = (ImageView) findViewById(R.id.money32);
                imgView.setVisibility(View.INVISIBLE);
            }
            if (use2[4]) {
                counter--;
                deleteCounter++;
                delete2[4] = true;
                use2[4] = false;
                ImageView imgView = (ImageView) findViewById(R.id.money42);
                imgView.setVisibility(View.INVISIBLE);
            }
            if (deleteCounter == 12 && firstPlayerTurn == false) {
                TextView textView = (TextView) findViewById(R.id.vinner);
                textView.setText("Игрок1 ПОБЕДИЛ!!!");
                textView.setVisibility(View.VISIBLE);
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Игра окончена!\nИгрок1 победил!!!", Toast.LENGTH_LONG);
                toast.show();
            }
            else if(deleteCounter == 12 && firstPlayerTurn == true) {
                TextView textView = (TextView) findViewById(R.id.vinner);
                textView.setText("Игрок2 ПОБЕДИЛ!!!");
                textView.setVisibility(View.VISIBLE);
                TextView textView2 = (TextView) findViewById(R.id.playerTurn);
                textView2.setVisibility(View.VISIBLE);
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Игра окончена!\nИгрок2 победил!!!", Toast.LENGTH_LONG);
                toast.show();
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
