# Task 10 — Packages and Encapsulation

Suggested package structure:
- `parking.model`: Vehicle, ParkingTicket, ParkingPass.
- `parking.service`: ParkingFacility and pricing services.
- `parking.app`: application entry point.

Use `private` for fields, `public` for the intended API, `protected` for subclass extension points, and package-private access for implementation details used only within a package. Getters expose data; setters validate values such as non-negative duration and valid slot coordinates.

Autoboxing converts an `int` to `Integer`; unboxing converts it back. Comparing two `Integer` objects with `==` compares references, not reliably their numeric values; use `.equals()` or compare primitive values.

Public fields force every caller to remember validation. With private fields and validating setters, each update has O(1) validation cost, but the check is centralized. Public fields may lead to repeated checks across many call sites and invalid object state.
