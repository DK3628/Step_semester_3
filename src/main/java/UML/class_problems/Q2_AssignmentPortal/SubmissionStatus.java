public enum SubmissionStatus { SUBMITTED, GRADED;
    @Override public String toString() { return this == SUBMITTED ? "Submitted" : "Graded"; }
}
