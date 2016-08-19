package cn.itcast.mysqlitecreat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyOpenHelper extends SQLiteOpenHelper {

	public MyOpenHelper(Context context) {
		super(context, "mysqlitecreat.db", null, 4);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
	
     db.execSQL("create table info(_id integer primary key autoincrement,name varchar(20))");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("alter table info add phone varchar(20)");

	}

}
