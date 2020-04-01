import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.util.*;

import java.util.*;

public class EntityMention {


    public static HashMap<String, List<String>> getAnnotations(String file) {
        HashMap<String,List<String>> tokens = new HashMap<>();
        List<String> persons = new ArrayList<>();

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
                }
            }
        }
        tokens.put("PERSON", persons);
        return tokens;
    }





}