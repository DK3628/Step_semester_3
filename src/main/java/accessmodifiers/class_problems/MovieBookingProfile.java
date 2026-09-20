public class MovieBookingProfile {
    private String name;
    private boolean confirmed;
    private String otp;

    public MovieBookingProfile() {
        // No-arg constructor required by JavaBean conventions
    }

    public MovieBookingProfile(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public static void main(String[] args) {
        MovieBookingProfile p = new MovieBookingProfile("Rahul Dev");
        System.out.println(p.getName());
        
        p.setConfirmed(true);
        System.out.println(p.isConfirmed());
        
        p.setOtp("4471"); // Write-only property, no way to retrieve it
    }
}