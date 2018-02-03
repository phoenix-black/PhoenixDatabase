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

public class DBOperation {


    public static String CreateTable(String primaryKey){
        return null;
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

    public static long insert(SQLiteOpenHelper helper, String tableName, ContentValues values) throws SQLiteException {
        SQLiteDatabase _dbW = helper.getWritableDatabase();
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
    public static long update(SQLiteOpenHelper helper, String tableName, ContentValues values, String whereClause, String whereArgs) throws SQLiteException {
        SQLiteDatabase _dbW = helper.getWritableDatabase();
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


    public static Cursor read(SQLiteOpenHelper helper, String tableName, String[] columnList, String whereClause, String whereArgs) throws SQLiteException,IllegalStateException {

        SQLiteDatabase _dbR = helper.getReadableDatabase();

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

    public static Cursor readAll(SQLiteOpenHelper helper, String tableName) throws SQLiteException {
        // HANDLE CLOSING OF DATABASE
        SQLiteDatabase _dbR = helper.getReadableDatabase();
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

    public static int count(SQLiteOpenHelper helper, String tableName) throws SQLiteException {
        SQLiteDatabase db = helper.getWritableDatabase();

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

    public static int delete(SQLiteOpenHelper helper, String tableName) throws SQLiteException {
        SQLiteDatabase db = helper.getWritableDatabase();
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

    public static int deleteSelected(SQLiteOpenHelper helper, String tableName, String whereClause, String[] whereArgs)throws SQLiteException {
        SQLiteDatabase db = helper.getWritableDatabase();
        return db.delete(tableName,whereClause,whereArgs);
    }

}
