package com.example.td22;

public class User {
    private String FirstName;
    private String FamilyName;
    private String Email;
    private String Password;
    private String Gender;
    private String Admin;

    public User(String first_name, String family_name, String email, String password, String gender, String admin) {
        FirstName = first_name;
        FamilyName = family_name;
        Email = email;
        Password = password;
        Gender = gender;
        Admin = admin;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getFamilyName() {
        return FamilyName;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getGender() {
        return Gender;
    }

    public String getAdmin() { return Admin; }

    @Override
    public String toString() {
        return FirstName + FamilyName;
    }
}
