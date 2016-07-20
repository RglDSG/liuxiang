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
public class Order {
    private String mail;
    private String orderNum;
    private String Contactid;
    private String trainNo;
    private double orderPrice;
    private int orderState;
    private String orderTime;

    private String targetTable = "order1";
    private APPDBHelper APH;
    private Context CC;

    public Order(Context c){APH = new APPDBHelper(c);CC =c;}


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public String getContactid() {
        return Contactid;
    }

    public void setContactid(String contactid) {
        Contactid = contactid;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public int insertOrder(Order A){
        String nullColumnHack = null;
        ContentValues insertContent = new ContentValues();
        insertContent.put("mail",A.mail);
        insertContent.put("orderNum",A.orderNum);
        insertContent.put("Contactid",A.Contactid);
        insertContent.put("trainNo",A.trainNo);
        insertContent.put("orderPrice",A.orderPrice);
        insertContent.put("orderState",A.orderState);
        insertContent.put("orderTime",A.orderTime);
        SQLiteDatabase db = APH.getWritableDatabase();
        long insertResult = db.insert(targetTable,nullColumnHack,insertContent);
        if(insertResult == -1)return 1;
        return 0;
    }

    public int updateOrder(String orderNum,int orderState){
        ContentValues updateData = new ContentValues();
        String whereClause = "orderNum=?";
        String[] whereArgs = new String[]{orderNum};
        updateData.put("orderState",orderState);
        SQLiteDatabase db = APH.getWritableDatabase();
        int affectedRows = db.update(targetTable,updateData,whereClause,whereArgs);
        if (affectedRows == 1)return 0;
        return 1;
    }
    public List<Order> selectORder(String mail){
        String[] columns = new String[]{"orderNum","Contactid","trainNo","orderPrice",
                "orderState","orderTime"};
        String selection = "mail=?";
        String[] selectionArgs = new String[]{mail};
        SQLiteDatabase db = APH.getReadableDatabase();
        Cursor queryCursor = db.query(targetTable,columns,selection,selectionArgs,null,null,null);
        List<Order> result = new ArrayList<Order>();
        while (queryCursor.moveToNext()) {
            Order NewOrder = new Order(CC);
            NewOrder.mail = mail;
            NewOrder.orderNum = queryCursor.getString(0);
            NewOrder.Contactid = queryCursor.getString(1);
            NewOrder.trainNo = queryCursor.getString(2);
            NewOrder.orderPrice = queryCursor.getInt(3);
            NewOrder.orderState = queryCursor.getInt(4);
            NewOrder.orderTime = queryCursor.getString(5);
            result.add(NewOrder);
        }
        return result;

    }
}
