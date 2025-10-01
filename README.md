# InventoryOOP
**A simple, object-oriented command-line inventory system.** 📦

This project is a basic console application designed to demonstrate fundamental principles of Object-Oriented Programming (OOP) in Java. It allows a user to manage a single item in an inventory, with special handling for "Food" items that have unique properties.


<p align="center">
  <img src="https://github.com/user-attachments/assets/8d505378-b608-4865-bfa0-e62cfab1c646" alt="Gemini_Generated_Image_5uopvs5uopvs5uop" width="512" height="512">
</p>


✨ **Features**

* Object-Oriented Design: Utilizes Item and Food classes, showcasing inheritance and encapsulation. Food extends Item, inheriting its core properties while adding specific attributes like calories and dietary information.
* User-Friendly Interface: Interacts with the user via the command line to add, view, and delete inventory items.
* Data Persistence: Automatically saves the current inventory item to a save.txt file, ensuring your data is not lost between sessions.
* Dynamic Item Handling: Recognizes when a new item is "FOOD" and prompts for additional, relevant details.

🚀 **How to Use**

To get this program up and running on your local machine, follow these steps:
* Prerequisites: Ensure you have the Java Development Kit (JDK) installed, as well as IntelliJ IDEA.
* Clone the Repository: Download or clone the project files to your computer using Github Desktop
* Target Repository: In Github Desktop, clone this repository to your IntelliJ IDEA projects folder.
* Run the Program: In IntelliJ IDEA, open the Main.java file, then run by clicking the play icon or "Shift + F10".
* Follow the Prompts: The application will guide you through the process of adding an item, viewing its details, or exiting the program.

📂 **Project Structure**

* Food.java: Defines the Food class, which inherits from Item and includes additional properties for food-specific data.
* Item.java: The parent class for all inventory items, containing fundamental properties like name, description, and quantity.
* ItemManager.java: Contains static methods for handling user input and managing item-related logic.
* Main.java: The main class that drives the application loop and calls the necessary methods.
* SaveManager.java: Handles the reading from and writing to the save.txt file for data persistence.

👤 **Credits**

* Author: John Carlo E. Cheng Roa
* Version: 5 Patch 2
* Last Updated: October 1, 2025

**Note:** This is a demonstration project and is not intended for large-scale or production use.

**AI Note:** This README is generated using Google Gemini.
