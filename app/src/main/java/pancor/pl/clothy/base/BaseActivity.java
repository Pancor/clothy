package pancor.pl.clothy.base;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import pancor.pl.clothy.R;

public class BaseActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener{

    private static final String TAG = BaseActivity.class.getSimpleName();

    @Nullable @BindView(R.id.toolbar)
        protected Toolbar toolbar;
    @Nullable @BindView(R.id.drawer_layout)
        protected DrawerLayout drawerLayout;

    private ActionBarDrawerToggle actionBarDrawerToggle = null;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        ButterKnife.bind(this);

        setupToolbar();
        setupDrawerLayout();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (actionBarDrawerToggle != null)
            actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return actionBarDrawerToggle.onOptionsItemSelected(item)
                || super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout != null && drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    private void setupToolbar(){
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        } else {
            Log.w(TAG, "Couldn't set toolbar");
        }
    }

    private void setupDrawerLayout(){
        if (drawerLayout != null){
            actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                    toolbar, R.string.drawer_open, R.string.drawer_closed){

                @Override
                public void onDrawerOpened(View drawerView) {
                    super.onDrawerOpened(drawerView);
                }

                @Override
                public void onDrawerClosed(View drawerView) {
                    super.onDrawerClosed(drawerView);
                }
            };
            drawerLayout.addDrawerListener(actionBarDrawerToggle);
            actionBarDrawerToggle.syncState();
        } else {
            Log.w(TAG, "Couldn't set drawer layout");
        }
    }
}
