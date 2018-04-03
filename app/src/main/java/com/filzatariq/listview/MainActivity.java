package com.filzatariq.listview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends Activity {

    ListView simpleList;

    /* Initialize Arraylist of Hashmap Type as globel member*/
    ArrayList<HashMap<String, String>> mArrayListMembers = new ArrayList<HashMap<String, String>>();

    /* Initialize String array for data*/
    String countryList[] = {"DHA TO SAMNABAD", "GAJJUMATTA TO ICHRA", "LIBERTY TO MODEL TOWN", "JOHERTOWN TO SAGGIYAN", "LUMS TO LCWU", "FEROZPUR ROAD TO MMALAM"};

    /* Initialize INTeger array for IMG*/
    int countryFlags[] = {R.mipmap.ic_launcher, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher, R.mipmap.ic_launcher_round};

    String date[] = {"25 FEB","20 JUNE","4 MARCH","8 FEB","4 APRIL","20 SEP"};

    String time[] = {"2:10 pm","2:00 am","4:00 pm","8:00 am","4:30 pm","2:00 pm"};

    String fare[] = {"250 RS","200 RS","400 RS","80 RS","40 RS","200 RS"};



    public static String KET_COUNTERY="COUNTRY_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleList = (ListView) findViewById(R.id.test);


        /* LOOP TO FILL HASHMAP AND ARRAYLIST(HASHMAP)*/
        for (int i = 0; i < countryList.length; i++) {

            HashMap<String, String> map = new HashMap<String, String>();
            map.put(KET_COUNTERY, countryList[i]);
            map.put("COUNTRY_FLAG", "" + countryFlags[i]);
            map.put("key_date", date[i]);
            map.put("key_time", time[i]);
            map.put("key_fare", fare[i]);

            //map.put("KEY", "VALUE");

            /* add hashmap to arraylist */
            mArrayListMembers.add(map);

        }

        /* ADDING UI on which content has to put */
        int[] to = {R.id.img_flag, R.id.src, R.id.date, R.id.time, R.id.fair};

        /* ADDING DATA FRom haSHMAP keys to put ON UI*/
        String[] from = new String[]{"COUNTRY_FLAG", "COUNTRY_NAME", "key_date", "key_time", "key_fare"};

        /* INITIALIZING ADAPTER which will need Context, ArrayLisy(which contain all data), UI(layout on which has to populate data), KEYS_ARRAY, UI_ARRAY */
        ListAdapter adapter = new SimpleAdapter(MainActivity.this, mArrayListMembers, R.layout.contact_items_listview, from, to);

        simpleList.setAdapter(adapter);

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent myintent = new Intent(view.getContext(),ride_details.class);
                    startActivityForResult(myintent,0);
                }
            }
        });

        /**simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            public void onItemClick(AdapterView<?> adapterView, View view, int position,
                                    long id) {
                for (int i = 0; i < simpleList.getChildCount(); i++) {
                    if(position == i ){
                        simpleList.getChildAt(i).setBackgroundColor(Color.BLUE);
                    }else{
                        simpleList.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                    }
                }
            }
        }); */

    }
}
