# Task 1 — Understand the Problem and Identify the Objects

## Inputs and outputs
Inputs: vehicle registration number and type, user category/pass validity, entry and exit time, requested floor/slot, and charging energy when applicable.
Outputs: allocated floor and slot, unique ticket number, entry record, parking fee, slot-release status, and error messages when an operation is invalid.

## Candidate classes and responsibilities
- `ParkingFacility`: owns floors and slots; allocates and releases slots.
- `ParkingSlot`: represents one numbered slot and whether it is occupied.
- `Vehicle` (abstract): common registration number and fee behaviour.
- `TwoWheeler`, `Car`, `ElectricCar`: specialise vehicle type/rate.
- `ParkingTicket`: unique ticket number, vehicle, slot, entry time and fee calculation.
- `ParkingUser` / `Student` / `Staff` / `Visitor`: represent user category and pass eligibility.
- `ParkingPass`: represents monthly or one-day pass validity.
- `PricingRule`: calculates the charge according to applicable rules.

## Business rules
1. A slot can contain at most one vehicle.
2. A registration number cannot have two active tickets simultaneously.
3. Ticket numbers must be unique and must not be reused.
4. A slot must be released only after a valid active ticket is processed.
5. Students and staff with valid monthly passes park free; visitors pay the normal fee unless they buy a valid one-day pass.
6. EV charging is charged separately.
7. Invalid registration numbers, negative durations and invalid slot coordinates must be rejected.

## Assumptions
Rates are configurable because the brief does not give every rate. Each started hour is billed as one hour in the supplied Task 8 example. A valid pass is checked at entry/exit. Floor and slot indexes in Java arrays start at zero, although displayed floor/slot numbers may start at one.

## Alternative: Vehicle objects vs parallel arrays
With objects, each vehicle keeps related data and behaviour together. Searching by registration number is O(n) in a simple array/list, or average O(1) with a `HashMap`. With parallel arrays (`regNo[]`, `type[]`, `entryTime[]`), all arrays must stay aligned; adding an attribute requires another array and synchronized updates. Search is O(n). Both approaches store O(n) vehicle records; object representation has per-object/reference overhead but is easier to extend.
