public enum OrderStatus {
    PENDING("Pending"), PAID("Paid");
    private final String label;
    OrderStatus(String label) { this.label = label; }
    @Override public String toString() { return label; }
}
