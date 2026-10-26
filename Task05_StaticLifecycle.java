public class Task05_StaticLifecycle {
    static class ParkingTicket {
        private static long nextTicketNumber = 1000;
        private final long ticketNumber;
        private final String registrationNumber;

        ParkingTicket(String registrationNumber) {
            this.ticketNumber = ++nextTicketNumber;
            this.registrationNumber = registrationNumber;
        }

        public long getTicketNumber() { return ticketNumber; }
        public String getRegistrationNumber() { return registrationNumber; }
    }

    public static void main(String[] args) {
        ParkingTicket a = new ParkingTicket("TN01AB1111");
        ParkingTicket b = new ParkingTicket("TN02CD2222");
        System.out.println(a.getTicketNumber());
        System.out.println(b.getTicketNumber());
    }
}
