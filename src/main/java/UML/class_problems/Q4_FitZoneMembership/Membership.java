/** Owns and guards its own status. Status has no public setter. */
public class Membership {
    private final Member member;
    private final MembershipPlan plan;
    private final double fee;
    private MembershipStatus status = MembershipStatus.ACTIVE;

    Membership(Member member, MembershipPlan plan) {
        this.member = member;
        this.plan = plan;
        this.fee = plan.calculateFee();
    }

    public void checkIn() {
        if (status != MembershipStatus.ACTIVE)
            throw new IllegalStateException("Check-in denied: " + member.getName() + "'s membership is " + status + ".");
    }

    public void freeze() {
        if (status != MembershipStatus.ACTIVE)
            throw new IllegalStateException("Cannot freeze " + article(status) + " " + status + " membership.");
        status = MembershipStatus.FROZEN;
    }

    public void unfreeze() {
        if (status != MembershipStatus.FROZEN)
            throw new IllegalStateException("Cannot unfreeze " + article(status) + " " + status + " membership.");
        status = MembershipStatus.ACTIVE;
    }

    public void expire() {
        if (status == MembershipStatus.EXPIRED)
            throw new IllegalStateException("Membership is already Expired.");
        status = MembershipStatus.EXPIRED;
    }

    private static String article(MembershipStatus s) { return s == MembershipStatus.FROZEN ? "a" : "an"; }

    public Member getMember() { return member; }
    public MembershipPlan getPlan() { return plan; }
    public double getFee() { return fee; }
    public MembershipStatus getStatus() { return status; }
}
