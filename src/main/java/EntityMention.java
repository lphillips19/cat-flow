import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.util.*;

import java.util.*;

public class EntityMention {


    public static HashMap<String, List<String>> getAnnotations(String file) {
        HashMap<String,List<String>> tokens = new HashMap<>(); // stores all tokens
        List<String> persons = new ArrayList<>();
        List<String> cities = new ArrayList<>(); // location removed
        List<String> emails = new ArrayList<>(); // emails to remove as could contain name


        Annotation document = new Annotation(file);
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,entitymentions");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        pipeline.annotate(document);

        for (CoreMap sentence : document.get(CoreAnnotations.SentencesAnnotation.class)) {
            for (CoreMap entityMention : sentence.get(CoreAnnotations.MentionsAnnotation.class)) {
                String annotationType = entityMention.get(CoreAnnotations.EntityTypeAnnotation.class);
                switch (annotationType){
                    case "PERSON":{
                        persons.add(entityMention.toString());
                        break;
                    }
                    case "CITY":{
                        cities.add(entityMention.toString());
                        break;

                    }
                    case "EMAIL":{
                        emails.add(entityMention.toString());
                        break;

                    }
                }
            }
        }
        tokens.put("PERSON", persons);
        tokens.put("CITY", cities);
        tokens.put("EMAIL", emails);
        return tokens;
    }





}