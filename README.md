# Ping Feed Beta

![GitHub repo size](https://img.shields.io/github/repo-size/Israel-Hart/Ping-Feed-Beta)
![GitHub contributors](https://img.shields.io/github/contributors/Israel-Hart/Ping-Feed-Beta)
![GitHub stars](https://img.shields.io/github/stars/Israel-Hart/Ping-Feed-Beta?style=social)
![GitHub forks](https://img.shields.io/github/forks/Israel-Hart/Ping-Feed-Beta?style=social)
![GitHub issues](https://img.shields.io/github/issues/Israel-Hart/Ping-Feed-Beta)
![GitHub license](https://img.shields.io/github/license/Israel-Hart/Ping-Feed-Beta)

A desktop-based GUI application that allows users to ping IP addresses and hostnames to check if they are online within a network.

## Content

 [About](#about)
 
 [Features](#features)
 
 [Getting Started](#getting-started)
  
 [Installation](#installation)
 
 [Usage](#usage)

 [License](#license)


## About

This project is a GUI-based network utility tool designed to help users quickly check the availability of devices on their network. By entering an IP address or hostname, users can ping the specified target to determine if it is online and reachable within the network. The program provides a straightforward interface to streamline network troubleshooting and monitoring. 

## Features

 **Ping IP Addresses and Hostnames**: Quickly check if devices are reachable on the network.
 **Real-Time Status**: Displays the connectivity status of each pinged device.
 **User-Friendly GUI**: Built with Java Swing for a simple and interactive user experience.


## Getting Started

## Prerequisites

 **Java Runtime Environment (JRE)**: Ensure that the Java Runtime Environment (JRE) is installed on your machine to run the `.jar` file. The minimum required version is JRE 8 or higher.
   [Download JRE](https://www.oracle.com/java/technologies/javase-jre8-downloads.html)
   To check if Java is installed, run the following command:
    ```bash
    java -version
    ```
    If Java is installed correctly, you should see the version information. If not, you will need to install it.

 **Operating System**: This program is cross-platform and can run on Windows, macOS, or Linux, as long as the JRE is installed.

 **No IDE Required**: Since the program is packaged as a `.jar` file, you do not need an Integrated Development Environment (IDE) to run it. However, if you'd like to modify the source code, any Java-compatible IDE will work, such as:
  - [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
  - [Eclipse](https://www.eclipse.org/downloads/)
  - [NetBeans](https://netbeans.apache.org/download/index.html)

 **Command Line or File Explorer**: You can run the `.jar` file either via the command line or by double-clicking the `.jar` file (depending on your operating system and settings).

 **Basic Networking Knowledge**: Since this application pings IP addresses and hostnames, some understanding of networking concepts (such as IP addresses, hostnames, and pinging) is useful.

### Installation

1. **Download and Run `.jar`**:
    - Download the pre-built `PingFeedBeta.jar` from the [releases page](https://github.com/Israel-Hart/Ping-Feed-Beta/releases) (coming soon).
    - Run with:
      ```bash
      java -jar PingFeedBeta.jar
      ```

## Usage

1. **Start the Application**:
    - Double-click the `PingFeedBeta.jar` file, or run `java -jar PingFeedBeta.jar` from the command line.

2. **Add Hosts**:
    - Enter an IP address or hostname.
    - Click “Ping” to ping host.

3. **View Status**:
    - The GUI will show the status (reachable or unreachable) for the host.

## License

This project is licensed under the MIT License. This means:

- **Permissions**: Free to use, modify, and distribute, including for commercial purposes.
- **Conditions**: A copy of this license must be included with substantial portions of the software.
- **Limitations**: The software is provided "as is," without warranty of any kind.

For the full license text, please see the [LICENSE](LICENSE) file.

