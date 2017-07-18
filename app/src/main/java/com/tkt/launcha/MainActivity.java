package com.tkt.launcha;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.tomerrosenfeld.customanalogclockview.CustomAnalogClock;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private int previousState, currentState;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);




        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                Log.d("mk","onPageScrolled");
            }

            @Override
            public void onPageSelected(int position) {
                Log.d("mk","onPageSelected");

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d("mk","onPageScrollStateChanged");

                int currentPage = mViewPager.getCurrentItem();       //ViewPager Type

                Log.d("mk","onPageScrollStateChanged pager :"+currentPage);

                if (currentPage == 2 || currentPage == 0){
                    previousState = currentState;
                    currentState = state;
                    if (previousState == 1 && currentState == 0){

                        mViewPager.setCurrentItem(currentPage == 0 ? 3 : 0);

                    }

                }

            }
        });

        listOfApps();
    }

    private PackageManager manager;

    void listOfApps(){
        manager = getPackageManager();

        Intent i = new Intent(Intent.ACTION_MAIN, null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> availableActivities = manager.queryIntentActivities(i, 0);

        for(ResolveInfo ri:availableActivities){
//            AppDetail app = new AppDetail();
//            app.label = ri.loadLabel(manager);
//            app.name = ri.activityInfo.packageName;
//            app.icon = ri.activityInfo.loadIcon(manager);
//            apps.add(app);

            Log.d("mk","ri.loadLabel(manager) :"+ri.loadLabel(manager));
            Log.d("mk","ri.activityInfo.packageName :"+ri.activityInfo.packageName);
            Log.d("mk","ri.activityInfo.loadIcon(manager) :"+ri.activityInfo.loadIcon(manager));
            Log.d("mk","---");


        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }



    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {


            Log.d("mk","to num :"+getArguments().getInt(ARG_SECTION_NUMBER));

//            View rootView = null;


            View rootView1 = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView1.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));


            CustomAnalogClock customAnalogClock = (CustomAnalogClock) rootView1.findViewById(R.id.analog_clock);
            customAnalogClock.setAutoUpdate(true);

            return rootView1;

        }
    }

    public static class SecondFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_contactos, container, false);

            TextView textView = (TextView) v.findViewById(R.id.section_label2);
            textView.setText("ss9");

            return v;
        }

        public static SecondFragment newInstance(String text) {

            SecondFragment f = new SecondFragment();
            Bundle b = new Bundle();
            b.putString("msg", text);

            f.setArguments(b);

            return f;
        }
    }


    public static class ThirdFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_reminders, container, false);

            TextView textView = (TextView) v.findViewById(R.id.section_label3);
            textView.setText("TKT");

            return v;
        }

        public static ThirdFragment newInstance(String text) {

            ThirdFragment f = new ThirdFragment();
            Bundle b = new Bundle();
            b.putString("msg", text);

            f.setArguments(b);

            return f;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
//            return PlaceholderFragment.newInstance(position + 1);

            switch (position){
                case 0: return PlaceholderFragment.newInstance(position + 1);
                case 1: return SecondFragment.newInstance("SecondFragment, Instance 1");
                case 2: return ThirdFragment.newInstance("Third, Instance 1");

                default:return PlaceholderFragment.newInstance(position + 1);
            }


        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
