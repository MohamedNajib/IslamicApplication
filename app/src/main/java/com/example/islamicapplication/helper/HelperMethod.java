package com.example.islamicapplication.helper;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HelperMethod {

    /**
     * Helper Method
     * to Replace Fragments
     *
     * @param fragment
     * @param supportFragmentManager
     * @param id
     */
    public static void replaceFragments(Fragment fragment, FragmentManager supportFragmentManager, int id) {
        supportFragmentManager.beginTransaction()
                .replace(id, fragment)
                .commit();
    }

    /**
     * Helper Method to Show Toast Message
     *
     * @param context
     * @param message
     */
    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Helper Method
     * Intent to Start a new Activity
     *
     * @param context
     * @param cls
     */
    public static void intentTo(Context context, Class<?> cls) {
        Intent in = new Intent(context, cls);
        context.startActivity(in);
    }

    public static ArrayList<String> readFileFromAssets(Context context ,String fileName) {
        ArrayList<String> verses = new ArrayList<>();
        BufferedReader reader;

        try {
            final InputStream file = context.getAssets().open(fileName);
            reader = new BufferedReader(new InputStreamReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                verses.add(line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return verses;
    }
}
