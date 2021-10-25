package com.dgpays;


import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;


@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class CheckNetworkJob extends JobService {

    private static final String TAG = CheckNetworkJob.class.getSimpleName();


    @Override
    public boolean onStartJob(JobParameters params) {
        Log.e(TAG, "onStartJob");
        System.out.println(CheckInternetConnection(getApplicationContext()));

        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.d(TAG, "No Internet connection..");

        return true;
    }

    public static boolean CheckInternetConnection(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        if(isConnected) {
            System.out.println("Internet connected..");
        }
        return isConnected;
    }
}
