package liuxiang.com.liuxiang.model;

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
}
