package com.example.seg2105_finalproject;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB_handler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_CLASSES = "classesDB.db";
    public static final String TABLE_CLASSES ="classes";
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_CLASSESNAME ="classesname";
    public static final String COLUMN_TIME ="time";


    public DB_handler(Context context){
        super(context, DATABASE_CLASSES, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " +
                TABLE_CLASSES + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_CLASSESNAME
                + " TEXT," + COLUMN_TIME + " INTEGER" + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLASSES);
        onCreate(db);
    }

    public void addClasses(Classes classes){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(COLUMN_CLASSESNAME, classes.getClassesName());
        values.put(COLUMN_TIME, classes.getTime());
        db.insert(TABLE_CLASSES, null, values);
        db.close();
    }

    public Classes findClasses(String classesname){
        SQLiteDatabase db= this.getReadableDatabase();
        String query= "SELECT * FROM "+ TABLE_CLASSES +" WHERE " +
                COLUMN_CLASSESNAME + "=\""+ classesname +"\"";
        Cursor cursor= db.rawQuery(query, null);
        Classes classes= new Classes();

        if(cursor.moveToFirst()){
            classes.setID(Integer.parseInt(cursor.getString(0)));
            classes.setClassesName(cursor.getString(1));
            classes.setTime(Double.parseDouble(cursor.getString(2)));
            cursor.close();
        }else{
            classes=null;
        }
        db.close();
        return classes;
    }

    public boolean deleteClasses(String classesname){
        boolean result=false;
        SQLiteDatabase db= this.getWritableDatabase();
        String query="SELECT * FROM "+ TABLE_CLASSES +" WHERE "+ COLUMN_CLASSESNAME +
                "= \""+ classesname +"\"";
        Cursor cursor= db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            String idStr=cursor.getString(0);
            db.delete(TABLE_CLASSES, COLUMN_ID+" = "+idStr,null);
            cursor.close();
            result=true;

        }
        db.close();
        return result;
    }
    public Cursor viewData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_CLASSES;
        Cursor cursor = db.rawQuery(query, null);

        return cursor;
    }

}