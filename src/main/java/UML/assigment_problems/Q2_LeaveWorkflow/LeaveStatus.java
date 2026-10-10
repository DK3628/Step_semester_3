public enum LeaveStatus {
    PENDING("Pending"), APPROVED("Approved"), REJECTED("Rejected");
    private final String label;
    LeaveStatus(String label) { this.label = label; }
    @Override public String toString() { return label; }
}
