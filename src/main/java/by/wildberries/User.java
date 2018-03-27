package by.wildberries;

public class User {

    private final String email = "maria@lyashenko.by";
    private final String password = "Maria1992_";
    private final String wrongEmail = "maria@lyash12enko.by";
    private final String wrongPassword = "Maria19932_";
    private final String phoneNumber = "445595951";
    private final String wrongPhoneNumber = "435595951";
    private final String searchParameter = "dress";



    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    public String getWrongEmail() {
        return wrongEmail;
    }

    public String getWrongPassword() {
        return wrongPassword;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWrongPhoneNumber() {
        return wrongPhoneNumber;
    }

    public String getSearchParameter() {
        return searchParameter;
    }
}
