package java.devcolibri.itvdn.com.logicalgame;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class RulesOrPlay2 extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.rules_or_play);
    }

    public void onClickPlay(View v){
        Intent intent = new Intent(this, Nim.class);
        startActivity(intent);
    }

    public void onClickRules(View v){
        Intent intent = new Intent(this, Rules.class);
        startActivity(intent);
    }
}
