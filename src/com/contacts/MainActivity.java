package com.contacts;

import static com.contacts.MySqliteHelper.COLUMN_NAME;
import static com.contacts.MySqliteHelper.COLUMN_PHONE;
import static com.contacts.MySqliteHelper.TABLE_CONTACTS;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText name;
	private EditText phone;
	private MySqliteHelper helper;
	private SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		helper = new MySqliteHelper(this);
		db = helper.getWritableDatabase();
		name = (EditText) findViewById(R.id.name);
		phone = (EditText) findViewById(R.id.phone);
	}

	public void addContact(View view) {
		
		ContentValues values = new ContentValues();
		values.put(COLUMN_NAME, name.getText().toString());
		values.put(COLUMN_PHONE, phone.getText().toString());
		db.insert(TABLE_CONTACTS, null, values);
		Toast.makeText(this, "Done!", Toast.LENGTH_SHORT).show();
	}

	public void nextActivity(View view) {
		
		Intent intent = new Intent(this, AddActivity.class);
		startActivity(intent);
	}
}