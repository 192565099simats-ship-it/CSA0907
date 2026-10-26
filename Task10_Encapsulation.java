package parking.model;

public class Task10_Encapsulation {
    private int slotNumber;
    private Integer durationMinutes;

    public int getSlotNumber() { return slotNumber; }
    public void setSlotNumber(int slotNumber) {
        if (slotNumber < 0) throw new IllegalArgumentException("Slot must be non-negative");
        this.slotNumber = slotNumber;
    }
    public Integer getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(Integer durationMinutes) {
        if (durationMinutes == null || durationMinutes < 0)
            throw new IllegalArgumentException("Duration must be non-negative");
        this.durationMinutes = durationMinutes; // int to Integer autoboxing
    }

    public static void main(String[] args) {
        Task10_Encapsulation t = new Task10_Encapsulation();
        t.setSlotNumber(2);
        t.setDurationMinutes(90);
        System.out.println(t.getSlotNumber() + " " + t.getDurationMinutes());
        // Compare Integer values with equals(), not ==, for value equality.
    }
}
