public class Member {
    private final String name;
    private Membership membership;

    public Member(String name) { this.name = name; }
    public String getName() { return name; }
    public Membership getMembership() { return membership; }
    void setMembership(Membership m) { this.membership = m; }
}
