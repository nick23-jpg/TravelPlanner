# Requirements Specification

TravelPlanner · CP3490 Software Engineering, Fall 2026

> **How to use this template (delete this box before submitting):**
> **[FILL]** = write this yourselves · **[REVIEW]** = check it and change it if needed · `___` = a word, number or choice your team decides.
> Search the file for `[FILL]`, `[REVIEW]` and `___` to find every spot.
> Keep the requirement IDs (FR-1.1, NFR-1 …): the user stories and backlog link to them. If you add a requirement, give it the next number; if you delete one, also remove it from the user stories.

## 1. Introduction

### 1.1 Purpose

> **[FILL]** 2–3 sentences in your own words: what this document is for, and who reads it (your team, the instructor). Mention that requirement IDs link to the user stories and backlog.

### 1.2 Scope

> **[FILL]** 3–4 sentences: what the app does, which platform it runs on, and what it does NOT do (e.g. it doesn't book or pay for travel). Use the Core Features and Out of Scope lists in the [Product Vision](ProductVision.md) as your checklist.

### 1.3 Stakeholders

| Stakeholder | Type | Needs |
| --- | --- | --- |
| Travelers | Primary | Organize destinations, activities, accommodations, schedules and expenses |
| Group organizers | Primary | Create shared trips, invite members, assign responsibilities, manage shared expenses |
| Families and friend groups | Secondary | View the shared itinerary and budget; complete assigned responsibilities |
| Travel service providers | Indirect | Added to plans by users; no direct interaction |
| Project team, instructor/evaluator | Development / assessment | Build, test and assess the app |

## 2. Functional Requirements

> **[REVIEW]** Every requirement must be testable: someone can try it and say pass or fail. For each feature below, go through the requirements as a team:
> - Fill every `___`.
> - Remove anything you won't build, and add anything missing (give it the next ID).
> - Rewrite any line that doesn't match how your app will actually work.

### 2.1 Feature 1: Trip Management

| ID | Requirement |
| --- | --- |
| FR-1.1 | The system shall let a user create a trip with a name (1–___ characters), main destination, start date, end date and number of travelers (at least 1), plus an optional description. |
| FR-1.2 | The system shall reject a trip whose end date is before its start date and display an error message. |
| FR-1.3 | The system shall let a user edit any trip detail. |
| FR-1.4 | The system shall let a user delete a trip after confirming in a dialog. |
| FR-1.5 | The system shall list all trips sorted by ___ (e.g. start date, upcoming first). |
| FR-1.6 | The system shall let a user add more than one destination (stop) to a trip, each with its own arrival and departure dates inside the trip dates. |

### 2.2 Feature 2: Itinerary Builder

| ID | Requirement |
| --- | --- |
| FR-2.1 | The system shall let a user add an activity with a title, date and start time (required), and ___ (optional fields, e.g. location, end time, notes). |
| FR-2.2 | The system shall reject an activity whose date is outside the trip's start and end dates. |
| FR-2.3 | The system shall display activities grouped by day and sorted by start time. |
| FR-2.4 | The system shall let a user edit and delete activities. |
| FR-2.5 | The system shall ___ (warn / block) the user when a new or edited activity overlaps the time of another activity on the same day. |

### 2.3 Feature 3: Budget and Expense Tracking

| ID | Requirement |
| --- | --- |
| FR-3.1 | The system shall let a user set a total budget for a trip as an amount greater than 0, in ___ (one currency per trip / a currency the user chooses). |
| FR-3.2 | The system shall let a user log an expense with an amount (greater than 0), category, date and optional note. Categories: Transportation, Accommodation, Food, Activities, Other. |
| FR-3.3 | The system shall display total spent and remaining budget, where remaining = budget − total spent. |
| FR-3.4 | The system shall display total spending for each category. |
| FR-3.5 | The system shall show a warning when total spent exceeds ___% of the budget. |
| FR-3.6 | The system shall let a user edit and delete expenses. |

### 2.4 Feature 4: Accommodation, Transportation and Travel Information

| ID | Requirement |
| --- | --- |
| FR-4.1 | The system shall let a user add accommodation with a name, address, check-in date, check-out date and optional confirmation number. |
| FR-4.2 | The system shall let a user add transportation with a type (Flight, Train, Bus, Car Rental, Other), provider, departure and arrival locations, departure and arrival date-times, and optional confirmation number. |
| FR-4.3 | The system shall reject a check-out date before check-in, or an arrival before departure. |
| FR-4.4 | The system shall let a user edit and delete accommodation and transportation entries. |
| FR-4.5 | The system shall let a user save travel notes and emergency contacts (name, phone number, relationship) for each trip. |

### 2.5 Feature 5: Group Planning

| ID | Requirement |
| --- | --- |
| FR-5.1 | The system shall let the trip's creator (the Organizer) invite another user to the trip by their account email. |
| FR-5.2 | The system shall show the invited user an in-app invitation that they can accept or decline. |
| FR-5.3 | The system shall give each person on a trip one role: Organizer (edit everything, manage members) or Member (view shared trip information and ___). |
| FR-5.4 | The system shall hide edit controls for ___ from Members. |
| FR-5.5 | The system shall show all members the same itinerary, budget and bookings for a shared trip. |
| FR-5.6 | The system shall let the Organizer assign a responsibility (a task, or an activity) to a member, and let that member mark it done. |
| FR-5.7 | The system shall show a list of the trip's members with their name and contact information. |
| FR-5.8 | The system shall let the Organizer remove a member from the trip. |

> **[FILL]** Group features need user accounts and an online backend. Write which backend you chose (e.g. Firebase) and one sentence on why, then delete this note.

### 2.6 Supporting: Trip Dashboard

| ID | Requirement |
| --- | --- |
| FR-6.1 | The system shall show a dashboard for each trip with the trip name, dates, days until departure, the next ___ activities, budget spent and remaining, and upcoming bookings. |
| FR-6.2 | The system shall open the related screen when the user taps a dashboard section. |

### 2.7 Supporting: Data Storage

| ID | Requirement |
| --- | --- |
| FR-7.1 | The system shall save trip data ___ (on the device as JSON / in the backend / both) so it is still there after the app is closed and reopened. |

### 2.8 Supporting: User Accounts

| ID | Requirement |
| --- | --- |
| FR-8.1 | The system shall let a new user create an account with a first name, last name, email address and password. |
| FR-8.2 | The system shall let a user sign in with their email and password, and sign out. |
| FR-8.3 | The system shall let a user reset a forgotten password by email. |
| FR-8.4 | The system shall show an account screen with the user's personal information and a list of their trips, and let them edit their name and contact details. |

## 3. Non-Functional Requirements

> **[FILL]** Every requirement needs a number in the last column so it can be measured. Fill each `___` with a target your team can actually test. Agree on the test device first, because it affects the performance numbers.

| ID | Category | Requirement | How it's measured |
| --- | --- | --- | --- |
| NFR-1 | Usability | A first-time user can create a trip without help. | ___ test users outside the team each create a trip in under ___ minutes |
| NFR-2 | Usability | Every main feature is reachable from the trip dashboard. | No more than ___ taps from the dashboard to any feature |
| NFR-3 | Usability | Invalid input shows a specific error message next to the field. | Every validation rule in FR-1.1, FR-1.2, FR-1.6, FR-2.2, FR-3.1, FR-3.2 and FR-4.3 tested |
| NFR-4 | Reliability | Saved data survives closing the app and restarting the device. | ___ out of ___ restart tests keep all data |
| NFR-5 | Reliability | The app does not crash during normal use. | 0 crashes while running every user story's acceptance test |
| NFR-6 | Reliability | A damaged data file does not crash the app. | Corrupted-data test shows an error message instead of crashing |
| NFR-7 | Performance | The app opens quickly. | Trip list appears within ___ seconds of launch on ___ (test device or emulator) |
| NFR-8 | Performance | Screens stay responsive with realistic data. | Each screen loads within ___ second(s) with ___ trips and ___ activities |
| NFR-9 | Maintainability | Business logic is unit tested. | At least ___% JUnit line coverage of non-UI code |
| NFR-10 | Maintainability | Code is consistent and reviewed. | Follows Kotlin coding conventions; every merge to `main` goes through a pull request approved by ___ teammate(s) |
| NFR-11 | Maintainability | Code is object-oriented, with UI code kept separate from data and logic code. | Uses the ___ architecture pattern (e.g. MVVM) |
| NFR-12 | Security | Trip data cannot be read by other apps. | Data stored only in the app's private internal storage |
| NFR-13 | Security | Shared trips, and members' personal and contact information, are visible only to members of that trip. | A non-member account cannot open or list the trip in testing |
| NFR-14 | Security | Passwords are never stored in plain text. | Passwords handled by ___ (authentication service); none saved on the device or in trip data |
| NFR-15 | Accessibility | Screen readers can describe every control. | Every button and icon has a content description, checked with TalkBack |
| NFR-16 | Accessibility | Controls are easy to tap. | All touch targets at least 48 × 48 dp (Android guideline) |
| NFR-17 | Accessibility | Text is readable for low-vision users. | Text contrast at least 4.5:1 (WCAG AA); layouts work at ___% system font size |

## 4. Constraints and Assumptions

> **[REVIEW]** Fill the blanks and add any constraint the team knows of (e.g. devices you have for testing).

- Android only, minimum version Android ___ (API ___).
- Built with Kotlin, Java, Compose Multiplatform and kotlinx.serialization in Android Studio, with ___ as the backend.
- Final delivery: first week of December 2026.
- Team of three, working in ___-week Scrum sprints.
- Users enter all travel details themselves; there are no provider integrations. Users are responsible for entering accurate trip, itinerary and expense information.
- Accounts, invitations and shared trips need an internet connection. Single-user features ___ (do / do not) work offline.

## 5. Glossary

> **[REVIEW]** Add any term a reader outside the course might not know. Remove terms you don't use.

| Term | Meaning |
| --- | --- |
| API | Application Programming Interface, a way for the app to get data from an outside service |
| FR / NFR | Functional / Non-Functional Requirement |
| JSON | JavaScript Object Notation, a text format for storing data |
| Compose | Kotlin toolkit for building app screens |
| kotlinx.serialization | Kotlin library that converts data to and from JSON |
| JUnit | Unit testing framework |
| TalkBack | Android's built-in screen reader |
| dp | Density-independent pixel, Android's unit for screen sizes |
| MoSCoW | Prioritization scheme: Must, Should, Could, Won't |
| OOP | Object-Oriented Programming, organizing code into classes and objects |
