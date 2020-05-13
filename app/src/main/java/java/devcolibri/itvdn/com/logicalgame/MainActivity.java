package java.devcolibri.itvdn.com.logicalgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, StartNim.class);
        startActivity(intent);
    }

    public void onClickNim(View v){
        Intent intent = new Intent(this, StartNim.class);
        startActivity(intent);
    }

    public void onClickXanoibashni(View v){
        Intent intent = new Intent(this, xanoibashni.class);
        startActivity(intent);
    }
}
