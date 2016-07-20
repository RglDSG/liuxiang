package liuxiang.com.liuxiang.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deathsea on 2016/7/20.
 */
public class Contact {
    private String mail;
    private String Cname;
    private String CCID;
    private String CPhone;
    private int Cstats;
    private int Cid;
    private String targetTable = "contact";
    private APPDBHelper APH;
    private Context CC;

    public Contact(Context c){APH = new APPDBHelper(c);CC =c;}

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getCid() {
        return Cid;
    }

    public void setCid(int cid) {
        Cid = cid;
    }

    public int getCstats() {
        return Cstats;
    }

    public void setCstats(int cstats) {
        Cstats = cstats;
    }

    public String getCPhone() {
        return CPhone;
    }

    public void setCPhone(String CPhone) {
        this.CPhone = CPhone;
    }

    public String getCCID() {
        return CCID;
    }

    public void setCCID(String CCID) {
        this.CCID = CCID;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }


    public List<Contact> query(String mail){
        String[] columns = new String[]{"Cname","CCID","Cphone","Cstate","Cid"};
        String selection = "mail=?";
        String[] selectionArgs = new String[]{mail};
        SQLiteDatabase db = APH.getReadableDatabase();
        Cursor queryCursor = db.query(targetTable,columns,selection,selectionArgs,null,null,null);
        List<Contact> result = new ArrayList<Contact>();
        while (queryCursor.moveToNext()) {
            Contact NewContact = new Contact(CC);
            NewContact.mail = mail;
            NewContact.Cname = queryCursor.getString(0);
            NewContact.CCID = queryCursor.getString(1);
            NewContact.CPhone = queryCursor.getString(2);
            NewContact.Cstats = queryCursor.getInt(3);
            NewContact.Cid = queryCursor.getInt(4);
            result.add(NewContact);
        }
        return result;
    }

    public int insertContacts(Contact A){
        String nullColumnHack = null;
        ContentValues insertContent = new ContentValues();
        insertContent.put("mail",A.mail);
        insertContent.put("Cname",A.Cname);
        insertContent.put("CCID",A.CCID);
        insertContent.put("Cphone",A.CPhone);
        insertContent.put("CState",A.Cstats);
        insertContent.put("Cid",A.Cid);
        SQLiteDatabase db = APH.getWritableDatabase();
        long insertResult = db.insert(targetTable,nullColumnHack,insertContent);
        if(insertResult == -1)return 1;
        return 0;
    }

    public int updateContacts(Contact A){
        ContentValues updateData = new ContentValues();
        String whereClause = "mail=?";
        String[] whereArgs = new String[]{A.mail};
        updateData.put("Cname",A.Cname);
        updateData.put("CCID",A.CCID);
        updateData.put("Cphone",A.CPhone);
        updateData.put("CState",A.Cstats);
        updateData.put("Cid",A.Cid);
        SQLiteDatabase db = APH.getWritableDatabase();
        int affectedRows = db.update(targetTable,updateData,whereClause,whereArgs);
        if (affectedRows == 1)return 0;
        return 1;
    }

    public int deleteContacts(int Cid){
        String whereClause = "Cid=?";
        String[] whereArgs = new String[]{String.format("%d",Cid)};
        SQLiteDatabase db = APH.getWritableDatabase();
        int affectedRows = db.delete(targetTable,whereClause,whereArgs);
        if (affectedRows == 1)return 0;
        return 1;
    }


}
