public enum MembershipStatus {
    ACTIVE("Active"), FROZEN("Frozen"), EXPIRED("Expired");
    private final String label;
    MembershipStatus(String label) { this.label = label; }
    @Override public String toString() { return label; }
}
