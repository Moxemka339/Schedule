package com.example.mark_5;

public class ScheduleItem {
    private String Object_Id;

    private String Time0;
    private String Time1;
    private String Item_Name;
    private String Teacher_Name;
    private String Item_Mode;
    private String Item_Auditorium;
    private String Item_Building;

    private String Teacher_Phone;
    private String Teacher_Mail;
    private String Favourite;

    private String Context_Table;

    private String Item_Notes;

    ScheduleItem(String _Object_ID, String _Time0, String _Time1, String _Item_Name,
                 String _Teacher_Name, String _Item_Mode, String _Item_Auditorium,
                 String _Item_Building, String _Teacher_Phone, String _Teacher_Mail,
                 String _Favourite, String _Context_Table, String _Item_Notes){

        Object_Id = _Object_ID;

        Time0 = _Time0;
        Time1 = _Time1;
        Item_Name = _Item_Name;
        Teacher_Name = _Teacher_Name;
        Item_Mode = _Item_Mode;
        Item_Auditorium = _Item_Auditorium;
        Item_Building = _Item_Building;

        Teacher_Phone = _Teacher_Phone;
        Teacher_Mail = _Teacher_Mail;
        Favourite = _Favourite;

        Context_Table = _Context_Table;

        Item_Notes = _Item_Notes;
    }


    public String getObject_Id() {
        return Object_Id;
    }

    public String getItem_Name () {
        return Item_Name;
    }
    public String getTime0 () {
        return Time0;
    }
    public String getItem_Mode () {
        return Item_Mode;
    }
    public String getTime1 () {
        return Time1;
    }
    public String getTeacher_Name () {
        return Teacher_Name;
    }
    public String getItem_Auditorium () {
        return Item_Auditorium;
    }
    public String getItem_Building () {
        return Item_Building;
    }
    public String getTeacher_Phone () {
        return Teacher_Phone;
    }
    public String getTeacher_Mail () {
        return Teacher_Mail;
    }
    public String getFavourite () {
        return Favourite;
    }
    public String getItem_Notes() {
        return Item_Notes;
    }
}
