/** Workflow layer; works with any MembershipPlan. */
public class MembershipDesk {

    public Membership buy(Member member, MembershipPlan plan) {
        Membership m = new Membership(member, plan);
        member.setMembership(m);
        System.out.printf("%s membership created for %s. Fee: ₹%,.2f. Status: %s.%n",
                plan.getName(), member.getName(), m.getFee(), m.getStatus());
        return m;
    }

    private Membership require(Member member) {
        if (member.getMembership() == null)
            throw new IllegalStateException(member.getName() + " has no membership.");
        return member.getMembership();
    }

    public void checkIn(Member member) {
        try {
            require(member).checkIn();
            System.out.println(member.getName() + " checked in successfully.");
        } catch (IllegalStateException e) { System.out.println(e.getMessage()); }
    }

    public void freeze(Member member) {
        try {
            Membership m = require(member);
            m.freeze();
            System.out.println(member.getName() + "'s membership frozen. Status: " + m.getStatus() + ".");
        } catch (IllegalStateException e) { System.out.println(e.getMessage()); }
    }

    public void unfreeze(Member member) {
        try {
            Membership m = require(member);
            m.unfreeze();
            System.out.println(member.getName() + "'s membership unfrozen. Status: " + m.getStatus() + ".");
        } catch (IllegalStateException e) { System.out.println(e.getMessage()); }
    }

    public void expire(Member member) {
        try {
            Membership m = require(member);
            m.expire();
            System.out.println(member.getName() + "'s membership expired. Status: " + m.getStatus() + ".");
        } catch (IllegalStateException e) { System.out.println(e.getMessage()); }
    }
}
