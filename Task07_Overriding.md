# Task 7 — Override and Specialise Behaviour

`calculateFee()` is overridden because each vehicle category may use a different rate or rule. `@Override` lets the compiler check that a superclass method is actually being overridden. The method name and parameter types must match; the return type must be compatible, and access cannot be made more restrictive.

Use `final` for immutable registration numbers, `final` methods when subclasses must not change behaviour, and `final` classes when inheritance is prohibited. `equals()` and `hashCode()` must follow the same equality rule. If registration number alone defines identity, the sample implementation treats different vehicle subclasses with the same registration as equal; a real system may instead require vehicle category to be part of equality.

A single switch-based fee method can be O(1) for a fixed number of types, but adding a type requires editing the switch and risks violating the open/closed principle. Overriding keeps each category's behaviour with its class.
