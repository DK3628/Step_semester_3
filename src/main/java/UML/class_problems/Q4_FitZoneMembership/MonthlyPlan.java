public class MonthlyPlan extends MembershipPlan {
    @Override public String getName() { return "Monthly"; }
    @Override public int getDurationMonths() { return 1; }
    @Override protected double getDiscountRate() { return 0.0; }
}
