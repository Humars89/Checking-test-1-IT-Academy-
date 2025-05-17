package com.edu.task.test01;

public class Checking_test01 {

	public static void main(String[] args) {
		// Исходные данные
		String[] dates = { "2024-04-24", "2024-04-25", "2024-04-26", "2024-04-27", "2024-04-28", "2024-04-29",
				"2024-04-30" };
		int[] morningTemps = { 10, 12, 11, 13, 15, 17, 16 };
		int[] dayTemps = { 15, 16, 15, 18, 20, 22, 21 };
		int[] eveningTemps = { 12, 13, 14, 15, 17, 19, 18 };

		// Вычисляем средние температуры
		double[] avgTemps = calculateAverageTemperatures(morningTemps, dayTemps, eveningTemps);

		// Определяем самый длинный период роста
		int[] longestPeriod = findLongestIncreasingPeriod(avgTemps);

		// Выводим результаты
		printAverageTemperatures(dates, avgTemps);
		printLongestIncreasingPeriod(dates, longestPeriod);
	}

	// Метод вычисления средней температуры
	private static double[] calculateAverageTemperatures(int[] morning, int[] day, int[] evening) {
		int length = morning.length;
		double[] avgTemps = new double[length];

		for (int i = 0; i < length; i++) {
			avgTemps[i] = (morning[i] + day[i] + evening[i]) / 3.0;
		}
		return avgTemps;
	}

	// Метод поиска самого длинного периода роста температуры
	private static int[] findLongestIncreasingPeriod(double[] avgTemps) {
		int maxStartIndex = -1, maxLength = 0;
		int currentStartIndex = 0, currentLength = 1;

		for (int i = 1; i < avgTemps.length; i++) {
			if (avgTemps[i] > avgTemps[i - 1]) {
				currentLength++;
			} else {
				if (currentLength > maxLength) {
					maxStartIndex = currentStartIndex;
					maxLength = currentLength;
				}
				currentStartIndex = i;
				currentLength = 1;
			}
		}

		// Проверка последней последовательности
		if (currentLength > maxLength) {
			maxStartIndex = currentStartIndex;
			maxLength = currentLength;
		}

		return new int[] { maxStartIndex, maxLength };
	}

	// Метод вывода средних температур
	private static void printAverageTemperatures(String[] dates, double[] avgTemps) {
		System.out.println("Средние температуры:");
		for (int i = 0; i < dates.length; i++) {
			System.out.printf("%s → %.1f\n", dates[i], avgTemps[i]);
		}
	}

	// Метод вывода информации о самом длинном периоде роста температуры
	private static void printLongestIncreasingPeriod(String[] dates, int[] period) {
		int startIndex = period[0];
		int length = period[1];

		if (length > 1) {
			System.out.println("\nСамый длинный период повышения:");
			System.out.printf("Дата начала: %s\n", dates[startIndex]);
			System.out.printf("Дата конца: %s\n", dates[startIndex + length - 1]);
			System.out.printf("Длина периода: %d дней\n", length);
		} else {
			System.out.println("\nНет периода непрерывного повышения.");
		}
	}
}
