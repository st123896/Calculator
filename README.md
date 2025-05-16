# Calculator App - Android Kotlin

## Overview
A simple yet functional calculator application built with Kotlin for Android. This app performs basic arithmetic operations with a clean user interface.

## Features
- **Basic Operations**: Addition, subtraction, multiplication, and division
- **Additional Functions**: Percentage calculation and sign toggle
- **Decimal Support**: Handles floating-point numbers
- **Error Handling**: Manages division by zero cases
- **Clean UI**: Grid-based layout with color-coded operation buttons
- **Input Validation**: Proper decimal point handling

## Technical Details
- **Language**: Kotlin
- **Minimum SDK**: API 21 (Android 5.0)
- **Architecture**: Single Activity
- **UI**: XML-based layout with Material Design elements

## Installation
1. Clone this repository
2. Open the project in Android Studio (latest version recommended)
3. Build and run the app on an emulator or physical device

## Code Structure
- `MainActivity.kt`: Contains all the calculator logic
- `activity_main.xml`: Defines the calculator layout
- `edittext_border.xml`: Custom drawable for the input field

## Usage
1. Enter numbers using the digit buttons
2. Select an operation (+, -, ×, /)
3. Enter the second number
4. Press "=" to see the result
5. Use "C" to clear the calculator
6. "+/-" toggles the sign of the current number
7. "%" converts the current number to percentage

## Customization
You can easily modify:
- Button colors in `activity_main.xml`
- Input field style in `edittext_border.xml`
- Calculation logic in `MainActivity.kt`



## License
This project is open source and available under the MIT License.

## Contributing
Contributions are welcome! Please fork the repository and submit a pull request.

## Known Issues
- No calculation history
- Limited to basic operations
- No landscape mode support

## Future Enhancements
- Memory functions (M+, M-, MR, MC)
- Scientific calculator functions
- Calculation history
- Theme support (light/dark mode)

## Author
[Tshepiso Zikhali]  
[ST10367205@rcconnect.edu.za]  
