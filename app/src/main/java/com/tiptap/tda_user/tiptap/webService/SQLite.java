package com.tiptap.tda_user.tiptap.webService;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite {

    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    // db
    private static final String DATABASE_NAME = "SQLiteDB";
    private static final int DATABASE_VERSION = 1;

    // tables
    private static final String FUNCTION_TABLE = "function";
    private static final String LESSON_TABLE = "lesson";
    private static final String ACTIVITY_TABLE = "activity";

    // function
    public static final String FUN_ID = "id";
    public static final String FUN_TITLE = "title";
    public static final String FUN_ROW = "row";

    private static final String FUNCTION_CREATE =
            "create table function (id text, title text, row text);";

    // lesson
    public static final String LES_ID = "id";
    public static final String LES_NUMBER = "number";
    public static final String LES_TITLE = "row";
    private static final String LESSON_CREATE =
            "create table lesson (id text, number text, row text);";

    // activity
    public static final String ACT_ID = "id";
    public static final String ACT_NUMBER = "number";
    public static final String ACT_TITLE = "title";
    public static final String ACT_NOTE = "note";
    public static final String ACT_ROW = "row";
    private static final String ACTIVITY_CREATE =
            "create table activity (id text, number text, title text, note text, row text);";

    public SQLite(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(FUNCTION_CREATE);
                db.execSQL(LESSON_CREATE);
                db.execSQL(ACTIVITY_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS function");
            db.execSQL("DROP TABLE IF EXISTS lesson");
            db.execSQL("DROP TABLE IF EXISTS activity");
            onCreate(db);
        }
    }

    public SQLite open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        DBHelper.close();
    }

    public String GetMaxRowV() {
        Cursor c = db.rawQuery("SELECT [RowVersion] FROM function ORDER BY RowVersion DESC LIMIT 1", null);
        int count = c.getCount();
        c.moveToFirst();
        String id = "0x0";
        for (int i = 0; i < count; i++) {
            id=c.getString(0);
        }
        return id;
    }

    public int GetMaxId_function() {
        Cursor c = db.rawQuery("SELECT [Id] FROM function ORDER BY id DESC LIMIT 1", null);
        int count = c.getCount();
        c.moveToFirst();
        int id=0;
        for (int i = 0; i < count; i++) {
            id=c.getInt(0);
        }
        return id;
    }

    public int function(String Q) {
        open();
        Cursor c = db.rawQuery(Q, null);
        int count = c.getCount();
        close();
        return count;
//        for (int i=0 ; i< id.length ; i++){
//            ContentValues initialValues = new ContentValues();
//            initialValues.put(FUN_ID, id[i]);
//            initialValues.put(FUN_TITLE, title[i]);
//            initialValues.put(FUN_ROW, row[i]);
//            Long insert = db.insert(FUNCTION_TABLE, null, initialValues);
//        }

        //return insert;
    }

    public long update_function(String id, String title, String row) {
        open();
        ContentValues initialValues = new ContentValues();
        initialValues.put(FUN_TITLE, title);
        initialValues.put(FUN_ROW, row);
        long update = db.update(FUNCTION_TABLE, initialValues, FUN_ID+"="+id,null);
        close();
        return update;
    }

    public Cursor getAllData_function() {
        return db.query(FUNCTION_TABLE, new String[] {FUN_ID, FUN_TITLE, FUN_ROW},
                null, null, null, null, null);
    }
}