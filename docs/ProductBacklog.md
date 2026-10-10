# Product Backlog

TravelPlanner for CP3490 Software Engineering, Fall 2026

The backlog is ordered by priority, with the most important work at the top. Every item links to the user story that holds its acceptance criteria, and to the requirements it delivers in the [Requirements Specification](RequirementsSpecification.md).

- **Priority (MoSCoW):** Must = needed for a working app · Should = important, but cut first if time runs short · Could = nice to have
- **Story points:** relative effort on the Fibonacci scale (1, 2, 3, 5, 8). A 1 is a small change; an 8 is the largest item we would take into one sprint.
- **Sprint:** assigned during sprint planning (Unassigned until then).

| Rank | ID | Item | User Story | Requirements | Priority | Points | Sprint |
| --- | --- | --- | --- | --- | --- | --- | --- |
| 1 | PB-01 | Create a trip | [US-01](UserStories/UserStories.md#us-01) | FR-1.1, FR-1.2 | Must | 3 | Unassigned |
| 2 | PB-02 | Save trip data | [US-14](UserStories/UserStories.md#us-14) | FR-7.1 | Must | 5 | Unassigned |
| 3 | PB-03 | View, edit and delete trips | [US-02](UserStories/UserStories.md#us-02) | FR-1.3, FR-1.4, FR-1.5 | Must | 3 | Unassigned |
| 4 | PB-04 | Add activities, with overlap warning | [US-04](UserStories/UserStories.md#us-04) | FR-2.1, FR-2.2, FR-2.5 | Must | 5 | Unassigned |
| 5 | PB-05 | Day-by-day itinerary, edit and delete | [US-05](UserStories/UserStories.md#us-05) | FR-2.3, FR-2.4 | Must | 5 | Unassigned |
| 6 | PB-06 | Set budget and log expenses | [US-06](UserStories/UserStories.md#us-06) | FR-3.1, FR-3.2, FR-3.6 | Must | 3 | Unassigned |
| 7 | PB-07 | Budget summary and overspend warning | [US-07](UserStories/UserStories.md#us-07) | FR-3.3, FR-3.4, FR-3.5 | Must | 5 | Unassigned |
| 8 | PB-08 | Accommodation and transportation details | [US-08](UserStories/UserStories.md#us-08) | FR-4.1, FR-4.2, FR-4.3, FR-4.4, FR-4.6 | Must | 5 | Unassigned |
| 9 | PB-09 | Trip dashboard | [US-13](UserStories/UserStories.md#us-13) | FR-6.1, FR-6.2 | Should | 5 | Unassigned |
| 10 | PB-12 | Accounts, sign-in and account screen | [US-15](UserStories/UserStories.md#us-15) | FR-8.1, FR-8.2, FR-8.3, FR-8.4 | Should | 8 | Unassigned |
| 11 | PB-13 | Invite members (accept / decline) | [US-10](UserStories/UserStories.md#us-10) | FR-5.1, FR-5.2, FR-5.5 | Should | 5 | Unassigned |
| 12 | PB-14 | Member roles and member list | [US-11](UserStories/UserStories.md#us-11) | FR-5.3, FR-5.4, FR-5.7, FR-5.8 | Should | 5 | Unassigned |
| 13 | PB-15 | Assign responsibilities | [US-12](UserStories/UserStories.md#us-12) | FR-5.6 | Should | 3 | Unassigned |
| 14 | PB-10 | Multiple destinations per trip | [US-03](UserStories/UserStories.md#us-03) | FR-1.6 | Should | 3 | Unassigned |
| 15 | PB-11 | Travel notes and emergency contacts | [US-09](UserStories/UserStories.md#us-09) | FR-4.5 | Could | 2 | Unassigned |

**Total:** 65 points (Must: 34 · Should: 29 · Could: 2)

## How the Backlog Is Ordered

1. **Core single-user features come first.** Items 1–8 are everything one traveler needs to plan a trip: create and manage it, build an itinerary, track a budget, and store bookings. Together they make a working app on their own, so they are all Must items, and saving data (PB-02) is near the top because every other item depends on it.
2. **The dashboard follows,** because it summarizes the Must items and can only be built once they exist.
3. **Accounts come before the group items,** because invitations, roles and responsibilities all need more than one account on the device. Items 10–13 are built in that order since each depends on the one before.
4. **Group Planning is Should, not Must.** It is one of our five core features, but it depends on accounts and is the most complex part of the app (see risk R-05 in the [Risk Roster](RiskRoster.md)). Ranking it after the single-user features protects the demo if time runs short.
5. **Smaller additions go last.** Multiple destinations and travel notes improve the app but nothing else depends on them, so they are the first to be cut.

Must items make up 34 of 65 points (about half), leaving room to drop Should and Could items without losing a working app.

## Non-Functional Requirements

Non-functional requirements (NFR-1 to NFR-17 in the [Requirements Specification](RequirementsSpecification.md#3-non-functional-requirements)) are not separate backlog items. They are part of the team's Definition of Done and are checked on every item.

## Definition of Done

An item is done when:

- [ ] All acceptance criteria in its user story pass
- [ ] JUnit tests are written for its logic and pass
- [ ] Code is merged to `main` through a pull request reviewed by 1 teammate
- [ ] Its screens work at 200% system font size and with TalkBack (NFR-15, NFR-17)
- [ ] It meets the other relevant non-functional requirements (e.g. error messages, data saved correctly)
