package org.mobile.parsers;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * https://stackoverflow.com/questions/46787542/stanford-nlp-api-for-java-how-to-get-the-name-as-full-not-in-parts
 */
@Component
public class NameParser {

    private StanfordCoreNLP pipeline = null;

    public NameParser() {
        Properties properties = new Properties();
        properties.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,entitymentions");
        pipeline = new StanfordCoreNLP(properties);
    }

    public String findName(String line) {
        String name = null;

        if(line != null) {
            Annotation document = new Annotation(line);
            pipeline.annotate(document);

            for (CoreMap sentence : document.get(CoreAnnotations.SentencesAnnotation.class)) {
                for (CoreMap entityMention : sentence.get(CoreAnnotations.MentionsAnnotation.class)) {
                    if (entityMention.get(CoreAnnotations.EntityTypeAnnotation.class).equals("PERSON")) {
                        name = entityMention.toString();
                    }
                }
            }
        }

        return name;
    }

}
