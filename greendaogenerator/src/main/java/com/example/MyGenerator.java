package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Property;
import org.greenrobot.greendao.generator.Schema;

public class MyGenerator {
    public static void main(String[] args) {
        Schema schema = new Schema(1, "com.appsng.greendaoapp.db");
        schema.enableKeepSectionsByDefault();
        addTables(schema);

        try {
            new DaoGenerator().generateAll(schema, "./app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addTables(final Schema schema) {
        // Function
        Entity function = schema.addEntity("Function");
        function.addIdProperty().primaryKey();
        function.addIntProperty("id_function");
        function.addStringProperty("title_function");
        function.addStringProperty("row_version");

        // Lesson
        Entity lesson = schema.addEntity("Lesson");
        lesson.addIdProperty().primaryKey();
        lesson.addIntProperty("id_lesson");
        lesson.addStringProperty("number_lesson");
        lesson.addStringProperty("row_version");

        // Activity
        Entity activity = schema.addEntity("Activity");
        activity.addIdProperty().primaryKey();
        activity.addIntProperty("id_activity");
        activity.addStringProperty("number_activity");
        activity.addStringProperty("title_activity");
        activity.addStringProperty("note_activity");
        activity.addStringProperty("row_version");

        // ActivityType
        Entity activityType = schema.addEntity("ActivityType");
        activityType.addIdProperty().primaryKey();
        activityType.addIntProperty("id_activityType");
        activityType.addStringProperty("title_activityType");
        activityType.addStringProperty("row_version");

        // relation 1:N
        Property property1 = lesson.addLongProperty("id_function").notNull().getProperty();
        function.addToMany(lesson, property1).setName("all_lesson");

        // relation 1:N
        Property property2 = activity.addLongProperty("id_lesson").notNull().getProperty();
        lesson.addToMany(activity, property2).setName("all_activity");

        // relation 1:N
        Property property3 = activity.addLongProperty("id_activityType").notNull().getProperty();
        activityType.addToMany(activity, property3).setName("all_activity");
    }
}