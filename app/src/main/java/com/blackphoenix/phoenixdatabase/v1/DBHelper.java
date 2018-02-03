package com.blackphoenix.phoenixdatabase.v1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Praba on 12/24/2017.
 * Version 2.0
 */

public class DBHelper extends SQLiteOpenHelper {

    private static String DB_NAME = "esos";
    private static int DB_VERSION = 1;
    private static DBHelper dbHelper = null;


    public static String CREATE_TABLE = "CREATE TABLE " + "sample_table"
            + " ( " + "table_id" + " integer not null primary key, "
            + "dummy_id" + " integer, "
            + "dummy_name" + " text, "
            + "dummy_status" + " integer, "
            + "dummy_real" + " real );";

    public static String DROP_TABLE = "DROP TABLE IF EXISTS "+"sample_table";



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
        // Add your create table query here
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        // Add your  drop table query here
        onCreate(sqLiteDatabase);
    }

    /**
     *
     * @param context
     */

    private DBHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    /**
     *
     * @param context
     * @return
     */

    /*
        TODO: Handle the null values of arguments
     */

    public static synchronized DBHelper getDBInstance(Context context){
        if(dbHelper == null){
            dbHelper = new DBHelper(context);
        }
        return dbHelper;
    }


    /**
     *
     * @param tableName : Name of the table on which DB operation has to be performed
     * @param values
     * @return
     * @throws SQLiteException
     */

    /*
        TODO: Handle the null values of arguments
     */

    public long insert(String tableName, ContentValues values) throws SQLiteException {
        return DBOperation.insert(this,tableName,values);
    }

    /**
     *
     * @param tableName : Name of the table on which DB operation has to be performed
     * @param values
     * @param whereClause
     * @param whereArgs
     * @return
     */

    /*
        TODO: Handle the null values of arguments
     */
    public long update(String tableName, ContentValues values, String whereClause, String whereArgs) throws SQLiteException {
        return DBOperation.update(this,tableName,values,whereClause,whereArgs);
    }

    /**
     *
     * @param tableName : Name of the table on which DB operation has to be performed
     * @param columnList
     * @param whereClause
     * @param whereArgs
     * @return
     * @throws SQLiteException
     */

    /*
        TODO: Handle the null values of arguments
     */


    public Cursor read(String tableName, String[] columnList, String whereClause, String whereArgs) throws SQLiteException,IllegalStateException {
        return DBOperation.read(this,tableName,columnList,whereClause,whereArgs);
    }

    /**
     *
     * @param tableName : Name of the table on which DB operation has to be performed
     * @return
     * @throws SQLiteException
     */

    /*
        TODO: Handle the null values of arguments
     */

    public Cursor readAll(String tableName) throws SQLiteException {
        return DBOperation.readAll(this,tableName);
    }


    /**
     *
     * @param tableName : Name of the table on which DB operation has to be performed
     * @return
     * @throws SQLiteException
     */

    /*
        TODO: Handle the null values of arguments
     */

    public int count(String tableName) throws SQLiteException {
        return DBOperation.count(this,tableName);
    }

    /**
     *
     * @param tableName : Name of the table on which DB operation has to be performed
     * @return
     * @throws SQLiteException
     */

    /*
        TODO: Handle the null values of arguments
     */

    public int delete(String tableName) throws SQLiteException {
        return DBOperation.delete(this,tableName);
    }


    /**
     *
     * @param tableName : Name of the table on which DB operation has to be performed
     * @param whereClause
     * @param whereArgs
     * @return
     * @throws SQLiteException
     */

    /*
        TODO: Handle the null values of arguments
     */

    public int deleteSelected(String tableName, String whereClause, String[] whereArgs)throws SQLiteException {
        return DBOperation.deleteSelected(this,tableName,whereClause,whereArgs);
    }

}
