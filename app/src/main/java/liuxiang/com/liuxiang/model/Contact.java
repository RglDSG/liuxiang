package liuxiang.com.liuxiang.model;

/**
 * Created by deathsea on 2016/7/20.
 */
public class Contact {
    private String mail;
    private String Cname;
    private String CCID;
    private String CPhone;
    private String Cstats;
    private int Cid;

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

    public String getCstats() {
        return Cstats;
    }

    public void setCstats(String cstats) {
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
}
