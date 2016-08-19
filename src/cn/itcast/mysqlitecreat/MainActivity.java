package cn.itcast.mysqlitecreat;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

    private MyOpenHelper myOpenHelper;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myOpenHelper = new MyOpenHelper(getApplicationContext());
        
    }
    public void click1(View v){
    	SQLiteDatabase db = myOpenHelper.getWritableDatabase();
    	db.execSQL("insert into info(_id,name,phone) values(?,?,?)", new Object[]{2,"张三","1343454544"});	
    	db.close();
    	
    }
 public void click2(View v){
	 SQLiteDatabase db = myOpenHelper.getWritableDatabase();
 	db.execSQL("delete from info where name =? ",new Object[]{"张三"});	
 	db.close();
    	
    }
 public void click3(View v){
 	
	 SQLiteDatabase db = myOpenHelper.getWritableDatabase();
 	db.execSQL("update info set phone=? where name=?",new Object[]{"124455555","张三"});	
 	db.close();
 }
 public void click4(View v){
	 SQLiteDatabase db = myOpenHelper.getWritableDatabase();
	 Cursor cursor = db.rawQuery("select *from info", null);
	 if (cursor!=null&&cursor.getCount()>0) {//cursor里面有记录再去取
		 while (cursor.moveToNext()) {//cursor.movetonext的返回值是bool,所以这句话的意思是如果当前cursor有下一个值
			String name = cursor.getString(1);
			String phone = cursor.getString(2);
			System.out.println("name是"+name+"===="+phone);
			
		}
		
	}
 }

}
