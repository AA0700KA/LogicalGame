package java.devcolibri.itvdn.com.logicalgame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by sams9 on 13.01.2020.
 */

public class xanoibashni extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xanoibashni);
    }

    public void onClickUploadLastGame(View v) throws IOException {
        FileReader fileReader = new FileReader("/sdcard/android/data/com.logicalGames.xanoibashni.data");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String a = bufferedReader.readLine();
        int numOfRings = Integer.valueOf(a);
        for (int i = 0; i < numOfRings; i++){
            String b = bufferedReader.readLine();
            int numOfRingsInThis = Integer.valueOf(b);
            for (int j = 0; j < numOfRingsInThis; j++) {
                String c = bufferedReader.readLine();
                int thisRing = Integer.valueOf(c);
            }
        }
        bufferedReader.close();
    }
}
