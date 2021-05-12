import java.util.List;

class WordsCounter {
    long count(List<String> lines, String wordToCount) {
        if (wordToCount == null || lines == null) {
            throw new IllegalArgumentException("Nothing to count");
        } else if (!wordToCount.matches("[a-zA-ZА-Яа-я]*")) {
            throw new IllegalArgumentException("Can count only words");
        }

        long count = 0;
        for (var line : lines) {
            if (line != null && line.length() > 1) {
                var words = line.split(" ");
                for (var word: words) {
                    if (word.equals(wordToCount)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
