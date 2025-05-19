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
		double[] avgTemps = new double[dates.length];
		for (int i = 0; i < dates.length; i++) {
			avgTemps[i] = (morningTemps[i] + dayTemps[i] + eveningTemps[i]) / 3.0;
		}

		// Поиск самого длинного периода роста температуры
		int maxStart = 0, maxLength = 0;
		int currentStart = 0, currentLength = 1;

		for (int i = 1; i < avgTemps.length; i++) {
			if (avgTemps[i] > avgTemps[i - 1]) {
				currentLength++;
				if (currentLength > maxLength) {
					maxStart = currentStart;
					maxLength = currentLength;
				}
			} else {
				currentStart = i;
				currentLength = 1;
			}
		}

		// Вывод средних температур
		System.out.println("Средние температуры за каждый день:");
		for (int i = 0; i < dates.length; i++) {
			System.out.println(dates[i] + ": " + (Math.round(avgTemps[i] * 10) / 10.0) + "C");
		}

		// Вывод результата анализа
		System.out.println("\nАнализ периода роста температур:");
		if (maxLength > 1) {
			System.out.println("Самый длинный период роста:");
			System.out.println("Начало: " + dates[maxStart]);
			System.out.println("Конец: " + dates[maxStart + maxLength - 1]);
			System.out.println("Длительность: " + maxLength + " дней");
		} else {
			System.out.println("Периодов роста температуры не обнаружено.");
		}
	}
}
