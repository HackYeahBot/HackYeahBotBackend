package pl.hackyeah.bot.hackyeahbot.user.control;

import org.springframework.stereotype.Service;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.LMT;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.File;
import java.util.Enumeration;

@Service
public class UserPersonalProfileServiceImpl implements UserPersonalProfileService{

    @Override
    public int getIndexOFMLSolution() {
        int indexToReturn = 0;
        try{
            ArffLoader loader = new ArffLoader();
            loader.setFile(new File("src/main/static/profile_train.arff"));
            Instances trainingSet = loader.getDataSet();
            int classIdx = 5;

            ArffLoader loader2 = new ArffLoader();
            loader2.setFile(new File("src/main/static/profile_train.arff"));
            Instances testSet = loader2.getDataSet();

            trainingSet.setClassIndex(classIdx);
            testSet.setClassIndex(classIdx);

            Classifier classifier = new LMT();
            classifier.buildClassifier(trainingSet);

            Evaluation eval = new Evaluation(trainingSet);
            eval.evaluateModel(classifier, testSet);

            System.out.println(eval.toSummaryString());

            ArffLoader loader3 = new ArffLoader();
            loader3.setFile(new File("src/main/static/profile_unclassified.arff"));
            Instances dataSet = loader3.getDataSet();

            for (Enumeration<Instance> en = dataSet.enumerateInstances(); en.hasMoreElements();) {
                double[] results = classifier.distributionForInstance(en.nextElement());
                double max = 0.0;
                int index = 0;
                for (int i = 0; i < results.length; i++){
                    if(max < results[i]){
                        max = results[i];
                        index = i;
                    }
                }
                System.out.println("MAX: " + max + " index: " + index);
                indexToReturn = index;
            };
        } catch (Exception e) {
            e.printStackTrace();
        }
        return indexToReturn;
    }
}
