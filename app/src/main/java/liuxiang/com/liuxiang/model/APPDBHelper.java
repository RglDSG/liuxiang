package liuxiang.com.liuxiang.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by deathsea on 2016/7/20.
 */
public final class APPDBHelper extends SQLiteOpenHelper{
    private static String SQL_CREATE_USER = "create table if not exists user(\n" +
            "mail vchar(100) primary key,\n" +
            "pwd vchar(1024),\n" +
            "name vchar(80),\n" +
            "gender int,\n" +
            "id char(18) ,\n" +
            "tel vchar(20)\n" +
            ");";
    private static String SQL_CREATE_CONTACTS = "create table if not exists contact(\n" +
            "mail vchar(100) references user(mail),\n" +
            "Cname vchar(80),\n" +
            "CCID vchar(18),\n" +
            "Cphone vchar(20),\n" +
            "Cstate int,\n" +
            "Cid integer primary key autoincrement\n" +
            ");";
    private static  String SQL_CREATE_TRAINID = "create table if not exists trainid(\n" +
            "id integer primary key autoincrement,\n" +
            "trainNo vchar(20),\n" +
            "startStationName vchar(50) ,\n" +
            "endStationName vchar(50),\n" +
            "startTime vchar(50),\n" +
            "arriveTime vchar(50),\n" +
            "startDate vchar(50),\n"+
            "seats integer,\n" +
            "price double \n" +
            ");";
    private static String SQL_CREATE_ORDER = "create table if not exists order1(\n" +
            "mail vchar(100) references user(mail),\n" +
            "orderNum vchar(80),\n" +
            "Contactid vchar(1000),\n" +
            "trainNo vchar(20) references trainid(trainNo),\n" +
            "orderPrice double,\n" +
            "orderState integer,\n" +
            "orderTime vchar(50)\n" +
            ");";
    private static String SQL_DELETE_USER = "drop table if exists user;";
    private static String SQL_DELETE_CONTACT = "drop table if exists contact;";
    private static String SQL_DELETE_TRAINID = "drop table if exists trainid;";
    private static String SQL_DELETE_ORDER = "drop table if exists order;";
    private final static String DATABASE_NAME = "liuxiang.db";
    private final static int DATABASE_VERSION = 1;

    public APPDBHelper(Context c){super(c,DATABASE_NAME,null,DATABASE_VERSION);}
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_USER);
        sqLiteDatabase.execSQL(SQL_CREATE_CONTACTS);
        sqLiteDatabase.execSQL(SQL_CREATE_TRAINID);
        sqLiteDatabase.execSQL(SQL_CREATE_ORDER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_USER);
        sqLiteDatabase.execSQL(SQL_DELETE_CONTACT);
        sqLiteDatabase.execSQL(SQL_DELETE_TRAINID);
        sqLiteDatabase.execSQL(SQL_DELETE_ORDER);
    }
}
