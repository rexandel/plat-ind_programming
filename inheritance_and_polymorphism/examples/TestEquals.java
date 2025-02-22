public class TestEquals {
	public static void main(String[] args) {
		MyDateWithEquals first_date_eq = new MyDateWithEquals(7, 11, 2025);
		MyDateWithEquals second_date_eq = new MyDateWithEquals(7, 11, 2025);

		System.out.println("Class using the equals method:");
		if (first_date_eq == second_date_eq) {
			System.out.println("First date == Second date");
		}
		else {
			System.out.println("First date !== Second date");
		}

		if (first_date_eq.equals(second_date_eq)) {
			System.out.println("First date is equal to the second");
		}
		else {
			System.out.println("First date is NOT equal to the second");
		}

		System.out.println();

		System.out.println("Class that does not use the equals method:");

		MyDateWithoutEquals first_date_not_eq = new MyDateWithoutEquals(7, 11, 2025);
		MyDateWithoutEquals second_date_not_eq = new MyDateWithoutEquals(7, 11, 2025);

		if (first_date_not_eq == second_date_not_eq) {
			System.out.println("First date == Second date");
		}
		else {
			System.out.println("First date !== Second date");
		}

		if (first_date_not_eq.equals(second_date_not_eq)) {
			System.out.println("First date is equal to the second");
		}
		else {
			System.out.println("First date is NOT equal to the second");
		}
	}
}