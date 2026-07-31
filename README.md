MouseKeepAlive

    A lightweight Java utility that prevents the mouse cursor from remaining idle by performing small random movements only after a period of user inactivity.

Java
Platform
License
Table of Contents

    Overview

    Features

    Requirements

    Installation

    Usage

    How It Works

    Configuration

    Project Structure

    Platform Notes

    Possible Improvements

    License

Overview

MouseKeepAlive is a simple Java application that continuously monitors mouse activity.

Every 4 minutes, it checks whether the mouse cursor has moved:

    ✅ If the user has been active, nothing happens.

    ✅ If no movement is detected, the application performs a few small random cursor movements.

    ✅ If the user touches the mouse during these movements, the application immediately stops moving the cursor and returns to monitoring mode.

The application is intended to run continuously in the background with minimal resource usage.
Features

    Continuous background execution

    User inactivity detection

    Automatic random mouse movement after inactivity

    Immediate interruption when user activity is detected

    Lightweight implementation

    No external dependencies

    Uses only the Java Standard Library (java.awt.Robot)

Requirements

    Java 8 or newer

    Desktop graphical environment

    Permission to control the mouse cursor (depending on the operating system)

Installation

Clone the repository:

git clone https://github.com/<your-username>/MouseKeepAlive.git

Navigate to the project directory:

cd MouseKeepAlive

Compile the application:

javac MouseKeepAlive.java

Usage

Run the application:

java MouseKeepAlive

The program starts monitoring immediately and continues running until it is manually terminated.
How It Works

Start
   │
   ▼
Store current mouse position
   │
   ▼
Wait 4 minutes
   │
   ▼
Has the mouse moved?
   │
 ┌─┴──────────────┐
 │                │
Yes              No
 │                │
 ▼                ▼
Update         Perform
position       random moves
 │                │
 │        User moves mouse?
 │                │
 └───────┬────────┘
         ▼
Repeat

Configuration

The application's behavior is controlled by two constants:
Constant	Description	Default
CHECK_INTERVAL	Time between activity checks	4 minutes
MAX_OFFSET	Maximum random cursor movement	15 pixels

Example:

private static final long CHECK_INTERVAL = 4 * 60 * 1000;
private static final int MAX_OFFSET = 15;

Project Structure

MouseKeepAlive/
│
├── MouseKeepAlive.java
├── README.md
└── LICENSE

Platform Notes
Windows

Works without additional configuration in most cases.
Linux

Works correctly on most X11 desktop environments.

Some Wayland environments intentionally block applications from generating synthetic mouse events.
macOS

The application may require Accessibility permission:

System Settings → Privacy & Security → Accessibility
Possible Improvements

    System tray icon

    Pause / Resume

    Configurable inactivity timeout

    Configurable movement distance

    Configuration file

    Logging

    Swing or JavaFX GUI

    Automatic startup with the operating system

    Multi-monitor awareness

    Randomized movement timing

    Unit tests

License

This project is licensed under the MIT License.

Feel free to use, modify, and distribute it.
Author

Created with Java using the standard java.awt.Robot API.
