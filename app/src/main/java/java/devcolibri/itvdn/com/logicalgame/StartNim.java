package java.devcolibri.itvdn.com.logicalgame;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class StartNim extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.start_nim);
    }

    public void onClickNimGame2Players(View v){
        Intent intent = new Intent(this, RulesOrPlay2.class);
        startActivity(intent);
    }

    public void onClickNimGameBot(View v){
        Intent intent = new Intent(this, RulesOrPlay.class);
        startActivity(intent);
    }
}