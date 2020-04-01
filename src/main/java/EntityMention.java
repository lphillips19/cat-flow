import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.util.*;

import java.io.File;
import java.util.*;

public class EntityMention {


    public static List<CoreMap> getAnnotations(String file) {
        List<CoreMap> annotations = new ArrayList<>();
        Annotation document = new Annotation(file);
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,entitymentions");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        pipeline.annotate(document);

        for (CoreMap sentence : document.get(CoreAnnotations.SentencesAnnotation.class)) {
            for (CoreMap entityMention : sentence.get(CoreAnnotations.MentionsAnnotation.class)) {
                annotations.add(entityMention);
                System.out.println(entityMention);
                System.out.println(entityMention.get(CoreAnnotations.EntityTypeAnnotation.class));
            }
        }
        return annotations;
    }




}