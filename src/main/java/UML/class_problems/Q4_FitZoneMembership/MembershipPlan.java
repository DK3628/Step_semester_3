/** Fee rules live here, separate from status rules. Add new plans by subclassing. */
public abstract class MembershipPlan {
    public static final double BASE_RATE_PER_MONTH = 1000.0;

    public abstract String getName();
    public abstract int getDurationMonths();
    protected abstract double getDiscountRate();   // 0.10 = 10% off

    public double calculateFee() {
        return BASE_RATE_PER_MONTH * getDurationMonths() * (1.0 - getDiscountRate());
    }
}
