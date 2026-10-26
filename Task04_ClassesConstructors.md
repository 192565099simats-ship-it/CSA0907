# Task 4 — Classes, Objects and Constructors

Example class responsibilities:
- `Vehicle`: registration number and common behaviour.
- `ParkingTicket`: ticket number, vehicle, location and entry time.
- `ParkingFacility`: owns slots and active tickets.

A default constructor is useful when an object can start with safe defaults. A parameterised constructor sets required fields at creation. Overloaded constructors accept different valid combinations. Constructor chaining with `this(...)` prevents duplicated initialization; `super(...)` initializes superclass state.

```java
class ParkingTicket {
    private final long ticketNo;
    private final String registrationNo;

    ParkingTicket(long ticketNo) {
        this(ticketNo, "UNKNOWN");
    }

    ParkingTicket(long ticketNo, String registrationNo) {
        this.ticketNo = ticketNo;
        this.registrationNo = registrationNo;
    }
}
```

A copy constructor is only needed if the design deliberately supports copying ticket data; a duplicate ticket must not accidentally reuse a unique ticket number. Local reference variables are commonly stored in stack frames, while objects and arrays are allocated on the heap. Multiple references can point to the same object.

## Alternative creation approaches
Setter-based construction can temporarily create an invalid object and needs validation on every setter. Constructors enforce required fields immediately. Static factory methods can give descriptive names and choose a subtype. Creating n objects takes O(n) total time and O(n) object storage in all approaches; the difference is validation/initialization work and maintainability, not asymptotic complexity.
