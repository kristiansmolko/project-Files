package students;

public class Contact {
    private String mobil;
    private String email;
    private String skype;

    public Contact(){
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }


    public void print(){
        if (skype != null)
            System.out.println("Skype: " + "\033[35m" + skype + "\033[0m");
        if (email != null)
            System.out.println("Email: " + "\033[34m" + email + "\033[0m");
        if (mobil != null)
            System.out.println("Mobil: " + "\033[33m" + mobil + "\033[0m");
    }
}
