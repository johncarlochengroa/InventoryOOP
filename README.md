# InventoryOOP
**A simple, object-oriented command-line inventory system.** 📦

This project is a basic console application designed to demonstrate fundamental principles of Object-Oriented Programming (OOP) in Java. It allows a user to manage a 4 slot inventory.


<p align="center">
  <img src="https://github.com/user-attachments/assets/8d505378-b608-4865-bfa0-e62cfab1c646" alt="Gemini_Generated_Image_5uopvs5uopvs5uop" width="512" height="512">
</p>


✨ **Features**

* Object-Oriented Design: Utilizes ItemManager class that adapts based on the type of items added, with Food, Tools, and Weapons Class showcasing inheritance and encapsulation. Food, Tools, and Weapons extends Item.
* User-Friendly Interface: Interacts with the user via the command line to add, view, and delete inventory items.
* Dynamic Item Handling: Adapts to different object types depending on the types of the input item.

🚀 **How to Use**

To get this program up and running on your local machine, follow these steps:
* Prerequisites: Ensure you have the Java Development Kit (JDK) installed, as well as IntelliJ IDEA.
* Clone the Repository: Download or clone the project files to your computer using Github Desktop
* Target Repository: In Github Desktop, clone this repository to your IntelliJ IDEA projects folder.
* Run the Program: In IntelliJ IDEA, open the Main.java file, then run by clicking the play icon or "Shift + F10".
* Follow the Prompts: The application will guide you through the process of adding an item, viewing its details, or exiting the program.

📂 **Project Structure**

* Food.java: Defines the Food class, which inherits from Item and includes additional properties for food-specific data.
* Tool.java: Defines the Tool class, which inherits from Item and includes additional properties for tool-specific data.
* Weapon.java: Defines the Weapon class, which inherits from Item and includes additional properties for weapon-specific data.
* Item.java: The parent class for all inventory items, containing fundamental properties like name and quantity.
* ItemManager.java: Contains static methods for handling user input and managing item-related logic.
* Main.java: The main class that drives the application loop and calls the necessary methods.

📝 **Changelog**

Version 8 Milestone 1 (December 12, 2025)

* Rewrote the entire program
* Added everything before except saving

👤 **Credits**

* Author: John Carlo E. Cheng Roa
  
**Note:** This is a demonstration project and is not intended for large-scale or production use.

**AI Note:** This README is created with the help of Google Gemini and ChatGPT.
