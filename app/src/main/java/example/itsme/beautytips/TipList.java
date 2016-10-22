package example.itsme.beautytips;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class TipList extends AppCompatActivity {

    public static final String LOGTAG = "EXPLORECA";
//    public static final int REQUEST_CODE =20;
    beautyDataSource dataSource;
    String image1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_list);

        dataSource = new beautyDataSource(this);
        dataSource.open();
        final List<Beauty> beauty = dataSource.findAll();
        ArrayAdapter<Beauty> BeautyArrayAdapter = new BeautyArrayAdapter(this,0,beauty);
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(BeautyArrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Beauty b=beauty.get(i);
                DisplayData(b);



            }


        });


    }

    private void DisplayData(Beauty b) {
        Intent intent=new Intent(TipList.this,TipDetail.class);
        intent.putExtra("title",b.getTitle());
        intent.putExtra("type",b.getType());
        intent.putExtra("desc1",b.getDescription_first());
        intent.putExtra("desc2",b.getDescription_mid());
        intent.putExtra("desc3",b.getDescription_last());
        intent.putExtra("image1",b.getImage_first());
        intent.putExtra("image2",b.getImage_mid());
//        intent.putExtra("image3",b.getImage_last());
        startActivity(intent);



    }



    class BeautyArrayAdapter extends ArrayAdapter<Beauty> {

        Context context;
        List<Beauty> objects;


        public BeautyArrayAdapter(Context context, int resource, List<Beauty> objects) {
            super(context, resource, objects);

            this.context = context;
            this.objects = objects;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Beauty beauty = objects.get(position);

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.single_list_textview, null);

            TextView tv_title = (TextView) view.findViewById(R.id.tvTitle);
            tv_title.setText(beauty.getTitle());
            Log.i(LOGTAG,"this is title "+tv_title);

            TextView tv_type = (TextView) view.findViewById(R.id.tvType);
            tv_type.setText(beauty.getType());
            Log.i(LOGTAG,"this is type " + tv_type);

            image1 = beauty.getImage_first();
            Log.i(LOGTAG, "this is my first " + image1 + "Image");
            byte[] imageAsBytes = Base64.decode(image1.getBytes(), Base64.DEFAULT);
            ImageView image = (ImageView) view.findViewById(R.id.list_img);
            image.setImageBitmap(
                    BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length)
            );


//            image2 = beauty.getImage_mid();
//            Log.i(LOGTAG, "this is my middle " + image2 + "Image");
//            byte[] image2AsBytes = Base64.decode(image2.getBytes(), Base64.DEFAULT);
//            ImageView image = (ImageView) view.findViewById(R.id.list_img);
//            image.setImageBitmap(
//                    BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length)
//            );

            return view;
        }
    }
}

