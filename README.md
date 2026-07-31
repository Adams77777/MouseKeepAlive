# MouseKeepAlive

> A lightweight Java utility that prevents the desktop from
> locking due to inactivity. After 4 minutes of inactivity,
> it moves the mouse cursor to generate activity.

![Java](https://img.shields.io/badge/Java-8%2B-blue)
![Platform](https://img.shields.io/badge/Platform-Windows%20%7C%20Linux%20%28X11%29%20%7C%20macOS-lightgrey)
![License](https://img.shields.io/badge/License-MIT-green)

------------------------------------------------------------------------

## Table of Contents

-   [Overview](#overview)
-   [Features](#features)
-   [Requirements](#requirements)
-   [Installation](#installation)
-   [Usage](#usage)
-   [How It Works](#how-it-works)
-   [Configuration](#configuration)
-   [Project Structure](#project-structure)
-   [Platform Notes](#platform-notes)
-   [Possible Improvements](#possible-improvements)
-   [License](#license)

------------------------------------------------------------------------

## Overview

**MouseKeepAlive** is a simple Java application that continuously
monitors mouse activity.

Every **4 minutes**, it checks whether the mouse cursor has moved:

-   If the user has been active, nothing happens.
-   If no movement is detected, the application performs a few small
    random cursor movements.
-   If the user touches the mouse during these movements, the
    application immediately stops moving the cursor and returns to
    monitoring mode.

The application is intended to run continuously in the background with
minimal resource usage.

------------------------------------------------------------------------

## Features

-   Continuous background execution
-   User inactivity detection
-   Automatic random mouse movement after inactivity
-   Immediate interruption when user activity is detected
-   Lightweight implementation
-   No external dependencies
-   Uses only the Java Standard Library (`java.awt.Robot`)

------------------------------------------------------------------------

## Requirements

-   Java 8 or newer
-   Desktop graphical environment
-   Permission to control the mouse cursor (depending on the operating
    system)

------------------------------------------------------------------------

## Installation

``` bash
git clone https://github.com/<your-username>/MouseKeepAlive.git
cd MouseKeepAlive
javac MouseKeepAlive.java
```

------------------------------------------------------------------------

## Usage

``` bash
java MouseKeepAlive
```

------------------------------------------------------------------------

## How It Works

1.  Store the current mouse position.
2.  Wait 4 minutes.
3.  Check whether the mouse has moved.
4.  If the mouse has moved, continue monitoring.
5.  Otherwise, perform 3--7 small random cursor movements.
6.  Stop immediately if user activity is detected.

------------------------------------------------------------------------

## Configuration

  Constant           Description                      Default
  ------------------ -------------------------------- -----------
  `CHECK_INTERVAL`   Time between activity checks     4 minutes
  `MAX_OFFSET`       Maximum random cursor movement   15 pixels

------------------------------------------------------------------------

## Project Structure

``` text
MouseKeepAlive/
├── MouseKeepAlive.java
├── README.md
└── LICENSE
```

------------------------------------------------------------------------

## Platform Notes

### Windows

Works without additional configuration in most cases.

### Linux

Works correctly on most X11 desktop environments.

Some Wayland environments intentionally block synthetic mouse events.

### macOS

The application may require Accessibility permission.

------------------------------------------------------------------------

## Possible Improvements

-   System tray icon
-   Pause / Resume
-   Configurable inactivity timeout
-   Configurable movement distance
-   Configuration file
-   Logging
-   Swing or JavaFX GUI
-   Automatic startup with the operating system
-   Multi-monitor support

------------------------------------------------------------------------

## License

This project is licensed under the **MIT License**.

Feel free to use, modify, and distribute it.
