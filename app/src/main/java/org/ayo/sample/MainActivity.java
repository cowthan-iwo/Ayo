package org.ayo.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.ayo.core.log.log;
import org.ayo.lang.Lang;
import org.greenrobot.eventbus.EventBus;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log.init(true, "hehe");
        log.i("hahah");
        if(Lang.isEmpty("")){
            EventBus.getDefault().register(this);
        }
    }
}
