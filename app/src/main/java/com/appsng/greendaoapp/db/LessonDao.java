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
 * DAO for table "LESSON".
*/
public class LessonDao extends AbstractDao<Lesson, Long> {

    public static final String TABLENAME = "LESSON";

    /**
     * Properties of entity Lesson.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Id_lesson = new Property(1, Integer.class, "id_lesson", false, "ID_LESSON");
        public final static Property Number_lesson = new Property(2, String.class, "number_lesson", false, "NUMBER_LESSON");
        public final static Property Row_version = new Property(3, String.class, "row_version", false, "ROW_VERSION");
        public final static Property Id_function = new Property(4, long.class, "id_function", false, "ID_FUNCTION");
    }

    private DaoSession daoSession;

    private Query<Lesson> function_All_lessonQuery;

    public LessonDao(DaoConfig config) {
        super(config);
    }
    
    public LessonDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"LESSON\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"ID_LESSON\" INTEGER," + // 1: id_lesson
                "\"NUMBER_LESSON\" TEXT," + // 2: number_lesson
                "\"ROW_VERSION\" TEXT," + // 3: row_version
                "\"ID_FUNCTION\" INTEGER NOT NULL );"); // 4: id_function
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LESSON\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Lesson entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer id_lesson = entity.getId_lesson();
        if (id_lesson != null) {
            stmt.bindLong(2, id_lesson);
        }
 
        String number_lesson = entity.getNumber_lesson();
        if (number_lesson != null) {
            stmt.bindString(3, number_lesson);
        }
 
        String row_version = entity.getRow_version();
        if (row_version != null) {
            stmt.bindString(4, row_version);
        }
        stmt.bindLong(5, entity.getId_function());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Lesson entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer id_lesson = entity.getId_lesson();
        if (id_lesson != null) {
            stmt.bindLong(2, id_lesson);
        }
 
        String number_lesson = entity.getNumber_lesson();
        if (number_lesson != null) {
            stmt.bindString(3, number_lesson);
        }
 
        String row_version = entity.getRow_version();
        if (row_version != null) {
            stmt.bindString(4, row_version);
        }
        stmt.bindLong(5, entity.getId_function());
    }

    @Override
    protected final void attachEntity(Lesson entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Lesson readEntity(Cursor cursor, int offset) {
        Lesson entity = new Lesson( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // id_lesson
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // number_lesson
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // row_version
            cursor.getLong(offset + 4) // id_function
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Lesson entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setId_lesson(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setNumber_lesson(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setRow_version(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setId_function(cursor.getLong(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Lesson entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Lesson entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Lesson entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "all_lesson" to-many relationship of Function. */
    public List<Lesson> _queryFunction_All_lesson(long id_function) {
        synchronized (this) {
            if (function_All_lessonQuery == null) {
                QueryBuilder<Lesson> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Id_function.eq(null));
                function_All_lessonQuery = queryBuilder.build();
            }
        }
        Query<Lesson> query = function_All_lessonQuery.forCurrentThread();
        query.setParameter(0, id_function);
        return query.list();
    }

}