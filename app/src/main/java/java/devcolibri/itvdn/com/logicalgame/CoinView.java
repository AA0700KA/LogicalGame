package java.devcolibri.itvdn.com.logicalgame;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class CoinView extends View{

    private float cordX;
    private float cordY;
    private float FirstX;
    private float FirstY;
    private float LastX;
    private float LastY;
    char[][] fields = new char[5][3];
    char[][] myFields = new char[5][7];
    private boolean stop = false;
    private Path path;
    private Paint p;
    public boolean help = false;

    public CoinView(Context context, AttributeSet attrs) {
        super(context, attrs);

        p = new Paint();
        p.setColor(Color.BLACK);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(2f);
        p.setAntiAlias(true);
        p.setTextSize(128f);

        path = new Path();
       // path.moveTo(cordX, cordY);
    }

    public float getCordX() {
        return cordX;
    }

    public void setCordX(float cordX) {
        this.cordX = cordX;
    }

    public float getCordY() {
        return cordY;
    }

    public void setCordY(float cordY) {
        this.cordY = cordY;
    }

    public boolean isStop() { return stop; }

    public void setStop(boolean stop) { this.stop = stop; }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(cordX != 0f && cordY != 0f && help == false) {
            path.moveTo(cordX, cordY);
            FirstX = cordX;
            FirstY = cordY;
            help = true;
        }
        else if(stop == true){
            LastX = cordX;
            LastY = cordY;
        }
        path.lineTo(cordX, cordY);
        canvas.drawPath(path, p);

    }

//    protected int[][] BotTurn(char fields[][]){
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 5; j++) {
//                myFields[j][i] = fields[j][i];
//            }
//        }
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 5; j++) {
//                if(fields[j][i] == '1' && fields[j+1][i] == '0' && (fields[j+2][i] == '1' || fields[j+3][i] == '1' || fields[j+4][i] == '1')){
//                    if(j == 2 && i == 2){
//                        myFields[6][4] = '1';
//                    }
//                    else{
//                        for (int k = j+1; k < 5; k++) {
//                            myFields[j][i+3] = fields[j][i];
//                        }
//                    }
//                }
//            }
//        }
//
//        return fields;
//    }
}
