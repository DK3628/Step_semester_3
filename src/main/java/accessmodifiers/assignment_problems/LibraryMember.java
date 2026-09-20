// Problem 4 JavaBean Implementation
public class LibraryMember {
    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswerHash;

    public LibraryMember() {
        // No-arg constructor required by JavaBean standard
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String membershipId) {
        if (this.membershipId == null) {
            this.membershipId = membershipId;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premiumMember) {
        this.premiumMember = premiumMember;
    }

    public void setSecurityAnswer(String answer) {
        if (answer != null) {
            // Store a one-way transformed value (hash) instead of plain text
            this.securityAnswerHash = Integer.toHexString(answer.hashCode());
        }
    }
    
    // Deliberately no getter for securityAnswer

    public static void main(String[] args) {
        LibraryMember m = new LibraryMember();
        m.setMembershipId("LIB-8841");
        m.setName("Priya Nair");
        m.setPremiumMember(true);
        System.out.println(m.getMembershipId());

        m.setMembershipId("FAKE-0000"); // Should be ignored
        System.out.println(m.getMembershipId());
        System.out.println(m.isPremiumMember());

        m.setSecurityAnswer("BlueMountain"); // Write-only
    }
}