package com.appsng.greendaoapp.db;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ACTIVITY".
*/
public class ActivityDao extends AbstractDao<Activity, Long> {

    public static final String TABLENAME = "ACTIVITY";

    /**
     * Properties of entity Activity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Id_activity = new Property(1, Integer.class, "id_activity", false, "ID_ACTIVITY");
        public final static Property Number_activity = new Property(2, String.class, "number_activity", false, "NUMBER_ACTIVITY");
        public final static Property Title_activity = new Property(3, String.class, "title_activity", false, "TITLE_ACTIVITY");
        public final static Property Note_activity = new Property(4, String.class, "note_activity", false, "NOTE_ACTIVITY");
        public final static Property Row_version = new Property(5, String.class, "row_version", false, "ROW_VERSION");
        public final static Property Id_lesson = new Property(6, long.class, "id_lesson", false, "ID_LESSON");
        public final static Property Id_activityType = new Property(7, long.class, "id_activityType", false, "ID_ACTIVITY_TYPE");
    }

    private Query<Activity> lesson_All_activityQuery;
    private Query<Activity> activityType_All_activityQuery;

    public ActivityDao(DaoConfig config) {
        super(config);
    }
    
    public ActivityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ACTIVITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"ID_ACTIVITY\" INTEGER," + // 1: id_activity
                "\"NUMBER_ACTIVITY\" TEXT," + // 2: number_activity
                "\"TITLE_ACTIVITY\" TEXT," + // 3: title_activity
                "\"NOTE_ACTIVITY\" TEXT," + // 4: note_activity
                "\"ROW_VERSION\" TEXT," + // 5: row_version
                "\"ID_LESSON\" INTEGER NOT NULL ," + // 6: id_lesson
                "\"ID_ACTIVITY_TYPE\" INTEGER NOT NULL );"); // 7: id_activityType
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ACTIVITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Activity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer id_activity = entity.getId_activity();
        if (id_activity != null) {
            stmt.bindLong(2, id_activity);
        }
 
        String number_activity = entity.getNumber_activity();
        if (number_activity != null) {
            stmt.bindString(3, number_activity);
        }
 
        String title_activity = entity.getTitle_activity();
        if (title_activity != null) {
            stmt.bindString(4, title_activity);
        }
 
        String note_activity = entity.getNote_activity();
        if (note_activity != null) {
            stmt.bindString(5, note_activity);
        }
 
        String row_version = entity.getRow_version();
        if (row_version != null) {
            stmt.bindString(6, row_version);
        }
        stmt.bindLong(7, entity.getId_lesson());
        stmt.bindLong(8, entity.getId_activityType());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Activity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer id_activity = entity.getId_activity();
        if (id_activity != null) {
            stmt.bindLong(2, id_activity);
        }
 
        String number_activity = entity.getNumber_activity();
        if (number_activity != null) {
            stmt.bindString(3, number_activity);
        }
 
        String title_activity = entity.getTitle_activity();
        if (title_activity != null) {
            stmt.bindString(4, title_activity);
        }
 
        String note_activity = entity.getNote_activity();
        if (note_activity != null) {
            stmt.bindString(5, note_activity);
        }
 
        String row_version = entity.getRow_version();
        if (row_version != null) {
            stmt.bindString(6, row_version);
        }
        stmt.bindLong(7, entity.getId_lesson());
        stmt.bindLong(8, entity.getId_activityType());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Activity readEntity(Cursor cursor, int offset) {
        Activity entity = new Activity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // id_activity
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // number_activity
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // title_activity
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // note_activity
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // row_version
            cursor.getLong(offset + 6), // id_lesson
            cursor.getLong(offset + 7) // id_activityType
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Activity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setId_activity(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setNumber_activity(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setTitle_activity(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setNote_activity(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setRow_version(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setId_lesson(cursor.getLong(offset + 6));
        entity.setId_activityType(cursor.getLong(offset + 7));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Activity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Activity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Activity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "all_activity" to-many relationship of Lesson. */
    public List<Activity> _queryLesson_All_activity(long id_lesson) {
        synchronized (this) {
            if (lesson_All_activityQuery == null) {
                QueryBuilder<Activity> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Id_lesson.eq(null));
                lesson_All_activityQuery = queryBuilder.build();
            }
        }
        Query<Activity> query = lesson_All_activityQuery.forCurrentThread();
        query.setParameter(0, id_lesson);
        return query.list();
    }

    /** Internal query to resolve the "all_activity" to-many relationship of ActivityType. */
    public List<Activity> _queryActivityType_All_activity(long id_activityType) {
        synchronized (this) {
            if (activityType_All_activityQuery == null) {
                QueryBuilder<Activity> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Id_activityType.eq(null));
                activityType_All_activityQuery = queryBuilder.build();
            }
        }
        Query<Activity> query = activityType_All_activityQuery.forCurrentThread();
        query.setParameter(0, id_activityType);
        return query.list();
    }

}