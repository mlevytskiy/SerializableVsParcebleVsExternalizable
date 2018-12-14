package serializable.petproject.serializablevsparceblevsexternalizable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startTest();

    }

    public void startTest() {
//        startActivity(new Intent(getApplicationContext(), ExternalizableActivity.class));
//        startActivity(new Intent(getApplicationContext(), SerializableActivity.class));
        startActivity(new Intent(getApplicationContext(), ParcelActivity.class));
        finish();
    }
}
