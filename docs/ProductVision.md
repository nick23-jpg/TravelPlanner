# Product Vision

## Vision Statement

**For** travelers planning trips alone or with family and friends
**who** want to plan and manage a whole trip in one place,
**TravelPlanner** is an Android app
**that** lets them create trips, add accommodation and transportation, budget for trips, build itineraries, and plan in groups.
**Unlike** most trip planners,
**our application** runs fully offline, with no backend or database.

## Target Users

| User | What they need |
| --- | --- |
| Solo traveler | One place for plans, bookings and spending |
| Group organizer | Invite people, assign responsibilities and keep the group's plan in one place |
| Family or friend group member | See the shared plan and budget, and know what they're responsible for |

## Goals

1. A user can plan a complete trip (itinerary, budget, bookings) without leaving the app.
2. A user can invite other users to plan a trip.
3. A trip member can add bookings and expenses but only edit what they added; the organizer controls everything else.
4. A user can still see all their data after closing and reopening the application.

## Core Features

1. Trip Management (including multi-stop trips)
2. Itinerary Builder
3. Budget and Expense Tracking
4. Accommodation, Transportation and Travel Information
5. Group Planning

## Future Ideas

These ideas are not yet requirements. They can be moved into the backlog if time allows.

- Calendar (month) view of the trip
- Notifications and reminders
- Search and filtering of trips, activities and expenses
- Map view of the trip, and routes between destinations
- Weather, flight status and travel advisories from external APIs

## Out of Scope

- Booking or paying for hotels, flights or tours inside the app
- Syncing accounts and shared trips across separate devices
- Direct integration with travel providers. Users enter details themselves.
- Web and iOS versions

## Success Measures

- A new user creates their first trip in under 5 minutes ([NFR-1](RequirementsSpecification.md#3-non-functional-requirements))
- A user can reach the core features of a trip from the trip dashboard in no more than 2 taps ([NFR-2](RequirementsSpecification.md#3-non-functional-requirements))
- Group planning works fully, with member permissions restricting what an invited member can edit ([2.5 Feature 5: Group Planning](RequirementsSpecification.md#25-feature-5-group-planning))
- All of a user's data stays saved in the app without any internet connection ([4. Constraints and Assumptions](RequirementsSpecification.md#4-constraints-and-assumptions))
