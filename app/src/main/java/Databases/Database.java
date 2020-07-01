package Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import Model.Course;

public class Database extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static  final String DATABASE_NAME="attandence";
    private static final String TABLE_NAME="course_record";
    private static final String COURSE_CODE="course_code";
    private static final String COURSE_NAME="course_name";
    private static final String MARKS="marks_in_database";

    private static final String CREATE_QUERY = "create table " + TABLE_NAME +" ("+ COURSE_CODE +" String primary key,"+ COURSE_NAME + " varhcar(30));";

    public Database(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_QUERY);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + TABLE_NAME + " ");
        onCreate(sqLiteDatabase);

    }
    public long insert(Course course)
    {
        //SQLiteDatabase sd=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COURSE_CODE,course.getCourseCode());
        cv.put(COURSE_NAME,course.getCourseName());
        return getWritableDatabase().insert(TABLE_NAME,null,cv);
    }
    public List<Course> getAllCourseNameCode()
    {
        List<Course> list=new ArrayList<>();
        Cursor cr=getReadableDatabase().query(TABLE_NAME,null,null,null,null,null,null);
        while (cr.moveToNext()) {


            Course course=new Course();
            course.setCourseCode(cr.getString(0));
            course.setCourseName(cr.getString(1));


            list.add(course);


        }
        return list;
        }


}
