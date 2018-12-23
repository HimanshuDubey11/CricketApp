package project.himanshu.com.cricketapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyViewPagerAdapter extends FragmentPagerAdapter {

    private Context context;

    ArrayList<TypeAll> allMatches;

    public MyViewPagerAdapter(FragmentManager fm, Context context, ArrayList<TypeAll> allMatches) {
        super(fm);
        this.context = context;
        this.allMatches = allMatches;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new LiveMatchesFrag(allMatches);

            case 1:
                return  new ScheduleFrag(allMatches);
        }

        return null;

    }

    @Override
    public int getCount() {
        return 2;
    }


    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {

            case 0 :
                return context.getString(R.string.live);
            case 1:
                return context.getString(R.string.schedule);

        }

        return super.getPageTitle(position);
    }

}
