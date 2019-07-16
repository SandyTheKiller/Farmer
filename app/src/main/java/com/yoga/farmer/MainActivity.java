package com.yoga.farmer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.yoga.farmer.Fragment.MyField;
import com.yoga.farmer.Fragment.MyFieldPractice;
import com.yoga.farmer.adapter.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private DrawerLayout drawer;
    private FloatingActionButton fab;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private RelativeLayout relative_main;
    private ImageView img_page_start;
    long back_pressed=0;
    Toast toast;
    Intent intent;
    private static boolean isShowPageStart = true;
    private final int MESSAGE_SHOW_DRAWER_LAYOUT = 0x001;
    private final int MESSAGE_SHOW_START_PAGE = 0x002;

   /* public Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MESSAGE_SHOW_DRAWER_LAYOUT:
                    drawer.openDrawer(GravityCompat.START);
                    SharedPreferences sharedPreferences = getSharedPreferences("app", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isFirst", false);
                    editor.apply();
                    break;

                case MESSAGE_SHOW_START_PAGE:
                    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                    alphaAnimation.setDuration(300);
                    alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            relative_main.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    relative_main.startAnimation(alphaAnimation);
                    break;
            }
        }
    };
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initViewPager();
        // init the preferences data of Settings
       /* try {
            PreferenceManager.setDefaultValues(this, R.xml.preferences_settings, false);
        } catch (Exception e) {
        }*/
    /*   SharedPreferences sharedPreferences = getSharedPreferences("app", MODE_PRIVATE);
        if (isShowPageStart) {
            relative_main.setVisibility(View.VISIBLE);
            Glide.with(MainActivity.this).load(R.drawable.ic_launcher_big).into(img_page_start);
            if (sharedPreferences.getBoolean("isFirst", true)) {
                mHandler.sendEmptyMessageDelayed(MESSAGE_SHOW_START_PAGE, 2000);
            } else {
                mHandler.sendEmptyMessageDelayed(MESSAGE_SHOW_START_PAGE, 1000);
            }
            isShowPageStart = false;
        }
        if (sharedPreferences.getBoolean("isFirst", true)) {
            mHandler.sendEmptyMessageDelayed(MESSAGE_SHOW_DRAWER_LAYOUT, 2500);
        }*/
    }
    private void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
        View headerView = navigationView.getHeaderView(0);
        LinearLayout nav_header = headerView.findViewById(R.id.nav_header);
        nav_header.setOnClickListener(this);
        fab = findViewById(R.id.fab_main);
        fab.setOnClickListener(this);
        relative_main = findViewById(R.id.relative_main);
        img_page_start = findViewById(R.id.img_page_start);
    }
    private void initViewPager() {
        mTabLayout = findViewById(R.id.tab_layout_main);
        mViewPager = findViewById(R.id.view_pager_main);
        List<String> titles = new ArrayList<>();
        titles.add(getString(R.string.tab_title_main_1));
        titles.add(getString(R.string.tab_title_main_2));
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(0)));
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(1)));
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new MyField());
        fragments.add(new MyFieldPractice());
        mViewPager.setOffscreenPageLimit(2);
        FragmentAdapter mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        mViewPager.setAdapter(mFragmentAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(mFragmentAdapter);
        mViewPager.addOnPageChangeListener(pageChangeListener);
    }
    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
        @Override
        public void onPageSelected(int position) {
            if (position == 2) {
                fab.show();
            } else {
                fab.hide();
            }
        }
        @Override
        public void onPageScrollStateChanged(int state) {
            }
    };
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nav_header:
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                break;

            case R.id.fab_main:
                Snackbar.make(view, getString(R.string.main_snack_bar), Snackbar.LENGTH_LONG)
                        .setAction(getString(R.string.main_snack_bar_action), new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        }).show();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_menu_main_1:
               /* Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);*/
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Intent intent = new Intent();

        switch (item.getItemId()) {
            case R.id.nav_recycler_and_swipe_refresh:
              /*  intent.setClass(this, RecyclerViewActivity.class);
                startActivity(intent);*/
                break;

            case R.id.nav_scrolling:
               /* intent.setClass(this, ScrollingActivity.class);
                startActivity(intent);*/
                break;

            case R.id.nav_full_screen:
              /*  intent.setClass(this, FullscreenActivity.class);
                startActivity(intent);*/
                break;

            case R.id.nav_bottom_navigation:
              /*  intent.setClass(this, BottomNavigationActivity.class);
                startActivity(intent);*/
                break;

            case R.id.nav_settings:
                /*intent.setClass(this, SettingsActivity.class);
                startActivity(intent);*/
                break;

            case R.id.nav_about:
               /* intent.setClass(this, AboutActivity.class);
                startActivity(intent);*/
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    /*@Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }*/
    @Override
    public void onBackPressed() {

        if (back_pressed + 2000 > System.currentTimeMillis()) {
            // need to cancel the toast here
            toast.cancel();
            // code for exit
            intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            // ask user to press back button one more time to close app
            toast = Toast.makeText(getBaseContext(), "Press once again to exit!", Toast.LENGTH_SHORT);
            toast.show();
        }
        back_pressed = System.currentTimeMillis();
    }
    @Override
    protected void onDestroy() {
     //   mHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}
