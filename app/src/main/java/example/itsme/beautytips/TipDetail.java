package example.itsme.beautytips;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class TipDetail extends AppCompatActivity {

    String desc1,desc2,desc3,image1,image2,image3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_detail);


//////////////////////////////////////////////////////////////////////////////////////////////
        image1 = getIntent().getStringExtra("image1");

 byte[] imageAsBytes = Base64.decode(image1.getBytes(), Base64.DEFAULT);
        ImageView image1 = (ImageView)findViewById(R.id.image1);
        image1.setImageBitmap(
                BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length)
        );

////////////////////////////////////////////////////////////////////////////////////////

        desc1= getIntent().getStringExtra("desc1");
        TextView desc_first= (TextView) findViewById(R.id.tipDesc_1);
        desc_first.setText(desc1);
////////////////////////////////////////////////////////////////////////////////////////

//        image2 = getIntent().getStringExtra("image2");
//        byte[] image2AsBytes = Base64.decode(image2.getBytes(), Base64.DEFAULT);
//        ImageView image_mid = (ImageView)findViewById(R.id.image2);
//        image_mid.setImageBitmap(
//                BitmapFactory.decodeByteArray(image2AsBytes, 0, image2AsBytes.length)
//        );

///////////////////////////////////////////////////////////////////////////////////////////////////
        desc2 = getIntent().getStringExtra("desc2");
        TextView desc_mid= (TextView) findViewById(R.id.tipDesc_2);
        desc_mid.setText(desc2);
     ///////////////////////////////////////////////////////////////////////////////////
//
//        image3 = getIntent().getStringExtra("image3");
//        byte[] image3AsBytes = Base64.decode(image3.getBytes(), Base64.DEFAULT);
//        ImageView image_last= (ImageView)findViewById(R.id.image3);
//        image_last.setImageBitmap(
//                BitmapFactory.decodeByteArray(image3AsBytes, 0, image3AsBytes.length)
//        );
   ///////////////////////////////////////////////////////////////////////////////////////////////////
//        desc3 = getIntent().getStringExtra("desc3");
//        TextView desc_last= (TextView) findViewById(R.id.tipDesc_3);
//        desc_last.setText(desc3);

    }
}
