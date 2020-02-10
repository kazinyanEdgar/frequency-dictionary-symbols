import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class FrequencyDictionarySymbols {
    public static void main(String[] args) {

        String pathInput = "C://Users//Edgar//Desktop//frequencyDictionarySymbols//ReadFile.txt";
        String pathOutput = "C://Users//Edgar//Desktop//frequencyDictionarySymbols//WriteFile.txt";

        try (Reader reader = new InputStreamReader(new FileInputStream(pathInput), "windows-1251");
             CounterOutputStream cos = new CounterOutputStream(new FileOutputStream(pathOutput));
             OutputStream os = cos) {

            String initialData = "";
            int i;
            while ((i = reader.read()) != -1)
                initialData += (char) i;

            Map<Character, Integer> map = frequencyDictionary(initialData);

            for (Map.Entry<Character, Integer> item : map.entrySet()) {
                String s = item.getKey() + " встречается " + item.getValue() + " раз(а)" + "\r\n";
                byte[] b = s.getBytes();
                os.write(b);
            }
        } catch (FileNotFoundException e) {
            System.err.println("По указанному ниже пути не удалось найти файл для считывания\n" + pathInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Character, Integer> frequencyDictionary(String initialData) {

        String[] wordsArray = initialData.split("\\s+");

        String singleText = "";
        for (int i = 0; i < wordsArray.length; i++) {
            singleText += wordsArray[i];
        }

        char[] charArray = singleText.toCharArray();
        Map<Character, Integer> hashMap = new TreeMap<>();

        int j = 0;
        while (charArray.length > j) {
            int number = 0;

            for (int i = 0, count = 1; i < charArray.length; i++) {
                if (i != j && charArray[i] == charArray[j])
                    count++;

                number = count;
            }

            hashMap.put(charArray[j], number);
            j++;
        }

        return hashMap;
    }
}