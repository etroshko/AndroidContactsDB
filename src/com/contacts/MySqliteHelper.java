package com.contacts;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqliteHelper extends SQLiteOpenHelper {
	
	private static final String DB_NAME = "contacts.db";
	private static final int VERSION = 1;
	public static final String COLUMN_CONTACT_ID = "contactId";
	public static final String COLUMN_NAME = "contactName";
	public static final String COLUMN_PHONE = "contactPhone";
	public static final String TABLE_CONTACTS = "contacts";

	public MySqliteHelper(Context context) {
		super(context, DB_NAME, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table " + TABLE_CONTACTS + 
				   " (" + COLUMN_CONTACT_ID + " integer,"
				   		+ COLUMN_NAME + " text,"
				   		+ COLUMN_PHONE +"  text);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}
}
