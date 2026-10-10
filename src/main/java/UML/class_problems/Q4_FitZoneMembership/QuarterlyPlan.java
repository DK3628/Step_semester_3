public class QuarterlyPlan extends MembershipPlan {
    @Override public String getName() { return "Quarterly"; }
    @Override public int getDurationMonths() { return 3; }
    @Override protected double getDiscountRate() { return 0.10; }
}
