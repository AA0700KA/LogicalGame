package java.devcolibri.itvdn.com.logicalgame;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.app.Activity;

public class Rules extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.rules);
    }
}
