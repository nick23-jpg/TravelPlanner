# Product Backlog

TravelPlanner · CP3490 Software Engineering, Fall 2026

> **How to use this template (delete this box before submitting):**
> **[FILL]** = write this yourselves · **[REVIEW]** = check it and change it if needed · `___` = a value your team decides.
>
> 1. **Priority:** as a team, mark each item Must, Should or Could (MoSCoW). Must = the app doesn't work without it.
> 2. **Points:** copy each story's estimate from [User Stories](UserStories/UserStories.md) after your planning-poker session.
> 3. **Rank:** re-order the rows so all Must items are at the top, then renumber the Rank column.
> 4. **Sprint:** leave as ___ until sprint planning, then write Sprint 1, Sprint 2, …
> 5. Add up the totals.

The backlog is ordered by priority, with the most important work at the top. Every item links to the user story (which holds its acceptance criteria) and the requirements it delivers.

- **Priority (MoSCoW):** Must = needed for a working app · Should = important, but cut first if time runs short · Could = nice to have
- **Story points:** relative effort on the Fibonacci scale (1, 2, 3, 5, 8), estimated by the team.
- **Sprint:** assigned during sprint planning

| Rank | ID | Item | User Story | Requirements | Priority | Points | Sprint |
| --- | --- | --- | --- | --- | --- | --- | --- |
| 1 | PB-01 | Create a trip | [US-01](UserStories/UserStories.md#us-01) | FR-1.1, FR-1.2 | ___ | ___ | ___ |
| 2 | PB-02 | Save trip data | [US-14](UserStories/UserStories.md#us-14) | FR-7.1 | ___ | ___ | ___ |
| 3 | PB-03 | View, edit and delete trips | [US-02](UserStories/UserStories.md#us-02) | FR-1.3, FR-1.4, FR-1.5 | ___ | ___ | ___ |
| 4 | PB-04 | Add activities, with overlap warning | [US-04](UserStories/UserStories.md#us-04) | FR-2.1, FR-2.2, FR-2.5 | ___ | ___ | ___ |
| 5 | PB-05 | Day-by-day itinerary, edit and delete | [US-05](UserStories/UserStories.md#us-05) | FR-2.3, FR-2.4 | ___ | ___ | ___ |
| 6 | PB-06 | Set budget and log expenses | [US-06](UserStories/UserStories.md#us-06) | FR-3.1, FR-3.2, FR-3.6 | ___ | ___ | ___ |
| 7 | PB-07 | Budget summary and overspend warning | [US-07](UserStories/UserStories.md#us-07) | FR-3.3, FR-3.4, FR-3.5 | ___ | ___ | ___ |
| 8 | PB-08 | Accommodation and transportation details | [US-08](UserStories/UserStories.md#us-08) | FR-4.1, FR-4.2, FR-4.3, FR-4.4 | ___ | ___ | ___ |
| 9 | PB-09 | Trip dashboard | [US-13](UserStories/UserStories.md#us-13) | FR-6.1, FR-6.2 | ___ | ___ | ___ |
| 10 | PB-10 | Multiple destinations per trip | [US-03](UserStories/UserStories.md#us-03) | FR-1.6 | ___ | ___ | ___ |
| 11 | PB-11 | Travel notes and emergency contacts | [US-09](UserStories/UserStories.md#us-09) | FR-4.5 | ___ | ___ | ___ |
| 12 | PB-12 | Accounts, sign-in and account screen | [US-15](UserStories/UserStories.md#us-15) | FR-8.1, FR-8.2, FR-8.3, FR-8.4 | ___ | ___ | ___ |
| 13 | PB-13 | Invite members (accept / decline) | [US-10](UserStories/UserStories.md#us-10) | FR-5.1, FR-5.2, FR-5.5 | ___ | ___ | ___ |
| 14 | PB-14 | Member roles and member list | [US-11](UserStories/UserStories.md#us-11) | FR-5.3, FR-5.4, FR-5.7, FR-5.8 | ___ | ___ | ___ |
| 15 | PB-15 | Assign responsibilities | [US-12](UserStories/UserStories.md#us-12) | FR-5.6 | ___ | ___ | ___ |

**Total:** ___ points (Must: ___ · Should: ___ · Could: ___)

> **[FILL]** One or two sentences on how you ordered the backlog (e.g. why accounts come before group features, what you would cut first if time runs short).

## Non-Functional Requirements

Non-functional requirements (NFR-1 to NFR-17 in the [Requirements Specification](RequirementsSpecification.md#3-non-functional-requirements)) are not separate backlog items. They are part of the team's Definition of Done and are checked on every item.

## Definition of Done

> **[REVIEW]** Agree on this list as a team; add or remove items.

An item is done when:

- [ ] All acceptance criteria in its user story pass
- [ ] JUnit tests are written for its logic and pass
- [ ] Code is merged to `main` through a pull request reviewed by 1 teammate
- [ ] It meets the relevant non-functional requirements (e.g. error messages, content descriptions)

