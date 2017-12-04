package com.tiptap.tda_user.tiptap.webService.viewmodel;

public class FunctionViewModel {

    private String id_function;
    private String title_function;
    private String row_version;

    public FunctionViewModel(){}

    public String getId_function() {
        return id_function;
    }

    public void setId_function(String id_function) {
        this.id_function = id_function;
    }

    public String getTitle_function() {
        return title_function;
    }

    public void setTitle_function(String title_function) {
        this.title_function = title_function;
    }

    public String getRow_version() {
        return row_version;
    }

    public void setRow_version(String row_version) {
        this.row_version = row_version;
    }
}
