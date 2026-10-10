# TravelPlanner

TravelPlanner is an offline Android app for planning trips alone or in a group: itineraries, budgets and expenses, accommodation and transportation, and shared trips between accounts on the same device.

**Course:** CP3490 Software Engineering, Fall 2026 · College of the North Atlantic
**Instructor:** Lori Hogan

## Team

- Hanson Agumbah
- Dominique Badibanga
- Oluwadamilare Oladipo

## Problem Statement
Travelers often use multiple applications to organize destinations, activities, accommodations, schedules, and expenses, making trip planning difficult to manage in one place. A travel planner application will be developed to centralize trip planning by allowing users to create itineraries, track budgets and expenses, and organize travel information, with support for planning trips with family or friends.

## Application Context
The travel planner software will assist users in planning and organizing their trips by allowing them to create, view, and manage trip details. It will include features such as trip management, itinerary planning, budget and expense tracking, accommodation and transportation details, group coordination, and travel information. The app runs fully offline and stores all data, including user accounts, in JSON files on the device.

## Stakeholder Analysis
The primary stakeholders are **travelers** and **group organizers**, who will use the application to organize destinations, activities, accommodations, schedules, and expenses.

**Families and groups of friends** are secondary stakeholders who may use shared itineraries and budget tracking.

**Travel service providers**, such as hotels, airlines, and tour operators, are indirect stakeholders because users may add their services to trip plans, but they will not directly interact with the system.

The **project team and instructor/evaluator** are responsible for developing, testing, and assessing the application.

## Key Features
The application will have:

- **Trip Creation:** Create trips with destinations, dates, and basic details, including multi-stop trips.
- **Itinerary Builder / Tracker:** Add and organize activities, locations, and events by date and time.
- **Budget and Expense Tracking:** Set a trip budget and track expenses by category.
- **Accommodation & Transportation:** Store hotel, flight, rental, and other travel details.
- **Travel Information:** Store travel notes and emergency contacts for each trip.
- **Group Planning:** Invite other accounts to a trip, with Organizer and Member roles and assigned responsibilities.
- **Trip Dashboard:** Provide a simple overview of the itinerary, budget, and important trip information.
- **User Accounts:** Local accounts on the device, with personal information and a list of the user's trips.

## Documentation

| Document | Contents |
| --- | --- |
| [Product Vision](docs/ProductVision.md) | Who the app is for, goals, scope and success measures |
| [Requirements Specification](docs/RequirementsSpecification.md) | Functional and non-functional requirements |
| [User Stories](docs/UserStories/UserStories.md) | User stories with acceptance criteria and story points |
| [Product Backlog](docs/ProductBacklog.md) | Prioritized backlog traced to user stories and requirements |
| [Risk Roster](docs/RiskRoster.md) | Project risks with probability, impact and mitigation |

## Technologies Used

- Kotlin
- Java
- Android Studio
- Compose Multiplatform
- kotlinx.serialization
- JSON
- Figma
- Git and GitHub
- JUnit
- Claude AI

## Use of AI Tools

With our instructor's approval, we used Claude AI to help plan the project and fine-tune its documentation, including the requirements, user stories, product backlog and risk roster. The team reviewed, edited and approved all content and made the final decisions on scope, priorities and design.

## Scrum Process

This project follows Scrum practices using:

- GitHub Issues
- GitHub Projects
- Pull Requests
- Sprint Reviews
- Sprint Retrospectives

## Repository Structure

- `/docs` Scrum and requirements documents
- `/src` Application source code

<pre>
TravelPlanner/
│
├── README.md
│
├── src/
│   └── README.md
│
└── docs/
    ├── ProductVision.md
    ├── RequirementsSpecification.md
    ├── ProductBacklog.md
    ├── RiskRoster.md
    ├── Architecture.drawio
    └── UserStories/
        └── UserStories.md
</pre>

Sprint planning, review and retrospective documents (e.g. `docs/Sprint1Planning.md`) will be added to `/docs` as each sprint runs.
