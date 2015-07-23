package ru.darvell.meetingclient;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initToolBar();
        initViewPager();
        initTabLayout(viewPager);
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
        toolbar.inflateMenu(R.menu.menu);
    }

    private void initViewPager(){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new DummyFragment(getResources().getColor(R.color.accent_material_light)), "CAT");
        adapter.addFrag(new DummyFragment(getResources().getColor(R.color.ripple_material_light)), "DOG");
        adapter.addFrag(new DummyFragment(getResources().getColor(R.color.button_material_dark)), "MOUSE");
        viewPager.setAdapter(adapter);
    }

    private void initTabLayout(ViewPager viewPager){
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//        tabLayout.addTab(tabLayout.newTab().setText("ALL"));
//        tabLayout.addTab(tabLayout.newTab().setText("MY"));
//        tabLayout.addTab(tabLayout.newTab().setText("FRIENDS"));
        tabLayout.setupWithViewPager(viewPager);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter{

        @Override
        public Fragment getItem(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return 0;
        }
    }
}
