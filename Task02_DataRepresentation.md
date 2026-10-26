# Task 2 — Choose the Data Representation

| Data | Suggested Java type | Reason |
|---|---|---|
| Floor/slot index | `int` | Whole-number array indexes |
| Registration number | `String` | Contains letters and digits |
| Ticket number | `long` | Supports a growing unique counter |
| Entry/exit time | `LocalDateTime` | Represents date and time |
| Duration | `long` or `int` minutes | Whole-minute duration |
| Fee | `double` for this assignment | Supports fractional arithmetic; production billing should use `BigDecimal` |
| Pass validity | `boolean` or a pass object | Indicates eligibility / stores dates |

Use a jagged array `String[][] slots`, where each row has the number of slots on that floor. It supports floors with different capacities. A one-dimensional array is straightforward only if floor capacities are equal or an index-offset table is maintained. `ArrayList<String[]>` also supports different row lengths.

Avoid integer division when converting minutes to billable hours. For example, `130 / 60` using integers gives `2`; this is correct only if every started hour is charged and ceiling logic is applied. Use `(minutes + 59) / 60` for non-negative integer minutes: 130 minutes becomes 3 hours. `minutes / 60.0` gives a decimal duration, but billing policy still determines whether to round up. Do not cast to `int` before rounding because that truncates the fraction.

Use `Scanner` for simple console input, or command-line arguments for repeatable tests.

## Complexity
Searching all slots is O(N), where N is the total number of slots; the slot array space is O(N). A flattened array uses O(N) space too, but unequal floors need offsets or a mapping from flat index to floor/slot. A jagged array uses O(N + F) space for N slots and F floor-row references.
