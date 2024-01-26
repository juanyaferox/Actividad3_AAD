package juanya.cifpaviles;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import juanya.cifpaviles.etc.ProgressBar;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        System.out.print("\u001B[32m");
        ProgressBar progressBar = new ProgressBar(200);
        progressBar.simulateProcessing();
        System.out.print("\u001B[0m\n");
    }
}
