package example.itsme.beautytips;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

 beautyDataSource dataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataSource = new beautyDataSource(this);
        dataSource.open();

    }

    public void onClickNewEntry(View view) {


        Intent intent = new Intent(MainActivity.this, NewEntry.class);
        startActivity(intent);
    }


    public void onClickBeautyTips(View view) {
//        Button showTip= (Button) findViewById(R.id.beautyTips);
        Intent intent=new Intent(MainActivity.this,TipList.class);
        startActivity(intent);

    }
}
