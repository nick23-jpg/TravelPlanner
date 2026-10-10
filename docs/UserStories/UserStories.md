# User Stories

TravelPlanner for CP3490 Software Engineering, Fall 2026

Each story links to the requirements it covers in the [Requirements Specification](../RequirementsSpecification.md).

## Trip Management

### US-01
**As a** traveler, **I want to** create a trip with a destination and dates **so that** I can start planning it.

- **Requirements:** FR-1.1, FR-1.2
- **Story points:** 3
- **Acceptance criteria:**
    - Given I fill in a name, destination, start date, end date and number of travelers, when I tap Save, then the trip appears in my trip list.
    - Given the end date is before the start date, when I tap Save, then I see an error and the trip is not saved.
    - Given a required field is empty, or the number of travelers is less than 1, when I tap Save, then that field is highlighted with an error.

### US-02
**As a** traveler, **I want to** see, edit and delete my trips **so that** I can find the one I need and keep my plans accurate.

- **Requirements:** FR-1.3, FR-1.4, FR-1.5
- **Story points:** 3
- **Acceptance criteria:**
    - Given I have several trips, when I open the app, then they are listed by start date with upcoming trips first.
    - Given I edit a trip's details, when I tap Save, then the changes show in the trip list and on the dashboard.
    - Given I tap Delete on a trip, when I confirm, then the trip and everything in it are removed; when I cancel, nothing changes.

### US-03
**As a** traveler, **I want to** add several destinations to one trip **so that** I can plan a multi-stop trip.

- **Requirements:** FR-1.6
- **Story points:** 3
- **Acceptance criteria:**
    - Given a trip from June 1 to June 10, when I add Toronto (June 1–4) and Montreal (June 4–10), then both stops appear in order on the trip.
    - Given I try to add a stop date that is outside of the trip dates, when I tap save, then I see an error.

## Itinerary Builder

### US-04
**As a** traveler, **I want to** add activities with a date and time **so that** I have a plan for each day.

- **Requirements:** FR-2.1, FR-2.2, FR-2.5
- **Story points:** 5
- **Acceptance criteria:**
    - Given I enter a title, date and time within the trip dates, when I tap Save, then the activity appears under that day.
    - Given I enter an activity date that falls outside of the trip dates, when I try to save, then an error is shown.
    - Given an activity from 2:00 to 4:00 PM already exists, when I add one at 3:00 PM the same day, then I see an overlap warning and can save anyway or change the time.

### US-05
**As a** traveler, **I want to** view my itinerary day by day and change it **so that** I always know what's happening when.

- **Requirements:** FR-2.3, FR-2.4
- **Story points:** 5
- **Acceptance criteria:**
    - Given a trip has activities on several days, when I open the itinerary, then activities are grouped by day and sorted by time.
    - Given I change an activity's time, when I save, then it moves to the correct position in that day's list.
    - Given I delete an activity, then it no longer appears in the itinerary or on the dashboard.

## Budget and Expense Tracking

### US-06
**As a** traveler, **I want to** set a trip budget and log expenses by category **so that** I can track where my money goes.

- **Requirements:** FR-3.1, FR-3.2, FR-3.6
- **Story points:** 3
- **Acceptance criteria:**
    - Given I enter a budget greater than 0 and choose a currency, when I save, then it shows as the trip budget; 0 or a negative amount shows an error.
    - Given I enter an expense with an amount, a category (Transportation, Accommodation, Food, Activities or Other) and a date, when I save, then it appears in the trip's expense list under that category.
    - Given I edit or delete an expense, when I save, then the trip's totals update immediately.

### US-07
**As a** traveler, **I want to** see how much I've spent and have left **so that** I don't overspend.

- **Requirements:** FR-3.3, FR-3.4, FR-3.5
- **Story points:** 5
- **Acceptance criteria:**
    - Given a $1,000 budget and $250 of expenses, then I see Spent $250 and Remaining $750.
    - Given I have expenses in several categories, then I see the total spent in each category.
    - Given my total spending goes over the budget, when I save an expense, then I see a warning and can choose to adjust the budget total or review my expenses.

## Accommodation, Transportation and Travel Information

### US-08
**As a** traveler, **I want to** save my accommodation and transportation details **so that** all my bookings are in one place.

- **Requirements:** FR-4.1, FR-4.2, FR-4.3, FR-4.4, FR-4.6
- **Story points:** 5
- **Acceptance criteria:**
    - Given I enter a hotel's name, address and check-in/check-out dates, when I save, then it is listed under the trip.
    - Given I enter a mode of transportation for a trip with the provider, locations and times, when I save, then it is listed under that trip.
    - Given the check-out date is before the check-in date, or the arrival is before the departure, when I try to save, then I see an error.
    - Given I edit or delete a booking, when I save, then the trip's booking list and dashboard update to match.
    - Given I create a new trip to a destination I have visited on a previous trip, when I fill in the trip information, then I am asked if I want to copy the hotel and transportation details from that trip.

### US-09
**As a** traveler, **I want to** keep travel notes and emergency contacts with my trip **so that** I can find them fast if something goes wrong.

- **Requirements:** FR-4.5
- **Story points:** 2
- **Acceptance criteria:**
    - Given I add an emergency contact with a name, phone number and relationship, when I save, then it appears in the trip's travel information.
    - Given I type a note for a trip, when I reopen it, then the note is still there.

## Group Planning

### US-10
**As an** organizer, **I want to** invite family or friends to my trip **so that** we can plan together.

- **Requirements:** FR-5.1, FR-5.2, FR-5.5
- **Story points:** 5
- **Acceptance criteria:**
    - Given I enter the email of an account on this device, when I tap Invite, then that user sees an invitation naming me and the trip the next time they sign in.
    - Given I am invited, when I tap Accept, then the trip appears in my trip list with the same itinerary, budget and bookings the organizer sees.
    - Given I am invited, when I tap Decline, then the trip does not appear in my list and the organizer sees that the invitation was declined.
    - Given the email does not belong to any account on this device, when I tap Invite, then I see an error.

### US-11
**As an** organizer, **I want** members to only change what they added and to see who is on the trip **so that** the plan stays under my control and everyone can reach each other.

- **Requirements:** FR-5.3, FR-5.4, FR-5.7, FR-5.8
- **Story points:** 5
- **Acceptance criteria:**
    - Given I am a Member, when I add a rental car booking, then it appears on the trip for everyone, and I can edit or delete it.
    - Given I am a Member, when I open a booking another member added, then I can view it but not edit or delete it.
    - Given I am a Member, when I open the itinerary or the trip budget, then no edit buttons are shown.
    - Given I open a shared trip, then I see every member's name and contact information.
    - Given I am the Organizer, when I remove a member, then they can no longer see the trip or its member list.

### US-12
**As an** organizer, **I want to** assign responsibilities to group members **so that** everyone knows what they need to do.

- **Requirements:** FR-5.6
- **Story points:** 3
- **Acceptance criteria:**
    - Given I assign "Book the rental car" to a member, then it shows with their name on the trip.
    - Given I am that member, when I mark it done, then the organizer sees it marked done the next time they open the trip.
    - Given a responsibility is not done yet, then it is shown as open on the trip.

## Trip Dashboard

### US-13
**As a** traveler, **I want** a dashboard for each trip **so that** I see the key information at a glance.

- **Requirements:** FR-6.1, FR-6.2
- **Story points:** 5
- **Acceptance criteria:**
    - Given a trip with activities, expenses and bookings, when I open it, then I see the dates, days until departure, the next 3 activities, spent and remaining budget, and upcoming bookings.
    - Given I tap the budget section of the dashboard, then the budget screen opens.

## Data Storage

### US-14
**As a** traveler, **I want** my trips saved automatically **so that** nothing is lost when I close the app.

- **Requirements:** FR-7.1
- **Story points:** 5
- **Acceptance criteria:**
    - Given I add a trip, activity, expense or booking, when I close and reopen the app, then it is still there.

## User Accounts

### US-15
**As a** user, **I want to** create an account, sign in and manage my details **so that** I can join shared trips and keep my contact info up to date.

- **Requirements:** FR-8.1, FR-8.2, FR-8.3, FR-8.4
- **Story points:** 8
- **Acceptance criteria:**
    - Given I enter my first name, last name, email, password and a security question and answer, when I tap Create Account, then I am signed in.
    - Given I have an account, when I enter my correct email and password and tap Sign In, then I see my trip list.
    - Given I enter a wrong password, when I tap Sign In, then I see an error and stay signed out.
    - Given I am signed in, when I tap Sign Out, then I return to the sign-in screen and my trips are hidden.
    - Given I forgot my password, when I answer my security question correctly, then I can set a new password.
    - Given I open my account screen, when I change my phone number and save, then members of my shared trips see the new number.
