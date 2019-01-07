package com.example.dedsec.bharatglasshouse.Model;

public class User {
    private String Name;
    private String Password;
    private String Phone;
    private String IsStaff;

    public User() {
    }

    public User(String name,String password) {
           Name = name;
           Password = password;
           IsStaff = "false";
    }

    public String getIsStaff() {
        return IsStaff;
    }

    public void setIsStaff(String isStaff) {
        IsStaff = isStaff;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getName() {
    //        Toast.makeText(null, Name+" get", Toast.LENGTH_SHORT).show();
            return Name;
        }

        public String setName(String name) {
            Name = name;
    //        Toast.makeText(null, Name+" set", Toast.LENGTH_SHORT).show();
            return Name;
        }

        public String getPassword() {
            return Password;
        }

        public void setPassword(String password) {
            Password = password;
    //        Toast.makeText(null, Password+" set", Toast.LENGTH_SHORT).show();
        }
}
