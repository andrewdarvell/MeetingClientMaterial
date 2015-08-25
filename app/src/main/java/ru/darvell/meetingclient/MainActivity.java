package ru.darvell.meetingclient;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;

import ru.darvell.meetingclient.fragments.SchedulesFragment;


public class MainActivity extends AppCompatActivity {

    final static int SCHEDULES_FRGMT = 1;

    private Toolbar toolbar;

    FragmentTransaction fTras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolBar();
        changeFragment(SCHEDULES_FRGMT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initToolBar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });
    }

    private void changeFragment(int frgmntType){
        Class fragmentClass = null;
        Fragment fragment = null;
        switch (frgmntType){
            case SCHEDULES_FRGMT:fragmentClass = SchedulesFragment.class;
                break;
        }
        try{
            fragment = (Fragment) fragmentClass.newInstance();
        }catch (Exception e){
            Log.e("Main", e.toString());
        }

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frgmCont, fragment);
        ft.commit();
    }


}
