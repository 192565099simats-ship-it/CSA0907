# Task 11 — Testing and Evaluation

Run the program and record your actual outputs in the report. Do not claim a test passed until you execute it.

| Test | Input / condition | Expected result |
|---|---|---|
| Normal car entry/exit | Car parked for 70 minutes at ₹30/hour | ₹60 if every started hour is charged |
| Two-wheeler | 70 minutes at ₹10/hour | ₹20 |
| Last free slot | Fill all but one slot, then enter | Entry succeeds in final slot |
| Facility full | Attempt another entry | Clear full-facility error |
| Zero-minute stay | Entry and exit at same time | ₹0 under this sample implementation |
| Fee boundary | Exactly 60 minutes | One billable hour |
| Duplicate registration | Enter same registration twice | Reject second active ticket |
| Invalid registration | Blank registration | Reject |
| Invalid exit | Exit unknown registration | Reject |
| Exit before entry | Exit timestamp earlier than entry | Reject |

Example hand calculation: one car parked for 70 minutes costs 2 × ₹30 = ₹60; one two-wheeler parked for 70 minutes costs 2 × ₹10 = ₹20; total collection = ₹80.

A `HashMap<String, ParkingTicket>` finds a ticket by registration in average O(1) time, compared with O(n) linear search in an array/list. Both store O(n) ticket references. The implementation should be evaluated against actual executed tests, and limitations (e.g. persistence and concurrency) should be stated.
