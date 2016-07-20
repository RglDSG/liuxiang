package liuxiang.com.liuxiang;

import android.app.Application;
import android.database.sqlite.SQLiteOpenHelper;
import android.test.ApplicationTestCase;
import android.util.Log;

import java.util.List;

import liuxiang.com.liuxiang.model.APPDBHelper;
import liuxiang.com.liuxiang.model.Contact;
import liuxiang.com.liuxiang.model.User;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testDataCreate(){
        APPDBHelper APH = new APPDBHelper(getContext());
        APH.close();
        Log.i("Create user data test","success");
    }

    public void testInsertUser(){
        User U = new User(getContext());
        U.setMail("test");
        U.setPwd("123456");
        U.setName("sunqiang");
        U.setGender(1);
        U.setId("110001199002122232");
        U.setTel("1234567890");
        U.insertUser(U);
        Log.i("insert test","success");
    }

    public void testValidateUser(){
        User U = new User(getContext());
        int T = U.validate("deng","12456");
        Log.i("valid user",String.format("the result is : %d",T));
    }

    public User testQueryUser(){
        User res = new User(getContext());
        res = res.query("dong");
        Log.i("db query test",String.format("result:ID:%s,mail:%s,name:%s,pwd:%s,gender:%d,tel:%s",
                res.getId(),
                res.getMail(),
                res.getName(),
                res.getPwd(),
                res.getGender(),
                res.getTel()));
        return res;
    }

    public void testUpdateUser(){
        User TEST = new User(getContext()).query("ai");
        TEST.setName("艾米米");
        TEST.update(TEST);
        Log.i("updatedbtest","success");
    }

    public void testUpdateUserPwd(){
        User U = new User(getContext());
        U.UpdatePwd("ai","ai123456");
    }

    public void testContactQuery(){
        Contact C = new Contact(getContext());
        List<Contact> DongContact=  C.query("dong");
        String formatString = "query result :mail:%s" +
                "Cname:%s" +
                "CCID:%s" +
                "CPhone:%s" +
                "Cstats:%d" +
                "Cid:%d";
        for (Contact element:DongContact
             ) {

            Log.i("queryContact",String.format(formatString,
                    element.getMail(),
                    element.getCname(),
                    element.getCCID(),
                    element.getCPhone(),
                    element.getCstats(),
                    element.getCid()));
        }
    }
}