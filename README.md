# Polynom

Codding by : Tomer Maabari and Ortal Hanoch
Computer since and Math , Ariel Uni

Use
1) gral-core-0.11.jar java library
2) LinePlotTest jaca class
* (For detailed description and examples see Main.java)

#Implements
1) public class Monom implements function
2) public class Monom_Comperator implements Comparator<Monom>
3) public class Polynom implements Polynom_able

#Monom's Constructors:
1) Monom(double a, int b)
2) Monom(Monom ot)

#Monom's Methods:
1) double f(double x)
2) Monom add (Monom m)
3) Monom multiply (Monom m)
4) Monom derivative ()
5) String toString()
6) Monom (String str)

#Polynom's Constructors:
1) Polynom() - Creates "x^0" polynomial, which is exactly "1.0".
2) Polynom (Polynom p) -Creates a*x^deg polynomial.

#Polynom's Methods:
1) double f(double x)-value of polynomial at x
2) add(Polynom_able p1)-Addition
3) add(Monom m1)-Addition Monom to a Polynom
4) substract(Polynom_able p1)-Subtraction
5) multiply(Polynom_able p1)-Multiplication
6) boolean equals(Polynom_able p1)-Compare two polynomial
7) void removeZero()
8) boolean isZero()
9) double root(double x0, double x1, double eps)
10) Polynom_able copy()
11) Polynom_able derivative()
12) double area(double x0, double x1, double eps)
13) double areaUnder(double x0, double x1, double eps)
14) Iterator<Monom> iteretor()
15) String toString()
16) Polynom (String str)
