package com.innopolis.tests.selections;


import java.util.Scanner;

public class olimpQ2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // вводим с клавы n и a,b
        int n = scanner.nextInt();

        // заполняем массивы
        int[] types = new int[n];
        int[] taste = new int[n];
        for (int i = 0; i < n; i++) {
            types[i]=scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            taste[i]=scanner.nextInt();
        }

        // сортируем все массивы по вкусности
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (taste[i]<taste[j]) {
                    // сначала переставляем местами элементы массива "вкус"
                    int temp = taste[i];
                    taste[i]=taste[j];
                    taste[j]=temp;
                    // затем синхронизируем расположение элементов и в массиве "тип"
                    temp = types[i];
                    types[i]=types[j];
                    types[j]=temp;
        }}}

        // создаём массив для уникальных типов размером 101, т.к. нам может быть нужен индекс 100.
        int[] uniq = new int[101];

        // если бургеры с положительной вкусностью отсутствует, то макс полезность = 0
        int posA = 0;
        int countUniq = 0; // счётчик уникальных типов
        int lastPosIndex = 0;

        for (int i = 0; i < n; i++) {
            // проверяем положительность значения вкуса
            if (taste[i]>=0) {
                // проверяем уникальность типа через массив uniq
                // если не встречался, то добавляем +1 в uniq и +1 в счётчик уникальных типов
                if (uniq[types[i]] == 0) {
                    uniq[types[i]]+=1;
                    countUniq+=1;
                }
                // суммируем вкусность положительных гамбургеров
                posA = posA + taste[i];
                // в конце цикла lastPosIndex будет хранить индекс последнего положительного значения вкуса
                lastPosIndex = i;
            } else break; // завершаем цикл, если i-ый элемент отрицательный
        }

        // если нет положительных в массиве, то выводим max = 0
        if (posA == 0) {
            System.out.println(0);
        }
        // если есть, то продолжаем выяснять самый max
        else {
            // считаем максимум удовольствия только для позитивных значений
            int posMax = countUniq*posA;
            // создаём переменные для работы с отрицательными числами
            int biggerMax = posMax; // аналог posMax, но включающий отрицательные
            int countUniqAdd = countUniq; // прибавляем уникальные типы из отрицательных вкусов сюда
            int A = posA; // сумма вкусов, теперь с отрицательными значениями

            // делаем цикл для прохода по отрицательным
            for (int i = 1; i <= n-lastPosIndex; i++) {
                if ((lastPosIndex+i)>(n-1)) break; // проверка на выход за пределы массива
                if (uniq[types[lastPosIndex+i]]==1) { // если тип неуникальный, то он не нужен
                    continue;
                }
                if (uniq[types[lastPosIndex+i]]==0) { // если уникальный, то пробуем посчитать удовольствие
                    countUniqAdd+=1;
                    A = A + taste[lastPosIndex+i];
                    biggerMax=countUniqAdd*A;
                    if (biggerMax>posMax) { // если с отрицательным наш максимум стал больше, то присвоим posMax новое значение
                        posMax = biggerMax;
                        continue;
                    }
                    else break; // завершаем цикл, если получаем меньший результат, чем был
                }
            }
            System.out.println(posMax); // выводим на экран максимум
        }
    }
}
