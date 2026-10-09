# User Stories

TravelPlanner · CP3490 Software Engineering, Fall 2026

Each story links to the requirements it covers in the [Requirements Specification](../RequirementsSpecification.md).

## Trip Management

### US-01
**As a** traveler, **I want to** create a trip with a destination and dates **so that** I can start planning it.

- **Requirements:** FR-1.1, FR-1.2
- **Story points:** 1
- **Acceptance criteria:**
    - Given I fill in a name, destination, start date, end date and number of travelers, when I tap Save, then the trip appears in my trip list.
    - Given the end date is before the start date, when I tap Save, then I see an error and the trip is not saved.
    - Given a required field is empty, or the number of travelers is less than 1, when I tap Save, then that field is highlighted with an error.

### US-02
**As a** traveler, **I want to** see, edit and delete my trips **so that** I can find the one I need and keep my plans accurate.

- **Requirements:** FR-1.3, FR-1.4, FR-1.5
- **Story points:** 8
- **Acceptance criteria:**
    - Given I have several trips, when I open the app, then they are listed by start date with upcoming trips first.

### US-03
**As a** traveler, **I want to** add several destinations to one trip **so that** I can plan a multi-stop trip.

- **Requirements:** FR-1.6
- **Story points:** 5
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
    - Given I enter an activity date that falls outside of the trip dates, when i try to save, then an error is shown.

### US-05
**As a** traveler, **I want to** view my itinerary day by day and change it **so that** I always know what's happening when.

- **Requirements:** FR-2.3, FR-2.4
- **Story points:** 5
- **Acceptance criteria:**
    - Given a trip has activities on several days, when I open the itinerary, then activities are grouped by day and sorted by time.


## Budget and Expense Tracking

### US-06
**As a** traveler, **I want to** set a trip budget and log expenses by category **so that** I can track where my money goes.

- **Requirements:** FR-3.1, FR-3.2, FR-3.6
- **Story points:** 8
- **Acceptance criteria:**
    - Given I create a new budget for a trip, I have to set the budget title or use the trip title, and enter a total amount for the budget.
    - Given I enter a budget greater than 0, when I save, then it shows as the trip budget, but 0 or a negative amount shows an error.
    - Given I have created a budget, I can add expenses under the budget with a title, and an amount within the budget's total.
    - Given I have a number of expenses, I can create categories and group different related expenses, when I save the categories, the total for each category is automatically displayed.
    - Given the total amount across the categories exceeds the set budget total, when I try to save I get a warning, then I am asked if I want to adjust the budget total, or review the categories and expenses. 

### US-07
**As a** traveler, **I want to** see how much I've spent and have left **so that** I don't overspend.

- **Requirements:** FR-3.3, FR-3.4, FR-3.5
- **Story points:** 3
- **Acceptance criteria:**
    - Given a $1,000 budget and $250 of expenses for example, then I see Spent $250 and Remaining $750.  


## Accommodation, Transportation and Travel Information

### US-08
**As a** traveler, **I want to** save my accommodation and transportation details **so that** all my bookings are in one place.

- **Requirements:** FR-4.1, FR-4.2, FR-4.3, FR-4.4
- **Story points:** 5
- **Acceptance criteria:**
    - Given I enter a hotel's name, address and check-in/check-out dates, when I save, then it is listed under the trip.
    - Given I enter a mode of transportation for a particular trip and enter the provider, location(s) and time(s), when I save  then it is listed under that trip.
    - Given the date of the check-out is before the check-in, or that of the arrival is before the departure, when I try to save, then I see an error.
    - Given I create a new trip to a location I have been to before, when I have to fill in the trip information, then I would be asked if I want to use the same hotel, and mode of transportation as last time.

### US-09
**As a** traveler, **I want to** keep travel notes and emergency contacts with my trip **so that** I can find them fast if something goes wrong.

- **Requirements:** FR-4.5
- **Story points:** 3
- **Acceptance criteria:**
    - Given I add an emergency contact with a name, phone number and relationship, when I save, then it appears in the trip's travel information.
    - Given I type a note for a trip, when i reopen it, the note is still there.


## Group Planning

### US-10
**As an** organizer, **I want to** invite family or friends to my trip **so that** we can plan together.

- **Requirements:** FR-5.1, FR-5.2, FR-5.5
- **Story points:** 8
- **Acceptance criteria:**
    - Given I enter the email of an existing account, when I tap Invite, then that user sees an invitation naming me and the trip.
    - 

### US-11
**As an** organizer, **I want** members to have view-only access and see who is on the trip **so that** only I change the plan and everyone can reach each other.

- **Requirements:** FR-5.3, FR-5.4, FR-5.7, FR-5.8
- **Story points:** 
- **Acceptance criteria:**
    - Given I am a Member, when I open a shared trip, then no edit or delete buttons are shown for the itinerary, budget or bookings.

### US-12
**As an** organizer, **I want to** assign responsibilities to group members **so that** everyone knows what they need to do.

- **Requirements:** FR-5.6
- **Story points:** 
- **Acceptance criteria:**
    - Given I assign "Book the rental car" to a member, then it shows with their name on the trip.

## Trip Dashboard

### US-13
**As a** traveler, **I want** a dashboard for each trip **so that** I see the key information at a glance.

- **Requirements:** FR-6.1, FR-6.2
- **Story points:** 
- **Acceptance criteria:**
    - Given a trip with activities, expenses and bookings, when I open it, then I see the dates, days until departure, the next 3 activities, spent and remaining budget, and upcoming bookings.


## Data Storage

### US-14
**As a** traveler, **I want** my trips saved automatically **so that** nothing is lost when I close the app.

- **Requirements:** FR-7.1
- **Story points:** 8
- **Acceptance criteria:**
    - Given I add a trip, activity, expense or booking, when I close and reopen the app, then it is still there.


## User Accounts

### US-15
**As a** user, **I want to** create an account, sign in and manage my details **so that** I can join shared trips and keep my contact info up to date.

- **Requirements:** FR-8.1, FR-8.2, FR-8.3, FR-8.4
- **Story points:** 5
- **Acceptance criteria:**
    - Given I enter my first name, last name, email and password, when I tap Create Account, then I am signed in.
