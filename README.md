> This projet is abandoned due to Starbound launching their own dedicated server software. The current usability of this code is undetermined and incomplete.

# Star Sector
Star Sector aims to be an intuitive Starbound server wrapper. This wrapper comes bundled with adminstration and user commands. It is designed to run on Windows, Mac, and Linux operating systems. [Installation](#installation) takes a seconds with the only [dependancy](#requirements) being Java. If you wish a command or action was included in the wrapper, Star Sector comes with its own command and plugin API for you to utilize. View the extensive list of features [here](#features) and all the commands [here](#commands).

Licensed under the [MIT](https://github.com/RyanPrintup/Star-Sector/blob/master/LICENSE.md) License, this project is open source.

For help with the API, view the [wiki](#).

# Requirements
- Java

# Installation
The Installation guide is located on the [wiki](#w).

# Features
- Automates Starbound process
	- Starts Starbound server
	- Writes Starbound configuration
- Configuration for full flexibility
- Administration and user commands
	- Ban & kick players
	- Private message players
	- View the full command list [here](#commands).
- Logs all server actions including chat, commands, connects, and more!
- Notifies you when a new version has been released
- Command and plugin API

# Commands
### Player commands
- /message <player> <message> - Sends a private message to <player>
- /help <command> - Shows a list of commands. Optionally show help for <command>.
- /players - Shows a list of online players

### Admin commands
- /ip <player> - Show the ip address of <player>
- /kick <player> - Kicks <player> from the server
- /restart <seconds> - Restarts the server. Optional countdown of <seconds>
- /say <message> - Send a message to all players
- /start - Start the server
- /stop - Stops the server
