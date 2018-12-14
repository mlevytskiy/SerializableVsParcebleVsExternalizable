package serializable.petproject.serializablevsparceblevsexternalizable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import java.util.Date;

/**
 * Created by max on 12/14/18.
 */

public class ParcelActivity extends Activity {
    public static final String PARCELABLE_ARRAY = "parcelable_array";

//    public ArrayList<MyExternalizbleClass> items;
	public MyParcelClass[] items;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Date time = new Date();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            //Serializable

//            items = (ArrayList<MyExternalizbleClass>) extras.getSerializable(PARCELABLE_ARRAY);

            //Parcelable
			Parcelable[] parcelableArray = extras.getParcelableArray(PARCELABLE_ARRAY);
			if (parcelableArray != null) {
				items = new MyParcelClass[parcelableArray.length];
			    for (int i = 0; i < parcelableArray.length; ++i) {
			    	items[i] = (MyParcelClass) parcelableArray[i];
			    }
			}
        }
        Date now = new Date();
        long delta = now.getTime() - time.getTime();

//        TextView res = (TextView) findViewById(R.id.resultTimer);
//        res.setText(String.format(getString(R.string.result_time, (now.getTime() - time.getTime()) * 1.0f / 1000)));

        if (App.attendCount == 0) {
            Log.w("MainActivity", "Summary parcerble time: " + App.allTime + " ms.");
            //clear
            App.allTime = -1;
            App.attendCount = App.ITEMS_COUNT;
            return;
        }

        if (App.attendCount > 0) {
            App.allTime = App.allTime + delta;
            App.attendCount = App.attendCount - 1;
            startTest();
        }


    }

    public void startTest() {
//        items = new ArrayList<>();
//        for (int i = 0; i < App.ITEMS_COUNT; i++) {
//            items.add(new MyExternalizbleClass());
//        }

		items = new MyParcelClass[App.ITEMS_COUNT];
		for (int i = 0; i < App.ITEMS_COUNT; i++)
		{
			items[i] = new MyParcelClass();
		}

        Intent i = new Intent(getApplicationContext(), ParcelActivity.class);
        i.putExtra(PARCELABLE_ARRAY, items);
        startActivity(i);
        finish();
    }

}
