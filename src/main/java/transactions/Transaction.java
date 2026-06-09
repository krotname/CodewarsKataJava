package transactions;

record Transaction(long id, long orderId, long amount, TransactionType type) implements Comparable<Transaction> {

    @Override
    public int compareTo(Transaction o) {
        return Long.compare(this.id, o.id());
    }
}
