import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise3 {

    /*
    implement the method below so that it extracts a URL from a String
    I willrite the basics for this one method, you will have to implement the other two methods from scratch
    */

    public static String extractURL(String text) {
        String regex = "((http|https)://)(www.)?[-a-zA-Z0-9@:%._+~#?&/=]*\\.[a-z]{2,6}[-a-zA-Z0-9@:%._+~#?&/=]*";  // TODO

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return matcher.group();
        }
        else{
            return null;
        }
    }

    /*
    implement the method below to validate an email address
     */

    public static boolean validateEmail(String email) {
        String regex = "[-a-zA-Z0-9._?&]*@[-a-zA-Z0-9._]*";  // TODO

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    /*
    implement the method below so that it returns a list of words with repeated letters
    */

    public static List<String> findWordsWithRepeatLetters(String input) {

        var regex = "\\b\\w+\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> wordsWithRepeatLetters = new ArrayList<>();
        while(matcher.find()){
            var hasReLetters = false;
            var word = matcher.group();
            for (var i = 0; i < word.length(); i++) {
                for (var j = i + 1; j < word.length(); j++) {
                    if (word.charAt(i) == word.charAt(j)) {
                        hasReLetters = true;
                    }
                }
            }
            if (hasReLetters){
                wordsWithRepeatLetters.add(word);
            }
        }
        return wordsWithRepeatLetters;
    }

    /*
    Bonus Problem ;)
    implement the method below so that it returns a list of words that are repeated twice accidentally in a string
    for example: "appleapple orange pearpear pineapple" -> ["appleapple", "pearpear"]
    */

    public static List<String> findReapetdWords(String input) {
        List<String> repeatedWords = new ArrayList<>();
        var regex = "\\b\\w+\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()){
            var word = matcher.group();
            if (word.length() % 2 == 1)
                continue;
            if ((word.substring(0,word.length()/2)).equals(word.substring(word.length()/2,word.length())))
                repeatedWords.add(word);
        }
        return repeatedWords;
    }

    public static void main(String[] args) {
        List<String> wordsWithRepeatLetters = findReapetdWords("haha you are so funny");
        for (String i : wordsWithRepeatLetters){
            System.out.println(i);
        }
    }
}