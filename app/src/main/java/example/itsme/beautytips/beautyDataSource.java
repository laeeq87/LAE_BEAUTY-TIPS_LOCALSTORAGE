package example.itsme.beautytips;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class beautyDataSource {
    public static final String LOGTAG = "EXPLORECA";

    SQLiteOpenHelper dbhelper;
    SQLiteDatabase database;

    public beautyDataSource(Context context) {

        dbhelper = new beautyOpenHelper(context);
        database = dbhelper.getWritableDatabase();

    }

    private static final String[] allColumns = {
            beautyOpenHelper.COL_ID,
            beautyOpenHelper.COL_TITLE,
            beautyOpenHelper.COL_TYPE,
            beautyOpenHelper.COL_DESC1,
            beautyOpenHelper.COL_DESC2,
            beautyOpenHelper.COL_DESC3,
            beautyOpenHelper.COL_IMAGE1,
            beautyOpenHelper.COL_IMAGE2,
            beautyOpenHelper.COL_IMAGE3};

    public void open() {

        database = dbhelper.getWritableDatabase();
        Log.i(LOGTAG, "Database Opened");

    }

    public void close() {
        dbhelper.close();
        Log.i(LOGTAG, "Database Close");

    }
//    public boolean createData(String image3,String image1, String title, String image2,String type,String desc1,String desc2,String desc3){
//        database = dbhelper.getWritableDatabase();
//        ContentValues values=new ContentValues();
//        values.put(beautyOpenHelper.COL_TITLE,title);
//        values.put(beautyOpenHelper.COL_TYPE,type);
//        values.put(beautyOpenHelper.COL_DESC1,desc1);
//        values.put(beautyOpenHelper.COL_DESC2,desc2);
//        values.put(beautyOpenHelper.COL_DESC3,desc3);
//        values.put(beautyOpenHelper.COL_IMAGE1,image1);
//        values.put(beautyOpenHelper.COL_IMAGE2,image2);
//        values.put(beautyOpenHelper.COL_IMAGE3,image3);
//        long result =database.insert(beautyOpenHelper.TABLE_NAME,null,values);
//
//        if (result== -1){
//
//            return false;
//        }
//        else {
//
//            return true;
//        }
//
//    }

    public Beauty create(Beauty beauty) {
        ContentValues values = new ContentValues();
        values.put(beautyOpenHelper.COL_TITLE, beauty.getTitle());
        values.put(beautyOpenHelper.COL_TYPE, beauty.getType());
        values.put(beautyOpenHelper.COL_DESC1, beauty.getDescription_first());
        values.put(beautyOpenHelper.COL_DESC2, beauty.getDescription_mid());
        values.put(beautyOpenHelper.COL_DESC3, beauty.getDescription_last());
        values.put(beautyOpenHelper.COL_IMAGE1, beauty.getImage_first());
        values.put(beautyOpenHelper.COL_IMAGE2, beauty.getImage_mid());
        values.put(beautyOpenHelper.COL_IMAGE3, beauty.getImage_last());
        long insertid = database.insert(beautyOpenHelper.TABLE_NAME, null, values);
        beauty.setId(insertid);
        return beauty;
    }


    //////////////////////////////////////////////////////////////////////////////////////

    public List<Beauty> findAll() {

        List<Beauty> beauty = new ArrayList<Beauty>();

        Cursor cursor = database.query(beautyOpenHelper.TABLE_NAME, allColumns, null, null, null, null, null);

        Log.i(LOGTAG, "Returned" + cursor.getCount() + "Rows");

        if (cursor.getCount()>0) {

            while (cursor.moveToNext()) {

                Beauty beautys = new Beauty();
                beautys.setId(cursor.getLong(cursor.getColumnIndex(beautyOpenHelper.COL_ID)));
                beautys.setTitle(cursor.getString(cursor.getColumnIndex(beautyOpenHelper.COL_TITLE)));
                beautys.setType(cursor.getString(cursor.getColumnIndex(beautyOpenHelper.COL_TYPE)));
                beautys.setDescription_first(cursor.getString(cursor.getColumnIndex(beautyOpenHelper.COL_DESC1)));
                beautys.setDescription_mid(cursor.getString(cursor.getColumnIndex(beautyOpenHelper.COL_DESC2)));
                beautys.setDescription_last(cursor.getString(cursor.getColumnIndex(beautyOpenHelper.COL_DESC3)));
                beautys.setImage_first(cursor.getString(cursor.getColumnIndex(beautyOpenHelper.COL_IMAGE1)));
                beautys.setImage_mid(cursor.getString(cursor.getColumnIndex(beautyOpenHelper.COL_IMAGE2)));
                beautys.setImage_last(cursor.getString(cursor.getColumnIndex(beautyOpenHelper.COL_IMAGE3)));
                beauty.add(beautys);

            }
        }
        return beauty;
    }


}
