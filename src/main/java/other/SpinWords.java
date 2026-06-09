package other;



// Разворачивает каждое слово в предложении

public class SpinWords {

    public String spinWords(String sentence) {
        String[] arrWords = sentence.split("\\s");
        StringBuilder resultSb = new StringBuilder();
        for (String curentWord : arrWords
        ) {
            if (curentWord.length() >= 5) {
                StringBuilder currentSb = new StringBuilder(curentWord);
                resultSb.append(currentSb.reverse());
            } else {
                resultSb.append(curentWord);
            }
            resultSb.append(" ");
        }
        return resultSb.toString().trim();
    }

}
