# ConcordiaEngineeringWeekCodingChallenge
A coding challenge organized by the Engineering and Computer Science Association (ECA)

A normal enigma machine is comprised of 3 different parts:

1. Input Keyboard

2. Scrambling Unit containing 4 rotation gears (Rotors)

3. Output board

As a mechanical device, the enigma passes the signal given by the keyboard through the
scrambling unit where each rotor will swap the given letter and pass it on until it reaches the
output board were the cyphered letter will appear. The rotors are then rotated clockwise at a
programmable pace.

More on the rotors:
Every gear contains a fixed right side containing the full alphabet and a rotatable left side
containing a random sequence unique for that rotor. The 3 first rotors from right to left are
rotatable units and the last one (called reflector) is fixed and never rotates.

The challenge:
We have intercepted a message from the enemy this morning. Our secret agents have leaked
us the configuration used for their machines. However, the amount of data is far too long to be
deciphered by hand and now we need to use Dr. Turing’s new machines.

Here is what we have:

Rotor I: MNBVCXZQWERTYUIOPLKJHGFDSA

Rotor II: AJDKSIRUXBLHWTMCQGZNPYFVOE

Rotor III: QWERTYUIOPASDFGHJKLZXCVBMN

Reflector: YRUHQSLDPXNGOKMIEBFZCWVJAT

Where Rotor I turns every letter, Rotor II turns every second letter, and Rotor III turns every third
letter.
We have intel confirming that the enemy replaces all space characters with “QQ” before
encrypting the messages.

Your mission is to:

1. Create a program in any language capable of reading a file given through the Command Line arguments and generating a file called enigma.txt with the encrypted or translated version of that file.

2. Submit your code in a zip file with a readme file with the team members’ names as well as instructions on how to run the code.

ATTENTION: We also received information that the file contains secret messages that can
possibly lead to new intel.

EXTRA POINTS: If your solution is capable of reading any given combination of an enigma
machine, you will be awarded extra points. Example: config file where line 1 = Rotor I, line 2 =
Rotor II, line 3 = Rotor3, line 4 = reflector and line 5 = rotation configuration. DOCUMENT YOUR
ASSUMPTIONS IN THE README FILE.

P.S. As this is WAR, time is our most precious resource, a faster and optimized solution will
guarantee us (and you) the victory!

TIP: You can create an extra command line flag to differentiate between translating the message
(reinserting spaces) and encrypting it. Document your changes in the README file.
