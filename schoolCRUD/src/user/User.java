package user;

import information.Gender;

public abstract class User {
    protected String id;
    protected String password;
    protected String name;
    protected int birthday;
    protected Gender gender;
    public String getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    public int getBirthday() {
        return birthday;
    }
    public Gender getGender() {
        return gender;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
