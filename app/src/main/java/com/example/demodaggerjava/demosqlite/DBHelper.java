package com.example.demodaggerjava.demosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.inject.Scope;
import javax.inject.Singleton;

@Singleton
public class DBHelper extends SQLiteOpenHelper {

    public static final String USER_TABLE_NAME = "hotgirls";
    public static final String USER_COLUMN_USER_ID = "id";
    public static final String USER_COLUMN_USER_NAME = "girl_name";
    public static final String USER_COLUMN_USER_AVATAR = "girl_avt";

    @Inject
    public DBHelper(@ApplicationContext Context context,
                    @DatabaseInfo String dbName,
                    @DatabaseInfo Integer version) {
        super(context, dbName, null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        tableCreateStatements(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + USER_TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    private void tableCreateStatements(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(
                    "CREATE TABLE IF NOT EXISTS "
                            + USER_TABLE_NAME + "("
                            + USER_COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                            + USER_COLUMN_USER_NAME + " VARCHAR(20), "
                            + USER_COLUMN_USER_AVATAR + " VARCHAR(50))"
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected Long insertUser(Hotgirl girl) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(USER_COLUMN_USER_NAME, girl.getName());
            contentValues.put(USER_COLUMN_USER_AVATAR, girl.getAvatar());
            return db.insert(USER_TABLE_NAME, null, contentValues);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    protected List<Hotgirl> getAllGirl() throws Resources.NotFoundException, NullPointerException {
        Cursor cursor = null;
        List<Hotgirl> listGirl = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            cursor = db.rawQuery("select * from " + USER_TABLE_NAME, null);

            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                do {
                    Hotgirl girl = new Hotgirl(cursor.getString(cursor.getColumnIndex(USER_COLUMN_USER_NAME)), cursor.getString(cursor.getColumnIndex(USER_COLUMN_USER_AVATAR)));
                    listGirl.add(girl);
                } while (cursor.moveToNext());
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            return listGirl;
        }
    }

    protected void clearDatabase() {
        getWritableDatabase().execSQL("delete from " + USER_TABLE_NAME);
    }

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ActivityContext {
    }

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ApplicationContext {
    }

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DatabaseInfo {
    }

    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PerActivity {
    }
}
