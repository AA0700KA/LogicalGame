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
import android.view.View;

public class NimBot extends Activity implements View.OnTouchListener {

    private int[] helpFields = new int[7];
    private int[] helpHelpFields = new int[7];
    private int[] binarFields = new int[7];
    private int[] helpBinarFields = new int[7];
    private int[][] doubleBinarFields = new int[7][3];
    private boolean[] problem = new boolean[3];
    private int[] numbers = new int[3];
    private boolean[][] use = new boolean[5][3];
    private boolean[][] useForBot = new boolean[5][3];
    private boolean[][] deleted = new boolean[5][3];
    private boolean firstUse = true;
    private int counter = 0;
    private int deleteCounter = 0;
    private boolean playerTurn = true;
    private boolean deleteAllFor = false;
    private int summ = 0;
    int help;
    private boolean[] crosses = new boolean[3];
    boolean done = false;
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
        use[4][0] = true;
        use[3][0] = true;
        use[4][1] = true;
        useForBot[4][0] = true;
        useForBot[3][0] = true;
        useForBot[4][1] = true;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                deleted[i][j] = false;
            }
        }
        deleted[4][0] = true;
        deleted[3][0] = true;
        deleted[4][1] = true;
        for (int i = 0; i < 3; i++) {
            problem[i] = false;
        }
    }

    private void draw(){
        if(use[0][0] == true) {
            ImageView imgView = (ImageView) findViewById(R.id.money00);
            imgView.setImageResource(R.drawable.black2);
        }
        if(use[1][0] == true) {
            ImageView imgView = (ImageView) findViewById(R.id.money10);
            imgView.setImageResource(R.drawable.black2);
        }
        if(use[2][0] == true) {
            ImageView imgView = (ImageView) findViewById(R.id.money20);
            imgView.setImageResource(R.drawable.black2);
        }
        if(use[0][1] == true) {
            ImageView imgView = (ImageView) findViewById(R.id.money01);
            imgView.setImageResource(R.drawable.black2);
        }
        if(use[1][1] == true) {
            ImageView imgView = (ImageView) findViewById(R.id.money11);
            imgView.setImageResource(R.drawable.black2);
        }
        if(use[2][1] == true) {
            ImageView imgView = (ImageView) findViewById(R.id.money21);
            imgView.setImageResource(R.drawable.black2);
        }
        if(use[3][1] == true) {
            ImageView imgView = (ImageView) findViewById(R.id.money31);
            imgView.setImageResource(R.drawable.black2);
        }
        if(use[0][2] == true) {
            ImageView imgView = (ImageView) findViewById(R.id.money02);
            imgView.setImageResource(R.drawable.black2);
        }
        if(use[1][2] == true) {
            ImageView imgView = (ImageView) findViewById(R.id.money12);
            imgView.setImageResource(R.drawable.black2);
        }
        if(use[2][2] == true) {
            ImageView imgView = (ImageView) findViewById(R.id.money22);
            imgView.setImageResource(R.drawable.black2);
        }
        if(use[3][2] == true) {
            ImageView imgView = (ImageView) findViewById(R.id.money32);
            imgView.setImageResource(R.drawable.black2);
        }
        if(use[4][2] == true) {
            ImageView imgView = (ImageView) findViewById(R.id.money42);
            imgView.setImageResource(R.drawable.black2);
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        if(counter == 0 && firstUse == false){
            firstUse = true;
        }
        if (y < 340 && y > 240 && event.getAction() == MotionEvent.ACTION_DOWN && playerTurn == true) {
            if (x < 200 && x > 100 && use[0][0] == false && deleted[0][0] == false){
                if ((firstUse == true&&deleted[1][0] == true&&deleted[2][0] == true)||use[1][0] == true) {
                    counter++;
                    ImageView imgView = (ImageView) findViewById(R.id.money00);
                    imgView.setImageResource(R.drawable.black2);
                    use[0][0] = true;
                    useForBot[0][0] = true;
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
                    useForBot[1][0] = true;
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
                    useForBot[2][0] = true;
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
                useForBot[0][0] = false;
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
                    useForBot[1][0] = false;
                }
            }
            else if (x < 420 && x > 320 && use[2][0] == true){
                counter--;
                ImageView imgView = (ImageView) findViewById(R.id.money20);
                imgView.setImageResource(R.drawable.money2);
                use[2][0] = false;
                useForBot[2][0] = false;
            }
        }
        else if (y < 450 && y > 350 && event.getAction() == MotionEvent.ACTION_DOWN && playerTurn == true) {
            if (x < 200 && x > 100 && use[0][1] == false && deleted[0][1] == false){
                if((firstUse == true&&deleted[1][1] == true&&deleted[2][1] == true&&deleted[3][1] == true)||use[1][1] == true) {
                    counter++;
                    ImageView imgView = (ImageView) findViewById(R.id.money01);
                    imgView.setImageResource(R.drawable.black2);
                    use[0][1] = true;
                    useForBot[0][1] = true;
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
                    useForBot[1][1] = true;
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
                    useForBot[2][1] = true;
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
                    useForBot[3][1] = true;
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
                useForBot[0][1] = false;
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
                    useForBot[1][1] = false;
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
                    useForBot[2][1] = false;
                }
            }
            else if (x < 530 && x > 430 && use[3][1] == true){
                counter--;
                ImageView imgView = (ImageView) findViewById(R.id.money31);
                imgView.setImageResource(R.drawable.money2);
                use[3][1] = false;
                useForBot[3][1] = false;
            }
        }
        else if (y < 560 && y > 460 && event.getAction() == MotionEvent.ACTION_DOWN && playerTurn == true) {
            if (x < 200 && x > 100 && use[0][2] == false && deleted[0][2] == false){
                if((firstUse == true&&deleted[1][2] == true&&deleted[2][2] == true&&deleted[3][2] == true&&deleted[4][2] == true)||use[1][2] == true) {
                    counter++;
                    ImageView imgView = (ImageView) findViewById(R.id.money02);
                    imgView.setImageResource(R.drawable.black2);
                    use[0][2] = true;
                    useForBot[0][2] = true;
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
                    useForBot[1][2] = true;
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
                    useForBot[2][2] = true;
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
                    useForBot[3][2] = true;
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
                    useForBot[4][2] = true;
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
                useForBot[0][2] = false;
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
                    useForBot[1][2] = false;
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
                    useForBot[2][2] = false;
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
                    useForBot[3][2] = false;
                }
            }
            else if (x < 640 && x > 540 && use[4][2] == true){
                counter--;
                ImageView imgView = (ImageView) findViewById(R.id.money42);
                imgView.setImageResource(R.drawable.money2);
                use[4][2] = false;
                useForBot[4][2] = false;
            }
        }

        return true;
    }

    public void onClickOK(View v){
        if(finish){
            Intent intent = new Intent(this, NimBot.class);
            startActivity(intent);
        }
        if(use[0][0] == false && use[1][0] == false && use[2][0] == false && use[0][1] == false && use[1][1] == false && use[2][1] == false && use[3][1] == false && use[0][2] == false && use[1][2] == false && use[2][2] == false && use[3][2] == false && use[4][2] == false&& playerTurn == true){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Ход невозможен!\nВы должны выбрать монету/монеты", Toast.LENGTH_SHORT);
            toast.show();
        }
        else if(use[0][0] == false && use[1][0] == false && use[2][0] == false && use[0][1] == false && use[1][1] == false && use[2][1] == false && use[3][1] == false && use[0][2] == false && use[1][2] == false && use[2][2] == false && use[3][2] == false && use[4][2] == false&& playerTurn == false){
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 7; j++) {
                    if (!useForBot[i][j%3]) {
                        use[i][j%3] = true;
                        useForBot[i][j%3] = true;
                        deleteAllFor = true;
                        break;
                    }
                }
                if (deleteAllFor) {
                    deleteAllFor = false;
                    break;
                }
            }
            draw();
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
            if (deleteCounter >= 12 && playerTurn == false) {
                TextView textView = (TextView) findViewById(R.id.vinner);
                textView.setText("Вы ПРОИГРАЛИ!!!");
                textView.setVisibility(View.VISIBLE);
                TextView textView2 = (TextView) findViewById(R.id.playerTurn);
                textView2.setVisibility(View.INVISIBLE);
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Игра окончена!\nВы ПРОИГРАЛИ!!!", Toast.LENGTH_LONG);
                toast.show();
                finish=true;
            }
            else if(deleteCounter >= 12 && playerTurn == true) {
                TextView textView = (TextView) findViewById(R.id.vinner);
                textView.setText("Вы ПОБЕДИЛИ!!!");
                textView.setVisibility(View.VISIBLE);
                TextView textView2 = (TextView) findViewById(R.id.playerTurn);
                textView2.setVisibility(View.INVISIBLE);
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Игра окончена!\nВы ПОБЕДИЛИ!!!", Toast.LENGTH_LONG);
                toast.show();
                finish=true;
            }
            else {
                if (playerTurn == false) {
                    TextView textView = (TextView) findViewById(R.id.playerTurn);
                    textView.setText("Ход:\nИгрок1");
                    playerTurn = true;
                } else if (playerTurn == true) {
                    playerTurn = false;
                    TextView textView = (TextView) findViewById(R.id.playerTurn);
                    textView.setText("Ход:\nКомпютер");
                    BotTurn();
                    summ = 0;
                    for (int i = 0; i < 7; i++) {
                        binarFields[i] = 0;
                        helpFields[i] = 0;
                        for (int j = 0; j < 3; j++) {
                            doubleBinarFields[i][j] = 0;
                        }
                    }
                    draw();
                    firstUse = true;
                }
            }
        }
    }

    protected void BotTurn(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if(deleted[i][j] == false){
                    helpFields[j]++;
                    System.out.println("helpFields["+j+"] = " + helpFields[j]);
                }
            }
        }
        for (int i = 0; i < 7; i++) {
            if (helpFields[i] == 0) {
                binarFields[i] = 0;
                doubleBinarFields[i][0] = 0;
                doubleBinarFields[i][1] = 0;
                doubleBinarFields[i][2] = 0;
            } else if (helpFields[i] == 1) {
                binarFields[i] = 1;
                doubleBinarFields[i][0] = 0;
                doubleBinarFields[i][1] = 0;
                doubleBinarFields[i][2] = 1;
            } else if (helpFields[i] == 2) {
                binarFields[i] = 10;
                doubleBinarFields[i][0] = 0;
                doubleBinarFields[i][1] = 1;
                doubleBinarFields[i][2] = 0;
            } else if (helpFields[i] == 3) {
                binarFields[i] = 11;
                doubleBinarFields[i][0] = 0;
                doubleBinarFields[i][1] = 1;
                doubleBinarFields[i][2] = 1;
            } else if (helpFields[i] == 4) {
                binarFields[i] = 100;
                doubleBinarFields[i][0] = 1;
                doubleBinarFields[i][1] = 0;
                doubleBinarFields[i][2] = 0;
            } else if (helpFields[i] == 5) {
                binarFields[i] = 101;
                doubleBinarFields[i][0] = 1;
                doubleBinarFields[i][1] = 0;
                doubleBinarFields[i][2] = 1;
            }
            summ += binarFields[i];
            System.out.println("binarFields["+(i)+"] = " + binarFields[i] + "; summ = "+summ);
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print("|"+doubleBinarFields[i][j]+"| ");
            }
            System.out.println();
        }
        System.out.println("-------------------");
        help = summ;
        for (int i = 0; i < 3; i++) {
            numbers[2 - i] = help % 10;
            help /= 10;
        }
        System.out.println("|"+numbers[0]+"| |"+numbers[1]+"| |"+numbers[2]+"|");
        done = false;
        if (numbers[0] == numbers[1] && numbers[1] == numbers[2] && numbers[0] == 0) {
            int help1 = 0;
            int help2 = 0;
            while(useForBot==use){
                useForBot[help1][help2] = true;
                help1++;
                if(help1 == help2+3){
                    help1=0;
                    help2++;
                }
            }
            done = true;
        }
        else{
            if(numbers[0]%2 == 1){
                crosses[0] = true;
            }
            if(numbers[1]%2 == 1){
                crosses[1] = true;
            }
            if(numbers[2]%2 == 1){
                crosses[2] = true;
            }
            if(crosses[0] == true){
                if(doubleBinarFields[2][0] == 1&&done == false){
                    doubleBinarFields[2][0] = 0;
                    System.out.println("doubleBinarFields[2][0] = 0");
                    if(crosses[2] == true) {
                        if (doubleBinarFields[2][2] == 0) {
                            doubleBinarFields[2][2] = 1;
                            System.out.println("doubleBinarFields[2][2] = 1");
                        } else {
                            doubleBinarFields[2][2] = 0;
                            System.out.println("doubleBinarFields[2][2] = 0");
                        }
                    }
                    if(crosses[1] == true) {
                        if (doubleBinarFields[2][1] == 0) {
                            doubleBinarFields[2][1] = 1;
                            System.out.println("doubleBinarFields[2][1] = 1");
                        } else {
                            doubleBinarFields[2][1] = 0;
                            System.out.println("doubleBinarFields[2][1] = 0");
                        }
                    }
                    done = true;
                }
                if(doubleBinarFields[1][0] == 1&&done == false){
                    System.out.println("doubleBinarFields[1][0] = 0");
                    doubleBinarFields[1][0] = 0;
                    if(crosses[2] == true) {
                        if (doubleBinarFields[1][2] == 0) {
                            doubleBinarFields[1][2] = 1;
                            System.out.println("doubleBinarFields[1][2] = 1");
                        } else {
                            doubleBinarFields[1][2] = 0;
                            System.out.println("doubleBinarFields[1][2] = 0");
                        }
                    }
                    if(crosses[1] == true) {
                        if (doubleBinarFields[1][1] == 0) {
                            doubleBinarFields[1][1] = 1;
                            System.out.println("doubleBinarFields[1][1] = 1");
                        } else {
                            doubleBinarFields[1][1] = 0;
                            System.out.println("doubleBinarFields[1][1] = 0");
                        }
                    }
                    done = true;
                }
            }
            else if(crosses[1] == true){
                if(doubleBinarFields[2][1] == 1&&done == false){
                    doubleBinarFields[2][1] = 0;
                    System.out.println("doubleBinarFields[2][1] = 0");
                    if(crosses[2] == true) {
                        if (doubleBinarFields[2][2] == 0) {
                            doubleBinarFields[2][2] = 1;
                            System.out.println("doubleBinarFields[2][2] = 1");
                        } else {
                            doubleBinarFields[2][2] = 0;
                            System.out.println("doubleBinarFields[2][2] = 0");
                        }
                    }
                    done = true;
                }
                if(doubleBinarFields[1][1] == 1&&done == false){
                    doubleBinarFields[1][1] = 0;
                    System.out.println("doubleBinarFields[1][1] = 0");
                    if(crosses[2] == true) {
                        if (doubleBinarFields[1][2] == 0) {
                            doubleBinarFields[1][2] = 1;
                            System.out.println("doubleBinarFields[1][2] = 1");
                        } else {
                            doubleBinarFields[1][2] = 0;
                            System.out.println("doubleBinarFields[1][2] = 0");
                        }
                    }
                    done = true;
                }
                if(doubleBinarFields[0][1] == 1&&done == false){
                    doubleBinarFields[0][1] = 0;
                    System.out.println("doubleBinarFields[0][1] = 0");
                    if(crosses[2] == true) {
                        if (doubleBinarFields[0][2] == 0) {
                            doubleBinarFields[0][2] = 1;
                            System.out.println("doubleBinarFields[0][2] = 1");
                        } else {
                            doubleBinarFields[0][2] = 0;
                            System.out.println("doubleBinarFields[0][2] = 0");
                        }
                    }
                    done = true;
                }
            }
            else if(crosses[2] == true){
                if(doubleBinarFields[2][2] == 1&&done == false){
                    doubleBinarFields[2][2] = 0;
                    System.out.println("doubleBinarFields[2][2] = 0");
                    done = true;
                }
                if(doubleBinarFields[1][2] == 1&&done == false){
                    doubleBinarFields[1][2] = 0;
                    System.out.println("doubleBinarFields[1][2] = 0");
                    done = true;
                }
                if(doubleBinarFields[0][2] == 1&&done == false){
                    doubleBinarFields[0][2] = 0;
                    System.out.println("doubleBinarFields[0][2] = 0");
                    done = true;
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    helpBinarFields[i] = 0;
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    helpBinarFields[i] += doubleBinarFields[i][j];
                    if(j < 2) {
                        helpBinarFields[i] *= 10;
                    }
                }
                if(helpBinarFields[i] == 0){
                    helpHelpFields[i] = 0;
                }
                if(helpBinarFields[i] == 1){
                    helpHelpFields[i] = 1;
                }
                if(helpBinarFields[i] == 10){
                    helpHelpFields[i] = 2;
                }
                if(helpBinarFields[i] == 11){
                    helpHelpFields[i] = 3;
                }
                if(helpBinarFields[i] == 100){
                    helpHelpFields[i] = 4;
                }
                if(helpBinarFields[i] == 101){
                    helpHelpFields[i] = 5;
                }
            }
            for (int i = 0; i < 3; i++) {
                System.out.println("binarFields["+i+"] = "+helpBinarFields[i]+"\nhelpFields["+i+"]-helpHelpFields["+i+"] = "+(helpFields[i]-helpHelpFields[i]));
            }
            for (int i = 0; i < 3; i++) {
                if(helpFields[i]-helpHelpFields[i] == 0){
                    helpFields[i] = 0;
                }
                if(helpFields[i]-helpHelpFields[i] == 1){
                    helpFields[i] = 1;
                    if(useForBot[1][i] == true&&useForBot[2][i] == true&&useForBot[3][i] == true&&useForBot[4][i] == true){
                        use[0][i] = true;
                        useForBot[0][i] = true;
                        break;
                    }
                    if(useForBot[2][i] == true&&useForBot[3][i] == true&&useForBot[4][i] == true){
                        use[1][i] = true;
                        useForBot[1][i] = true;
                        break;
                    }
                    if(useForBot[3][i] == true&&useForBot[4][i] == true){
                        use[2][i] = true;
                        useForBot[2][i] = true;
                        break;
                    }
                    if(useForBot[4][i] == true){
                        use[3][i] = true;
                        useForBot[3][i] = true;
                        break;
                    }
                    else {
                        use[4][i] = true;
                        useForBot[4][i] = true;
                    }
                }
                if(helpFields[i]-helpHelpFields[i] == 2){
                    helpFields[i] = 2;
                    if(useForBot[2][i] == true&&useForBot[3][i] == true&&useForBot[4][i] == true){
                        use[0][i] = true;
                        use[1][i] = true;
                        useForBot[0][i] = true;
                        useForBot[1][i] = true;
                        break;
                    }
                    if(useForBot[3][i] == true&&useForBot[4][i] == true){
                        use[1][i] = true;
                        use[2][i] = true;
                        useForBot[1][i] = true;
                        useForBot[2][i] = true;
                        break;
                    }
                    if(useForBot[4][i] == true){
                        use[2][i] = true;
                        use[3][i] = true;
                        useForBot[2][i] = true;
                        useForBot[3][i] = true;
                        break;
                    }
                    else {
                        use[3][i] = true;
                        use[4][i] = true;
                        useForBot[3][i] = true;
                        useForBot[4][i] = true;
                    }
                }
                if(helpFields[i]-helpHelpFields[i] == 3){
                    helpFields[i] = 3;
                    if(useForBot[3][i] == true&&useForBot[4][i] == true){
                        use[0][i] = true;
                        use[1][i] = true;
                        use[2][i] = true;
                        useForBot[0][i] = true;
                        useForBot[1][i] = true;
                        useForBot[2][i] = true;
                        break;
                    }
                    if(useForBot[4][i] == true){
                        use[1][i] = true;
                        use[2][i] = true;
                        use[3][i] = true;
                        useForBot[1][i] = true;
                        useForBot[2][i] = true;
                        useForBot[3][i] = true;
                        break;
                    }
                    else {
                        use[2][i] = true;
                        use[3][i] = true;
                        use[4][i] = true;
                        useForBot[2][i] = true;
                        useForBot[3][i] = true;
                        useForBot[4][i] = true;
                    }
                }
                if(helpFields[i]-helpHelpFields[i] == 4){
                    helpFields[i] = 4;
                    if(useForBot[4][i] == true){
                        use[0][i] = true;
                        use[1][i] = true;
                        use[2][i] = true;
                        use[3][i] = true;
                        useForBot[0][i] = true;
                        useForBot[1][i] = true;
                        useForBot[2][i] = true;
                        useForBot[3][i] = true;
                        break;
                    }
                    else {
                        use[1][i] = true;
                        use[2][i] = true;
                        use[3][i] = true;
                        use[4][i] = true;
                        useForBot[1][i] = true;
                        useForBot[2][i] = true;
                        useForBot[3][i] = true;
                        useForBot[4][i] = true;
                    }
                }
                if(helpFields[i]-helpHelpFields[i] == 5){
                    helpFields[i] = 5;
                    use[0][i] = true;
                    use[1][i] = true;
                    use[2][i] = true;
                    use[3][i] = true;
                    use[4][i] = true;
                    useForBot[0][i] = true;
                    useForBot[1][i] = true;
                    useForBot[2][i] = true;
                    useForBot[3][i] = true;
                    useForBot[4][i] = true;
                    break;
                }
            }
        }
    }
}
