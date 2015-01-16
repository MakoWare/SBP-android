package makowaredev.com.sbp.Activities;

import android.app.Activity;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.support.v4.widget.DrawerLayout;


import makowaredev.com.sbp.Frags.EventsFragment;
import makowaredev.com.sbp.Frags.HomeFragment;
import makowaredev.com.sbp.Frags.NavigationDrawerFragment;
import makowaredev.com.sbp.Frags.NewsFragment;
import makowaredev.com.sbp.Frags.WallsFragment;
import makowaredev.com.sbp.R;


public class Home_Activity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks,
        NewsFragment.NewsFragmentCallbacks, EventsFragment.EventFragmentCallbacks,
        HomeFragment.HomeFragmentCallbacks, WallsFragment.WallsFragmentCallbacks {

    private NavigationDrawerFragment mNavigationDrawerFragment;
    private CharSequence mTitle;
    private final String TAG = "Home_Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        onNavigationDrawerItemSelected(0);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        switch (position) {
            //Home Fragment
            case 0:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, HomeFragment.newInstance(position + 1))
                        .commit();
                break;
            //News Fragment
            case 1:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, NewsFragment.newInstance(position + 1))
                        .commit();
                break;
            //Events Fragment
            case 2:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, EventsFragment.newInstance(position + 1))
                        .commit();
                break;
            //Walls Fragment
            case 3:

                Intent intent = new Intent(this, Walls_Activity.class);
                startActivity(intent);
                /*
                fragmentManager.beginTransaction()
                        .replace(R.id.container, WallsFragment.newInstance(position + 1))
                        .commit();
                        */
                break;
        }

    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.home);
                break;
            case 2:
                mTitle = getString(R.string.news);
                break;
            case 3:
                mTitle = getString(R.string.events);
                break;
            case 4:
                mTitle = getString(R.string.walls);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.home_, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    //News Fragment Callbacks
    @Override
    public void onNewsItemSelected(Uri uri) {

    }

    //Events Fragment Callbacks
    @Override
    public void onEventSelected(Uri uri) {

    }

    //Home Fragment Callbacks
    @Override
    public void onHomeInteraction(Uri uri) {

    }

    //Wall Fragment Callbacks
    @Override
    public void onWallInteraction(Uri uri) {

    }
}
