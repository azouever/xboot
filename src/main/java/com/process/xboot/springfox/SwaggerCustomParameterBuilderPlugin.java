package com.process.xboot.springfox;

import static springfox.documentation.swagger.common.SwaggerPluginSupport.pluginDoesApply;

import java.lang.annotation.Annotation;
import java.util.List;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CookieValue;
import springfox.documentation.service.ParameterType;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.ParameterBuilderPlugin;
import springfox.documentation.spi.service.contexts.ParameterContext;
import springfox.documentation.swagger.common.SwaggerPluginSupport;

@Component
@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER + 1000)
public class SwaggerCustomParameterBuilderPlugin implements ParameterBuilderPlugin {

    @Override
    public void apply(ParameterContext context) {
        if (isCookieValue(context)) {
//            context.parameterBuilder().parameterType("cookie");
//            context.parameterBuilder().parameterType(ParameterType.COOKIE);
            context.requestParameterBuilder().in(ParameterType.COOKIE);
        }
    }

    private boolean isCookieValue(ParameterContext context) {
        List<Annotation> annotations = context.resolvedMethodParameter().getAnnotations();
        return annotations.stream()
            .anyMatch(annotation -> annotation.annotationType() == CookieValue.class);
    }

    @Override
    public boolean supports(DocumentationType documentationType) {
        return pluginDoesApply(documentationType);
    }

}
