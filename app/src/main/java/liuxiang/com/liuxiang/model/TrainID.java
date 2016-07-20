package liuxiang.com.liuxiang.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deathsea on 2016/7/20.
 */
public class TrainID {
    private int id;
    private String trainNo;
    private String startStationName;
    private String endStationName;
    private String startTime;
    private String arriveTime;
    private String startDate;
    private int seats;
    private double price;
    private String targetTable = "trainid";
    private APPDBHelper APH;
    private Context CC;

    public TrainID(Context c){APH = new APPDBHelper(c);CC= c;}

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndStationName() {
        return endStationName;
    }

    public void setEndStationName(String endStationName) {
        this.endStationName = endStationName;
    }

    public String getStartStationName() {
        return startStationName;
    }

    public void setStartStationName(String startStationName) {
        this.startStationName = startStationName;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public List<TrainID> queryTrainID(String from,String to,String date){
        String[] columns = new String[]{"id","trainNo","startStationName","endStationName",
                "startTime","arriveTime","startDate","seats","price"};
        String selection = "startStationName=? and endStationName=? and startDate=?";
        String[] selectionArgs = new String[]{from,to,date};
        List<TrainID> result = new ArrayList<TrainID>();
        SQLiteDatabase db = APH.getReadableDatabase();
        Cursor queryCursor = db.query(targetTable,columns,selection,selectionArgs,null,null,null);
        while(queryCursor.moveToNext())
        {
            TrainID newTrainID = new TrainID(CC);
            newTrainID.id = queryCursor.getInt(0);
            newTrainID.trainNo = queryCursor.getString(1);
            newTrainID.startStationName = from;
            newTrainID.endStationName = to;
            newTrainID.startTime = queryCursor.getString(4);
            newTrainID.arriveTime = queryCursor.getString(5);
            newTrainID.startDate = date;
            newTrainID.seats = queryCursor.getInt(7);
            newTrainID.price = queryCursor.getDouble(8);
            result.add(newTrainID);
        }
        return result;
    }
}
