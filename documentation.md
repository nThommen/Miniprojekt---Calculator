## Model Class

#### Variables

**The Stringbuilder current:**
What is currently displayed on screen. Dynamically adds new characters as the user clicks on them.

**The String calc:**
Only needed as a middle step to split the StringBuilder current into the ArrayList calcParts.

**The Arraylist calcParts:**
Mainly important for the method calculate in the Controller Class. It's an ArrayList of which the entries are the numbers that have been typed by the users and the corresponding operators between them.

**The boolean calculated:**
Tracks whether or not the last button pressed was "=". This serves to automatically erase the displayed result upon another button being pressed.

#### Methods

**updateCalcParts():**
Converts the current StringBuilder "current" to a String, then splits it into an ArrayList to prepare it for the calculate()-method of the Controller class.

**isInteger:**
Can't currently remember if still needed - will check once at desktop.


## View Class

Code self-explanatory except for...

**init():**
The for-loop needs explanation: It simply iterates over the entire JButton-array "buttons", adding an ActionListener to and placing each one in the gridBagLayout. The if- and else if-statements each are responsible for their respective row in the layout.


## Controller Class

#### Methods:

**clear():**
Resets "calcParts" and "current".

**clearEntry():**
Not yet fully implemented. Supposed to erase the last entry in "current".

**calculate():**
Gets called by pressing "=".

Calls "updateCalcParts" (ref. Model).
Instantiates an Int "i", a String "part" and three doubles "leftOperand", "rightOperand" and "res". Those are needed for the following for-loops, which happen from highest to lowest order of operation.

**addSymbol():**
Gets called by the method "handleButtonEvent" by default and appends "current" by the symbol of the pressed button.

**handleButtonEvent():**
Handles the button events through a Switch-case event.