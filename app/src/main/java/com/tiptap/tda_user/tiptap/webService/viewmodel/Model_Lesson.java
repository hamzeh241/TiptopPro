package com.tiptap.tda_user.tiptap.webService.viewmodel;


public class Model_Lesson {

    private String id_lesson;
    private String number_lesson;
    private String row_version;

    public Model_Lesson(){}

    public String getId_lesson() {
        return id_lesson;
    }

    public void setId_lesson(String id_lesson) {
        this.id_lesson = id_lesson;
    }

    public String getNumber_lesson() {
        return number_lesson;
    }

    public void setNumber_lesson(String number_lesson) {
        this.number_lesson = number_lesson;
    }

    public String getRow_version() {
        return row_version;
    }

    public void setRow_version(String row_version) {
        this.row_version = row_version;
    }
}
