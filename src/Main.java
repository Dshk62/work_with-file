import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "D:/input.txt"; // Укажите путь к вашему входному файлу
        String outputFilePath = "D:/out.txt"; // Путь к выходному файлу

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line = br.readLine();
            if (line != null && !line.isEmpty()) {
                // Преобразуем строку в число
                long number = Long.parseLong(line);

                // Записываем число в файл out.txt
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
                    bw.write(Long.toString(number));
                }

                // Получаем последнюю цифру
                int lastDigit = (int) (number % 10);
                System.out.println("Последняя цифра: " + lastDigit);
            } else {
                System.out.println("Входной файл пуст.");
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении или записи файла: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Ошибка формата числа: " + e.getMessage());
        }
    }
}