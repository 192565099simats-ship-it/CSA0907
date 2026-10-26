# Task 5 — Static Members and Object Life Cycle

The ticket counter belongs to the class because ticket numbers must be shared across ticket objects. A static method can report shared configuration or validate a class-level value. A static block is appropriate for one-time class initialization, not for normal per-ticket work.

When a vehicle exits, the active-ticket collection should remove the ticket and the slot should be released. The ticket becomes eligible for garbage collection only when no reachable references point to it. Passing an object to a method passes a copy of the reference; the method can access the same object.

## Counter alternative
If each `ParkingFacility` has its own instance counter, two facilities may issue the same ticket number. A shared static counter avoids that within one JVM. If ticket numbers should be unique per facility, use a facility identifier plus a local counter. One static counter takes O(1) space; k facility-specific counters take O(k) space. Storing n ticket objects takes O(n) space either way.
