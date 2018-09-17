import java.util.StringTokenizer;

/**
 * This class has 15 methods related by the fact that CSC 210 students are
 * learning the algorithmic patterns Guarded Selection, Alternative Selection,
 * Multiple Selection using the Java programming language.
 * 
 * The methods will specifically use the if and if..else statements written is
 * virtually all languages because these algorithmic patterns occur so
 * frequently while developing software.
 * 
 * There are several silly contrived methods and several possibly useful
 * methods.
 * 
 * @author Pratyush Singh
 */
public class ControlFun2 {

	// Given 2 strings, a and b, return a string of the form short+long+short, with
	// the shorter string on the outside and the longer string on the inside. The
	// strings will not be the same length, but they may be empty (length() == 0).
	//
	// comboString("Hello", "hi") returns "hiHellohi"
	// comboString("hi", "Hello") returns "hiHellohi"
	// comboString("aaa", "b") returns "baaab"
	//
	// Precondition: a.length() != b.length()
	//
	public String comboString(String a, String b) {
		int lenA = a.length();
		int lenB = b.length();
		String ret = "";
		if (lenA == lenB) {
			return ret;
		}

		if (lenA < lenB) {
			ret = a + b + a;
		} else if (lenB < lenA) {
			ret = b + a + b;
		}

		return ret;
	}

	// Given 2 ints, a and b, return their sum. However, sums in the range 10..19
	// inclusive, are forbidden. In that case just return 20.
	//
	// sortaSum(3, 4) returns 7
	// sortaSum(9, 4) returns 20
	// sortaSum(10, 11) returns 21
	//
	public int sortaSum(int a, int b) {
		int sum = a + b;
		if (sum >= 10 && sum <= 19)
			return 20;
		return sum;
	}

	// Given two strings, append them together ("concatenation") and return the
	// result. However, if the strings are different lengths, omit the beginning
	// chars from the longer string so it is the same length as the shorter string.
	// So "Hello" and "Hi" yield "loHi". The strings may be any length.
	//
	// minCat("Hello", "Hi") returns "loHi"
	// minCat("Hello", "java") returns "ellojava"
	// minCat("java", "Hello") returns "javaello"
	//
	public String minCat(String a, String b) {
		int lenA = a.length();
		int lenB = b.length();

		if (lenA < lenB) {
			return a + b.substring(lenB - lenA, b.length());
		} else if (lenB < lenA) {
			return a.substring(lenA - lenB, a.length()) + b;
		}
		return a + b;
	}

	// Given three String arguments, return the String that lexicographically
	// precedes or is equal to the other two string arguments.
	//
	// firstOf3String("a", "b", "c") returns "a"
	// firstOf3String("X", "b", "c") returns "X"
	// firstOf3String("123", "1231", "123 0") returns "123"
	//
	// You will need to use Strings compareTo method.
	//
	public String firstOf3Strings(String a, String b, String c) {
		String ret = "";
		if (a.compareTo(b) <= 0 && (a.compareTo(c) <= 0)) {
			ret = a;
		} else if (b.compareTo(a) <= 0 && (b.compareTo(c) <= 0)) {
			ret = b;
		} else {
			ret = c;
		}
		return ret;
	}

	// Your cell phone rings. Return true if you should answer it. Normally you
	// answer, except in the morning you only answer if it is your mom calling. In
	// all cases, if you are asleep, you do not answer.
	//
	// answerCell(false, false, false) returns true
	// answerCell(false, false, true) returns false
	// answerCell(true, false, false) returns false
	//
	public boolean answerOrNot(boolean isMorning, boolean isMom, boolean isAsleep) {
		if (isAsleep) {
			return false;
		}
		if (isMorning && !isMom) {
			return false;
		}

		return true;
	}

	// Complete method letterGrade that returns the proper letter grade as a string
	// for a plus/minus system with the following scale:
	//
	// Percentage.............. Grade
	// 93.0 ≤ percentage ...... A
	// 90.0 ≤ percentage < 93.0 A-
	// 87.0 ≤ percentage < 90.0 B+
	// 83.0 ≤ percentage < 87.0 B
	// 80.0 ≤ percentage < 83.0 B-
	// 77.0 ≤ percentage < 80.0 C+
	// 70.0 ≤ percentage < 77.0 C
	// 60.0 ≤ percentage < 70.0 D
	// 70.0 D percentage < 60.0 E
	//
	// Precondition: percentage is in the range of 0.0 through 100.0
	//
	public String letterGrade(double percentage) {
		String ret = "";
		if (percentage >= 93) {
			ret = "A";
		} else if (percentage >= 90) {
			ret = "A-";
		} else if (percentage >= 87) {
			ret = "B+";
		} else if (percentage >= 83) {
			ret = "B";
		} else if (percentage >= 80) {
			ret = "B-";
		} else if (percentage >= 77) {
			ret = "C+";
		} else if (percentage >= 70) {
			ret = "C";
		} else if (percentage >= 60) {
			ret = "D";
		} else if (percentage < 60) {
			ret = "E";
		}

		return ret;
	}

	// Given a string str,if the string starts with"f", return"Fizz".
	// If the string ends with"b", return"Buzz". If both the"f" and "b"
	// conditions are true,return"FizzBuzz". In all other cases,return
	// the string unchanged.
	//
	// fizzString("fig") returns "Fizz"
	//
	// fizzString("dib") returns "Buzz"
	//
	// fizzString("fib") returns "FizzBuzz"
	//
	public String fizzBuzz(String str) {
		boolean fCond = str.startsWith("f");
		boolean bCond = str.endsWith("b");
		String ret = "";
		if (fCond && bCond) {
			ret = "FizzBuzz";
		} else if (fCond) {
			ret = "Fizz";
		} else if (bCond) {
			ret = "Buzz";
		} else {
			ret = str;
		}
		return ret;
	}

	// Complete the free function salary that returns a salesperson’s salary
	// for the month according to the following policy:
	//
	// Sales . .But
	// Over . . Not Over . . Monthly Salary
	// ======= .======== . . ==============
	// 0 .. . . 10,000 . . . Base salary
	// 10,000 . 20,000 . . . Base salary plus 5% of sales over 10,000
	// 20,000 . 30,000 . . . Base salary plus 500.00 plus 8% of sales over 20,000
	// 30,000 . . . . . . .. Base salary plus 1300.00 plus 12% of sales over 30,000
	//
	// The base salary is $1,500.00, which means salary returns a value that
	// is never less than 1500.00. When sales are over $10,000, commission is
	// added to the base salary. For example, when sales equals 10001, the
	// monthly salary is $1,500.00 + 5% of $1.00 for a total of $1,500.05,
	// and when sales is 20001, the monthly salary is $1,500.00 + $500.00 + 8%
	// of $1.00 for a total of $2,000.08.
	//
	// Precondition: sales >= 0.0 (never negative)
	//
	public double salary(double sales) {
		if (sales < 0.0) {
			return 0.0;
		}
		double baseSalary = 1500.00;
		double salaryMonthly = 0.0;
		if (sales > 30000) {
			salaryMonthly = baseSalary + 1300 + ((sales - 30000) / 100.0) * 12;
		} else if (sales > 20000) {
			salaryMonthly = baseSalary + 500 + ((sales - 20000) / 100.0) * 8;
		} else if (sales > 10000) {
			salaryMonthly = baseSalary + ((sales - 10000) / 100.0) * 5;
		} else {
			salaryMonthly = baseSalary;
		}

		return salaryMonthly;
	}

	// Complete the free function romanNumeral that returns the numeric
	// equivalent of an upper- or lower-case Roman numeral, which is actually
	// a char. Roman numerals and their decimal equivalents are
	//
	// 'I' (or 'i') = 1
	// 'V' (or 'v') = 5
	// 'X' (or 'x') = 10
	// 'L' (or 'l') = 50
	// 'C' (or 'c') = 100
	// 'D' or ('d') = 500
	// 'M' (or 'm') = 1,000
	//
	// Precondition: numeral is one of the valid 14 Roman numerals shown above
	//
	public int romanNumeral(char numeral) {
		char lowerCaseNumeral = Character.toLowerCase(numeral);
		int numericRom = 0;
		if (lowerCaseNumeral == 'i' || lowerCaseNumeral == 'v' || lowerCaseNumeral == 'x' || lowerCaseNumeral == 'l'
				|| lowerCaseNumeral == 'c' || lowerCaseNumeral == 'd' || lowerCaseNumeral == 'm') {

			if (lowerCaseNumeral == 'i') {
				numericRom = 1;
			} else if (lowerCaseNumeral == 'v') {
				numericRom = 5;
			} else if (lowerCaseNumeral == 'x') {
				numericRom = 10;
			} else if (lowerCaseNumeral == 'l') {
				numericRom = 50;
			} else if (lowerCaseNumeral == 'c') {
				numericRom = 100;
			} else if (lowerCaseNumeral == 'd') {
				numericRom = 500;
			} else if (lowerCaseNumeral == 'm') {
				numericRom = 1000;
			}
		}

		return numericRom;
	}

	/////////////////////////////////////////////
	// And now for some Calendar functions
	/////////////////////////////////////////////

	// dayOfWeek returns the string "Monday" if the int argument passed to the
	// parameter dayNumber is 1, return "Tuesday" if the argument 2, and so on up
	// through returning "Sunday" if the argument is 7. This is case sensitive.
	//
	// dayOfWeek(1) returns "Monday"
	// dayOfWeek(2) returns "Tuesday"
	// dayOfWeek(3) returns "Wednesday"
	// dayOfWeek(4) returns "Thursday"
	// dayOfWeek(5) returns "Friday"
	// dayOfWeek(6) returns "Saturday"
	// dayOfWeek(7) returns "Sunday"
	//
	// Precondition: dayNumber is in the range of 1 through 7
	//
	public String dayOfWeek(int dayNumber) {
		// TODO: Complete this method
		String day = "";
		if (dayNumber < 1 || dayNumber > 7) {
			return "Unknown";
		}
		if (dayNumber == 1) {
			day = "Monday";
		} else if (dayNumber == 2) {
			day = "Tuesday";
		} else if (dayNumber == 3) {
			day = "Wednesday";
		} else if (dayNumber == 4) {
			day = "Thursday";
		} else if (dayNumber == 5) {
			day = "Friday";
		} else if (dayNumber == 6) {
			day = "Saturday";
		} else if (dayNumber == 7) {
			day = "Sunday";
		}
		return day;
	}

	// In the US, Thanksgiving falls on the 4th Thursday of each November. Complete
	// method thanksDate that determines the day of the month that Thanksgiving
	// falls on no matter the day on which November begins. November can begin on
	// any day where 1 represents Monday, through 7 that represents Sunday. A valid
	// call would be thanksDate(1) to indicate the first day of November is Monday.
	//
	// Arguments can only be 1 (for Monday) through 7 (for Sunday).

	// When 1-Nov is Monday thanksDate(1) returns 25
	// When 1-Nov is Tuesday thanksDate(2) returns 24
	// When 1-Nov is wednesday thanksDate(3) returns 23
	// When 1-Nov is Thursday, thanksDate(4) returns 22
	// When 1-Nov is Friday, thanksDate(5) returns 28
	// When 1-Nov is saturday, thanksDate(6) returns 27
	// When 1-Nov is Sunday thanksDate(7) returns 26

	//
	// Precondition: day is in the range of 1 through 7.
	//
	public int thanksDate(int day) {
		if (day < 1 || day > 7) {
			return 0;
		}

		int thankDate = 0;
		if (day < 5) {
			thankDate = 21 + 5 - day;
		} else {
			thankDate = 28 - (day - 5);
		}

		return thankDate;
	}

	// Given an integer for the month (1 is January and 12 is December) and a
	// Boolean argument that when true represents the northern hemisphere, return
	// the current season in that hemisphere using the table below.
	//
	// month ........inNorthernHemisphere | !inNorthernHemisphere
	// ============ | ====================| =====================
	// 12, 1, or 2 .| "Winter" ...........| "Summer"
	// . 3, 4, or 5 | "Spring" ...........| "Fall"
	// . 6, 7, or 8 | "Summer" ...........| "Winter"
	// 9, 10, or 11 | "Fall" .............| "Spring"
	//
	// Precondition: month is in the range of 1 through 12 inclusive.
	//
	public String season(int month, boolean inNorthernHemisphere) {
		if (month < 1 || month > 12) {
			return "Unknown";
		}
		String ret = "";
		if (inNorthernHemisphere) {
			if (month == 12 || month == 1 || month == 2) {
				ret = "Winter";
			} else if (month == 3 || month == 4 || month == 5) {
				ret = "Spring";
			} else if (month == 6 || month == 7 || month == 8) {
				ret = "Summer";
			} else if (month == 9 || month == 10 || month == 11) {
				ret = "Fall";
			}
		} else {
			if (month == 12 || month == 1 || month == 2) {
				ret = "Summer";
			} else if (month == 3 || month == 4 || month == 5) {
				ret = "Fall";
			} else if (month == 6 || month == 7 || month == 8) {
				ret = "Winter";
			} else if (month == 9 || month == 10 || month == 11) {
				ret = "Spring";
			}
		}

		return ret;
	}

	// Complete method daysInMonth to return the number of days in a month for the
	// given year. There are 30 days in the months September, April, June, and
	// November, or months 9, 4, 6, and 11. February has 28 days unless it is a leap
	// year when it has 29. All other months 1 (Janurary), 3, 5, 7, 8, 10,
	// and 12 (December) have 31 days. Assume the year is always >= 1582, the
	// year this type of calendar started.
	//
	// daysInMonth(1, 2020) returns 31
	// daysInMonth(2, 2019) returns 28
	// daysInMonth(2, 2016) returns 29
	//
	// Preconditions: m is the range of 1 through 12 and year >= 1582
	//
	public int daysInMonth(int m, int year) {
		if (m < 1 || m > 12 || year < 1582) {
			return 0;
		}

		boolean isLeapYear = (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
		int days = 0;

		if (isLeapYear && m == 2) {
			days = 29;
		} else if (m == 2) {
			days = 28;
		} else if (m == 9 || m == 4 || m == 6 || m == 11) {
			days = 30;
		} else {
			days = 31;
		}

		return days;
	}

	// Complete method dayNumber to return how many days a valid date is into
	// the year. If the string argument is not a value date, return -1.
	//
	// dayNumber("01/03/2016")returns 3
	// dayNumber("12/31/2017")returns 365
	// dayNumber("12/31/2020") returns 366
	// dayNumber("13/11/2020") returns -1
	//
	// Repeating: If the string argument is not a value date, return -1.
	//
	// Precondition: date has a length() of 10 with "/" at index 2 and 5,
	// and only digits 0 through 9 in the other 8 indexes.
	//
	public int dayNumber(String date) {
		if (!validDate(date)) {
			return -1;
		}

		StringTokenizer st = new StringTokenizer(date);
		int month = Integer.parseInt(st.nextToken("/"));
		int day = Integer.parseInt(st.nextToken("/"));
		int year = Integer.parseInt(st.nextToken("/"));

		int days = 0;
		for (int i = 1; i < month; i++) {
			days += daysInMonth(i, year);
		}
		days += day;

		return days;
	}

	// Write function validDate to return true if the string argument is
	// a valid calendar date. The arguments always take the form of month, day,
	// and year as positive integers separated by / as in "mm/dd/yyyy".
	// If the String argument does not express a valid date, return false.
	//
	// You will need the static method Integer.parseInt(String possibleInt) that
	// returns the integer value of the string argument. For example,
	// Integer.parseInt("08") returns 8 and Integer.parseInt("2021") returns 2021.
	//
	// validDate("01/31/2016") returns true
	// validDate("12/31/2017") returns true
	// validDate("06/15/2018") returns true
	// validDate("02/28/2019") returns true
	// validDate("02/29/2019") returns false
	// validDate("2019/06/06") returns false
	// validDate("02/29/2100") returns false
	// validDate("13/02/2019") returns false
	// validDate("12/32/2019") returns false
	//
	// Precondition: date has a length() of 10 with "/" at index 2 and 5,
	// and only digits 0 through 9 in the other 8 indexes.
	//
	public boolean validDate(String date) {
		if (date.length() == 10) {
			for (int i = 0; i < date.length(); i++) {

				if (i == 2 || i == 5) {
					if (date.charAt(i) != '/') {
						return false;
					}
				} else {
					if (!Character.isDigit(date.charAt(i))) {
						return false;
					}
				}

			}
		} else {
			return false;
		}

		StringTokenizer st = new StringTokenizer(date);
		int month = Integer.parseInt(st.nextToken("/"));
		int day = Integer.parseInt(st.nextToken("/"));
		int year = Integer.parseInt(st.nextToken("/"));

		if (month < 1 || month > 12 || year < 1582) {
			return false;
		}

		boolean isLeapYear = (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));

		if (isLeapYear && month == 2) {
			if (day < 0 || day > 29) {
				return false;
			}
		} else if (month == 2) {
			if (day < 0 || day > 28) {
				return false;
			}

		} else if ((month == 9 || month == 4 || month == 6 || month == 11)) {
			if (day < 0 || day > 30) {
				return false;
			}
		} else if (day < 0 || day > 31) {
			return false;
		}
		return true;
	}

}