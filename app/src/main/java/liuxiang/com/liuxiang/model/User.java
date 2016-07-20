package liuxiang.com.liuxiang.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


/**
 * Created by deathsea on 2016/7/20.
 */
public class User {
    private String mail;
    private String pwd;
    private String name;
    private int gender;
    private String id;
    private String tel;
    private String targetTable = "user";
    private APPDBHelper APH;

    public User(Context c){APH = new APPDBHelper(c);}

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int validate(String mail,String pwd) {
        SQLiteDatabase db = APH.getReadableDatabase();
        String[] columns = new String[]{"pwd"};
        String whereClause = "mail=?";
        String[] whereArgs = new String[]{mail};
        Cursor queryCursor = db.query(targetTable,columns,whereClause,whereArgs,null,null,null);
        if (queryCursor.moveToFirst()){
            String pwdinSQL = queryCursor.getString(0);
            if(pwdinSQL.equals(pwd)){return 0;}
            return 2;
        }
        return 1;
    }

    public User query(String mail){
        SQLiteDatabase db = APH.getReadableDatabase();
        String[] columns = new String[]{"mail","pwd","name","gender","id","tel"};
        String whereClause = "mail=?";
        String[] whereArgs = new String[]{mail};
        Cursor queryCursor = db.query(targetTable,columns,whereClause,whereArgs,null,null,null);
        if (queryCursor.moveToFirst()){
            this.mail = mail;
            this.pwd = queryCursor.getString(1);
            this.name = queryCursor.getString(2);
            this.gender = queryCursor.getInt(3);
            this.id = queryCursor.getString(4);
            this.tel = queryCursor.getString(5);
            return this;
        }
        return null;
    }

    public int update(User A){
        ContentValues updateData = new ContentValues();
        String whereClause = "mail=?";
        String[] whereArgs = new String[]{A.mail};
        updateData.put("name",A.name);
        updateData.put("gender",A.gender);
        updateData.put("id",A.id);
        updateData.put("tel",A.tel);
        SQLiteDatabase db = APH.getWritableDatabase();
        int affectedRows = db.update(targetTable,updateData,whereClause,whereArgs);
        if (affectedRows == 1)return 0;
        return 1;
    }

    public int UpdatePwd(String mail,String newPwd){
        ContentValues updateData = new ContentValues();
        String whereClause = "mail=?";
        String[] whereArgs = new String[]{mail};
        updateData.put("pwd",newPwd);
        SQLiteDatabase db = APH.getWritableDatabase();
        int affectedRows = db.update(targetTable,updateData,whereClause,whereArgs);
        if (affectedRows == 1)return 0;
        return 1;
    }

    public void insertUser(User A)
    {
        String nullColumnHack = null;
        ContentValues insertContent = new ContentValues();
        insertContent.put("mail",A.mail);
        insertContent.put("pwd",A.pwd);
        insertContent.put("name",A.name);
        insertContent.put("gender",A.gender);
        insertContent.put("id",A.id);
        insertContent.put("tel",A.tel);
        SQLiteDatabase db = APH.getWritableDatabase();
        long insertResult = db.insert(targetTable,nullColumnHack,insertContent);


    }
}
