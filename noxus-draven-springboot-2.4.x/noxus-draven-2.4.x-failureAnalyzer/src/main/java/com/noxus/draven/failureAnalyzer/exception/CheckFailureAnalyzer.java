package com.noxus.draven.failureAnalyzer.exception;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * @author lengleng
 * @date 2020/11/19
 * <p>
 * 格式化异常信息，方便启动时观察。
 */
public class CheckFailureAnalyzer extends AbstractFailureAnalyzer<CheckException> implements BeanFactoryAware, EnvironmentAware {

    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, CheckException cause) {

        return new FailureAnalysis(cause.getMessage(), "解决方案参考: http://www.baidu.com", cause);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    @Override
    public void setEnvironment(Environment environment) {
    }
}
