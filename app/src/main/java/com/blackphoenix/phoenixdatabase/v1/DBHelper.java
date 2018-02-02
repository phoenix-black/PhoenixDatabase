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


    public static String CREATE_TABLE = "create table " + "dummy_table"
            + " ( " + "table_id" + " integer not null primary key, "
            + "dummy_id" + " integer, "
            + "dummy_name" + " text, "
            + "dummy_status" + " integer, "
            + "dummy_real" + " real );";

    public static String DROP_TABLE = "DROP TABLE IF EXISTS "+"dummy_table";



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
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
        SQLiteDatabase _dbW = this.getWritableDatabase();
        long  dbReturnValue = _dbW.insert(tableName,null,values);
        _dbW.close();
        return dbReturnValue;
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
        SQLiteDatabase _dbW = this.getWritableDatabase();
        long  dbReturnValue = _dbW.update(tableName,values,whereClause,new String[]{whereArgs});
        _dbW.close();
        return dbReturnValue;

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

        SQLiteDatabase _dbR = this.getReadableDatabase();

        if(columnList == null) {

            String selectQuery = "select * from " + tableName + " where " + whereClause + " = " + whereArgs;
            return  _dbR.rawQuery(selectQuery,null);

        } else {
            return  _dbR.query(tableName,columnList,whereClause,new String[]{whereArgs},null,null,null);
        }
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
        // HANDLE CLOSING OF DATABASE
        SQLiteDatabase _dbR = this.getReadableDatabase();
        return  _dbR.rawQuery("select * from "+tableName,null);
        /*_dbR.close();
        return cursor;*/
        // HANDLE CLOSING OF DATABASE
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
        SQLiteDatabase db = this.getWritableDatabase();

        String countQueryClause =  "select * from " + tableName;
        Cursor cursor = db.rawQuery(countQueryClause,null);
        if(cursor!= null) {
            int count = cursor.getCount();
            cursor.close();
            db.close();
            return count;
        }
        db.close();
        return 0;
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
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(tableName,"1",null);

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
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(tableName,whereClause,whereArgs);
    }

}
