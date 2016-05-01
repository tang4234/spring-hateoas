package de.escalon.hypermedia.affordance;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

import de.escalon.hypermedia.action.Type;

/**
 * Interface to represent an input parameter to a resource handler method, independent of a particular ReST framework.
 * Created by Dietrich on 05.04.2015.
 */
public interface AnnotatedParameter {

	Object getCallValue();

	String getCallValueFormatted();

	Type getHtmlInputFieldType();

	boolean isRequestBody();

	boolean isRequestParam();

	boolean isPathVariable();

	String getRequestHeaderName();

	boolean hasInputConstraints();

	<T extends Annotation> T getAnnotation(Class<T> annotation);

	boolean isHidden(String property);

	boolean isReadOnly(String property);

	boolean isIncluded(String property);

	boolean isExcluded(String property);

	/**
	 * Gets possible values for this parameter.
	 *
	 * @param annotatedParameters in case that access to the other parameters is necessary to determine the possible values.
	 * @return possible values
	 */
	Object[] getPossibleValues(AnnotatedParameters annotatedParameters);

	/**
	 * Gets possible values for a method parameter.
	 *
	 * @param annotatedParameters in case that access to the other parameters is necessary to determine the possible values.
	 * @param method having parameter
	 * @param parameterIndex of parameter
	 * @return possible values
	 */
	Object[] getPossibleValues(Method method, int parameterIndex, AnnotatedParameters annotatedParameters);

	/**
	 * Gets possible values for a constructor parameter.
	 *
	 * @param annotatedParameters in case that access to the other parameters is necessary to determine the possible values.
	 * @param constructor having parameter
	 * @param parameterIndex of parameter
	 * @return possible values
	 */
	Object[] getPossibleValues(Constructor constructor, int parameterIndex, AnnotatedParameters annotatedParameters);

	boolean isArrayOrCollection();

	boolean isRequired();

	String getDefaultValue();

	Object[] getCallValues();

	boolean hasCallValue();

	String getParameterName();

	Class<?> getDeclaringClass();

	Class<?> getParameterType();

	java.lang.reflect.Type getGenericParameterType();

	Map<String, Object> getInputConstraints();
}