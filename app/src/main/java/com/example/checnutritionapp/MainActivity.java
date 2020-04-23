package com.example.checnutritionapp;

import android.net.sip.SipSession;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

<<<<<<< HEAD
import com.example.checnutritionapp.model.User;
=======
import com.example.checnutritionapp.ui.queue.QueueFragment;
>>>>>>> b3d4a0c6c08b97a29553eea8561bf413ebc5440a
import com.example.checnutritionapp.utility.JSONUtilities;
import com.example.checnutritionapp.utility.MealBank;
import com.example.checnutritionapp.utility.UserSet;
import com.example.checnutritionapp.utility.Week;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    private Week week;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_your_week, R.id.nav_user_profile, R.id.nav_favs,
                R.id.nav_order_history, R.id.nav_queue)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        // Import Meal data
        try {
            // Get meal data
            JSONObject mealsJSON = JSONUtilities.loadJSONFromAsset(getApplicationContext(), "meals.json");
            // Process meal JSON data
            MealBank meals = new MealBank(mealsJSON);
            // Get meal schedule
            // For now we're importing test data
            JSONObject scheduleJSON = JSONUtilities.loadJSONFromAsset(getApplicationContext(), "test_schedule.json");
            week = new Week(scheduleJSON, meals);
        } catch (JSONException e) {
            System.out.println("MEAL JSON FAILURE");
            e.printStackTrace();
            this.finish();
        }

        Log.d("Main Activity", week.toString());

        // Import Users data
        try {
            JSONObject usersJSON = JSONUtilities.loadJSONFromAsset(getApplicationContext(), "users.json");
            UserSet users = new UserSet(usersJSON);

            // Debug only
            User u = users.getUserById(2);
            System.out.println(u.getFullName());
        } catch (JSONException e) {
            System.out.println("USER JSON FAILURE");
            e.printStackTrace();
            this.finish();
        }

    }

    public Week getWeek() {
        return week;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
