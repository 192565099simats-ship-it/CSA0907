# Task 8 — Polymorphism

Compile-time polymorphism is method overloading: for example `calculateFee(int minutes)` and `calculateFee(LocalDateTime entry, LocalDateTime exit)`. The compiler selects the overload from argument types. Runtime polymorphism occurs when a `Vehicle` reference points to a `Car` or `TwoWheeler`; the actual object's overridden method is selected at runtime.

Example trace: declared type `Vehicle`, actual object `ElectricCar`, invoked method `calculateFee(130)` → inherited `Vehicle.calculateFee` calls the overridden `ratePerHour()` → `Car` rate of 30 is used; the charging interface then adds 10 × 12 = 120. Total is 90 + 120 = ₹210.

The last equality expression prints true because the supplied equality implementation compares only registration numbers. Decide whether registration number alone should define equality for your system.

Using a chain of `instanceof` checks can require up to k checks for k categories; dynamic dispatch selects the implementation without a growing conditional chain. Both fee calculation and dispatch are O(1) for this example.
