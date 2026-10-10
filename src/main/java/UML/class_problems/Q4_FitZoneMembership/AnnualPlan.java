public class AnnualPlan extends MembershipPlan {
    @Override public String getName() { return "Annual"; }
    @Override public int getDurationMonths() { return 12; }
    @Override protected double getDiscountRate() { return 0.25; }
}
