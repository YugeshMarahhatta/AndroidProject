package com.example.pharmacy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
    DB.execSQL("create Table ProductDetails(id INTEGER primary key autoincrement, tradename TEXT,commonname TEXT,composition TEXT,batchno TEXT,quantity TEXT,costprice TEXT,sellingprice TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists ProductDetails");

    }
    public Boolean insertproductdetails(String tradename,String commonname,String composition,String batchno,String quantity,String costprice,String sellingprice)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tradename",tradename);
        contentValues.put("commonname",commonname);
        contentValues.put("composition",composition);
        contentValues.put("batchno",batchno);
        contentValues.put("quantity",quantity);
        contentValues.put("costprice",costprice);
        contentValues.put("sellingprice",sellingprice);

        long result = DB.insert("ProductDetails", null, contentValues);
        if(result==-1){
            return false;

        }
        else
        {
            return true;
        }
    }

    //for delete

    //viewing data in view
    public Cursor readalldata()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="select * from ProductDetails order by id desc";
        Cursor cursor=db.rawQuery(qry,null);
        return  cursor;
    }
}
