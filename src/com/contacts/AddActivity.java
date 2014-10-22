package com.contacts;

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import static com.contacts.MySqliteHelper.*;


public class AddActivity extends Activity {
	Cursor cursor;
	private MySqliteHelper helper;
	private SQLiteDatabase db;
	ArrayList<Contact> contactList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ArrayList<Contact> contactList = createList();
        ListView lv = (ListView) findViewById(R.id.listView1);
        ArrayAdapter<Contact> arrayAdapter = new ArrayAdapter<Contact>(this, android.R.layout.simple_list_item_1, contactList);
        lv.setAdapter(arrayAdapter);
    }

    private ArrayList<Contact> createList() {
        
    	contactList = new ArrayList<Contact>();
        helper = new MySqliteHelper(this.getApplicationContext());
        db = helper.getReadableDatabase();
        String[] columns = new String [] {COLUMN_NAME, COLUMN_PHONE};
        contactList.clear();
        cursor = db.query(TABLE_CONTACTS, columns, null, null, null, null, null);
        if(!cursor.isAfterLast()) {
        	
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
            	
            	Contact p = new Contact();
				p.name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
				p.phone = cursor.getString(cursor.getColumnIndex(COLUMN_PHONE));
				contactList.add(p);
				cursor.moveToNext();            
				}
        }
        return contactList;
    }
}