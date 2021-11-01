package com.daar.POC_LHOM.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ParseCV {
    public static String extractAge(String content){
        Pattern regEx= Pattern.compile("([0-9]{2}) *ans");
        Matcher matcher = regEx.matcher(content);
        if(matcher.find())
            return matcher.group(1);

        return "";
    }

    public static ArrayList<String> extractWords(String content){
        ArrayList<String> words= new ArrayList<>();

        for(String word : content.split(" |/|-|\\(|\\)|,")){
            try{
                String newWord = word.toLowerCase(Locale.ENGLISH).replace("\n", "");
                if(!newWord.matches("| |:|\\|")) {
                    if(newWord.equals("asp.net".toLowerCase(Locale.ENGLISH))) words.add("aspdotnet");
                    else if(newWord.equals("c#".toLowerCase(Locale.ENGLISH))) words.add("csharp");
                    else if(newWord.equals("c++".toLowerCase(Locale.ENGLISH))) words.add("cpp");
                    else words.add(newWord);
                }
            }catch (IllegalArgumentException e){
                continue;
            }
        }
        return (ArrayList) words.stream().distinct().collect(Collectors.toList());
    }

    public static ArrayList<String> extractSkills(String content, List<String> contentWords) throws FileNotFoundException {
        File file = new File("src/main/java/com/daar/POC_LHOM/resource/Skills");
        HashSet<String> wantedSkillsList = Utils.fileToHashSet(file);
        ArrayList<String> skills= new ArrayList<>();

        for(String word : contentWords){
            try{
                if(wantedSkillsList.contains(word)){
                    skills.add(word);
                }
            }catch (IllegalArgumentException e){
                continue;
            }
        }

        return (ArrayList) skills.stream().distinct().collect(Collectors.toList());
    }
}
