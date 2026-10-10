# TravelPlanner — Source Code

## Overview

This directory contains the source code for TravelPlanner, an application designed to centralize trip planning by allowing users to organize travel information in one place. The application supports trip creation, itinerary management, budget and expense tracking, and the organization of accommodation and transportation details.

## Features

* **Trip Creation:** Create trips with destinations, travel dates, and basic details.
* **Itinerary Builder:** Add and organize activities, locations, and events by date and time.
* **Budget and Expense Tracking:** Set trip budgets, record expenses, and organize spending by category.
* **Group Planning:** Invite other accounts on the device to a trip, with Organizer and Member roles and assigned responsibilities.
* **Trip Dashboard:** Display an overview of the itinerary, budget, and important trip information.
* **Accommodation and Transportation:** Store details about hotels, flights, rental vehicles, and other travel arrangements.
* **User Accounts:** Local accounts on the device; each user sees only their own trips and trips they've been invited to.

## Technologies

* **Kotlin and Java:** Application development.
* **Compose Multiplatform:** User interface development.
* **kotlinx.serialization:** Serialization and deserialization of application data.
* **JSON:** Local data storage.
* **Android Studio:** Development environment.
* **Figma:** UI/UX design and prototyping.
* **Git and GitHub:** Version control and collaboration.
* **JUnit:** Unit testing.

## Data Storage

TravelPlanner uses JSON files for local data storage rather than a database. User accounts (with hashed passwords), trip details, itineraries, budgets, expenses, and other travel information are stored on the device and managed by the application. The app does not require an internet connection.

## Development and Testing

The source code follows the MVVM (Model–View–ViewModel) pattern with a repository layer, keeping screens separate from logic and data storage. JUnit is used to test application functionality and verify that individual components behave as expected.

## Project Scope

TravelPlanner focuses on providing a centralized and straightforward trip-planning experience. Travel service providers do not interact directly with the application; users manually organize and maintain their travel information. The application is intended to help individuals, families, and groups of friends manage their travel plans more efficiently.
